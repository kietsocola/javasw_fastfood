package BUS;
import DAO.phanquyen_DAO;
import DTO.phanquyen_DTO;


public class phanquyen_BUS {
	phanquyen_DAO temp = new phanquyen_DAO();
	
	public String themPhanQuyen(phanquyen_DTO item) {
		
		if(temp.hasNamePhanQuyen(item))
			return "ten phan quyen da ton tai";
		
		if(temp.insertPhanQuyen(item))
			return "them thanh cong";
		return "them that bai";
	}
	
	public String suaPhanQuyen(phanquyen_DTO item) {
		
		if(temp.hasNamePhanQuyen(item))
			return "ten phan quyen da ton tai";
		if(temp.updatePhanQuyen(item))
			return "sua thanh cong";
		return "sua that bai";
	}
	
	public String xoaPhanQuyen(phanquyen_DTO item) {
		
		if(temp.deletePhanQuyen(item))
			return "xoa thanh cong";
		return "xoa that bai";
	}
	
}
