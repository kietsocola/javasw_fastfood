package DTO;

public class ChiTietPhieuNhap {
	private int maPN;
	private int maNL;
	private int donGia;
	private int soLuong;
	private int thanhTien;
	public ChiTietPhieuNhap() {
	
	}
	public ChiTietPhieuNhap(int maPN, int maNL, int donGia, int soLuong, int thanhTien) {
		this.maPN = maPN;
		this.maNL = maNL;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public int getMaPN() {
		return maPN;
	}
	public void setMaPN(int maPN) {
		this.maPN = maPN;
	}
	public int getMaNL() {
		return maNL;
	}
	public void setMaNL(int maNL) {
		this.maNL = maNL;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	
}
