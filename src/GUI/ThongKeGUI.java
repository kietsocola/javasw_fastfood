package GUI;

import java.util.ArrayList;
import java.util.Map;
import java.sql.Date;
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
			Date ngayLap = (Date) hoaDon.getNgayLap();
			int tongTien = hoaDon.getTongTien();
			System.out.println("ID: " + id + ", Ngày Lập: " + ngayLap + ", Tổng Tiền: " + tongTien);
		}
	}
	
	public void hienThiDanhSachHoaDonWithDate(Date ngayBatDau, Date ngayKetThuc) {
	    ArrayList<HoaDon> hoaDonList = thongKeDAO.layDuLieuHoaDonWithDate(ngayBatDau, ngayKetThuc);

	    // In ra thông tin của từng hóa đơn từ danh sách
	    for (HoaDon hoaDon : hoaDonList) {
	        int id = hoaDon.getidHD();
	        Date ngayLap = (Date) hoaDon.getNgayLap();
	        int tongTien = hoaDon.getTongTien();
	        System.out.println("ID: " + id + ", Ngày Lập: " + ngayLap + ", Tổng Tiền: " + tongTien);
	    }
	}

	 public void hienThiThongKeHoaDonKhachHang() {
	        // Thực hiện thống kê hóa đơn theo khách hàng
	        Map<KhachHang, ArrayList<HoaDon>> thongKe = thongKeDAO.thongKeHoaDonKhachHang();

	        // Duyệt qua từng khách hàng và danh sách hóa đơn của họ
	        for (Map.Entry<KhachHang, ArrayList<HoaDon>> entry : thongKe.entrySet()) {
	            KhachHang khachHang = entry.getKey();
	            ArrayList<HoaDon> hoaDonList = entry.getValue();

	            // In thông tin khách hàng
	            System.out.println("Khách hàng: " + khachHang.getTen());
	            System.out.println("Danh sách hóa đơn:");
	            for (HoaDon hoaDon : hoaDonList) {
	                System.out.println("- ID: " + hoaDon.getidHD() + ", Ngày lập: " + hoaDon.getNgayLap() + ", Tổng tiền: " + hoaDon.getTongTien());
	            }
	            System.out.println();
	        }
	    }
	 
	 public void hienThongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) {
	        // Thực hiện thống kê doanh thu và lợi nhuận
	        double doanhThu = thongKeDAO.thongKeDoanhThu(ngayBatDau, ngayKetThuc);

	        // Hiển thị kết quả
	        System.out.println("Doanh thu từ " + ngayBatDau + " đến " + ngayKetThuc + " là: " + doanhThu);
	    }

	

	public static void main(String[] args) {
		ConnectDatabase dbConnection = new ConnectDatabase();
		ThongKeDAO thongKeDAO = new ThongKeDAO(dbConnection);
		ThongKeGUI thongKeGUI = new ThongKeGUI(thongKeDAO);

//		thongKeGUI.hienThiDanhSachSanPham();
//		thongKeGUI.hienThiDanhSachHoaDon();
		
		  // Ngày bắt đầu và ngày kết thúc
	    Date ngayBatDau = Date.valueOf("2022-01-01");
	    Date ngayKetThuc = Date.valueOf("2023-03-31");

	    // Hiển thị danh sách sản phẩm và danh sách hóa đơn
//	    thongKeGUI.hienThiDanhSachSanPham();
//	    thongKeGUI.hienThiDanhSachHoaDonWithDate(ngayBatDau, ngayKetThuc);
//	    
//	    int tongSoLuongKhachHang = thongKeDAO.tinhTongSoLuongKhachHang();
//	    System.out.println("Tổng số lượng khách hàng: " + tongSoLuongKhachHang);
	    
//	    int tongSoLuongSanPham = thongKeDAO.tinhTongSoLuongSanPham();
//	    System.out.println("Tổng số lượng sản phẩm: " + tongSoLuongSanPham);
	    
//	    thongKeGUI.hienThiThongKeHoaDonKhachHang();
	    
//	    thongKeGUI.hienThongKeDoanhThu(ngayBatDau, ngayKetThuc);

		dbConnection.closeConnection();
	}
}
