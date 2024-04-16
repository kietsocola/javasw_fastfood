package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhap;

public class CTPhieuNhapDAO {
	ConnectDB conDB = new ConnectDB();
	public ArrayList<ChiTietPhieuNhap> getDanhSachCTPhieuNhap(){
		ArrayList <ChiTietPhieuNhap> DSCTPhieuNhap = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM chitietphieunhap";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
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
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return DSCTPhieuNhap;
	}
	public ChiTietPhieuNhap getCTSP(int ma) {
		ChiTietPhieuNhap ctpn = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM chitietphieunhap WHERE ma=?";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);
				prest.setInt(1, ma);
				ResultSet rs = prest.executeQuery();
				while (rs.next()){
					ctpn = new ChiTietPhieuNhap();
					
					ctpn.setMaChitietPhieuNhap(rs.getInt("idChiTietPhieuNhap"));
					ctpn.setMaPN(rs.getInt("idPhieuNhap"));
					ctpn.setMaNL(rs.getInt("idNguyenLieu"));
					ctpn.setDonGia(rs.getInt("DonGia"));
					ctpn.setSoLuong(rs.getInt("SoLuong"));
					ctpn.setThanhTien(rs.getInt("ThanhTien"));
				
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return ctpn;
	}
// thêm xóa sửa
	public boolean themCTPN (ChiTietPhieuNhap ctpn) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				//update số lượng nguyên liệu trong kho
				String sqlUpdateNL = "UPDATE nguyenlieu SET SoLuong = SoLuong + ? WHERE id=? ";
				PreparedStatement pre1 = conDB.conn.prepareCall(sqlUpdateNL);
				pre1.setInt(1, ctpn.getSoLuong());
				pre1.setInt(2, ctpn.getMaNL());
				pre1.executeUpdate();
				
				String sqlUpdateCTPN="INSERT INTO chitietphieunhap(idNguyenLieu,DonGia,SoLuong,ThanhTien"
						+ "VALUES(?,?,?,?)";
				PreparedStatement pre2 = conDB.conn.prepareStatement(sqlUpdateCTPN);
				
				pre2.setInt(1, ctpn.getMaNL());
				pre2.setInt(2, ctpn.getDonGia());
				pre2.setInt(3, ctpn.getSoLuong());
				pre2.setInt(4, ctpn.getThanhTien());
				
				pre2.executeUpdate();
				result = true;
			}catch (SQLException e) {
				// TODO: handle exception
			}finally {
				conDB.closeConnectDB();
			}
		}
		return result;
	}
	public boolean xoaCTPN(int maCTPN) {
		 boolean result = false;
		    if (conDB.openConnectDB()) {
		        try {
		            String sql = "DELETE FROM chitietphieunhap WHERE idChiTietPhieuNhap=?";
		            PreparedStatement pre = conDB.conn.prepareStatement(sql);
		            pre.setInt(1, maCTPN);
		            pre.executeUpdate();
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
