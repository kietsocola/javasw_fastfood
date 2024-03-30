package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.LoaiSanPham;

public class LoaiSpDAO {
public ArrayList<LoaiSanPham> getDanhSachLoai(){
		
		try {
			String sql = "SELECT * FROM loaisanpham";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <LoaiSanPham> DSLoaiSanPham = new ArrayList<>();
			while (rs.next()){
				LoaiSanPham lsp = new LoaiSanPham();
				
				lsp.setMaLoai(rs.getInt("idLoaiSP"));
				lsp.setTenLoaiSP(rs.getString("TenLoaiSP"));
				
				DSLoaiSanPham.add(lsp);
				
				
			}
			return DSLoaiSanPham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
