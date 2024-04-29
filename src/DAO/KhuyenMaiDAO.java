package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CongThuc;
import DTO.KhuyenMai;

public class KhuyenMaiDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<KhuyenMai> getListKhuyenMai() {
		ArrayList<KhuyenMai> arrKhuyenMai = new ArrayList<KhuyenMai>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from KhuyenMai";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					KhuyenMai km = new KhuyenMai();
					km.setMaKM(rs.getInt("id"));
					km.setTenKM(rs.getString("Ten"));
					km.setPhanTramKM(rs.getInt("PhanTram"));
					km.setNgayBatDau(rs.getDate("NgayBatDau"));
					km.setNgayKetThuc(rs.getDate("NgayKetThuc"));
					arrKhuyenMai.add(km);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrKhuyenMai;
	}
	public boolean addKhuyenMai(KhuyenMai km) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "INSERT INTO khuyenmai(Ten, PhanTram) VALUES (?, ?)";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setString(1, km.getTenKM());
	            prep.setInt(2, km.getPhanTramKM());
	            if (prep.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
	public boolean updateKhuyenMai(KhuyenMai km) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE khuyenmai set Ten = ?, PhanTram = ? where id = "+km.getMaKM();
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setString(1, km.getTenKM());
	            prep.setInt(2, km.getPhanTramKM());
	            if (prep.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
	public KhuyenMai getKhuyenMaiById(int id) {
		KhuyenMai km = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from KhuyenMai where id = "+id;
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					km = new KhuyenMai();
					km.setTenKM(rs.getString("Ten"));
					km.setPhanTramKM(rs.getInt("PhanTram"));
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return km;
	}
}
