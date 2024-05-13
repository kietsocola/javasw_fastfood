package BUS;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiSpDAO;
import DTO.LoaiSanPham;
public class LoaiBUS {
	private ArrayList<LoaiSanPham> ListLoaiSP = null;
	private LoaiSpDAO loaiDAO = new LoaiSpDAO();
	public LoaiBUS() {
		docListLoaiSP();
	}
	public void docListLoaiSP() {
		this.ListLoaiSP = loaiDAO.getDanhSachLoai();
	}
	
	public ArrayList<LoaiSanPham> getListLoaiSP(){
		if (ListLoaiSP == null) {
			docListLoaiSP();
		}
		return this.ListLoaiSP;
	}
	
	public String getTenLoai(int ma) {
        for (LoaiSanPham loai : ListLoaiSP) {
            if (loai.getMaLoai() == ma) {
                return loai.getMaLoai() + " - " + loai.getTenLoaiSP();
            }
        }
        return "";
    }

	public boolean themLoai(int maLoai, String tenLoai) {
        if (tenLoai.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống tên loại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        maLoai += 1;
        LoaiSanPham loai = new LoaiSanPham(maLoai, tenLoai);
        if (loaiDAO.themLoaiSanPham(loai)) {
            JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean xoaLoai(String ma) {
        if (ma.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn loại để xoá!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int maLoai = Integer.parseInt(ma);
        if (loaiDAO.xoaLoaiSanPham(maLoai)) {
            JOptionPane.showMessageDialog(null, "Xoá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Xoá thất bại! Loại có sản phẩm con", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean suaLoai(String ma, String ten) {
        if (ten.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống tên loại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int maLoai = Integer.parseInt(ma);
        LoaiSanPham loai = new LoaiSanPham(maLoai, ten);
        if (loaiDAO.suaLoaiSanPham(loai)) {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
