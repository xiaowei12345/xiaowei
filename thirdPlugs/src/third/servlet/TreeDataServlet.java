package third.servlet;

import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import third.utils.FileUtils;
import com.jiuqi.dna.core.Context;

public class TreeDataServlet extends GetOrPostServlet2 {

	private static final long serialVersionUID = 1L;

	@Override
	protected JSONArray handle(Context context, JSONObject parseContent)
			throws JSONException {
		
		JSONObject data = new JSONObject();
		JSONArray jsonList = new JSONArray();
		
		FileUtils.readfile("C:"+File.separator+"third"+File.separator+"uploads",data,"1");
		jsonList.put(data);
		
		return jsonList;
	}
}
