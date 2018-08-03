package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.db.ProductDao;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// retrieve all products on sale
		try {
			// insert products in a session scope
			// request.getSession().setAttribute("products",products);
			
			// insert products in a application scope
			ServletContext application = getServletConfig().getServletContext();
			synchronized (application) {
				if (application.getAttribute("products") == null){
					HashSet<Product> products = ProductDao.getInstance().getAllProducts();  //TreeSet - orderBy
					application.setAttribute("products",products);	
					
				}
			}
		
			// forward to a view
			HttpSession sess = request.getSession();
			// ако сесията е нова, препрати клиента към страницата с login, ако не
			// го препрати към main page

			Object o = sess.getAttribute("logged");
			boolean logged = (o != null && (boolean) o);

			if (sess.isNew() || !logged) {
				response.sendRedirect("index.html");
			} else {
				response.sendRedirect("main.jsp");
			}
		//	request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println("SQL Ops / products");
		}
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// chose a product from list of all products for sale and add it in cart
		// update session - add this product in basket
	}

}
