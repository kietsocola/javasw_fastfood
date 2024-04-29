package BUS;
import java.util.ArrayList;

import DAO.NguyenLieuDAO;
import DTO.NguyenLieu;
public class NguyenLieuBUS {
	NguyenLieuDAO nlDAO = new NguyenLieuDAO();
	
	public NguyenLieu getNguyenLieubyId(int id) {
		try {
			NguyenLieu nl = nlDAO.getNguyenLieu(id);
			return nl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<NguyenLieu> getDSachNguyenLieu(){
		ArrayList<NguyenLieu> arr = new ArrayList<>();
		try {
			arr = nlDAO.getDanhSachNguyenLieu();
		} catch (Exception e) {
			arr = null;
			e.printStackTrace();
		}
		return arr;
	}
}
