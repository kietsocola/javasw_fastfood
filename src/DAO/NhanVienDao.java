package DAO;

import DTO.NhanVien;
import DAO.MyConnect;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class NhanVienDao {
	public ArrayList<NhanVien>getDSNhanVien(){
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "SELECT * FROM nhanvien";
			PreparedStatement pre =con.getCon().prepareStatement(sql);
			ArrayList<NhanVien> dsnv = new ArrayList<>();
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				
				nv.setMaNV(rs.getInt(1));
				nv.setTen(rs.getString(2));
	            nv.setNgaySinh(rs.getString(3));
	            nv.setGioiTinh(rs.getString(4));
	            nv.setSoDT(rs.getString(5));
	                
	            dsnv.add(nv);
			}
		}catch(SQLException e) {
			
		}
		con.close();
		 return null;
	}
	
	public NhanVien getNhanVien(int maNV) {
		NhanVien nv =null;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "SELECT * FROM nhanvien WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setInt(0,maNV);
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				nv = new NhanVien();
				
				nv.setMaNV(rs.getInt(1));
	            nv.setTen(rs.getString(2));
	            nv.setNgaySinh(rs.getString(3));
	            nv.setGioiTinh(rs.getString(4));
	            nv.setSoDT(rs.getString(5));
			}
		}catch(SQLException e) {
			return null;
		}
		con.close();
		return nv;
	}
	
	public boolean updateNV(NhanVien nv) {
		boolean result=false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			  String sql = "UPDATE nhanvien SET Ho=?, Ten=?, GioiTinh=?, SoDienThoai=? WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setString(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			pre.setInt(5, nv.getMaNV());
		}catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
	
	public boolean deleteNV(int maNV) {
		boolean result=false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "DELETE FROM nhanvien WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setInt(1,maNV);
			result=pre.executeUpdate()>0;
		} catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
	
	public boolean themNV(NhanVien nv) {
		boolean result =false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "INSERT INTO NhanVien(Ho, Ten, GioiTinh, ChucVu) " +
                    "VALUES(?, ?, ?, ?)";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setString(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			result=pre.executeUpdate()>0;
		}catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
}
