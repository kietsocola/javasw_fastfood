package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
import DAO.LoaiSpDAO;
import DTO.HoaDon;
import DTO.LoaiSanPham;
import DTO.SanPham;

public class SanPhamBUS {
	private ArrayList<SanPham> listSP = null;
	private SanPhamDAO sanPhamDAO = new SanPhamDAO();
	private LoaiSpDAO loaiSPDAO = new LoaiSpDAO();
	public SanPhamBUS() {
		docListSanPham();
	}
	public ArrayList<SanPham> getListSanPham(){
		listSP = sanPhamDAO.getListSanPham();
		return listSP;
	}
	public ArrayList<LoaiSanPham> getListLoaiSanPham(){
		ArrayList<LoaiSanPham> lsp = loaiSPDAO.getDanhSachLoai();
		return lsp;
	}
	public ArrayList<SanPham> getSanPhamTheoTenVaLoai(String ten, int maLoai) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSP) {
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.toLowerCase().contains(ten.toLowerCase()) && sp.getIdLoaiSP()==maLoai) {
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
	public void docListSanPham() {
		listSP = sanPhamDAO.getListSanPham();
	}
}
