package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.db.DBManager;
import model.db.UserDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check for register credentials
		// check if user exists
		// insert user in db
		// update session
		// redirect to main html
		
		
		HttpSession sess = request.getSession();
		
		// TODO register this user
		
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String company = request.getParameter("company");
	// validations
	// if (UserDao.existsUser(username)
	User user = new User(username, company, password, email);

	try {
		UserDao.getInstanse().insertUser(user);
		response.getWriter().append("well done, you registerred with id= " + user.getId());

	} catch (SQLException e) {
		response.getWriter().append("Ops, we have a problem with database: " + e.getMessage());
	}
	
	
	}

	
	@Override
	public void destroy() {
		try {
			DBManager.getInstanse().closeConnection();
		} catch (SQLException e) {
			System.out.println("ops close con");
		}
		super.destroy();
	}
}
