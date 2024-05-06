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
    
    public void indanhsach() {
    	System.out.println(listNV.size() + "  la kich thuoc cua danh sach nhan vien");
    	for(NhanVien nv : listNV) {
    		System.out.print(nv.getTen() + " \n");
    	}
    }
    
    public String getTenNhanVien(int idTaiKhoan) {
    	for(NhanVien nv : listNV) {
    		System.out.print(nv.getIdTaiKhoan() + " id cua tai khoan o nhan vien bus\n");
    			if(nv.getIdTaiKhoan() == idTaiKhoan)
    				return nv.getTen();
    	}
    	return "";
    }

    public boolean themNhanVien(String ten, String ngaySinh, int gioiTinh, String soDT, String chucVu, int idTaiKhoan, int isThongBao ) {
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
        if (chucVu.equals("")) {
            JOptionPane.showMessageDialog(null, "Chức vụ không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        nv.setChucVu(chucVu);
        nv.setIdTaiKhoan(idTaiKhoan);
        boolean flag = nvdao.themNV(nv);
        if(isThongBao == 1) {
        	if (!flag) {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return flag;
    }

    public boolean suaNhanVien(String ma, String ten, String ngaySinh, int gioiTinh, String soDT, String chucVu) {
        try {
    	int maNV = Integer.parseInt(ma);
        ten = ten.trim();
        ngaySinh = ngaySinh.trim();
        soDT = soDT.trim();
        if (ten.equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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
        if (chucVu.equals("")) {
            JOptionPane.showMessageDialog(null, "Chức vụ không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setMaNV(maNV);
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        nv.setChucVu(chucVu);
        boolean flag = nvdao.updateNV(nv);
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

    public ArrayList<NhanVien> timNhanVien(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (NhanVien nv : listNV) {
        	
            if (nv.getTen().toLowerCase().contains(tuKhoa) || nv.getSoDT().toLowerCase().contains(tuKhoa)|| nv.getChucVu().toLowerCase().contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public boolean xoaNhanVien(String ma) {
    	if (ma.trim().equals("")) {
    		 JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    		 return false;
    	}
        int result = JOptionPane.showConfirmDialog(null, "Bạn chắn chắn muốn xoá?", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (result != JOptionPane.YES_OPTION) {
			return false;
		}
        
        int maNV = Integer.parseInt(ma);
        boolean flag = nvdao.deleteNV(maNV);
        if (flag) {
                JOptionPane.showMessageDialog(null, "Xoá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
                JOptionPane.showMessageDialog(null, "Xoá thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
            return flag;
        
    }
    

    public boolean nhapExcel(String ten, String ngaySinh, int gioiTinh, String soDT, String chucVu ) {
        NhanVien nv = new NhanVien();
        nv.setTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setGioiTinh(gioiTinh);
        nv.setSoDT(soDT);
        nv.setChucVu(chucVu);
        boolean flag = nvdao.nhapExcel(nv);
        
        return flag;
    }

}

