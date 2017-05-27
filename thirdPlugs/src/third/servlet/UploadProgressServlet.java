package third.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import third.utils.UploadStatus;

import com.jiuqi.dna.core.http.DNAHttpServlet;

public class UploadProgressServlet extends DNAHttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		//---------------------------------
		ServletUtil.response(response, data);	 
	}
}
