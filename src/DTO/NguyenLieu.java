package DTO;

public class NguyenLieu {
	private int maNguyenLieu;
	private String tenNL;
	private int soLuongNL;
	private int DonGiaNL;
	private int maDonVi;

	public NguyenLieu() {
		
	}
	public NguyenLieu(int maNguyenLieu, String tenNL, int soLuongNL,int DonGiaNL, int maDonVi) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNL = tenNL;
		this.soLuongNL = soLuongNL;
		this.DonGiaNL = DonGiaNL;
		this.maDonVi = maDonVi;
	}
	public int getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(int maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public String getTenNL() {
		return tenNL;
	}
	public void setTenNL(String tenNL) {
		this.tenNL = tenNL;
	}
	public int getsoLuongNL() {
		return soLuongNL;
	}
	public void setsoLuongNL(int soLuongNL) {
		this.soLuongNL = soLuongNL;
	}
	public int getDonGiaNL() {
		return DonGiaNL;
	}
	public void setDonGiaNL(int donGiaNL) {
		DonGiaNL = donGiaNL;
	}
	public int getSoLuongNL() {
		return soLuongNL;
	}
	public void setSoLuongNL(int soLuongNL) {
		this.soLuongNL = soLuongNL;
	}
	public int getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(int maDonVi) {
		this.maDonVi = maDonVi;
	}
	
}
