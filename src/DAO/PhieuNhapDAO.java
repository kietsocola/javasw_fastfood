package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PhieuNhap;


public class PhieuNhapDAO {
public ArrayList<PhieuNhap> getDanhSachPhieuNhap(){
		
		try {
			String sql = "SELECT * FROM sanpham";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <PhieuNhap> DSPhieuNhap = new ArrayList<>();
			while (rs.next()){
				PhieuNhap pn = new PhieuNhap();
				
				pn.setMaPN(rs.getInt("id"));
				pn.setMaNCC(rs.getInt("idNhaCC"));
				pn.setTongTien(rs.getInt("TongTien"));
				pn.setNgayLap(rs.getDate("NgayLap"));
				pn.setMaNV(rs.getInt("idNhanVien"));
			
				DSPhieuNhap.add(pn);
				
				
			}
			return DSPhieuNhap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
