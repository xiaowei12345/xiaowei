package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {

	private static int person = 0;
	private static final long serialVersionUID = 1L;

	public SignServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object attribute = getServletContext().getAttribute("person");
		if(null==attribute){
			getServletContext().setAttribute("person", person+1);
		}else{
			getServletContext().setAttribute("person", (int)attribute+1);
		}
		response.sendRedirect(request.getContextPath()+"/project/layout/complex.jsp"); 
	}

}
