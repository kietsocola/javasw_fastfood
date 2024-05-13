package BUS;
import java.util.ArrayList;

import DAO.NguyenLieuDAO;
import DTO.NguyenLieu;
public class NguyenLieuBUS {
	NguyenLieuDAO nlDAO = new NguyenLieuDAO();
	
	public NguyenLieu getNguyenLieubyId(int id) {
		try {
			NguyenLieu nl = nlDAO.getNguyenLieu(id);
			return nl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<NguyenLieu> getDSachNguyenLieu(){
		ArrayList<NguyenLieu> arr = new ArrayList<>();
		try {
			arr = nlDAO.getDanhSachNguyenLieu();
		} catch (Exception e) {
			arr = null;
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<NguyenLieu> getNguyenLieuTheoTen(String ten) {
	    ArrayList<NguyenLieu> dsnl = new ArrayList<>();
	    ArrayList<NguyenLieu> allNguyenLieu = getDSachNguyenLieu(); // Lấy danh sách tất cả nguyên liệu

	    for (NguyenLieu nl : allNguyenLieu) {
	        String tenNL = nl.getTenNL().toLowerCase(); // Lấy tên nguyên liệu và chuyển về chữ thường
	        if (tenNL.contains(ten.toLowerCase())) { // Kiểm tra xem tên có chứa từ khóa không
	            dsnl.add(nl); // Nếu có, thêm vào danh sách kết quả
	        }
	    }

	    return dsnl;
	}
	public boolean giamSoLuongNLkhiCheBien(int id, int slNL) {
		try {
			return nlDAO.suaSoLuongNguyenLieu(id, slNL);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean themNguyenLieu(String tenNL,int soluong,int donGiaNL) {
	    // Tạo một đối tượng NguyenLieu từ các thông tin đầu vào
	    NguyenLieu nl = new NguyenLieu();
	    nl.setTenNL(tenNL);
	    //nl.setSoLuongNL(soLuongNL);
	    nl.setDonGiaNL(donGiaNL);

	    try {
	        // Gọi phương thức themNguyenLieu từ lớp DAO để thêm nguyên liệu vào cơ sở dữ liệu
	        return nlDAO.themNguyenLieu(nl);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
