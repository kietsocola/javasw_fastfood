package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Custom.*;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

public class NhapHangGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtmKhoHang;
	
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
		
		MyPanelSecond panel_main = new MyPanelSecond();
		contentPane.add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_main.add(tabbedPane, BorderLayout.NORTH);
		
		MyPanelSecond tabNhapHang = new MyPanelSecond();
		tabNhapHang.setPreferredSize(new Dimension(10, 700));
		tabbedPane.addTab("Nhập hàng", null, tabNhapHang, null);
		tabNhapHang.setLayout(new BorderLayout(10, 0));
		
		MyPanel pnChucNang = new MyPanel();
		tabNhapHang.add(pnChucNang, BorderLayout.EAST);
		MyLabel lblTitle = new MyLabel("Quản lý kho hàng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		tabNhapHang.add(lblTitle, BorderLayout.NORTH);
		
		MyPanelSecond pnTblKhoHang = new MyPanelSecond();
		pnTblKhoHang.setPreferredSize(new Dimension(10, 400));
		tabNhapHang.add(pnTblKhoHang, BorderLayout.CENTER);
		tabbedPane.setBackgroundAt(0, MyColor.BACKGROUND_TEXTFIELD_COLOR);
//-------------------------Bảng kho hàng-----------------------------------
		dtmKhoHang = new DefaultTableModel();
		dtmKhoHang.addColumn("Mã SP");
//-------------------------------------------------------------------------
		
		
		MyPanelSecond tabPhieuNhap = new MyPanelSecond();
		tabbedPane.addTab("Xem lại phiếu nhập", null, tabPhieuNhap, null);
		tabbedPane.setBackgroundAt(1, MyColor.BACKGROUND_TEXTFIELD_COLOR);
		

}
	}
