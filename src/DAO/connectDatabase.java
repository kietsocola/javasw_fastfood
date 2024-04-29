package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connectDatabase {
		private Connection con ;
		private String url = "jdbc:mysql://localhost:3306/";
		private String nameDatabase = "javafastfood";
		private String user ="root";
		private String password ="";
		private Statement s;
		
		
		public Connection getCon() {
			return this.con;
		}
		
		public void connect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.con = DriverManager.getConnection(url+ nameDatabase  ,user ,password);
				s = con.createStatement();
			}catch(Exception e) {
			}
		}
		
		public void close() {
			try {
				con.close();
			}catch(Exception e) {
			}
		}
		
		public static void main(String[] args) {
			connectDatabase newCon =  new connectDatabase();
			newCon.connect();
			newCon.close();
			
		}
}
