package third.servlet;

import java.util.List;

import intf.FPerson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.jiuqi.dna.core.Context;

public class GridDatsServlet extends GetOrPostServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject handle(Context context, JSONObject parseContent)
			throws JSONException {
		
		JSONObject data = new JSONObject();
		JSONArray jsonList = new JSONArray();
		
		List<FPerson> list = context.getList(FPerson.class);
		for (FPerson f : list) {
			JSONObject json = new JSONObject();
			json.put("recid", f.getRecid());
			json.put("username", f.getUsername());
			json.put("city", f.getCity());
			json.put("phone", f.getPhone());
			json.put("reason", f.getReason());
			json.put("remark", f.getRemark());
			
			jsonList.put(json);
		}
		data.put("total", list.size());
		data.put("rows",jsonList);
		return data;
	}
}
