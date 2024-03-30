package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import DTO.SanPham;
public class SanPhamDAO {
	
	public ArrayList<SanPham> getDanhSachSanPham(){
		
		try {
			String sql = "SELECT * FROM sanpham";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <SanPham> DSSanPham = new ArrayList<>();
			while (rs.next()){
				SanPham sp = new SanPham();
				
				sp.setMaSP(rs.getInt("id"));
				sp.setMaLoai(rs.getInt("idLoaiSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setDonGia(rs.getInt("DonGia"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setMaCongThuc(rs.getInt("idCongThuc"));
				
				DSSanPham.add(sp);
				
				
			}
			return DSSanPham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
