package third.script;

import com.jiuqi.dna.core.def.arg.ArgumentDefine;
import com.jiuqi.dna.core.def.query.QueryColumnDefine;
import com.jiuqi.dna.core.def.query.ORMDeclarator;

public class GetPersonByNameOrm extends ORMDeclarator<intf.PersonImpl> {

	public final ArgumentDefine arg_name;

	public final QueryColumnDefine c_city;
	public final QueryColumnDefine c_phone;
	public final QueryColumnDefine c_reason;
	public final QueryColumnDefine c_recid;
	public final QueryColumnDefine c_remark;
	public final QueryColumnDefine c_username;

	public GetPersonByNameOrm() {
		this.arg_name = this.orm.getArguments().get(0);
		this.c_city = this.orm.getColumns().get(0);
		this.c_phone = this.orm.getColumns().get(1);
		this.c_reason = this.orm.getColumns().get(2);
		this.c_recid = this.orm.getColumns().get(3);
		this.c_remark = this.orm.getColumns().get(4);
		this.c_username = this.orm.getColumns().get(5);
	}
}
