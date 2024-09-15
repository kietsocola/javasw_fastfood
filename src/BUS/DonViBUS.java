package BUS;

import java.util.ArrayList;

import DAO.DonViDAO;
import DTO.DonVi;

public class DonViBUS {
	private DonViDAO donViDAO = new DonViDAO();
	public ArrayList<DonVi> getDSDonVi() {
		ArrayList<DonVi> arr = donViDAO.getList();
		return arr;
	}
	public String getTenDonViByMaDonViBUS(int maDonVi) {
		return donViDAO.getTenDonViByMaDonVi(maDonVi);
	}
}
