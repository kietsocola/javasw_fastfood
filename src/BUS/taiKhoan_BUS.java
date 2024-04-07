package BUS;

import java.sql.SQLException;

import DAO.taiKhoan_DAO;
import DTO.taiKhoan_DTO;

public class taiKhoan_BUS {
	public String checkDangNhap(taiKhoan_DTO account) throws SQLException {
		taiKhoan_DAO check = new taiKhoan_DAO();
		if(account.getTenTaiKhoan().equals("") || account.getMatKhau().equals(""))
			return "vui long nhap day du thong tin";
		if(check.checkStatus(account) == 0)
			return check.getTen(account);
		return "ten dang nhap hoac mat khau sai" ;
	}
}
