package BUS;

import DAO.CongThucDAO;
import DTO.CongThuc;

public class CongThucBUS {
	CongThucDAO ctDAO = new CongThucDAO();
	public boolean addCongThuc(int maNL, int soluong, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setSoLuongDung(soluong);
		ct.setIdSanPham(maSP);
		return ctDAO.addCongThuc(ct);
	}
	public boolean updateCongThuc(int maNL, int soluong, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setSoLuongDung(soluong);
		ct.setIdSanPham(maSP);
		return ctDAO.updateCongThuc(ct);
	}
}
