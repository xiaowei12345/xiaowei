package intf;

import com.jiuqi.dna.core.invoke.Task;
import com.jiuqi.dna.core.type.GUID;

public class NewsTask extends Task<NewsTask.Method> {
	
	public GUID recid;
	public String title;
	public String content;
	public long time;
	
	public NewsTask() {
		super();
	}
	
	public NewsTask(GUID recid) {
		this.recid = recid;
	}

	public NewsTask(GUID recid, String title, String content, long time) {
		super();
		this.recid = recid;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	public enum Method {
		ADD,MODIFY,DELETE
	}
}
