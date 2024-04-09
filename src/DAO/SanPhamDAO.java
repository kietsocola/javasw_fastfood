package DAO;

import java.sql.PreparedStatement;
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
	public boolean tangSoLuongSanPham(int id, int sl) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				String sql = "UPDATE sanpham SET SoLuong=SoLuong+? WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setInt(1, sl);
	            prest.setInt(2, id);
	            result = prest.executeUpdate()>0;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return result;
	}
}
