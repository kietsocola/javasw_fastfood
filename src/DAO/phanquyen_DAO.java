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
			item.setTenPhanQuyen(result.getString(2));
			item.setNhaphang(result.getBoolean(3));
			item.setSanpham(result.getBoolean(4));
			item.setNhanvien(result.getBoolean(5));
			item.setKhachhang(result.getBoolean(6));
			item.setThongke(result.getBoolean(7));
			ds.add(item);
		}
		return ds;
	}
}
