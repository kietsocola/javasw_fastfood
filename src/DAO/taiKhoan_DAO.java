package DAO;
import java.sql.Connection;


import DTO.taiKhoan_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class taiKhoan_DAO  {
	connectDatabase con = new connectDatabase();
	
	public ArrayList<taiKhoan_DTO> getDSTaiKhoan() {
		 
	    ArrayList<taiKhoan_DTO> dstk = new ArrayList<>();
	    con.connect();
	        try (PreparedStatement pre = con.getCon().prepareStatement("SELECT * FROM taiKhoan")) {
	            ResultSet rs = pre.executeQuery();
	            while (rs.next()) {
	            	taiKhoan_DTO tk = new taiKhoan_DTO();
	            	tk.setMa(rs.getInt(1));
	            	tk.setNgayTao(rs.getString(2));
	            	tk.setTenTaiKhoan(rs.getString(3));;
	            	tk.setMatKhau(rs.getString(4));
	            	tk.setTrangThai(rs.getInt(5));
	            	tk.setQuyen(rs.getInt(6));
	            	
	                dstk.add(tk);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    
	    return dstk;
}
	
public int idTaiKhoanMax() {
		
		con.connect();
		String sql = "select MAX(id) as id from taikhoan";
		try {
			Statement stmt = con.getCon().createStatement()	;
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt("id");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return-1;
	}
	
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
	
	public int getTrangThai(int id) {	
		try {
			con.connect();
			String sql="SELECT TrangThai FROM taikhoan where id="+id;
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return -1;
	}
	
	public boolean suaTaiKhoan(taiKhoan_DTO tk) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "UPDATE taikhoan SET NgayTao=?, TenDangNhap=?, MatKhau=?, TrangThai=?, Quyen=? WHERE id=? ";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            pre.setInt(5, tk.getQuyen());
            pre.setInt(6, tk.getMa());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	
	public boolean themTaiKhoan(taiKhoan_DTO tk) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "INSERT INTO taikhoan( NgayTao, TenDangNhap, MatKhau,TrangThai, Quyen) "
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            pre.setInt(5, tk.getQuyen());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	
	public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        try {
        	con.connect();
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = '" + tenDangNhap + "'";
            Statement st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static void main(String[] args) {
		
	}
}
