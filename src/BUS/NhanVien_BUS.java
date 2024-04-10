package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.NhanVien_DAO;
import DTO.NhanVien;

public class NhanVien_BUS {

	 private NhanVien_DAO nvdao;
    private ArrayList<NhanVien> listNV = null;

    public NhanVien_BUS() {
        nvdao = new NhanVien_DAO();
        docDanhSach();
    }

    public void docDanhSach() {
        this.listNV = nvdao.getDSNhanVien();
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        if (this.listNV == null)
            this.docDanhSach();
        return this.listNV;
    }

    public boolean themNhanVien(String ten, String ngaySinh, String gioiTinh, String soDT) {
        ten = ten.trim();
        soDT = soDT.trim();
        if (ten.equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soDT.equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        boolean flag = nvdao.themNV(nv);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }

    public boolean suaNhanVien(String ma, String ten, String ngaySinh, String gioiTinh, String soDT) {
        int maNV = Integer.parseInt(ma);
        ten = ten.trim();
        ngaySinh = ngaySinh.trim();
        gioiTinh = gioiTinh.trim();
        soDT = soDT.trim();
        if (ten.equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soDT.equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setMaNV(maNV);
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        boolean flag = nvdao.updateNV(nv);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }

    public ArrayList<NhanVien> timNhanVien(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (NhanVien nv : listNV) {
            if (nv.getTen().toLowerCase().contains(tuKhoa) ||nv.getGioiTinh().toLowerCase().contains(tuKhoa) 
            		|| nv.getSoDT().toLowerCase().contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public boolean xoaNhanVien(String ma) {
        try {
            int maNV = Integer.parseInt(ma);
            boolean flag = nvdao.deleteNV(maNV);
            if (flag) {
                JOptionPane.showMessageDialog(null, "Xoá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xoá thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            return flag;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}

