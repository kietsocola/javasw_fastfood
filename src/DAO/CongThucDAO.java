package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CongThuc;

public class CongThucDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<CongThuc> getListCongThuc() {
		ArrayList<CongThuc> arrCongThuc = new ArrayList<CongThuc>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from CongThuc";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					CongThuc ct = new CongThuc();
					ct.setid(rs.getInt("id"));
					ct.setIdNguyenLieu(rs.getInt("idNguyenLieu"));
					ct.setIdSanPham(rs.getInt("idSanPham"));
					ct.setSoLuongDung(rs.getInt("SoLuongDung"));
					arrCongThuc.add(ct);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrCongThuc;
	}

	public ArrayList<CongThuc> getCongThuc_byIdSanPham(int idSP) {
		ArrayList<CongThuc> arrCongThuc = new ArrayList<CongThuc>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from CongThuc where idSanPham = " + idSP;
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					CongThuc ct = new CongThuc();
					ct.setid(rs.getInt("id"));
					ct.setIdNguyenLieu(rs.getInt("idNguyenLieu"));
					ct.setIdSanPham(rs.getInt("idSanPham"));
					ct.setSoLuongDung(rs.getInt("SoLuongDung"));
					arrCongThuc.add(ct);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}
		}
		return arrCongThuc;
	}
	public boolean addCongThuc(CongThuc congThuc) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "INSERT INTO CongThuc(idNguyenLieu, idSanPham, SoLuongDung) VALUES (?, ?, ?)";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setInt(1, congThuc.getIdNguyenLieu());
	            prep.setInt(2, congThuc.getIdSanPham());
	            prep.setInt(3, congThuc.getSoLuongDung());
	            if (prep.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
	public boolean updateCongThuc(CongThuc congThuc) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE CongThuc set SoLuongDung=? where idNguyenLieu=? ";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setInt(1, congThuc.getSoLuongDung());
	            prep.setInt(2, congThuc.getIdNguyenLieu());
	            if (prep.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}
//	public boolean updateCongThuc(CongThuc congThuc) {
//	    boolean result = false;
//	    if (conDB.openConnectDB()) {
//	        try {
//	            String sql = "UPDATE CongThuc SET idNguyenLieu = ?, SoLuongDung = ? WHERE id = ?";
//	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
//	            prep.setInt(1, congThuc.getIdNguyenLieu());
//	            prep.setInt(2, congThuc.getSoLuongDung());
//	            prep.setInt(3, congThuc.getid());
//	            if (prep.executeUpdate() >= 1)
//	                result = true;
//	        } catch (SQLException ex) {
//	            System.out.println(ex);
//	        } finally {
//	            conDB.closeConnectDB();
//	        }
//	    }
//	    return result;
//	}
	public boolean deleteCongThuc(int id) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "DELETE FROM CongThuc WHERE id = ?";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setInt(1, id);
	            if (prep.executeUpdate() >= 1)
	                result = true;
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;
	}


}
