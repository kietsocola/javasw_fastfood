package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Custom.MyPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import BUS.taiKhoan_BUS;
import DTO.taiKhoan_DTO;
public class dangnhap {

	private JFrame frame;
	private JTextField tenDangNhap;
	private JTextField matKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap window = new dangnhap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public dangnhap() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 295, 257);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		MyPanel panel = new MyPanel();
		panel.setBorder(new LineBorder(new Color(255, 128, 255), 3, true));
		panel.setBackground(new Color(31, 29, 43));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 293, 256);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(45, 48, 62));
		panel_1.setBounds(10, 10, 273, 236);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đang nhập");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 157, 20);
		panel_1.add(lblNewLabel);
		
		tenDangNhap = new JTextField();
		tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenDangNhap.setBounds(10, 35, 253, 39);
		panel_1.add(tenDangNhap);
		tenDangNhap.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 97, 82, 20);
		panel_1.add(lblNewLabel_1);
		
		matKhau = new JTextField();
		matKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		matKhau.setBounds(10, 127, 253, 39);
		panel_1.add(matKhau);
		matKhau.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				taiKhoan_DTO account = new taiKhoan_DTO();
				account.setTenTaiKhoan(tenDangNhap.getText());
				account.setMatKhau(matKhau.getText());
				taiKhoan_BUS tk_BUS = new taiKhoan_BUS();
					// TODO Auto-generated catch block\
				try {
					JOptionPane.showMessageDialog(btnNewButton, tk_BUS.checkDangNhap(account),"Thong bao",0);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(148, 188, 115, 21);
		panel_1.add(btnNewButton);
	}
}
