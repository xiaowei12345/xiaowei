package intf;

import com.jiuqi.dna.core.type.GUID;

public class NewsImpl implements FNews {

	private GUID recid;
	private String title;
	private long time;
	private String content;

	@Override
	public GUID getRecid() {
		return recid;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public long getTime() {
		return time;
	}

	@Override
	public String getContent() {
		return content;
	}

	public void setRecid(GUID recid) {
		this.recid = recid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
