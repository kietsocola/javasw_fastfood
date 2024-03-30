package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
	ConnectDB conDB = new ConnectDB();
	public ArrayList<ChiTietHoaDon> getListCTHDtheoIdHD(int idHD) {
		ArrayList<ChiTietHoaDon> arrChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM cthoadon WHERE MaHD="+idHD;
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					ChiTietHoaDon cthd = new ChiTietHoaDon();
	                cthd.setIdHoaDon(rs.getInt("idHoaDon"));
	                cthd.setIdSanPham(rs.getInt("idSanPham"));
	                cthd.setSoLuong(rs.getInt("SoLuong"));
	                cthd.setThanhTien(rs.getInt("ThanhTien"));
	                cthd.setDonGia(rs.getInt("DonGia"));
	                cthd.setIdKhuyenMai(rs.getInt("idKhuyenMai"));
	                arrChiTietHoaDon.add(cthd);
	            }
			}catch(SQLException ex) {
	            return null;
	        }
		}

        return arrChiTietHoaDon;
	}
	public boolean addChiietHoaDon(ChiTietHoaDon cthd) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				String sql = "INSERT INTO HoaDon(idHoaDon, idSanPham, DonGia, SoLuong, ThanhTien, idKhuyenMai) VALUES(?, ?, ?, ?, ?, ?)";
				PreparedStatement prep = conDB.conn.prepareStatement(sql);
				prep.setInt(1, cthd.getIdHoaDon());
				prep.setInt(2, cthd.getIdSanPham());
				prep.setInt(3, cthd.getDonGia());
				prep.setInt(4, cthd.getSoLuong());
				prep.setInt(5, cthd.getThanhTien());
				prep.setInt(6, cthd.getIdKhuyenMai());
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
}
