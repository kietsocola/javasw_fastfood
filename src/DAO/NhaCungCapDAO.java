package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public NhaCungCap getNhaCungCap(int MaNCC) {
        NhaCungCap ncc = null;
        try {
            String sql = "SELECT * FROM nhacungcap WHERE id=" + MaNCC;
            Statement stmt = ConnectDB.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("id"));
                ncc.setTenNCC(rs.getString("Ten"));

            }
        } catch (SQLException ex) {
            return null;
        }
        return ncc;
    }

    public boolean addNCC(NhaCungCap ncc) {
        boolean result = false;
        try {
            String sql = "INSERT INTO nhacungcap VALUES(?,?)";
            PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
            prest.setInt(1, ncc.getMaNCC());
            prest.setString(2, ncc.getTenNCC());
            result = prest.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateNCC(NhaCungCap ncc) {
        boolean result = false;
        try {
            String sql = "UPDATE nhacungcap SET Ten=? WHERE id=?";
            PreparedStatement prep = ConnectDB.con.prepareStatement(sql);
            prep.setString(1, ncc.getTenNCC());
            prep.setInt(2, ncc.getMaNCC());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean deleteNCC(int MaNCC) {
        boolean result = false;
        try {
            String sql = "DELETE FROM nhacungcap WHERE id=" + MaNCC;
            Statement stmt = ConnectDB.con.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
	
}
