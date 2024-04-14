package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Custom.MyColor;
import Custom.MyLabel;
import Custom.MyPanel;

public class MainQuanlyGUI extends JFrame {
	private ArrayList<MyLabel> listMenuLeft;
	private CardLayout cardMenuLeftGroup = new CardLayout();
	private MyPanel pnCard;
	
	private QLyBanHangGUI pnBanHang;
	private SanPhamGUI pnSanpham;
	private QuanLyKhachHangGUI pnKhachhang;
	private QuanLyNhanVienGUI pnNhanvien;
	private ThongKeGUI pnThongke;
	private NhapHangGUI pnNhapHang;
	
	private MyLabel panel_logo, lblBanHang, lblKhuyenMai, lblSanPham, lblNhanvien, lblKhachhang, lblNhapHang,
			lblThongKe;

	private MyLabel lastClickedLabel;
	public MainQuanlyGUI() {
		this.setTitle("Phần mềm quản lý cửa hàng pizza");
		this.setSize(1280, 900);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		Container con = getContentPane();

		MyPanel pnMain = new MyPanel();
		pnMain.setLayout(new BorderLayout());

		MyPanel panel_Category = new MyPanel();
		pnMain.add(panel_Category, BorderLayout.WEST);
		panel_Category.setLayout(new BoxLayout(panel_Category, BoxLayout.Y_AXIS));

		// các option cho menu
		panel_logo = new MyLabel("");
		lblBanHang = new MyLabel("Bán hàng");
		lblBanHang.setOpaque(true);
		lblBanHang.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
		lblBanHang.setForeground(MyColor.SECOND_TEXT_COLOR);
		lastClickedLabel = lblBanHang;
		lblKhuyenMai = new MyLabel("Khuyến mãi");
		lblSanPham = new MyLabel("Sản phẩm");
		lblNhanvien = new MyLabel("Nhân viên");
		lblKhachhang = new MyLabel("Khách hàng");
		lblNhapHang = new MyLabel("Nhập hàng");
		lblThongKe = new MyLabel("Thống kê");
//		lblThongKe.addMouseListener(new LabelMouseListener());
//		panel_Category.add(lblThongKe);
		listMenuLeft = new ArrayList<>();
		listMenuLeft.add(panel_logo);
		listMenuLeft.add(lblBanHang);
		listMenuLeft.add(lblSanPham);
		listMenuLeft.add(lblKhuyenMai);
		listMenuLeft.add(lblNhanvien);
		listMenuLeft.add(lblKhachhang);
		listMenuLeft.add(lblNhapHang);
		listMenuLeft.add(lblThongKe);

		for (MyLabel lbl : listMenuLeft) {
			lbl.addMouseListener(new LabelMouseListener());
			panel_Category.add(lbl);
		}

		/*
		 * ============================================================ CARD PANEL
		 * ============================================================
		 */

		pnCard = new MyPanel(cardMenuLeftGroup);
		
		pnBanHang = new QLyBanHangGUI();
		pnSanpham = new SanPhamGUI();
		pnKhachhang = new QuanLyKhachHangGUI();
		pnNhanvien = new QuanLyNhanVienGUI();
		pnThongke = new ThongKeGUI();
		pnNhapHang= new NhapHangGUI();
		
		pnCard.add(pnBanHang, "banhang");
		pnCard.add(pnSanpham, "sanpham");
		pnCard.add(pnKhachhang, "khachhang");
		pnCard.add(pnNhanvien, "nhanvien");
		pnCard.add(pnThongke, "thongke");
		pnCard.add(pnNhapHang, "nhaphang");

		pnMain.add(pnCard, BorderLayout.CENTER);
		
		con.add(pnMain);
	}

	private void addEvents() {
		for (MyLabel lbl : listMenuLeft) {
			lbl.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					String cardName = "";
					if (lbl == lblBanHang) {
						cardName = "banhang";
					} else if (lbl == lblSanPham) {
						cardName = "sanpham";
					} else if (lbl == lblKhachhang) {
						cardName = "khachhang";
					} else if (lbl == lblNhanvien) {
						cardName = "nhanvien";
					} else if (lbl == lblThongKe) {
						cardName = "thongke";
					} else if (lbl == lblNhapHang) {
						cardName = "nhaphang";
					}
					cardMenuLeftGroup.show(pnCard, cardName);
				}
			});
		}

	}

	class LabelMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			MyLabel label = (MyLabel) e.getSource();
			// Đặt màu nền của label được nhấn vào
			label.setOpaque(true);
			label.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
			label.setForeground(MyColor.SECOND_TEXT_COLOR);

			// Trả lại màu nền của label trước đó (nếu có)
			if (lastClickedLabel != null && lastClickedLabel != label) {
				lastClickedLabel.setBackground(null);
				lastClickedLabel.setForeground(MyColor.PRIMARY_TEXT_COLOR);
			}

			// Lưu label hiện tại là label được nhấn cuối cùng
			lastClickedLabel = label;

			// Cập nhật lại giao diện người dùng để thấy được sự thay đổi
			label.repaint();
		}
	}
}
