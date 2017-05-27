package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.ServletUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/UploadProgressServlet")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("开始提取新闻数据");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		
		JSONObject data = new JSONObject();
		JSONArray news = new JSONArray();
        try {
        	data.put("pagenum", 100);
			data.put("limit", 5);
			
			for(int i=0;i<5;i++){
				JSONObject json = new JSONObject();
				json.put("title", "标题"+i);
				json.put("content", "内容"+i);
				json.put("time", "2017-05-13");
				json.put("read", "1003");
				json.put("url", "http://www.baidu.com");
				news.put(json);
			}
			data.put("news", news);
		} catch (JSONException e) {
			e.printStackTrace();
		}
     
		ServletUtil.response(response, data);
	}
	
}
