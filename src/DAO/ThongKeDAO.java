package DAO;

import java.util.ArrayList;
import java.util.HashMap;
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
				String sql = "SELECT * FROM SanPham where isdelete = 0 ";
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

	public SanPham getProductById(int productId) {
		SanPham product = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM SanPham WHERE id = ? and   isdelete = 0 ";
				PreparedStatement preparedStatement = conDB.conn.prepareStatement(sql);
				preparedStatement.setInt(1, productId);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					product = new SanPham();
					product.setId(resultSet.getInt("id"));
					product.setIdLoaiSP(resultSet.getInt("idLoaiSP"));
					product.setTenSP(resultSet.getString("TenSP"));
					product.setDonGia(resultSet.getInt("DonGia"));
					product.setSoLuong(resultSet.getInt("SoLuong"));
					product.setHinhAnh(resultSet.getString("HinhAnh"));
					product.setIdCongThuc(resultSet.getInt("idCongThuc"));
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return product;
	}

	public ArrayList<SanPham> getSanPhamByLoaiSP(String loaiSP) {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT s.* FROM SanPham s JOIN LoaiSanPham l ON s.idLoaiSP = l.id WHERE l.TenLoaiSP = ? and   s.isdelete = 0 ";
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

	public ArrayList<SanPham> getSanPhamByDate(Date startDate, Date endDate) {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT DISTINCT sp.* FROM SanPham sp "
						+ "JOIN ChiTietHoaDon cthd ON sp.id = cthd.idSanPham "
						+ "JOIN HoaDon hd ON cthd.idHoaDon = hd.id " + "WHERE hd.NgayLap BETWEEN ? AND ? and   sp.isdelete = 0 ";
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
						+ "WHERE hd.NgayLap BETWEEN ? AND ? AND lsp.TenLoaiSP = ? and sp.isdelete = 0 ";
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

	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM HoaDon";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					HoaDon hoaDon = new HoaDon();
					hoaDon.setidHD(rs.getInt("id"));
					hoaDon.setNgayLap(rs.getDate("NgayLap"));
					hoaDon.setTongTien(rs.getInt("TongTien"));
					hoaDon.setTrangThai(rs.getInt("TrangThai"));
					hoaDon.setidNV(rs.getInt("idNhanVien"));
					hoaDon.setidKH(rs.getInt("idKhachHang"));
					hoaDon.setGhiChu(rs.getString("ghiChu"));
					listHoaDon.add(hoaDon);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return listHoaDon;
	}
	
	public ArrayList<HoaDon> getHoaDon() {
		ArrayList<HoaDon> hoaDonList = new ArrayList<>();

		if (conDB.openConnectDB()) {
			try {
				// Tạo câu truy vấn SQL để lấy danh sách hóa đơn trong tháng
				String sql = "SELECT * FROM HoaDon";
				PreparedStatement preparedStatement = conDB.conn.prepareStatement(sql);

				// Thực thi truy vấn
				ResultSet resultSet = preparedStatement.executeQuery();

				// Lặp qua kết quả và thêm hóa đơn vào danh sách
				while (resultSet.next()) {
					HoaDon hoaDon = new HoaDon();
					// Đọc thông tin từ kết quả và thiết lập vào đối tượng hóa đơn
					hoaDon.setidHD(resultSet.getInt("id"));
					hoaDon.setNgayLap(resultSet.getDate("NgayLap"));
					hoaDon.setTongTien(resultSet.getInt("TongTien"));
					hoaDon.setTrangThai(resultSet.getInt("TrangThai"));
					hoaDon.setidNV(resultSet.getInt("idNhanVien"));
					hoaDon.setidKH(resultSet.getInt("idKhachHang"));
					hoaDon.setGhiChu(resultSet.getString("ghiChu"));

					// Thêm hóa đơn vào danh sách
					hoaDonList.add(hoaDon);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}

		return hoaDonList;
	}

	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM ChiTietHoaDon";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setId(rs.getInt("id"));
					chiTietHoaDon.setIdHoaDon(rs.getInt("idHoaDon"));
					chiTietHoaDon.setIdSanPham(rs.getInt("idSanPham"));
					chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
					chiTietHoaDon.setDonGia(rs.getInt("DonGia"));
					chiTietHoaDonList.add(chiTietHoaDon);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return chiTietHoaDonList;
	}
	
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonByHoaDonId(int hoaDonId) {
		ArrayList<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM ChiTietHoaDon WHERE idHoaDon = ?";
				PreparedStatement preparedStatement = conDB.conn.prepareStatement(sql);
				preparedStatement.setInt(1, hoaDonId);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setId(resultSet.getInt("id"));
					chiTietHoaDon.setIdHoaDon(resultSet.getInt("idHoaDon"));
					chiTietHoaDon.setIdSanPham(resultSet.getInt("idSanPham"));
					chiTietHoaDon.setSoLuong(resultSet.getInt("SoLuong"));
					chiTietHoaDon.setDonGia(resultSet.getInt("DonGia"));

					chiTietHoaDonList.add(chiTietHoaDon);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}

		return chiTietHoaDonList;
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

	public int getTotal(String table) {
		int totalCustomers = 0;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT COUNT(*) AS total FROM " + table + " where isdelete = 0";
				PreparedStatement preparedStatement = conDB.conn.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					totalCustomers = resultSet.getInt("total");
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return totalCustomers;
	}
	
	public int getAVG(String table) {
		int totalCustomers = 0;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT avg(tongtien) AS total FROM " + table ;
				PreparedStatement preparedStatement = conDB.conn.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					totalCustomers = resultSet.getInt("total");
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return totalCustomers;
	}

}