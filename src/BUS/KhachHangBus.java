package BUS;

import java.util.ArrayList;

import DAO.KhachHangDAO;
import DAO.NhanVienDao;
import DTO.KhachHang;
import DTO.NhanVien;

public class KhachHangBus {

	private KhachHangDAO khdao= new KhachHangDAO();
	private ArrayList<KhachHang> listKH=null;
	
	public KhachHangBus() {
		docDanhSach();
	}
	
	public void docDanhSach() {
		this.listKH=khdao.getDSKhachHang();
	}
	
	public ArrayList<KhachHang> getDanhSachKhachHang(){
		if(this.listKH==null) this.docDanhSach();
		return this.listKH;
	}
	
	public boolean themKhachHang(String ten, String gioiTinh, String soDT, double tongChiTieu) {
		ten=ten.trim();
		gioiTinh=gioiTinh.trim();
		soDT=soDT.trim();
		if(ten.equals("")) {
			System.out.print("Tên không được để trống!");
			return false;
		}
		if(soDT.equals("")) {
			System.out.print("Số điện thoại không được để trống!");
			return false;
		}
		KhachHang kh =new KhachHang();
		kh.setTen(ten);
		kh.setGioiTinh(gioiTinh);
		kh.setSoDT(soDT);
		kh.setTongChiTieu(tongChiTieu);
		boolean flag=khdao.themKH(kh);
		if(!flag) {
			System.out.print("Thêm thất bại!");
		}
		else {
			System.out.print("Thêm thành công!");
		}
		return flag;
	}
	
	public boolean suaKhachHang(String ma,String ten, String gioiTinh, String soDT, double tongChiTieu) {
		int maKH=Integer.parseInt(ma);
		ten=ten.trim();
		gioiTinh=gioiTinh.trim();
		soDT=soDT.trim();
		if(ten.equals("")) {
			System.out.print("Tên không được để trống!");
			return false;
		}
		if(soDT.equals("")) {
			System.out.print("Số điện thoại không được để trống!");
			return false;
		}
		KhachHang kh =new KhachHang();
		kh.setMaKH(maKH);
		kh.setTen(ten);
		kh.setGioiTinh(gioiTinh);
		kh.setSoDT(soDT);
		kh.setTongChiTieu(tongChiTieu);
		boolean flag=khdao.themKH(kh);
		if(!flag) {
			System.out.print("Thêm thất bại!");
		}
		else {
			System.out.print("Thêm thành công!");
		}
		return flag;
	}
	
	public ArrayList<KhachHang> timKhachHang(String tuKhoa){
		tuKhoa=tuKhoa.toLowerCase();
		ArrayList<KhachHang> dskh=new ArrayList<>();
		for(KhachHang kh : listKH) {
			if(kh.getTen().toLowerCase().contains(tuKhoa)
				||kh.getGioiTinh().toLowerCase().contains(tuKhoa)
				||kh.getSoDT().toLowerCase().contains(tuKhoa)) {
				dskh.add(kh);
			}
		}
		return dskh;
	}
	
	public ArrayList<KhachHang> timKhachHang(String txtMin, String txtMax){
		if(txtMax.trim().equals("")&&txtMax.trim().equals("")) 
			return listKH;
		try {
			ArrayList<KhachHang> dskh=new ArrayList<>();
			txtMin=txtMin.replace(",", "");
			txtMax=txtMax.replace(",", "");
			int min=Integer.parseInt(txtMin);
			int max=Integer.parseInt(txtMax);
			for(KhachHang kh : listKH) {
				if(kh.getTongChiTieu()>=min && kh.getTongChiTieu()<=max) {
					dskh.add(kh);
				}
			}
			return dskh;
		}catch (Exception e) {
            System.out.print("Hãy nhập giá trị nguyên phù hợp!");
        }
        return null;
	}
	
	
	public boolean xoaKhachHang(String ma) {
		try {
			int maKH=Integer.parseInt(ma);
			boolean flag=false;
			flag=khdao.deleteKH(maKH);
			if(flag) {
				System.out.print("Xoá thành công!");
			}
			else {
				System.out.print("Xoá thất bại!");
			}
			return flag;
		}catch (Exception e) {
			System.out.print("Chưa chọn khách hàng!");
        }
        return false;
	}
}
