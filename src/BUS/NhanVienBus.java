package BUS;

import java.util.ArrayList;

import DAO.NhanVienDao;
import DTO.NhanVien;

public class NhanVienBus {

	private NhanVienDao nvdao= new NhanVienDao();
	private ArrayList<NhanVien> listNV=null;
	
	public NhanVienBus() {
		docDanhSach();
	}
	
	public void docDanhSach() {
		this.listNV=nvdao.getDSNhanVien();
	}
	
	public ArrayList<NhanVien> getDanhSachNhanVien(){
		if(this.listNV==null) this.docDanhSach();
		return this.listNV;
	}
	
	public boolean themNhanVien(String ten, String ngaySinh, String gioiTinh, String soDT) {
		ten=ten.trim();
		ngaySinh=ngaySinh.trim();
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
		NhanVien nv =new NhanVien();
		nv.setTen(ten);
		nv.setNgaySinh(ngaySinh);
		nv.setGioiTinh(gioiTinh);
		nv.setSoDT(soDT);
		boolean flag=nvdao.themNV(nv);
		if(!flag) {
			System.out.print("Thêm thất bại!");
		}
		else {
			System.out.print("Thêm thành công!");
		}
		return flag;
	}
	
	public boolean suaNhanVien(String ma,String ten, String ngaySinh, String gioiTinh, String soDT) {
		int maNV=Integer.parseInt(ma);
		ten=ten.trim();
		ngaySinh=ngaySinh.trim();
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
		NhanVien nv =new NhanVien();
		nv.setMaNV(maNV);
		nv.setTen(ten);
		nv.setNgaySinh(ngaySinh);
		nv.setGioiTinh(gioiTinh);
		nv.setSoDT(soDT);
		boolean flag=nvdao.themNV(nv);
		if(!flag) {
			System.out.print("Thêm thất bại!");
		}
		else {
			System.out.print("Thêm thành công!");
		}
		return flag;
	}
	
	public ArrayList<NhanVien> timNhanVien(String tuKhoa){
		tuKhoa=tuKhoa.toLowerCase();
		ArrayList<NhanVien> dsnv=new ArrayList<>();
		for(NhanVien nv : listNV) {
			if(nv.getTen().toLowerCase().contains(tuKhoa)
				||nv.getGioiTinh().toLowerCase().contains(tuKhoa)
				||nv.getNgaySinh().toLowerCase().contains(tuKhoa)
				||nv.getSoDT().toLowerCase().contains(tuKhoa)) {
				dsnv.add(nv);
			}
		}
		return dsnv;
	}
	
	public boolean xoaNhanVien(String ma) {
		try {
			int maNV=Integer.parseInt(ma);
			boolean flag=false;
			flag=nvdao.deleteNV(maNV);
			if(flag) {
				System.out.print("Xoá thành công!");
			}
			else {
				System.out.print("Xoá thất bại!");
			}
			return flag;
		}catch (Exception e) {
			System.out.print("Chưa chọn nhân viên!");
        }
        return false;
	}

}
