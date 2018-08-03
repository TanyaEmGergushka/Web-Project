package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getSession().getAttribute("user") == null){
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
//		HttpSession sess = request.getSession();
//		Object o = sess.getAttribute("logged");
//		boolean logged = (o!=null && (boolean) o);
//		
//		if (sess.isNew() || !logged) {
//			response.sendRedirect("home.jsp");
//		} else {
//			response.sendRedirect("main.jsp");
//		}
		
		
	}

}
