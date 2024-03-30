package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/testjava";
    private static final String username = "root";
    private static final String password = "";

   
    public static void getconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối CSDL thành công");
        } catch (Exception e) {
            System.out.println("Kết nối CSDL thất bại");
            e.printStackTrace();
        }
    }

    public static void closeConnect() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Đã đóng CSDL");
            }
        } catch (Exception e) {
            System.out.println("Đóng CSDL thất bại");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getconnect();
        closeConnect();
    }
}

