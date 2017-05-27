package intf;

import com.jiuqi.dna.core.type.GUID;

public interface FNews {
	public GUID getRecid();
	public String getTitle();
	public long getTime();
	public String getContent();
}
