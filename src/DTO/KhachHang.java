package DTO;

public class KhachHang {
    private int maKH;
    private String ten;
    private int gioiTinh;
    private String soDT;
    private int tongChiTieu;
    

    public KhachHang() {
    }

    public KhachHang(int maKH, String ten, int gioiTinh, String soDT, int tongChiTieu) {
        this.maKH = maKH;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
        this.soDT = soDT;

    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(int tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }


}