package third.servlet;

import intf.FNews;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.jiuqi.dna.core.http.DNAHttpServlet;
import com.jiuqi.dna.core.spi.application.AppUtil;
import com.jiuqi.dna.core.spi.application.ContextSPI;
import com.jiuqi.dna.core.spi.application.Session;

public class NewsListServlet extends DNAHttpServlet {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Session session = AppUtil.getDefaultApp().newSession(null, null);
		ContextSPI context = session.newContext(false);
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		
		JSONObject data = new JSONObject();
		JSONArray news = new JSONArray();
        try {
        	data.put("pagenum", 100);
			data.put("limit", 5);
			
			List<FNews> list = context.getList(FNews.class);

			for(FNews f : list){
				JSONObject json = new JSONObject();
				json.put("title", f.getTitle());
				json.put("content", f.getContent());
				json.put("time", sdf.format(new Date(f.getTime())));
				json.put("read", "1003");
				json.put("url", "/m/detail?id="+f.getRecid().toString());
				news.put(json);
			}
			data.put("news", news);
		} catch (JSONException e) {
			e.printStackTrace();
		}
     
		ServletUtil.response(response, data);	 
	}
}
