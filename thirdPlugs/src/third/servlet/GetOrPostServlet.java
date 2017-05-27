package third.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import com.jiuqi.dna.core.Context;
import com.jiuqi.dna.core.http.DNAHttpServlet;
import com.jiuqi.dna.core.spi.application.AppUtil;
import com.jiuqi.dna.core.spi.application.ContextSPI;
import com.jiuqi.dna.core.spi.application.Session;

/**
 * 
 * @Author xiaowei
 * @Function Servlet 无Token的继承类
 * @Time 2016/07/20
 * @Desc 
 *
 */
public abstract class GetOrPostServlet extends DNAHttpServlet implements JsonFieldConstant{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding(CHARSET_UTF8);
		resp.setCharacterEncoding(CHARSET_UTF8);
		resp.setContentType(CONTENT_TYPE_JSON);
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding(CHARSET_UTF8);
		resp.setCharacterEncoding(CHARSET_UTF8);
		resp.setContentType(CONTENT_TYPE_JSON);
		ServletUtil.response(resp, this.handle(req, resp));
	}
	
	/**
	 * 验证信息并调用子类实现的方法
	 * @param req
	 * @param resp
	 * @return
	 */
	private final JSONObject handle(HttpServletRequest req,HttpServletResponse resp) {
		try {
			final Session session = AppUtil.getDefaultApp().newSession(null, null);
			
			try {
				final ContextSPI context = session.newContext(false);
				try {
					JSONObject parseContent = ServletUtil.parseContent(req);
					return this.handle(context , parseContent);
				} finally {
					context.dispose();
				}
			} finally {
				session.dispose(60000);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return Retcode.SERVER_ERROR.raise();
		}
	}
	
	/**
	 * 子类实现
	 * @param context
	 * @param req
	 * @return
	 * @throws JSONException
	 */
	protected abstract JSONObject handle(Context context, JSONObject parseContent) throws JSONException;
}