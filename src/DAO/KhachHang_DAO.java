package DAO;

import DTO.KhachHang;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class KhachHang_DAO {
	
	ConnectDB conDB = new ConnectDB();
	
	
	public ArrayList<KhachHang> getDSKhachHang() {
		 
		ArrayList<KhachHang> dskh = new ArrayList<>();
	    if (conDB.openConnectDB()) {
	        try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT *FROM khachhang")) {
	            ResultSet rs = pre.executeQuery();
	            while (rs.next()) {
	            	KhachHang kh = new KhachHang();
	            	kh.setMaKH(rs.getInt(1));
					kh.setTen(rs.getString(2));
					kh.setGioiTinh(rs.getInt(5));
					kh.setSoDT(rs.getString(3));
					kh.setTongChiTieu(rs.getInt(4));
					
		            dskh.add(kh);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	    return dskh;
	}
	
	public KhachHang getKhachHang(int maKH) {
		KhachHang kh =null;

		try {
			String sql = "SELECT *FROM khachhang WHERE id=?";
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setInt(1,maKH);
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				kh = new KhachHang();
				
				kh.setMaKH(rs.getInt(1));
				kh.setTen(rs.getString(2));
				kh.setGioiTinh(rs.getInt(3));
				kh.setSoDT(rs.getString(4));
				kh.setTongChiTieu(rs.getInt(5));
			}
		}catch(SQLException e) {
			return null;
		}

		return kh;
	}
	public KhachHang getKhachHangBySDT(String sdt) {
		KhachHang kh =null;

		try {
			String sql = "SELECT *FROM khachhang WHERE SoDienThoai=?";
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setString(1,sdt);
			ResultSet rs=pre.executeQuery();
			
			while(rs.next()) {
				kh = new KhachHang();
				
				kh.setMaKH(rs.getInt(1));
				kh.setTen(rs.getString(2));
				kh.setGioiTinh(rs.getInt(3));
				kh.setSoDT(rs.getString(4));
				kh.setTongChiTieu(rs.getInt(5));
			}
		}catch(SQLException e) {
			return null;
		}

		return kh;
	}
	public boolean updateKH(int maKH,KhachHang kh) {
		boolean result=false;

		try {
			String sql ="UPDATE khachhang SET Ten=?, GioiTinh=?, SoDienThoai=? WHERE id=?";
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setString(1, kh.getTen());
			pre.setInt(2, kh.getGioiTinh());
			pre.setString(3, kh.getSoDT());
			pre.setInt(4, maKH);
			result = pre.executeUpdate() > 0;
		}catch (SQLException ex) {
            return false;
        }

        return result;
	}
	public boolean updateChiTieuKH(int maKH, int money) {
		boolean result=false;

		try {
			String sql ="UPDATE khachhang SET TongChiTieu=TongChiTieu+? WHERE id=?";
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setInt(1, money);
			pre.setInt(2, maKH);
			result = pre.executeUpdate() > 0;
		}catch (SQLException ex) {
            return false;
        }

        return result;
	}
	
	public boolean deleteKH(int maKH) {
		boolean result=false;
		
		try {
			String sql ="DELETE FROM khachhang WHERE id=?";
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setInt(1,maKH);
			result=pre.executeUpdate()>0;
		} catch (SQLException ex) {
            return false;
        }
		
        return result;
	}
	
	public boolean themKH(KhachHang kh) {
		boolean result =false;
		
		try {
			String sql="INSERT INTO KhachHang(Ten, GioiTinh, SoDienThoai, TongChiTieu)" + "VALUES(?,?,?,?)" ;
			PreparedStatement pre= conDB.conn.prepareStatement(sql);
			pre.setString(1, kh.getTen());
			pre.setInt(2, kh.getGioiTinh());
			pre.setString(3, kh.getSoDT());
			pre.setInt(4, kh.getTongChiTieu());
			result=pre.executeUpdate()>0;
		}catch (SQLException ex) {
            return false;
        }
		
        return result;
	}
}