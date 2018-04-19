package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import model.Order;

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

	public HashSet<Order> getOrdersForUser(long user_id) throws SQLException {

		Connection con = DBManager.getInstanse().getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT id,date FROM orders WHERE user_id = ? ");
		ps.setLong(1, user_id);
		ResultSet rs = ps.executeQuery();
		HashSet<Order> orders = new HashSet<>();
		while (rs.next()) {
			orders.add(new Order(user_id, null, null, null, null)); // -----------------

		}
		return orders;

	}

}
