package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import model.User;
import model.db.UserDao;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	public void init() throws ServletException {
//		// TODO open connections
//		super.init();
//	}
//
//	@Override
//	public void destroy() {
//		// TODO close connections
//		super.destroy();
//	}

	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
// response.getWriter().append("welcome lo");
		 doPost(request, response);
	 }
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check for login credentials
		String name = request.getParameter("user");
		String pass = request.getParameter("password");
	//	String mail = request.getParameter("email");
		
		// check if user exists in db
		try {
			boolean exists = UserDao.getInstanse().existsUser(name, pass);
			if (exists){
				// update session
				User u = UserDao.getInstanse().getUser(name);
				request.getSession().setAttribute("user", u);
				// forward to main page
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				
			} else {
				request.setAttribute("error", "user does not exist");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("error", "DB problem:" + e.getMessage() );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
		
//		
//	response.setContentType("text/html; charset=UTF-8"); // informing the client that which format of data/response will be send
//	PrintWriter out = response.getWriter();

	// insert username in a session scope
		request.getSession().setAttribute("name", name);
//
//		if (name != null || !name.isEmpty() || pass != null || !pass.isEmpty() || mail != null || !mail.isEmpty()) {
//			// login
//			request.getSession().setAttribute("logged", true); // при успешен лог-ин
//															// това се записва в
//															// сесията и го има,
//															// докато тя е жива
//		}
//response.sendRedirect("welcome.jsp");
//		

	}
}
