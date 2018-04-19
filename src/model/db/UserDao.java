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

	// тук се throws защото ще се try-catch в контролера, т.като контролера знае
	// какво да направи - гърми нещо в модела и контролера показва error page
	// registration - we enter a user
	public void insertUser(User u) throws SQLException {
		Connection con = DBManager.getInstanse().getConnection();

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO users (username,password, email, company) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, u.getUsername());
		ps.setString(2,u.getPassword());
		//ps.setString(2, Encrypter.Encrypt(u.getPassword())); // hashed
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getCompany());
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
		PreparedStatement ps = con.prepareStatement("SELECT id,username, password, email, company FROM users WHERE username = ?");
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		rs.next();
	//	HashSet<Order> orders = new HashSet<>();
	//	orders = OrderDAO.getInstanse().getOrdersForUser(rs.getLong("id"));
		//TODO select orders
		User user = new User(rs.getLong("id"), username, rs.getString("password"), rs.getString("email"), rs.getString("company")/*, orders*/);
		return user;
		
		
	}
}
