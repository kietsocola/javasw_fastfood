package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.SanPham;

public class SanPhamDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<SanPham> getListSanPham() {
		ArrayList<SanPham> arrSanPham = new ArrayList<SanPham>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from SanPham";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					SanPham hd = new SanPham();
					hd.setId(rs.getInt("id"));
					hd.setIdLoaiSP(rs.getInt("idLoaiSP"));
					hd.setTenSP(rs.getString("TenSP"));
					hd.setDonGia(rs.getInt("DonGia"));
					hd.setSoLuong(rs.getInt("SoLuong"));
					hd.setHinhAnh(rs.getString("HinhAnh"));
					hd.setIdCongThuc(rs.getInt("idCongThuc"));
					arrSanPham.add(hd);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrSanPham;
	}
}
