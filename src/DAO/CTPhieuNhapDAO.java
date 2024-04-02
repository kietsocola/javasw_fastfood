package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhap;

public class CTPhieuNhapDAO {
public ArrayList<ChiTietPhieuNhap> getDanhSachCTPhieuNhap(){
		
		try {
			String sql = "SELECT * FROM sanpham";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <ChiTietPhieuNhap> DSCTPhieuNhap = new ArrayList<>();
			while (rs.next()){
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
				
				ctpn.setMaNL(rs.getInt("idNguyenLieu"));
				ctpn.setMaPN(rs.getInt("idPhieuNhap"));
				ctpn.setDonGia(rs.getInt("DonGia"));
				ctpn.setThanhTien(rs.getInt("ThanhTien"));
			
				DSCTPhieuNhap.add(ctpn);
				
				
			}
			return DSCTPhieuNhap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
// thêm xóa sửa
}
