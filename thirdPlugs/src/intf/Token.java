
package intf;

import java.util.List;
import com.jiuqi.dna.core.type.GUID;

public interface Token {

	public String getCreateTime();	
	public List<GUID> getSignPerson();
}
