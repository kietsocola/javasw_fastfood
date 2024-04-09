package BUS;
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
}
