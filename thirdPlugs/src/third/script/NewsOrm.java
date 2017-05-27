package third.script;

import com.jiuqi.dna.core.def.query.QueryColumnDefine;
import com.jiuqi.dna.core.def.query.ORMDeclarator;

public class NewsOrm extends ORMDeclarator<intf.NewsImpl> {

	public final QueryColumnDefine c_content;
	public final QueryColumnDefine c_recid;
	public final QueryColumnDefine c_title;
	public final QueryColumnDefine c_time;

	public NewsOrm() {
		this.c_content = this.orm.getColumns().get(0);
		this.c_recid = this.orm.getColumns().get(1);
		this.c_title = this.orm.getColumns().get(2);
		this.c_time = this.orm.getColumns().get(3);
	}
}
