package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Custom.*;

public class NhapHangGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangGUI frame = new NhapHangGUI();
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
	public NhapHangGUI() {
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

}
	}
