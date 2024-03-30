package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyConnect{
	private Connnection con;
	private String url ="jdbc:mysql://localhost:3306/";
	private String dbname="DBJava";
	private String user="root";
	private String pwd="";
	private Statement s;
	
	public Connection getcon() {
		return this.con;
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con= DriverManager.getConnection(url+ dbname + "?useUnicode=true&characterEncoding=utf-8", user, pwd);
			s=con.createStatement();
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
		MyConnect newCon =new MyConnect();
		newCon.connect();
		newCon.close();
	}

}

