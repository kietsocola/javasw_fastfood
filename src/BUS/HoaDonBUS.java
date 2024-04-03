package BUS;
import java.util.ArrayList;

import DTO.HoaDon;

import DAO.HoaDonDAO;
public class HoaDonBUS {
	
	private ArrayList<HoaDon> listHD;
	private HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public ArrayList<HoaDon> getListHoaDon(){
		listHD = hoaDonDAO.getListHoaDon();
		return listHD;
	}
}
