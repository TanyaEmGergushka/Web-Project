package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton
public class DBManager {

	private static DBManager instanse;
	private Connection con;

	private DBManager() throws SQLException {
		// loading the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found or failed to load. Check your libraries.");
		}
		// these parameters can be read from a file or listed here
//	final String DB_IP = "192.168.1.104";
		final String DB_IP = "127.0.0.1";
		final String DB_PORT = "3306";
		final String DB_DBNAME = "sofyabread";
		final String DB_USER = "root";
		final String DB_PASS = "4600";

		try {
			con = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
		//	con = DriverManager.getConnection("jdbc:mysql://localhost:3306" + "/" +  DB_DBNAME, DB_USER, DB_PASS);
		} catch (SQLException e) {
			System.out.println("Sql Ops");
		}
	}

	public static synchronized DBManager getInstanse() throws SQLException {
		if (instanse == null) {
			instanse = new DBManager();
		}
		return instanse;

	}

	// returns the connection created by the db manager's constructor
	public Connection getConnection() {
		return con;
	}

	// this method will be called in "destroy method" in servlet -register
	// servlet,
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can not close connection");
			}
		}
	}
}
