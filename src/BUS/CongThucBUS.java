package BUS;

import java.util.ArrayList;

import DAO.CongThucDAO;
import DAO.NguyenLieuDAO;
import DTO.CongThuc;
import DTO.NguyenLieu;

public class CongThucBUS {
	CongThucDAO ctDAO = new CongThucDAO();
	NguyenLieuDAO nlDAO = new NguyenLieuDAO();

	public boolean addUpdate(int maNL, int soluong, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setSoLuongDung(soluong);
		ct.setIdSanPham(maSP);
		if (!ctDAO.checkExistingCongThuc(ct)) {
			return ctDAO.addCongThuc(ct);
		} else
			return ctDAO.updateCongThuc(ct);
	}

	public boolean deleteCongThuc(int maNL, int maSP) {
		CongThuc ct = new CongThuc();
		ct.setIdNguyenLieu(maNL);
		ct.setIdSanPham(maSP);
		return ctDAO.deleteCongThuc(maSP, maNL);
	}

	public boolean checkSoLuongNguyenLieuKhiCheBien(int maSP, int sl) {
		try {
			ArrayList<CongThuc> arr = ctDAO.getCongThuc_byIdSanPham(maSP);
			int maNL = 0;
			int slNL = 0;
			for (CongThuc x : arr) {
				maNL = x.getIdNguyenLieu();
				slNL = x.getSoLuongDung() * sl;
				NguyenLieu nl = nlDAO.getNguyenLieu(maNL);
				System.out.println(nl.getsoLuongNL() + " " + slNL);
				if (nl.getsoLuongNL() < slNL)
					return false;
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean giamSoLuongNguyenLieuKhiCheBien(int maSP, int sl) {
		try {
			boolean rs = false;
			ArrayList<CongThuc> arr = ctDAO.getCongThuc_byIdSanPham(maSP);
			int maNL = 0;
			int slNL = 0;
			for (CongThuc x : arr) {
				maNL = x.getIdNguyenLieu();
				slNL = x.getSoLuongDung() * sl;
				rs = nlDAO.suaSoLuongNguyenLieu(maNL, slNL);
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<CongThuc> getCongThucbyIdSanPham(int idSP) {

		try {
			ArrayList<CongThuc> dsct = new ArrayList<>();
			dsct = ctDAO.getCongThuc_byIdSanPham(idSP);
			return dsct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
