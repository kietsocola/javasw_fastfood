package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.LoaiSanPham;

public class LoaiSpDAO {
	ConnectDB conDB = new ConnectDB();
	public ArrayList<LoaiSanPham> getDanhSachLoai(){
		ArrayList <LoaiSanPham> DSLoaiSanPham = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT * FROM loaisanpham";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					LoaiSanPham lsp = new LoaiSanPham();
					
					lsp.setMaLoai(rs.getInt("idLoaiSP"));
					lsp.setTenLoaiSP(rs.getString("TenLoaiSP"));
					
					DSLoaiSanPham.add(lsp);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conDB.closeConnectDB();
			}
		}
		return DSLoaiSanPham;
	}
	public LoaiSanPham getLoaiSanPham(int maLoai) {
		LoaiSanPham lsp = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM loaisanpham WHERE idLoaiSP=?";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setInt(1, maLoai);
				ResultSet rs = prest.executeQuery();
				while (rs.next()) {
					 lsp= new LoaiSanPham();
					
					lsp.setTenLoaiSP(rs.getString("TenLoaiSP"));
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
			}finally {
				conDB.closeConnectDB();
			}
		}
		return lsp;
	}
// thêm xóa sửa
	public boolean themLoaiSanPham(LoaiSanPham lsp) {
		boolean result = false;
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "INSERT INTO loaisanpham(TenLoaiSP) VALUES (?)";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setString(1, lsp.getTenLoaiSP());
	            if (prest.executeUpdate() >= 1) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    return result;

	}
    public boolean xoaLoaiSanPham(int maLoaiSP) {
    	 boolean result = false;
    	    if (conDB.openConnectDB()) {
    	        try {
    	            String sql = "DELETE FROM loaisanpham WHERE idLoaiSP=?";
    	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
    	            prest.setInt(1, maLoaiSP);
    	            if (prest.executeUpdate() >= 1) {
    	                result = true;
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        } finally {
    	            conDB.closeConnectDB();
    	        }
    	    }
    	    return result;
    }
    public boolean suaLoaiSanPham(LoaiSanPham lsp) {
    	boolean result = false;
        if (conDB.openConnectDB()) {
            try {
                String sql = "UPDATE loaisanpham SET TenLoaiSP=? WHERE idLoaiSP=?";
                PreparedStatement prest = conDB.conn.prepareStatement(sql);
                prest.setString(1, lsp.getTenLoaiSP());
                prest.setInt(2, lsp.getMaLoai());
                if (prest.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conDB.closeConnectDB();
            }
        }
        return result;
    }
}
