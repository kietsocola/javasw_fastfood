package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import Custom.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import BUS.SanPhamBUS;
import DTO.SanPham;

import java.awt.Component;
import java.awt.ComponentOrientation;
public class SanPhamGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblSanPham;
	private DefaultTableModel dtmSanPham;
	private MyLabelSecond lblMaSP, lblTenSP, lblLoaiSP, lblSoLuong,lblCongThuc, lblDonGia, lblHinhAnh;
	private MyButton btnThem,btnXoa,btnSua,btnChonAnh;
	private MyTextField txtMaSP, txtTenSP, txtSoLuong,txtCongThuc, txtDonGia;
	private JComboBox<String> cmbLoaiSP;
	private SanPhamBUS spBUS = new SanPhamBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamGUI frame = new SanPhamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SanPhamGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 800);
		contentPane = new MyPanelSecond();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 0));
		
		MyPanel panel_category = new MyPanel();
//		panel_Category.setToolTipText("");
		contentPane.add(panel_category, BorderLayout.WEST);
		panel_category.setLayout(new BoxLayout(panel_category, BoxLayout.Y_AXIS));
		
		MyLabel panel_logo = new MyLabel("");
		panel_category.add(panel_logo);
		
		MyLabel lblBanHang = new MyLabel("New label");
		lblBanHang.setText("Bán Hàng");
		panel_category.add(lblBanHang);
		
		MyLabel lblKhuyenMai = new MyLabel("New label");
		lblKhuyenMai.setText("Khuyến Mãi");
		panel_category.add(lblKhuyenMai);
		
		MyLabel lblSanPham = new MyLabel("New label");
		lblSanPham.setText("Sản Phẩm");
		panel_category.add(lblSanPham);
		
		MyLabel lblNhanVien = new MyLabel("New label");
		lblNhanVien.setText("Nhân viên");
		panel_category.add(lblNhanVien);
		
		MyLabel lblKhachHang = new MyLabel("New label");
		lblKhachHang.setText("Khách hàng");
		panel_category.add(lblKhachHang);
		
		MyLabel lblNhapHang = new MyLabel("New label");
		lblNhapHang.setText("Nhập hàng");
		panel_category.add(lblNhapHang);
		
		MyLabel lblThongKe = new MyLabel("New label");
		lblThongKe.setText("Thống kê");
		panel_category.add(lblThongKe);
		
		MyPanelSecond panel_main = new MyPanelSecond();
		contentPane.add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));
// ------------------------------------------------------------------------------------------------------		
		MyPanelSecond panel_input = new MyPanelSecond();
		panel_main.add(panel_input, BorderLayout.NORTH);
		panel_input.setLayout(new BorderLayout(10, 10));
		
		MyLabel lblNewLabel = new MyLabel("Quản lý sản phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblNewLabel, BorderLayout.NORTH);
		
		MyPanelSecond pnInputOptions = new MyPanelSecond();
		panel_input.add(pnInputOptions,BorderLayout.CENTER);
		pnInputOptions.setLayout(new BoxLayout(pnInputOptions, BoxLayout.Y_AXIS));
		
		MyPanel pnMaSP = new MyPanel();
		txtMaSP = new MyTextField();
		lblMaSP = new MyLabelSecond("Mã SP");
		pnMaSP.add(lblMaSP);
		pnMaSP.add(txtMaSP);
		
		MyPanel pnTenSP = new MyPanel();
		txtTenSP = new MyTextField();
		lblTenSP = new MyLabelSecond("Tên SP");
		pnTenSP.add(lblTenSP);
		pnTenSP.add(txtTenSP);
 		
		MyPanel pnLoai = new MyPanel();
		cmbLoaiSP = new JComboBox<String>();
		lblLoaiSP = new MyLabelSecond("Loại");
		pnLoai.add(lblLoaiSP);
		pnLoai.add(cmbLoaiSP);
		
		MyPanel pnSoLuong = new MyPanel();
		txtSoLuong = new MyTextField();
		lblSoLuong = new MyLabelSecond("Số lượng");
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		
		MyPanel pnCongThuc = new MyPanel();
		txtCongThuc = new MyTextField();
		lblCongThuc = new MyLabelSecond("Công Thức");
		pnCongThuc.add(lblCongThuc);
		pnCongThuc.add(txtCongThuc);
		
		MyPanel pnDonGia = new MyPanel();
		txtDonGia = new MyTextField();
		lblDonGia = new MyLabelSecond("Đơn giá");
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		
		pnInputOptions.add(pnMaSP);
		pnInputOptions.add(pnTenSP);
		pnInputOptions.add(pnLoai);
		pnInputOptions.add(pnSoLuong);
		pnInputOptions.add(pnCongThuc);
		pnInputOptions.add(pnDonGia);
		
		//Panel Ảnh
		MyPanel pnAnh = new MyPanel();
		pnAnh.setPreferredSize(new Dimension(300, 10));
		panel_input.add(pnAnh,BorderLayout.EAST);
		JPanel pnChuaAnh = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnChuaAnh.getLayout();
		pnChuaAnh.setMaximumSize(new Dimension(120, 120));
		pnChuaAnh.setPreferredSize(new Dimension(120, 120));
        
		MyPanel pnButtonAnh = new MyPanel();
		pnButtonAnh.setPreferredSize(new Dimension(
                (int) pnChuaAnh.getPreferredSize().getHeight(), 40));
        pnAnh.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        pnAnh.add(pnChuaAnh);
        pnAnh.add(pnButtonAnh);
        btnChonAnh = new  MyButton("Chọn Ảnh");
        pnButtonAnh.add(btnChonAnh);
        //Panel nút
        MyPanel pnButton = new MyPanel();
        pnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnThem = new MyButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnXoa = new MyButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSua = new MyButton("Sửa");
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa);
        
        panel_input.add(pnButton,BorderLayout.SOUTH);
// ------------------------------------------------------------------------------------------------------ 
		// Bảng Sản phẩm
// ------------------------------------------------------------------------------------------------------
		MyPanelSecond panel_table = new MyPanelSecond();
		panel_main.add(panel_table, BorderLayout.CENTER);
	
		dtmSanPham = new DefaultTableModel();
		dtmSanPham.addColumn("Mã sản phẩm");
		dtmSanPham.addColumn("Tên sản phẩm");
		dtmSanPham.addColumn("Loại");
		dtmSanPham.addColumn("Số lượng");
		dtmSanPham.addColumn("Công thức");
		dtmSanPham.addColumn("Đơn giá");
		dtmSanPham.addColumn("Ảnh");
		
		tblSanPham = new JTable();
		tblSanPham.setModel(dtmSanPham);
		loadDataToTblSanPham();
		Color primaryColor = new Color(Integer.parseInt("39", 16), Integer.parseInt("3c", 16), Integer.parseInt("49", 16));
		JScrollPane  scrTableSanPham= new JScrollPane(tblSanPham);
		scrTableSanPham.getViewport().setBackground(primaryColor);
		panel_table.setLayout(new BorderLayout(0, 0));
		panel_table.add(scrTableSanPham, BorderLayout.NORTH);
//---------------------------------------------------------------------------------------------		

	}
	private void loadDataToTblSanPham() {
		spBUS.docListSanPham();
		dtmSanPham.setRowCount(0);
		
		ArrayList <SanPham> dssp = spBUS.getDSSanPham();
		
		for (SanPham sp : dssp) {
			Vector vec = new Vector();
			vec.add(sp.getMaSP());
			vec.add(sp.getTenSP());
			vec.add(sp.getMaLoai());
			vec.add(sp.getSoLuong());
			vec.add(sp.getMaCongThuc());
			vec.add(sp.getDonGia());
			vec.add(sp.getHinhAnh());
			
			dtmSanPham.addRow(vec);
		}
	}

}
