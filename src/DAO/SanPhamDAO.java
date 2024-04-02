package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import DTO.SanPham;
public class SanPhamDAO {
	
	public ArrayList<SanPham> getDanhSachSanPham(){
		
		try {
			String sql = "SELECT *FROM sanpham";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <SanPham> DSSanPham = new ArrayList<>();
			while (rs.next()){
				SanPham sp = new SanPham();
				
				sp.setMaSP(rs.getInt("id"));
				sp.setMaLoai(rs.getInt("idLoaiSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setDonGia(rs.getInt("DonGia"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setMaCongThuc(rs.getInt("idCongThuc"));
				
				DSSanPham.add(sp);
				
				
			}
			return DSSanPham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public SanPham getSanPham(int ma) { // Lay san pham dua theo maSp
		try {
			String sql = "SELECT *FROM sanpham WHERE id=?";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			prest.setInt(1, ma);
			ResultSet rs = prest.executeQuery();
			while (rs.next()){
				SanPham sp = new SanPham();
				
				sp.setMaSP(rs.getInt("id"));
				sp.setMaLoai(rs.getInt("idLoaiSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setDonGia(rs.getInt("DonGia"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setMaCongThuc(rs.getInt("idCongThuc"));				
				
				return sp;
			}
			
		} catch (SQLException e) {
			
		}
		return null;
	}
	public ArrayList<SanPham> getSanPhamTheoLoai (int maLoai){
		try {
			String sql = "SELECT *FROM sanpham WHERE idLoaiSP=?";
			PreparedStatement prest =ConnectDB.con.prepareStatement(sql);	
			ResultSet rs = prest.executeQuery();
			ArrayList <SanPham> DSSanPhamTheoLoai = new ArrayList<>();
			while (rs.next()){
				SanPham sp = new SanPham();
				
				sp.setMaSP(rs.getInt("id"));
				sp.setMaLoai(rs.getInt("idLoaiSP"));
				sp.setTenSP(rs.getString("TenSP"));
				sp.setDonGia(rs.getInt("DonGia"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setMaCongThuc(rs.getInt("idCongThuc"));
				
				DSSanPhamTheoLoai.add(sp);
				
				
			}
			return DSSanPhamTheoLoai;
		} catch (SQLException e) {
	
		}
		return null;
	}
	public String getAnh(int ma) {
		try {
			String sql = "SELECT HinhAnh FORM sanpham WHERE id=?";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			prest.setInt(1, ma);
			ResultSet rs = prest.executeQuery();
			if(rs.next()) {
				return rs.getString("HinhAnh");
			}
			
		} catch (SQLException e) {
			
		}
		return "";
		
	}
	public void capNhatSoLuongSp(int ma, int soLuongMa) {
		SanPham sp = getSanPham(ma);
		int soLuong = sp.getSoLuong();
		sp.setSoLuong(soLuong + soLuongMa);
		try {
			String sql = "UPDATE sanpham SET SoLuong=? WHERE id=" + ma;
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			prest.setInt(1, sp.getSoLuong());
			prest.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public boolean themSanPham(SanPham sp) {
		try {
			String sql = "INSERT INTO sanpham(TenSP, idLoaiSP,SoLuong,idCongThuc,HinhAnh,DonGia)"
					+"VALUES (?,?,?,?,?,?)";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			
			prest.setString(1, sp.getTenSP());
			prest.setInt(2, sp.getMaLoai());
			prest.setInt(3, sp.getSoLuong());
			prest.setInt(4, sp.getMaCongThuc());
			prest.setString(5, sp.getHinhAnh());
			prest.setInt(6, sp.getDonGia());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
    public boolean xoaSanPham(int maSP) {
        try {
            String sql = "DELETE FROM sanpham WHERE id=" + maSP;
            Statement st = ConnectDB.con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean suaSanPham(SanPham sp) {
		try {
			String sql = "UPDATE sanpham SET"
					+ "TenSP=?, "
					+ "idLoaiSp=? ,SoLuong=?, idCongThuc=? ,HinhAnh=? ,DonGia=? "
					+ "WHERE id=?";
			PreparedStatement prest = ConnectDB.con.prepareStatement(sql);
			
			prest.setString(1, sp.getTenSP());
			prest.setInt(2, sp.getMaLoai());
			prest.setInt(3, sp.getSoLuong());
			prest.setInt(4, sp.getMaCongThuc());
			prest.setString(5, sp.getHinhAnh());
			prest.setInt(6, sp.getDonGia());
			prest.setInt(7, sp.getMaSP());
			
			prest.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
}
