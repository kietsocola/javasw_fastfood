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
import Custom.CustomJDialog;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import DTO.phanquyen_DTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class PhanQuyen_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyButton btnThem , btnSua ,btnXoa,btnHuy,btnLuu,btnLamMoi;
	private MyPanel PanelPhanQuyen,MainPhanQuyen,panel_22,LabelName,btnChucNang,panel_20;
	private MyPanelSecond QuyenThongKe,PanelTenQuyen,QuyenNhapHang,QuyenSanPham,QuyenNhanVien,QuyenKhachHang;
	private ArrayList<phanquyen_DTO> ds = new ArrayList<>();
	private phanquyen_DTO tempPQ ;
	private boolean isThem = false,isSua = false , isXoa = false;
	private boolean isBtnChucNang = false;
	private phanquyen_BUS pqB = new phanquyen_BUS();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PhanQuyen_GUI() {
		JComboBox comboBox;
		
		this.setLayout(new GridLayout(0, 1, 0, 0));
		
		PanelPhanQuyen = new MyPanel();
		PanelPhanQuyen.setLayout(new GridLayout(2, 1, 0, 0));
		this.add(PanelPhanQuyen);
		
		MainPhanQuyen = new MyPanel();
		PanelPhanQuyen.add(MainPhanQuyen);
		MainPhanQuyen.setLayout(new BoxLayout(MainPhanQuyen, BoxLayout.Y_AXIS));
		
		LabelName = new MyPanel();
//		LabelName.setBorder(new EmptyBorder(20, 0, 0, 0));
		MainPhanQuyen.add(LabelName);
		LabelName.setLayout(new GridLayout(1, 0, 0, 0));
		LabelName.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		
		MyLabel lblNewLabel_2 = new MyLabel("QUẢN LÍ PHÂN QUYỀN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		LabelName.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));

		
		PanelTenQuyen = new MyPanelSecond();
//		PanelTenQuyen.setBorder(new EmptyBorder(20, 0, 20, 0));
		MainPhanQuyen.add(PanelTenQuyen);
		PanelTenQuyen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Nhóm quyền : ");
		lblNewLabel_3.setFont(new Font("Arial" , Font.PLAIN , 20));
		PanelTenQuyen.add(lblNewLabel_3);
	
		QuyenNhapHang = new MyPanelSecond();
		QuyenNhapHang.setBorder(new EmptyBorder(0, 0, 0, 15));
		MainPhanQuyen.add(QuyenNhapHang);
		QuyenNhapHang.setLayout(new BoxLayout(QuyenNhapHang, BoxLayout.X_AXIS));
		JCheckBox QLNhapHang = new JCheckBox("Quản lí nhập hàng");
		QLNhapHang.setFont(new Font("Arial" , Font.BOLD , 16));
		QLNhapHang.setEnabled(false);
		QLNhapHang.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		QuyenNhapHang.add(QLNhapHang);
		
		QuyenSanPham = new MyPanelSecond();
		QuyenSanPham.setBorder(new EmptyBorder(0, 0, 0, 21));
		MainPhanQuyen.add(QuyenSanPham);
		QuyenSanPham.setLayout(new BoxLayout(QuyenSanPham, BoxLayout.X_AXIS));
		JCheckBox QLSanPham = new JCheckBox("Quản lí sản phẩm");
		QLSanPham.setEnabled(false);
		QLSanPham.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		QLSanPham.setFont(new Font("Arial" , Font.BOLD , 16));
		QuyenSanPham.add(QLSanPham);
		
		QuyenNhanVien = new MyPanelSecond();
		QuyenNhanVien.setBorder(new EmptyBorder(0, 0, 0, 21));
		MainPhanQuyen.add(QuyenNhanVien);
		QuyenNhanVien.setLayout(new BoxLayout(QuyenNhanVien, BoxLayout.X_AXIS));
		JCheckBox QLNhanVien = new JCheckBox("Quản lí nhân viên");
		QLNhanVien.setEnabled(false);
		QLNhanVien.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		QLNhanVien.setFont(new Font("Arial" , Font.BOLD , 16));
		QuyenNhanVien.add(QLNhanVien);
		
		QuyenKhachHang = new MyPanelSecond();
		QuyenKhachHang.setBorder(new EmptyBorder(0, 0, 0, 8));
		MainPhanQuyen.add(QuyenKhachHang);
		QuyenKhachHang.setLayout(new BoxLayout(QuyenKhachHang, BoxLayout.X_AXIS));
		JCheckBox QLKhachHang = new JCheckBox("Quản lí khách hàng");
		QLKhachHang.setEnabled(false);
		QLKhachHang.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		QLKhachHang.setFont(new Font("Arial" , Font.BOLD , 16));
		QuyenKhachHang.add(QLKhachHang);
		
		QuyenThongKe = new MyPanelSecond();
		QuyenThongKe.setBorder(new EmptyBorder(0, 0, 0, 28));
		MainPhanQuyen.add(QuyenThongKe);
		QuyenThongKe.setLayout(new BoxLayout(QuyenThongKe, BoxLayout.X_AXIS));
		
		JCheckBox QLThongKe = new JCheckBox("Quân lí thống kê");
		QLThongKe.setEnabled(false);
		QLThongKe.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		QLThongKe.setFont(new Font("Arial" , Font.BOLD , 16));
		QuyenThongKe.add(QLThongKe);
		
		JCheckBox[] ql = {QLNhapHang , QLSanPham , QLNhanVien , QLKhachHang ,QLThongKe } ;
		
		
		btnChucNang = new MyPanel();
		btnChucNang.setBorder(new EmptyBorder(30, 0, 50, 0));
		MainPhanQuyen.add(btnChucNang);
		btnChucNang.setLayout(new GridLayout(0, 7, 15, 0));
		
		panel_22 = new MyPanel();
		btnChucNang.add(panel_22);
		
		comboBox = new JComboBox() ;
		comboBox.setFont(new Font("Arial" , Font.PLAIN , 18));
		comboBox.setPreferredSize(new Dimension(150, 25));
		PanelTenQuyen.add(comboBox);
		
		btnLamMoi = new MyButton("Làm mới");
		btnLamMoi.setPreferredSize(new Dimension(100,25));
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
		
		ItemListener reComboBox = new ItemListener() {
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
	                System.out.println("Selected Quyen: " + selectedLanguage );
				}
			}
		};
		
		ActionListener reBtnLamMoi = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds = pqB.getData();
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
				// Lấy giá trị được chọn từ ComboBox
                String selectedLanguage = (String) comboBox.getSelectedItem();
                int index = (int)comboBox.getSelectedIndex();
				QLNhapHang.setSelected(ds.get(index).getNhaphang());
				QLSanPham.setSelected(ds.get(index).getSanpham());
				QLNhanVien.setSelected(ds.get(index).getNhanvien());
				QLKhachHang.setSelected(ds.get(index).getKhachhang());
				QLThongKe.setSelected(ds.get(index).getThongke());
				
                // Hiển thị giá trị được chọn trong Console (hoặc làm bất kỳ điều gì bạn muốn với giá trị này)
                System.out.println("Selected Quyen: " + selectedLanguage );
		}
	};
		
		
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
            	CustomJDialog dialog = new CustomJDialog();
            	String newItem = JOptionPane.showInputDialog("nhap ten quyen : ");
            	int ketqua  =0;
            	String regex = "[\\p{L}\\p{N}]+(\\s[\\p{L}\\p{N}]+)*";
            	Pattern pattern = Pattern.compile(regex);
            	Matcher matcher = pattern.matcher(newItem);
            	
                	if (newItem != null && !newItem.isEmpty()) {
                    	try {
                    		if(matcher.matches())
                    		{
                    			dialog.notifi("Tên phân quyền có thể chứa chữ,sô,1 khoảng trắng giữa các từ");
                                btnHuy.setEnabled(false);
                        	   	btnLuu.setEnabled(false);
                        	   	btnThem.setEnabled(true);
                        	   	btnSua.setEnabled(true);
                        	   	btnXoa.setEnabled(true);
                        	   	btnLamMoi.setEnabled(true);
                        		return;
                    			
                    		}
        					ketqua = pqB.hasPhanQuyen(newItem);
                        	if(ketqua == 1)
                        	{
                        		dialog.notifi("Tên phân quyền đã tồn tại");
                                btnHuy.setEnabled(false);
                        	   	btnLuu.setEnabled(false);
                        	   	btnThem.setEnabled(true);
                        	   	btnSua.setEnabled(true);
                        	   	btnXoa.setEnabled(true);
                        	   	btnLamMoi.setEnabled(true);
                        		return;
                        	}
        				} catch (SQLException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                        // Thêm mục vào ComboBox
                    	dialog.notifi("Tên phân quyền hợp lệ");
                        comboBox.addItem(newItem);
                        comboBox.setSelectedItem(newItem);
                        isThem = true;
                        for (JCheckBox item : ql) {
                            item.setSelected(false);
                            item.setEnabled(true);
                        }
                    } else {
                        // Người dùng đã hủy hoặc không nhập dữ liệu
                        dialog.notifi("Người dùng đã hủy hoặc không nhập dữ liệu. Vui lòng thử lại.");
                        btnHuy.setEnabled(false);
                	   	btnLuu.setEnabled(false);
                	   	btnThem.setEnabled(true);
                	   	btnSua.setEnabled(true);
                	   	btnXoa.setEnabled(true);
                	   	btnLamMoi.setEnabled(false);
                    }
			}
		});
		
		// Thêm mã sau vào actionPerformed của ActionListener cho btnThem

		
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
//        Image img = icon.getImage();
//        Image resizedImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
//        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        btnThem.setIcon(icon);
        
        ImageIcon icon1 = new ImageIcon("images/edit2.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        Image img1 = icon1.getImage();
        Image resizedImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
        btnSua.setIcon(resizedIcon1);
        
        ImageIcon icon2 = new ImageIcon("images/remove.png");
        Image img2 = icon2.getImage();
        Image resizedImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon2 = new ImageIcon(resizedImg2);
        btnXoa.setIcon(resizedIcon2);
        
        
        ImageIcon icon3 = new ImageIcon("images/Huy.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img3 = icon3.getImage();
        Image resizedImg3 = img3.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon3 = new ImageIcon(resizedImg3);
        btnHuy.setIcon(resizedIcon3);
        
        ImageIcon icon4 = new ImageIcon("images/Luu.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        Image img4 = icon4.getImage();
        Image resizedImg4 = img4.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon4 = new ImageIcon(resizedImg4);
        btnLuu.setIcon(resizedIcon4);
        
        ImageIcon icon5 = new ImageIcon("..\\javasw_fastfood\\images\\LamMoi.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        // Thiết lập kích thước mới cho biểu tượng
        btnLamMoi.setIcon(icon5);
        
        
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isThem) {
					comboBox.removeItemAt(comboBox.getModel().getSize() - 1);
					comboBox.setSelectedIndex(0);
					isThem = false;
				}
				
				if(isSua) {
					comboBox.setSelectedIndex(tempPQ.getIdPhanQuyen() - 1);
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
				
				CustomJDialog dialog = new CustomJDialog();
				if(isThem) {
					/// tang id tu dong
					phanquyen.setIdPhanQuyen(ds.get(ds.size() - 1).getIdPhanQuyen() + 1);
					String ketqua = pqB.themPhanQuyen(phanquyen);
					dialog.notifi(ketqua);
					isThem = false;
				}
				
				if(isSua) {
					phanquyen.setIdPhanQuyen(tempPQ.getIdPhanQuyen());
					String ketqua = pqB.suaPhanQuyen(phanquyen);
					dialog.notifi(ketqua);
					isSua=false;
				}
				
				if(isXoa) {
					phanquyen.setIdPhanQuyen(tempPQ.getIdPhanQuyen());
					String ketqua = pqB.xoaPhanQuyen(phanquyen);
					dialog.notifi(ketqua);
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
		
		
		btnLamMoi.addActionListener(reBtnLamMoi);
		comboBox.addItemListener(reComboBox);
		
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