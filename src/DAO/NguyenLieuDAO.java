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
		ArrayList <NguyenLieu> DSNguyenLieu = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM nguyenlieu";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					NguyenLieu nl = new NguyenLieu();

					nl.setMaNguyenLieu(rs.getInt("id"));
					nl.setTenNL(rs.getString("Ten"));
					nl.setsoLuongNL(rs.getInt("SoLuong"));
					
					DSNguyenLieu.add(nl);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return DSNguyenLieu;
	}
	// thêm xóa sửa + lấy nguyên liệu
	public NguyenLieu getNguyenLieu (int maNL) {
		NguyenLieu nl = null;
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM nguyenlieu WHERE id=?";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setInt(1, maNL);
				ResultSet rs = prest.executeQuery();
				while (rs.next()) {
					 nl = new NguyenLieu();
					
					nl.setTenNL(rs.getString("Ten"));
					nl.setsoLuongNL(rs.getInt("SoLuong"));
					
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				conDB.closeConnectDB();
			}
		}
		return nl;
	}
	public boolean themNguyenLieu (NguyenLieu nl) {
		 boolean result = false;
		    if (conDB.openConnectDB()) {
		        try {
		            String sql = "INSERT INTO nguyenlieu(Ten, SoLuong, DonGiaNL) VALUES (?, ?, ?)";
		            PreparedStatement prest = conDB.conn.prepareStatement(sql);
		            prest.setString(1, nl.getTenNL());
		            prest.setInt(2, nl.getsoLuongNL());
		            prest.setInt(3, nl.getDonGiaNL());
		            if(prest.executeUpdate() >=1)
						result = true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            conDB.closeConnectDB();
		        }
		    }
		    return result;
	}
	public boolean xoaNguyenLieu(int maNL) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "DELETE FROM nguyenlieu WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setInt(1, maNL);
	            result =prest.executeUpdate() >0;
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
    }
	public boolean suaNguyenLieu(NguyenLieu nl) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE nguyenlieu SET Ten=?, SoLuong=?,DonGiaNL, WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setString(1, nl.getTenNL());
	            prest.setInt(2, nl.getsoLuongNL());
	            prest.setInt(3, nl.getDonGiaNL());
	            prest.setInt(4, nl.getMaNguyenLieu());
	            result = prest.executeUpdate()>0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
	public boolean suaSoLuongNguyenLieu(int id, int soluong) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE nguyenlieu SET SoLuong=SoLuong-? WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setInt(1, soluong);
	            prest.setInt(2, id);
	            result = prest.executeUpdate()>0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
}