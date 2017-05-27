package intf;

import com.jiuqi.dna.core.invoke.Task;
import com.jiuqi.dna.core.type.GUID;

public class PersonTask extends Task<PersonTask.Method> {
	
	public GUID recid;
	public String username;
	public String phone;
	public String city;
	public String reason;
	public String remark;
	
	public PersonTask() {
		super();
	}
	
	public PersonTask(GUID recid) {
		this.recid = recid;
	}
		
	public PersonTask(GUID recid, String username, String phone, String city,
			String reason, String remark) {
		super();
		this.recid = recid;
		this.username = username;
		this.phone = phone;
		this.city = city;
		this.reason = reason;
		this.remark = remark;
	}

	public enum Method {
		ADD,MODIFY,DELETE
	}
}
