package BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.ConnectDB;
import DAO.taiKhoan_DAO;
import DTO.taiKhoan_DTO;

public class taiKhoan_BUS {
	private taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
	
	 private ArrayList<taiKhoan_DTO> listTK = null;
	 
	 public void docDanhSach() {
	        this.listTK = taikhoandao.getDSTaiKhoan();
	    }
	 
	 public ArrayList<taiKhoan_DTO> getDanhSachTaiKhoan() {
	        if (this.listTK == null)
	            this.docDanhSach();
	        return this.listTK;
	    }
	    
		public int idTaiKhoanMax() {
			return taikhoandao.idTaiKhoanMax();
		}
	 
	public int checkDangNhap(taiKhoan_DTO account) throws SQLException {
		taiKhoan_DAO check = new taiKhoan_DAO();
		if(account.getTenTaiKhoan().equals("") || account.getMatKhau().equals(""))
			return 0;
		if(check.checkStatus(account) == 1 && check.checkAccount(account) == true)
			return 1;
		return 2 ;
	}
	
	public int IdPhanQuyen(taiKhoan_DTO account) throws SQLException {
		taiKhoan_DAO check = new taiKhoan_DAO();
		return check.getIdPhanQuyen(account);	
	}
	
	public int idTaiKhoan(taiKhoan_DTO account) throws SQLException {
		taiKhoan_DAO check = new taiKhoan_DAO();
		return check.getId(account);	
	}
	
	
	
	public int getTrangThai(int id) {
		return taikhoandao.getTrangThai(id);
	}
	
	public String getTenDangNhap(int id) {
		return taikhoandao.getTenDangNhap(id);
	}
	
	public String getMatKhau(int id) {
		return taikhoandao.getMatKhau(id);
	}
	
	public String getTenQuyen(int id) {
		return taikhoandao.getTenQuyen(id);
	}
	
	 public boolean setTrangThai(int ma, int trangThai) {
	        
	        if (taikhoandao.setTrangThai(ma,trangThai)) {
	            JOptionPane.showMessageDialog(null, "Sửa trạng thái thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Sửa trạng thái thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	        return taikhoandao.setTrangThai(ma, trangThai);
	    }
	
	public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taikhoandao.kiemTraTrungTenDangNhap(tenDangNhap);
    }
	
	
	public boolean kiemTraTaiKhoan(String tenDangNhap,String matKhau) {
		if (tenDangNhap.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
		
		 if (kiemTraTrungTenDangNhap(tenDangNhap)) {
	        	JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
	            return false;
	        }
        
        if (matKhau.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        String regex2 = ".*\\d.*";
        if (!matKhau.trim().matches(regex2)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu ít nhất 1 kí tự chữ và số", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }

        String regex = "^[a-zA-Z0-9!@#$%^&*-_]{8,}$";
        if (!matKhau.trim().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu ít nhất 8 kí tự và chỉ chứa kí tự đặc biệt(!@#$%^&*-_)!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        return true;
	}
	
	public boolean kiemTraTaiKhoan2(String tenDangNhap,String matKhau) {
		if (tenDangNhap.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        if (matKhau.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        String regex2 = ".*\\d.*";
        if (!matKhau.trim().matches(regex2)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu ít nhất 1 kí tự số", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }

        String regex = "^[a-zA-Z0-9!@#$%^&*-_]{8,}$";
        if (!matKhau.trim().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu ít nhất 8 kí tự và chỉ chứa kí tự đặc biệt(!@#$%^&*-_)!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
       
        return true;
	}
	
	public boolean suaTaiKhoan(int id,String tenDangNhap,String matKhau, int quyen) {
        taiKhoan_DTO tk= new taiKhoan_DTO();
        
        tk.setMa(id);
        tk.setTenTaiKhoan(tenDangNhap);
        tk.setMatKhau(matKhau);
        tk.setQuyen(quyen);
        boolean flag = taikhoandao.suaTaiKhoan(tk);

        return flag;
    }
	
	
	public boolean themTaiKhoan( String tenDangNhap,String matKhau, int quyen) {

		
        taiKhoan_DTO tk= new taiKhoan_DTO();
        
        Date ngayHienTai = new Date();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = dateFormat.format(ngayHienTai);

        tk.setNgayTao(ngayTao);
        tk.setTenTaiKhoan(tenDangNhap);
        tk.setMatKhau(matKhau);
        tk.setTrangThai(1);
        tk.setQuyen(quyen);
        boolean flag = taikhoandao.themTaiKhoan(tk);

        return flag;
    }
	
    public boolean xoaTaiKhoan(int ma) {
        boolean flag = taikhoandao.deleteTaiKhoan(ma);
            return flag;  
    }
}
