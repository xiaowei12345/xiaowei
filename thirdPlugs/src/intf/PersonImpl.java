package intf;

import com.jiuqi.dna.core.type.GUID;

public class PersonImpl implements FPerson {

	private GUID recid;
	private String username;
	private String phone;
	private String city;
	private String reason;
	private String remark;
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public GUID getRecid() {
		return recid;
	}
	
	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRecid(GUID recid) {
		this.recid = recid;
	}

	public PersonImpl(String username, String phone, String city,
			String reason, String remark, GUID recid) {
		super();
		this.username = username;
		this.phone = phone;
		this.city = city;
		this.reason = reason;
		this.remark = remark;
		this.recid = recid;
	}

	public PersonImpl() {

	}	
}
