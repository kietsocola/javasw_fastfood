package BUS;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.phanquyen_DAO;
import DTO.phanquyen_DTO;


public class phanquyen_BUS {
	phanquyen_DAO temp = new phanquyen_DAO();
	
	
	public ArrayList<phanquyen_DTO> getData() throws SQLException{
		return temp.getData();
	}
	public int hasPhanQuyen(String name) throws SQLException {
		
		for(phanquyen_DTO pq : getData()) {
			if(pq.getTenPhanQuyen().equals(name))
			return 1;
		}
		return 0;
	}
	
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
	
	public	ArrayList<Boolean> loaiPhanQuyen(int idPhanQuyen) throws SQLException{
		return temp.getLoaiPhanQuyen(idPhanQuyen);
	}
	
}
