package intf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.jiuqi.dna.core.def.obja.StructClass;
import com.jiuqi.dna.core.type.GUID;

@StructClass
public final class TokenImpl implements Token {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private String createTime;
	private List<GUID> signPerson;

	@Override
	public String getCreateTime() {
		return createTime;
	}

	@Override
	public List<GUID> getSignPerson() {
		return signPerson;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setSignPerson(List<GUID> signPerson) {
		this.signPerson = signPerson;
	}

	public TokenImpl(List<GUID> signPerson) {
		super();
		this.signPerson = signPerson;
		this.createTime = sdf.format(new Date());
	}
}
