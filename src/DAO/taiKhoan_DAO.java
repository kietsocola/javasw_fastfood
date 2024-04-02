package DAO;
import java.sql.Connection;
import DTO.taiKhoan_DTO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.taiKhoan_DTO;

public class taiKhoan_DAO  {
	connectDatabase con = new connectDatabase();

	
	public boolean checkAccount(taiKhoan_DTO account) throws SQLException  {
		boolean result = false;
		con.connect();
		String sql = "select * from acount where user_name = ? and password =?";
		PreparedStatement preparedStatement =con.getCon().prepareStatement(sql);
		
		preparedStatement.setString(1,account.getTenTaiKhoan());
		preparedStatement.setString(2, account.getMatKhau());
		
		ResultSet resultset = preparedStatement.executeQuery();
		result =  resultset.next();
		con.close();
		return result;
	}
	
	public int checkStatus(taiKhoan_DTO account) throws SQLException {
		
		connectDatabase con = new connectDatabase();
		con.connect();
		String sql = "select * from acount where user_name = ? and password =?";
		PreparedStatement preparedStatement =con.getCon().prepareStatement(sql);
			
		preparedStatement.setString(1,account.getTenTaiKhoan());
		preparedStatement.setString(2, account.getMatKhau());
			
		ResultSet resultset = preparedStatement.executeQuery();
		if(resultset.next())
			return resultset.getInt("status");
		con.close();
		return 0;
	}
	
	public String getTen(taiKhoan_DTO account) throws SQLException {
		
		connectDatabase con = new connectDatabase();
		con.connect();
		String sql = "select * from acount as a,nguoidung as nd where a.user_name = ? and a.password =? and nd.id_acount = a.id";
		PreparedStatement preparedStatement =con.getCon().prepareStatement(sql);
			
		preparedStatement.setString(1,account.getTenTaiKhoan());
		preparedStatement.setString(2, account.getMatKhau());
			
		ResultSet resultset = preparedStatement.executeQuery();
		if(resultset.next())
			return resultset.getString("fullname");
		con.close();
		return null;
	}
	
	
	public static void main(String[] args) {
		
	}
}
