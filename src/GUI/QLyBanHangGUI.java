package GUI;

import java.util.Vector;
import java.util.ArrayList;

import java.awt.EventQueue;
import java.awt.CardLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

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
import Custom.MyLabelSecond;
import Custom.MyPanelSecond;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class QLyBanHangGUI {

	private JFrame frame;
	private MyTextField txtMaSP;
	private MyTextField txtTenSP;
	private MyTextField txtDonGia;
	private MyTextField txtSoLuong, txtSoLuongCB;
//	private MyTextField txtNhanVien;
	private DefaultTableModel modelTableHD, modelTableSP, modelTableGH, modelTableCTHD, modelTableNguyenLieuCB, modelTableSPCheBien;
	private JTable tableSP, tableGH, tableHD, tableCTHD;
	private MyButton btnThemGioHang, btnXoaSP, btnXuatHD, btnTimKiem, btnTimKiemHD, btnCheBien;

	HoaDonBUS hdBUS = new HoaDonBUS();
	SanPhamBUS spBUS = new SanPhamBUS();
	CheBienBUS chebienBUS = new CheBienBUS();
	ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	NguyenLieuBUS nlBUS = new NguyenLieuBUS();
	
	private JTextField txtTimTheoTen;
	private JComboBox ngayBD, thangBD, namBD, ngayKT, thangKT, namKT;
	private JTable tableSanPhamCheBien;
	private JTable tableNguyenLieuCheBien;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLyBanHangGUI window = new QLyBanHangGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QLyBanHangGUI() {
		initialize();
		addEventsBanHang();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
//		frame.pack();

		MyPanel panel_Category = new MyPanel();
		frame.getContentPane().add(panel_Category, BorderLayout.WEST);
		panel_Category.setLayout(new BoxLayout(panel_Category, BoxLayout.Y_AXIS));

		// các option cho menu
		MyLabel panel_logo = new MyLabel("");
		panel_Category.add(panel_logo);

		MyLabel lblBanHang = new MyLabel("Bán hàng");
		panel_Category.add(lblBanHang);

		MyLabel lblKhuyenMai = new MyLabel("Khuyến mãi");
		panel_Category.add(lblKhuyenMai);

		MyLabel lblSanPham = new MyLabel("Sản phẩm");
		panel_Category.add(lblSanPham);

		MyLabel lblNhanvien = new MyLabel("Nhân viên");
		panel_Category.add(lblNhanvien);

		MyLabel lblKhachhang = new MyLabel("Khách hàng");
		panel_Category.add(lblKhachhang);

		MyLabel lblNhapHang = new MyLabel("Nhập hàng");
		panel_Category.add(lblNhapHang);

		MyLabel lblThongKe = new MyLabel("Thống kê");
		panel_Category.add(lblThongKe);

		// panel chứa tab và các table
		MyPanelSecond panel_main = new MyPanelSecond();
		frame.getContentPane().add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));

		// panel chứa tab
		MyPanel panel_tab = new MyPanel();
		panel_main.add(panel_tab, BorderLayout.NORTH);
		panel_tab.setLayout(new BoxLayout(panel_tab, BoxLayout.X_AXIS));

		MyLabelSecond tabBanHang = new MyLabelSecond("Bán hàng");
		tabBanHang.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabBanHang);

		MyLabelSecond tabHoaDon = new MyLabelSecond("Hóa đơn");
		tabHoaDon.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabHoaDon);

		CardLayout cardLayout = new CardLayout();

		JPanel panelCard = new JPanel(cardLayout);
		// panel chứa table và chi tiết
		MyPanelSecond panelTabBanHang = new MyPanelSecond();
		panelTabBanHang.setLayout(new BorderLayout(0, 0));
		panelCard.add(panelTabBanHang, "BanHang");

		// panel chứa table
		MyPanelSecond panel_table = new MyPanelSecond();
		panelTabBanHang.add(panel_table, BorderLayout.CENTER);
		panel_table.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanelSecond panel_tableSP = new MyPanelSecond();
		panel_table.add(panel_tableSP);
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
		tableSP = new JTable(modelTableSP);
		JScrollPane scrollPaneSP = new JScrollPane(tableSP);
		panel_tableSP.add(scrollPaneSP);
		scrollPaneSP.getViewport().setBackground(primaryColor);
		loadDataTableSanPham();
		clickTableBanHang();

		// tạo table giỏ hàng
		MyPanelSecond panel_tableGH = new MyPanelSecond();
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
		tableGH = new JTable(modelTableGH);
		JScrollPane scrollPaneGH = new JScrollPane(tableGH);
		scrollPaneGH.getViewport().setBackground(primaryColor);
		panel_tableGH.add(scrollPaneGH);

		// panel chi tiết sp
		MyPanel panel_DetailSP = new MyPanel();
		panelTabBanHang.add(panel_DetailSP, BorderLayout.EAST);
		panel_DetailSP.setLayout(new BoxLayout(panel_DetailSP, BoxLayout.Y_AXIS));

		MyPanel panel_TimSP = new MyPanel();
		panel_DetailSP.add(panel_TimSP);
		panel_TimSP.setLayout(new BoxLayout(panel_TimSP, BoxLayout.Y_AXIS));

		MyPanel panel_1 = new MyPanel();
		panel_TimSP.add(panel_1);

//		MyLabelSecond lblNewLabel_2 = new MyLabelSecond("Tìm kiếm");
//		panel_1.add(lblNewLabel_2);

		MyPanel panel_timTheoLoai = new MyPanel();
		panel_TimSP.add(panel_timTheoLoai);
		panel_timTheoLoai.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblNewLabel = new MyLabelSecond("Chọn loại");
		panel_timTheoLoai.add(lblNewLabel, BorderLayout.WEST);

		// @SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		panel_timTheoLoai.add(comboBox, BorderLayout.CENTER);

		JPanel panel_TimTheoTen = new JPanel();
		panel_TimSP.add(panel_TimTheoTen);
		panel_TimTheoTen.setLayout(new BorderLayout(0, 0));

		txtTimTheoTen = new JTextField();
		panel_TimTheoTen.add(txtTimTheoTen, BorderLayout.CENTER);
		txtTimTheoTen.setColumns(10);

		btnTimKiem = new MyButton("Tìm kiếm");
		panel_TimTheoTen.add(btnTimKiem, BorderLayout.EAST);

		MyPanel panel = new MyPanel();
		panel_DetailSP.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblNewLabel_1 = new MyLabelSecond("Chi tiết");
		lblNewLabel_1.setText("Chi tiết sản phẩm");
		panel.add(lblNewLabel_1, BorderLayout.CENTER);

		MyPanel panel_MaSP = new MyPanel();
		panel_DetailSP.add(panel_MaSP);

		MyLabelSecond lblMaSP = new MyLabelSecond("Mã SP");
		panel_MaSP.add(lblMaSP);

		txtMaSP = new MyTextField();
		panel_MaSP.add(txtMaSP);
		txtMaSP.setColumns(10);

		MyPanel panel_TenSP = new MyPanel();
		panel_DetailSP.add(panel_TenSP);

		MyLabelSecond lblTenSP = new MyLabelSecond("Tên SP");
		panel_TenSP.add(lblTenSP);

		txtTenSP = new MyTextField();
		panel_TenSP.add(txtTenSP);
		txtTenSP.setColumns(10);

		MyPanel panel_DonGia = new MyPanel();
		panel_DetailSP.add(panel_DonGia);

		MyLabelSecond lblDonGia = new MyLabelSecond("Đơn giá");
		panel_DonGia.add(lblDonGia);

		txtDonGia = new MyTextField();
		panel_DonGia.add(txtDonGia);
		txtDonGia.setColumns(10);

		MyPanel panel_SoLuong = new MyPanel();
		panel_DetailSP.add(panel_SoLuong);

		MyLabelSecond lblSoLuong = new MyLabelSecond("Số lượng");
		panel_SoLuong.add(lblSoLuong);

		txtSoLuong = new MyTextField();
		panel_SoLuong.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		MyPanel panel_NhanVien = new MyPanel();
		panel_DetailSP.add(panel_NhanVien);

//		MyLabelSecond lblNhanVien = new MyLabelSecond("Nhân viên");
//		panel_NhanVien.add(lblNhanVien);
//
//		txtNhanVien = new MyTextField();
//		panel_NhanVien.add(txtNhanVien);
//		txtNhanVien.setColumns(10);

		MyPanel panel_ThemGH = new MyPanel();
		panel_DetailSP.add(panel_ThemGH);

		// các button chức năng
		btnThemGioHang = new MyButton("Thêm giỏ hàng");
		panel_ThemGH.add(btnThemGioHang);

		MyPanel panel_HinhAnhSP = new MyPanel();
		panel_DetailSP.add(panel_HinhAnhSP);

		MyPanel panel_XoaSP_XuatHD = new MyPanel();
		panel_DetailSP.add(panel_XoaSP_XuatHD);

		btnXoaSP = new MyButton("Xóa");
		clickTableGioHang();
		panel_XoaSP_XuatHD.add(btnXoaSP);

		btnXuatHD = new MyButton("Xuất hóa đơn");
		panel_XoaSP_XuatHD.add(btnXuatHD);

		MyPanelSecond panelTabHoaDon = new MyPanelSecond();
		panelTabHoaDon.setLayout(new BorderLayout(0, 0));

		MyPanelSecond panel_tableHoaDon = new MyPanelSecond();
		panelTabHoaDon.add(panel_tableHoaDon, BorderLayout.CENTER);
		panel_tableHoaDon.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanelSecond panel_tableHD = new MyPanelSecond();
		panel_tableHoaDon.add(panel_tableHD);
		panel_tableHD.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblDSHD = new MyLabelSecond("Danh sách hóa đơn");
		panel_tableHD.add(lblDSHD, BorderLayout.NORTH);

		// tạo table hóa đơn
		modelTableHD = new DefaultTableModel();
		modelTableHD.addColumn("Mã HD");
		modelTableHD.addColumn("Tổng tiền");
		modelTableHD.addColumn("Ngày lập");
		modelTableHD.addColumn("Ghi chú");

		loadDataTableHoaDon();
		tableHD = new JTable(modelTableHD);
		JScrollPane scrollPaneHD = new JScrollPane(tableHD);
		panel_tableHD.add(scrollPaneHD);
		scrollPaneHD.getViewport().setBackground(primaryColor);

		// tạo table chi tiết hd
		MyPanelSecond panel_tableCTHD = new MyPanelSecond();
		panel_tableHoaDon.add(panel_tableCTHD);
		panel_tableCTHD.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblCTHoaDon = new MyLabelSecond("Chi tiết hóa đơn");
		panel_tableCTHD.add(lblCTHoaDon, BorderLayout.NORTH);
		modelTableCTHD = new DefaultTableModel();
		modelTableCTHD.addColumn("Mã SP");
		modelTableCTHD.addColumn("Tên SP");
		modelTableCTHD.addColumn("Số lượng");
		modelTableCTHD.addColumn("Đơn giá");
		modelTableCTHD.addColumn("Thành tiền");
		tableCTHD = new JTable(modelTableCTHD);
		JScrollPane scrollPaneCTHD = new JScrollPane(tableCTHD);
		scrollPaneCTHD.getViewport().setBackground(primaryColor);
		panel_tableCTHD.add(scrollPaneCTHD);
		clickTableHoaDon();

		MyPanel panel_HD_CTHD = new MyPanel();
		panel_HD_CTHD.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanel panel_xemHD = new MyPanel();
		panel_xemHD.setLayout(new BoxLayout(panel_xemHD, BoxLayout.Y_AXIS));
		MyPanel panel_MaHD = new MyPanel();
		panel_xemHD.add(panel_MaHD);
		panel_MaHD.setLayout(new GridLayout(2, 1, 0, 0));
		
		MyPanel panel_3 = new MyPanel();
		panel_MaHD.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		MyLabelSecond lblNewLabel_2 = new MyLabelSecond("Từ ngày");
		panel_3.add(lblNewLabel_2);
		
		ngayBD = new JComboBox();
		panel_3.add(ngayBD);

		thangBD = new JComboBox();
		panel_3.add(thangBD);
		
		namBD = new JComboBox();
		panel_3.add(namBD);
		
		MyPanel panel_2 = new MyPanel();
		panel_MaHD.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		MyLabelSecond lblNewLabel_3 = new MyLabelSecond("Tới ngày");
		panel_2.add(lblNewLabel_3);
		
		ngayKT = new JComboBox();
		panel_2.add(ngayKT);
		
		thangKT = new JComboBox();
		panel_2.add(thangKT);
		
		namKT = new JComboBox();
		panel_2.add(namKT);
		
		for (int i = 1; i <= 31; i++) {
            ngayBD.addItem(i);
            ngayKT.addItem(i);
        }
        
        // Thêm số lựa chọn cho các JComboBox tháng (ví dụ: từ 1 đến 12)
        for (int i = 1; i <= 12; i++) {
            thangBD.addItem(i);
            thangKT.addItem(i);
        }
        
        // Thêm số lựa chọn cho các JComboBox năm (ví dụ: từ 2000 đến 2025)
        for (int i = 2000; i <= 2025; i++) {
            namBD.addItem(i);
            namKT.addItem(i);
        }
		MyPanel panel_NgayTaoHD = new MyPanel();
		panel_xemHD.add(panel_NgayTaoHD);
		
		btnTimKiemHD = new MyButton("Tìm");
		panel_NgayTaoHD.add(btnTimKiemHD);

		panel_HD_CTHD.add(panel_xemHD);

		MyPanel panel_xemCTHD = new MyPanel();
		panel_xemCTHD.setLayout(new BoxLayout(panel_xemCTHD, BoxLayout.Y_AXIS));
		MyLabelSecond lblMaCTHD = new MyLabelSecond("Mã CTHD");
		MyTextField txtMaCTHD = new MyTextField();
		MyPanel panel_MaCTHD = new MyPanel();
		panel_MaCTHD.add(lblMaCTHD);
		panel_MaCTHD.add(txtMaCTHD);
		panel_xemCTHD.add(panel_MaCTHD);
		panel_HD_CTHD.add(panel_xemCTHD);

		panelTabHoaDon.add(panel_HD_CTHD, BorderLayout.EAST);

		panelCard.add(panelTabHoaDon, "HoaDon");
		panel_main.add(panelCard);
		
		
		//================================Menu chế biến=============================================
		MyLabelSecond tabCheBien = new MyLabelSecond("CheBien");
		tabCheBien.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabCheBien);
		
		JPanel panelMenuCheBien = new JPanel();
		panelCard.add(panelMenuCheBien, "CheBien");
		panelMenuCheBien.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBtnCheBien = new JPanel();
		panelMenuCheBien.add(panelBtnCheBien, BorderLayout.EAST);
		panelBtnCheBien.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		txtSoLuongCB = new MyTextField();
		panelBtnCheBien.add(txtSoLuongCB);
		txtSoLuongCB.setColumns(10);
		btnCheBien = new MyButton("Chế biến");
		panelBtnCheBien.add(btnCheBien);
		
		JPanel panelTableCheBien = new JPanel();
		panelMenuCheBien.add(panelTableCheBien, BorderLayout.CENTER);
		panelTableCheBien.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelTableSanPham = new JPanel();
		panelTableCheBien.add(panelTableSanPham);
		panelTableSanPham.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSanPhamCheBien = new JLabel("Sản phẩm");
		panelTableSanPham.add(lblSanPhamCheBien, BorderLayout.NORTH);
		
		JScrollPane scrollPaneSanPham = new JScrollPane();
		panelTableSanPham.add(scrollPaneSanPham, BorderLayout.CENTER);
		
		modelTableSPCheBien = new DefaultTableModel();
		modelTableSPCheBien.addColumn("Mã SP");
		modelTableSPCheBien.addColumn("Tên SP");
		modelTableSPCheBien.addColumn("Đơn giá");
		modelTableSPCheBien.addColumn("Còn lại");
		tableSanPhamCheBien = new JTable(modelTableSPCheBien);
		scrollPaneSanPham.setViewportView(tableSanPhamCheBien);
		clickTableSanPhamCheBien();
		
		JPanel panelCongThucCheBien = new JPanel();
		panelTableCheBien.add(panelCongThucCheBien);
		panelCongThucCheBien.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCTCB = new JLabel("Nguyên liệu");
		panelCongThucCheBien.add(lblCTCB, BorderLayout.NORTH);
		
		JScrollPane scrollPaneNguyenLieu = new JScrollPane();
		panelCongThucCheBien.add(scrollPaneNguyenLieu, BorderLayout.CENTER);
		
		modelTableNguyenLieuCB = new DefaultTableModel();
		modelTableNguyenLieuCB.addColumn("Mã SP");
		modelTableNguyenLieuCB.addColumn("Mã NL");
		modelTableNguyenLieuCB.addColumn("Tên nguyên liệu");
		modelTableNguyenLieuCB.addColumn("Số lượng cần");
		modelTableNguyenLieuCB.addColumn("Số lượng còn lại");
		tableNguyenLieuCheBien = new JTable(modelTableNguyenLieuCB);
		scrollPaneNguyenLieu.setViewportView(tableNguyenLieuCheBien);
		loadDataTableSanPhamCB();
		
		
		//=============================================================================
		
		
		// chuyển tab
		tabBanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "BanHang");
				tabBanHang.setForeground(Color.BLUE);
				tabHoaDon.setForeground(Color.WHITE);
				tabCheBien.setForeground(Color.WHITE);
			}
		});
		tabHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "HoaDon");
				tabBanHang.setForeground(Color.WHITE);
				tabHoaDon.setForeground(Color.BLUE);
				tabCheBien.setForeground(Color.WHITE);
			}
		});
		tabCheBien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "CheBien");
				tabCheBien.setForeground(Color.BLUE);
				tabBanHang.setForeground(Color.WHITE);
				tabHoaDon.setForeground(Color.WHITE);
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
		ArrayList<SanPham> listSP = spBUS.getListSanPham();
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
			return;
		}
		String soLuong = txtSoLuong.getText();
		if (soLuong.isEmpty()) {
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
			vec.add(sp.getId()+"");
			vec.add(sp.getTenSP()+"");
			vec.add(sp.getDonGia()+"");
			vec.add(sp.getSoLuong()+"");
			modelTableSP.addRow(vec);
		}
	}
	private void timTheoKhoangNgay() {
		String ngayBatDau =ngayBD.getSelectedItem() + "";
		String thangBatDau = thangBD.getSelectedItem() + "";
		String namBatDau = namBD.getSelectedItem()+ "";
		String ngayKetThuc = ngayKT.getSelectedItem()+ "";
		String thangKetThuc = thangKT.getSelectedItem()+ "";
		String namKetThuc = namKT.getSelectedItem()+ "";
		ngayBatDau = (ngayBatDau.length() == 1) ? "0" + ngayBatDau : ngayBatDau;
		thangBatDau = (thangBatDau.length() == 1) ? "0" + thangBatDau : thangBatDau;
		ngayKetThuc = (ngayKetThuc.length() == 1) ? "0" + ngayKetThuc : ngayKetThuc;
		thangKetThuc = (thangKetThuc.length() == 1) ? "0" + thangKetThuc : thangKetThuc;
		String ngayBatDauString = ngayBatDau + "/" + thangBatDau + "/" + namBatDau;
		String ngayKetThucString = ngayKetThuc + "/" + thangKetThuc + "/" + namKetThuc;
		ArrayList<HoaDon> dshd = hdBUS.getListHoaDonTheoNgay(ngayBatDauString, ngayKetThucString);
		addDataToTableHoaDon(dshd);
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
			vec.add(ct.getSoLuongDung()+"");
			vec.add(nl.getsoLuongNL()+"");
			modelTableNguyenLieuCB.addRow(vec);
		}
	}
	
	private void loadDataTableSanPhamCB() {
		ArrayList<SanPham> listSP = spBUS.getListSanPham();
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
		if((txtSoLuongCB.getText())==null) return;
		int soLuong = Integer.parseInt(txtSoLuongCB.getText()+"");
		if(soLuong==0) return;
		
		
		
		
		for (int row = 0; row < modelTableNguyenLieuCB.getRowCount(); row++) {
            int soLuong0 = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 3)+"");
            int soLuongCan = soLuong0*soLuong;
            int soLuongConLai = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 4)+"");
            if(soLuongCan>soLuongConLai) {
            	return;
            }

        }
		boolean rs = true;
		int maSP = -1;
		for (int row = 0; row < modelTableNguyenLieuCB.getRowCount(); row++) {
			int soLuong0 = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 3)+"");
            int soLuongCan = soLuong0*soLuong;
            int idNL = Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 1)+"");
            rs = chebienBUS.giamSoLuongNLkhiCheBien(idNL, soLuongCan);
            maSP=Integer.parseInt(modelTableNguyenLieuCB.getValueAt(row, 0)+"");
        }
		if(rs==true) {
			spBUS.tangSoLuongSP(maSP, soLuong);
		}
		
		
	}

}
