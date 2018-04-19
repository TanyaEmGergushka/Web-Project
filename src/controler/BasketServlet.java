package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// retrieve all products that have been chosen for purchase
	}

	// create order
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check if logged
		// create an order with all chosen product in session
		// save to db
	}

}
