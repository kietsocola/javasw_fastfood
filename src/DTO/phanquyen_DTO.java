package DTO;

public class phanquyen_DTO {
		private int idPhanQuyen ;
		private String tenPhanQUyen ;
		private Boolean nhaphang;
		private Boolean sanpham;
		private Boolean nhanvien;
		private Boolean khachhang;
		private Boolean thongke;
		
		public int getIdPhanQuyen() {
			return this.idPhanQuyen;		
		}
		
		public String getTenPhanQuyen() {
			return this.tenPhanQUyen;
		}
		
		public void setIdPhanQuyen(int idPhanQuyen) {
			this.idPhanQuyen = idPhanQuyen;
		}
		
		public void setTenPhanQuyen(String tenPhanQuyen) {
			this.tenPhanQUyen = tenPhanQuyen;
		}

		public String getTenPhanQUyen() {
			return tenPhanQUyen;
		}

		public void setTenPhanQUyen(String tenPhanQUyen) {
			this.tenPhanQUyen = tenPhanQUyen;
		}

		public Boolean getNhaphang() {
			return nhaphang;
		}

		public void setNhaphang(Boolean nhaphang) {
			this.nhaphang = nhaphang;
		}

		public Boolean getSanpham() {
			return sanpham;
		}

		public void setSanpham(Boolean sanpham) {
			this.sanpham = sanpham;
		}

		public Boolean getNhanvien() {
			return nhanvien;
		}

		public void setNhanvien(Boolean nhanvien) {
			this.nhanvien = nhanvien;
		}

		public Boolean getKhachhang() {
			return khachhang;
		}

		public void setKhachhang(Boolean khachhang) {
			this.khachhang = khachhang;
		}

		public Boolean getThongke() {
			return thongke;
		}

		public void setThongke(Boolean thongke) {
			this.thongke = thongke;
		}
		
		
		
}	
