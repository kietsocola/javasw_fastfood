package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhaCungCap;

public class NhaCungCapDAO {
	ConnectDB conDB = new ConnectDB();
	public ArrayList<NhaCungCap> getDanhSachNhaCungCap() {
		ArrayList<NhaCungCap> DSNCC = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try {
		           
	            String sql = "SELECT * FROM nhacungcap";
	            PreparedStatement prest =conDB.conn.prepareStatement(sql);	
	            ResultSet rs = prest.executeQuery(sql);
	            while (rs.next()) {
	                NhaCungCap ncc = new NhaCungCap();
	                
	                ncc.setMaNCC(rs.getInt(1));
	                ncc.setTenNCC(rs.getString(2));
	                ncc.setSoDT(rs.getString(3));
	                ncc.setDiaChi(rs.getString(4));
	                DSNCC.add(ncc);
	            }
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace(); 
	        } finally {
				conDB.closeConnectDB();
			}
		}
		return DSNCC;
    }
	public NhaCungCap getNhaCungCap(int MaNCC) {
        NhaCungCap ncc = null;
        if (conDB.openConnectDB()) {
            try {
                String sql = "SELECT * FROM nhacungcap WHERE id=?";
                PreparedStatement prest = conDB.conn.prepareStatement(sql);
                prest.setInt(1, MaNCC);
                ResultSet rs = prest.executeQuery(sql);
                while (rs.next()) {
                    ncc = new NhaCungCap();
                    ncc.setMaNCC(rs.getInt(1));
	                ncc.setTenNCC(rs.getString(2));
	                ncc.setSoDT(rs.getString(3));
	                ncc.setDiaChi(rs.getString(4));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            	conDB.closeConnectDB();
            }
        
        }
        return ncc;
	}
    public boolean addNCC(NhaCungCap ncc) {
        boolean result = false;
        if(conDB.openConnectDB()) {
        	try {
                String sql = "INSERT INTO nhacungcap(Ten, SoDienThoai, DiaChi)" 
                		+"VALUES(?,?,?)";
                PreparedStatement pre = conDB.conn.prepareStatement(sql);
                pre.setString(1, ncc.getTenNCC());
                pre.setString(2, ncc.getSoDT());
                pre.setString(3, ncc.getDiaChi());
                if(pre.executeUpdate() >=1)
    				result = true;
            } catch (SQLException ex) {
                
            } finally {
            	conDB.closeConnectDB();
            }
        }
        return result;
    }

    public boolean updateNCC(NhaCungCap ncc) {
    	boolean result = false;
        if (conDB.openConnectDB()) {
            try {
                String sql = "UPDATE nhacungcap SET Ten=?, SoDienThoai=?, DiaChi=? WHERE id=?";
                PreparedStatement pre = conDB.conn.prepareStatement(sql);
                pre.setString(1, ncc.getTenNCC());
                pre.setString(2, ncc.getSoDT());
                pre.setString(3, ncc.getDiaChi());
                pre.setInt(4, ncc.getMaNCC());
                result = pre.executeUpdate() > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                conDB.closeConnectDB();
            }
        }
        return result;
    }

    public boolean deleteNCC(int MaNCC) {
    	 boolean result = false;
    	    if (conDB.openConnectDB()) {
    	        try {
    	            String sql = "DELETE FROM nhacungcap WHERE id=?";
    	            PreparedStatement prep = conDB.conn.prepareStatement(sql);
    	            prep.setInt(1, MaNCC);
    	            result = prep.executeUpdate() > 0;
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();
    	        } finally {
    	            conDB.closeConnectDB();
    	        }
    	    }
    	    return result;
    }
	
}
