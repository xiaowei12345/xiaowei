
package intf;

import com.jiuqi.dna.core.type.GUID;

public final class TokenRequestKey {

	private final String time;
	private GUID userId;
	
	public TokenRequestKey(String time,GUID userId) {
		super();
		this.time = time;
		this.userId = userId;
	}

	/**
	 * @return the user
	 */
	public final String getTime() {
		return time;
	}
	
	public final GUID getUser() {
		return userId;
	}
}
