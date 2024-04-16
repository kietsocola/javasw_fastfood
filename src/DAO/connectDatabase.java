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
				System.out.println("ket not csdl thanh cong");
			}catch(Exception e) {
				System.out.println("ket not csdl that bai");
			}
		}
		
		public void close() {
			try {
				con.close();
				System.out.println("dong co so du lieu thanh cong");
			}catch(Exception e) {
				System.out.println("dong co so du lieu that bai");
			}
		}
		
		public static void main(String[] args) {
			connectDatabase newCon =  new connectDatabase();
			newCon.connect();
			newCon.close();
			
		}
}
