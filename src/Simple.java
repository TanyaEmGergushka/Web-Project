import java.sql.SQLException;
import java.util.HashSet;


import model.Product;

import model.db.ProductDao;
import model.db.UserDao;

public class Simple {
	
	

	public static void main(String[] args) throws SQLException {
//	Product p = new Product("кифла8", "marmalad8", 7 , "10");
//	ProductDao.getInstance().insertProduct(p);
//	
//
//		HashSet<Product> pr = ProductDao.getInstance().getAllProducts();
//		for (Product p1 : pr){
//		System.out.println(p1);
//		}
		
	System.out.println(UserDao.getInstanse().existsUser("tanya", "ta"));
//	git commit -m "First commit - Servlets, DAO, MVC, HTML, JSP, JSTL"

	}

}
