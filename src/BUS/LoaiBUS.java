package BUS;
import java.util.ArrayList;

import DAO.LoaiSpDAO;
import DTO.LoaiSanPham;
public class LoaiBUS {
	private ArrayList<LoaiSanPham> ListLoaiSP = null;
	private LoaiSpDAO loaiDAO = new LoaiSpDAO();
	
	public ArrayList<LoaiSanPham> getListLoaiSP(){
		if (ListLoaiSP == null) {
			docListLoaiSP();
		}
		return ListLoaiSP;
	}
	public void docListLoaiSP() {
		ListLoaiSP = loaiDAO.getDanhSachLoai();
	}
	public LoaiBUS() {
		docListLoaiSP();
	}
}
