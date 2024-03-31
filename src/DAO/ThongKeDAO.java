package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DTO.HoaDon;
import DTO.KhachHang;
import DTO.SanPham;

public class ThongKeDAO {
	private ConnectDatabase conn;

	public ThongKeDAO(ConnectDatabase conn) {
		this.conn = conn;
	}

	public ArrayList<KhachHang> layDuLieuKhachHang() {
		Connection connection = conn.getConnection();
		String sql = "SELECT id, Ten, SoDienThoai, TongChiTieu, GioiTinh FROM khachhang";
		ArrayList<KhachHang> result = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String Ten = resultSet.getString("Ten");
				String SoDienThoai = resultSet.getString("SoDienThoai");
				int TongChiTieu = resultSet.getInt("TongChiTieu");
				String GioiTinh = resultSet.getString("GioiTinh");

				KhachHang khachHang = new KhachHang(id, Ten, GioiTinh, SoDienThoai, TongChiTieu);

				result.add(khachHang);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi lấy dữ liệu từ bảng khachHang: " + e.getMessage());
		}
		return result;
	}

	public int tinhTongSoLuongKhachHang() {
		Connection connection = conn.getConnection();
		String sql = "SELECT COUNT(*) AS total FROM khachhang";
		int total = 0;

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			if (resultSet.next()) {
				total = resultSet.getInt("total");
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi tính tổng số lượng khách hàng: " + e.getMessage());
		}
		return total;
	}

	public ArrayList<SanPham> layDuLieuSanPham() {
		Connection connection = conn.getConnection();
		String sql = "SELECT id, idLoaiSP, TenSP, DonGia, SoLuong,HinhAnh,idCongThuc FROM sanpham";
		ArrayList<SanPham> result = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			// Xử lý kết quả
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String TenSP = resultSet.getString("TenSP");
				int idLoaiSP = resultSet.getInt("idLoaiSP");
				int SoLuong = resultSet.getInt("SoLuong");
				String HinhAnh = resultSet.getString("HinhAnh");
				int DonGia = resultSet.getInt("DonGia");
				int idCongThuc = resultSet.getInt("idCongThuc");

				SanPham SanPham = new SanPham(id, TenSP, idLoaiSP, SoLuong, HinhAnh, DonGia);

				result.add(SanPham);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi lấy dữ liệu từ bảng sanpham: " + e.getMessage());
		}
		return result;
	}
	
	public int tinhTongSoLuongSanPham() {
		Connection connection = conn.getConnection();
		String sql = "SELECT COUNT(*) AS total FROM sanpham";
		int total = 0;

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			if (resultSet.next()) {
				total = resultSet.getInt("total");
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi tính tổng số lượng sản phẩm: " + e.getMessage());
		}
		return total;
	}

	public ArrayList<HoaDon> layDuLieuHoaDon() {
		Connection connection = conn.getConnection();
		String sql = "SELECT id, NgayLap, TongTien FROM HoaDon";
		ArrayList<HoaDon> result = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				Date ngayLap = resultSet.getDate("NgayLap");
				int tongTien = resultSet.getInt("TongTien");

				HoaDon hoaDon = new HoaDon(id, ngayLap, tongTien);
				result.add(hoaDon);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi lấy dữ liệu từ bảng HoaDon: " + e.getMessage());
		}
		return result;
	}

	public ArrayList<HoaDon> layDuLieuHoaDonWithDate(Date ngayBatDau, Date ngayKetThuc) {
		Connection connection = conn.getConnection();
		String sql = "SELECT id, NgayLap, TongTien FROM HoaDon WHERE NgayLap BETWEEN ? AND ?";
		ArrayList<HoaDon> result = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setDate(1, ngayBatDau);
			statement.setDate(2, ngayKetThuc);
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				Date ngayLap = resultSet.getDate("NgayLap");
				int tongTien = resultSet.getInt("TongTien");

				HoaDon hoaDon = new HoaDon(id, ngayLap, tongTien);
				result.add(hoaDon);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi lấy dữ liệu từ bảng HoaDon: " + e.getMessage());
		}
		return result;
	}

	public Map<KhachHang, ArrayList<HoaDon>> thongKeHoaDonKhachHang() {
		Map<KhachHang, ArrayList<HoaDon>> hoaDonTheoKhachHang = new HashMap<>();

		// Lấy danh sách khách hàng
		ArrayList<KhachHang> khachHangList = layDuLieuKhachHang();

		// Duyệt qua từng khách hàng
		for (KhachHang khachHang : khachHangList) {
			// Lấy danh sách hóa đơn của khách hàng
			ArrayList<HoaDon> hoaDonList = layDuLieuHoaDonTheoKhachHang(khachHang.getMaKH());

			// Thêm vào map
			hoaDonTheoKhachHang.put(khachHang, hoaDonList);
		}

		return hoaDonTheoKhachHang;
	}

	private ArrayList<HoaDon> layDuLieuHoaDonTheoKhachHang(int idKhachHang) {
		Connection connection = conn.getConnection();
		String sql = "SELECT id, NgayLap, TongTien FROM HoaDon WHERE idKhachHang = ?";
		ArrayList<HoaDon> result = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, idKhachHang);
			ResultSet resultSet = statement.executeQuery();

			// Xử lý kết quả
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				Date ngayLap = resultSet.getDate("NgayLap");
				int tongTien = resultSet.getInt("TongTien");

				HoaDon hoaDon = new HoaDon(id, ngayLap, tongTien);
				result.add(hoaDon);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi lấy dữ liệu từ bảng HoaDon: " + e.getMessage());
		}
		return result;
	}

	public double thongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) {
		Connection connection = conn.getConnection();
		String sqlHoaDon = "SELECT SUM(TongTien) AS doanhThu FROM hoadon WHERE NgayLap BETWEEN ? AND ?";
		double doanhThu = 0;

		try (PreparedStatement statementHoaDon = connection.prepareStatement(sqlHoaDon)) {
			// Thiết lập tham số cho truy vấn hoá đơn
			statementHoaDon.setDate(1, ngayBatDau);
			statementHoaDon.setDate(2, ngayKetThuc);
			ResultSet resultSetHoaDon = statementHoaDon.executeQuery();

			// Lấy doanh thu từ hóa đơn
			if (resultSetHoaDon.next()) {
				doanhThu += resultSetHoaDon.getDouble("doanhThu");
			}

		} catch (SQLException e) {
			System.out.println("Lỗi khi thống kê doanh thu: " + e.getMessage());
		}

		return doanhThu;
	}
}
