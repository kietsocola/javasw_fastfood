package DAO;

import DTO.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class KhachHangDAO {

	public ArrayList<KhachHang>getDSKhachHang(){
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "SELECT *FROM khachhang";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			ArrayList<KhachHang> dskh = new ArrayList<>();
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				KhachHang kh = new KhachHang();
				
				kh.setMaKH(rs.getInt(1));
				kh.setTen(rs.getString(2));
				kh.setGioiTinh(rs.getString(3));
				kh.setSoDT(rs.getString(4));
				kh.setTongChiTieu(rs.getDouble(5));
				
	            dskh.add(kh);
			}
		}catch(SQLException e) {
			
		}
		con.close();
		 return null;
	}
	
	public KhachHang getKhachHang(int maKH) {
		KhachHang kh =null;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql = "SELECT *FROM khachhang WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setInt(0,maKH);
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				kh = new KhachHang();
				
				kh.setMaKH(rs.getInt(1));
				kh.setTen(rs.getString(2));
				kh.setGioiTinh(rs.getString(3));
				kh.setSoDT(rs.getString(4));
				kh.setTongChiTieu(rs.getDouble(5));
			}
		}catch(SQLException e) {
			return null;
		}
		con.close();
		return kh;
	}
	
	public boolean updateKH(KhachHang kh) {
		boolean result=false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql ="UPDATE khachhang SET Ten=?, GioiTinh=?,SoDT=?,TongChiTieu=? WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setString(1, kh.getTen());
			pre.setString(2, kh.getGioiTinh());
			pre.setString(3, kh.getSoDT());
			pre.setDouble(4, kh.getTongChiTieu());
			pre.setInt(5, kh.getMaKH());
		}catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
	
	public boolean deleteKH(int maKH) {
		boolean result=false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql ="DELETE FROM khachhang WHERE id=?";
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setInt(1,maKH);
			result=pre.executeUpdate()>0;
		} catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
	
	public boolean themKH(KhachHang kh) {
		boolean result =false;
		MyConnect con = new MyConnect();
		con.connect();
		try {
			String sql="INSERT INTO KhachHang(Ten, GioiTinh, SoDT,TongChiTieu)" + "VALUES(?,?,?,?)" ;
			PreparedStatement pre= con.getCon().prepareStatement(sql);
			pre.setString(1, kh.getTen());
			pre.setString(2, kh.getGioiTinh());
			pre.setString(3, kh.getSoDT());
			pre.setDouble(4, kh.getTongChiTieu());
			result=pre.executeUpdate()>0;
		}catch (SQLException ex) {
            return false;
        }
		con.close();
        return result;
	}
}
