package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private Connection conn;

	public ConnectDatabase() {
		try {
			String url = "jdbc:mysql://localhost:3306/java";
			String username = "root";
			String password = "";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the database!");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database!");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed.");
			} catch (SQLException e) {
				System.out.println("Failed to close connection!");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		ConnectDatabase dbConnection = new ConnectDatabase();

		dbConnection.closeConnection();
	}
}
