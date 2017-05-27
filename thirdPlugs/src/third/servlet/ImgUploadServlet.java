package third.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import third.utils.FileCategory;
import third.utils.FileUtils;
import com.jiuqi.dna.core.http.DNAHttpServlet;
import com.jiuqi.dna.core.spi.application.AppUtil;
import com.jiuqi.dna.core.spi.application.ContextSPI;
import com.jiuqi.dna.core.spi.application.Session;
import com.jiuqi.dna.core.type.GUID;
import com.jiuqi.xlib.utils.IOUtils;

/**
 * web端文件上传协议
 */
public class ImgUploadServlet extends DNAHttpServlet{

	private static final long serialVersionUID = 2317989392896145983L;
	
	private String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	 public ImgUploadServlet() {
	        super();
	    }
		/**
		 * 将输入流转为字符串
		 * @param input
		 * @param charset
		 * @return
		 * @throws IOException
		 */
		public static final String readString(InputStream input, Charset charset)
				throws IOException {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int read = 0;
			while ((read = input.read(buffer)) > 0) {
				out.write(buffer, 0, read);
			}
			return new String(out.toByteArray(), charset == null
					? Charset.defaultCharset().name() : charset.name());
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        final Session session = AppUtil.getDefaultApp().newSession(null, null);
        response.setCharacterEncoding("utf-8");
		try {
			FileCategory catagory = null;
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload uploader = new ServletFileUpload(factory);
			
            final ContextSPI context = session.newContext(false);
			try {
				String fileName = null;
				List<FileItem> itemList = null;
				InputStream input = null;
				try {
					itemList = uploader.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				for (FileItem fi : itemList) {
					if(fi.getName() == null){//获取type 参数来获取category值
						String readString = readString(fi.getInputStream(), Charset.forName("utf-8"));
						try {
							catagory = FileCategory.ToFileCategory(Integer.valueOf(readString));
						} catch (Exception e) {
						}
					}else{// 文件信息
						fileName = fi.getName();
				        boolean allowed = Arrays.asList(allowedType).contains(fi.getContentType());
				        if (!allowed) {
				            response.getWriter().write("error|图片类型只支持jpg、jpeg、png、gif、bmp");
				            return;
				        }
						input = fi.getInputStream();
					}
					
	            }
				if(catagory == null){
					response.getWriter().write("error|不支持的文件类型");
		            return;
				}
				//获取文件扩展名
				String[] split = fileName.split("\\.");
				//生成文件id
				GUID fId = GUID.randomID();
				FileUtils.exportFileToPath(JsonFieldConstant.ROOT_PATH, fId.toString()+"."+split[split.length-1], IOUtils.getContentsData(input));
	  			response.getWriter().write("/m/imgshow?img="+fId.toString()+"."+split[split.length-1]);
			} finally {
				context.dispose();
			}
		} finally {
			session.dispose(60000);
		}
	}

}
