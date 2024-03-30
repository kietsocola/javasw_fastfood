package GUI;

import java.util.ArrayList;
import java.util.Date;

import DAO.ConnectDatabase;
import DAO.ThongKeDAO;
import DTO.HoaDon;
import DTO.KhachHang;

public class ThongKeGUI {
	private ThongKeDAO thongKeDAO;

	public ThongKeGUI(ThongKeDAO thongKeDAO) {
		this.thongKeDAO = thongKeDAO;
	}

	public void hienThiDanhSachSanPham() {
		ArrayList<KhachHang> sanPhamList = thongKeDAO.layDuLieuKhachHang();

		// In ra thông tin của từng sản phẩm từ danh sách
		for (KhachHang khachHang : sanPhamList) {
			int id = khachHang.getMaKH();
			String Ten = khachHang.getTen();
			String SoDienThoai = khachHang.getSoDT();
			int TongChiTieu = khachHang.getTongChiTieu();
			String GioiTinh = khachHang.getGioiTinh();
			System.out.println("ID: " + id + ", Ten: " + Ten + ", SoDienThoai: " + SoDienThoai + ", TongChiTieu: "
					+ TongChiTieu + ", GioiTinh: " + GioiTinh);
		}
	}

	public void hienThiDanhSachHoaDon() {
		ArrayList<HoaDon> hoaDonList = thongKeDAO.layDuLieuHoaDon();

		// In ra thông tin của từng hóa đơn từ danh sách
		for (HoaDon hoaDon : hoaDonList) {
			int id = hoaDon.getidHD();
			Date ngayLap = hoaDon.getNgayLap();
			int tongTien = hoaDon.getTongTien();
			System.out.println("ID: " + id + ", Ngày Lập: " + ngayLap + ", Tổng Tiền: " + tongTien);
		}
	}

	public static void main(String[] args) {
		ConnectDatabase dbConnection = new ConnectDatabase();
		ThongKeDAO thongKeDAO = new ThongKeDAO(dbConnection);
		ThongKeGUI thongKeGUI = new ThongKeGUI(thongKeDAO);

		thongKeGUI.hienThiDanhSachSanPham();
		thongKeGUI.hienThiDanhSachHoaDon();

		dbConnection.closeConnection();
	}
}
