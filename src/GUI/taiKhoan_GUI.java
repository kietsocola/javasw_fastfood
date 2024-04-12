package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import BUS.taiKhoan_BUS;
import DTO.taiKhoan_DTO;

import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DropMode;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class taiKhoan_GUI {

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
					taiKhoan_GUI window = new taiKhoan_GUI();
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
	public taiKhoan_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EmptyBorder border = new EmptyBorder(20, 20, 20, 20);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(300, 200));
		lblNewLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Pictures\\fastfood1.jpg"));
		frame.getContentPane().add(lblNewLabel, BorderLayout.WEST);

		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBorder(border);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel txtNameApp = new JLabel("FOOD AND DRINK");
		txtNameApp.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameApp.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(txtNameApp);
		txtNameApp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelTenDangNhap = new JPanel();
		panelTenDangNhap.setPreferredSize(new Dimension(10, 5));
		panel.add(panelTenDangNhap);
		panelTenDangNhap.setLayout(new BoxLayout(panelTenDangNhap, BoxLayout.X_AXIS));
		panelTenDangNhap.setBorder(new EmptyBorder(15, 20, 20, 20));
		panelTenDangNhap.add(Box.createHorizontalGlue());
		
		JLabel labelDangNhap = new JLabel("Tên đăng nhập:");
		labelDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		labelDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTenDangNhap.add(labelDangNhap);
		
		tenDangNhap = new JTextField();
		tenDangNhap.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		tenDangNhap.setAlignmentX(Component.LEFT_ALIGNMENT);
		tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTenDangNhap.add(tenDangNhap);
		tenDangNhap.setColumns(15);
		panelTenDangNhap.add(Box.createHorizontalGlue());
		
		JPanel panelMatKhau = new JPanel();
		panelMatKhau.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panelMatKhau);
		panelMatKhau.setLayout(new BoxLayout(panelMatKhau, BoxLayout.X_AXIS));
		panelMatKhau.setBorder(new EmptyBorder(15, 20, 20, 20));
		
		JLabel labelMatKhau = new JLabel("Mật Khẩu         :");
		labelMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		labelMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMatKhau.add(labelMatKhau);
		
		matKhau = new JTextField();
		matKhau.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		matKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelMatKhau.add(matKhau);
		matKhau.setColumns(10);
		
		JPanel panelBtnDangNhap = new JPanel();
		panel.add(panelBtnDangNhap);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
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
		panelBtnDangNhap.setLayout(new GridLayout(0, 2, 15, 20));
		panelBtnDangNhap.setBorder(border);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBtnDangNhap.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showOptionDialog(
		                null, // parentComponent, null để hiển thị ở giữa màn hình
		                "Bạn có muốn thoát không?", // message
		                "Xác nhận", // title
		                JOptionPane.YES_NO_CANCEL_OPTION, // optionType
		                JOptionPane.QUESTION_MESSAGE, // messageType
		                null, // icon
		                new String[]{"Yes", "No"}, // options
		                "Yes" // initialValue
		        );

		        // Xử lý lựa chọn
		        switch (choice) {
		            case JOptionPane.YES_OPTION:
		                System.exit(0);
		                break;
		            case JOptionPane.NO_OPTION:
		               frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		                break;
		            default:
		                System.out.println("Bạn đã đóng hộp thoại");
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBtnDangNhap.add(btnNewButton_1);
	}

}
