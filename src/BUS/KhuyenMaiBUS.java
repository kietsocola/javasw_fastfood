package BUS;

import java.util.ArrayList;

import DTO.KhuyenMai;
import DAO.KhuyenMaiDAO;

public class KhuyenMaiBUS {
	private ArrayList<KhuyenMai> arrKM;
	private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
	
	public ArrayList<KhuyenMai> getListKhuyenMai(){
		arrKM = new ArrayList<>();
		try {
			arrKM = kmDAO.getListKhuyenMai();
		} catch (Exception e) {
			arrKM = null;
			e.printStackTrace();
		}
		return arrKM;
	}
	public void addKhuyenMai(String tenKM, int pt) {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM(tenKM);
		km.setPhanTramKM(pt);
		try {
			kmDAO.addKhuyenMai(km);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean updateKhuyenMai(String tenKM, int pt, int maKM) {
		KhuyenMai km = new KhuyenMai();
		km.setMaKM(maKM);
		km.setTenKM(tenKM);
		km.setPhanTramKM(pt);
		try {
			boolean rs = kmDAO.updateKhuyenMai(km);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public KhuyenMai getKhuyenMaiById(int id) {
		KhuyenMai km = new KhuyenMai();
		try {
			km = kmDAO.getKhuyenMaiById(id);
		} catch (Exception e) {
			e.printStackTrace();
			km = null;
		}
		return km;
	}
}
