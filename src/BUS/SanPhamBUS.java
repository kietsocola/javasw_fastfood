package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.HoaDon;
import DTO.SanPham;

public class SanPhamBUS {
	private ArrayList<SanPham> listSP;
	private SanPhamDAO sanPhamDAO = new SanPhamDAO();
	public ArrayList<SanPham> getListSanPham(){
		listSP = sanPhamDAO.getListSanPham();
		return listSP;
	}
}
