package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDon;
import DTO.KhachHang;

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
}
