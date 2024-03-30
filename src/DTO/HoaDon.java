package DTO;

import java.util.Date;

public class HoaDon {
	private int idHD;
	private int idKH;
	private int idNV;
	private Date ngayLap;
	private int tongTien;
	private String ghiChu;
	private int trangThai;

	public HoaDon() {

	}

	public HoaDon(int idHD, Date ngayLap, int tongTien) {
		super();
		this.idHD = idHD;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
	}

	public HoaDon(int idHD, int idKH, int idNV, Date ngayLap, int tongTien, String ghiChu, int trangThai) {
		super();
		this.idHD = idHD;
		this.idKH = idKH;
		this.idNV = idNV;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}

	public int getidHD() {
		return idHD;
	}

	public void setidHD(int idHD) {
		this.idHD = idHD;
	}

	public int getidKH() {
		return idKH;
	}

	public void setidKH(int idKH) {
		this.idKH = idKH;
	}

	public int getidNV() {
		return idNV;
	}

	public void setidNV(int idNV) {
		this.idNV = idNV;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}