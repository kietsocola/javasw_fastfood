package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;

public class PhieuNhapBUS {
	private ArrayList<PhieuNhap> listPN;
	private PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
	
	public ArrayList<PhieuNhap> getListPhieuNhap(){
		listPN = phieuNhapDAO.getDanhSachPhieuNhap();
		return listPN;
	}
	public void luuPhieuNhap( int maNV, int maNCC,int TongTien ) {
		PhieuNhap pn = new PhieuNhap();
		
		pn.setMaNV(1);
		pn.setMaNCC(maNCC);
		Date currentDate = new Date();
		pn.setNgayLap(currentDate);
		pn.setTongTien(TongTien);
		
		phieuNhapDAO.themPhieuNhap(pn);
	}
}
