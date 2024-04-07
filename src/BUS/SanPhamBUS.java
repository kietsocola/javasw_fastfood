package BUS;
import DAO.SanPhamDAO;
import DTO.SanPham;
import java.util.ArrayList;
public class SanPhamBUS {
	private ArrayList<SanPham> DSSanPham = null;
	private SanPhamDAO spDAO = new SanPhamDAO();
	
	public ArrayList<SanPham> getDSSanPham() {
		if(DSSanPham == null) {
			docListSanPham();
		}
		return DSSanPham;
	}
	public void docListSanPham() {
	    DSSanPham = spDAO.getDanhSachSanPham();
	}
	public SanPhamBUS(){
		docListSanPham();
	}
	
}

