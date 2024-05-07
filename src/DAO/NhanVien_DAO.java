package DAO;

import DTO.NhanVien;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NhanVien_DAO {
	
	 private ConnectDB conDB = new ConnectDB();
	 
	 public ArrayList<NhanVien> getDSNhanVien() {
		 
		    ArrayList<NhanVien> dsnv = new ArrayList<>();
		    if (conDB.openConnectDB()) {
		        try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT * FROM nhanvien WHERE isDelete=0")) {
		            ResultSet rs = pre.executeQuery();
		            while (rs.next()) {
		                NhanVien nv = new NhanVien();
		                nv.setMaNV(rs.getInt(1));
		                nv.setTen(rs.getString(4));
		                nv.setNgaySinh(rs.getString(6));
		                nv.setGioiTinh(rs.getInt(5));
		                nv.setSoDT(rs.getString(2));
		                nv.setIdTaiKhoan(rs.getInt(3));
		                nv.setChucVu(rs.getString(7));
		                dsnv.add(nv);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		    }
		    return dsnv;
	}


	public NhanVien getNhanVien(int maNV) {
	    NhanVien nv = null;
	    try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT * FROM nhanvien WHERE id=? AND isDelete=0")) {
	        pre.setInt(1, maNV);
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            nv = new NhanVien();
	            nv.setMaNV(rs.getInt(1));
	            nv.setTen(rs.getString(4));
	            nv.setNgaySinh(rs.getString(6));
	            nv.setGioiTinh(rs.getInt(5));
	            nv.setSoDT(rs.getString(2));
	            nv.setChucVu(rs.getString(7));
	        }
	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return nv;
	}

	
	public boolean themNV(NhanVien nv) {
		boolean result = false;
	    try  {
	    	String sql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai,ChucVu,idTaiKhoan ) " 
	    + "VALUES(?, ?, ?, ?,?,?)";
	    	PreparedStatement pre = conDB.conn.prepareStatement(sql);
	        pre.setString(1, nv.getTen());
	        pre.setString(2, nv.getNgaySinh());
	        pre.setInt(3, nv.getGioiTinh());
	        pre.setString(4, nv.getSoDT());
	        pre.setString(5, nv.getChucVu());
	        pre.setInt(6, nv.getIdTaiKhoan());
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();

	        return false;
	    }
	    return result;
	}
	
	public boolean updateNV(NhanVien nv) {
		boolean result = false;
	    try {
	    	String sql = "UPDATE nhanvien SET Ten=?,NgaySinh=?, GioiTinh=?, SoDienThoai=?, ChucVu=? WHERE id=? ";
	    	PreparedStatement pre = conDB.conn.prepareStatement(sql);
	        pre.setString(1, nv.getTen());
	        pre.setString(2, nv.getNgaySinh());
	        pre.setInt(3, nv.getGioiTinh());
	        pre.setString(4, nv.getSoDT());
	        pre.setString(5, nv.getChucVu());
	        pre.setInt(6, nv.getMaNV());
	        
	        result = pre.executeUpdate() > 0;
	    } catch (SQLException e) {  
	        e.printStackTrace();
	        return false;
	    }
	    return result;
	}

	public boolean deleteNV(int maNV) {
	    String sql = "UPDATE nhanvien SET isDelete=1 WHERE id=?" ;
	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, maNV);

	        int rowsAffected = pre.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public int getIdTaiKhoan(int id) {	
		try {
			String sql="SELECT idTaiKhoan FROM nhanvien where id="+id;
			Statement st = conDB.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return -1;
	}
	

	public boolean nhapExcel(NhanVien nv) {
	    try {
	        // Cập nhật trường isDelete để đánh dấu là tất cả các dữ liệu hiện tại được xem như đã xóa
	        String updateSql = "UPDATE nhanvien SET isDelete = 1";
	        PreparedStatement updatePre = conDB.conn.prepareStatement(updateSql);
	        updatePre.executeUpdate();

	        // Chèn dữ liệu mới từ đối tượng NhanVien vào bảng nhanvien
	        String insertSql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai, ChucVu) " +
	                           "VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement pre = conDB.conn.prepareStatement(insertSql);
	        pre.setString(1, nv.getTen());
	        pre.setString(2, nv.getNgaySinh());
	        pre.setInt(3, nv.getGioiTinh());
	        pre.setString(4, nv.getSoDT());
	        pre.setString(5, nv.getChucVu());
	        
	        // Thực hiện chèn dữ liệu mới
	        boolean inserted = pre.executeUpdate() > 0;
	        
	        return inserted;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean kiemTraTrungSDT(String sdt) {
		try {
			String sql="SELECT * FROM nhanvien where SoDienThoai='"+sdt+"' AND isDelete = 0";
			Statement st = conDB.conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
