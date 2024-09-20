package DAO;
import java.sql.Connection;


import DTO.taiKhoan_DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class taiKhoan_DAO  {
	connectDatabase con = new connectDatabase();
	
//	public ArrayList<taiKhoan_DTO> getDSTaiKhoan() {
//		 
//	    ArrayList<taiKhoan_DTO> dstk = new ArrayList<>();
//	    con.connect();
//	        try (PreparedStatement pre = con.getCon().prepareStatement("SELECT * FROM taiKhoan WHERE isDelete=0")) {
//	            ResultSet rs = pre.executeQuery();
//	            while (rs.next()) {
//	            	taiKhoan_DTO tk = new taiKhoan_DTO();
//	            	tk.setMa(rs.getInt(1));
//	            	tk.setNgayTao(rs.getString(2));
//	            	tk.setTenTaiKhoan(rs.getString(3));;
//	            	tk.setMatKhau(rs.getString(4));
//	            	tk.setTrangThai(rs.getInt(5));
//	            	tk.setQuyen(rs.getInt(6));
//	            	
//	                dstk.add(tk);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } 
//	    
//	    return dstk;
//}
	public ArrayList<taiKhoan_DTO> getDSTaiKhoan() {
	    ArrayList<taiKhoan_DTO> dstk = new ArrayList<>();
	    con.connect();

	    String sql = "SELECT id, NgayTao, TenDangNhap, MatKhau, TrangThai, Quyen, 'taiKhoan' as Source FROM taiKhoan WHERE isDelete = 0 " +
	                 "UNION ALL " +
	                 "SELECT id, NgayTao, TenDangNhap, MatKhau, TrangThai, 3 as Quyen, 'taiKhoanbanhang' as Source FROM taiKhoanbanhang WHERE isDelete = 0";

	    try (PreparedStatement pre = con.getCon().prepareStatement(sql);
	         ResultSet rs = pre.executeQuery()) {

	        while (rs.next()) {
	            taiKhoan_DTO tk = new taiKhoan_DTO();
	            tk.setMa(rs.getInt("id"));
	            tk.setNgayTao(rs.getString("NgayTao"));
	            tk.setTenTaiKhoan(rs.getString("TenDangNhap"));
	            tk.setMatKhau(rs.getString("MatKhau"));
	            tk.setTrangThai(rs.getInt("TrangThai"));

	            // Kiểm tra nếu Quyen không null, tức là từ bảng `taiKhoan`
	            if ("taiKhoan".equals(rs.getString("Source"))) {
	                tk.setQuyen(rs.getInt("Quyen"));
	            } else {
	                // Nếu từ bảng `taiKhoanbanhang`, bạn có thể set giá trị mặc định cho Quyen
	                tk.setQuyen(3); // Hoặc giá trị mặc định mà bạn muốn
	            }

	            dstk.add(tk);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return dstk;
	}
	
public int idTaiKhoanMax() {
		
		con.connect();
		String sql = "select MAX(id) as id from taikhoan where isDelete=0";
		try {
			Statement stmt = con.getCon().createStatement()	;
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt("id");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return-1;
	}
	
//public ResultSet getAccount(taiKhoan_DTO account) throws SQLException  {
//	boolean result = false;
//	con.connect();
//	String sql = "select * from taikhoan where TenDangNhap = ? and MatKhau =? AND isDelete=0";
//	PreparedStatement preparedStatement =con.getCon().prepareStatement(sql);
//	
//	preparedStatement.setString(1,account.getTenTaiKhoan());
//	preparedStatement.setString(2, account.getMatKhau());
//	
//	ResultSet resultset = preparedStatement.executeQuery();
//	return resultset;
//}

public ResultSet getAccount(taiKhoan_DTO account) throws SQLException {
    con.connect();
    
    // Chỉ lấy cột TenDangNhap và MatKhau từ cả hai bảng
    String sql = "SELECT TenDangNhap, MatKhau, trangthai, tendangnhap, quyen, id "
    		+ "FROM taikhoan \n"
    		+ "WHERE TenDangNhap = ? AND MatKhau = ? AND isDelete = 0 "
    		+ "UNION ALL "
    		+ "SELECT TenDangNhap, MatKhau, trangthai, tendangnhap, 3 AS quyen, id "
    		+ "FROM taikhoanbanhang "
    		+ "WHERE TenDangNhap = ? AND MatKhau = ? AND isDelete = 0";
    
    PreparedStatement preparedStatement = con.getCon().prepareStatement(sql);
    
    // Đặt giá trị tham số cho cả hai truy vấn
    preparedStatement.setString(1, account.getTenTaiKhoan());
    preparedStatement.setString(2, account.getMatKhau());
    preparedStatement.setString(3, account.getTenTaiKhoan());
    preparedStatement.setString(4, account.getMatKhau());
    
    // Thực thi truy vấn
    ResultSet resultset = preparedStatement.executeQuery();
    return resultset;
}
	
	public boolean checkAccount(taiKhoan_DTO account) throws SQLException  {
		boolean result = false;
		result =  getAccount(account).next();
		con.close();
		return result;
	}
	
	public int checkStatus(taiKhoan_DTO account) throws SQLException {
			
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("TrangThai");
		con.close();
		return 0;
	}
	
	public String getTen(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getString("TenDangNhap");
		con.close();
		return null;
	}
	
	public int getIdPhanQuyen(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("Quyen");
		con.close();
		return 0;
	}
	
	public int getId(taiKhoan_DTO account) throws SQLException {
		
		ResultSet result = getAccount(account);
		if(result.next())
			return result.getInt("id");
		con.close();
		return 0;
	}
	
	public int getTrangThai(int id) {	
		try {
			con.connect();
			String sql="SELECT TrangThai FROM taikhoan where id="+id;
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return -1;
	}
	
	public boolean setTrangThai(int id, int trangThai) {	
		boolean result=false;
	    try {
	        con.connect();
	        String sql = "UPDATE taikhoan SET TrangThai=?  WHERE id=?";
	        PreparedStatement ps = con.getCon().prepareStatement(sql);
	        ps.setInt(1, trangThai);
	        ps.setInt(2,id);
	        result = ps.executeUpdate() > 0;
	    } catch (SQLException ex) {
            return false;
        }
        return result;
	}
	
	public String getTenDangNhap(int id) {    
	    try {
	        con.connect();
	        String sql = "SELECT TenDangNhap FROM taikhoan WHERE id=? AND isDelete=0 "
	                   + "UNION ALL "
	                   + "SELECT TenDangNhap FROM taikhoanbanhang WHERE id=? AND isDelete=0";
	        PreparedStatement ps = con.getCon().prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.setInt(2, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getString("TenDangNhap");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return "";
	}
	
	

	public String getMatKhau(int id) {    
	    try {
	        con.connect();
	        String sql = "SELECT MatKhau FROM taikhoan WHERE id=? AND isDelete=0 "
	                   + "UNION ALL "
	                   + "SELECT MatKhau FROM taikhoanbanhang WHERE id=? AND isDelete=0";
	        PreparedStatement ps = con.getCon().prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.setInt(2, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getString("MatKhau");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return "";
	}
	
	
	public boolean suaTaiKhoan(taiKhoan_DTO tk) {
	    boolean result = false;
	    boolean taikhoanUpdated = false;
	    boolean taikhoanbanhangUpdated = false;

	    try {
	        con.connect();
	        
	        // Cập nhật bảng taikhoan
	        String sqlTaiKhoan = "UPDATE taikhoan SET TenDangNhap = ?, MatKhau = ?, TrangThai = ?, Quyen = ? WHERE id = ?";
	        try (PreparedStatement preTaiKhoan = con.getCon().prepareStatement(sqlTaiKhoan)) {
	            preTaiKhoan.setString(1, tk.getTenTaiKhoan());
	            preTaiKhoan.setString(2, tk.getMatKhau());
	            preTaiKhoan.setInt(3, tk.getTrangThai());
	            preTaiKhoan.setInt(4, tk.getQuyen());
	            preTaiKhoan.setInt(5, tk.getMa());
	            taikhoanUpdated = preTaiKhoan.executeUpdate() > 0;
	        }

	        // Cập nhật bảng taikhoanbanhang
	        String sqlTaiKhoanBanHang = "UPDATE taikhoanbanhang SET TenDangNhap = ?, MatKhau = ?, TrangThai = ? WHERE id = ?";
	        try (PreparedStatement preTaiKhoanBanHang = con.getCon().prepareStatement(sqlTaiKhoanBanHang)) {
	            preTaiKhoanBanHang.setString(1, tk.getTenTaiKhoan());
	            preTaiKhoanBanHang.setString(2, tk.getMatKhau());
	            preTaiKhoanBanHang.setInt(3, tk.getTrangThai());
	            preTaiKhoanBanHang.setInt(4, tk.getMa());
	            taikhoanbanhangUpdated = preTaiKhoanBanHang.executeUpdate() > 0;
	        }

	        // Trả về true nếu ít nhất một trong hai bảng được cập nhật
	        result = taikhoanUpdated || taikhoanbanhangUpdated;

	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng log hoặc xử lý lỗi phù hợp
	    }

	    return result;
	}
	
	 public boolean deleteTaiKhoan(int ma) {
	        boolean result = false;
	        try {
	            String sql = "UPDATE taikhoan SET isDelete=1 where id=?";
	            PreparedStatement pre = con.getCon().prepareStatement(sql);
	            pre.setInt(1, ma);
	            result = pre.executeUpdate() > 0;
	        } catch (SQLException ex) {
	            return false;
	        }
	        return result;
	    }
	
	public boolean themTaiKhoan(taiKhoan_DTO tk) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "INSERT INTO taikhoan( NgayTao, TenDangNhap, MatKhau,TrangThai, Quyen) "
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            pre.setInt(5, tk.getQuyen());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	public boolean themTaiKhoanCoID(taiKhoan_DTO tk, int quyen) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "INSERT INTO taikhoan(NgayTao, TenDangNhap, MatKhau,TrangThai, Quyen, id) "
                    + "VALUES (?, ?, ?, ?,?, ?)";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            pre.setInt(5, quyen);
            pre.setInt(6, tk.getMa());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	
	public boolean themTaiKhoanBanHang(taiKhoan_DTO tk) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "INSERT INTO taikhoanbanhang( NgayTao, TenDangNhap, MatKhau,TrangThai) "
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	public boolean themTaiKhoanBanHangCoID(taiKhoan_DTO tk) {
		boolean result = false;
        try {
        	con.connect();
            String sql = "INSERT INTO taikhoanbanhang(NgayTao, TenDangNhap, MatKhau,TrangThai, id) "
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement pre = con.getCon().prepareStatement(sql);
            pre.setString(1, tk.getNgayTao());
            pre.setString(2, tk.getTenTaiKhoan());
            pre.setString(3, tk.getMatKhau());
            pre.setInt(4, tk.getTrangThai());
            pre.setInt(5, tk.getMa());
            result= pre.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return result;
    }
	
	public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
	    String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND isDelete = 0 "
	               + "UNION ALL "
	               + "SELECT * FROM taikhoanbanhang WHERE TenDangNhap = ? AND isDelete = 0";
	    
	    try {
	        con.connect();
	        try (PreparedStatement pre = con.getCon().prepareStatement(sql)) {
	            pre.setString(1, tenDangNhap);
	            pre.setString(2, tenDangNhap);
	            try (ResultSet rs = pre.executeQuery()) {
	                return rs.next();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng log hoặc xử lý lỗi phù hợp
	    }
	    return false;
	}
	
	public boolean kiemTraTrungTenDangNhap2(String tenDangNhap, int id) {
	    String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE TenDangNhap = ? AND id != ? AND isDelete = 0 "
	               + "UNION ALL "
	               + "SELECT TenDangNhap FROM taikhoanbanhang WHERE TenDangNhap = ? AND id != ? AND isDelete = 0";
	    
	    try {
	        con.connect();
	        try (PreparedStatement pre = con.getCon().prepareStatement(sql)) {
	            pre.setString(1, tenDangNhap);
	            pre.setInt(2, id);
	            pre.setString(3, tenDangNhap);
	            pre.setInt(4, id);
	            try (ResultSet rs = pre.executeQuery()) {
	                return rs.next();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng log hoặc xử lý lỗi phù hợp
	    }
	    return false;
	}
	
	public String getTenQuyen(int id) {
	    String tenQuyen = "";
	    try {
	        con.connect();
	        String sql = "SELECT TenQuyen FROM phanquyen pq "
	                   + "JOIN taikhoan tk ON tk.Quyen = pq.id "
	                   + "WHERE tk.id = ? AND tk.isDelete = 0 "
	                   + "UNION ALL "
	                   + "SELECT 'Bán hàng' as TenQuyen FROM taikhoanbanhang tkb "
	                   + "WHERE tkb.id = ? AND tkb.isDelete = 0";
	        
	        try (PreparedStatement pre = con.getCon().prepareStatement(sql)) {
	            pre.setInt(1, id);
	            pre.setInt(2, id);
	            try (ResultSet rs = pre.executeQuery()) {
	                if (rs.next()) {
	                    tenQuyen = rs.getString("TenQuyen"); // Lấy tên quyền hoặc giá trị mặc định
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error retrieving TenQuyen: " + e.getMessage());
	    } finally {
	        con.close();
	    }
	    return tenQuyen;
	}
	
	public int getIdAccountWithQuyenAndId(int quyen, int idAccount) {
		// quyen = 3 => bán hàng
		// quyen = 5 => nhập hàng
	    try {
	        con.connect();
	        String sql = "SELECT id FROM taikhoan WHERE Quyen = ? AND isDelete = 0 AND id = ?";
	        PreparedStatement pre = con.getCon().prepareStatement(sql);
	        pre.setInt(1, quyen);
	        pre.setInt(2, idAccount);
	        ResultSet rs = pre.executeQuery();
	        
	        if (rs.next()) {
	            return rs.getInt("id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Bạn có thể thay thế bằng log hoặc xử lý lỗi
	    }
	    return -1; // Trả về -1 nếu không tìm thấy kết quả nào
	}
	public int getIdAccountWithQuyenAndId_InTaiKhoanBanHang(int quyen, int idAccount) {
		// quyen = 3 => bán hàng
		// quyen = 5 => nhập hàng
	    try {
	        con.connect();
	        String sql = "SELECT id FROM taikhoanbanhang WHERE Quyen = ? AND isDelete = 0 AND id = ?";
	        PreparedStatement pre = con.getCon().prepareStatement(sql);
	        pre.setInt(1, quyen);
	        pre.setInt(2, idAccount);
	        ResultSet rs = pre.executeQuery();
	        
	        if (rs.next()) {
	            return rs.getInt("id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Bạn có thể thay thế bằng log hoặc xử lý lỗi
	    }
	    return -1; // Trả về -1 nếu không tìm thấy kết quả nào
	}
	
	public int getIdAccountByIdNhanVienOrIdNhanVienBanHang(int idNhanVien) {
	    int idTaiKhoan = -1; // Giá trị trả về nếu không tìm thấy

	    try {
	        // Truy vấn kết hợp giữa bảng nhanvien và taikhoan
	        String sqlNhanVien = "SELECT tk.id FROM nhanvien nv " +
	                             "JOIN taikhoan tk ON nv.idTaiKhoan = tk.id " +
	                             "WHERE nv.id = ? AND tk.isDelete = 0";
	        PreparedStatement preNhanVien = con.getCon().prepareStatement(sqlNhanVien);
	        preNhanVien.setInt(1, idNhanVien);
	        ResultSet rsNhanVien = preNhanVien.executeQuery();

	        if (rsNhanVien.next()) {
	            idTaiKhoan = rsNhanVien.getInt("id");
	            return idTaiKhoan; // Trả về ngay khi tìm thấy trong bảng nhanvien
	        }

	        // Truy vấn kết hợp giữa bảng nhanvienbanhang và taikhoan nếu không tìm thấy trong nhanvien
	        String sqlNhanVienBanHang = "SELECT tk.id FROM nhanvienbanhang nvb " +
	                                    "JOIN taikhoan tk ON nvb.idTaiKhoan = tk.id " +
	                                    "WHERE nvb.id = ? AND tk.isDelete = 0";
	        PreparedStatement preNhanVienBanHang = con.getCon().prepareStatement(sqlNhanVienBanHang);
	        preNhanVienBanHang.setInt(1, idNhanVien);
	        ResultSet rsNhanVienBanHang = preNhanVienBanHang.executeQuery();

	        if (rsNhanVienBanHang.next()) {
	            idTaiKhoan = rsNhanVienBanHang.getInt("id");
	            return idTaiKhoan; // Trả về nếu tìm thấy trong nhanvienbanhang
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý lỗi SQL, có thể thay bằng log nếu cần
	    }

	    return idTaiKhoan; // Trả về -1 nếu không tìm thấy trong cả hai bảng
	}
	
	public int getIdAccountBanHangByIdNhanVienOrIdNhanVienBanHang(int idNhanVien) {
	    int idTaiKhoan = -1; // Giá trị trả về nếu không tìm thấy

	    try {
	        // Truy vấn kết hợp giữa bảng nhanvien và taikhoan
	        String sqlNhanVien = "SELECT tk.id FROM nhanvien nv " +
	                             "JOIN taikhoanbanhang tk ON nv.idTaiKhoan = tk.id " +
	                             "WHERE nv.id = ? AND tk.isDelete = 0";
	        PreparedStatement preNhanVien = con.getCon().prepareStatement(sqlNhanVien);
	        preNhanVien.setInt(1, idNhanVien);
	        ResultSet rsNhanVien = preNhanVien.executeQuery();

	        if (rsNhanVien.next()) {
	            idTaiKhoan = rsNhanVien.getInt("id");
	            return idTaiKhoan; // Trả về ngay khi tìm thấy trong bảng nhanvien
	        }

	        // Truy vấn kết hợp giữa bảng nhanvienbanhang và taikhoan nếu không tìm thấy trong nhanvien
	        String sqlNhanVienBanHang = "SELECT tk.id FROM nhanvienbanhang nvb " +
	                                    "JOIN taikhoanbanhang tk ON nvb.idTaiKhoan = tk.id " +
	                                    "WHERE nvb.id = ? AND tk.isDelete = 0";
	        PreparedStatement preNhanVienBanHang = con.getCon().prepareStatement(sqlNhanVienBanHang);
	        preNhanVienBanHang.setInt(1, idNhanVien);
	        ResultSet rsNhanVienBanHang = preNhanVienBanHang.executeQuery();

	        if (rsNhanVienBanHang.next()) {
	            idTaiKhoan = rsNhanVienBanHang.getInt("id");
	            return idTaiKhoan; // Trả về nếu tìm thấy trong nhanvienbanhang
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý lỗi SQL, có thể thay bằng log nếu cần
	    }

	    return idTaiKhoan; // Trả về -1 nếu không tìm thấy trong cả hai bảng
	}
	
	public taiKhoan_DTO getTaiKhoanBanHangById(int id) {
	    taiKhoan_DTO tk = new taiKhoan_DTO();
	    String sql = "SELECT * FROM taikhoanbanhang WHERE id = ?";
	    
	    try (PreparedStatement stmt = con.getCon().prepareStatement(sql)) {	      
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                tk.setMa(rs.getInt("id"));
	                tk.setTenTaiKhoan(rs.getString("TenDangNhap"));
	                tk.setMatKhau(rs.getString("MatKhau"));
	                tk.setTrangThai(rs.getInt("TrangThai"));
	                tk.setNgayTao(rs.getString("NgayTao"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return tk;
	}
	
	public taiKhoan_DTO getTaiKhoanById(int id) {
	    taiKhoan_DTO tk = new taiKhoan_DTO();
	    String sql = "SELECT * FROM taikhoan WHERE id = ?";
	    
	    try (PreparedStatement stmt = con.getCon().prepareStatement(sql)) {	      
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                tk.setMa(rs.getInt("id"));
	                tk.setTenTaiKhoan(rs.getString("TenDangNhap"));
	                tk.setMatKhau(rs.getString("MatKhau"));
	                tk.setTrangThai(rs.getInt("TrangThai"));
	                tk.setTenQuyen(rs.getString("Quyen"));
	                tk.setNgayTao(rs.getString("NgayTao"));
	                tk.setQuyen(rs.getInt("Quyen"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return tk;
	}
	public boolean deleteTaiKhoanBanHangById(int id) {
	    String sql = "DELETE FROM taikhoanbanhang WHERE id = ?";
	    boolean result = false;

	    try (PreparedStatement pre = con.getCon().prepareStatement(sql)) {
	        pre.setInt(1, id);
	        
	        // Thực hiện câu truy vấn, nếu số dòng bị ảnh hưởng > 0 thì xóa thành công
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng ghi log trong thực tế
	    }
	    
	    return result;
	}
	public boolean deleteTaiKhoanById(int id) {
	    String sql = "DELETE FROM taikhoan WHERE id = ?";
	    boolean result = false;

	    try (PreparedStatement pre = con.getCon().prepareStatement(sql)) {
	        pre.setInt(1, id);
	        
	        // Thực hiện câu truy vấn, nếu số dòng bị ảnh hưởng > 0 thì xóa thành công
	        result = pre.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Nên thay bằng ghi log trong thực tế
	    }
	    
	    return result;
	}
}
