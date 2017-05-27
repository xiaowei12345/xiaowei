package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import utils.ServletUtil;
import utils.UploadStatus;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/UploadProgressServlet")
public class UploadProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadProgressServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("开始提取进度");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		
		JSONObject data = new JSONObject();
		
		UploadStatus status = (UploadStatus)request.getSession().getAttribute("uploadStatus");
		if(status == null){
	        System.out.println("进度获取失败");
	    }
		//已经完成的百分比
        int percent = (int)(100 * (double)status.getBytesRead() / (double)status.getContentLength());
        
        try {
			data.put("progressValue", percent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        System.out.println("------------"+percent+"--------------");
		//---------------------------------
		ServletUtil.response(response, data);
	}
	
}
