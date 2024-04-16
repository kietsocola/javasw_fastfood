package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuNhap;


public class PhieuNhapDAO {
	ConnectDB conDB = new ConnectDB();
	
	public ArrayList<PhieuNhap> getDanhSachPhieuNhap(){
		ArrayList <PhieuNhap> DSPhieuNhap = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM sanpham";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					PhieuNhap pn = new PhieuNhap();
					
					pn.setMaPN(rs.getInt("id"));
					pn.setMaNCC(rs.getInt("idNhaCC"));
					pn.setTongTien(rs.getInt("TongTien"));
					pn.setNgayLap(rs.getDate("NgayLap"));
					pn.setMaNV(rs.getInt("idNhanVien"));
				
					DSPhieuNhap.add(pn);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return DSPhieuNhap;
	}
	public PhieuNhap getPhieuNhap(int maPN) {
		PhieuNhap pn = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM phieunhap WHERE id=";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setInt(1, maPN);
				ResultSet rs = prest.executeQuery();
				while (rs.next()) {
					pn = new PhieuNhap();
					
					pn.setMaNCC(rs.getInt("id"));
					pn.setMaNCC(rs.getInt("idNhaCC"));
					pn.setTongTien(rs.getInt("TongTien"));
					pn.setNgayLap(rs.getDate("NgayLap"));
					pn.setMaNV(rs.getInt("idNhanVien"));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return pn;
	}
	// các chức năng thêm xóa sửa 
	public boolean themPhieuNhap(PhieuNhap pn) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				String sql = "INSERT INTO phieunhap(idNhacc, TongTien, NgayLap, idNhanVien)"
						+"VALUES (?,?,?,?)";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				
				prest.setInt(1, pn.getMaNCC());
				prest.setInt(2, pn.getTongTien());
				prest.setDate(3, (Date) pn.getNgayLap());
				prest.setInt(4, pn.getMaNV());
				
				if(prest.executeUpdate() >=1)
					result = true;
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				conDB.closeConnectDB();
			}
		}
		return result;
	}
	public boolean xoaPhieuNhap(int maPN) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "DELETE FROM phieunhap WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setInt(1, maPN);
	            if (prest.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
	public boolean suaPhieuNhap(PhieuNhap pn) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE phieunhap SET idNhaCC=?, TongTien=?, NgayLap=?, idNhanVien=? WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);

	            prest.setInt(1, pn.getMaNCC());
	            prest.setInt(2, pn.getTongTien());
	            prest.setDate(3, (Date) pn.getNgayLap());
	            prest.setInt(4, pn.getMaNV());
	            prest.setInt(5, pn.getMaPN());

	            if (prest.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
}
