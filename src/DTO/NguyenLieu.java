package DTO;

public class NguyenLieu {
	private String maNguyenLieu;
	private String tenNL;
	private int soLuongNL;
	public NguyenLieu() {
		
	}
	public NguyenLieu(String maNguyenLieu, String tenNL, int soLuongNL) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNL = tenNL;
		this.soLuongNL = soLuongNL;
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
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
