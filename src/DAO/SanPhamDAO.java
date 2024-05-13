package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.SanPham;

public class SanPhamDAO {
	ConnectDB conDB = new ConnectDB();

	public ArrayList<SanPham> getListSanPham() {
		ArrayList<SanPham> arrSanPham = new ArrayList<SanPham>();
		if (conDB.openConnectDB()) {
			try {
				String sql = "Select * from SanPham";
				Statement stmt = conDB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					SanPham hd = new SanPham();
					hd.setId(rs.getInt("id"));
					hd.setIdLoaiSP(rs.getInt("idLoaiSP"));
					hd.setTenSP(rs.getString("TenSP"));
					hd.setDonGia(rs.getInt("DonGia"));
					hd.setSoLuong(rs.getInt("SoLuong"));
					hd.setHinhAnh(rs.getString("HinhAnh"));
					hd.setIdCongThuc(rs.getInt("idCongThuc"));
					arrSanPham.add(hd);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return arrSanPham;
	}
	public boolean tangSoLuongSanPham(int id, int sl) {
		boolean result = false;
		if (conDB.openConnectDB()) {
			try {
				String sql = "UPDATE sanpham SET SoLuong=SoLuong+? WHERE id=?";
	            PreparedStatement prest = conDB.conn.prepareStatement(sql);
	            prest.setInt(1, sl);
	            prest.setInt(2, id);
	            result = prest.executeUpdate()>0;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				conDB.closeConnectDB();
			}

		}
		return result;
	}
	// Phần của quản lý sản phẩm 
	public ArrayList<SanPham> getDanhSachSanPham(){
		ArrayList <SanPham> DSSanPham = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham WHERE Isdelete=0";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					SanPham sp = new SanPham();
					
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					
					DSSanPham.add(sp);
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
			
		}
		return DSSanPham;
	}
	public ArrayList<SanPham> getDanhSachSanPhamTheoTenVaLoai(String name, int maLoai){
		ArrayList <SanPham> DSSanPham = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham where TenSP LIKE CONCAT('%', ?, '%') and idLoaiSP=? AND Isdelete=0";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setString(1, name);
				prest.setInt(2, maLoai);
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					SanPham sp = new SanPham();
					
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					
					DSSanPham.add(sp);
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
			
		}
		return DSSanPham;
	}
	public ArrayList<SanPham> getDanhSachSanPhamTheoTen(String name){
		ArrayList <SanPham> DSSanPham = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham where TenSP LIKE CONCAT('%', ?, '%') AND Isdelete=0";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setString(1, name);
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					SanPham sp = new SanPham();
					
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					
					DSSanPham.add(sp);
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
			
		}
		return DSSanPham;
	}
	public SanPham getSanPham(int ma) { // Lay san pham dua theo maSp
		SanPham sp = null;
		if (conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham WHERE id=? AND Isdelete=0";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setInt(1, ma);
				ResultSet rs = prest.executeQuery();
				while (rs.next()){
					 sp = new SanPham();
					
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conDB.closeConnectDB();
			}
		}
		return sp;
	}
	public ArrayList<SanPham> getSanPhamTheoLoai (int maLoai){
		ArrayList <SanPham> DSSanPhamTheoLoai = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham WHERE idLoaiSP=? AND Isdelete=0";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
				ResultSet rs = prest.executeQuery();
				
				while (rs.next()){
					SanPham sp = new SanPham();
					
					sp.setId(rs.getInt("id"));
					sp.setIdLoaiSP(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setIdCongThuc(rs.getInt("idCongThuc"));
					
					DSSanPhamTheoLoai.add(sp);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
	        } finally {
	            conDB.closeConnectDB();
	        }
		}
		return DSSanPhamTheoLoai;
	}
	public String getAnh(int ma) {
	    try {
	        String sql = "SELECT HinhAnh FROM sanpham WHERE id=? AND Isdelete=0";
	        PreparedStatement prest = conDB.conn.prepareStatement(sql);
	        prest.setInt(1, ma);
	        ResultSet rs = prest.executeQuery();
	        if (rs.next()) {
	            return rs.getString("HinhAnh");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        conDB.closeConnectDB();
	    }
	    return "";
	}

	public void capNhatSoLuongSp(int ma, int soLuongMa) {
		SanPham sp = getSanPham(ma);
		int soLuong = sp.getSoLuong();
		sp.setSoLuong(soLuong + soLuongMa);
		try {
			String sql = "UPDATE sanpham SET SoLuong=? WHERE id=" + ma;
			PreparedStatement prest = conDB.conn.prepareStatement(sql);
			prest.setInt(1, sp.getSoLuong());
			prest.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public boolean themSanPham(SanPham sp) {
		boolean result = false;
		if(conDB.openConnectDB()) {
			try {
				String sql = "INSERT INTO sanpham(idLoaiSP ,TenSP ,DonGia,SoLuong,HinhAnh,idCongThuc)"
						+"VALUES (?,?,?,?,?,?)";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				
				prest.setInt(1, sp.getIdLoaiSP());
				prest.setString(2, sp.getTenSP());
				prest.setInt(3, sp.getDonGia());
				prest.setInt(4, sp.getSoLuong());
				prest.setString(5, sp.getHinhAnh());
				prest.setInt(6, sp.getIdCongThuc());
				
				if(prest.executeUpdate() >=1)
				result = true;
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				conDB.closeConnectDB();
			}
			
		}
		return result;
	}
	public boolean xoaSanPham(int maSP) {
	    boolean result = false;
	    if (conDB.openConnectDB()) {
	    	try {
		        String sql = "UPDATE sanpham SET Isdelete=1 WHERE id=" + maSP;
		        Statement st = conDB.conn.createStatement();
		        // Thực hiện truy vấn và kiểm tra số hàng đã bị ảnh hưởng
		        if (st.executeUpdate(sql) >= 1)
		            result = true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
				conDB.closeConnectDB();
			}
	    }
	    return result;
	}
	public boolean suaSanPham(SanPham sp) {
	    boolean result = false;
	    if(conDB.openConnectDB()) {
		    try {
		        String sql = "UPDATE sanpham SET "
		        		+ "TenSP=?, idLoaiSp=? , HinhAnh=?, DonGia=? WHERE id=?";
		        PreparedStatement prest = conDB.conn.prepareStatement(sql);

		        prest.setString(1, sp.getTenSP());
		        prest.setInt(2, sp.getIdLoaiSP());
		        //prest.setInt(3, sp.getSoLuong());
		       //prest.setInt(4, sp.getIdCongThuc());
		        prest.setString(3, sp.getHinhAnh());
		        prest.setInt(4, sp.getDonGia());
		        prest.setInt(5, sp.getId());

		        // Thực hiện truy vấn và kiểm tra số hàng đã bị ảnh hưởng
		        if (prest.executeUpdate() >= 1)
		            result = true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
				conDB.closeConnectDB();
			}
	    }
	    return result;
	}
}
