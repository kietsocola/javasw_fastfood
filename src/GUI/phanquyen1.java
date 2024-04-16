package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Custom.*;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import DAO.phanquyen_DAO;
import DTO.phanquyen_DTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class phanquyen1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<phanquyen_DTO> ds = new ArrayList<>();
	private boolean isChange = true;
	private phanquyen_DAO temp = new phanquyen_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phanquyen1 frame = new phanquyen1();
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
	public phanquyen1() {
		JButton btnThem , btnSua ,btnXoa,btnHuy,btnLuu;
		JComboBox comboBox;
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel PhanQuyenPanel = new JPanel();
//		tabbedPane.addTab("Quyền", null, PhanQuyenPanel, null);
		PhanQuyenPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelpanel = new JPanel();
		panelpanel.add(PhanQuyenPanel);
		panel.add(panelpanel);
		panelpanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel PhanQuyenMain = new JPanel();
		PhanQuyenPanel.add(PhanQuyenMain);
		PhanQuyenMain.setLayout(new BoxLayout(PhanQuyenMain, BoxLayout.Y_AXIS));
		
		JPanel panel_14 = new JPanel();
		PhanQuyenMain.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("QUẢN LÍ PHÂN QUYỀN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblNewLabel_2);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new EmptyBorder(20, 0, 0, 0));
		PhanQuyenMain.add(panel_15);
		panel_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Nhóm quyền : ");
		panel_15.add(lblNewLabel_3);
	
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new EmptyBorder(0, 0, 0, 15));
		PhanQuyenMain.add(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.X_AXIS));
		
		JCheckBox QLNhapHang = new JCheckBox("Quản lí nhập hàng");
		QLNhapHang.setEnabled(false);
		panel_16.add(QLNhapHang);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new EmptyBorder(0, 0, 0, 19));
		PhanQuyenMain.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));
		
		JCheckBox QLSanPham = new JCheckBox("Quản lí sản phẩm");
		QLSanPham.setEnabled(false);
		panel_17.add(QLSanPham);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new EmptyBorder(0, 0, 0, 19));
		PhanQuyenMain.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.X_AXIS));
		
		JCheckBox QLNhanVien = new JCheckBox("Quản lí nhân viên");
		QLNhanVien.setEnabled(false);
		panel_18.add(QLNhanVien);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new EmptyBorder(0, 0, 0, 11));
		PhanQuyenMain.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));
		
		JCheckBox QLKhachHang = new JCheckBox("Quản lí khách hàng");
		QLKhachHang.setEnabled(false);
		panel_19.add(QLKhachHang);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new EmptyBorder(0, 0, 0, 25));
		PhanQuyenMain.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.X_AXIS));
		
		JCheckBox QLThongKe = new JCheckBox("Quân lí thống kê");
		QLThongKe.setEnabled(false);
		panel_21.add(QLThongKe);
		
		
		
		
		JPanel btnChucNang = new JPanel();
		btnChucNang.setBorder(new EmptyBorder(5, 0, 0, 0));
		PhanQuyenMain.add(btnChucNang);
		btnChucNang.setLayout(new GridLayout(0, 7, 15, 0));
		
		JPanel panel_22 = new JPanel();
		btnChucNang.add(panel_22);
		
		comboBox = new JComboBox() ;
		comboBox.setPreferredSize(new Dimension(150, 21));
		panel_15.add(comboBox);
		btnHuy = new JButton("Hủy");
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnThem.setEnabled(false);
		btnXoa.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JCheckBox[] ql = {QLNhapHang , QLSanPham , QLNhanVien , QLKhachHang ,QLThongKe } ;
					
					btnHuy.setEnabled(true);
					btnLuu.setEnabled(true);
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					btnSua.setEnabled(false);
					comboBox.addItem("");
					comboBox.setEditable(true);
					comboBox.setSelectedItem("");
//					comboBox.setSelectedIndex(comboBox.getItemCount());
					
					System.out.println("\n" + comboBox.getItemCount());
					
					
					QLNhapHang.setEnabled(true);
					QLSanPham.setEnabled(true);
					QLNhanVien.setEnabled(true);
					QLKhachHang.setEnabled(true);
					QLThongKe.setEnabled(true);
					
					
			}
		});
		// Tạo một biểu tượng
        ImageIcon icon = new ImageIcon("D:\\netbean\\javasw_fastfood\\images\\plus.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        btnThem.setIcon(resizedIcon);
		btnSua.setEnabled(false);
        ImageIcon icon1 = new ImageIcon("D:\\netbean\\javasw_fastfood\\images\\edit.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img1 = icon1.getImage();
        Image resizedImg1 = img1.getScaledInstance(18, 18, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
        btnSua.setIcon(resizedIcon1);
		
		btnXoa.setEnabled(false);
        ImageIcon icon2 = new ImageIcon("D:\\netbean\\javasw_fastfood\\images\\delete.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img2 = icon2.getImage();
        Image resizedImg2 = img2.getScaledInstance(18, 18, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon2 = new ImageIcon(resizedImg2);
        btnXoa.setIcon(resizedIcon2);
		
		btnHuy.setEnabled(false);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHuy.setEnabled(false);
				btnLuu.setEnabled(false);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				
				QLNhapHang.setEnabled(false);
				QLSanPham.setEnabled(false);
				QLNhanVien.setEnabled(false);
				QLKhachHang.setEnabled(false);
				QLThongKe.setEnabled(false);
				
				comboBox.setEditable(false);
				
				try {
					ds = temp.getData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				String[] model = new String[ds.size()];
				System.out.print(model.length);
				comboBox.removeAllItems();
				for(int i = 0 ; i <  model.length ; i++ )
					comboBox.addItem(ds.get(i).getTenPhanQuyen());
			}
		});
		btnChucNang.add(btnThem);
		btnChucNang.add(btnSua);
		btnChucNang.add(btnXoa);
		btnChucNang.add(btnHuy);
		btnChucNang.add(btnLuu);
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(isChange) {
					try {
						ds = temp.getData();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					String[] model = new String[ds.size()];
					System.out.print(model.length);
					comboBox.removeAllItems();
					for(int i = 0 ; i <  model.length ; i++ )
						comboBox.addItem(ds.get(i).getTenPhanQuyen());
					btnThem.setEnabled(true);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
					isChange = false ;
				}
			}
		});
		 comboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Lấy giá trị được chọn từ ComboBox
	                String selectedLanguage = (String) comboBox.getSelectedItem();
	                int index = (int)comboBox.getSelectedIndex();
					QLNhapHang.setSelected(ds.get(index).getNhaphang());
					QLSanPham.setSelected(ds.get(index).getSanpham());
					QLNhanVien.setSelected(ds.get(index).getNhanvien());
					QLKhachHang.setSelected(ds.get(index).getKhachhang());
					QLThongKe.setSelected(ds.get(index).getThongke());
					
	                // Hiển thị giá trị được chọn trong Console (hoặc làm bất kỳ điều gì bạn muốn với giá trị này)
	                System.out.println("Selected Quyen: " + selectedLanguage + "\n da duoc edit chua : " + isChange);
	            }
	        });
		
		JPanel panel_20 = new JPanel();
		PhanQuyenPanel.add(panel_20);
		


}
	}