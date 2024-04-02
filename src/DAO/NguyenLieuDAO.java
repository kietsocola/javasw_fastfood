package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NguyenLieu;

public class NguyenLieuDAO {
	public ArrayList<NguyenLieu> getDanhSachNguyenLieu(){
		
		try {
			String sql = "SELECT * FROM nguyenlieu";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <NguyenLieu> DSNguyenLieu = new ArrayList<>();
			while (rs.next()){
				NguyenLieu nl = new NguyenLieu();

				nl.setMaNguyenLieu(rs.getInt("id"));
				nl.setTenNL(rs.getString("Ten"));
				nl.setsoLuongNL(rs.getInt("SoLuong"));
				
				DSNguyenLieu.add(nl);
				
				
			}
			return DSNguyenLieu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// thêm xóa sửa + lấy nguyên liệu
}
