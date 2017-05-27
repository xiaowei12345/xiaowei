package third.servlet;

import org.json.JSONException;
import org.json.JSONObject;

public enum Retcode {

	SUCCESS(0, "成功"),
	INVALID_PARAMETER(104,"错误的参数"),
	SERVER_ERROR(5001 , "服务器处理错误"),
	UNSUPPORTED_REQUEST_METHOD(5002 , "不支持的请求");

	public final int code;
	public String explanation;

	/**
	 * @param code
	 *            号
	 * @param meesage
	 *            说明
	 */
	private Retcode(int code, String meesage) {
		this.code = code;
		this.explanation = meesage;
	}

	public final JSONObject raise() {
		JSONObject json = new JSONObject();
		try {
			json.put(JK_RETCODE, this.code);
			json.put(JK_EXPLANATION, this.explanation);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	public final JSONObject raise(String explanation) {
		JSONObject json = new JSONObject();
		try {
			json.put(JK_RETCODE, this.code);
			String str = isEmpty(explanation) ? this.explanation : explanation;
			json.put(JK_EXPLANATION, str);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static JSONObject Error(String explanation) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.putOpt(JK_RETCODE, 3000);
		jsonObject.putOpt(JK_EXPLANATION, explanation);
		return jsonObject;
	}

	public static JSONObject Deleted(String explanation) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.putOpt(JK_RETCODE, 3001);
		jsonObject.putOpt(JK_EXPLANATION, explanation);
		return jsonObject;
	}

	public static final String JK_RETCODE = "retcode";
	public static final String JK_EXPLANATION = "explanation";
}