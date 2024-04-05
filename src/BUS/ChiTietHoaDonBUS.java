package BUS;

import DTO.ChiTietHoaDon;

import java.util.ArrayList;

import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
public class ChiTietHoaDonBUS {
	ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<>();
	ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
	HoaDonDAO hdDAO = new HoaDonDAO();
	public void addChiTietHoaDon(String maSP, String soLuong, String donGia, String thanhTien) {
		ChiTietHoaDon cthd = new ChiTietHoaDon();
		
		cthd.setIdHoaDon(hdDAO.getMaHoaDonMoiNhat()+1);
        cthd.setIdSanPham(Integer.parseInt(maSP));
        cthd.setDonGia(Integer.parseInt(donGia));
        cthd.setSoLuong(Integer.parseInt(soLuong));
        cthd.setThanhTien(Integer.parseInt(thanhTien));
        cthd.setIdKhuyenMai(1);
        
        cthdDAO.addChiTietHoaDon(cthd);
	}
	public ArrayList<ChiTietHoaDon> getListCTHDtheoIdHoaDon(int idHD) {
		listCTHD = cthdDAO.getListCTHDtheoIdHD(idHD);
		return listCTHD;
	}
}
