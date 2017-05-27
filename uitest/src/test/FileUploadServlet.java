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
		
	     UploadStatus status = new UploadStatus(); // �ϴ�״̬
	     UploadListener listner = new UploadListener(status); // ������
	     request.getSession().setAttribute("uploadStatus", status); // ��״̬�ŵ�session��ȥ
		
		//----------------------------------------------------------------
		//��������
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		//ʹ�ù�����������������
		ServletFileUpload fileupload = new ServletFileUpload(dfif);
		
		fileupload.setProgressListener(listner);
		//-----------------------------------------------------------------
		fileupload.setHeaderEncoding("utf-8");
		
		String fileName = "";
		try{
			List<FileItem> list = fileupload.parseRequest(request);
			//�������б���
			for (FileItem fileItem : list) {
				//�����ǰ����ĿΪ��ͨ����
				if(fileItem.isFormField()){
					//��ȡ��ǰ��������ֶ�����
					String fieldName = fileItem.getFieldName();
					if(fieldName.equals("filename")){
						fileName = fileItem.getString("utf-8");
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().print(fileItem.getString());
					}
				}else{   //�ļ��ֶ�
					String name = fileItem.getName();
					//����ϴ��ļ�����Ϊ�գ���û���ϴ��ļ�
					if(name == null || name.isEmpty()){
						continue;
					}
					System.out.println("--------------------------------------------"+fileName+"||"+name);
					//��ȡ��ʵ·������Ӧ$(��ĿĿ¼)/uploads����Ȼ�����Ŀ¼�������
					String realPath = this.getServletContext().getRealPath("/uploads");
					//ͨ��uploadsĿ¼���ļ���������file����
					File file = new File(realPath, name) ;
					//���ϴ��ļ����浽ָ��λ��
					fileItem.write(file);
					
					//��ӡ�ϴ��ļ�������
//					response.getWriter().print("�ϴ��ļ�����"+name+"<br/>");
					//��ӡ�ϴ��ļ�������
//					response.getWriter().print("�ϴ��ļ���С��"+fileItem.getSize()+"<br/>");
					//��ӡ�ϴ��ļ�������
//					response.getWriter().print("�ϴ��ļ����ͣ�"+fileItem.getContentType()+"<br/>");
//					response.sendRedirect(request.getContextPath()+"/project/layout/complex.jsp");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
