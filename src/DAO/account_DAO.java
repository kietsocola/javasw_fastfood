package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.account_DTO;

public class account_DAO  {
	
	public boolean checkAccount(account_DTO account) throws SQLException  {
		boolean result = false;
		connectDatabase con = new connectDatabase();
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
	
	public static void main(String[] args) {
		
	}
}
