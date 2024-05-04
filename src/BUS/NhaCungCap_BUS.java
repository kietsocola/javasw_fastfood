package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;



public class NhaCungCap_BUS {
	private NhaCungCapDAO nccdao =new NhaCungCapDAO();
	private ArrayList<NhaCungCap> listncc = null;
	
	public  NhaCungCap_BUS() {
		docDS();
	}
	
	public void docDS() {
		this.listncc=nccdao.getDanhSachNhaCungCap();
	}
	
	public ArrayList<NhaCungCap> getListNhaCungCap(){
		if(this.listncc==null) {
			docDS();
		}
		return this.listncc;
	}
	
	public boolean themNCC(String tenNCC,String soDT, String diaChi ) {
		if(tenNCC.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy nhập tên nhà cung cấp này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		if(diaChi.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy nhập địa chỉ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		if(soDT.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy nhập số điện thoại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		
		 String regex = "^0\\d{9,10}$";
	        if (!soDT.matches(regex)) {
	        	 JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        	 return false;
	        }

        NhaCungCap ncc =new NhaCungCap();
        ncc.setTenNCC(tenNCC);
        ncc.setSoDT(soDT);
        ncc.setDiaChi(diaChi);
        boolean flag=nccdao.addNCC(ncc);
        if(flag) {
        	JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        	JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
       return flag; 
	}
	
	public boolean suaNCC(String maNCC,String tenNCC,String soDT, String diaChi ) {
		if(tenNCC.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy chọn nhà cung cấp này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		if(diaChi.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy nhập địa chỉ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		if(soDT.trim().equals("")) {
			 JOptionPane.showMessageDialog(null, "Hãy nhập số điện thoại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		
		String regex = "^0\\d{9,10}$";
        if (!soDT.matches(regex)) {
        	 JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        	 return false;
        }
        
        int ma=Integer.parseInt(maNCC);
        
        NhaCungCap ncc =new NhaCungCap();
        ncc.setMaNCC(ma);
        ncc.setTenNCC(tenNCC);
        ncc.setSoDT(soDT);
        ncc.setDiaChi(diaChi);
        boolean flag=nccdao.updateNCC(ncc);
        if(flag) {
        	JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        	JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
       return flag; 
	}
	
    public boolean xoaNCC(String ma) {
    	if (ma.trim().equals("")) {
   		 JOptionPane.showMessageDialog(null, "Chưa chọn nhà cung cấp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
   		 return false;
   	}
       int result = JOptionPane.showConfirmDialog(null, "Bạn chắn chắn muốn xoá?", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
       if (result != JOptionPane.YES_OPTION) {
			return false;
		}
            boolean flag = nccdao.deleteNCC(Integer.parseInt(ma));
            if (flag) {
                JOptionPane.showMessageDialog(null, "Xoá thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xoá thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            return flag;
       
    }
    
    
    public ArrayList<NhaCungCap> timNCC(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();
        for (NhaCungCap ncc : listncc) {
        	String ma = String.valueOf(ncc.getMaNCC());
            if (ncc.getTenNCC().toLowerCase().contains(tuKhoa) || ncc.getSoDT().toLowerCase().contains(tuKhoa)|| ma.contains(tuKhoa)) {
                dsncc.add(ncc);
            }
        }
        return dsncc;
    }
}
