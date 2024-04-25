package GUI;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Custom.MyColor;
import Custom.MyLabel;
import Custom.MyPanel;
import Custom.MyPanelSecond;

public class MainQuanlyGUI extends JFrame {
	private ArrayList<MyLabel> listMenuLeft;
	private CardLayout cardMenuLeftGroup = new CardLayout();
	private MyPanel pnCard;
	
	private QLyBanHangGUI pnBanHang;
	private SanPhamGUI pnSanpham;
	private QuanLyKhachHangGUI pnKhachhang;
	private QuanLyNhanVienGUI pnNhanvien;
	private PhanQuyen_GUI pnPhanQuyen;
	private ThongKeGUI pnThongke;
	private NhapHangGUI pnNhapHang;
	private KhuyenMaiGUI pnKhuyenMai;
	private CongThucGUI pnCongThuc;
	
	private MyLabel panel_logo, lblBanHang, lblKhuyenMai, lblSanPham, lblNhanvien, lblKhachhang, lblNhapHang,
			lblThongKe,lblPhanQuyen;

	private MyLabel lastClickedLabel;
	private MyLabel lblCongThuc;
	public MainQuanlyGUI() {
		this.setTitle("Phần mềm quản lý cửa hàng đồ ăn nhanh");
		this.setSize(1280, 800);
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

		MyPanelSecond Contain_panel_Category = new MyPanelSecond();
		Contain_panel_Category.setLayout(new BorderLayout());
		Contain_panel_Category.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
//		MyPanel pnSpace = new MyPanel();
//		Contain_panel_Category.add(pnSpace, BorderLayout.EAST);
//		MyPanel pnSpace2 = new MyPanel();
//		Contain_panel_Category.add(pnSpace2, BorderLayout.WEST);
		MyPanel panel_Category = new MyPanel();
		Contain_panel_Category.add(panel_Category, BorderLayout.CENTER);
		panel_Category.setBackground(new Color(255, 255, 255));
		pnMain.add(Contain_panel_Category, BorderLayout.WEST);
		panel_Category.setLayout(new BoxLayout(panel_Category, BoxLayout.Y_AXIS));

		// các option cho menu
		panel_logo = new MyLabel("");
		lblBanHang = new MyLabel("  Bán hàng");
		lblBanHang.setOpaque(true);
		lblBanHang.setBackground(MyColor.BACKGROUND_CLICK_COLOR);
		lblBanHang.setForeground(Color.WHITE);

		ImageIcon iconBanHang = new ImageIcon("images/trolley.png");
		Image img = iconBanHang.getImage();
		Image newImg = img.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconBanHang.setImage(newImg);
		lblBanHang.setIcon(iconBanHang);
		
//		lblBanHang.setForeground(MyColor.SECOND_TEXT_COLOR);
		lastClickedLabel = lblBanHang;
		lblKhuyenMai = new MyLabel("  Khuyến mãi");
		ImageIcon iconKhuyenMai = new ImageIcon("images/voucher.png");
		Image img2 = iconKhuyenMai.getImage();
		Image newImg2 = img2.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconKhuyenMai.setImage(newImg2);
		lblKhuyenMai.setIcon(iconKhuyenMai);
		
		lblSanPham = new MyLabel("  Sản phẩm");
		ImageIcon iconSanPham = new ImageIcon("images/fast-food.png");
		Image img3 = iconSanPham.getImage();
		Image newImg3 = img3.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconSanPham.setImage(newImg3);
		lblSanPham.setIcon(iconSanPham);
		
		lblNhanvien = new MyLabel("  Nhân viên");
		ImageIcon iconNhanVien = new ImageIcon("images/staff.png");
		Image img4 = iconNhanVien.getImage();
		Image newImg4 = img4.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconNhanVien.setImage(newImg4);
		lblNhanvien.setIcon(iconNhanVien);
		
		lblKhachhang = new MyLabel("  Khách hàng");
		ImageIcon iconKhachHang = new ImageIcon("images/customer.png");
		Image img5 = iconKhachHang.getImage();
		Image newImg5 = img5.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconKhachHang.setImage(newImg5);
		lblKhachhang.setIcon(iconKhachHang);
		
		lblNhapHang = new MyLabel("  Nhập hàng");
		ImageIcon iconNhapHang = new ImageIcon("images/vegetable.png");
		Image img6 = iconNhapHang.getImage();
		Image newImg6 = img6.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconNhapHang.setImage(newImg6);
		lblNhapHang.setIcon(iconNhapHang);
		
		lblThongKe = new MyLabel("  Thống kê");
		ImageIcon iconThongKe = new ImageIcon("images/analytics.png");
		Image img7 = iconThongKe.getImage();
		Image newImg7 = img7.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconThongKe.setImage(newImg7);
		lblThongKe.setIcon(iconThongKe);
		lblThongKe.addMouseListener(new LabelMouseListener());
		panel_Category.add(lblThongKe);
		
		lblCongThuc = new MyLabel("  Công thức");
		ImageIcon iconCongThuc = new ImageIcon("images/vegetable.png");
		Image img8 = iconNhapHang.getImage();
		Image newImg8 = img8.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconCongThuc.setImage(newImg8);
		lblCongThuc.setIcon(iconCongThuc);
		
		listMenuLeft = new ArrayList<>();
		listMenuLeft.add(panel_logo);
		listMenuLeft.add(lblBanHang);
		listMenuLeft.add(lblSanPham);
		listMenuLeft.add(lblKhuyenMai);
		listMenuLeft.add(lblNhanvien);
		listMenuLeft.add(lblKhachhang);
		listMenuLeft.add(lblNhapHang);
		listMenuLeft.add(lblThongKe);
		listMenuLeft.add(lblCongThuc);
//		listMenuLeft.add(lblPhanQuyen);

		for (MyLabel lbl : listMenuLeft) {
			lbl.addMouseListener(new LabelMouseListener());
			lbl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
		pnKhuyenMai = new KhuyenMaiGUI();
		pnCongThuc = new CongThucGUI();
//		pnPhanQuyen =  new PhanQuyen_GUI();
		
		pnCard.add(pnBanHang, "banhang");
		pnCard.add(pnSanpham, "sanpham");
		pnCard.add(pnKhachhang, "khachhang");
		pnCard.add(pnNhanvien, "nhanvien");
		pnCard.add(pnThongke, "thongke");
		pnCard.add(pnNhapHang, "nhaphang");
		pnCard.add(pnKhuyenMai, "khuyenmai");
		pnCard.add(pnCongThuc, "congthuc");
//		pnCard.add(pnPhanQuyen,"phanquyen");
//		

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
					if (lbl.getBackground() != MyColor.BACKGROUND_CLICK_COLOR) {
		                lbl.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		            }

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (lbl.getBackground() != MyColor.BACKGROUND_CLICK_COLOR) {
		                lbl.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
		            }

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
					} else if (lbl == lblKhuyenMai) {
						cardName = "khuyenmai";
					} else if (lbl == lblCongThuc) {
						cardName = "congthuc";
					}
					lbl.setBackground(MyColor.BACKGROUND_CLICK_COLOR);
					lbl.setForeground(new Color(255, 255, 255));
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
//			label.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
//			label.setForeground(MyColor.SECOND_TEXT_COLOR);

			// Trả lại màu nền của label trước đó (nếu có)
			if (lastClickedLabel != null && lastClickedLabel != label) {
				lastClickedLabel.setBackground(null);
				lastClickedLabel.setForeground(Color.black);
			}

			// Lưu label hiện tại là label được nhấn cuối cùng
			lastClickedLabel = label;

			// Cập nhật lại giao diện người dùng để thấy được sự thay đổi
			label.repaint();
		}
	}
}
