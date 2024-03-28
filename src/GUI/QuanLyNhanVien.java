package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Custom.MyColor;


import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class QuanLyNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_tenNV;
	private JTextField textField_soDT;
	private JTextField textField_timKiem;
	private JTextField textField_maNV;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien frame = new QuanLyNhanVien();
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
	public QuanLyNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,820,630 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		contentPane.setBackground(MyColor.BORDER_COLOR);
		
		 
		
		Object data[][]= {};
        String column[]= { "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT"};
		Panel panel_tableNhanVien = new Panel();
		panel_tableNhanVien.setBounds(10, 40, 800, 178);
		contentPane.add(panel_tableNhanVien);
		panel_tableNhanVien.setLayout(null);
		table = new JTable(data,column);
		table.setBounds(75, 412, 453, 212);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 6, 780, 167);
		sp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_tableNhanVien.add(sp);
		
		
		
		
		
		JPanel panel_nhap_timKiem_duLieu = new JPanel();
		panel_nhap_timKiem_duLieu.setBounds(10, 224, 800, 358);
		contentPane.add(panel_nhap_timKiem_duLieu);
		panel_nhap_timKiem_duLieu.setLayout(null);
		
		panel_nhap_timKiem_duLieu.setBackground(MyColor.BORDER_COLOR);
		
		JPanel panel_dienThongTin = new JPanel();
		panel_dienThongTin.setBounds(10, 11, 530, 336);
		panel_nhap_timKiem_duLieu.add(panel_dienThongTin);
		panel_dienThongTin.setLayout(null);
		
		panel_dienThongTin.setBackground(MyColor.BORDER_COLOR);
		
		Panel panel_dienMa = new Panel();
		panel_dienMa.setBounds(10, 0, 373, 60);
		panel_dienThongTin.add(panel_dienMa);
		panel_dienMa.setLayout(null);
		
		Label label = new Label("Mã Nhân Viên");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(10, 19, 113, 30);
		panel_dienMa.add(label);
		
		
		label.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		
		panel_dienMa.setBackground(MyColor.BORDER_COLOR);
		
		
		
		textField_maNV = new JTextField();
		textField_maNV.setColumns(10);
		textField_maNV.setBounds(129, 19, 234, 30);
		panel_dienMa.add(textField_maNV);
		
		textField_maNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		
		Panel panel_dienTen = new Panel();
		panel_dienTen.setBounds(10, 66, 373, 57);
		panel_dienThongTin.add(panel_dienTen);
		panel_dienTen.setLayout(null);
		
		panel_dienTen.setBackground(MyColor.BORDER_COLOR);
		
		Label label_1 = new Label("Tên Nhân Viên");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 10, 114, 36);
		panel_dienTen.add(label_1);
		
		label_1.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_tenNV = new JTextField();
		textField_tenNV.setColumns(10);
		textField_tenNV.setBounds(129, 19, 234, 30);
		panel_dienTen.add(textField_tenNV);
		
		textField_tenNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		Panel panel_ngaySinh = new Panel();
		panel_ngaySinh.setBounds(10, 129, 373, 57);
		panel_dienThongTin.add(panel_ngaySinh);
		panel_ngaySinh.setLayout(null);
		
		panel_ngaySinh.setBackground(MyColor.BORDER_COLOR);
		
		Label label_2 = new Label("Ngày Sinh");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 10, 102, 37);
		panel_ngaySinh.add(label_2);
		
		label_2.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(126, 11, 237, 35);
		panel_ngaySinh.add(panel_14);
		panel_14.setLayout(null);
		
		panel_14.setBackground(MyColor.BORDER_COLOR);
		
		JSpinner spinner_ngaysinh = new JSpinner();
		spinner_ngaysinh.setBounds(0, 11, 38, 20);
		panel_14.add(spinner_ngaysinh);
		
		spinner_ngaysinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JSpinner spinner_thangSinh = new JSpinner();
		spinner_thangSinh.setBounds(103, 11, 38, 20);
		panel_14.add(spinner_thangSinh);
		
		spinner_thangSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JSpinner spinner_namSinh = new JSpinner();
		spinner_namSinh.setBounds(189, 11, 38, 20);
		panel_14.add(spinner_namSinh);
		
		spinner_namSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		Panel panel_gioiTinh = new Panel();
		panel_gioiTinh.setBounds(10, 192, 373, 60);
		panel_dienThongTin.add(panel_gioiTinh);
		panel_gioiTinh.setLayout(null);
		
		panel_gioiTinh.setBackground(MyColor.BORDER_COLOR);
		
		Label label_3 = new Label("Giới Tính");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 10, 104, 42);
		panel_gioiTinh.add(label_3);
		
		label_3.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		JRadioButton RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nam.setBounds(155, 9, 58, 43);
		panel_gioiTinh.add(RadioButton_Nam);
		
		RadioButton_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_Nam.setBackground(MyColor.BORDER_COLOR);
		
		JRadioButton RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nu.setBounds(275, 10, 58, 42);
		panel_gioiTinh.add(RadioButton_Nu);
		
		RadioButton_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_Nu.setBackground(MyColor.BORDER_COLOR);
		
		JPanel panel_soDT = new JPanel();
		panel_soDT.setBounds(10, 263, 373, 60);
		panel_dienThongTin.add(panel_soDT);
		panel_soDT.setLayout(null);
		
		panel_soDT.setBackground(MyColor.BORDER_COLOR);
		
		Label label_8 = new Label("Số ĐT");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(10, 10, 66, 39);
		panel_soDT.add(label_8);
		
		label_8.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_soDT = new JTextField();
		textField_soDT.setBounds(129, 15, 234, 30);
		panel_soDT.add(textField_soDT);
		textField_soDT.setColumns(10);
		
		textField_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JButton themButton = new JButton("Thêm");
		themButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		themButton.setBounds(420, 24, 89, 23);
		
		panel_dienThongTin.add(themButton);
		themButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		themButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		JButton xoaButton = new JButton("Xoá");
		xoaButton.setBounds(420, 73, 89, 23);
		xoaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		xoaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_dienThongTin.add(xoaButton);
		
		JButton SuaButton = new JButton("Sửa");
		SuaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SuaButton.setBounds(420, 129, 89, 23);
		SuaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		SuaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_dienThongTin.add(SuaButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		resetButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		resetButton.setBounds(420, 198, 89, 23);
		panel_dienThongTin.add(resetButton);
		
	
        
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBounds(550, 11, 240, 334);
		panel_nhap_timKiem_duLieu.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		panel_TimKiem.setBackground(MyColor.BORDER_COLOR);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setBounds(95, 67, 55, 20);
		panel_TimKiem.add(lblNewLabel);
		
		lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setBounds(25, 115, 200, 30);
		panel_TimKiem.add(textField_timKiem);
		textField_timKiem.setColumns(10);
		
		textField_timKiem.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JRadioButton RadioButton_maNV = new JRadioButton("Mã nhân viên");
		RadioButton_maNV.setBounds(18, 165, 111, 23);
		panel_TimKiem.add(RadioButton_maNV);
		
		RadioButton_maNV.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_maNV.setBackground(MyColor.BORDER_COLOR);
		
		JRadioButton RadioButton_tenNV = new JRadioButton("Tên nhân viên");
		RadioButton_tenNV.setBounds(125, 165, 111, 23);
		panel_TimKiem.add(RadioButton_tenNV);
		
		RadioButton_tenNV.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_tenNV.setBackground(MyColor.BORDER_COLOR);
		
		JLabel Label_TieuDe = new JLabel("NHÂN VIÊN");
		Label_TieuDe.setBounds(390, 11, 74, 18);
		contentPane.add(Label_TieuDe);
		
		Label_TieuDe.setForeground(MyColor.SECOND_TEXT_COLOR);
	}
}
