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
		
	
	 private ArrayList<taiKhoan_DTO> listTK = null;
	 
	 public void docDanhSach() {
		 taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
	        this.listTK = taikhoandao.getDSTaiKhoan();
	    }
	 
	 public ArrayList<taiKhoan_DTO> getDanhSachTaiKhoan() {
	        if (this.listTK == null)
	            this.docDanhSach();
	        return this.listTK;
	    }
	    
		public int idTaiKhoanMax() {
			taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
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
	
	
	
	public int getTrangThai(String id) {
		taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
		return taikhoandao.getTrangThai(Integer.parseInt(id));
	}
	
	public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
		taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
        return taikhoandao.kiemTraTrungTenDangNhap(tenDangNhap);
    }
	
	public boolean suaTaiKhoan(int id,String tenDangNhap,String matKhau, int quyen) {
		taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
        if (tenDangNhap.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        if (matKhau.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        

        taiKhoan_DTO tk= new taiKhoan_DTO();
        
        Date ngayHienTai = new Date();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = dateFormat.format(ngayHienTai);
        tk.setMa(id);
        tk.setNgayTao(ngayTao);
        tk.setTenTaiKhoan(tenDangNhap);
        tk.setMatKhau(matKhau);
        tk.setQuyen(quyen);
        boolean flag = taikhoandao.suaTaiKhoan(tk);

        return flag;
    }
	
	
	public boolean themTaiKhoan( String tenDangNhap,String matKhau, int quyen) {
		taiKhoan_DAO taikhoandao = new taiKhoan_DAO();
        if (tenDangNhap.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        if (matKhau.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
        if (kiemTraTrungTenDangNhap(tenDangNhap)) {
        	JOptionPane.showMessageDialog(null, "Tên đăng nhập bị trùng!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
        
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
//        if (flag) {
//        	JOptionPane.showMessageDialog(null, "Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//           
//        } else {
//        	JOptionPane.showMessageDialog(null, "Cấp tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
        return flag;
    }
}
