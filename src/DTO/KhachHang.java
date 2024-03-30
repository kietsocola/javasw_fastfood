package DTO;

public class KhachHang {
    private int maKH;
    private String ten;
    private String gioiTinh;
    private String soDT;
    private boolean tongChiTieu;
    

    public KhachHang() {
    }

    public KhachHang(int maKH, String ten, String gioiTinh, String soDT, boolean tongChiTieu) {
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(boolean tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }


}