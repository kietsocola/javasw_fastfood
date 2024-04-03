package DTO;

public class SanPham {
	private int id;
	private int idLoaiSP;
	private String tenSP;
	private int donGia;
	private int soLuong;
	private String hinhAnh;
	private int idCongThuc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLoaiSP() {
		return idLoaiSP;
	}
	public void setIdLoaiSP(int idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
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
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getIdCongThuc() {
		return idCongThuc;
	}
	public void setIdCongThuc(int idCongThuc) {
		this.idCongThuc = idCongThuc;
	}
	public SanPham(int id, int idLoaiSP, String tenSP, int donGia, int soLuong, String hinhAnh, int idCongThuc) {
		super();
		this.id = id;
		this.idLoaiSP = idLoaiSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
		this.idCongThuc = idCongThuc;
	}
	public SanPham() {
		// TODO Auto-generated constructor stub
	}
	
}
