package third.servlet;

import intf.FNews;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jiuqi.dna.core.http.DNAHttpServlet;
import com.jiuqi.dna.core.spi.application.AppUtil;
import com.jiuqi.dna.core.spi.application.ContextSPI;
import com.jiuqi.dna.core.spi.application.Session;
import com.jiuqi.dna.core.type.GUID;

public class NewsDetailServlet extends DNAHttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Session session = AppUtil.getDefaultApp().newSession(null, null);
		ContextSPI context = session.newContext(false);

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String nId = request.getParameter("id");
		List<FNews> list = context.getList(FNews.class);

		for(FNews f : list){
			if(GUID.tryValueOf(nId).equals(f.getRecid()))
				response.getWriter().write(f.getContent());
		}
	}
}
