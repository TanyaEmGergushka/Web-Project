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
		
		
		HttpSession sess = request.getSession();
// ако сесията е нова, препрати клиента към страницата с login, ако не го препрати към main page
		
		Object o = sess.getAttribute("logged");
		boolean logged = (o!=null && (boolean) o);
		
		if (sess.isNew() || !logged) {
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("main.jsp");
		}
	}

}
