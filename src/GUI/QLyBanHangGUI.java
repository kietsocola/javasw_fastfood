package GUI;

import java.util.Vector;

import javax.swing.ImageIcon;
import java.util.ArrayList;

import java.awt.EventQueue;
import java.awt.CardLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

//import com.toedter.calendar.JDateChooser;

import BUS.CheBienBUS;
import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.NguyenLieuBUS;
import BUS.SanPhamBUS;
import Custom.MyPanel;
import Custom.MyTextField;
import DTO.ChiTietHoaDon;
import DTO.CongThuc;
import DTO.HoaDon;
import DTO.NguyenLieu;
import DTO.SanPham;
import Custom.MyLabel;
import Custom.MyButton;
import Custom.MyColor;
import Custom.MyLabelSecond;
import Custom.MyPanelSecond;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Custom.MyTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;

public class QLyBanHangGUI extends JPanel {

	private MyTextField txtMaSP;
	private MyTextField txtTenSP;
	private MyTextField txtDonGia;
	private MyTextField txtSoLuong, txtSoLuongCB;
	private DefaultTableModel modelTableHD, modelTableSP, modelTableGH, modelTableCTHD, modelTableNguyenLieuCB,
			modelTableSPCheBien;
	private MyTable tableSP, tableGH, tableHD, tableCTHD;
	private MyButton btnThemGioHang, btnXoaSP, btnXuatHD, btnTimKiem, btnTimKiemHD, btnCheBien;
	HoaDonBUS hdBUS = new HoaDonBUS();
	SanPhamBUS spBUS = new SanPhamBUS();
	CheBienBUS chebienBUS = new CheBienBUS();
	ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	NguyenLieuBUS nlBUS = new NguyenLieuBUS();

	private JTextField txtTimTheoTen;
	private JComboBox ngayBD, thangBD, namBD, ngayKT, thangKT, namKT;
	private MyTable tableSanPhamCheBien;
	private MyTable tableNguyenLieuCheBien;
//	private JDateChooser startDateChooser, endDateChooser;
//	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLyBanHangGUI window = new QLyBanHangGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public QLyBanHangGUI() {
		addControlsBanHang();
		addEventsBanHang();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void addControlsBanHang() {

		// panel chứa tab và các table
		this.setLayout(new BorderLayout());
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);
		//frame.getContentPane().add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));

		// panel chứa tab
		MyPanel panel_tab = new MyPanel();
		panel_main.add(panel_tab, BorderLayout.NORTH);
		panel_tab.setLayout(new BoxLayout(panel_tab, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("       ");
		panel_tab.add(lblNewLabel_4);

		MyLabelSecond tabBanHang = new MyLabelSecond("Bán hàng");
		tabBanHang.setText("  Bán hàng");
		tabBanHang.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabBanHang);

		MyLabelSecond tabHoaDon = new MyLabelSecond("Hóa đơn");
		tabHoaDon.setText("  Hóa đơn");
		tabHoaDon.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabHoaDon);

		CardLayout cardLayout = new CardLayout();

		JPanel panelCard = new JPanel(cardLayout);
		// panel chứa table và chi tiết
		MyPanelSecond panelTabBanHang = new MyPanelSecond();
		panelTabBanHang.setLayout(new BorderLayout(0, 0));
		panelCard.add(panelTabBanHang, "BanHang");

		// panel chứa table
		MyPanel panel_table = new MyPanel();
		panelTabBanHang.add(panel_table, BorderLayout.CENTER);
		panel_table.setLayout(new GridLayout(2, 1, 0, 0));
		panel_table.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		
		MyPanel panel_containtableSP = new MyPanel();
		panel_containtableSP.setLayout(new BorderLayout());
		panel_table.add(panel_containtableSP);
		MyPanelSecond panel_tableSP = new MyPanelSecond();
		panel_tableSP.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_containtableSP.add(panel_tableSP, BorderLayout.CENTER);
		MyPanel pnSpace = new MyPanel();
		pnSpace.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_containtableSP.add(pnSpace, BorderLayout.SOUTH);
		panel_tableSP.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblDSSP = new MyLabelSecond("Danh sách sản phẩm");
		panel_tableSP.add(lblDSSP, BorderLayout.NORTH);
		
		Color primaryColor = new Color(Integer.parseInt("39", 16), Integer.parseInt("3c", 16),
				Integer.parseInt("49", 16));
		// tạo table sản phẩm
		modelTableSP = new DefaultTableModel();
		modelTableSP.addColumn("Mã SP");
		modelTableSP.addColumn("Tên SP");
		modelTableSP.addColumn("Đơn giá");
		modelTableSP.addColumn("Còn lại");
		tableSP = new MyTable(modelTableSP);
		JScrollPane scrollPaneSP = new JScrollPane(tableSP);
		panel_tableSP.add(scrollPaneSP);
		scrollPaneSP.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		loadDataTableSanPham();
		clickTableBanHang();

		// tạo table giỏ hàng
		MyPanelSecond panel_tableGH = new MyPanelSecond();
		panel_tableGH.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_table.add(panel_tableGH);
		panel_tableGH.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblGIoHang = new MyLabelSecond("Giỏ hàng");
		panel_tableGH.add(lblGIoHang, BorderLayout.NORTH);
		modelTableGH = new DefaultTableModel();
		modelTableGH.addColumn("Mã SP");
		modelTableGH.addColumn("Tên SP");
		modelTableGH.addColumn("Số lượng");
		modelTableGH.addColumn("Đơn giá");
		modelTableGH.addColumn("Thành tiền");
		tableGH = new MyTable(modelTableGH);
		JScrollPane scrollPaneGH = new JScrollPane(tableGH);
		scrollPaneGH.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		panel_tableGH.add(scrollPaneGH);

		// panel chi tiết sp
		MyPanel panel_ContainDetailSP = new MyPanel();
		panel_ContainDetailSP.setLayout(new BorderLayout());
		MyPanelSecond panel_DetailSP = new MyPanelSecond();
		panel_ContainDetailSP.add(panel_DetailSP, BorderLayout.CENTER);
		panelTabBanHang.add(panel_ContainDetailSP, BorderLayout.EAST);
		panel_DetailSP.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		panel_DetailSP.setLayout(new BorderLayout());
		MyPanel pnSpace1 = new MyPanel();
		panel_ContainDetailSP.add(pnSpace1, BorderLayout.EAST);
		MyPanel pnSpace2 = new MyPanel();
		panel_ContainDetailSP.add(pnSpace2, BorderLayout.SOUTH);

		MyPanelSecond panel_TimSP = new MyPanelSecond();
		panel_DetailSP.add(panel_TimSP, BorderLayout.NORTH);
		panel_TimSP.setLayout(new BoxLayout(panel_TimSP, BoxLayout.Y_AXIS));

		MyPanelSecond panel_1 = new MyPanelSecond();
		panel_TimSP.add(panel_1);

//		MyLabelSecond lblNewLabel_2 = new MyLabelSecond("Tìm kiếm");
//		panel_1.add(lblNewLabel_2);

		MyPanelSecond panel_timTheoLoai = new MyPanelSecond();
		panel_timTheoLoai.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_TimSP.add(panel_timTheoLoai);
		panel_timTheoLoai.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblNewLabel = new MyLabelSecond("Chọn loại");
		panel_timTheoLoai.add(lblNewLabel, BorderLayout.WEST);

		// @SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		panel_timTheoLoai.add(comboBox, BorderLayout.CENTER);

		JPanel panel_TimTheoTen = new JPanel();
//		panel_TimTheoTen.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_TimSP.add(panel_TimTheoTen);
		panel_TimTheoTen.setLayout(new BorderLayout(0, 0));

		txtTimTheoTen = new JTextField();
		panel_TimTheoTen.add(txtTimTheoTen, BorderLayout.CENTER);
		txtTimTheoTen.setColumns(10);

		btnTimKiem = new MyButton("Tìm kiếm");
		ImageIcon iconTimkiem = new ImageIcon("images/loupe.png");
		Image img0 = iconTimkiem.getImage();
		Image newImg0 = img0.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconTimkiem.setImage(newImg0);
		btnTimKiem.setIcon(iconTimkiem);
		
		panel_TimTheoTen.add(btnTimKiem, BorderLayout.EAST);

		MyPanelSecond pnInput = new MyPanelSecond();
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		panel_DetailSP.add(pnInput, BorderLayout.CENTER);
//		MyPanel panel = new MyPanel();
//		pnInput.add(panel);
//		panel.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblNewLabel_1 = new MyLabelSecond("Chi tiết");
		lblNewLabel_1.setText("Chi tiết");
//		panel.add(lblNewLabel_1, BorderLayout.NORTH);
		pnInput.add(lblNewLabel_1);
		MyPanelSecond panel_MaSP = new MyPanelSecond();
		panel_MaSP.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_MaSP);
		panel_MaSP.setLayout(new BoxLayout(panel_MaSP, BoxLayout.X_AXIS));

		MyLabelSecond lblMaSP = new MyLabelSecond("Mã SP");
		panel_MaSP.add(lblMaSP);

		txtMaSP = new MyTextField();
		panel_MaSP.add(txtMaSP);
		txtMaSP.setColumns(10);

		MyPanelSecond panel_TenSP = new MyPanelSecond();
		panel_TenSP.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_TenSP);
		panel_TenSP.setLayout(new BoxLayout(panel_TenSP, BoxLayout.X_AXIS));

		MyLabelSecond lblTenSP = new MyLabelSecond("Tên SP");
		panel_TenSP.add(lblTenSP);

		txtTenSP = new MyTextField();
		panel_TenSP.add(txtTenSP);
		txtTenSP.setColumns(10);

		MyPanelSecond panel_DonGia = new MyPanelSecond();
		panel_DonGia.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_DonGia);
		panel_DonGia.setLayout(new BoxLayout(panel_DonGia, BoxLayout.X_AXIS));

		MyLabelSecond lblDonGia = new MyLabelSecond("Đơn giá");
		panel_DonGia.add(lblDonGia);

		txtDonGia = new MyTextField();
		panel_DonGia.add(txtDonGia);
		txtDonGia.setColumns(10);

		MyPanelSecond panel_SoLuong = new MyPanelSecond();
		panel_SoLuong.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_SoLuong);
		panel_SoLuong.setLayout(new BoxLayout(panel_SoLuong, BoxLayout.X_AXIS));

		MyLabelSecond lblSoLuong = new MyLabelSecond("Số lượng");
		panel_SoLuong.add(lblSoLuong);

		txtSoLuong = new MyTextField();
		panel_SoLuong.add(txtSoLuong);
		txtSoLuong.setColumns(10);

//		MyPanel panel_NhanVien = new MyPanel();
//		pnInput.add(panel_NhanVien);

//		MyLabelSecond lblNhanVien = new MyLabelSecond("Nhân viên");
//		panel_NhanVien.add(lblNhanVien);
//
//		txtNhanVien = new MyTextField();
//		panel_NhanVien.add(txtNhanVien);
//		txtNhanVien.setColumns(10);
//		MyPanel panel_ThemGH = new MyPanel();
//		panel_DetailSP.add(panel_ThemGH);

		// các button chức năng

		MyPanelSecond panel_HinhAnhSP = new MyPanelSecond();
		pnInput.add(panel_HinhAnhSP);

		MyPanelSecond pnBTN = new MyPanelSecond();
		pnBTN.setLayout(new BoxLayout(pnBTN, BoxLayout.Y_AXIS));
		panel_DetailSP.add(pnBTN, BorderLayout.SOUTH);
		btnThemGioHang = new MyButton("Thêm giỏ hàng");
		ImageIcon icon = new ImageIcon("images/cart.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		icon.setImage(newImg);
		btnThemGioHang.setIcon(icon);
		pnBTN.add(btnThemGioHang);

		MyPanelSecond panel_XoaSP_XuatHD = new MyPanelSecond();
		pnBTN.add(panel_XoaSP_XuatHD);

		btnXoaSP = new MyButton("Xóa");
		ImageIcon iconXoa = new ImageIcon("images/remove.png");
		Image img2 = iconXoa.getImage();
		Image newImg2 = img2.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconXoa.setImage(newImg2);
		btnXoaSP.setIcon(iconXoa);
		
		clickTableGioHang();
		panel_XoaSP_XuatHD.add(btnXoaSP);

		btnXuatHD = new MyButton("Xuất hóa đơn");
		ImageIcon iconXuatHD = new ImageIcon("images/invoice.png");
		Image img3 = iconXuatHD.getImage();
		Image newImg3 = img3.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconXuatHD.setImage(newImg3);
		btnXuatHD.setIcon(iconXuatHD);
		
		panel_XoaSP_XuatHD.add(btnXuatHD);

		MyPanelSecond panelTabHoaDon = new MyPanelSecond();
		panelTabHoaDon.setLayout(new BorderLayout(0, 0));
		

		MyPanel panel_tableHoaDon = new MyPanel();
		panel_tableHoaDon.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		panelTabHoaDon.add(panel_tableHoaDon, BorderLayout.CENTER);
		panel_tableHoaDon.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanelSecond panel_containTableHD = new MyPanelSecond();
		panel_containTableHD.setLayout(new BorderLayout());
		MyPanelSecond panel_tableHD = new MyPanelSecond();
		panel_containTableHD.add(panel_tableHD, BorderLayout.CENTER);
		MyPanel pnSpace3 = new MyPanel();
		pnSpace3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_containTableHD.add(pnSpace3, BorderLayout.SOUTH);
		panel_tableHoaDon.add(panel_containTableHD);
		panel_tableHD.setLayout(new BorderLayout(0, 0));
		panel_tableHD.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblDSHD = new MyLabelSecond("Danh sách hóa đơn");
		panel_tableHD.add(lblDSHD, BorderLayout.NORTH);
		
		
		
		/*=================================HÓA ĐƠN======================================*/
		
		
		// tạo table hóa đơn
		modelTableHD = new DefaultTableModel();
		modelTableHD.addColumn("Mã HD");
		modelTableHD.addColumn("Tổng tiền");
		modelTableHD.addColumn("Ngày lập");
		modelTableHD.addColumn("Ghi chú");

		loadDataTableHoaDon();
		tableHD = new MyTable(modelTableHD);
		JScrollPane scrollPaneHD = new JScrollPane(tableHD);
		panel_tableHD.add(scrollPaneHD);
		scrollPaneHD.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);

		// tạo table chi tiết hd
		MyPanelSecond panel_tableCTHD = new MyPanelSecond();
		panel_tableHoaDon.add(panel_tableCTHD);
		panel_tableCTHD.setLayout(new BorderLayout(0, 0));
		panel_tableCTHD.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblCTHoaDon = new MyLabelSecond("Chi tiết hóa đơn");
		panel_tableCTHD.add(lblCTHoaDon, BorderLayout.NORTH);
		modelTableCTHD = new DefaultTableModel();
		modelTableCTHD.addColumn("Mã SP");
		modelTableCTHD.addColumn("Tên SP");
		modelTableCTHD.addColumn("Số lượng");
		modelTableCTHD.addColumn("Đơn giá");
		modelTableCTHD.addColumn("Thành tiền");
		tableCTHD = new MyTable(modelTableCTHD);
		JScrollPane scrollPaneCTHD = new JScrollPane(tableCTHD);
		scrollPaneCTHD.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		panel_tableCTHD.add(scrollPaneCTHD);
		clickTableHoaDon();

		MyPanel Contain_Panel_HD_CTHD = new MyPanel();
		Contain_Panel_HD_CTHD.setLayout(new BorderLayout());
		MyPanel pnSpace4 = new MyPanel();
		Contain_Panel_HD_CTHD.add(pnSpace4, BorderLayout.EAST);
		MyPanel pnSpace5 = new MyPanel();
		Contain_Panel_HD_CTHD.add(pnSpace5, BorderLayout.SOUTH);
		MyPanelSecond panel_HD_CTHD = new MyPanelSecond();
		Contain_Panel_HD_CTHD.add(panel_HD_CTHD, BorderLayout.CENTER);
		
		panel_HD_CTHD.setLayout(new GridLayout(2, 1, 0, 0));
		panel_HD_CTHD.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		MyPanelSecond panel_xemHD = new MyPanelSecond();
		panel_xemHD.setLayout(new BorderLayout());
		MyPanelSecond panel_MaHD = new MyPanelSecond();
		panel_xemHD.add(panel_MaHD, BorderLayout.NORTH);
		panel_MaHD.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanelSecond panel_3 = new MyPanelSecond();
		panel_3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_MaHD.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		MyLabelSecond lblNewLabel_2 = new MyLabelSecond("Từ ngày");
		panel_3.add(lblNewLabel_2);
//		startDateChooser = new JDateChooser();
//		startDateChooser.setBackground(new Color(0, 0, 0));
//		startDateChooser.setPreferredSize(new Dimension(120, 30));
//		startDateChooser.setForeground(Color.BLUE); // Thiết lập màu chữ
//		startDateChooser.setFont(new Font("Arial", Font.BOLD, 14)); // Thiết lập font chữ
//		panel_3.add(startDateChooser);
		
//		ngayBD = new JComboBox();
//		panel_3.add(ngayBD);
//
//		thangBD = new JComboBox();
//		panel_3.add(thangBD);
//
//		namBD = new JComboBox();
//		panel_3.add(namBD);
//
		MyPanelSecond panel_2 = new MyPanelSecond();
		panel_MaHD.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
//
		MyLabelSecond lblNewLabel_3 = new MyLabelSecond("Tới ngày");
		panel_2.add(lblNewLabel_3);
//		endDateChooser = new JDateChooser();
//		endDateChooser.setBackground(new Color(0, 0, 0));
//		endDateChooser.setPreferredSize(new Dimension(120, 30));
//		panel_2.add(endDateChooser);
//
//		ngayKT = new JComboBox();
//		panel_2.add(ngayKT);
//
//		thangKT = new JComboBox();
//		panel_2.add(thangKT);
//
//		namKT = new JComboBox();
//		panel_2.add(namKT);
//
//		for (int i = 1; i <= 31; i++) {
//			ngayBD.addItem(i);
//			ngayKT.addItem(i);
//		}
//
//		// Thêm số lựa chọn cho các JComboBox tháng (ví dụ: từ 1 đến 12)
//		for (int i = 1; i <= 12; i++) {
//			thangBD.addItem(i);
//			thangKT.addItem(i);
//		}
//
//		// Thêm số lựa chọn cho các JComboBox năm (ví dụ: từ 2000 đến 2025)
//		for (int i = 2000; i <= 2025; i++) {
//			namBD.addItem(i);
//			namKT.addItem(i);
//		}
		MyPanelSecond panel_NgayTaoHD = new MyPanelSecond();
		panel_xemHD.add(panel_NgayTaoHD, BorderLayout.SOUTH);

		btnTimKiemHD = new MyButton("Tìm");
		panel_NgayTaoHD.add(btnTimKiemHD);

		panel_HD_CTHD.add(panel_xemHD);

		MyPanelSecond panel_xemCTHD = new MyPanelSecond();
		panel_xemCTHD.setLayout(new BoxLayout(panel_xemCTHD, BoxLayout.Y_AXIS));
		MyLabelSecond lblMaCTHD = new MyLabelSecond("Mã CTHD");
		MyTextField txtMaCTHD = new MyTextField();
		MyPanelSecond panel_MaCTHD = new MyPanelSecond();
		panel_MaCTHD.add(lblMaCTHD);
		panel_MaCTHD.add(txtMaCTHD);
		panel_xemCTHD.add(panel_MaCTHD);
		panel_HD_CTHD.add(panel_xemCTHD);

		panelTabHoaDon.add(Contain_Panel_HD_CTHD, BorderLayout.EAST);

		panelCard.add(panelTabHoaDon, "HoaDon");
		panel_main.add(panelCard);

		// ================================Menu chế biến=============================================
		MyLabelSecond tabCheBien = new MyLabelSecond("CheBien");
		tabCheBien.setText("  Chế biến");
		tabCheBien.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabCheBien);

		MyPanel panelMenuCheBien = new MyPanel();
		panelCard.add(panelMenuCheBien, "CheBien");
		panelMenuCheBien.setLayout(new BorderLayout(0, 0));

		MyPanel Contain_panelBtnCheBien = new MyPanel();
		Contain_panelBtnCheBien.setLayout(new BorderLayout());
		MyPanel pnSpace7 = new MyPanel();
		Contain_panelBtnCheBien.add(pnSpace7, BorderLayout.SOUTH);
		MyPanelSecond panelBtnCheBien = new MyPanelSecond();
		Contain_panelBtnCheBien.add(panelBtnCheBien, BorderLayout.CENTER);
		panelMenuCheBien.add(Contain_panelBtnCheBien, BorderLayout.EAST);
		panelMenuCheBien.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		panelBtnCheBien.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txtSoLuongCB = new MyTextField();
		panelBtnCheBien.add(txtSoLuongCB);
		txtSoLuongCB.setColumns(10);
		btnCheBien = new MyButton("Chế biến");
		panelBtnCheBien.add(btnCheBien);

		MyPanel panelTableCheBien = new MyPanel();
		panelTableCheBien.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		panelMenuCheBien.add(panelTableCheBien, BorderLayout.CENTER);
		panelTableCheBien.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanel Contain_PanelTableSanPham = new MyPanel();
		Contain_PanelTableSanPham.setLayout(new BorderLayout());
		MyPanel pnSpace6 = new MyPanel();
		pnSpace6.setBorder(new EmptyBorder(0, 0, 5, 0));
		Contain_PanelTableSanPham.add(pnSpace6, BorderLayout.SOUTH);
		MyPanelSecond panelTableSanPham = new MyPanelSecond();
		Contain_PanelTableSanPham.add(panelTableSanPham, BorderLayout.CENTER);
		panelTableCheBien.add(Contain_PanelTableSanPham);
		panelTableSanPham.setLayout(new BorderLayout(0, 0));
		panelTableSanPham.setBorder(new EmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblSanPhamCheBien = new MyLabelSecond("Sản phẩm");
		panelTableSanPham.add(lblSanPhamCheBien, BorderLayout.NORTH);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		panelTableSanPham.add(scrollPaneSanPham, BorderLayout.CENTER);

		modelTableSPCheBien = new DefaultTableModel();
		modelTableSPCheBien.addColumn("Mã SP");
		modelTableSPCheBien.addColumn("Tên SP");
		modelTableSPCheBien.addColumn("Đơn giá");
		modelTableSPCheBien.addColumn("Còn lại");
		tableSanPhamCheBien = new MyTable(modelTableSPCheBien);
		scrollPaneSanPham.setViewportView(tableSanPhamCheBien);
		scrollPaneSanPham.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		clickTableSanPhamCheBien();

		MyPanelSecond panelCongThucCheBien = new MyPanelSecond();
		panelCongThucCheBien.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelTableCheBien.add(panelCongThucCheBien);
		panelCongThucCheBien.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblCTCB = new MyLabelSecond("Nguyên liệu");
		panelCongThucCheBien.add(lblCTCB, BorderLayout.NORTH);

		JScrollPane scrollPaneNguyenLieu = new JScrollPane();
		panelCongThucCheBien.add(scrollPaneNguyenLieu, BorderLayout.CENTER);
		scrollPaneNguyenLieu.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);

		modelTableNguyenLieuCB = new DefaultTableModel();
		modelTableNguyenLieuCB.addColumn("Mã SP");
		modelTableNguyenLieuCB.addColumn("Mã NL");
		modelTableNguyenLieuCB.addColumn("Tên nguyên liệu");
		modelTableNguyenLieuCB.addColumn("Số lượng cần");
		modelTableNguyenLieuCB.addColumn("Số lượng còn lại");
		tableNguyenLieuCheBien = new MyTable(modelTableNguyenLieuCB);
		scrollPaneNguyenLieu.setViewportView(tableNguyenLieuCheBien);
		loadDataTableSanPhamCB();

		// =============================================================================

		// chuyển tab
		tabBanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "BanHang");
//				tabBanHang.setForeground(MyColor.PRIMARY_TEXT_COLOR);
//				tabHoaDon.setForeground(Color.WHITE);
//				tabCheBien.setForeground(Color.WHITE);
				tabBanHang.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
				tabBanHang.setOpaque(true);
				tabCheBien.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
				tabHoaDon.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
			}
		});
		tabHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "HoaDon");
//				tabBanHang.setForeground(Color.WHITE);
//				tabHoaDon.setForeground(Color.BLUE);
//				tabCheBien.setForeground(Color.WHITE);
				tabHoaDon.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
				tabHoaDon.setOpaque(true);
				tabBanHang.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
				tabCheBien.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
			}
		});
		tabCheBien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "CheBien");
//				tabCheBien.setForeground(Color.BLUE);
//				tabBanHang.setForeground(Color.WHITE);
//				tabHoaDon.setForeground(Color.WHITE);
				tabCheBien.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
				tabCheBien.setOpaque(true);
				tabBanHang.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
				tabHoaDon.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
			}
		});

	}

	private void addEventsBanHang() {
		btnCheBien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				xulyCheBien();

			}
		});
		btnTimKiemHD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				timTheoKhoangNgay();

			}
		});
		btnTimKiem.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				timSPTheoTen();
			}
		});
		btnXoaSP.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				xoaSPfromGioHang();
				btnXoaSP.setEnabled(false);
			}
		});
		btnXuatHD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				luuHoaDon();

			}
		});
		btnThemGioHang.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				themVaoGioHang();
			}
		});
	}

	private void loadDataTableHoaDon() {
		ArrayList<HoaDon> listHD = hdBUS.getListHoaDon();
		addDataToTableHoaDon(listHD);
	}

	private void addDataToTableHoaDon(ArrayList<HoaDon> listHD) {
		modelTableHD.setRowCount(0);
		for (HoaDon hd : listHD) {
			Vector<String> vec = new Vector<>();
			vec.add(hd.getidHD() + "");
			vec.add(hd.getTongTien() + "");
			vec.add(hd.getNgayLap() + "");
			vec.add(hd.getGhiChu());
			modelTableHD.addRow(vec);
		}
	}

	private void loadDataTableSanPham() {
		ArrayList<SanPham> listSP = spBUS.getDSSanPham();
		addDataToTableSanPham(listSP);
	}

	private void addDataToTableSanPham(ArrayList<SanPham> listSP) {
		modelTableSP.setRowCount(0);
		for (SanPham sp : listSP) {
			Vector<String> vec = new Vector<>();
			vec.add(sp.getId() + "");
			vec.add(sp.getTenSP());
			vec.add(sp.getDonGia() + "");
			vec.add(sp.getSoLuong() + "");
			modelTableSP.addRow(vec);
		}
	}

	private void clickTableBanHang() {
		ListSelectionModel selectionModel = tableSP.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableSP.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					String ma = tableSP.getValueAt(selectedRow, 0) + "";
					String ten = tableSP.getValueAt(selectedRow, 1) + "";
					String donGia = tableSP.getValueAt(selectedRow, 2) + "";
//                    int soLuongConLai = Integer.parseInt(tableSP.getValueAt(selectedRow, 3)+"");
					txtMaSP.setText(ma);
					txtTenSP.setText(ten);
					txtDonGia.setText(donGia);
				}
			}
		});
	}

	private void clickTableGioHang() {
		btnXoaSP.setEnabled(false);
		ListSelectionModel selectionModel = tableGH.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableSP.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					// do something
					btnXoaSP.setEnabled(true);
				} else {
				}
			}
		});
	}

	private void clickTableHoaDon() {
		ListSelectionModel selectionModel = tableHD.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableHD.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int maHD = Integer.parseInt(tableHD.getValueAt(selectedRow, 0) + "");
					ArrayList<ChiTietHoaDon> listCTHD = cthdBUS.getListCTHDtheoIdHoaDon(maHD);
					addDataTableCTHD(listCTHD);
				}
			}
		});

	}

	private void addDataTableCTHD(ArrayList<ChiTietHoaDon> listCTHD) {
		modelTableCTHD.setRowCount(0);
		for (ChiTietHoaDon ct : listCTHD) {
			Vector<String> vec = new Vector<>();
			vec.add(ct.getIdSanPham() + "");
			vec.add(ct.getIdHoaDon() + "");
			vec.add(ct.getDonGia() + "");
			vec.add(ct.getSoLuong() + "");
			vec.add(ct.getThanhTien() + "");
			modelTableCTHD.addRow(vec);
		}
	}

	private void themVaoGioHang() {
		int row = tableSP.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String soLuong = txtSoLuong.getText();
		if (soLuong.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String ma = txtMaSP.getText();
		String ten = txtTenSP.getText();
		String donGia = txtDonGia.getText();

		txtMaSP.setText("");
		txtTenSP.setText("");
		txtDonGia.setText("");
		txtSoLuong.setText("");

		String thanhTien = String.valueOf(Integer.parseInt(donGia) * Integer.parseInt(soLuong));

		Vector<String> vec = new Vector<>();
		vec.add(ma);
		vec.add(ten);
		vec.add(donGia);
		vec.add(soLuong);
		vec.add(thanhTien);
		modelTableGH.addRow(vec);
	}

	private void luuHoaDon() {
		int total = 0;
		for (int i = 0; i < modelTableGH.getRowCount(); i++) {
			total += Integer.parseInt(modelTableGH.getValueAt(i, 4) + "");
			String maSP = modelTableGH.getValueAt(i, 0) + "";
			String donGia = modelTableGH.getValueAt(i, 2) + "";
			String soLuong = modelTableGH.getValueAt(i, 3) + "";
			String thanhTien = modelTableGH.getValueAt(i, 4) + "";

			cthdBUS.addChiTietHoaDon(maSP, soLuong, donGia, thanhTien);
		}
		hdBUS.luuHoaDon(1, 1, total, "Đã thanh toán");
	}

	private void xoaSPfromGioHang() {
		int selectedRow = tableGH.getSelectedRow();
		if (selectedRow != -1) { // Nếu có hàng được chọn
			DefaultTableModel model = (DefaultTableModel) tableGH.getModel();
			model.removeRow(selectedRow);
		}
	}

	private void timSPTheoTen() {
		modelTableSP.setRowCount(0);
		String ten = txtTimTheoTen.getText();
		ArrayList<SanPham> dssp = spBUS.getSanPhamTheoTen(ten);
		for (SanPham sp : dssp) {
			Vector<String> vec = new Vector<>();
			vec.add(sp.getId() + "");
			vec.add(sp.getTenSP() + "");
			vec.add(sp.getDonGia() + "");
			vec.add(sp.getSoLuong() + "");
			modelTableSP.addRow(vec);
		}
	}

	private void timTheoKhoangNgay() {
//		java.util.Date utilStartDate = startDateChooser.getDate();
//		java.util.Date utilEndDate = endDateChooser.getDate();
//		ArrayList<HoaDon> dshd = hdBUS.getListHoaDonTheoNgay(utilStartDate, utilEndDate);
//		addDataToTableHoaDon(dshd);
	}

	private void clickTableSanPhamCheBien() {
		ListSelectionModel selectionModel = tableSanPhamCheBien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableSanPhamCheBien.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int maSP = Integer.parseInt(tableSanPhamCheBien.getValueAt(selectedRow, 0) + "");
					ArrayList<CongThuc> listCT = chebienBUS.getCongThucbyIdSanPham(maSP);
					addDataTableNguyenLieu(listCT);
				}
			}
		});

	}

	private void addDataTableNguyenLieu(ArrayList<CongThuc> listCT) {
		modelTableNguyenLieuCB.setRowCount(0);
		for (CongThuc ct : listCT) {
			Vector<String> vec = new Vector<>();
			vec.add(ct.getIdSanPham() + "");
			vec.add(ct.getIdNguyenLieu() + "");
			NguyenLieu nl = nlBUS.getNguyenLieubyId(ct.getIdNguyenLieu());
			vec.add(nl.getTenNL());
			vec.add(ct.getSoLuongDung() + "");
			vec.add(nl.getsoLuongNL() + "");
			modelTableNguyenLieuCB.addRow(vec);
		}
	}

	private void loadDataTableSanPhamCB() {
		ArrayList<SanPham> listSP = spBUS.getDSSanPham();
		addDataToTableSanPhamCB(listSP);
	}

	private void addDataToTableSanPhamCB(ArrayList<SanPham> listSP) {
		modelTableSPCheBien.setRowCount(0);
		for (SanPham sp : listSP) {
			Vector<String> vec = new Vector<>();
			vec.add(sp.getId() + "");
			vec.add(sp.getTenSP());
			vec.add(sp.getDonGia() + "");
			vec.add(sp.getSoLuong() + "");
			modelTableSPCheBien.addRow(vec);
		}
	}

	private void xulyCheBien() {
		if (txtSoLuongCB.getText() == "") {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int soLuong=0;
		try {			
			soLuong = Integer.parseInt(txtSoLuongCB.getText().trim() + "");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (soLuong == 0) {
			JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		for (int row = 0; row < modelTableNguyenLieuCB.getRowCount(); row++) {
			int soLuong0 = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 3) + "");
			int soLuongCan = soLuong0 * soLuong;
			int soLuongConLai = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 4) + "");
			if (soLuongCan > soLuongConLai) {
				return;
			}

		}
		boolean rs = true;
		int maSP = -1;
		for (int row = 0; row < modelTableNguyenLieuCB.getRowCount(); row++) {
			int soLuong0 = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 3) + "");
			int soLuongCan = soLuong0 * soLuong;
			int idNL = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 1) + "");
			rs = chebienBUS.giamSoLuongNLkhiCheBien(idNL, soLuongCan);
			maSP = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 0) + "");
		}
		if (rs == true) {
			spBUS.tangSoLuongSP(maSP, soLuong);
		}
	}

}