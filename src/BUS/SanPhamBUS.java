package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.SanPhamDAO;
import DAO.LoaiSpDAO;
import DTO.HoaDon;
import DTO.LoaiSanPham;
import DTO.SanPham;

public class SanPhamBUS {
	private ArrayList<SanPham> DSSanPham = null;
	private SanPhamDAO spDAO = new SanPhamDAO();
	public SanPhamBUS() {
		docListSanPham();
	}
//	public ArrayList<SanPham> getListSanPham(){
//		listSP = sanPhamDAO.getListSanPham();
//		return listSP;
//	}
//	public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
//        ArrayList<SanPham> dssp = new ArrayList<>();
//        for (SanPham sp : DSSanPham) {
//            String tenSP = sp.getTenSP().toLowerCase();
//            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
//                dssp.add(sp);
//            }
//        }
//        return dssp;
//    }
	public ArrayList<SanPham> getSanPhamTheoTenVaLoai(String ten, int maLoai) {
        ArrayList<SanPham> dssp = new ArrayList<>();
//        for (SanPham sp : DSSanPham) {
//            String tenSP = sp.getTenSP().toLowerCase();
//            if (tenSP.toLowerCase().contains(ten.toLowerCase()) && sp.getIdLoaiSP()==maLoai) {
//                dssp.add(sp);
//            }
//        }
        dssp = spDAO.getDanhSachSanPhamTheoTenVaLoai(ten, maLoai);
        return dssp;
    }
	public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        dssp = spDAO.getDanhSachSanPhamTheoTen(ten);
        return dssp;
    }
	public SanPham getSanPhamTheoMa(int ma) {
        return spDAO.getSanPham(ma);
    }
	public void tangSoLuongSP(int id, int sl) {
		try {
			spDAO.tangSoLuongSanPham(id, sl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void docListSanPham() {
//		listSP = sanPhamDAO.getListSanPham();
//	}
	// phần của tú
	public ArrayList<SanPham> getDSSanPham() {
		if(DSSanPham == null) {
			docListSanPham();
		}
		return DSSanPham;
	}
	public void docListSanPham() {
	    DSSanPham = spDAO.getDanhSachSanPham();
	}
	public String getAnh(String ma) {
        int maSP = Integer.parseInt(ma);
        return spDAO.getAnh(maSP);
    }
 public boolean themSanPham(String ten,
            int loai,
            int soLuong,
            //int idCongThuc,
            String anh,
            int donGia) {

        if (ten.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Tên SP không được để rỗng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            
            return false;
        }
        try {
            
            if (loai == 0) {
	        	JOptionPane.showMessageDialog(null, "vui lòng chọn loại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            SanPham sp = new SanPham();
            sp.setTenSP(ten);
            sp.setIdLoaiSP(loai);
            sp.setSoLuong(soLuong);
            //sp.setIdCongThuc(idCongThuc);
            sp.setHinhAnh(anh);
            sp.setDonGia(donGia);

            if (spDAO.themSanPham(sp)) {
            	JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
            	JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);;
        }
        return false;
    }
 public boolean suaSanPham(int id,
		 	String ten,
            int loai,
            int soLuong,
            //int idCongThuc,
            String anh,
            int donGia) {
	 try {
		 if(id==0) {
			 JOptionPane.showMessageDialog(null, "Chưa chọn mã để sửa", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	            
	            return false;
		 }
		 if (loai == 0) {
	        	JOptionPane.showMessageDialog(null, "vui lòng chọn loại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
             return false;
         }
		 if (ten.trim().equals("")) {
	        	JOptionPane.showMessageDialog(null, "Tên SP không được để rỗng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	            
	            return false;
	        }
		 SanPham sp = new SanPham();
         sp.setTenSP(ten);
         sp.setIdLoaiSP(loai);
         sp.setSoLuong(soLuong);
        // sp.setIdCongThuc(idCongThuc);
         sp.setHinhAnh(anh);
         sp.setDonGia(donGia);
		 sp.setId(id);
         if (spDAO.suaSanPham(sp)) {
            	JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
            	JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại các giá trị", "Thông báo", JOptionPane.INFORMATION_MESSAGE);;
        }
	 return false;
 }

 public boolean xoaSanPham (String MaSP) {
	 if (MaSP.trim().equals("")) {
         	JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm để xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
         return false;
     }

     int maSP = Integer.parseInt(MaSP);
     if (spDAO.xoaSanPham(maSP)) {
    	 	JOptionPane.showMessageDialog(null, "Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
    	 return true;
     }

     JOptionPane.showMessageDialog(null, "Xóa thất bại","Thông báo",JOptionPane.INFORMATION_MESSAGE);     
     return false;
 }
}

