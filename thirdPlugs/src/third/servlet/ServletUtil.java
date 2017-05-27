package third.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServletUtil{

	public static final String EMOIJ_REG = "[\ue000-\uf8ff]|[\\x{1f300}-\\x{1f7ff}]";// emoij表情正则表达式，目前过滤正则表达式返回？
	private ServletUtil() {}

	public static final void response(HttpServletResponse resp, JSONObject json)
			throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json");
		resp.getWriter().append(json.toString().replaceAll(EMOIJ_REG, "?"));
	}
	
	public static final void response2(HttpServletResponse resp, JSONArray json)
			throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json");
		resp.getWriter().append(json.toString().replaceAll(EMOIJ_REG, "?"));
	}
	
	/**
	 * 将字符串转为json
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public static final JSONObject parseContent(HttpServletRequest req)
			throws IOException {
		try {
			final String content = readString(req.getInputStream(), Charset.forName("utf-8"));
			if (content == null || content.length() == 0) {
				return new JSONObject();
			}
			return new JSONObject(content);
		} catch (JSONException e) {
			return new JSONObject();
		}
	}
	
	/**
	 * 获取客户端请求json字符串
	 * @param req
	 * @return
	 */
	public static final String readString(HttpServletRequest req){
		String content = "";
		try {
			content = readString(req.getInputStream(), Charset.forName("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
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
}