package DTO;

import java.sql.Date;

public class ChiTietHoaDon {
	private int idHoaDon;
	private int idSanPham;
	private int soLuong;
	private int donGia;
	private int thanhTien;
	private int idKhuyenMai;
	private int id;
	private Date ngayBan; 
	private int idLoaiSP;

	public ChiTietHoaDon() {

	}

	public ChiTietHoaDon(int idHoaDon, int idSanPham, int soLuong, int donGia, int thanhTien, int idKhuyenMai, int id) {
		super();
		this.idHoaDon = idHoaDon;
		this.idSanPham = idSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.idKhuyenMai = idKhuyenMai;
		this.id = id;
	}
	
	public Date getNgayBan() {
		return ngayBan;
	}

	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getidLoaiSP() {
		return idLoaiSP;
	}

	public void setidLoaiSP(int idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getIdKhuyenMai() {
		return idKhuyenMai;
	}

	public void setIdKhuyenMai(int idKhuyenMai) {
		this.idKhuyenMai = idKhuyenMai;
	}

}