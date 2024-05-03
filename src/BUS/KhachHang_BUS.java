package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.KhachHang_DAO;
import DTO.KhachHang;

public class KhachHang_BUS {

    private KhachHang_DAO khdao;
    private ArrayList<KhachHang> listKH = null;

    public KhachHang_BUS() {
    	khdao = new KhachHang_DAO();
        docDanhSach();
    }

    public void docDanhSach() {
        this.listKH = khdao.getDSKhachHang();
    }

    public ArrayList<KhachHang> getDanhSachKhachHang() {
        if (this.listKH == null)
            this.docDanhSach();
        return this.listKH;
    }

    public boolean themKhachHang(String ten, int gioiTinh, String soDT) {
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
        String regex = "^0\\d{9,10}$";
        if (!soDT.matches(regex)) {
        	 JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        	 return false;
        }
        KhachHang kh = new KhachHang();
        kh.setTen(ten);
        kh.setGioiTinh(gioiTinh);
        kh.setSoDT(soDT);
        kh.setTongChiTieu(0);
        boolean flag = khdao.themKH(kh);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    }

    public boolean suaKhachHang(String ma, String ten, int gioiTinh, String soDT) {
    	try {
        int maKH = Integer.parseInt(ma);
        if (ten.equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (soDT.equals("")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regex = "^0\\d{9,10}$";
        if (!soDT.matches(regex)) {
        	 JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        	 return false;
        }
        KhachHang kh = new KhachHang();
        kh.setTen(ten);
        kh.setGioiTinh(gioiTinh);
        kh.setSoDT(soDT);

        boolean flag = khdao.updateKH(maKH, kh);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return flag;
    	}catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        	return false;
        }
    }

    public ArrayList<KhachHang> timKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (KhachHang kh : listKH) {
        	String ten = kh.getTen().toLowerCase();
        	String sodt=kh.getSoDT().toLowerCase();
            if (ten.contains(tuKhoa) ||  sodt.contains(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }
   public KhachHang getKhachHangBySDT(String sdt) {
	   return khdao.getKhachHangBySDT(sdt);
   }

    public ArrayList<KhachHang> timKhachHang(String txtMin, String txtMax) {
        if (txtMax.trim().equals("") && txtMax.trim().equals(""))
            return listKH;
        try {
            ArrayList<KhachHang> dskh = new ArrayList<>();
            txtMin = txtMin.replace(",", "");
            txtMax = txtMax.replace(",", "");
            int min = Integer.parseInt(txtMin);
            int max = Integer.parseInt(txtMax);
            for (KhachHang kh : listKH) {
                if (kh.getTongChiTieu() >= min && kh.getTongChiTieu() <= max) {
                    dskh.add(kh);
                }
            }
            return dskh;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Hãy nhập giá trị nguyên phù hợp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean xoaKhachHang(String ma) {
        try {
            int maKH = Integer.parseInt(ma);
            boolean flag = false;
            flag = khdao.deleteKH(maKH);
            if (flag) {
                JOptionPane.showMessageDialog(null, "Xoá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xoá thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            return flag;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}