package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.HoaDon;
import DTO.SanPham;

public class SanPhamBUS {
	private ArrayList<SanPham> listSP = null;
	private SanPhamDAO sanPhamDAO = new SanPhamDAO();
	public SanPhamBUS() {
		listSP = getListSanPham();
	}
	public ArrayList<SanPham> getListSanPham(){
		listSP = sanPhamDAO.getListSanPham();
		return listSP;
	}
	public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSP) {
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
                dssp.add(sp);
            }
        }
        return dssp;
    }
	public void tangSoLuongSP(int id, int sl) {
		try {
			sanPhamDAO.tangSoLuongSanPham(id, sl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
