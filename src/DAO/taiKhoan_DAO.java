package DAO;
import java.sql.Connection;
import DTO.taiKhoan_DTO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class taiKhoan_DAO  {
	connectDatabase con = new connectDatabase();
	
	public ResultSet getAccount(taiKhoan_DTO account) throws SQLException  {
		boolean result = false;
		con.connect();
		String sql = "select * from taikhoan where TenDangNhap = ? and MatKhau =?";
		PreparedStatement preparedStatement =con.getCon().prepareStatement(sql);
		
		preparedStatement.setString(1,account.getTenTaiKhoan());
		preparedStatement.setString(2, account.getMatKhau());
		
		ResultSet resultset = preparedStatement.executeQuery();
		return resultset;
	}
	


	
	public boolean checkAccount(taiKhoan_DTO account) throws SQLException  {
		boolean result = false;
		result =  getAccount(account).next();
		con.close();
		return result;
	}
	
	public int checkStatus(taiKhoan_DTO account) throws SQLException {
			
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("TrangThai");
		con.close();
		return 0;
	}
	
	public String getTen(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getString("TenDangNhap");
		con.close();
		return null;
	}
	
	public int getIdPhanQuyen(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("Quyen");
		con.close();
		return 0;
	}
	
	public int getId(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("id");
		con.close();
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
