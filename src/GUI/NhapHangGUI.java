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

public class NhapHangGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtmKhoHang;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhapHangGUI frame = new NhapHangGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NhapHangGUI() {
		this.setLayout(new BorderLayout());
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);
		
//		contentPane.add(panel_main, BorderLayout.CENTER);
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