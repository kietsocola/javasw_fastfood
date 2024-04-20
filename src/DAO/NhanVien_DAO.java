package DAO;

import DTO.NhanVien;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class NhanVien_DAO {
	
	 private ConnectDB conDB = new ConnectDB();
	 
	 public ArrayList<NhanVien> getDSNhanVien() {
		 
		    ArrayList<NhanVien> dsnv = new ArrayList<>();
		    if (conDB.openConnectDB()) {
		        try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT * FROM nhanvien")) {
		            ResultSet rs = pre.executeQuery();
		            while (rs.next()) {
		                NhanVien nv = new NhanVien();
		                nv.setMaNV(rs.getInt(1));
		                nv.setTen(rs.getString(4));
		                nv.setNgaySinh(rs.getString(6));
		                nv.setGioiTinh(rs.getInt(5));
		                nv.setSoDT(rs.getString(2));
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
	    try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT * FROM nhanvien WHERE id=?")) {
	        pre.setInt(1, maNV);
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            nv = new NhanVien();
	            nv.setMaNV(rs.getInt(1));
	            nv.setTen(rs.getString(4));
	            nv.setNgaySinh(rs.getString(6));
	            nv.setGioiTinh(rs.getInt(5));
	            nv.setSoDT(rs.getString(2));
	        }
	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return nv;
	}

	

	
	public boolean updateNV(NhanVien nv) {
		boolean result = false;
	    try {
	    	String sql = "UPDATE nhanvien SET Ten=?,NgaySinh=?, GioiTinh=?, SoDienThoai=? WHERE id=?";
	    	PreparedStatement pre = conDB.conn.prepareStatement(sql);
	        pre.setString(1, nv.getTen());
	        pre.setString(2, nv.getNgaySinh());
	        pre.setInt(3, nv.getGioiTinh());
	        pre.setString(4, nv.getSoDT());
	        pre.setInt(5, nv.getMaNV());
	        
	        result = pre.executeUpdate() > 0;
	    } catch (SQLException e) {  
	        e.printStackTrace();
	        return false;
	    }
	    return result;
	}

	public boolean deleteNV(int maNV) {
	    String sql = "DELETE FROM nhanvien WHERE id=?";
	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, maNV);
	        
	        int rowsAffected = pre.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean themNV(NhanVien nv) {
		boolean result = false;
	    try  {
	    	String sql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai)" 
	    + "VALUES(?, ?, ?, ?)";
	    	PreparedStatement pre = conDB.conn.prepareStatement(sql);
	        pre.setString(1, nv.getTen());
	        pre.setString(2, nv.getNgaySinh());
	        pre.setInt(3, nv.getGioiTinh());
	        pre.setString(4, nv.getSoDT());
	        
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();

	        return false;
	    }
	    return result;
	}


}
