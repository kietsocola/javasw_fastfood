package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.ChiTietPhieuNhapBUS;
import BUS.NguyenLieuBUS;
import BUS.NhaCungCap_BUS;
import BUS.PhieuNhapBUS;
import Custom.MyButton;
import Custom.MyColor;
import Custom.MyLabelSecond;
import Custom.MyPanel;
import Custom.MyPanelSecond;
import Custom.MyTable;
import Custom.MyTextField;
import DTO.ChiTietPhieuNhap;
import DTO.NguyenLieu;
import DTO.NhaCungCap;
import DTO.PhieuNhap;

public class NhapHangGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelTableNL, modelTableXN, modelTablePN, modelTableCTPN;
	private MyTextField txtMaNL, txtMaNL2, txtTenNL, txtSoLuongNL, txtDonGiaNL, txtTongTien,
			txtMaPN, txtSL, txtDG, txtMaNCC, txtMaNV, txtThanhTien;
	private MyTable tableNL, tableXN, tablePN, tableCTPN;
	private JTextField txtTimTheoTen;
	private JComboBox<String> cmbNCC;
	private MyButton btnXoa, btnXuatPN, btnTimKiem;
	private NguyenLieuBUS nlBUS = new NguyenLieuBUS();
	private NhaCungCap_BUS nccBUS = new NhaCungCap_BUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private PhieuNhapBUS pnBUS = new PhieuNhapBUS();
	private MyButton btnChonNhap;
	private MyButton btnTimKiemHD;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// NhapHangGUI frame = new NhapHangGUI();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private MyButton btnLamMoi;

	/**
	 * Create the frame.
	 */
	public NhapHangGUI() {
		addControlsNhapHang();
		eventsNhapHang();
	}

	public void addControlsNhapHang() {
		this.setLayout(new BorderLayout());
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);

		// contentPane.add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));
		CardLayout cardLayout = new CardLayout();

		JPanel panelCard = new JPanel(cardLayout);
		MyPanel panel_tab = new MyPanel();
		panel_main.add(panel_tab, BorderLayout.NORTH);
		panel_tab.setLayout(new BoxLayout(panel_tab, BoxLayout.X_AXIS));

		JLabel lblNewLabel_4 = new JLabel("       ");
		panel_tab.add(lblNewLabel_4);

		MyLabelSecond tabNhapHang = new MyLabelSecond("Nhập Hàng");

		tabNhapHang.setText("  Nhập hàng");
		tabNhapHang.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabNhapHang);

		MyLabelSecond tabPhieuNhap = new MyLabelSecond("Phiếu Nhập");

		tabPhieuNhap.setMaximumSize(new Dimension(100, 60));
		tabPhieuNhap.setText("  Phiếu nhập");
		tabPhieuNhap.setPreferredSize(new Dimension(200, 30));
		panel_tab.add(tabPhieuNhap);

		// panel chứa table và chi tiết
		MyPanelSecond paneltabNhapHang = new MyPanelSecond();
		paneltabNhapHang.setLayout(new BorderLayout(0, 0));
		panelCard.add(paneltabNhapHang, "NhapHang");

		MyPanel panel_table = new MyPanel();
		paneltabNhapHang.add(panel_table, BorderLayout.CENTER);
		panel_table.setLayout(new GridLayout(2, 1, 0, 0));
		panel_table.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		// panel chứa table
		MyPanel panel_containtableNL = new MyPanel();
		panel_containtableNL.setLayout(new BorderLayout());
		panel_table.add(panel_containtableNL);
		MyPanelSecond panel_tableNL = new MyPanelSecond();
		panel_tableNL.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_containtableNL.add(panel_tableNL, BorderLayout.CENTER);
		MyPanel pnSpace = new MyPanel();
		pnSpace.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_containtableNL.add(pnSpace, BorderLayout.SOUTH);
		panel_tableNL.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblDSNL = new MyLabelSecond("Danh sách nguyên liệu");
		lblDSNL.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tableNL.add(lblDSNL, BorderLayout.NORTH);

		Color primaryColor = new Color(Integer.parseInt("39", 16), Integer.parseInt("3c", 16),
				Integer.parseInt("49", 16));
		// table sản phẩm
		modelTableNL = new DefaultTableModel();
		modelTableNL.addColumn("Mã nguyên liệu");
		modelTableNL.addColumn("Tên nguyên liệu");
		modelTableNL.addColumn("Tồn kho");
		// modelTableNL.addColumn("Số lượng");
		tableNL = new MyTable(modelTableNL);
		JScrollPane scrollPaneNL = new JScrollPane(tableNL);
		panel_tableNL.add(scrollPaneNL);
		scrollPaneNL.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		addDataToTblNL();
		clickTableNL();
		// Tạo table cho phần chờ xác nhận
		MyPanelSecond panel_tableXN = new MyPanelSecond();
		panel_tableXN.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_table.add(panel_tableXN);
		panel_tableXN.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblHangCho = new MyLabelSecond("Hàng chờ nhập");
		lblHangCho.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tableXN.add(lblHangCho, BorderLayout.NORTH);
		modelTableXN = new DefaultTableModel();
		modelTableXN.addColumn("Mã nguyên liệu");
		modelTableXN.addColumn("Tên nguyên liệu");
		modelTableXN.addColumn("Số Lượng");
		modelTableXN.addColumn("Đơn giá");
		modelTableXN.addColumn("Thành tiền");
		// phần chi tiết sẽ hiển thị đơn giá, thành tiền và các thông tin chi tiết đã
		// chọn
		tableXN = new MyTable(modelTableXN);
		JScrollPane scrollPaneXN = new JScrollPane(tableXN);
		scrollPaneXN.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		panel_tableXN.add(scrollPaneXN);

		// panel chi tiết
		MyPanel panel_ContainDetailNL = new MyPanel();
		panel_ContainDetailNL.setLayout(new BorderLayout());
		MyPanelSecond panel_DetailNL = new MyPanelSecond();
		panel_ContainDetailNL.add(panel_DetailNL, BorderLayout.CENTER);
		paneltabNhapHang.add(panel_ContainDetailNL, BorderLayout.EAST);
		panel_DetailNL.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		panel_DetailNL.setLayout(new BorderLayout());
		MyPanel pnSpace1 = new MyPanel();
		panel_ContainDetailNL.add(pnSpace1, BorderLayout.EAST);
		MyPanel pnSpace2 = new MyPanel();
		panel_ContainDetailNL.add(pnSpace2, BorderLayout.SOUTH);

		MyPanelSecond panel_TimNL = new MyPanelSecond();
		panel_DetailNL.add(panel_TimNL, BorderLayout.NORTH);
		panel_TimNL.setLayout(new BoxLayout(panel_TimNL, BoxLayout.Y_AXIS));

		MyPanelSecond panel_1 = new MyPanelSecond();
		panel_TimNL.add(panel_1);

		JPanel panel_TimTheoTen = new JPanel();
		// panel_TimTheoTen.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_TimNL.add(panel_TimTheoTen);
		panel_TimTheoTen.setLayout(new BorderLayout(0, 0));

		txtTimTheoTen = new JTextField();
		txtTimTheoTen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimTheoTen.getText().equals("Nhập tên nguyên liệu")) {
					txtTimTheoTen.setText("");

				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimTheoTen.getText().equals("")) {
					txtTimTheoTen.setText("Nhập tên nguyên liệu");
					txtTimTheoTen.setForeground(new Color(192, 192, 192));

				}
			}
		});
		txtTimTheoTen.setText("Nhập tên nguyên liệu");
		panel_TimTheoTen.add(txtTimTheoTen, BorderLayout.CENTER);
		txtTimTheoTen.setColumns(10);

		btnTimKiem = new MyButton("Tìm kiếm");

		ImageIcon iconTimkiem = new ImageIcon("images/loupe.png");
		Image img0 = iconTimkiem.getImage();
		Image newImg0 = img0.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconTimkiem.setImage(newImg0);

		panel_TimTheoTen.add(btnTimKiem, BorderLayout.EAST);

		MyPanelSecond pnInput = new MyPanelSecond();
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		panel_DetailNL.add(pnInput, BorderLayout.CENTER);
		// MyPanel panel = new MyPanel();
		// pnInput.add(panel);
		// panel.setLayout(new BorderLayout(0, 0));

		// Phần chi tiết của xác nhận
		MyLabelSecond lblChiTiet = new MyLabelSecond("Thông tin nguyên liệu");
		lblChiTiet.setMaximumSize(new Dimension(150, 40));
		lblChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTiet.setText("Thông tin nguyên liệu");
		pnInput.add(lblChiTiet);
		MyPanelSecond panel_MaNL = new MyPanelSecond();
		panel_MaNL.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_MaNL);
		panel_MaNL.setLayout(new BoxLayout(panel_MaNL, BoxLayout.X_AXIS));

		MyLabelSecond lblMaNL = new MyLabelSecond("Mã nguyên liệu: ");
		panel_MaNL.add(lblMaNL);

		txtMaNL = new MyTextField();
		txtMaNL.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaNL.setEnabled(false);
		txtMaNL.setDisabledTextColor(new Color(0, 0, 0));
		panel_MaNL.add(txtMaNL);
		txtMaNL.setColumns(10);

		MyPanelSecond panel_TenNL = new MyPanelSecond();
		panel_TenNL.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_TenNL);
		panel_TenNL.setLayout(new BoxLayout(panel_TenNL, BoxLayout.X_AXIS));

		MyLabelSecond lblTenNL = new MyLabelSecond("Tên nguyên liệu: ");
		panel_TenNL.add(lblTenNL);

		txtTenNL = new MyTextField();
		txtTenNL.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenNL.setEnabled(false);
		txtTenNL.setDisabledTextColor(new Color(0, 0, 0));
		panel_TenNL.add(txtTenNL);
		txtTenNL.setColumns(10);

		MyPanelSecond panel_SoLuong = new MyPanelSecond();
		panel_SoLuong.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_SoLuong);
		panel_SoLuong.setLayout(new BoxLayout(panel_SoLuong, BoxLayout.X_AXIS));

		MyLabelSecond lblSoLuong = new MyLabelSecond("Số lượng nhập: ");
		panel_SoLuong.add(lblSoLuong);

		txtSoLuongNL = new MyTextField();
		txtSoLuongNL.setHorizontalAlignment(SwingConstants.CENTER);
		panel_SoLuong.add(txtSoLuongNL);
		txtSoLuongNL.setColumns(10);

		MyPanelSecond panel_DonGiaNL = new MyPanelSecond();
		panel_DonGiaNL.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_DonGiaNL);
		panel_DonGiaNL.setLayout(new BoxLayout(panel_DonGiaNL, BoxLayout.X_AXIS));

		MyLabelSecond lblDonGiaNL = new MyLabelSecond("Đơn giá: ");
		panel_DonGiaNL.add(lblDonGiaNL);

		txtDonGiaNL = new MyTextField();
		txtDonGiaNL.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DonGiaNL.add(txtDonGiaNL);
		txtDonGiaNL.setColumns(10);

		MyLabelSecond lblTTPN = new MyLabelSecond("Thông tin phiếu nhập");
		lblTTPN.setMaximumSize(new Dimension(150, 40));
		lblTTPN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTPN.setText("Thông tin phiếu nhập");
		pnInput.add(lblTTPN);

		MyPanelSecond panel_NCC = new MyPanelSecond();
		panel_NCC.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnInput.add(panel_NCC);
		panel_NCC.setLayout(new BoxLayout(panel_NCC, BoxLayout.X_AXIS));

		MyLabelSecond lblNCC = new MyLabelSecond("Nhà cung cấp: ");
		panel_NCC.add(lblNCC);

		cmbNCC = new JComboBox<String>();
		cmbNCC.setMaximumSize(new Dimension(300, 30));
		cmbNCC.setPreferredSize(new Dimension(200, 30));
		panel_NCC.add(cmbNCC);
		loadDataCmbNCC();
		MyPanelSecond pnBTN = new MyPanelSecond();
		pnInput.add(pnBTN);
		btnChonNhap = new MyButton("Chọn nhập");
		btnChonNhap.setMaximumSize(new Dimension(80, 40));
		btnChonNhap.setPreferredSize(new Dimension(80, 40));
		// ImageIcon icon = new ImageIcon("images/cart.png");
		// Image img = icon.getImage();
		// Image newImg = img.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		// icon.setImage(newImg);
		pnBTN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// btnChonNhap.setIcon(icon);
		pnBTN.add(btnChonNhap);

		btnXoa = new MyButton("Xóa");

		btnXoa.setMaximumSize(new Dimension(80, 40));
		btnXoa.setPreferredSize(new Dimension(80, 40));
		ImageIcon iconXoa = new ImageIcon("images/remove.png");
		Image img2 = iconXoa.getImage();
		Image newImg2 = img2.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconXoa.setImage(newImg2);
		btnXoa.setIcon(iconXoa);
		clickTableXN();
		pnBTN.add(btnXoa);

		btnXuatPN = new MyButton("Xuất phiếu nhập");

		btnXuatPN.setMaximumSize(new Dimension(80, 40));
		btnXuatPN.setPreferredSize(new Dimension(120, 40));
		// ImageIcon iconXuatPN = new ImageIcon("images/.png");
		// Image img3 = iconXuatPN.getImage();
		// Image newImg3 = img3.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		// iconXuatPN.setImage(newImg3);
		// btnXuatPN.setIcon(icon);
		pnBTN.add(btnXuatPN);
		/*
		 * ==========================TAB PHIẾU
		 * NHẬP=======================================
		 */
		MyPanelSecond panelTabPhieuNhap = new MyPanelSecond();
		panelTabPhieuNhap.setLayout(new BorderLayout(0, 0));
		panelCard.add(panelTabPhieuNhap, "PhieuNhap");

		MyPanel panel_tablePhieuNhap = new MyPanel();
		panel_tablePhieuNhap.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		panelTabPhieuNhap.add(panel_tablePhieuNhap, BorderLayout.CENTER);
		panel_tablePhieuNhap.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanelSecond panel_containTablePN = new MyPanelSecond();
		panel_containTablePN.setLayout(new BorderLayout());
		MyPanelSecond panel_tablePN = new MyPanelSecond();
		panel_containTablePN.add(panel_tablePN, BorderLayout.CENTER);
		MyPanel pnSpace3 = new MyPanel();
		pnSpace3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_containTablePN.add(pnSpace3, BorderLayout.SOUTH);
		panel_tablePhieuNhap.add(panel_containTablePN);
		panel_tablePN.setLayout(new BorderLayout(0, 0));
		panel_tablePN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblDSPN = new MyLabelSecond("Danh sách phiếu nhập");
		lblDSPN.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tablePN.add(lblDSPN, BorderLayout.NORTH);
		// ======================PHẦN PHIẾU NHẬP
		// ===========================================
		modelTablePN = new DefaultTableModel();
		modelTablePN.addColumn("Mã PN");
		modelTablePN.addColumn("Mã NCC");
		modelTablePN.addColumn("Mã NV");
		modelTablePN.addColumn("Ngày lập");
		modelTablePN.addColumn("Tổng tiền");

		tablePN = new MyTable(modelTablePN);
		loadDataTablePhieuNhap();
		JScrollPane scrollPanePN = new JScrollPane(tablePN);
		panel_tablePN.add(scrollPanePN);
		scrollPanePN.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);

		clickTablePhieuNhap();
		// ======================PHẦN CHI TIẾT PHIẾU NHẬP
		// ==================================
		MyPanelSecond panel_tableCTPN = new MyPanelSecond();
		panel_tablePhieuNhap.add(panel_tableCTPN);
		panel_tableCTPN.setLayout(new BorderLayout(0, 0));
		panel_tableCTPN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblCTPhieuNhap = new MyLabelSecond("Chi tiết phiếu nhập");
		lblCTPhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tableCTPN.add(lblCTPhieuNhap, BorderLayout.NORTH);
		modelTableCTPN = new DefaultTableModel();
		modelTableCTPN.addColumn("Mã NL");
		modelTableCTPN.addColumn("Mã PN");

		modelTableCTPN.addColumn("Số lượng");
		modelTableCTPN.addColumn("Đơn giá");
		modelTableCTPN.addColumn("Thành tiền");
		tableCTPN = new MyTable(modelTableCTPN);
		JScrollPane scrollPaneCTPN = new JScrollPane(tableCTPN);
		scrollPaneCTPN.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		panel_tableCTPN.add(scrollPaneCTPN);

		MyPanelSecond panel_Detail = new MyPanelSecond();
		panelTabPhieuNhap.add(panel_Detail, BorderLayout.EAST);
		panel_Detail.setLayout(new BoxLayout(panel_Detail, BoxLayout.Y_AXIS));
		// phần hiển thị của phiếu nhập
		MyPanelSecond panel_DetailPN = new MyPanelSecond();
		panel_DetailPN.setLayout(new BoxLayout(panel_DetailPN, BoxLayout.Y_AXIS));
		panel_Detail.add(panel_DetailPN);

		MyLabelSecond lblThongTinPN = new MyLabelSecond("Thông tin phiếu nhập");
		lblThongTinPN.setMaximumSize(new Dimension(400, 40));
		lblThongTinPN.setHorizontalTextPosition(SwingConstants.LEFT);
		lblThongTinPN.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DetailPN.add(lblThongTinPN);

		MyPanelSecond pnMaPN = new MyPanelSecond();
		MyLabelSecond lblMaPN = new MyLabelSecond("Mã PN: ");
		lblMaPN.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DetailPN.add(pnMaPN);
		pnMaPN.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnMaPN.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pnMaPN.add(lblMaPN);
		txtMaPN = new MyTextField();
		txtMaPN.setMaximumSize(new Dimension(180, 30));
		pnMaPN.add(txtMaPN);

		MyPanelSecond pnMaNCC = new MyPanelSecond();
		MyLabelSecond lblMaNCC = new MyLabelSecond("Mã NCC: ");
		lblMaNCC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DetailPN.add(pnMaNCC);
		pnMaNCC.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnMaNCC.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pnMaNCC.add(lblMaNCC);
		txtMaNCC = new MyTextField();
		txtMaNCC.setMaximumSize(new Dimension(180, 30));
		pnMaNCC.add(txtMaNCC);

		MyPanelSecond pnTongTien = new MyPanelSecond();
		MyLabelSecond lblTongTien = new MyLabelSecond("Tổng tiền: ");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DetailPN.add(pnTongTien);
		pnTongTien.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		pnTongTien.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pnTongTien.add(lblTongTien);
		txtTongTien = new MyTextField();
		txtTongTien.setMaximumSize(new Dimension(180, 30));
		pnTongTien.add(txtTongTien);
		// Phần hiển thị chi tiết phiếu
		MyPanelSecond panel_DetailCTPN = new MyPanelSecond();
		panel_DetailCTPN.setLayout(new BoxLayout(panel_DetailCTPN, BoxLayout.Y_AXIS));
		panel_Detail.add(panel_DetailCTPN);

		MyLabelSecond lblThongTinCTPN = new MyLabelSecond("Chi tiết phiếu nhập");
		lblThongTinCTPN.setMaximumSize(new Dimension(300, 40));
		lblThongTinCTPN.setHorizontalTextPosition(SwingConstants.LEFT);
		lblThongTinCTPN.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DetailCTPN.add(lblThongTinCTPN);

		MyPanelSecond pnMaNL2 = new MyPanelSecond();
		MyLabelSecond lblMaNL2 = new MyLabelSecond("Mã NL: ");
		lblMaNL2.setHorizontalAlignment(SwingConstants.CENTER);
		pnMaNL2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_DetailCTPN.add(pnMaNL2);
		pnMaNL2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pnMaNL2.add(lblMaNL2);
		txtMaNL2 = new MyTextField();
		txtMaNL2.setMaximumSize(new Dimension(180, 30));
		pnMaNL2.add(txtMaNL2);

		MyPanelSecond pnSL = new MyPanelSecond();
		pnSL.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		MyLabelSecond lblSL = new MyLabelSecond("Số lượng: ");
		lblSL.setPreferredSize(new Dimension(100, 30));
		lblSL.setHorizontalAlignment(SwingConstants.CENTER);
		pnSL.add(lblSL);
		txtSL = new MyTextField();
		txtSL.setMaximumSize(new Dimension(180, 30));
		pnSL.add(txtSL);
		pnSL.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_DetailCTPN.add(pnSL);

		MyPanelSecond pnDG = new MyPanelSecond();
		pnDG.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		MyLabelSecond lblDG = new MyLabelSecond("Đơn giá: ");
		lblDG.setPreferredSize(new Dimension(100, 30));
		lblDG.setHorizontalAlignment(SwingConstants.CENTER);
		pnDG.add(lblDG);
		txtDG = new MyTextField();
		txtDG.setMaximumSize(new Dimension(180, 30));
		pnDG.add(txtDG);
		panel_DetailCTPN.add(pnDG);

		MyPanelSecond pnTT = new MyPanelSecond();
		pnTT.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		MyLabelSecond lblTT = new MyLabelSecond("Thành tiền: ");
		lblTT.setPreferredSize(new Dimension(100, 30));
		lblTT.setHorizontalAlignment(SwingConstants.CENTER);
		pnTT.add(lblTT);
		txtThanhTien = new MyTextField();
		txtThanhTien.setMaximumSize(new Dimension(180, 30));
		pnTT.add(txtThanhTien);
		pnTT.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_DetailCTPN.add(pnTT);

		// tìm theo ngày của Kiệt add dô
		MyPanelSecond panel_FindHD = new MyPanelSecond();
		panel_Detail.add(panel_FindHD, BorderLayout.NORTH);
		panel_FindHD.setLayout(new BoxLayout(panel_FindHD, BoxLayout.Y_AXIS));

		MyLabelSecond lblTimKiem = new MyLabelSecond("Tìm kiếm phiếu nhập");
		lblTimKiem.setMaximumSize(new Dimension(150, 40));
		panel_FindHD.add(lblTimKiem);

		MyPanelSecond panel_3 = new MyPanelSecond();
		panel_3.setMinimumSize(new Dimension(300, 10));
		panel_3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		panel_FindHD.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		MyLabelSecond lblNewLabel_2 = new MyLabelSecond("Từ ngày");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		startDateChooser = new JDateChooser();
		startDateChooser.setMaximumSize(new Dimension(120, 30));
		startDateChooser.setBackground(new Color(0, 0, 0));
		startDateChooser.setPreferredSize(new Dimension(120, 30));
		startDateChooser.setForeground(Color.BLUE); // Thiết lập màu chữ
		startDateChooser.setFont(new Font("Arial", Font.BOLD, 14)); // Thiết lập font chữ
		panel_3.add(startDateChooser);
		//
		MyPanelSecond panel_2 = new MyPanelSecond();
		panel_FindHD.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		//
		MyLabelSecond lblNewLabel_3 = new MyLabelSecond("Tới ngày");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_3);
		endDateChooser = new JDateChooser();
		endDateChooser.setMaximumSize(new Dimension(120, 30));
		endDateChooser.setBackground(new Color(0, 0, 0));
		endDateChooser.setPreferredSize(new Dimension(120, 30));
		panel_2.add(endDateChooser);

		MyPanelSecond panel_btnTimkiem = new MyPanelSecond();
		FlowLayout flowLayout = (FlowLayout) panel_btnTimkiem.getLayout();
		panel_FindHD.add(panel_btnTimkiem);

		btnTimKiemHD = new MyButton("Tìm kiếm");
		btnTimKiemHD.setIcon(iconTimkiem);
		btnTimKiem.setIcon(iconTimkiem);
		btnLamMoi = new MyButton("Làm mới");
		ImageIcon icon0 = new ImageIcon("images/LamMoi.png");
		Image img01 = icon0.getImage();
		Image newImg01 = img01.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		icon0.setImage(newImg01);
		btnLamMoi.setIcon(icon0);

		panel_btnTimkiem.add(btnTimKiemHD);
		panel_btnTimkiem.add(btnLamMoi);

		// --------- phần thêm ---------
		panel_main.add(panelCard);
		// Chuyển tab
		tabNhapHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// Kiểm tra nếu tab hiện đang không được chọn
				if (!tabNhapHang.isOpaque()) {
					// Đặt màu nền về mặc định
					tabNhapHang.setBackground(null);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "NhapHang");
				tabNhapHang.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
				tabNhapHang.setOpaque(true);

				// Đặt màu cho tab Phiếu nhập về mặc định
				tabPhieuNhap.setBackground(null);
				tabPhieuNhap.setOpaque(false);
			}

		});
		tabPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// Kiểm tra nếu tab hiện đang không được chọn
				if (!tabPhieuNhap.isOpaque()) {
					// Đặt màu nền về mặc định
					tabPhieuNhap.setBackground(null);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panelCard, "PhieuNhap");
				tabPhieuNhap.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
				tabPhieuNhap.setOpaque(true);

				// Đặt màu cho tab Nhập hàng về mặc định
				tabNhapHang.setBackground(null);
				tabNhapHang.setOpaque(false);
			}

		});
	}

	// Xử lý load dữ liệu
	private void addDataToTblNL() {
		nlBUS.getDSachNguyenLieu();
		modelTableNL.setRowCount(0);
		ArrayList<NguyenLieu> dsnl = nlBUS.getDSachNguyenLieu();
		for (NguyenLieu nl : dsnl) {
			Vector<String> vec = new Vector<>();
			vec.add(nl.getMaNguyenLieu() + "");
			vec.add(nl.getTenNL() + "");
			vec.add(nl.getsoLuongNL() + "");
			modelTableNL.addRow(vec);
		}
	}

	private void clickTableNL() {
		ListSelectionModel selectionModel = tableNL.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tableNL.getSelectedRow();
				if (selectedRow != -1) {
					String manl = tableNL.getValueAt(selectedRow, 0) + "";
					String tennl = tableNL.getValueAt(selectedRow, 1) + "";

					txtMaNL.setText(manl);
					txtTenNL.setText(tennl);

				}
			}
		});
	}

	private void clickTableXN() {
		btnXoa.setEnabled(false);
		ListSelectionModel selectionModel = tableXN.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableXN.getSelectedRow();
				if (selectedRow != -1) {
					btnXoa.setEnabled(true);
				}
			}
		});
	}

	// xử lý load cmbncc
	private void loadDataCmbNCC() {
		cmbNCC.removeAllItems();

		ArrayList<NhaCungCap> dsncc = nccBUS.getListNhaCungCap();
		cmbNCC.addItem("0 - Chọn NCC");
		for (NhaCungCap ncc : dsncc) {
			cmbNCC.addItem(ncc.getMaNCC() + " - " + ncc.getTenNCC());
		}
	}

	// Xử lý btn chọn nhập\
	private void ChonNhap() {
		int row = tableNL.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nguyên liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			;
			return;
		}
		String soLuong = txtSoLuongNL.getText();
		if (soLuong.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			;
			return;
		}
		String dongia = txtDonGiaNL.getText();
		if (dongia.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn giá cho nguyên liệu", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			;
			return;
		}
		if (cmbNCC.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// Lấy thông tin nguyên liệu
		String maNL = txtMaNL.getText();
		String tenNL = txtTenNL.getText();
		String maNCC = cmbNCC.getSelectedItem().toString().split(" - ")[0];
		// Thêm dữ liệu vào bảng chờ xác nhận
		Vector<String> rowData = new Vector<>();
		rowData.add(maNL);
		rowData.add(tenNL);
		rowData.add(soLuong);
		rowData.add(dongia);
		int thanhTien = Integer.parseInt(soLuong) * Integer.parseInt(dongia);
		rowData.add(String.valueOf(thanhTien));
		modelTableXN.addRow(rowData);
	}

	private void xoaNLformXacNhan() {
		int selectedRow = tableXN.getSelectedRow();
		if (selectedRow != -1) {
			DefaultTableModel model = (DefaultTableModel) tableXN.getModel();
			model.removeRow(selectedRow);
		}
	}
	// Phần xử lý xuất phiếu nhập và thêm các dữ kiện vào Tab phiếu nhập

	private void xuatPN() {
		if (modelTableXN.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Không có nguyên liệu nào trong hàng chờ", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int total = 0;
		for (int i = 0; i < modelTableXN.getRowCount(); i++) {
			total += Integer.parseInt(modelTableXN.getValueAt(i, 4) + "");
			String MaNL = modelTableXN.getValueAt(i, 0) + "";
			String TenNL = modelTableXN.getValueAt(i, 1) + "";
			String SL = modelTableXN.getValueAt(i, 2) + "";
			String DG = modelTableXN.getValueAt(i, 3) + "";
			String thanhTien = modelTableXN.getValueAt(i, 4) + "";

			ctpnBUS.addChiTietPhieuNhap(MaNL, SL, DG, thanhTien);
		}
		pnBUS.luuPhieuNhap(1, Integer.parseInt(cmbNCC.getSelectedItem().toString().split(" - ")[0]), total);

		modelTableXN.setRowCount(0);

	}

	private void loadDataTablePhieuNhap() {
		ArrayList<PhieuNhap> listPN = pnBUS.getListPhieuNhap();
		addDataToTablePN(listPN);
	}

	private void addDataToTablePN(ArrayList<PhieuNhap> listPN) {
		modelTablePN.setRowCount(0);
		for (PhieuNhap pn : listPN) {
			Vector<String> vec = new Vector<>();
			vec.add(pn.getMaPN() + "");
			vec.add(pn.getMaNCC() + "");
			vec.add(pn.getMaNV() + "");
			vec.add(pn.getNgayLap() + "");
			vec.add(pn.getTongTien() + "");

			modelTablePN.addRow(vec);
		}
	}

	private void addDataToTableCTPN(ArrayList<ChiTietPhieuNhap> listCTPN) {
		modelTableCTPN.setRowCount(0);
		for (ChiTietPhieuNhap ctpn : listCTPN) {
			Vector<String> vec = new Vector<>();
			vec.add(ctpn.getMaPN() + "");
			vec.add(ctpn.getMaNL() + "");
			vec.add(ctpn.getSoLuong() + "");
			vec.add(ctpn.getDonGia() + "");
			vec.add(ctpn.getThanhTien() + "");

			modelTableCTPN.addRow(vec);
		}
	}

	private void clickTablePhieuNhap() {
		ListSelectionModel selectionModel = tablePN.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tablePN.getSelectedRow();
				if (selectedRow != -1) {
					int maPN = Integer.parseInt(tablePN.getValueAt(selectedRow, 0) + "");
					ArrayList<ChiTietPhieuNhap> listCTPN = ctpnBUS.getListCTPNtheoIdPhieuNhap(maPN);
					addDataToTableCTPN(listCTPN);
				}
			}
		});
	}

	private void timNguyenLieuTheoTen() {
		modelTableNL.setRowCount(0);
		String ten = txtTimTheoTen.getText();
		ArrayList<NguyenLieu> dsnl = nlBUS.getNguyenLieuTheoTen(ten);
		for (NguyenLieu nl : dsnl) {
			Vector<String> vec = new Vector<>();
			vec.add(nl.getMaNguyenLieu() + "");
			vec.add(nl.getTenNL() + "");
			vec.add(nl.getsoLuongNL() + "");
			modelTableNL.addRow(vec);
		}
	}

	private void timTheoKhoangNgay() {
		java.util.Date utilStartDate = startDateChooser.getDate();
		java.util.Date utilEndDate = endDateChooser.getDate();
		ArrayList<PhieuNhap> dspn = pnBUS.getListPhieuNhapTheoNgay(utilStartDate, utilEndDate);
		addDataToTablePN(dspn);
	}

	private void eventsNhapHang() {
		btnChonNhap.addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub
				ChonNhap();
			}
		});
		btnXuatPN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuatPN();
				loadDataTablePhieuNhap();
				addDataToTblNL();
			}
		});
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xoaNLformXacNhan();
				btnXoa.setEnabled(false);
			}
		});
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timNguyenLieuTheoTen();

			}
		});
		btnTimKiemHD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timTheoKhoangNgay();
			}
		});
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadDataTablePhieuNhap();
				startDateChooser.setDate(null);
				endDateChooser.setDate(null);
			}
		});
		tablePN.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tablePN.getSelectedRow();
					if (selectedRow != -1) {
						String maPN = tablePN.getValueAt(selectedRow, 0).toString();
						String maNCC = tablePN.getValueAt(selectedRow, 1).toString();
						String tongTien = tablePN.getValueAt(selectedRow, 4).toString();

						txtMaPN.setText(maPN);
						txtMaNCC.setText(maNCC);
						txtTongTien.setText(tongTien);
					}
				}
			}
		});

		// Đăng ký sự kiện cho bảng tableCTPN
		tableCTPN.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableCTPN.getSelectedRow();
					if (selectedRow != -1) {
						String maNL = tableCTPN.getValueAt(selectedRow, 1).toString();
						String soLuong = tableCTPN.getValueAt(selectedRow, 2).toString();
						String donGia = tableCTPN.getValueAt(selectedRow, 3).toString();
						String thanhTien = tableCTPN.getValueAt(selectedRow, 4).toString();

						txtMaNL2.setText(maNL);
						txtSL.setText(soLuong);
						txtDG.setText(donGia);
						txtThanhTien.setText(thanhTien);
					}
				}
			}
		});
	}

}
