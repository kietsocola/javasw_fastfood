package BUS;
import java.util.ArrayList;

import DAO.CTPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhap;
public class ChiTietPhieuNhapBUS {
	ArrayList<ChiTietPhieuNhap> listCTPN = new ArrayList<>();
	CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
	PhieuNhapDAO pnDAO = new PhieuNhapDAO();
	public void addChiTietPhieuNhap(String maNL, String soLuong, String donGia, String thanhTien) {
		ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
		
		ctpn.setMaPN(pnDAO.getMaPhieuNhapMoiNhat()+1);
		ctpn.setMaNL(Integer.parseInt(maNL));
		ctpn.setSoLuong(Integer.parseInt(soLuong));
		ctpn.setDonGia(Integer.parseInt(donGia));
		ctpn.setThanhTien(Integer.parseInt(thanhTien));
		
		ctpnDAO.themCTPN(ctpn);
	}
	public ArrayList<ChiTietPhieuNhap> getListCTPNtheoIdPhieuNhap(int idPN){
		listCTPN = ctpnDAO.getCTPNtheoIdPN(idPN);
		return listCTPN;
	}
}
