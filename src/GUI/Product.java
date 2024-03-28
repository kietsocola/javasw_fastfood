package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import Custom.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
public class Product extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Display;
	private JTextField txtQunLSn;
	private JTextField txtMaSP;
	private JTextField txtTenSp;
	private JTextField txtSoLuong;
	private JTextField txtDonVi;
	private JTextField txtDonGia;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
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
	public Product() {
		setTitle("Phần mềm quản lý bán thức ăn nhanh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 880); // contentpane co ti le la 1194x834 chua tinh thanh tren cung
		Display = new JPanel();
		Display.setForeground(new Color(37, 40, 54));
		Display.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Display);
		Display.setLayout(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 1194, 834);
		MainPanel.setBackground(new Color(37, 40, 54));
		Display.add(MainPanel);
		MainPanel.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBounds(0, 0, 104, 834);
		MenuPanel.setForeground(new Color(255, 255, 255));
		MenuPanel.setBackground(new Color(31, 29, 43));
		MainPanel.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel lblLoGo = new JLabel("");
		lblLoGo.setBackground(new Color(253, 150, 106));
		lblLoGo.setForeground(new Color(253, 150, 106));
		lblLoGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoGo.setBounds(25, 10, 56, 56);
		MenuPanel.add(lblLoGo);
		Image bx_bxs_store = new ImageIcon(this.getClass().getResource("/bx_bxs-store-alt.png")).getImage()	;
		lblLoGo.setIcon(new ImageIcon(bx_bxs_store));
		
		JLabel lblBanHang = new JLabel("Bán Hàng");
		
		lblBanHang.setForeground(new Color(255, 255, 255));
		lblBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblBanHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBanHang.setBounds(0, 76, 104, 56);
		MenuPanel.add(lblBanHang);
		Image icBanHang = new ImageIcon(this.getClass().getResource("/Home.png")).getImage()	;
		lblBanHang.setIcon(new ImageIcon(icBanHang));
		
		JLabel lblKhuyenMai = new JLabel("Khuyến Mãi");
		lblKhuyenMai.setForeground(new Color(255, 255, 255));
		lblKhuyenMai.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKhuyenMai.setBounds(0, 142, 104, 56);
		MenuPanel.add(lblKhuyenMai);
		Image icKhuyenMai = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblKhuyenMai.setIcon(new ImageIcon(icKhuyenMai));
		
		JLabel lblSanPham = new JLabel("Sản Phẩm");
		lblSanPham.setForeground(new Color(255, 255, 255));
		lblSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSanPham.setBounds(0, 208, 104, 56);
		MenuPanel.add(lblSanPham);
		Image icSanPham = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblSanPham.setIcon(new ImageIcon(icSanPham));
		
		JLabel lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhanVien.setBounds(0, 274, 104, 56);
		MenuPanel.add(lblNhanVien);
		Image icNhanVien = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblNhanVien.setIcon(new ImageIcon(icNhanVien));
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setForeground(new Color(255, 255, 255));
		lblKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKhachHang.setBounds(0, 340, 104, 56);
		MenuPanel.add(lblKhachHang);
		Image icKhachHang = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblKhachHang.setIcon(new ImageIcon(icKhachHang));
		
		JLabel lblNhapHang = new JLabel("Nhập Hàng");
		lblNhapHang.setForeground(new Color(255, 255, 255));
		lblNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhapHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhapHang.setBounds(0, 406, 104, 56);
		MenuPanel.add(lblNhapHang);
		Image icNhapHang = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblNhapHang.setIcon(new ImageIcon(icNhapHang));
		
		JLabel lblThongKe = new JLabel("Thống kê");
		lblThongKe.setForeground(new Color(255, 255, 255));
		lblThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongKe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblThongKe.setBounds(0, 472, 104, 56);
		MenuPanel.add(lblThongKe);
		Image icThongKe = new ImageIcon(this.getClass().getResource("/Discount.png")).getImage()	;
		lblThongKe.setIcon(new ImageIcon(icThongKe));
		
		JPanel pnProductsTable = new JPanel();
		pnProductsTable.setBackground(new Color(31, 29, 43));
		pnProductsTable.setBounds(144, 360, 999, 474);
		MainPanel.add(pnProductsTable);
		pnProductsTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(31, 29, 43));
		scrollPane.setBounds(10, 10, 979, 464);
		pnProductsTable.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 SP", "T\u00EAn SP", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u01A1n gi\u00E1", "\u1EA2nh"
			}
		));
		
		txtQunLSn = new JTextField();
		txtQunLSn.setHorizontalAlignment(SwingConstants.CENTER);
		txtQunLSn.setForeground(new Color(255, 255, 255));
		txtQunLSn.setFont(new Font("Times New Roman", Font.BOLD, 36));
		txtQunLSn.setText("Quản Lý Sản Phẩm");
		txtQunLSn.setBackground(new Color(31, 29, 43));
		txtQunLSn.setBounds(146, 10, 999, 67);
		MainPanel.add(txtQunLSn);
		txtQunLSn.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(31, 29, 43));
		panel.setBounds(144, 87, 472, 263);
		MainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setForeground(new Color(255, 255, 255));
		lblMaSP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaSP.setBounds(10, 10, 100, 30);
		panel.add(lblMaSP);
		
		JLabel lblTenSp = new JLabel("Tên Sản Phẩm");
		lblTenSp.setForeground(new Color(255, 255, 255));
		lblTenSp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenSp.setBounds(10, 50, 100, 30);
		panel.add(lblTenSp);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setForeground(new Color(255, 255, 255));
		lblLoai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoai.setBounds(10, 90, 100, 30);
		panel.add(lblLoai);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setForeground(new Color(255, 255, 255));
		lblSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoLuong.setBounds(10, 130, 100, 30);
		panel.add(lblSoLuong);
		
		JLabel lblDonVi = new JLabel("Đơn vị tính");
		lblDonVi.setForeground(new Color(255, 255, 255));
		lblDonVi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDonVi.setBounds(10, 170, 100, 30);
		panel.add(lblDonVi);
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setForeground(new Color(255, 255, 255));
		lblDonGia.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDonGia.setBounds(10, 210, 100, 30);
		panel.add(lblDonGia);
		
		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaSP.setBounds(120, 16, 310, 19);
		panel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSp = new JTextField();
		txtTenSp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTenSp.setBounds(120, 56, 310, 19);
		panel.add(txtTenSp);
		txtTenSp.setColumns(10);
		
		JComboBox comboBoxLoai = new JComboBox();
		comboBoxLoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxLoai.setBounds(120, 95, 310, 21);
		panel.add(comboBoxLoai);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtSoLuong.setBounds(120, 136, 310, 19);
		panel.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		txtDonVi = new JTextField();
		txtDonVi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDonVi.setBounds(120, 176, 310, 19);
		panel.add(txtDonVi);
		txtDonVi.setColumns(10);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDonGia.setBounds(120, 216, 310, 19);
		panel.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(878, 87, 144, 133);
		MainPanel.add(panel_1);
		
		MyButton btnChonAnhSP = new MyButton("Chọn Ảnh");
		btnChonAnhSP.setBackground(new Color(234, 124, 105));
		btnChonAnhSP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChonAnhSP.setBounds(878, 230, 144, 21);
		MainPanel.add(btnChonAnhSP);
	}
}
