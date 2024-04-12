package DAO;

import java.util.ArrayList;

import java.sql.*;
import java.util.List; 
import java.sql.Date;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.SanPham;

public class ThongKeDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<String> getListTenLoaiSP() {
		ArrayList<String> listTenLoaiSP = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT TenLoaiSP FROM LoaiSanPham";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					listTenLoaiSP.add(rs.getString("TenLoaiSP"));
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listTenLoaiSP;
	}

	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM SanPham";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					SanPham sp = new SanPham();
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					listSanPham.add(sp);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listSanPham;
	}

	public ArrayList<SanPham> getSanPhamByLoaiSP(String loaiSP) {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT s.* FROM SanPham s JOIN LoaiSanPham l ON s.idLoaiSP = l.id WHERE l.TenLoaiSP = ?";
				PreparedStatement stmt = conDB.conn.prepareStatement(sql);
				stmt.setString(1, loaiSP);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					SanPham sp = new SanPham();
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					listSanPham.add(sp);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listSanPham;
	}

	public HoaDon getHoaDonById(int idHoaDon) {
		HoaDon hoaDon = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM HoaDon WHERE id = ?";
				PreparedStatement stmt = conDB.conn.prepareStatement(sql);
				stmt.setInt(1, idHoaDon);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					hoaDon = new HoaDon();
					hoaDon.setidHD(rs.getInt("id"));
					hoaDon.setNgayLap(rs.getDate("NgayLap"));
					hoaDon.setTongTien(rs.getInt("TongTien"));
					hoaDon.setTrangThai(rs.getInt("TrangThai"));
					hoaDon.setidNV(rs.getInt("idNhanVien"));
					hoaDon.setidKH(rs.getInt("idKhachHang"));
					hoaDon.setGhiChu(rs.getString("ghiChu"));
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return hoaDon;
	}

	public ArrayList<ChiTietHoaDon> getChiTietHoaDonBySanPham(int idSanPham) {
		ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM ChiTietHoaDon WHERE idSanPham = ?";
				PreparedStatement stmt = conDB.conn.prepareStatement(sql);
				stmt.setInt(1, idSanPham);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					ChiTietHoaDon cthd = new ChiTietHoaDon();
					cthd.setId(rs.getInt("id"));
					cthd.setIdHoaDon(rs.getInt("idHoaDon"));
					cthd.setIdSanPham(rs.getInt("idSanPham"));
					cthd.setDonGia(rs.getInt("DonGia"));
					cthd.setSoLuong(rs.getInt("SoLuong"));
					cthd.setThanhTien(rs.getInt("ThanhTien"));
					cthd.setIdKhuyenMai(rs.getInt("idKhuyenMai"));
					listChiTietHoaDon.add(cthd);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listChiTietHoaDon;
	}

	public ArrayList<SanPham> getSanPhamByDate(Date startDate, Date endDate) {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT DISTINCT sp.* FROM SanPham sp "
						+ "JOIN ChiTietHoaDon cthd ON sp.id = cthd.idSanPham "
						+ "JOIN HoaDon hd ON cthd.idHoaDon = hd.id " + "WHERE hd.NgayLap BETWEEN ? AND ?";
				PreparedStatement stmt = conDB.conn.prepareStatement(sql);
				stmt.setDate(1, startDate);
				stmt.setDate(2, endDate);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					SanPham sp = new SanPham();
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					listSanPham.add(sp);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listSanPham;
	}

	public ArrayList<SanPham> getSanPhamByDateAndCategory(String loaiSP, Date startDate, Date endDate) {
		ArrayList<SanPham> listSanPham = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT DISTINCT sp.* FROM SanPham sp "
						+ "JOIN ChiTietHoaDon cthd ON sp.id = cthd.idSanPham "
						+ "JOIN HoaDon hd ON cthd.idHoaDon = hd.id " + "JOIN LoaiSanPham lsp ON sp.idLoaiSP = lsp.id "
						+ "WHERE hd.NgayLap BETWEEN ? AND ? AND lsp.TenLoaiSP = ?";
				PreparedStatement stmt = conDB.conn.prepareStatement(sql);
				stmt.setDate(1, startDate);
				stmt.setDate(2, endDate);
				stmt.setString(3, loaiSP);
				ResultSet rs = stmt.executeQuery();
				listSanPham = new ArrayList<>();
				while (rs.next()) {
					SanPham sp = new SanPham();
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					listSanPham.add(sp);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listSanPham;
	}

}