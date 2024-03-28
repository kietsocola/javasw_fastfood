package DTO;

import java.util.Date;

public class DTOPhieuNhap {
	private int maPN;
    private DTONhaCungCap maNCC;
    private int maNV;
    private Date ngayLap;
    private int tongTien;

    public DTOPhieuNhap() {
    }

    public DTOPhieuNhap(int maPN, DTONhaCungCap maNCC, int maNV, Date ngayLap, int tongTien) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public DTONhaCungCap getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(DTONhaCungCap maNCC) {
        this.maNCC = maNCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
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

}
