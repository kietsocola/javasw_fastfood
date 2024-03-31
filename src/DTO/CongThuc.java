package DTO;

public class CongThuc {
	private int id;
    private int idSanPham;
    private int idNguyenLieu;
    private int soLuongDung;
    public CongThuc() {
    	
    }
	public CongThuc(int id, int idSanPham, int idNguyenLieu, int soLuongDung) {
		super();
		this.id = id;
		this.idSanPham = idSanPham;
		this.idNguyenLieu = idNguyenLieu;
		this.soLuongDung = soLuongDung;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
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
