package DAO;

import java.util.ArrayList;
import java.sql.*;

import DTO.HoaDon;

public class HoaDonDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<HoaDon> getListHoaDon() {
		ArrayList<HoaDon> arrHoaDon = new ArrayList<HoaDon>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from HoaDon";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					HoaDon hd = new HoaDon();
					hd.setidHD(rs.getInt("id"));
					hd.setidNV(rs.getInt("idNhanVien"));
					hd.setidKH(rs.getInt("idKhachHang"));
					hd.setNgayLap(rs.getDate("NgayLap"));
					hd.setTongTien(rs.getInt("TongTien"));
					hd.setTrangThai(rs.getInt("TrangThai"));
					hd.setGhiChu(rs.getString("ghiChu"));
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrHoaDon;
	}

	public boolean addHoaDon(HoaDon hd) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				String sqlUpdateTongTien = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getTongTien()
						+ " WHERE idKhachHang=" + hd.getidKH();
				Statement stmt = conDB.conn.createStatement();
				stmt.executeQuery(sqlUpdateTongTien);
				String sql = "INSERT INTO HoaDon(NgayLap, TongTien, TrangThai, idNhanVien, idKhachHang, ghiChu) VALUES(?, ?, ?, ?, ?, ?)";
				PreparedStatement prep = conDB.conn.prepareStatement(sql);
				prep.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
				prep.setInt(2, hd.getTongTien());
				prep.setInt(3, hd.getTrangThai());
				prep.setInt(4, hd.getidNV());
				prep.setInt(5, hd.getidKH());
				prep.setString(6, hd.getGhiChu());
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
	public boolean deleteHoaDon(int idHD) {
		ChiTietHoaDonDAO cthdDao = new ChiTietHoaDonDAO();
		return cthdDao.deleteChiTietHoaDon_ByIdHoaDon(idHD);
	}
}
