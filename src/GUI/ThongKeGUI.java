package GUI;

import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import BUS.ThongKeBUS;
import Custom.MyPanelSecond;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.SanPham;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class ThongKeGUI extends JPanel {
	private JFrame frame;
	private CardLayout cardLayout;
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private JButton btnLoc;
	private JTable jTable;
	private JPanel panel_47;
	private JPanel panel_48;
	private JComboBox<String> comboBoxLoaiSP;
	ThongKeBUS thongKeBUS = new ThongKeBUS();
	private ArrayList<SanPham> listSanPham;
	private HashMap<Integer, Integer> idQuantityMap;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongKeGUI window = new ThongKeGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ThongKeGUI() {
		initialize();
		showAllSanPham();
	}

	private void initialize() {
		idQuantityMap = new HashMap<>();
		// Tạo một JPanel chứa BorderLayout
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setLayout(new BorderLayout());
		this.add(mainPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 40, 54));
		mainPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(37, 40, 54));
		panel_1.setPreferredSize(new Dimension(104, 24));
		panel.add(panel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(24, 24));
		panel_2.setBackground(new Color(37, 40, 54));
		panel.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(24, 24));
		panel_3.setBackground(new Color(37, 40, 54));
		panel.add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(24, 24));
		panel_4.setBackground(new Color(37, 40, 54));
		panel.add(panel_4, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(37, 40, 54));
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(10, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(37, 40, 54));
		panel_6.setPreferredSize(new Dimension(372, 80));
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(24, 24));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(37, 40, 54));
		panel_7.setPreferredSize(new Dimension(372, 80));
		panel_6.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new BorderLayout(0, 24));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setPreferredSize(new Dimension(372, 426));
		panel_7.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.BLACK);
		panel_15.setPreferredSize(new Dimension(24, 24));
		panel_9.add(panel_15, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.BLACK);
		panel_16.setPreferredSize(new Dimension(24, 24));
		panel_9.add(panel_16, BorderLayout.WEST);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.BLACK);
		panel_24.setPreferredSize(new Dimension(24, 24));
		panel_9.add(panel_24, BorderLayout.SOUTH);

		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.BLACK);
		panel_25.setPreferredSize(new Dimension(24, 24));
		panel_9.add(panel_25, BorderLayout.EAST);

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(0, 0, 0));
		panel_9.add(panel_30, BorderLayout.CENTER);
		panel_30.setLayout(new BorderLayout(0, 0));

		JPanel panel_31 = new JPanel();
		panel_31.setBackground(new Color(0, 0, 0));
		panel_31.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(57, 60, 73)));
		panel_31.setPreferredSize(new Dimension(65, 65));
		panel_30.add(panel_31, BorderLayout.NORTH);
		panel_31.setLayout(new BorderLayout(0, 0));

		JPanel panel_32 = new JPanel();
		panel_32.setBackground(new Color(0, 0, 0));
		panel_32.setForeground(new Color(37, 40, 54));
		panel_32.setPreferredSize(new Dimension(45, 45));
		panel_31.add(panel_32, BorderLayout.NORTH);
		panel_32.setLayout(new BorderLayout(0, 0));

		JPanel panel_33 = new JPanel();
		panel_33.setBackground(new Color(0, 0, 0));
		FlowLayout flowLayout_2 = (FlowLayout) panel_33.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setVgap(0);
		flowLayout_2.setAlignment(FlowLayout.TRAILING);
		panel_32.add(panel_33, BorderLayout.WEST);

		JLabel lblNewLabel_4 = new JLabel("Most Ordered");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setPreferredSize(new Dimension(150, 45));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_33.add(lblNewLabel_4);

		JPanel panel_34 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_34.getLayout();
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		panel_32.add(panel_34, BorderLayout.EAST);

		JButton btnNewButton = new JButton("Today");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("D:\\Downloads\\Mask.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setPreferredSize(new Dimension(95, 45));
		panel_34.add(btnNewButton);

		JPanel panel_35 = new JPanel();
		panel_35.setBackground(new Color(0, 0, 0));
		panel_35.setPreferredSize(new Dimension(95, 48));
		panel_30.add(panel_35, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("View All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(234, 124, 105));
		btnNewButton_1.setBackground(new Color(37, 40, 54));
		btnNewButton_1.setPreferredSize(new Dimension(324, 40));
		panel_35.add(btnNewButton_1);

		JPanel panel_36 = new JPanel();
		panel_30.add(panel_36, BorderLayout.CENTER);
		panel_36.setLayout(new BorderLayout(0, 0));

		JPanel panel_37 = new JPanel();
		panel_37.setBackground(new Color(0, 0, 0));
		panel_37.setPreferredSize(new Dimension(200, 233));
		panel_36.add(panel_37, BorderLayout.CENTER);
		panel_37.setLayout(new GridLayout(3, 0, 20, 20));

		JPanel panel_39 = new JPanel();
		panel_39.setBackground(new Color(0, 0, 0));
		panel_37.add(panel_39);
		panel_39.setLayout(new BorderLayout(16, 16));

		JPanel panel_42 = new JPanel();
		panel_42.setBackground(new Color(0, 0, 0));
		FlowLayout flowLayout_4 = (FlowLayout) panel_42.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		panel_42.setPreferredSize(new Dimension(62, 233));
		panel_39.add(panel_42, BorderLayout.WEST);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setPreferredSize(new Dimension(62, 60));
		lblNewLabel_6.setIcon(new ImageIcon("D:\\Downloads\\image 4.png"));
		panel_42.add(lblNewLabel_6);

		JPanel panel_43 = new JPanel();
		panel_43.setBackground(new Color(0, 0, 0));
		panel_43.setPreferredSize(new Dimension(250, 233));
		panel_39.add(panel_43, BorderLayout.EAST);
		panel_43.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_43.add(lblNewLabel_7, BorderLayout.NORTH);

		JLabel lblNewLabel_8 = new JLabel("200 dishes ordered");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setPreferredSize(new Dimension(30, 55));
		lblNewLabel_8.setForeground(new Color(192, 192, 192));
		panel_43.add(lblNewLabel_8, BorderLayout.SOUTH);

		JPanel panel_39_1 = new JPanel();
		panel_39_1.setBackground(new Color(0, 0, 0));
		panel_37.add(panel_39_1);
		panel_39_1.setLayout(new BorderLayout(16, 16));

		JPanel panel_42_1 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_42_1.getLayout();
		flowLayout_6.setVgap(0);
		flowLayout_6.setHgap(0);
		panel_42_1.setPreferredSize(new Dimension(62, 233));
		panel_42_1.setBackground(Color.BLACK);
		panel_39_1.add(panel_42_1, BorderLayout.WEST);

		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon("D:\\Downloads\\image 1.png"));
		lblNewLabel_6_1.setPreferredSize(new Dimension(62, 60));
		lblNewLabel_6_1.setBackground(Color.BLACK);
		panel_42_1.add(lblNewLabel_6_1);

		JPanel panel_43_1 = new JPanel();
		panel_43_1.setPreferredSize(new Dimension(250, 233));
		panel_43_1.setBackground(Color.BLACK);
		panel_39_1.add(panel_43_1, BorderLayout.EAST);
		panel_43_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7_1 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_43_1.add(lblNewLabel_7_1, BorderLayout.NORTH);

		JLabel lblNewLabel_8_1 = new JLabel("200 dishes ordered");
		lblNewLabel_8_1.setPreferredSize(new Dimension(30, 55));
		lblNewLabel_8_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_43_1.add(lblNewLabel_8_1, BorderLayout.CENTER);

		JPanel panel_39_1_1 = new JPanel();
		panel_39_1_1.setBackground(new Color(0, 0, 0));
		panel_37.add(panel_39_1_1);
		panel_39_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_42_1_1 = new JPanel();
		panel_42_1_1.setBackground(new Color(0, 0, 0));
		FlowLayout flowLayout_5 = (FlowLayout) panel_42_1_1.getLayout();
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		panel_42_1_1.setPreferredSize(new Dimension(62, 233));
		panel_39_1_1.add(panel_42_1_1, BorderLayout.WEST);

		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setIcon(new ImageIcon("D:\\Downloads\\image 2.png"));
		lblNewLabel_6_1_1.setPreferredSize(new Dimension(62, 60));
		lblNewLabel_6_1_1.setBackground(Color.BLACK);
		panel_42_1_1.add(lblNewLabel_6_1_1);

		JPanel panel_43_1_1 = new JPanel();
		panel_43_1_1.setPreferredSize(new Dimension(250, 233));
		panel_43_1_1.setBackground(Color.BLACK);
		panel_39_1_1.add(panel_43_1_1, BorderLayout.EAST);
		panel_43_1_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7_1_1 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_43_1_1.add(lblNewLabel_7_1_1, BorderLayout.NORTH);

		JLabel lblNewLabel_8_1_1 = new JLabel("200 dishes ordered");
		lblNewLabel_8_1_1.setPreferredSize(new Dimension(30, 55));
		lblNewLabel_8_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_43_1_1.add(lblNewLabel_8_1_1, BorderLayout.CENTER);

		JPanel panel_38 = new JPanel();
		panel_38.setBackground(new Color(0, 0, 0));
		panel_38.setPreferredSize(new Dimension(372, 20));
		panel_36.add(panel_38, BorderLayout.NORTH);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.BLACK);
		panel_10.setPreferredSize(new Dimension(372, 333));
		panel_7.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.BLACK);
		panel_26.setPreferredSize(new Dimension(24, 24));
		panel_10.add(panel_26, BorderLayout.NORTH);

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.BLACK);
		panel_27.setPreferredSize(new Dimension(24, 24));
		panel_10.add(panel_27, BorderLayout.WEST);

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.BLACK);
		panel_28.setPreferredSize(new Dimension(24, 24));
		panel_10.add(panel_28, BorderLayout.SOUTH);

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(Color.BLACK);
		panel_29.setPreferredSize(new Dimension(24, 24));
		panel_10.add(panel_29, BorderLayout.EAST);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(37, 40, 54));
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(24, 24));

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(57, 60, 73)));
		panel_11.setBackground(new Color(37, 40, 54));
		panel_11.setPreferredSize(new Dimension(646, 60));
		panel_8.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		panel_11.add(lblNewLabel_1, BorderLayout.NORTH);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));

		JLabel lblNewLabel_2_1 = new JLabel("Tuesday 2 Feb, 2021");
		panel_11.add(lblNewLabel_2_1, BorderLayout.SOUTH);
		lblNewLabel_2_1.setPreferredSize(new Dimension(300, 30));
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(37, 40, 54));
		panel_12.setPreferredSize(new Dimension(200, 500));
		panel_8.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_41 = new JPanel();
		panel_41.setBackground(new Color(37, 40, 54));
		panel_41.setPreferredSize(new Dimension(104, 40));
		panel_12.add(panel_41, BorderLayout.NORTH);

		cardLayout = new CardLayout();
		JPanel panel_40 = new JPanel(cardLayout);
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel_12.add(panel_40, BorderLayout.CENTER);

		// Thêm các panel vào panel_2
		JPanel panel2_1 = new JPanel();
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel2_1.setBackground(new Color(37, 40, 54));
		panel_40.add(panel2_1, "Panel 2-1");
		panel2_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_44 = new JPanel();
		panel_44.setBackground(new Color(37, 40, 54));
		panel2_1.add(panel_44, BorderLayout.NORTH);

		JPanel panel_45 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_45.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		panel_45.setBackground(new Color(37, 40, 54));
		panel2_1.add(panel_45, BorderLayout.CENTER);

		JPanel panel2_2 = new JPanel();
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel2_2.setBackground(new Color(37, 40, 54));
		panel_40.add(panel2_2, "Panel 2-2");
		panel2_2.setLayout(new BorderLayout(10, 5));

		JPanel panel_46 = new JPanel();
		panel_46.setPreferredSize(new Dimension(200, 40));
		panel_46.setBackground(new Color(37, 40, 54));
		panel2_2.add(panel_46, BorderLayout.NORTH);

		panel_47 = new JPanel();
		panel2_2.add(panel_47, BorderLayout.CENTER);

		comboBoxLoaiSP = new JComboBox<>();
		comboBoxLoaiSP.addItem("Tất cả"); // Thêm mục "Tất cả"
		// Lấy danh sách tên loại sản phẩm từ database và thêm vào comboBoxLoaiSP
		ArrayList<String> listTenLoaiSP = thongKeBUS.getListTenLoaiSP();
		for (String tenLoaiSP : listTenLoaiSP) {
			comboBoxLoaiSP.addItem(tenLoaiSP);
		}

		panel_46.add(comboBoxLoaiSP);

		// Thêm các thành phần UI vào panel_3
		startDateChooser = new JDateChooser();
		startDateChooser.setBackground(new Color(0, 0, 0));
		startDateChooser.setPreferredSize(new Dimension(120, 30));
		startDateChooser.setForeground(Color.BLUE); // Thiết lập màu chữ
		startDateChooser.setFont(new Font("Arial", Font.BOLD, 14)); // Thiết lập font chữ

		panel_46.add(startDateChooser);

		endDateChooser = new JDateChooser();
		endDateChooser.setBackground(new Color(0, 0, 0));
		endDateChooser.setPreferredSize(new Dimension(120, 30));
		panel_46.add(endDateChooser);

		btnLoc = new JButton("Lọc");
		panel_46.add(btnLoc);
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy loại sản phẩm được chọn từ comboBox
				String selectedCategory = (String) comboBoxLoaiSP.getSelectedItem();

				// Lấy ngày bắt đầu và kết thúc từ JDateChooser
				java.util.Date utilStartDate = startDateChooser.getDate();
				java.util.Date utilEndDate = endDateChooser.getDate();

				// Kiểm tra xem ngày bắt đầu và kết thúc có null không
				if (utilStartDate == null || utilEndDate == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn cả ngày bắt đầu và kết thúc.", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Giảm đi một ngày từ ngày bắt đầu
				Calendar calendarStart = Calendar.getInstance();
				calendarStart.setTime(utilStartDate);
				calendarStart.add(Calendar.DAY_OF_MONTH, -1);
				java.util.Date modifiedStartDate = calendarStart.getTime();

				// Chuyển đổi sang kiểu java.sql.Date
				java.sql.Date startDate = new java.sql.Date(modifiedStartDate.getTime());
				java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());

				if (selectedCategory.equals("Tất cả")) {

					ArrayList<SanPham> filteredSanPhamList = thongKeBUS.getSanPhamByDate(startDate, endDate);
					displaySanPham(filteredSanPhamList, startDate, endDate);

				} else {

					ArrayList<SanPham> filteredSanPhamList = thongKeBUS.getSanPhamByDateAndCategory(selectedCategory,
							startDate, endDate);
					displaySanPham(filteredSanPhamList, startDate, endDate);
					displaySanPham5(filteredSanPhamList, startDate, endDate);
				}
			}
		});
		comboBoxLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy loại sản phẩm được chọn từ comboBox
				String selectedCategory = (String) comboBoxLoaiSP.getSelectedItem();

				// Kiểm tra xem đã chọn ngày bắt đầu và kết thúc chưa
				if (startDateChooser.getDate() == null || endDateChooser.getDate() == null) {
					// Nếu không có ngày được chọn, hiển thị tất cả sản phẩm hoặc theo loại sản phẩm
					if (selectedCategory.equals("Tất cả")) {
						showAllSanPham();
					} else {
						showSanPhamByLoaiSP(selectedCategory);
					}
				} else {
					// Nếu đã chọn ngày bắt đầu và kết thúc, thực hiện tìm kiếm sản phẩm theo ngày
					// và loại sản phẩm
					// Lấy ngày bắt đầu và kết thúc từ JDateChooser
					java.util.Date utilStartDate = startDateChooser.getDate();
					java.util.Date utilEndDate = endDateChooser.getDate();

					// Giảm đi một ngày từ ngày bắt đầu
					Calendar calendarStart = Calendar.getInstance();
					calendarStart.setTime(utilStartDate);
					calendarStart.add(Calendar.DAY_OF_MONTH, -1);
					java.util.Date modifiedStartDate = calendarStart.getTime();

					// Chuyển đổi sang kiểu java.sql.Date
					java.sql.Date startDate = new java.sql.Date(modifiedStartDate.getTime());
					java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());

					// Gọi phương thức của BUS để lấy danh sách sản phẩm dựa trên ngày và loại sản
					// phẩm được chọn

					if (selectedCategory.equals("Tất cả")) {
						ArrayList<SanPham> filteredSanPhamList = thongKeBUS.getSanPhamByDate(startDate, endDate);

						// Hiển thị danh sách sản phẩm lấy được lên JTable
						displaySanPham(filteredSanPhamList, startDate, endDate);
						displaySanPham5(filteredSanPhamList, startDate, endDate);
					} else {
						ArrayList<SanPham> filteredSanPhamList = thongKeBUS
								.getSanPhamByDateAndCategory(selectedCategory, startDate, endDate);

						// Hiển thị danh sách sản phẩm lấy được lên JTable
						displaySanPham(filteredSanPhamList, startDate, endDate);
						displaySanPham5(filteredSanPhamList, startDate, endDate);
					}
				}
			}
		});

		panel_46.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_48 = new JPanel();
		panel_48.setPreferredSize(new Dimension(324, 200));
		panel_48.setLayout(new BorderLayout());
		panel2_2.add(panel_48, BorderLayout.SOUTH);

		JButton btnPanel2 = new JButton("Bảng");
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_40, "Panel 2-2");
			}
		});

		JButton btnPanel1 = new JButton("Biểu đồ");
		btnPanel1.setForeground(new Color(234, 124, 105));
		btnPanel1.setBackground(new Color(37, 40, 54));
		btnPanel1.setPreferredSize(new Dimension(324, 40));
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_40, "Panel 2-1");
			}
		});
		panel_41.setLayout(new GridLayout(0, 6, 15, 15));
		panel_41.add(btnPanel1);
		panel_41.add(btnPanel2);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(37, 40, 54));
		panel_13.setPreferredSize(new Dimension(104, 145));
		panel_8.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new GridLayout(0, 3, 24, 24));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(16, 16));
		panel_17.setBackground(new Color(37, 40, 54));
		panel_14.add(panel_17, BorderLayout.WEST);

		JPanel panel_18 = new JPanel();
		panel_18.setPreferredSize(new Dimension(16, 16));
		panel_18.setBackground(new Color(37, 40, 54));
		panel_14.add(panel_18, BorderLayout.NORTH);

		JPanel panel_19 = new JPanel();
		panel_19.setPreferredSize(new Dimension(16, 16));
		panel_19.setBackground(new Color(37, 40, 54));
		panel_14.add(panel_19, BorderLayout.EAST);

		JPanel panel_20 = new JPanel();
		panel_20.setPreferredSize(new Dimension(16, 16));
		panel_20.setBackground(new Color(37, 40, 54));
		panel_14.add(panel_20, BorderLayout.SOUTH);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(37, 40, 54));
		panel_14.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout(8, 8));

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(37, 40, 54));
		FlowLayout flowLayout_1 = (FlowLayout) panel_22.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(0);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_22.setPreferredSize(new Dimension(16, 38));
		panel_21.add(panel_22, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(38, 38));
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\Coinxxxx.png"));
		panel_22.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("+32.40%");
		lblNewLabel_2.setForeground(new Color(80, 209, 170));
		panel_22.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(18, 18));
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\arrow.png"));
		panel_22.add(lblNewLabel_3);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(37, 40, 54));
		panel_21.add(panel_23, BorderLayout.CENTER);
		panel_23.setLayout(new BorderLayout(0, 8));

		JLabel lblNewLabel_1_1_1_2 = new JLabel("$10,243.00");
		lblNewLabel_1_1_1_2.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_2.setBackground(new Color(37, 40, 54));
		panel_23.add(lblNewLabel_1_1_1_2, BorderLayout.NORTH);

		JLabel lblNewLabel_4_1_2 = new JLabel("Total Revenue");
		lblNewLabel_4_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23.add(lblNewLabel_4_1_2, BorderLayout.CENTER);

		JPanel panel_14_1 = new JPanel();
		panel_13.add(panel_14_1);
		panel_14_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_17_1 = new JPanel();
		panel_17_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1.setBackground(new Color(37, 40, 54));
		panel_14_1.add(panel_17_1, BorderLayout.NORTH);

		JPanel panel_17_2 = new JPanel();
		panel_17_2.setPreferredSize(new Dimension(16, 16));
		panel_17_2.setBackground(new Color(37, 40, 54));
		panel_14_1.add(panel_17_2, BorderLayout.WEST);

		JPanel panel_19_1 = new JPanel();
		panel_19_1.setPreferredSize(new Dimension(16, 16));
		panel_19_1.setBackground(new Color(37, 40, 54));
		panel_14_1.add(panel_19_1, BorderLayout.EAST);

		JPanel panel_20_1 = new JPanel();
		panel_20_1.setPreferredSize(new Dimension(16, 16));
		panel_20_1.setBackground(new Color(37, 40, 54));
		panel_14_1.add(panel_20_1, BorderLayout.SOUTH);

		JPanel panel_21_1 = new JPanel();
		panel_21_1.setBackground(new Color(37, 40, 54));
		panel_14_1.add(panel_21_1, BorderLayout.CENTER);
		panel_21_1.setLayout(new BorderLayout(8, 8));

		JPanel panel_22_1 = new JPanel();
		panel_22_1.setPreferredSize(new Dimension(16, 38));
		panel_22_1.setBackground(new Color(37, 40, 54));
		panel_21_1.add(panel_22_1, BorderLayout.NORTH);
		panel_22_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Downloads\\Order.png"));
		lblNewLabel_5.setPreferredSize(new Dimension(38, 38));
		panel_22_1.add(lblNewLabel_5);

		JLabel lblNewLabel_2_2 = new JLabel("-12.40%");
		lblNewLabel_2_2.setForeground(new Color(255, 124, 163));
		panel_22_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("D:\\Downloads\\arrow-downas.png"));
		lblNewLabel_3_1.setPreferredSize(new Dimension(18, 18));
		panel_22_1.add(lblNewLabel_3_1);

		JPanel panel_23_1 = new JPanel();
		panel_23_1.setBackground(new Color(37, 40, 54));
		panel_21_1.add(panel_23_1, BorderLayout.CENTER);
		panel_23_1.setLayout(new BorderLayout(0, 8));

		JLabel lblNewLabel_1_1_1 = new JLabel("23,456");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1.setBackground(new Color(37, 40, 54));
		panel_23_1.add(lblNewLabel_1_1_1, BorderLayout.NORTH);

		JLabel lblNewLabel_4_1 = new JLabel("Total Dish Ordered");
		lblNewLabel_4_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23_1.add(lblNewLabel_4_1, BorderLayout.CENTER);

		JPanel panel_14_1_1 = new JPanel();
		panel_13.add(panel_14_1_1);
		panel_14_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_17_1_1 = new JPanel();
		panel_17_1_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1_1.setBackground(new Color(37, 40, 54));
		panel_14_1_1.add(panel_17_1_1, BorderLayout.NORTH);

		JPanel panel_17_2_1 = new JPanel();
		panel_17_2_1.setPreferredSize(new Dimension(16, 16));
		panel_17_2_1.setBackground(new Color(37, 40, 54));
		panel_14_1_1.add(panel_17_2_1, BorderLayout.WEST);

		JPanel panel_19_1_1 = new JPanel();
		panel_19_1_1.setPreferredSize(new Dimension(16, 16));
		panel_19_1_1.setBackground(new Color(37, 40, 54));
		panel_14_1_1.add(panel_19_1_1, BorderLayout.EAST);

		JPanel panel_20_1_1 = new JPanel();
		panel_20_1_1.setPreferredSize(new Dimension(16, 16));
		panel_20_1_1.setBackground(new Color(37, 40, 54));
		panel_14_1_1.add(panel_20_1_1, BorderLayout.SOUTH);

		JPanel panel_21_1_1 = new JPanel();
		panel_21_1_1.setBackground(new Color(37, 40, 54));
		panel_14_1_1.add(panel_21_1_1, BorderLayout.CENTER);
		panel_21_1_1.setLayout(new BorderLayout(8, 8));

		JPanel panel_22_1_1 = new JPanel();
		panel_22_1_1.setPreferredSize(new Dimension(16, 38));
		panel_22_1_1.setBackground(new Color(37, 40, 54));
		panel_21_1_1.add(panel_22_1_1, BorderLayout.NORTH);
		panel_22_1_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("D:\\Downloads\\Customer.svg"));
		lblNewLabel_5_1.setPreferredSize(new Dimension(38, 38));
		panel_22_1_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_2_2_1 = new JLabel("+2.40%");
		lblNewLabel_2_2_1.setForeground(new Color(80, 209, 170));
		panel_22_1_1.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon("D:\\Downloads\\arrow.png"));
		lblNewLabel_3_1_1.setPreferredSize(new Dimension(18, 18));
		panel_22_1_1.add(lblNewLabel_3_1_1);

		JPanel panel_23_1_1 = new JPanel();
		panel_23_1_1.setBackground(new Color(37, 40, 54));
		panel_21_1_1.add(panel_23_1_1, BorderLayout.CENTER);
		panel_23_1_1.setLayout(new BorderLayout(0, 8));

		JLabel lblNewLabel_1_1_1_1 = new JLabel("1,234");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_1.setBackground(new Color(37, 40, 54));
		panel_23_1_1.add(lblNewLabel_1_1_1_1, BorderLayout.NORTH);

		JLabel lblNewLabel_4_1_1 = new JLabel("Total Customer");
		lblNewLabel_4_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23_1_1.add(lblNewLabel_4_1_1, BorderLayout.CENTER);

		// Tạo JPanel ở vị trí West
//		JPanel panelWest = new JPanel();
//		mainPanel.add(panelWest, BorderLayout.WEST);
//		panelWest.setPreferredSize(new Dimension(104, 80));
//		panelWest.setBackground(Color.BLACK);

		// Đặt JFrame ở giữa màn hình
//		frame.setLocationRelativeTo(null);
	}

	// Renderer tùy chỉnh cho tiêu đề cột
	private class CustomHeaderRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			label.setBackground(new Color(37, 40, 54));
			label.setForeground(Color.WHITE);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			return label;
		}
	}

	// Renderer tùy chỉnh cho ô dữ liệu
	private class CustomCellRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			label.setBackground(new Color(37, 40, 54));
			label.setForeground(Color.WHITE);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			return label;
		}
	}

	// Hiển thị tất cả sản phẩm
	private void showAllSanPham() {
		listSanPham = thongKeBUS.getAllSanPham();
		displaySanPham(listSanPham);
		displaySanPham5(listSanPham);

	}

	private void showSanPhamByLoaiSP(String loaiSP) {
		listSanPham = thongKeBUS.getSanPhamByLoaiSP(loaiSP);
		displaySanPham(listSanPham);
		displaySanPham5(listSanPham);
	}

	public ArrayList<Object[]> displaySanPhamOnTable(ArrayList<SanPham> listSanPham) {
		ArrayList<Object[]> rowDataList = new ArrayList<>();
		for (SanPham sp : listSanPham) {
			ArrayList<ChiTietHoaDon> listChiTietHoaDon = thongKeBUS.getChiTietHoaDonBySanPham(sp.getId());
			for (ChiTietHoaDon cthd : listChiTietHoaDon) {
				HoaDon hd = thongKeBUS.getHoaDonById(cthd.getIdHoaDon());
				Object[] rowData = { sp.getId(), sp.getTenSP(), sp.getDonGia(), cthd.getSoLuong(), cthd.getThanhTien(),
						sp.getHinhAnh(), hd.getNgayLap() };
				rowDataList.add(rowData);
			}
		}
		return rowDataList;
	}

	public void displaySanPham(ArrayList<SanPham> listSanPham) {
		// Gọi phương thức để lấy dữ liệu từ displaySanPham
		ArrayList<Object[]> rowDataList = displaySanPhamOnTable(listSanPham);

		// Tạo lại model cho JTable với dữ liệu mới
		String[] columnNames = { "ID", "Tên sản phẩm", "Đơn giá", "Số lượng sản phẩm", "Thành tiền sản phẩm",
				"Hình ảnh", "Ngày hóa đơn" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Object[] rowData : rowDataList) {
			model.addRow(rowData);
		}
		jTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(jTable);

		panel_47.removeAll();
		panel_47.setLayout(new BorderLayout());
		panel_47.add(scrollPane, BorderLayout.CENTER);

		panel_47.revalidate();
		panel_47.repaint();
	}

	public ArrayList<Object[]> displaySanPhamOnTable(ArrayList<SanPham> listSanPham, Date startDate, Date endDate) {
		ArrayList<Object[]> rowDataList = new ArrayList<>();
		for (SanPham sp : listSanPham) {
			ArrayList<ChiTietHoaDon> listChiTietHoaDon = thongKeBUS.getChiTietHoaDonBySanPham(sp.getId());
			for (ChiTietHoaDon cthd : listChiTietHoaDon) {
				HoaDon hd = thongKeBUS.getHoaDonById(cthd.getIdHoaDon());
				// Kiểm tra xem ngày hóa đơn có nằm trong khoảng thời gian được chọn không
				if (hd.getNgayLap().compareTo(startDate) >= 0 && hd.getNgayLap().compareTo(endDate) <= 0) {
					Object[] rowData = { sp.getId(), sp.getTenSP(), sp.getDonGia(), cthd.getSoLuong(),
							cthd.getThanhTien(), sp.getHinhAnh(), hd.getNgayLap() };
					rowDataList.add(rowData);
				}
			}
		}
		return rowDataList;
	}

	public void displaySanPham(ArrayList<SanPham> listSanPham, Date startDate, Date endDate) {
		// Gọi phương thức để lấy dữ liệu từ displaySanPham
		ArrayList<Object[]> rowDataList = displaySanPhamOnTable(listSanPham, startDate, endDate);

		// Tạo lại model cho JTable với dữ liệu mới
		String[] columnNames = { "ID", "Tên sản phẩm", "Đơn giá", "Số lượng sản phẩm", "Thành tiền sản phẩm",
				"Hình ảnh", "Ngày hóa đơn" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Object[] rowData : rowDataList) {
			model.addRow(rowData);
		}
		jTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(jTable);

		panel_47.removeAll();
		panel_47.setLayout(new BorderLayout());
		panel_47.add(scrollPane, BorderLayout.CENTER);

		panel_47.revalidate();
		panel_47.repaint();

	}

	public ArrayList<Object[]> displaySanPhamOnTable5(ArrayList<SanPham> listSanPham) {
		ArrayList<Object[]> rowDataList = new ArrayList<>();

		// Xóa dữ liệu cũ trong HashMap trước khi thêm dữ liệu mới
		idQuantityMap.clear();

		for (SanPham sp : listSanPham) {
			ArrayList<ChiTietHoaDon> listChiTietHoaDon = thongKeBUS.getChiTietHoaDonBySanPham(sp.getId());
			for (ChiTietHoaDon cthd : listChiTietHoaDon) {
				int id = sp.getId();
				int quantity = cthd.getSoLuong();

				// Cập nhật hoặc thêm số lượng vào HashMap
				if (idQuantityMap.containsKey(id)) {
					quantity += idQuantityMap.get(id);
				}
				idQuantityMap.put(id, quantity);
			}
		}

		// Tạo dữ liệu cho bảng từ HashMap
		for (Integer id : idQuantityMap.keySet()) {
			SanPham sp = timSanPhamTheoID(listSanPham, id);
			int totalQuantity = idQuantityMap.get(id);
			Object[] rowData = { sp.getId(), sp.getTenSP(), sp.getDonGia(), totalQuantity,
					sp.getDonGia() * totalQuantity };
			rowDataList.add(rowData);
		}
		return rowDataList;
	}

	private SanPham timSanPhamTheoID(ArrayList<SanPham> listSanPham, int id) {
		for (SanPham sp : listSanPham) {
			if (sp.getId() == id) {
				return sp;
			}
		}
		return null;
	}

	public void displaySanPham5(ArrayList<SanPham> listSanPham) {
		ArrayList<Object[]> rowDataList = displaySanPhamOnTable5(listSanPham);

		String[] columnNames = { "ID", "Tên sản phẩm", "Đơn giá", "Số lượng sản phẩm", "Thành tiền sản phẩm" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Object[] rowData : rowDataList) {
			model.addRow(rowData);
		}

		jTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setPreferredSize(new Dimension(300, 200));

		panel_48.removeAll();
		panel_48.setLayout(new BorderLayout());
		panel_48.add(scrollPane, BorderLayout.CENTER);

		panel_48.revalidate();
		panel_48.repaint();
	}

	public ArrayList<Object[]> displaySanPhamOnTable5(ArrayList<SanPham> listSanPham, Date startDate, Date endDate) {
		ArrayList<Object[]> rowDataList = new ArrayList<>();
		HashMap<Integer, Integer> idQuantityMap = new HashMap<>(); // Tạo một HashMap mới để tính tổng số lượng cho từng
																	// ID
		for (SanPham sp : listSanPham) {
			ArrayList<ChiTietHoaDon> listChiTietHoaDon = thongKeBUS.getChiTietHoaDonBySanPham(sp.getId());
			for (ChiTietHoaDon cthd : listChiTietHoaDon) {
				HoaDon hd = thongKeBUS.getHoaDonById(cthd.getIdHoaDon());
				// Kiểm tra xem ngày hóa đơn có nằm trong khoảng thời gian được chọn không
				if (hd.getNgayLap().compareTo(startDate) >= 0 && hd.getNgayLap().compareTo(endDate) <= 0) {
					int id = sp.getId();
					int quantity = cthd.getSoLuong();
					// Cập nhật hoặc thêm số lượng vào HashMap
					if (idQuantityMap.containsKey(id)) {
						quantity += idQuantityMap.get(id);
					}
					idQuantityMap.put(id, quantity);
				}
			}
		}
		// Tạo dữ liệu cho bảng từ HashMap
		for (Integer id : idQuantityMap.keySet()) {
			SanPham sp = timSanPhamTheoID(listSanPham, id);
			int totalQuantity = idQuantityMap.get(id);
			Object[] rowData = { sp.getId(), sp.getTenSP(), sp.getDonGia(), totalQuantity,
					sp.getDonGia() * totalQuantity };
			rowDataList.add(rowData);
		}
		return rowDataList;
	}

	public void displaySanPham5(ArrayList<SanPham> listSanPham, Date startDate, Date endDate) {
		// Gọi phương thức để lấy dữ liệu từ displaySanPhamOnTable5
		ArrayList<Object[]> rowDataList = displaySanPhamOnTable5(listSanPham, startDate, endDate);

		// Tạo lại model cho JTable với dữ liệu mới
		String[] columnNames = { "ID", "Tên sản phẩm", "Đơn giá", "Số lượng sản phẩm", "Thành tiền sản phẩm" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (Object[] rowData : rowDataList) {
			model.addRow(rowData);
		}

		jTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 200));

		panel_48.removeAll();
		panel_48.setLayout(new BorderLayout());
		panel_48.add(scrollPane, BorderLayout.CENTER);
		panel_48.revalidate();
		panel_48.repaint();
	}

}