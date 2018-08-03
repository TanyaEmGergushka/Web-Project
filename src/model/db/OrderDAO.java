package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import model.Basket;
import model.Order;
import model.Product;
import model.User;

public class OrderDAO {

	private static OrderDAO instanse;

	private OrderDAO() {
	}

	public static synchronized OrderDAO getInstanse() {
		if (instanse == null) {
			instanse = new OrderDAO();
		}
		return instanse;
	}

	public HashSet<Order> getOrdersForUser(User u) throws SQLException {

		Connection con = DBManager.getInstanse().getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT id, datetime FROM orders WHERE user_id = ?" /*ORDER BY datetime*/);
		ps.setLong(1, u.getId());
		ResultSet rs = ps.executeQuery();
		LinkedHashSet<Order> orders = new LinkedHashSet<>();
		while (rs.next()) {
			HashSet<String> products = ProductDao.getInstance().getProductsForOrder(rs.getLong("id"));
			orders.add(new Order(rs.getTimestamp("datetime").toLocalDateTime(), u, products)); 
		}
		return orders;

	}

}
