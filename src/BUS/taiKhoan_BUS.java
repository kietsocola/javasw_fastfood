package BUS;

import java.sql.SQLException;

import DAO.taiKhoan_DAO;
import DTO.taiKhoan_DTO;

public class taiKhoan_BUS {
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
}
