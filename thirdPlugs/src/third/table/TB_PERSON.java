package third.table;

import com.jiuqi.dna.core.def.table.TableDeclarator;
import com.jiuqi.dna.core.type.TypeFactory;
import com.jiuqi.dna.core.def.table.TableFieldDefine;

public final class TB_PERSON extends TableDeclarator {

	public static final String TABLE_NAME ="PERSON";

	public final TableFieldDefine f_username;
	public final TableFieldDefine f_phone;
	public final TableFieldDefine f_city;
	public final TableFieldDefine f_reason;
	public final TableFieldDefine f_remark;

	public static final String FN_username ="username";
	public static final String FN_phone ="phone";
	public static final String FN_city ="city";
	public static final String FN_reason ="reason";
	public static final String FN_remark ="remark";

	//不可调用该构造方法.当前类只能由框架实例化.
	private TB_PERSON() {
		super(TABLE_NAME);
		this.f_username = this.table.newField(FN_username, TypeFactory.VARCHAR(50));
		this.f_phone = this.table.newField(FN_phone, TypeFactory.VARCHAR(50));
		this.f_city = this.table.newField(FN_city, TypeFactory.VARCHAR(50));
		this.f_reason = this.table.newField(FN_reason, TypeFactory.VARCHAR(50));
		this.f_remark = this.table.newField(FN_remark, TypeFactory.VARCHAR(50));
	}

}
