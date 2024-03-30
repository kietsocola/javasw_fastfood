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
            System.out.println("ket noi csdl thanh cong");
        } catch (Exception e) {
            System.out.println("Ket noi csdl that bai");
            e.printStackTrace();
        }
    }

    public static void closeConnect() {
        try {
            if (con != null) {
                con.close();
                System.out.println("da dong CSDL");
            }
        } catch (Exception e) {
            System.out.println("Dong CSDL that bai");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getconnect();
        closeConnect();
    }
}

