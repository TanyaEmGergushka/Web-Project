package model.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import java.sql.Connection;

// example !!! 
//singleton
//Initialize the database connection - only 1 connection
public class DBManagerExample {

	private static DBManagerExample instanse;
	private Connection con;
	private PreparedStatement stmt;

	// these parameters can be read from a file or listed here
	private static final String DB_IP = "192.168.1.104";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "SofyaBread";
	private static final String DB_USER = "admin";
	private static final String DB_PASS = "007";

	private DBManagerExample() {
		try {
			// loading the driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found or failed to load. Check your librar;ies.");
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql:/ /"+ DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER,
					DB_PASS);
			stmt = con.prepareStatement(" SOMETHING  ");
		} catch (SQLException e) {
			System.out.println("Connection failed to open. Reason: " + e.getMessage());
		}
		
		// finally block or try-with-resources statement
		finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("The connecton can not be closed.");
			}
		}
	}

	public synchronized static DBManagerExample getInstanse() {

		if (instanse == null) {
			instanse = new DBManagerExample();
		}
		return instanse;
	}

}
