package third.servlet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import third.utils.FileUtils;

import com.jiuqi.dna.core.http.DNAHttpServlet;

public class ImgShowServlet extends DNAHttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String path = req.getParameter("img");
		byte[] byteArray = FileUtils.toByteArray(JsonFieldConstant.ROOT_PATH+File.separator+path);
		IOUtils.copy(new ByteArrayInputStream(byteArray), resp.getOutputStream());
	}
}