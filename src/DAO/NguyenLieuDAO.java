package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NguyenLieu;

public class NguyenLieuDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<NguyenLieu> getDanhSachNguyenLieu(){
		
		try {
			String sql = "SELECT * FROM nguyenlieu";
			PreparedStatement prest =conDB.conn.prepareStatement(sql);	
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
	public NguyenLieu getNguyenLieu (int maNL) {
		try {
			String sql = "SELECT *FROM nguyenlieu WHERE id=?";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			prest.setInt(1, maNL);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				NguyenLieu nl = new NguyenLieu();
				
				nl.setTenNL(rs.getString("Ten"));
				nl.setsoLuongNL(rs.getInt("SoLuong"));
				
				return nl;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean themNguyenLieu (NguyenLieu nl) {
		try {
			String sql = "INSET INTO nguyenlieu(Ten, SoLuong)"
					+ "VALUE (?,?)";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			
			prest.setString(1, nl.getTenNL());
			prest.setInt(2, nl.getsoLuongNL());
			
			prest.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean xoaNguyenLieu(int maNL) {
        try {
            String sql = "DELETE FROM nguyenlieu WHERE id=" + maNL;
            Statement st = conDB.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
	public boolean suaNguyenLieu(NguyenLieu nl) {
		try {
			String sql = "UPDATE nguyenlieu SET"
					+ "Ten=?, SoLuong=? "
					+ "WHERE id=?";
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			
			prest.setString(1, nl.getTenNL());
			prest.setInt(2, nl.getsoLuongNL());
			prest.setInt(3, nl.getMaNguyenLieu());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
}
