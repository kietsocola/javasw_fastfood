package DTO;

public class CheBien {
	private int idCheBien;
    private int idSanPham;
    private int idNguyenLieu;
    private int soLuongDung;
    public CheBien() {
    	
    }
	public CheBien(int idCheBien, int idSanPham, int idNguyenLieu, int soLuongDung) {
		super();
		this.idCheBien = idCheBien;
		this.idSanPham = idSanPham;
		this.idNguyenLieu = idNguyenLieu;
		this.soLuongDung = soLuongDung;
	}
	public int getIdCheBien() {
		return idCheBien;
	}
	public void setIdCheBien(int idCheBien) {
		this.idCheBien = idCheBien;
	}
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getIdNguyenLieu() {
		return idNguyenLieu;
	}
	public void setIdNguyenLieu(int idNguyenLieu) {
		this.idNguyenLieu = idNguyenLieu;
	}
	public int getSoLuongDung() {
		return soLuongDung;
	}
	public void setSoLuongDung(int soLuongDung) {
		this.soLuongDung = soLuongDung;
	}
	
    
}
