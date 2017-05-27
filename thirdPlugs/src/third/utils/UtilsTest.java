package third.utils;

import java.io.File;

import org.json.JSONObject;


public class UtilsTest {
	public static void main(String[] args) {
		JSONObject data = new JSONObject();
		FileUtils.readfile("C:"+File.separator+"third"+File.separator+"uploads",data,"1");
		System.out.println(data.toString());
	}
}
