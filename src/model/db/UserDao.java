package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.mysql.jdbc.Statement;

import model.Order;
import model.User;
import util.Encrypter;

// singleton
public class UserDao {

	private static UserDao instanse;

	private UserDao() {
	}

	public static synchronized UserDao getInstanse() {
		if (instanse == null) {
			instanse = new UserDao();
		}
		return instanse;
	}

	// ��� �� throws ������ �� �� try-catch � ����������, �.���� ���������� ����
	// ����� �� ������� - ����� ���� � ������ � ���������� ������� error page
	// registration - we enter a user
	public void insertUser(User u) throws SQLException {
		Connection con = DBManager.getInstanse().getConnection();

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO users (username,password, email, company, avatarUrl) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, u.getUsername());
		ps.setString(2,u.getPassword());
		//ps.setString(2, Encrypter.Encrypt(u.getPassword())); // hashed
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getCompany());
		ps.setString(5, u.getAvatarUrl());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		u.setId(rs.getLong(1));
	}
	
	// whether the user exists by username and password
	public boolean existsUser(String username, String password) throws SQLException {
		Connection con = DBManager.getInstanse().getConnection();
		
		PreparedStatement ps = con
				.prepareStatement("SELECT  count(*) as count  FROM users WHERE username = ?  AND password = ?");
		ps.setString(1, username);
		ps.setString(2, password);
	//	ps.setString(2, Encrypter.Encrypt(password)); // hashed
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt("count") > 0;
	}
	//  successful login - returns a user with its parameters
	public User getUser (String username) throws SQLException{
		Connection con = DBManager.getInstanse().getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT id,username, password, email, company, avatarUrl FROM users WHERE username = ?");
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User(rs.getLong("id"), username,
				rs.getString("password"), rs.getString("email"), 
				rs.getString("company"), rs.getString("avatarUrl") );
		HashSet<Order> orders = new HashSet<>();
		orders = OrderDAO.getInstanse().getOrdersForUser(user);
		user.setOrders(orders);
		
		return user;
		
		
	}
}
