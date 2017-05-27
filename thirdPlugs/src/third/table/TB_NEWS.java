package third.table;

import com.jiuqi.dna.core.def.table.TableDeclarator;
import com.jiuqi.dna.core.type.TypeFactory;
import com.jiuqi.dna.core.def.table.TableFieldDefine;

public final class TB_NEWS extends TableDeclarator {

	public static final String TABLE_NAME ="NEWS";

	public final TableFieldDefine f_title;
	public final TableFieldDefine f_content;
	public final TableFieldDefine f_createTime;

	public static final String FN_title ="title";
	public static final String FN_content ="content";
	public static final String FN_createTime ="createTime";

	//不可调用该构造方法.当前类只能由框架实例化.
	private TB_NEWS() {
		super(TABLE_NAME);
		this.f_title = this.table.newField(FN_title, TypeFactory.VARCHAR(200));
		this.f_content = this.table.newField(FN_content, TypeFactory.NTEXT);
		this.f_createTime = this.table.newField(FN_createTime, TypeFactory.LONG);
	}

}
