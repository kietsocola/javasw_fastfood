package DAO;

import java.sql.Connection;
import DTO.phanquyen_DTO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class phanquyen_DAO {
	connectDatabase con = new connectDatabase();
	public ArrayList<phanquyen_DTO> getData() throws SQLException {
		con.connect();
		ArrayList<phanquyen_DTO> ds = new ArrayList<>();
		
		String sql = "select * from phanquyen";
		Statement stmt =   con.getCon().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		while(result.next()) {
			phanquyen_DTO item = new phanquyen_DTO();
			item.setIdPhanQuyen(result.getInt(1));
			item.setTenPhanQuyen(result.getString(2));
			item.setNhaphang(result.getBoolean(3));
			item.setSanpham(result.getBoolean(4));
			item.setNhanvien(result.getBoolean(5));
			item.setKhachhang(result.getBoolean(6));
			item.setThongke(result.getBoolean(7));
			ds.add(item);
		}
		con.close();
		return ds;
	}
	
	public void insertPhanQuyen(phanquyen_DTO phanquyen) {
		con.connect();
		String sql ;
		try {
				sql = "INSERT INTO phanquyen (`id`, `TenQuyen`, `NhapHang`, `SanPham`, `NhanVien`, `KhachHang`, `ThongKe`) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.getCon().prepareStatement(sql);
				pstmt.setInt(1,phanquyen.getIdPhanQuyen());
				pstmt.setString(2, phanquyen.getTenPhanQuyen());
				pstmt.setBoolean(3, phanquyen.getNhaphang());
				pstmt.setBoolean(4, phanquyen.getSanpham());
				pstmt.setBoolean(5, phanquyen.getNhanvien());
				pstmt.setBoolean(6, phanquyen.getKhachhang());
				pstmt.setBoolean(7, phanquyen.getThongke());
				int index = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updatePhanQuyen(phanquyen_DTO item) {
		con.connect();
		try {
				int index;
				String sql = "update phanquyen set TenQuyen=? , NhapHang=? , SanPham=? , NhanVien=? , KhachHang=? , ThongKe=? where id=?";
				PreparedStatement pstmt = con.getCon().prepareStatement(sql);
				pstmt.setInt(7,item.getIdPhanQuyen());
				pstmt.setString(1, item.getTenPhanQuyen());
				pstmt.setBoolean(2, item.getNhaphang());
				pstmt.setBoolean(3, item.getSanpham());
				pstmt.setBoolean(4, item.getNhanvien());
				pstmt.setBoolean(5, item.getKhachhang());
				pstmt.setBoolean(6, item.getThongke());
				index = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
	}
	
	public void deletePhanQuyen(phanquyen_DTO item) {
		con.connect();
		try {
			int index;
			String sql = "delete from phanquyen where id = ?";
			PreparedStatement pstmt = con.getCon().prepareStatement(sql);
			pstmt.setInt(1,item.getIdPhanQuyen());
			index = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
