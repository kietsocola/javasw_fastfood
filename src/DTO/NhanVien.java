package DTO;

public class NhanVien {
	 private int maNV;
	    private String ten;
	    private String ngaySinh;
	    private int gioiTinh;
	    private String soDT;
	    private String chucVu;
	    private int idTaiKhoan;

	    public NhanVien() {
	    }

	    public NhanVien(int maNV, String ten,String ngaySinh, int gioiTinh, String soDT) {
	        this.maNV = maNV;
	        this.ten = ten;
	        this.ngaySinh=ngaySinh;
	        this.gioiTinh = gioiTinh;
	        this.soDT = soDT;
	    }

	    public int getMaNV() {
	        return maNV;
	    }

	    public void setMaNV(int maNV) {
	        this.maNV = maNV;
	    }

	    public String getTen() {
	        return ten;
	    }

	    public void setTen(String ten) {
	        this.ten = ten;
	    }
	    
	    public String getNgaySinh() {
	    	return ngaySinh;
	    }
	    
	    public void setNgaySinh(String ngaySinh) {
	    	this.ngaySinh=ngaySinh;
	    }

	    public int getGioiTinh() {
	        return gioiTinh;
	    }

	    public void setGioiTinh(int gioiTinh) {
	        this.gioiTinh = gioiTinh;
	    }

	    public String getSoDT() {
	        return soDT;
	    }

	    public void setSoDT(String soDT) {
	        this.soDT = soDT;
	    }
	    
	    public String getChucVu() {
	        return chucVu;
	    }

	    public void setChucVu(String chucVu) {
	        this.chucVu = chucVu;
	    }


		public int getIdTaiKhoan() {
			return idTaiKhoan;
		}

		public void setIdTaiKhoan(int idTaiKhoan) {
			this.idTaiKhoan = idTaiKhoan;
		}
}
