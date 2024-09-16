package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CongThuc;
import DTO.NguyenLieu;

public class CongThucDAO {
	ConnectDB conDB = new ConnectDB();
	SanPhamDAO spDAO = new SanPhamDAO();
	NguyenLieuDAO nlDAO = new NguyenLieuDAO();
	public ArrayList<CongThuc> getListCongThuc() {
		ArrayList<CongThuc> arrCongThuc = new ArrayList<CongThuc>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from CongThuc where isDelete=0";
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
				String sql = "Select * from CongThuc where isDelete=0 and idSanPham = " + idSP;
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
	            if (prep.executeUpdate() >= 1) {
	                result = true;
	                int idSP = congThuc.getIdSanPham();
	                int giaMoi = 0;
	                ArrayList<CongThuc> listCT = this.getCongThuc_byIdSanPham(idSP);
	                for(CongThuc ct : listCT) {
	                	NguyenLieu nl = nlDAO.getNguyenLieu(ct.getIdNguyenLieu());
	                	System.out.println("đon gia nl: "+nl.getDonGiaNL());
	                	System.out.println("so luong: "+ct.getSoLuongDung());
	                	giaMoi += nl.getDonGiaNL()*ct.getSoLuongDung();
	                	System.out.println(giaMoi);
	                }
	                giaMoi = (giaMoi + giaMoi*100/70);
	                System.out.println(giaMoi);
                	spDAO.updateGiaSanPham(idSP, giaMoi);
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    
	    return result;
	}
	public boolean checkExistingCongThuc(CongThuc congThuc) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "SELECT COUNT(*) FROM CongThuc WHERE isDelete=0 and idNguyenLieu = ? AND idSanPham = ?";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setInt(1, congThuc.getIdNguyenLieu());
	            prep.setInt(2, congThuc.getIdSanPham());
	            ResultSet rs = prep.executeQuery();
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                if (count > 0)
	                    result = true; // Công thức đã tồn tại
	            }
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
	public boolean deleteCongThuc(int maSP, int maNL) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "UPDATE congthuc SET isDelete=1 WHERE idNguyenLieu = ? and idSanPham=?";
	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
	            prep.setInt(1, maNL);
	            prep.setInt(2, maSP);
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
	
	public boolean updateTrangThaiSPbyNL(int idSP) {
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "select * from congthuc as ct, nguyenlieu as nl where ct.idSanPham = " + idSP + " and ct.idNguyenLieu = nl.id ";
//	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
//	            prep.setInt(1, idSP);
//	            if (prep.executeUpdate() >= 1)
//	            {
//	            	
//	            }
	            Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					if(rs.getInt("TrangThai") == 0)
						return false ;
				}
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return true;
	}
}
