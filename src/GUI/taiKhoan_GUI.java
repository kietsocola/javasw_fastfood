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

import BUS.NhanVien_BUS;
import BUS.phanquyen_BUS;
import BUS.taiKhoan_BUS;
import Custom.MyButton;
import Custom.MyPanel;
import DTO.NhanVien;
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
import java.util.ArrayList;
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
	private MyPanel panel ,panel_2 ,panelTenDangNhap,panelMatKhau,panelBtnDangNhap;
	JPanel panel_1;
	private MyButton btnDangNhap ,btnThoat;
	private taiKhoan_BUS tk_BUS = new taiKhoan_BUS();
	private NhanVien_BUS nv_BUS = new NhanVien_BUS();
	private phanquyen_BUS pq_BUS = new phanquyen_BUS();
	public static int idTaiKhoan ;

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
	public void run(taiKhoan_GUI login) {
		login.frame.setVisible(true);
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
		frame.setLocationRelativeTo(null);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		EmptyBorder border = new EmptyBorder(20, 20, 20, 20);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_1.setPreferredSize(new Dimension(320, 400));
//		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lbImageApp = new JLabel("");
		lbImageApp.setPreferredSize(new Dimension(320, 320));
		lbImageApp.setHorizontalAlignment(SwingConstants.CENTER);
		lbImageApp.setIcon(new ImageIcon("images\\fd1.jpg"));
		panel_1.add(lbImageApp);

		
		panel = new MyPanel();
//		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel txtNameApp = new JLabel("FOOD AND DRINK");
		txtNameApp.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameApp.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(txtNameApp);
		txtNameApp.setFont(new Font("Arial", Font.BOLD, 18));
		
		panelTenDangNhap = new MyPanel();
		panelTenDangNhap.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelTenDangNhap.setPreferredSize(new Dimension(10, 5));
		panel.add(panelTenDangNhap);
		panelTenDangNhap.setLayout(new BoxLayout(panelTenDangNhap, BoxLayout.X_AXIS));
		panelTenDangNhap.add(Box.createHorizontalGlue());
		
		JLabel labelDangNhap = new JLabel("Tên đăng nhập: ");
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
		
		panelMatKhau = new MyPanel();
		panelMatKhau.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelMatKhau.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panelMatKhau);
		panelMatKhau.setLayout(new BoxLayout(panelMatKhau, BoxLayout.X_AXIS));
		
		JLabel labelMatKhau = new JLabel("Mật Khẩu         : ");
		labelMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		labelMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMatKhau.add(labelMatKhau);
		
		matKhau = new JTextField();
		matKhau.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		matKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelMatKhau.add(matKhau);
		matKhau.setColumns(10);
		
		panelBtnDangNhap = new MyPanel();
		panel.add(panelBtnDangNhap);
		
		btnDangNhap = new MyButton("Đăng nhập");
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				taiKhoan_DTO account = new taiKhoan_DTO();
				account.setTenTaiKhoan(tenDangNhap.getText());
				account.setMatKhau(matKhau.getText());
					// TODO Auto-generated catch block\
				try {
					if(tk_BUS.checkDangNhap(account) == 0)
						JOptionPane.showMessageDialog(null, "vui long nhap day du thong tin","Thong bao",0);
					else if(tk_BUS.checkDangNhap(account) == 1)
					{	
						int idPhanQuyen = tk_BUS.IdPhanQuyen(account);
						ArrayList<Boolean> PhanQuyen = pq_BUS.loaiPhanQuyen(idPhanQuyen);
//						for(boolean x : PhanQuyen)
//							System.out.print(x + " la quyen cua tai khoan \n");
						idTaiKhoan = tk_BUS.idTaiKhoan(account);
						String TenNhanVien = nv_BUS.getTenNhanVien(idTaiKhoan);
						JOptionPane.showMessageDialog(null, "Xin Chào " + TenNhanVien,"Thong bao",JOptionPane.INFORMATION_MESSAGE);

						MainQuanlyGUI main = new MainQuanlyGUI(PhanQuyen);
						main.showWindow();
						frame.setVisible(false);
					}
					else if(tk_BUS.checkDangNhap(account) == 2)
						JOptionPane.showMessageDialog(null, "ten tai khoan hoac mat khau cua ban bi sai","Thong bao",1);
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
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBtnDangNhap.add(btnDangNhap);
		
		btnThoat = new MyButton("Thoát");
		btnThoat.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int choice = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

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
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBtnDangNhap.add(btnThoat);
		
		panel_2 = new MyPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		panel_2.add(panel_1);
		panel_2.add(panel);
		frame.getContentPane().add(panel_2);
	}

}
