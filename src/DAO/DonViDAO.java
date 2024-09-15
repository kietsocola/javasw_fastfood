package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DonVi;

public class DonViDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<DonVi> getList() {
		ArrayList<DonVi> arrDonVi = new ArrayList<DonVi>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from DonVi";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					DonVi dv = new DonVi();
					dv.setMaDonVi(rs.getInt("maDonVi"));
					dv.setTenDonVi(rs.getString("tenDonVi"));
					arrDonVi.add(dv);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrDonVi;
	}
	public String getTenDonViByMaDonVi(int maDonVi) {
	    String name = "";
	    if (conDB.openConnectDB()) {
	        try {
	            String sql = "SELECT tenDonVi FROM DonVi WHERE maDonVi = ?";
	            PreparedStatement pstmt = conDB.conn.prepareStatement(sql);
	            pstmt.setInt(1, maDonVi);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) { 
	                name = rs.getString("tenDonVi");
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            conDB.closeConnectDB();
	        }
	    }
	    
	    return name;
	}
}
