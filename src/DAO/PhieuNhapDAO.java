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
		
		try {
			String sql = "SELECT * FROM sanpham";
			PreparedStatement prest =conDB.conn.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <PhieuNhap> DSPhieuNhap = new ArrayList<>();
			while (rs.next()){
				PhieuNhap pn = new PhieuNhap();
				
				pn.setMaPN(rs.getInt("id"));
				pn.setMaNCC(rs.getInt("idNhaCC"));
				pn.setTongTien(rs.getInt("TongTien"));
				pn.setNgayLap(rs.getDate("NgayLap"));
				pn.setMaNV(rs.getInt("idNhanVien"));
			
				DSPhieuNhap.add(pn);
				
				
			}
			return DSPhieuNhap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public PhieuNhap getPhieuNhap(int maPN) {
		
		try {
			String sql = "SELECT *FROM phieunhap WHERE id=";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			prest.setInt(1, maPN);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				PhieuNhap pn = new PhieuNhap();
				
				pn.setMaNCC(rs.getInt("id"));
				pn.setMaNCC(rs.getInt("idNhaCC"));
				pn.setTongTien(rs.getInt("TongTien"));
				pn.setNgayLap(rs.getDate("NgayLap"));
				pn.setMaNV(rs.getInt("idNhanVien"));
				
				return pn;
				
			}
		} catch (SQLException e) {
			
		}
		return null;
	}
	// các chức năng thêm xóa sửa 
	public boolean themPhieuNhap(PhieuNhap pn) {
		try {
			String sql = "INSERT INTO phieunhap(idNhacc, TongTien, NgayLap, idNhanVien)"
					+"VALUES (?,?,?,?)";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			
			prest.setInt(1, pn.getMaNCC());
			prest.setInt(2, pn.getTongTien());
			prest.setDate(3, (Date) pn.getNgayLap());
			prest.setInt(4, pn.getMaNV());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean xoaPhieuNhap(int maPN) {
		try {
            String sql = "DELETE FROM phieunhap WHERE id=" + maPN;
            Statement st = conDB.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
	}
	public boolean suaPhieuNhap(PhieuNhap pn) {
		try {
			String sql = "UPDATE phieunhap SET"
					+ "idNhaCC=?, "
					+ "TongTien=? ,NgayLap=?, idNhanVien=?"
					+ "WHERE id=?";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			
			prest.setInt(1, pn.getMaNCC());
			prest.setInt(2, pn.getTongTien());
			prest.setDate(3, (Date) pn.getNgayLap());
			prest.setInt(4, pn.getMaNV());
			prest.setInt(5, pn.getMaPN());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
}
