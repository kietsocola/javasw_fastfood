package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhap;

public class CTPhieuNhapDAO {
	public ArrayList<ChiTietPhieuNhap> getDanhSachCTPhieuNhap(){
		
		try {
			String sql = "SELECT * FROM chitietphieunhap";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <ChiTietPhieuNhap> DSCTPhieuNhap = new ArrayList<>();
			while (rs.next()){
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
				
				ctpn.setMaChitietPhieuNhap(rs.getInt("idChiTietPhieuNhap"));
				ctpn.setMaPN(rs.getInt("idPhieuNhap"));
				ctpn.setMaNL(rs.getInt("idNguyenLieu"));
				ctpn.setDonGia(rs.getInt("DonGia"));
				ctpn.setSoLuong(rs.getInt("SoLuong"));
				ctpn.setThanhTien(rs.getInt("ThanhTien"));
			
				DSCTPhieuNhap.add(ctpn);
				
				
			}
			return DSCTPhieuNhap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ChiTietPhieuNhap getCTSP(int ma) {
		try {
			String sql = "SELECT * FROM chitietphieunhap WHERE ma=?";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);
			prest.setInt(1, ma);
			ResultSet rs = prest.executeQuery();
			while (rs.next()){
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
				
				ctpn.setMaChitietPhieuNhap(rs.getInt("idChiTietPhieuNhap"));
				ctpn.setMaPN(rs.getInt("idPhieuNhap"));
				ctpn.setMaNL(rs.getInt("idNguyenLieu"));
				ctpn.setDonGia(rs.getInt("DonGia"));
				ctpn.setSoLuong(rs.getInt("SoLuong"));
				ctpn.setThanhTien(rs.getInt("ThanhTien"));
			
				return ctpn;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
// thêm xóa sửa
	public boolean themCTPN (ChiTietPhieuNhap ctpn) {
		try {
			//update số lượng nguyên liệu trong kho
			String sqlUpdateNL = "UPDATE nguyenlieu SET SoLuong = SoLuong + ? WHERE id=? ";
			PreparedStatement pre1 = ConnectDB.con.prepareCall(sqlUpdateNL);
			pre1.setInt(1, ctpn.getSoLuong());
			pre1.setInt(2, ctpn.getMaNL());
			pre1.executeUpdate();
			
			String sqlUpdateCTPN="INSERT INTO chitietphieunhap(idNguyenLieu,DonGia,SoLuong,ThanhTien"
					+ "VALUES(?,?,?,?)";
			PreparedStatement pre2 = ConnectDB.con.prepareStatement(sqlUpdateCTPN);
			
			pre2.setInt(1, ctpn.getMaNL());
			pre2.setInt(2, ctpn.getDonGia());
			pre2.setInt(3, ctpn.getSoLuong());
			pre2.setInt(4, ctpn.getThanhTien());
			
			pre2.execute();
			return true;
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean xoaCTPN(int maCTPN) {
		try {
            String sql = "DELETE FROM chitietphieunhap WHERE idChiTietPhieuNhap=" + maCTPN;
            Statement st = ConnectDB.con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
	}
}
