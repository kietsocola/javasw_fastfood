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
import GUI.MainQuanlyGUI;

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
import javax.swing.border.MatteBorder;

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
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setPreferredSize(new Dimension(700, 200));
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		EmptyBorder border = new EmptyBorder(20, 20, 20, 20);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_1.setPreferredSize(new Dimension(320, 400));
//		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(320, 320));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Pictures\\fd1.jpg"));
		panel_1.add(lblNewLabel);

		
		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel txtNameApp = new JLabel("FOOD AND DRINK");
		txtNameApp.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameApp.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(txtNameApp);
		txtNameApp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelTenDangNhap = new JPanel();
		panelTenDangNhap.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelTenDangNhap.setPreferredSize(new Dimension(10, 5));
		panel.add(panelTenDangNhap);
		panelTenDangNhap.setLayout(new BoxLayout(panelTenDangNhap, BoxLayout.X_AXIS));
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
		panelMatKhau.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelMatKhau.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panelMatKhau);
		panelMatKhau.setLayout(new BoxLayout(panelMatKhau, BoxLayout.X_AXIS));
		
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
					if(tk_BUS.checkDangNhap(account) == 0)
						JOptionPane.showMessageDialog(btnNewButton, "vui long nhap day du thong tin","Thong bao",0);
					else if(tk_BUS.checkDangNhap(account) == 1)
					{
						JOptionPane.showMessageDialog(btnNewButton, "hello","Thong bao",0);
						MainQuanlyGUI main = new MainQuanlyGUI();
						main.showWindow();
						frame.setVisible(false);
					}
					else if(tk_BUS.checkDangNhap(account) == 2)
						JOptionPane.showMessageDialog(btnNewButton, "ten tai khoan hoac mat khau cua ban bi sai","Thong bao",0);
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
		panelBtnDangNhap.setBorder(new EmptyBorder(25, 20, 25, 20));
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.add(panel_1);
		panel_2.add(panel);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
	}

}
