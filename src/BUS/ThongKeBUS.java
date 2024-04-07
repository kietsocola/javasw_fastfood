package BUS;

import java.sql.Date;

import java.sql.Date;
import java.util.ArrayList;
import DAO.ThongKeDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.SanPham;

import java.util.ArrayList;

import DAO.ThongKeDAO;
import DTO.HoaDon;

public class ThongKeBUS {

	private ThongKeDAO thongKeDAO = new ThongKeDAO();

	// Phương thức lấy danh sách tên loại sản phẩm
	public ArrayList<String> getListTenLoaiSP() {
		return thongKeDAO.getListTenLoaiSP();
	}

	// Phương thức lấy danh sách tất cả sản phẩm
	public ArrayList<SanPham> getAllSanPham() {
		return thongKeDAO.getAllSanPham();
	}

	// Phương thức lấy danh sách sản phẩm theo loại sản phẩm
	public ArrayList<SanPham> getSanPhamByLoaiSP(String loaiSP) {
		return thongKeDAO.getSanPhamByLoaiSP(loaiSP);
	}

	public HoaDon getHoaDonById(int idHoaDon) {
		return thongKeDAO.getHoaDonById(idHoaDon);
	}

	public ArrayList<ChiTietHoaDon> getChiTietHoaDonBySanPham(int idSanPham) {
		return thongKeDAO.getChiTietHoaDonBySanPham(idSanPham);
	}

	public ArrayList<SanPham> getSanPhamByDate(Date startDate, Date endDate) {
		return thongKeDAO.getSanPhamByDate(startDate, endDate);
	}

	public ArrayList<SanPham> getSanPhamByDateAndCategory(String loaiSP, Date startDate, Date endDate) {
		return thongKeDAO.getSanPhamByDateAndCategory(loaiSP, startDate, endDate);
	}

}