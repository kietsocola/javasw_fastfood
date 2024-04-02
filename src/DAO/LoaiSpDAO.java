package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public LoaiSanPham getLoaiSanPham(int maLoai) {
		try {
			String sql = "SELECT *FROM loaisanpham WHERE idLoaiSP=?";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			prest.setInt(1, maLoai);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				LoaiSanPham lsp = new LoaiSanPham();
				
				lsp.setTenLoaiSP(rs.getString("TenLoaiSP"));
				
				return lsp;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
// thêm xóa sửa
	public boolean themLoaiSanPham(LoaiSanPham lsp) {
		try {
			String sql = "INSERT INTO loaisanpham(TenLoaiSP)"
					+ "VALUES (?)";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			
			prest.setString(1, lsp.getTenLoaiSP());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
    public boolean xoaLoaiSanPham(int maLoaiSP) {
        try {
            String sql = "DELETE FROM loaisanpham WHERE idLoaiSP=" + maLoaiSP;
            Statement st = ConnectDB.con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean suaLoaiSanPham(LoaiSanPham lsp) {
    	try {
			String sql = "UPDATE loaisanpham SET"
					+ "TenLoaiSP=?"
					+ "WHERE idLoaiSP=?";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			
			prest.setString(1, lsp.getTenLoaiSP());
			prest.setInt(2, lsp.getMaLoai());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	return false;
    }
}
