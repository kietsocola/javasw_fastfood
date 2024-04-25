package DTO;

import java.util.Date;

public class KhuyenMai {
	private int maKM;
	private String tenKM;
	private int phanTramKM;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	public KhuyenMai() {
		
	}
	public KhuyenMai(int maKM, String tenKM, int phanTramKM, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.phanTramKM = phanTramKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getMaKM() {
		return maKM;
	}
	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}
	public String getTenKM() {
		return tenKM;
	}
	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}
	public int getPhanTramKM() {
		return phanTramKM;
	}
	public void setPhanTramKM(int phanTramKM) {
		this.phanTramKM = phanTramKM;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
}
