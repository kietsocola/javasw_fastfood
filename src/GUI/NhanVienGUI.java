package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Custom.MyColor;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class NhanVienGUI extends JFrame {

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
					NhanVienGUI frame = new NhanVienGUI();
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
	public NhanVienGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 50));
		
		contentPane.setBackground(MyColor.BORDER_COLOR);
		
		JPanel jPanel_TieuDe = new JPanel();
		jPanel_TieuDe.setPreferredSize(new Dimension(400, 40));
		contentPane.add(jPanel_TieuDe, BorderLayout.NORTH);
		jPanel_TieuDe.setLayout(new BorderLayout());

		jPanel_TieuDe.setBackground(MyColor.BORDER_COLOR);
		
		JLabel Label_TieuDe = new JLabel();
		Label_TieuDe.setText("NHÂN VIÊN");
		Label_TieuDe.setPreferredSize(new Dimension(119, 120));
		Label_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		Label_TieuDe.setForeground(new Color(255, 255, 255));
		Label_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jPanel_TieuDe.add(Label_TieuDe, BorderLayout.CENTER);
		
		
	
		
		Object data[][]= {};
        String column[]= { "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT"};
		Panel panel_tableNhanVien = new Panel();
		panel_tableNhanVien.setPreferredSize(new Dimension(780, 170));
		contentPane.add(panel_tableNhanVien, BorderLayout.CENTER);
		panel_tableNhanVien.setLayout(new BorderLayout(0, 0));
		table = new JTable(data,column);
		table.setPreferredSize(new Dimension(453, 150));
		JScrollPane sp = new JScrollPane(table);
		panel_tableNhanVien.add(sp, BorderLayout.CENTER);
		sp.setPreferredSize(new Dimension(453, 150));
		sp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		Panel panel_nhap_timKiem_duLieu = new Panel();
		 panel_nhap_timKiem_duLieu.setPreferredSize(new Dimension(780, 250));
		contentPane.add(panel_nhap_timKiem_duLieu, BorderLayout.SOUTH);
		
		panel_nhap_timKiem_duLieu.setBackground(MyColor.BORDER_COLOR);
		panel_nhap_timKiem_duLieu.setLayout(new BorderLayout());
		
		JPanel panel_dienThongTin = new JPanel();
		panel_dienThongTin.setPreferredSize(new Dimension(400, 250));
		panel_nhap_timKiem_duLieu.add(panel_dienThongTin,  BorderLayout.WEST);
		panel_dienThongTin.setBackground(MyColor.BORDER_COLOR);
		panel_dienThongTin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Panel panel_dienMa = new Panel();
		panel_dienMa.setPreferredSize(new Dimension(385, 40));
		panel_dienThongTin.add(panel_dienMa);
		panel_dienMa.setLayout(new BorderLayout(10, 10));
		
		Label label = new Label("Mã Nhân Viên");
		label.setPreferredSize(new Dimension(110, 10));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_dienMa.add(label, BorderLayout.WEST);
		
		
		label.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		
		panel_dienMa.setBackground(MyColor.BORDER_COLOR);
		

		textField_maNV = new JTextField();
		textField_maNV.setColumns(10);
		textField_maNV.setPreferredSize(new Dimension(50, 17));
		panel_dienMa.add(textField_maNV, BorderLayout.CENTER);
		
		textField_maNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		
		Panel panel_dienTen = new Panel();
		panel_dienTen.setPreferredSize(new Dimension(385, 40));//
		panel_dienThongTin.add(panel_dienTen);
		panel_dienTen.setLayout(new BorderLayout(10, 10));//
		
		Label label_tenNV = new Label("Tên Nhân Viên");
		label_tenNV.setPreferredSize(new Dimension(110, 10));//
		label_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_dienTen.add(label_tenNV, BorderLayout.WEST);//
		
		
		label_tenNV.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		
		panel_dienTen.setBackground(MyColor.BORDER_COLOR);
		

		textField_tenNV = new JTextField();
		textField_tenNV.setColumns(10);
		textField_tenNV.setPreferredSize(new Dimension(50, 17));//
		panel_dienTen.add(textField_tenNV, BorderLayout.CENTER);//
		
		textField_tenNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		Panel panel_ngaySinh = new Panel();
		panel_ngaySinh.setPreferredSize(new Dimension(385, 40));
		panel_dienThongTin.add(panel_ngaySinh);
		panel_ngaySinh.setLayout(new BorderLayout(10, 10));
		
		panel_ngaySinh.setBackground(MyColor.BORDER_COLOR);
		
		Label label_2 = new Label("Ngày Sinh");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setPreferredSize(new Dimension(110, 10));
		panel_ngaySinh.add(label_2, BorderLayout.WEST);
		
		label_2.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		JPanel panel_14 = new JPanel();
		panel_14.setPreferredSize(new Dimension(50, 17));
		panel_ngaySinh.add(panel_14, BorderLayout.CENTER);
		
		panel_14.setBackground(MyColor.BORDER_COLOR);
		panel_14.setLayout(new BorderLayout(5, 5));
		
		JSpinner spinner_ngaysinh = new JSpinner();
		panel_14.add(spinner_ngaysinh, BorderLayout.WEST);
		spinner_ngaysinh.setPreferredSize(new Dimension(50, 10));
		
		spinner_ngaysinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JSpinner spinner_thangSinh = new JSpinner();
		panel_14.add(spinner_thangSinh, BorderLayout.CENTER);
		spinner_thangSinh.setPreferredSize(new Dimension(50, 10));
		
		spinner_thangSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JSpinner spinner_namSinh = new JSpinner();
		panel_14.add(spinner_namSinh, BorderLayout.EAST);
		spinner_namSinh.setPreferredSize(new Dimension(50, 10));
		
		spinner_namSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		Panel panel_gioiTinh = new Panel();
		panel_gioiTinh.setPreferredSize(new Dimension(385, 40));
		panel_dienThongTin.add(panel_gioiTinh, BorderLayout.WEST);
		panel_gioiTinh.setLayout(new BorderLayout(10, 10));
		
		panel_gioiTinh.setBackground(MyColor.BORDER_COLOR);
		
		Label label_3 = new Label("Giới Tính");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setPreferredSize(new Dimension(150, 17));
		panel_gioiTinh.add(label_3, BorderLayout.WEST);
		
		label_3.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		JRadioButton RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nam.setPreferredSize(new Dimension(20, 17));
		panel_gioiTinh.add(RadioButton_Nam, BorderLayout.CENTER);
		
		RadioButton_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_Nam.setBackground(MyColor.BORDER_COLOR);
		
		JRadioButton RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RadioButton_Nu.setPreferredSize(new Dimension(80, 17));
		panel_gioiTinh.add(RadioButton_Nu, BorderLayout.EAST);
		
		RadioButton_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_Nu.setBackground(MyColor.BORDER_COLOR);
		
		JPanel panel_soDT = new JPanel();
		panel_soDT.setPreferredSize(new Dimension(385, 40));
		panel_dienThongTin.add(panel_soDT, BorderLayout.WEST);
		panel_soDT.setLayout(new BorderLayout(10, 10));
		
		panel_soDT.setBackground(MyColor.BORDER_COLOR);
		
		Label label_8 = new Label("Số ĐT");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setPreferredSize(new Dimension(110, 10));
		panel_soDT.add(label_8, BorderLayout.WEST);
		
		label_8.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_soDT = new JTextField();
		textField_soDT.setPreferredSize(new Dimension(50, 17));
		panel_soDT.add(textField_soDT, BorderLayout.CENTER);
		
		textField_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JPanel panel_btn = new JPanel();
		panel_nhap_timKiem_duLieu.add(panel_btn, BorderLayout.CENTER);
		panel_btn.setPreferredSize(new Dimension(150, 250));
		panel_btn.setBackground(MyColor.BORDER_COLOR);
		panel_btn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton themButton = new JButton("Thêm");
		themButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel_btn.add(panel);
		panel.setPreferredSize(new Dimension(140, 30));
		panel.setBackground(MyColor.BORDER_COLOR);
		
		themButton.setPreferredSize(new Dimension(89, 32));
		panel_btn.add(themButton, BorderLayout.CENTER);
		themButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		themButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		JButton xoaButton = new JButton("Xoá");
		xoaButton.setPreferredSize(new Dimension(89, 32));
		xoaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		xoaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_btn.add(xoaButton, BorderLayout.CENTER);
		
		JButton SuaButton = new JButton("Sửa");
		SuaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SuaButton.setPreferredSize(new Dimension(89, 32));
		SuaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		SuaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		panel_btn.add(SuaButton, BorderLayout.CENTER);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		resetButton.setForeground(MyColor.SECOND_TEXT_COLOR);
		resetButton.setPreferredSize(new Dimension(89, 32));
		panel_btn.add(resetButton, BorderLayout.CENTER);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setPreferredSize(new Dimension(250, 250));
		panel_nhap_timKiem_duLieu.add(panel_TimKiem, BorderLayout.EAST);
		panel_TimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_TimKiem.setBackground(MyColor.BORDER_COLOR);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setPreferredSize(new Dimension(250, 110));
		
		panel_TimKiem.add(lblNewLabel, BorderLayout.NORTH);
		
		lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setPreferredSize(new Dimension(200, 25));
		panel_TimKiem.add(textField_timKiem, BorderLayout.CENTER);

		
		textField_timKiem.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
		
		JRadioButton RadioButton_maNV = new JRadioButton("Mã nhân viên");
		RadioButton_maNV.setPreferredSize(new Dimension(100, 50));
		panel_TimKiem.add(RadioButton_maNV);
		
		RadioButton_maNV.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_maNV.setBackground(MyColor.BORDER_COLOR);
		
		JRadioButton RadioButton_tenNV = new JRadioButton("Tên nhân viên");
		RadioButton_tenNV.setPreferredSize(new Dimension(100, 50));
		panel_TimKiem.add(RadioButton_tenNV);
		
		RadioButton_tenNV.setForeground(MyColor.SECOND_TEXT_COLOR);
		
		RadioButton_tenNV.setBackground(MyColor.BORDER_COLOR);
	}

}
