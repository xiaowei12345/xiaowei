package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object attribute = getServletContext().getAttribute("person");
		if(null==attribute){
			getServletContext().setAttribute("person", 0);
		}else{
			getServletContext().setAttribute("person", (int)attribute);
		}
//		response.sendRedirect(request.getContextPath()+"/demo/window/windowlayout.html");
		response.sendRedirect(request.getContextPath()+"/project/layout/newslist.html");
//		response.sendRedirect(request.getContextPath()+"/project/layout/Editor/html/demo.html");
	}
}
