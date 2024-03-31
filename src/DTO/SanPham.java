package DTO;

public class SanPham {
	    private int maSP;
	    private String tenSP;
	    private int maLoai;
	    private int soLuong;
	    private String hinhAnh;
	    private int donGia;
	    private int maCongThuc;
	    public SanPham() {

	    }

	    public SanPham(int maSP, String tenSP, int maLoai, int soLuong, String donViTinh, String hinhAnh, int donGia) {
	        this.maSP = maSP;
	        this.tenSP = tenSP;
	        this.maLoai = maLoai;
	        this.soLuong = soLuong;
	        this.hinhAnh = hinhAnh;
	        this.donGia = donGia;
	    }
	    
	    public SanPham(int maSP, String tenSP, int maLoai, int soLuong, String hinhAnh, int donGia) {
	        this.maSP = maSP;
	        this.tenSP = tenSP;
	        this.maLoai = maLoai;
	        this.soLuong = soLuong;
	        this.hinhAnh = hinhAnh;
	        this.donGia = donGia;
	    }


	    public int getMaSP() {
	        return maSP;
	    }

	    public void setMaSP(int maSP) {
	        this.maSP = maSP;
	    }

	    public String getTenSP() {
	        return tenSP;
	    }

	    public void setTenSP(String tenSP) {
	        this.tenSP = tenSP;
	    }

	    public int getMaLoai() {
	        return maLoai;
	    }

	    public void setMaLoai(int maLoai) {
	        this.maLoai = maLoai;
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

	    public int getDonGia() {
	        return donGia;
	    }

	    public void setDonGia(int donGia) {
	        this.donGia = donGia;
	    }

		public int getMaCongThuc() {
			return maCongThuc;
		}

		public void setMaCongThuc(int maCongThuc) {
			this.maCongThuc = maCongThuc;
		}
}