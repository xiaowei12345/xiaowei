package third.service;

import intf.FNews;
import intf.NewsImpl;
import intf.NewsTask;
import java.util.List;
import third.script.NewsOrm;
import com.jiuqi.dna.core.Context;
import com.jiuqi.dna.core.da.ORMAccessor;
import com.jiuqi.dna.core.service.Publish;
import com.jiuqi.dna.core.service.Service;

public class NewsService extends Service {

	private NewsOrm newsOrm;

	protected NewsService(NewsOrm newsOrm) {
		super("新闻服务");
		this.newsOrm = newsOrm;
	}

	@Publish
	protected class AllPersonProvider extends ResultListProvider<FNews> {

		@Override
		protected void provide(Context arg0, List<FNews> arg1)
				throws Throwable {
			ORMAccessor<NewsImpl> acc = arg0.newORMAccessor(newsOrm);
			arg1.addAll(acc.fetch());
		}
	}

	@Publish
	protected class AddNewsHandler extends TaskMethodHandler<NewsTask, NewsTask.Method>{

		protected AddNewsHandler() {
			super(NewsTask.Method.ADD);
		}

		@Override
		protected void handle(Context arg0, NewsTask arg1) throws Throwable {
			NewsImpl impl = new NewsImpl();
			impl.setRecid(arg1.recid);
			impl.setTime(arg1.time);
			impl.setTitle(arg1.title);
			impl.setContent(arg1.content);

			ORMAccessor<NewsImpl> newORMAccessor=arg0.newORMAccessor(newsOrm);
			newORMAccessor.insert(impl);
			newORMAccessor.unuse();
		}
	}
}
