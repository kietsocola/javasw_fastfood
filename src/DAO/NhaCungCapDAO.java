package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NhaCungCap;

public class NhaCungCapDAO {
	public ArrayList<NhaCungCap> getDanhSachNhaCungCap() {
        try {
            ArrayList<NhaCungCap> DSNCC = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap";
            PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
            ResultSet rs = prest.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("id"));
                ncc.setTenNCC(rs.getString("Ten"));
               
                DSNCC.add(ncc);
            }
            return DSNCC;
        } catch (SQLException ex) {
            return null;
        }
    }
	
}
