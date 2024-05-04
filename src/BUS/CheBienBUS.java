package BUS;
import java.util.ArrayList;

import DAO.CongThucDAO;
import DAO.NguyenLieuDAO;
import DTO.CongThuc;
public class CheBienBUS {
	CongThucDAO ctDAO = new CongThucDAO();
	NguyenLieuDAO nlDAO = new NguyenLieuDAO();
	ArrayList<CongThuc> dsct = new ArrayList<>();
	public ArrayList<CongThuc> getCongThucbyIdSanPham(int idSP) {
		
		try {
			dsct = ctDAO.getCongThuc_byIdSanPham(idSP);
			return dsct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean giamSoLuongNLkhiCheBien(int id, int slNL) {
		try {
			return nlDAO.suaSoLuongNguyenLieu(id, slNL);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
