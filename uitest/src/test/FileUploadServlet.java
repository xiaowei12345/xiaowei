package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.UploadListener;
import utils.UploadStatus;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     UploadStatus status = new UploadStatus(); // 上传状态
	     UploadListener listner = new UploadListener(status); // 监听器
	     request.getSession().setAttribute("uploadStatus", status); // 把状态放到session里去
		
		//----------------------------------------------------------------
		//创建工厂
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		//使用工厂创建解析器对象
		ServletFileUpload fileupload = new ServletFileUpload(dfif);
		
		fileupload.setProgressListener(listner);
		//-----------------------------------------------------------------
		fileupload.setHeaderEncoding("utf-8");
		
		String fileName = "";
		try{
			List<FileItem> list = fileupload.parseRequest(request);
			//便利所有表单项
			for (FileItem fileItem : list) {
				//如果当前表单项目为普通表单项
				if(fileItem.isFormField()){
					//获取当前表单香项的字段名称
					String fieldName = fileItem.getFieldName();
					if(fieldName.equals("filename")){
						fileName = fileItem.getString("utf-8");
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().print(fileItem.getString());
					}
				}else{   //文件字段
					String name = fileItem.getName();
					//如果上传文件名称为空，则没有上传文件
					if(name == null || name.isEmpty()){
						continue;
					}
					System.out.println("--------------------------------------------"+fileName+"||"+name);
					//获取真实路径，对应$(项目目录)/uploads，当然，这个目录必须存在
					String realPath = this.getServletContext().getRealPath("/uploads");
					//通过uploads目录和文件名来创建file对象
					File file = new File(realPath, name) ;
					//把上传文件保存到指定位置
					fileItem.write(file);
					
					//打印上传文件的名称
//					response.getWriter().print("上传文件名："+name+"<br/>");
					//打印上传文件的名称
//					response.getWriter().print("上传文件大小："+fileItem.getSize()+"<br/>");
					//打印上传文件的名称
//					response.getWriter().print("上传文件类型："+fileItem.getContentType()+"<br/>");
//					response.sendRedirect(request.getContextPath()+"/project/layout/complex.jsp");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
