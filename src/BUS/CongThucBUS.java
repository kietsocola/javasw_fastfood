package BUS;

import DAO.CongThucDAO;
import DTO.CongThuc;

public class CongThucBUS {
	CongThucDAO ctDAO = new CongThucDAO();
	public boolean addUpdate(int maNL, int soluong, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setSoLuongDung(soluong);
		ct.setIdSanPham(maSP);
		if(!ctDAO.checkExistingCongThuc(ct)) {
			return ctDAO.addCongThuc(ct);
		} else return ctDAO.updateCongThuc(ct);
	}
	public boolean deleteCongThuc(int maNL, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setIdSanPham(maSP);
		return ctDAO.deleteCongThuc(maSP, maNL);
	}
}
