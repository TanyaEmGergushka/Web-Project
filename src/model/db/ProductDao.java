package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.sql.Statement;

import model.Basket;
import model.Product;

public class ProductDao {

	private static ProductDao instanse;
	private static final HashSet<Product> products = new HashSet<>(); // cashing
																		// products

	private ProductDao() {
	}

	public static synchronized ProductDao getInstance() {
		if (instanse == null) {
			instanse = new ProductDao();
		}
		return instanse;
	}

	public HashSet<Product> getAllProducts() throws SQLException {
		if (!products.isEmpty()) {
			return products;
		} else {
			Connection con = DBManager.getInstanse().getConnection();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement("SELECT id, name, description, price, quantity FROM products");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getString("description"),
						rs.getDouble("price"), rs.getString("quantity")));
			}
			return products;
		}
	}

	
	public static HashSet<Product> getProducts() {
		return products;
	}

	public void insertProduct(Product p) throws SQLException {
		Connection con = DBManager.getInstanse().getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, p.getName());
		ps.setString(2, p.getDescription());
		ps.setDouble(3, p.getPrice());
		ps.setString(4, p.getQuantity());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		p.setId(rs.getLong(1));

		if (!products.isEmpty()) {
			products.add(p);
		}

	}

	public HashSet<String> getProductsForOrder(long orderId) throws SQLException {
		Connection con = DBManager.getInstanse().getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM sofyabread.`orders_have_ product` as o "
				+ "JOIN products as p "
				+ "ON o.product_id = p.id "
				+ "WHERE o.order_id = ?;" /*ORDER by quantity*/);
		
		ps.setLong(1,orderId);
		ResultSet rs = ps.executeQuery();
		
		LinkedHashSet<String> products = new LinkedHashSet<>(); /* or LinkedHashMap<String,Integer> - When we want to know the quantity*/
		while (rs.next()) {
			products.add(rs.getString("name"));
		}
		
		return products;
	}

}
