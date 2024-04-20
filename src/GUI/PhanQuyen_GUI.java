package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.phanquyen_BUS;
import Custom.*;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PhanQuyen_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyButton btnThem , btnSua ,btnXoa,btnHuy,btnLuu,btnLamMoi;
	private MyPanel PanelPhanQuyen,MainPhanQuyen,panel_22,LabelName,btnChucNang,QuyenThongKe,PanelTenQuyen,QuyenNhapHang,QuyenSanPham,QuyenNhanVien,QuyenKhachHang,panel_20;
	private ArrayList<phanquyen_DTO> ds = new ArrayList<>();
	private phanquyen_DTO tempPQ ;
	private boolean isThem = false,isSua = false , isXoa = false;
	private boolean isBtnChucNang = false;
	private phanquyen_DAO temp = new phanquyen_DAO();
	private phanquyen_BUS pqB = new phanquyen_BUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanQuyen_GUI frame = new PhanQuyen_GUI();
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
	public PhanQuyen_GUI() {
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
		
		PanelPhanQuyen = new MyPanel();
		PanelPhanQuyen.setLayout(new GridLayout(2, 1, 0, 0));
		panel.add(PanelPhanQuyen);
		
		MainPhanQuyen = new MyPanel();
		PanelPhanQuyen.add(MainPhanQuyen);
		MainPhanQuyen.setLayout(new BoxLayout(MainPhanQuyen, BoxLayout.Y_AXIS));
		
		LabelName = new MyPanel();
//		LabelName.setBorder(new EmptyBorder(20, 0, 0, 0));
		MainPhanQuyen.add(LabelName);
		LabelName.setLayout(new GridLayout(1, 0, 0, 0));
		
		MyLabel lblNewLabel_2 = new MyLabel("QUẢN LÍ PHÂN QUYỀN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelName.add(lblNewLabel_2);
		
		PanelTenQuyen = new MyPanel();
//		PanelTenQuyen.setBorder(new EmptyBorder(20, 0, 20, 0));
		MainPhanQuyen.add(PanelTenQuyen);
		PanelTenQuyen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Nhóm quyền : ");
		PanelTenQuyen.add(lblNewLabel_3);
	
		
		QuyenNhapHang = new MyPanel();
		QuyenNhapHang.setBorder(new EmptyBorder(0, 0, 0, 15));
		MainPhanQuyen.add(QuyenNhapHang);
		QuyenNhapHang.setLayout(new BoxLayout(QuyenNhapHang, BoxLayout.X_AXIS));
		JCheckBox QLNhapHang = new JCheckBox("Quản lí nhập hàng");
		QLNhapHang.setEnabled(false);
		QLNhapHang.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		QuyenNhapHang.add(QLNhapHang);
		
		QuyenSanPham = new MyPanel();
		QuyenSanPham.setBorder(new EmptyBorder(0, 0, 0, 19));
		MainPhanQuyen.add(QuyenSanPham);
		QuyenSanPham.setLayout(new BoxLayout(QuyenSanPham, BoxLayout.X_AXIS));
		JCheckBox QLSanPham = new JCheckBox("Quản lí sản phẩm");
		QLSanPham.setEnabled(false);
		QLSanPham.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		QuyenSanPham.add(QLSanPham);
		
		QuyenNhanVien = new MyPanel();
		QuyenNhanVien.setBorder(new EmptyBorder(0, 0, 0, 19));
		MainPhanQuyen.add(QuyenNhanVien);
		QuyenNhanVien.setLayout(new BoxLayout(QuyenNhanVien, BoxLayout.X_AXIS));
		JCheckBox QLNhanVien = new JCheckBox("Quản lí nhân viên");
		QLNhanVien.setEnabled(false);
		QLNhanVien.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		QuyenNhanVien.add(QLNhanVien);
		
		QuyenKhachHang = new MyPanel();
		QuyenKhachHang.setBorder(new EmptyBorder(0, 0, 0, 11));
		MainPhanQuyen.add(QuyenKhachHang);
		QuyenKhachHang.setLayout(new BoxLayout(QuyenKhachHang, BoxLayout.X_AXIS));
		JCheckBox QLKhachHang = new JCheckBox("Quản lí khách hàng");
		QLKhachHang.setEnabled(false);
		QLKhachHang.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		QuyenKhachHang.add(QLKhachHang);
		
		QuyenThongKe = new MyPanel();
		QuyenThongKe.setBorder(new EmptyBorder(0, 0, 0, 25));
		MainPhanQuyen.add(QuyenThongKe);
		QuyenThongKe.setLayout(new BoxLayout(QuyenThongKe, BoxLayout.X_AXIS));
		
		JCheckBox QLThongKe = new JCheckBox("Quân lí thống kê");
		QLThongKe.setEnabled(false);
		QLThongKe.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		QuyenThongKe.add(QLThongKe);
		
		JCheckBox[] ql = {QLNhapHang , QLSanPham , QLNhanVien , QLKhachHang ,QLThongKe } ;
		
		
		btnChucNang = new MyPanel();
		btnChucNang.setBorder(new EmptyBorder(5, 0, 0, 0));
		MainPhanQuyen.add(btnChucNang);
		btnChucNang.setLayout(new GridLayout(0, 7, 15, 0));
		
		panel_22 = new MyPanel();
		btnChucNang.add(panel_22);
		
		comboBox = new JComboBox() ;

		comboBox.setPreferredSize(new Dimension(150, 21));
		PanelTenQuyen.add(comboBox);
		
		btnLamMoi = new MyButton("Làm mới");
		btnHuy = new MyButton("Hủy");
		btnThem = new MyButton("Thêm");
		btnSua = new MyButton("Sửa");
		btnXoa = new MyButton("Xóa");
		btnLuu = new MyButton("Lưu");
		btnLuu.setEnabled(false);
		btnThem.setEnabled(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnHuy.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					isBtnChucNang = true;

					
					btnHuy.setEnabled(true);
					btnLuu.setEnabled(true);
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					btnSua.setEnabled(false);
					btnLamMoi.setEnabled(false);
					
					System.out.println("dang them  1 phan tu moi vao comboBox ");
					
					String newItem  =  JOptionPane.showInputDialog("Nhâp tên quyền:");
					if (newItem != null && !newItem.isEmpty()) {
						comboBox.addItem(newItem);
						comboBox.setSelectedItem(newItem);
						isThem = true;
						for(JCheckBox item : ql) {
							item.setSelected(false);
							item.setEnabled(true);
						}
	                } else {
	                    // Người dùng đã hủy hoặc không nhập dữ liệu
	                	JOptionPane.showMessageDialog(btnThem,"người dùng đã hủy hoặc không nhập dữ liệu vì thế không thể thêm","Thong bao",0);
	    				
	    				btnHuy.setEnabled(false);
	    				btnLuu.setEnabled(false);
	    				btnThem.setEnabled(true);
	    				btnSua.setEnabled(true);
	    				btnXoa.setEnabled(true);
	    				btnLamMoi.setEnabled(false);
	                }
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(false);
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
				btnLamMoi.setEnabled(false);
				for(JCheckBox item : ql) {
					item.setEnabled(true);
				}
				
				comboBox.setEditable(true);
				
				isSua = true;
				isBtnChucNang = true;
				tempPQ = ds.get(comboBox.getSelectedIndex());
				
				
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(false);
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
				btnLamMoi.setEnabled(false);
				
				isXoa = true;
				isBtnChucNang = true;
				tempPQ = ds.get(comboBox.getSelectedIndex());
			}
		});
		// Tạo một biểu tượng
        ImageIcon icon = new ImageIcon("..\\javasw_fastfood\\images\\plus.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        btnThem.setIcon(resizedIcon);
        
        ImageIcon icon1 = new ImageIcon("..\\javasw_fastfood\\images\\edit.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img1 = icon1.getImage();
        Image resizedImg1 = img1.getScaledInstance(18, 18, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
        btnSua.setIcon(resizedIcon1);
        
        ImageIcon icon2 = new ImageIcon("..\\javasw_fastfood\\images\\delete.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img2 = icon2.getImage();
        Image resizedImg2 = img2.getScaledInstance(18, 18, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon2 = new ImageIcon(resizedImg2);
        btnXoa.setIcon(resizedIcon2);
		
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isThem) {
					comboBox.removeItemAt(comboBox.getModel().getSize() - 1);
					comboBox.setSelectedIndex(0);
					isThem = false;
				}
				
				if(isSua) {
					comboBox.setSelectedItem(tempPQ.getTenPhanQuyen());
					isSua = false;
				}
				
				for(JCheckBox item : ql) {
					item.setEnabled(false);
				}
				
				btnHuy.setEnabled(false);
				btnLuu.setEnabled(false);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnLamMoi.setEnabled(false);
				
				comboBox.setEditable(false);
				isBtnChucNang = false;
		
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameQuyen = comboBox.getSelectedItem().toString();
				boolean nhaphang = QLNhapHang.isSelected() ;
				boolean sanpham = QLSanPham.isSelected() ;
				boolean nhanvien = QLNhanVien.isSelected();
				boolean khachhang = QLKhachHang.isSelected();
				boolean thongke = QLThongKe.isSelected();
				
				phanquyen_DTO phanquyen = new phanquyen_DTO();
				phanquyen.setTenPhanQuyen(nameQuyen);
				phanquyen.setNhaphang(nhaphang);
				phanquyen.setNhanvien(nhanvien);
				phanquyen.setKhachhang(khachhang);
				phanquyen.setThongke(thongke);
				phanquyen.setSanpham(sanpham);
				
				if(isThem) {
					/// tang id tu dong
					phanquyen.setIdPhanQuyen(ds.get(ds.size() - 1).getIdPhanQuyen() + 1);
					JOptionPane.showMessageDialog(btnXoa,pqB.themPhanQuyen(phanquyen),"Thong bao",0);
					isThem = false;
				}
				
				if(isSua) {
					phanquyen.setIdPhanQuyen(tempPQ.getIdPhanQuyen());
					JOptionPane.showMessageDialog(btnXoa,pqB.suaPhanQuyen(phanquyen),"Thong bao",0);
					isSua=false;
				}
				
				if(isXoa) {
					phanquyen.setIdPhanQuyen(tempPQ.getIdPhanQuyen());
					JOptionPane.showMessageDialog(btnXoa,pqB.xoaPhanQuyen(phanquyen),"Thong bao",0);
					isXoa=false;
				}
				
				
				
				///BAT TAT CAC NUT////
				for(JCheckBox item : ql) {
					item.setEnabled(false);
				}
				btnHuy.setEnabled(false);
				btnLuu.setEnabled(false);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnLamMoi.setEnabled(true);
				comboBox.setEditable(false);
				///BAT TAT CAC NUT////
				
			}
		});
		
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						ds = temp.getData();
						if(ds.size() <= 0)
						{
							btnThem.setEnabled(true);
							btnLamMoi.setEnabled(false);
							return ;
						}
					} catch (SQLException e1) {
						System.out.println("lay danh sach quyen that bai");
					}
					
					comboBox.removeAllItems();
					for(int i = 0 ; i <  ds.size() ; i++ )
						comboBox.addItem(ds.get(i).getTenPhanQuyen());
					btnThem.setEnabled(true);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
					isBtnChucNang = false;
					btnLamMoi.setEnabled(false);
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getModel().getSize() > 0 && !isBtnChucNang)
				{
					// Lấy giá trị được chọn từ ComboBox
	                String selectedLanguage = (String) comboBox.getSelectedItem();
	                int index = (int)comboBox.getSelectedIndex();
					QLNhapHang.setSelected(ds.get(index).getNhaphang());
					QLSanPham.setSelected(ds.get(index).getSanpham());
					QLNhanVien.setSelected(ds.get(index).getNhanvien());
					QLKhachHang.setSelected(ds.get(index).getKhachhang());
					QLThongKe.setSelected(ds.get(index).getThongke());
					
	                // Hiển thị giá trị được chọn trong Console (hoặc làm bất kỳ điều gì bạn muốn với giá trị này)
//	                System.out.println("Selected Quyen: " + selectedLanguage );
				}
			}
		});
		 comboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            }
	        });
		
		
		panel_20 = new MyPanel();
		PanelTenQuyen.add(btnLamMoi);
		btnChucNang.add(btnThem);
		btnChucNang.add(btnSua);
		btnChucNang.add(btnXoa);
		btnChucNang.add(btnHuy);
		btnChucNang.add(btnLuu);
		PanelPhanQuyen.add(panel_20);
		


}
	}