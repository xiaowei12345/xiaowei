package thirdPlugs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import intf.FPerson;
import intf.NewsTask;
import intf.PersonTask;
import intf.Token;
import intf.TokenRequestKey;
import org.json.JSONObject;

import third.utils.Escape;

import com.jiuqi.dna.core.type.GUID;
import com.jiuqi.dna.ui.wt.events.BrowserActionEvent;
import com.jiuqi.dna.ui.wt.events.BrowserActionListener;
import com.jiuqi.dna.ui.wt.graphics.TextFileDescriptor;
import com.jiuqi.dna.ui.wt.layouts.GridData;
import com.jiuqi.dna.ui.wt.layouts.GridLayout;
import com.jiuqi.dna.ui.wt.widgets.Browser;
import com.jiuqi.dna.ui.wt.widgets.Composite;
import com.jiuqi.dna.ui.wt.widgets.MessageDialog;
import com.jiuqi.dna.ui.wt.widgets.Page;

public class UiTestPage extends Page {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public UiTestPage(Composite parent) {
		super(parent);
		this.setLayout(new GridLayout());
		this.setLayoutData(GridData.INS_FILL_BOTH);

		final TextFileDescriptor txtFile = TextFileDescriptor.getDescriptor("thirdPlugs", "project/layout/complex.html");
		final TextFileDescriptor txtFile2 = TextFileDescriptor.getDescriptor("thirdPlugs", "project/layout/register.html");
		final TextFileDescriptor txtFile3 = TextFileDescriptor.getDescriptor("thirdPlugs", "project/layout/editor.html");
		final TextFileDescriptor txtFile4 = TextFileDescriptor.getDescriptor("thirdPlugs", "project/layout/newslist.html");
//		final TextFileDescriptor txtFile3 = TextFileDescriptor.getDescriptor("thirdPlugs", "demo/resizable/basic.html");

		final Browser bro = new Browser(this);
		bro.setLayoutData(GridData.INS_FILL_BOTH);
		bro.applyHTML(txtFile.getContent("utf-8"));
		bro.setHandlerName("handleAction");
		bro.addActionListener(new BrowserActionListener() {

			@Override
			public void actionPerformed(BrowserActionEvent arg0) {				
				JSONObject data = new JSONObject(arg0.actionValue);
				
				if("register".equals(data.get("type"))){
					bro.clear();
					bro.applyHTML(txtFile2.getContent("utf-8"));
				}else if("index".equals(data.get("type"))){
					bro.applyHTML(txtFile.getContent("utf-8"));
				}else if("editor".equals(data.get("type"))){
					bro.applyHTML(txtFile3.getContent("utf-8"));
				}else if("news".equals(data.get("type"))){
					System.out.println(data.getString("title"));
					System.out.println(Escape.unescape(data.getString("title")));
					//正文html反编码
					String content = Escape.unescape(data.getString("content"));
					getContext().handle(new NewsTask(GUID.randomID(), Escape.unescape(data.getString("title")),
							content, System.currentTimeMillis()), NewsTask.Method.ADD);
					bro.applyHTML(txtFile4.getContent("utf-8"));
					MessageDialog.alert("发布成功！");
				}else if("newslist".equals(data.get("type"))){
					bro.applyHTML(txtFile4.getContent("utf-8"));
				}else if("sign".equals(data.get("type"))){
					if(data.length()<=1){
						Token find = getContext().find(Token.class,sdf.format(new Date()));
						int amount = find == null? 0:find.getSignPerson().size();

						bro.invoke("qiandao", new JSONObject("{'msg':"+amount+"}"));
					}else{
						List<FPerson> list = getContext().getList(FPerson.class,data.getString("username"));
						if(list==null||list.size()==0){
							MessageDialog.alert("还不是会员偶");
							return;
						}
						FPerson person = list.get(0);
						if(checkUsername(person.getRecid())){
							Token find = getContext().find(Token.class,new TokenRequestKey(sdf.format(new Date()), person.getRecid()));
							bro.invoke("qiandao", new JSONObject("{'msg':"+find.getSignPerson().size()+"}"));
						}else{
							MessageDialog.alert("用户今日已经签过到啦");
						}
					}
				}else{ 
					List<FPerson> list = getContext().getList(FPerson.class,(String)data.get("name"));
					if(list!=null&&list.size()>0){
						bro.invoke("checkInfo", new JSONObject("{'msg':1}"));
					}else{
						PersonTask pk = new PersonTask(GUID.randomID(), data.getString("name"), 
								data.getString("phone"),  data.getString("city"), data.getString("reason"),
								data.getString("remark"));
						getContext().handle(pk, PersonTask.Method.ADD);
						bro.applyHTML(txtFile2.getContent("utf-8"));
						MessageDialog.alert("注册成功");
					}
				}
			}
		});	
	}
	/*
	 * true:ok | false:repeat
	 */
	private boolean checkUsername(GUID userId){
		Token find = getContext().find(Token.class,sdf.format(new Date()));
		if(find==null) return true;
		List<GUID> signPerson = find.getSignPerson();
		for (GUID guid : signPerson) {
			if(guid.equals(userId))
				return false;
		}
		return true;
	}
}
