package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import DTO.SanPham;
public class SanPhamDAO {
	ConnectDB conDB = new ConnectDB();
	public ArrayList<SanPham> getDanhSachSanPham(){
		ArrayList <SanPham> DSSanPham = new ArrayList<>();
		if(conDB.openConnectDB()) {
			try {
				String sql = "SELECT *FROM sanpham";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
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
				String sql = "SELECT *FROM sanpham WHERE id=?";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				prest.setInt(1, ma);
				ResultSet rs = prest.executeQuery();
				while (rs.next()){
					 sp = new SanPham();
					
					sp.setMaSP(rs.getInt("id"));
					sp.setMaLoai(rs.getInt("idLoaiSP"));
					sp.setTenSP(rs.getString("TenSP"));
					sp.setDonGia(rs.getInt("DonGia"));
					sp.setSoLuong(rs.getInt("SoLuong"));
					sp.setHinhAnh(rs.getString("HinhAnh"));
					sp.setMaCongThuc(rs.getInt("idCongThuc"));				
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
				String sql = "SELECT *FROM sanpham WHERE idLoaiSP=?";
				PreparedStatement prest =conDB.conn.prepareStatement(sql);	
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
	        String sql = "SELECT HinhAnh FROM sanpham WHERE id=?";
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
				String sql = "INSERT INTO sanpham(TenSP, idLoaiSP,SoLuong,idCongThuc,HinhAnh,DonGia)"
						+"VALUES (?,?,?,?,?,?)";
				PreparedStatement prest = conDB.conn.prepareStatement(sql);
				
				prest.setString(1, sp.getTenSP());
				prest.setInt(2, sp.getMaLoai());
				prest.setInt(3, sp.getSoLuong());
				prest.setInt(4, sp.getMaCongThuc());
				prest.setString(5, sp.getHinhAnh());
				prest.setInt(6, sp.getDonGia());
				
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
		        String sql = "DELETE FROM sanpham WHERE id=?" + maSP;
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
		        		+ "TenSP=?, idLoaiSp=?, SoLuong=?, "
		        		+ "idCongThuc=?, HinhAnh=?, DonGia=? WHERE id=?";
		        PreparedStatement prest = conDB.conn.prepareStatement(sql);

		        prest.setString(1, sp.getTenSP());
		        prest.setInt(2, sp.getMaLoai());
		        prest.setInt(3, sp.getSoLuong());
		        prest.setInt(4, sp.getMaCongThuc());
		        prest.setString(5, sp.getHinhAnh());
		        prest.setInt(6, sp.getDonGia());
		        prest.setInt(7, sp.getMaSP());

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
//    public static void main(String[] args) {
//        // Thiết lập kết nối đến cơ sở dữ liệu
//        ConnectDB con = new ConnectDB();
//        con.openConnectDB();
//
//        // Tạo một đối tượng SanPhamDAO để truy xuất dữ liệu từ cơ sở dữ liệu
//        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//
//        // Gọi phương thức DuLieuSanPham() để lấy danh sách sản phẩm từ cơ sở dữ liệu
//        ArrayList<SanPham> dsSanPham = sanPhamDAO.getDanhSachSanPham();
//
//        // Kiểm tra xem danh sách sản phẩm có dữ liệu không
//        if (dsSanPham != null && !dsSanPham.isEmpty()) {
//            // Hiển thị thông tin của từng sản phẩm
//            System.out.println("Danh sách sản phẩm:");
//            for (SanPham sp : dsSanPham) {
//                System.out.println("Mã SP: " + sp.getMaSP());
//                System.out.println("Mã Loại SP: " + sp.getMaLoai());
//                System.out.println("Tên SP: " + sp.getTenSP());
//                System.out.println("Đơn giá: " + sp.getDonGia());
//                System.out.println("Số lượng: " + sp.getSoLuong());
//                System.out.println("Hình ảnh: " + sp.getHinhAnh());
//                System.out.println("Mã công thức: " + sp.getMaCongThuc());
//                System.out.println("----------------------------------------");
//            }
//        } else {
//            System.out.println("Không có sản phẩm nào trong cơ sở dữ liệu.");
//        }
//
//        // Đóng kết nối đến cơ sở dữ liệu sau khi hoàn thành công việc
//        con.closeConnectDB();
//    }
}
