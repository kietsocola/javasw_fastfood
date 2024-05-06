package BUS;
import java.util.ArrayList;
import java.util.Date;

import DTO.HoaDon;

import DAO.HoaDonDAO;
public class HoaDonBUS {
	
	private ArrayList<HoaDon> listHD;
	private HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public ArrayList<HoaDon> getListHoaDon(){
		listHD = hoaDonDAO.getListHoaDon();
		return listHD;
	}
	public void luuHoaDon(int nhanVien, int maKH, int tongTien, String ghiChu) {
        HoaDon hd = new HoaDon();
//        String[] arrNV = nhanVien.split(" - ");
//        int maNV = Integer.parseInt(arrNV[0]);
//        hd.setidNV(maNV);
        if(maKH!=0) hd.setidKH(maKH);
        hd.setGhiChu(ghiChu);
        hd.setTongTien(tongTien);
        Date currentDate = new Date();
        hd.setNgayLap(currentDate);
        hd.setidNV(nhanVien);
        hoaDonDAO.addHoaDon(hd);
    }
	public ArrayList<HoaDon> getListHoaDonTheoNgay(Date minDate, Date maxDate) {
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date minDate = sdf.parse(min);
//            Date maxDate = sdf.parse(max);

            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<HoaDon> dshd = hoaDonDAO.getListHoaDon(dateMin, dateMax);
            return dshd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
