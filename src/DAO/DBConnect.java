package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	protected Connection conn = null;

	static final String url = "jdbc:mysql://localhost:3306/DBJava";
	static final String nameUser = "root";
	static final String pass = "";


	public boolean openConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, nameUser, pass);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void closeConnectDB() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
//	public static void main(String[] args) {
//		DBConnect cn = new DBConnect();
//		if(cn.openConnectDB()) {
//			System.out.println("yes");
//			cn.closeConnectDB();
//		} else System.out.println("no");
//	}

}