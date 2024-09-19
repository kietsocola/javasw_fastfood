package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVien;

public class NhanVien_DAO {

	private ConnectDB conDB = new ConnectDB();

	public ArrayList<NhanVien> getDSNhanVien() {

		ArrayList<NhanVien> dsnv = new ArrayList<>();
		if (conDB.openConnectDB()) {
			try (PreparedStatement pre = conDB.conn
					.prepareStatement("SELECT id, SoDienThoai, idTaiKhoan, Ten, GioiTinh, NgaySinh, isDelete, ChucVu\n"
							+ "FROM NhanVienbanhang\n" + "WHERE isDelete = 0\n" + "\n" + "UNION ALL\n" + "\n"
							+ "SELECT id, SoDienThoai, idTaiKhoan, Ten, GioiTinh, NgaySinh, isDelete, ChucVu\n"
							+ "FROM nhanvien\n" + "WHERE isDelete = 0;\n" + "")) {
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(rs.getInt(1));
					nv.setTen(rs.getString(4));
					nv.setNgaySinh(rs.getString(6));
					nv.setGioiTinh(rs.getInt(5));
					nv.setSoDT(rs.getString(2));
					nv.setIdTaiKhoan(rs.getInt(3));

					dsnv.add(nv);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsnv;
	}

	public NhanVien getNhanVien(int maNV) {
		NhanVien nv = null;
		try (PreparedStatement pre = conDB.conn.prepareStatement("SELECT * FROM nhanvien WHERE id=? AND isDelete=0")) {
			pre.setInt(1, maNV);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				nv = new NhanVien();
				nv.setMaNV(rs.getInt(1));
				nv.setTen(rs.getString(4));
				nv.setNgaySinh(rs.getString(6));
				nv.setGioiTinh(rs.getInt(5));
				nv.setSoDT(rs.getString(2));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nv;
	}

	public boolean themNV(NhanVien nv) {
		boolean result = false;
		try {
			String sql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai,idTaiKhoan ) "
					+ "VALUES(?, ?, ?,?,?)";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setInt(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			pre.setInt(5, nv.getIdTaiKhoan());
			result = pre.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}
		return result;
	}
	public boolean themNVCoId(NhanVien nv) {
		boolean result = false;
		try {
			String sql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai,idTaiKhoan, id ) "
					+ "VALUES(?, ?, ?,?,?,?)";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setInt(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			pre.setInt(5, nv.getIdTaiKhoan());
			pre.setInt(6, nv.getMaNV());
			result = pre.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}
		return result;
	}

	public boolean themNVBanHang(NhanVien nv) {
		boolean result = false;
		try {
			String sql = "INSERT INTO nhanvienbanhang(Ten, NgaySinh, GioiTinh, SoDienThoai,idTaiKhoan ) "
					+ "VALUES(?, ?, ?,?,?)";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setInt(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			pre.setInt(5, nv.getIdTaiKhoan());
			
			result = pre.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}
		return result;
	}
	public boolean themNVBanHangCoId(NhanVien nv) {
		boolean result = false;
		try {
			String sql = "INSERT INTO nhanvienbanhang(Ten, NgaySinh, GioiTinh, SoDienThoai,idTaiKhoan, id) "
					+ "VALUES(?, ?, ?,?,?,?)";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setInt(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());
			pre.setInt(5, nv.getIdTaiKhoan());
			pre.setInt(6, nv.getMaNV());
			result = pre.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}
		return result;
	}

	public boolean updateNV(NhanVien nv) {
	    boolean result = false;
	    String sqlNhanVien = "UPDATE nhanvien SET Ten=?, NgaySinh=?, GioiTinh=?, SoDienThoai=? WHERE id=?";
	    String sqlNhanVienBanHang = "UPDATE nhanvienbanhang SET Ten=?, NgaySinh=?, GioiTinh=?, SoDienThoai=? WHERE id=?";
	    
	    try {
	        // Cập nhật trong bảng nhanvien
	        PreparedStatement preNhanVien = conDB.conn.prepareStatement(sqlNhanVien);
	        preNhanVien.setString(1, nv.getTen());
	        preNhanVien.setString(2, nv.getNgaySinh());
	        preNhanVien.setInt(3, nv.getGioiTinh());
	        preNhanVien.setString(4, nv.getSoDT());
	        preNhanVien.setInt(5, nv.getMaNV());

	        // Cập nhật trong bảng nhanvienbanhang
	        PreparedStatement preNhanVienBanHang = conDB.conn.prepareStatement(sqlNhanVienBanHang);
	        preNhanVienBanHang.setString(1, nv.getTen());
	        preNhanVienBanHang.setString(2, nv.getNgaySinh());
	        preNhanVienBanHang.setInt(3, nv.getGioiTinh());
	        preNhanVienBanHang.setString(4, nv.getSoDT());
	        preNhanVienBanHang.setInt(5, nv.getMaNV());

	        // Thử cập nhật trong cả hai bảng
	        int rowsUpdatedNhanVien = preNhanVien.executeUpdate();
	        int rowsUpdatedNhanVienBanHang = preNhanVienBanHang.executeUpdate();

	        // Nếu cập nhật thành công trong ít nhất một bảng, trả về true
	        if (rowsUpdatedNhanVien > 0 || rowsUpdatedNhanVienBanHang > 0) {
	            result = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return result;
	}

	public boolean deleteNV(int maNV) {
		String sql = "UPDATE nhanvien SET isDelete=1 WHERE id=?";
		try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
			pre.setInt(1, maNV);

			int rowsAffected = pre.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

//	public int getIdTaiKhoan(int id) {
//		try {
//			String sql = "SELECT idTaiKhoan FROM nhanvien where id=" + id;
//			Statement st = conDB.conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while (rs.next()) {
//				return rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
	
	public int getIdTaiKhoan(int id) {
	    String sql = "SELECT idTaiKhoan FROM nhanvien WHERE id = ? " +
	                 "UNION " +
	                 "SELECT idTaiKhoan FROM nhanvienbanhang WHERE id = ?";
	    try (PreparedStatement ps = conDB.conn.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        ps.setInt(2, id);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1);  // Trả về idTaiKhoan nếu tìm thấy
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;  // Trả về -1 nếu không tìm thấy
	}

	public boolean nhapExcel(NhanVien nv) {
		try {
			// Cập nhật trường isDelete để đánh dấu là tất cả các dữ liệu hiện tại được xem
			// như đã xóa
			String updateSql = "UPDATE nhanvien SET isDelete = 1";
			PreparedStatement updatePre = conDB.conn.prepareStatement(updateSql);
			updatePre.executeUpdate();

			// Chèn dữ liệu mới từ đối tượng NhanVien vào bảng nhanvien
			String insertSql = "INSERT INTO nhanvien(Ten, NgaySinh, GioiTinh, SoDienThoai) " + "VALUES (?, ?, ?, ?)";
			PreparedStatement pre = conDB.conn.prepareStatement(insertSql);
			pre.setString(1, nv.getTen());
			pre.setString(2, nv.getNgaySinh());
			pre.setInt(3, nv.getGioiTinh());
			pre.setString(4, nv.getSoDT());

			// Thực hiện chèn dữ liệu mới
			boolean inserted = pre.executeUpdate() > 0;

			return inserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean kiemTraTrungSDT(String sdt) {
		try {
			String sql = "SELECT * FROM nhanvien where SoDienThoai=? AND isDelete = 0";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, sdt);
			ResultSet rs = pre.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean kiemTraTrungSDT2(String sdt, int id) {
		try {
			String sql = "SELECT * FROM nhanvien where SoDienThoai=? AND id!=? AND isDelete = 0";
			PreparedStatement pre = conDB.conn.prepareStatement(sql);
			pre.setString(1, sdt);
			pre.setInt(2, id);
			ResultSet rs = pre.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public NhanVien getNhanVienWithIdAccount(int idTaiKhoan) {
	    NhanVien nv = null;
	    String sql = "SELECT nv.* FROM nhanvien nv " +
	                 "JOIN taikhoan tk ON nv.idTaiKhoan = tk.id " +
	                 "WHERE tk.id = ? AND tk.isDelete = 0 AND nv.isDelete = 0";

	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, idTaiKhoan);
	        ResultSet rs = pre.executeQuery();

	        if (rs.next()) {
	            nv = new NhanVien();
	            nv.setMaNV(rs.getInt("id"));  // Assuming "id" is the primary key in nhanvien
	            nv.setTen(rs.getString("Ten"));  // Assuming "Ten" is the employee's name column
	            nv.setNgaySinh(rs.getString("NgaySinh"));  // Assuming "NgaySinh" is the birthdate column
	            nv.setGioiTinh(rs.getInt("GioiTinh"));  // Assuming "GioiTinh" represents gender
	            nv.setSoDT(rs.getString("SoDienThoai"));  // Assuming "SoDienThoai" is the phone number
	            nv.setIdTaiKhoan(rs.getInt("idTaiKhoan"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return nv;
	}
	
	public boolean deleteNhanVienByIdAccount(int idTaiKhoan) {
	    String sql = "DELETE FROM nhanvien WHERE idTaiKhoan = ?";
	    boolean result = false;
	    
	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, idTaiKhoan);
	        
	        // Thực hiện câu truy vấn, nếu số dòng bị ảnh hưởng > 0 thì xóa thành công
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng ghi log trong thực tế
	    }
	    
	    return result;
	}
	public NhanVien getNhanVienBanHangWithIdAccount(int idTaiKhoan) {
	    NhanVien nvbh = null;
	    String sql = "SELECT nvbh.* FROM nhanvienbanhang nvbh " +
	                 "JOIN taikhoanbanhang tk ON nvbh.idTaiKhoan = tk.id " +
	                 "WHERE tk.id = ? AND tk.isDelete = 0 AND nvbh.isDelete = 0";

	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, idTaiKhoan);
	        ResultSet rs = pre.executeQuery();

	        if (rs.next()) {
	            nvbh = new NhanVien();
	            nvbh.setMaNV(rs.getInt("id"));  // Assuming "id" is the primary key in nhanvienbanhang
	            nvbh.setTen(rs.getString("Ten"));  // Assuming "Ten" is the employee's name column
	            nvbh.setNgaySinh(rs.getString("NgaySinh"));  // Assuming "NgaySinh" is the birthdate column
	            nvbh.setGioiTinh(rs.getInt("GioiTinh"));  // Assuming "GioiTinh" represents gender
	            nvbh.setSoDT(rs.getString("SoDienThoai"));  // Assuming "SoDienThoai" is the phone number
	            nvbh.setIdTaiKhoan(rs.getInt("idTaiKhoan"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return nvbh;
	}
	
	public boolean deleteNhanVienBanHangByIdAccount(int idTaiKhoan) {
	    String sql = "DELETE FROM nhanvienbanhang WHERE idTaiKhoan = ?";
	    boolean result = false;

	    try (PreparedStatement pre = conDB.conn.prepareStatement(sql)) {
	        pre.setInt(1, idTaiKhoan);
	        
	        // Thực hiện câu truy vấn, nếu số dòng bị ảnh hưởng > 0 thì xóa thành công
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng ghi log trong thực tế
	    }
	    
	    return result;
	}

}
