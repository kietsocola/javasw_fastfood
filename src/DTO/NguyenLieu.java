package DTO;

public class NguyenLieu {
	private int maNguyenLieu;
	private String tenNL;
	private int soLuongNL;
	public NguyenLieu() {
		
	}
	public NguyenLieu(int maNguyenLieu, String tenNL, int soLuongNL) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNL = tenNL;
		this.soLuongNL = soLuongNL;
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
	

}
