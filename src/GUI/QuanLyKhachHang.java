package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Custom.MyColor;
import java.awt.Color;

public class QuanLyKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_tenKH;
	private JTextField textField_maKH;
	private JTextField textField_tongChiTieu;
	private JTextField textField_timKiem;
	private JTextField textField_sodt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang frame = new QuanLyKhachHang();
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
	public QuanLyKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,930,630 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		contentPane.setBackground(MyColor.BORDER_COLOR);
		
		 
		
		Object data[][]= {};
        String column[]= { "STT", "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính",  "Số ĐT",  "Tồng Số Chi Tiêu"};
		Panel panel_tableNhanVien = new Panel();
		panel_tableNhanVien.setBounds(10, 40, 900, 178);
		contentPane.add(panel_tableNhanVien);
		panel_tableNhanVien.setLayout(null);
		table = new JTable(data,column);
		table.setBounds(75, 412, 453, 212);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 6, 880, 167);
		sp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_tableNhanVien.add(sp);
		
		
		
		
		
		JPanel panel_nhap_timKiem_duLieu = new JPanel();
		panel_nhap_timKiem_duLieu.setBounds(10, 224, 900, 358);
		contentPane.add(panel_nhap_timKiem_duLieu);
		panel_nhap_timKiem_duLieu.setLayout(null);
		
		panel_nhap_timKiem_duLieu.setBackground(MyColor.BORDER_COLOR);
		
		JPanel panel_dienThongTin = new JPanel();
		panel_dienThongTin.setBounds(10, 11, 630, 336);
		panel_nhap_timKiem_duLieu.add(panel_dienThongTin);
		panel_dienThongTin.setLayout(null);
		
		panel_dienThongTin.setBackground(MyColor.BORDER_COLOR);
		
		Panel panel_dienMa = new Panel();
		panel_dienMa.setBounds(10, 0, 435, 60);
		panel_dienThongTin.add(panel_dienMa);
		panel_dienMa.setLayout(null);
		
		Label label = new Label("Mã KH");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(10, 19, 113, 30);
		panel_dienMa.add(label);
		
		
		label.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		
		panel_dienMa.setBackground(MyColor.BORDER_COLOR);
		
		
		
		textField_maKH = new JTextField();
		textField_maKH.setColumns(10);
		textField_maKH.setBounds(191, 19, 234, 30);
		panel_dienMa.add(textField_maKH);
		
		
		
		textField_maKH.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		
		Panel panel_dienTen = new Panel();
		panel_dienTen.setBounds(10, 66, 435, 57);
		panel_dienThongTin.add(panel_dienTen);
		panel_dienTen.setLayout(null);
		
		panel_dienTen.setBackground(MyColor.BORDER_COLOR);
		
		Label label_1 = new Label("Tên KH");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 10, 114, 36);
		panel_dienTen.add(label_1);
		
		label_1.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_tenKH = new JTextField();
		textField_tenKH.setColumns(10);
		textField_tenKH.setBounds(191, 16, 234, 30);
		panel_dienTen.add(textField_tenKH);
		
		
		
		textField_tenKH.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JPanel panel_tongSochiTieu = new JPanel();
		panel_tongSochiTieu.setBounds(10, 263, 435, 58);
		panel_dienThongTin.add(panel_tongSochiTieu);
		panel_tongSochiTieu.setLayout(null);
		
		panel_tongSochiTieu.setBackground(MyColor.BORDER_COLOR);
		
		Label label_6 = new Label("Tổng Chi Tiêu");
		label_6.setBounds(10, 10, 140, 35);
		panel_tongSochiTieu.add(label_6);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		label_6.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		
		
		textField_tongChiTieu = new JTextField();
		textField_tongChiTieu.setColumns(10);
		textField_tongChiTieu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		textField_tongChiTieu.setBounds(191, 15, 234, 30);
		panel_tongSochiTieu.add(textField_tongChiTieu);
		
		JPanel panel_SoDT = new JPanel();
		panel_SoDT.setBounds(10, 195, 435, 57);
		panel_dienThongTin.add(panel_SoDT);
		panel_SoDT.setLayout(null);
		
		panel_SoDT.setBackground(MyColor.BORDER_COLOR);
		
		Label label_8 = new Label("Số ĐT");
		label_8.setBounds(10, 10, 66, 39);
		panel_SoDT.add(label_8);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		label_8.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_sodt = new JTextField();
		textField_sodt.setBounds(191, 10, 234, 30);
		panel_SoDT.add(textField_sodt);
		textField_sodt.setColumns(10);
		
		textField_sodt.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		Panel panel_gioiTinh = new Panel();
		panel_gioiTinh.setLayout(null);
		panel_gioiTinh.setBackground(new Color(57, 60, 73));
		panel_gioiTinh.setBounds(10, 129, 435, 60);
		panel_dienThongTin.add(panel_gioiTinh);
		
	
		
		Label label_3 = new Label("Giới Tính");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 10, 104, 42);
		panel_gioiTinh.add(label_3);
		
		JRadioButton RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setForeground(Color.WHITE);
		RadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nam.setBackground(new Color(57, 60, 73));
		RadioButton_Nam.setBounds(190, 9, 58, 43);
		panel_gioiTinh.add(RadioButton_Nam);
		
		JRadioButton RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setForeground(Color.WHITE);
		RadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nu.setBackground(new Color(57, 60, 73));
		RadioButton_Nu.setBounds(354, 10, 58, 42);
		panel_gioiTinh.add(RadioButton_Nu);
		
		JButton themButton = new JButton("Thêm");
		themButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		themButton.setBounds(500, 24, 89, 23);
		
		panel_dienThongTin.add(themButton);
		themButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		themButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		JButton xoaButton = new JButton("Xoá");
		xoaButton.setBounds(500, 73, 89, 23);
		xoaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		xoaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_dienThongTin.add(xoaButton);
		
		JButton SuaButton = new JButton("Sửa");
		SuaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SuaButton.setBounds(500, 129, 89, 23);
		SuaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		SuaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_dienThongTin.add(SuaButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		resetButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		resetButton.setBounds(500, 198, 89, 23);
		panel_dienThongTin.add(resetButton);
		
		
		
	
        
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBounds(650, 11, 240, 336);
		panel_nhap_timKiem_duLieu.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		panel_TimKiem.setBackground(MyColor.BORDER_COLOR);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setBounds(95, 67, 55, 20);
		panel_TimKiem.add(lblNewLabel);
		
		lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setColumns(10);
		textField_timKiem.setBackground(new Color(45, 48, 62));
		textField_timKiem.setBounds(20, 120, 200, 30);
		panel_TimKiem.add(textField_timKiem);
		
		JLabel lblKhchHng = new JLabel("KHÁCH HÀNG");
		lblKhchHng.setBounds(430, 11, 74, 18);
		contentPane.add(lblKhchHng);
		
		lblKhchHng.setForeground(MyColor.SECOND_TEXT_COLOR);
	}
}
