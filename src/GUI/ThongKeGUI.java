package GUI;

import java.awt.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.knowm.xchart.*;
import org.knowm.xchart.style.*;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.lines.*;

import java.text.DecimalFormat;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import com.toedter.calendar.JDateChooser;
import java.util.List;
import java.util.stream.Collectors;

import BUS.ThongKeBUS;
import Custom.MyButton;
import Custom.MyPanelSecond;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.SanPham;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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

import java.util.*;
import java.util.stream.Collectors;

public class ThongKeGUI extends JPanel {
	private static final String Styler = null;
	private JFrame frame;
	private CardLayout cardLayout;
	private JDateChooser startDateChooser;
	private JDateChooser endDateChooser;
	private JButton btnLoc;
	private JTable jTable;
	private JPanel panel_47;
	private JPanel panel_48;
	private JPanel panel_green;
	private JPanel panel_cyan;
	private JPanel panel_red;
	private JComboBox<String> comboBoxLoaiSP;
	ThongKeBUS thongKeBUS = new ThongKeBUS();
	private ArrayList<SanPham> listSanPham;
	private HashMap<Integer, Integer> idQuantityMap;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeGUI window = new ThongKeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ThongKeGUI() {
		initialize();
		showAllSanPham();
		drawRevenueChartByMonth();
		drawProductSoldChartByMonth();
		drawTop10BestSellingProductsChart();
	}

	private void initialize() {
		idQuantityMap = new HashMap<>();
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1194, 834);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setLayout(new BorderLayout());
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.add(mainPanel, BorderLayout.CENTER);
		// Tạo một JPanel chứa BorderLayout
//		frame.getContentPane().add(mainPanel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 228));
		mainPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(24, 24));
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 240, 228));
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(10, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 240, 228));
		panel_6.setPreferredSize(new Dimension(372, 80));
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(24, 24));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(24, 24));

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(57, 60, 73)));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setPreferredSize(new Dimension(646, 60));
		panel_8.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		panel_11.add(lblNewLabel_1, BorderLayout.NORTH);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));

		JLabel lblNewLabel_2_1 = new JLabel("Tuesday 2 Feb, 2021");
		panel_11.add(lblNewLabel_2_1, BorderLayout.SOUTH);
		lblNewLabel_2_1.setPreferredSize(new Dimension(300, 30));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 240, 228));
		panel_12.setPreferredSize(new Dimension(200, 500));
		panel_8.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_41 = new JPanel();
		panel_41.setBackground(new Color(255, 255, 255));
		panel_41.setPreferredSize(new Dimension(104, 40));
		panel_12.add(panel_41, BorderLayout.NORTH);

		cardLayout = new CardLayout();
		JPanel panel_40 = new JPanel(cardLayout);
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel_12.add(panel_40, BorderLayout.CENTER);

		// Thêm các panel vào panel_2
		JPanel panel2_1 = new JPanel();
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel2_1.setBackground(new Color(255, 240, 228));
		panel_40.add(panel2_1, "Panel 2-1");
		panel2_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_44 = new JPanel();
		panel_44.setBackground(new Color(255, 255, 255));
		panel2_1.add(panel_44, BorderLayout.NORTH);

		JPanel panel_45 = new JPanel();
		panel_45.setBackground(new Color(255, 240, 228));
		panel2_1.add(panel_45, BorderLayout.CENTER);
		panel_45.setLayout(new BoxLayout(panel_45, BoxLayout.Y_AXIS));

		// Sử dụng GridLayout với 2 cột và số hàng không giới hạn
		panel_45.setLayout(new GridLayout(0, 1, 20, 20));

		panel_green = new JPanel();
		panel_green.setPreferredSize(new Dimension(200, 400));
		panel_45.add(panel_green);

		// Tính toán doanh thu từng tháng

		panel_cyan = new JPanel();
		panel_cyan.setPreferredSize(new Dimension(200, 400));
		panel_45.add(panel_cyan);

		panel_red = new JPanel();
		panel_red.setPreferredSize(new Dimension(200, 400));
		panel_45.add(panel_red);

		JScrollPane scrollPane = new JScrollPane(panel_45);
		panel2_1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel2_2 = new JPanel();
		panel_40.setPreferredSize(new Dimension(200, 50));
		panel2_2.setBackground(new Color(255, 240, 228));
		panel_40.add(panel2_2, "Panel 2-2");
		panel2_2.setLayout(new BorderLayout(10, 5));

		JPanel panel_46 = new JPanel();
		panel_46.setPreferredSize(new Dimension(200, 40));
		panel_46.setBackground(new Color(255, 240, 228));
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

		btnLoc = new MyButton("Lọc");
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

		JButton btnPanel2 = new MyButton("Bảng");
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_40, "Panel 2-2");
			}
		});

		JButton btnPanel1 = new MyButton("Biểu đồ");
		btnPanel1.setForeground(new Color(234, 124, 105));
		btnPanel1.setBackground(new Color(255, 240, 228));
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
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setPreferredSize(new Dimension(104, 145));
		panel_8.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new GridLayout(0, 4, 24, 24));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(16, 16));
		panel_17.setBackground(new Color(228, 228, 255));
		panel_14.add(panel_17, BorderLayout.WEST);

		JPanel panel_18 = new JPanel();
		panel_18.setPreferredSize(new Dimension(16, 16));
		panel_18.setBackground(new Color(228, 228, 255));
		panel_14.add(panel_18, BorderLayout.NORTH);

		JPanel panel_19 = new JPanel();
		panel_19.setPreferredSize(new Dimension(16, 16));
		panel_19.setBackground(new Color(228, 228, 255));
		panel_14.add(panel_19, BorderLayout.EAST);

		JPanel panel_20 = new JPanel();
		panel_20.setPreferredSize(new Dimension(16, 16));
		panel_20.setBackground(new Color(228, 228, 255));
		panel_14.add(panel_20, BorderLayout.SOUTH);

		JPanel panel_7 = new JPanel();
		panel_14.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(50, 50));
		panel_7.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(228, 228, 255));
		panel_9.add(panel_16, BorderLayout.WEST);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(228, 228, 255));
		panel_9.add(panel_21, BorderLayout.SOUTH);

		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(228, 228, 255));
		panel_26.setForeground(new Color(228, 228, 255));
		panel_9.add(panel_26, BorderLayout.CENTER);
		panel_26.setLayout(new BorderLayout(0, 0));

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(228, 228, 255));
		panel_26.add(panel_27, BorderLayout.CENTER);
		panel_27.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblNewLabel_4_1_2 = new JLabel("Khách hàng");
		lblNewLabel_4_1_2.setBackground(new Color(228, 228, 255));
		lblNewLabel_4_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_27.add(lblNewLabel_4_1_2);

		int tongKH = thongKeBUS.getTotal("KhachHang");
		JLabel lblNewLabel_1_1_1_2 = new JLabel(String.valueOf(tongKH));

		lblNewLabel_1_1_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_2.setPreferredSize(new Dimension(104, 10));
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_2.setBackground(new Color(228, 228, 255));
		panel_27.add(lblNewLabel_1_1_1_2);

		JPanel panel_15 = new JPanel();
		panel_15.setForeground(new Color(228, 228, 255));
		panel_7.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(228, 228, 255));
		panel_23.setForeground(new Color(228, 228, 255));
		panel_15.add(panel_23, BorderLayout.EAST);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(228, 228, 255));
		panel_24.setForeground(new Color(228, 228, 255));
		panel_15.add(panel_24, BorderLayout.SOUTH);

		JPanel panel_25 = new JPanel();
		panel_25.setForeground(new Color(228, 228, 255));
		panel_15.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new BorderLayout(0, 0));

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(228, 228, 255));
		panel_28.setForeground(new Color(228, 228, 255));
		panel_28.setPreferredSize(new Dimension(26, 70));
		panel_25.add(panel_28, BorderLayout.WEST);

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(228, 228, 255));
		panel_29.setForeground(new Color(228, 228, 255));
		panel_25.add(panel_29, BorderLayout.CENTER);

		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon("images/user.png"));
		lblNewLabel_5_2.setPreferredSize(new Dimension(70, 70));
		panel_29.add(lblNewLabel_5_2);

		JPanel panel_14_1 = new JPanel();
		panel_13.add(panel_14_1);
		panel_14_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_22_1 = new JPanel();
		panel_22_1.setBackground(new Color(255, 244, 216));
		panel_14_1.add(panel_22_1, BorderLayout.NORTH);

		JPanel panel_17_1 = new JPanel();
		panel_17_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1.setBackground(new Color(255, 244, 216));
		panel_14_1.add(panel_17_1, BorderLayout.WEST);

		JPanel panel_19_1 = new JPanel();
		panel_19_1.setPreferredSize(new Dimension(16, 16));
		panel_19_1.setBackground(new Color(255, 244, 216));
		panel_14_1.add(panel_19_1, BorderLayout.EAST);

		JPanel panel_20_1 = new JPanel();
		panel_20_1.setPreferredSize(new Dimension(16, 16));
		panel_20_1.setBackground(new Color(255, 244, 216));
		panel_14_1.add(panel_20_1, BorderLayout.SOUTH);

		JPanel panel_7_1 = new JPanel();
		panel_14_1.add(panel_7_1, BorderLayout.CENTER);
		panel_7_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_9_1 = new JPanel();
		panel_9_1.setPreferredSize(new Dimension(50, 50));
		panel_7_1.add(panel_9_1);
		panel_9_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_9_2 = new JPanel();
		panel_9_2.setPreferredSize(new Dimension(50, 50));
		panel_9_1.add(panel_9_2, BorderLayout.CENTER);
		panel_9_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_16_1 = new JPanel();
		panel_16_1.setBackground(new Color(255, 244, 216));
		panel_9_2.add(panel_16_1, BorderLayout.WEST);

		JPanel panel_21_1 = new JPanel();
		panel_21_1.setBackground(new Color(255, 244, 216));
		panel_9_2.add(panel_21_1, BorderLayout.SOUTH);

		JPanel panel_26_1 = new JPanel();
		panel_9_2.add(panel_26_1, BorderLayout.CENTER);
		panel_26_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_27_1 = new JPanel();
		panel_27_1.setBackground(new Color(255, 244, 216));
		panel_26_1.add(panel_27_1, BorderLayout.CENTER);
		panel_27_1.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblNewLabel_4_1_2_1 = new JLabel("Sản phẩm");
		lblNewLabel_4_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_27_1.add(lblNewLabel_4_1_2_1);

		int tongSP = thongKeBUS.getTotal("SanPham");
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel(String.valueOf(tongSP));
		lblNewLabel_1_1_1_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_2_1.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_2_1.setBackground(new Color(255, 240, 228));
		panel_27_1.add(lblNewLabel_1_1_1_2_1);

		JPanel panel_15_1 = new JPanel();
		panel_7_1.add(panel_15_1);
		panel_15_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_23_1 = new JPanel();
		panel_23_1.setBackground(new Color(255, 244, 216));
		panel_15_1.add(panel_23_1, BorderLayout.EAST);

		JPanel panel_24_1 = new JPanel();
		panel_24_1.setBackground(new Color(255, 244, 216));
		panel_15_1.add(panel_24_1, BorderLayout.SOUTH);

		JPanel panel_28_1 = new JPanel();
		panel_28_1.setBackground(new Color(255, 244, 216));
		panel_28_1.setPreferredSize(new Dimension(26, 70));
		panel_15_1.add(panel_28_1, BorderLayout.WEST);

		JPanel panel_29_1 = new JPanel();
		panel_29_1.setBackground(new Color(255, 244, 216));
		panel_15_1.add(panel_29_1, BorderLayout.CENTER);

		JLabel lblNewLabel_5_2_1 = new JLabel("");
		lblNewLabel_5_2_1.setBackground(new Color(255, 244, 216));
		lblNewLabel_5_2_1.setIcon(new ImageIcon("images/Icon.png"));
		lblNewLabel_5_2_1.setPreferredSize(new Dimension(70, 70));
		panel_29_1.add(lblNewLabel_5_2_1);

		JPanel panel_14_1_1 = new JPanel();
		panel_13.add(panel_14_1_1);
		panel_14_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_17_1_1 = new JPanel();
		panel_17_1_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1_1.setBackground(new Color(221, 255, 238));
		panel_14_1_1.add(panel_17_1_1, BorderLayout.WEST);

		JPanel panel_7_1_1 = new JPanel();
		panel_14_1_1.add(panel_7_1_1, BorderLayout.CENTER);
		panel_7_1_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_9_1_1 = new JPanel();
		panel_9_1_1.setPreferredSize(new Dimension(50, 50));
		panel_7_1_1.add(panel_9_1_1);
		panel_9_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_9_1_3 = new JPanel();
		panel_9_1_3.setPreferredSize(new Dimension(50, 50));
		panel_9_1_1.add(panel_9_1_3, BorderLayout.CENTER);
		panel_9_1_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_9_2_1 = new JPanel();
		panel_9_2_1.setPreferredSize(new Dimension(50, 50));
		panel_9_1_3.add(panel_9_2_1, BorderLayout.CENTER);
		panel_9_2_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_26_1_1 = new JPanel();
		panel_26_1_1.setBackground(new Color(221, 255, 238));
		panel_9_2_1.add(panel_26_1_1, BorderLayout.CENTER);
		panel_26_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_27_1_1 = new JPanel();
		panel_27_1_1.setBackground(new Color(221, 255, 238));
		panel_26_1_1.add(panel_27_1_1, BorderLayout.CENTER);
		panel_27_1_1.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("Đơn hàng");
		lblNewLabel_4_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_27_1_1.add(lblNewLabel_4_1_2_1_1);

		int tongHD = thongKeBUS.getTotal("hoadon");
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel(String.valueOf(tongHD));
		lblNewLabel_1_1_1_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_2_1_1.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_2_1_1.setBackground(new Color(255, 240, 228));
		panel_27_1_1.add(lblNewLabel_1_1_1_2_1_1);

		JPanel panel_10_1_1_1 = new JPanel();
		panel_10_1_1_1.setBackground(new Color(221, 255, 238));
		panel_26_1_1.add(panel_10_1_1_1, BorderLayout.SOUTH);

		JPanel panel_10_1_1_2 = new JPanel();
		panel_10_1_1_2.setBackground(new Color(221, 255, 238));
		panel_26_1_1.add(panel_10_1_1_2, BorderLayout.WEST);

		JPanel panel_15_1_1 = new JPanel();
		panel_7_1_1.add(panel_15_1_1);
		panel_15_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_15_1_3 = new JPanel();
		panel_15_1_1.add(panel_15_1_3, BorderLayout.CENTER);
		panel_15_1_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_28_1_1 = new JPanel();
		panel_28_1_1.setBackground(new Color(221, 255, 238));
		panel_28_1_1.setPreferredSize(new Dimension(26, 70));
		panel_15_1_3.add(panel_28_1_1, BorderLayout.WEST);

		JPanel panel_29_1_1 = new JPanel();
		panel_29_1_1.setBackground(new Color(221, 255, 238));
		panel_15_1_3.add(panel_29_1_1, BorderLayout.CENTER);

		JLabel lblNewLabel_5_2_1_1 = new JLabel("");
		lblNewLabel_5_2_1_1.setIcon(new ImageIcon("images/doanh thu.png"));
		lblNewLabel_5_2_1_1.setPreferredSize(new Dimension(70, 70));
		panel_29_1_1.add(lblNewLabel_5_2_1_1);

		JPanel panel_10_1_1_4 = new JPanel();
		panel_10_1_1_4.setBackground(new Color(221, 255, 238));
		panel_15_1_3.add(panel_10_1_1_4, BorderLayout.SOUTH);

		JPanel panel_17_1_1_1 = new JPanel();
		panel_17_1_1_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1_1_1.setBackground(new Color(221, 255, 238));
		panel_14_1_1.add(panel_17_1_1_1, BorderLayout.NORTH);

		JPanel panel_17_1_1_1_1 = new JPanel();
		panel_17_1_1_1_1.setPreferredSize(new Dimension(16, 16));
		panel_17_1_1_1_1.setBackground(new Color(221, 255, 238));
		panel_14_1_1.add(panel_17_1_1_1_1, BorderLayout.SOUTH);

		JPanel panel_17_1_1_1_2 = new JPanel();
		panel_17_1_1_1_2.setPreferredSize(new Dimension(16, 16));
		panel_17_1_1_1_2.setBackground(new Color(221, 255, 238));
		panel_14_1_1.add(panel_17_1_1_1_2, BorderLayout.EAST);

		JPanel panel_14_1_1_1 = new JPanel();
		panel_13.add(panel_14_1_1_1);
		panel_14_1_1_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_19_1_2 = new JPanel();
		panel_19_1_2.setPreferredSize(new Dimension(16, 16));
		panel_19_1_2.setBackground(new Color(255, 230, 220));
		panel_14_1_1_1.add(panel_19_1_2, BorderLayout.WEST);

		JPanel panel_7_1_2 = new JPanel();
		panel_14_1_1_1.add(panel_7_1_2, BorderLayout.CENTER);
		panel_7_1_2.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_9_1_2 = new JPanel();
		panel_9_1_2.setPreferredSize(new Dimension(50, 50));
		panel_7_1_2.add(panel_9_1_2);
		panel_9_1_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_9_1_4 = new JPanel();
		panel_9_1_4.setPreferredSize(new Dimension(50, 50));
		panel_9_1_2.add(panel_9_1_4, BorderLayout.CENTER);
		panel_9_1_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_9_2_2 = new JPanel();
		panel_9_2_2.setPreferredSize(new Dimension(50, 50));
		panel_9_1_4.add(panel_9_2_2, BorderLayout.CENTER);
		panel_9_2_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_26_1_2 = new JPanel();
		panel_9_2_2.add(panel_26_1_2, BorderLayout.CENTER);
		panel_26_1_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_27_1_2 = new JPanel();
		panel_27_1_2.setBackground(new Color(255, 230, 220));
		panel_26_1_2.add(panel_27_1_2, BorderLayout.CENTER);
		panel_27_1_2.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblNewLabel_4_1_2_1_2 = new JLabel("Khuyến mãi");
		lblNewLabel_4_1_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_27_1_2.add(lblNewLabel_4_1_2_1_2);

		int tongKM = thongKeBUS.getTotal("Khuyenmai");
		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel(String.valueOf(tongKM));

		lblNewLabel_1_1_1_2_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1_2_1_2.setPreferredSize(new Dimension(104, 30));
		lblNewLabel_1_1_1_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1_1_1_2_1_2.setBackground(new Color(255, 240, 228));
		panel_27_1_2.add(lblNewLabel_1_1_1_2_1_2);

		JPanel panel_10_1_4_1 = new JPanel();
		panel_10_1_4_1.setBackground(new Color(255, 230, 220));
		panel_9_2_2.add(panel_10_1_4_1, BorderLayout.SOUTH);

		JPanel panel_10_1_4_2 = new JPanel();
		panel_10_1_4_2.setBackground(new Color(255, 230, 220));
		panel_9_2_2.add(panel_10_1_4_2, BorderLayout.WEST);

		JPanel panel_15_1_2 = new JPanel();
		panel_7_1_2.add(panel_15_1_2);
		panel_15_1_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_15_1_4 = new JPanel();
		panel_15_1_2.add(panel_15_1_4, BorderLayout.CENTER);
		panel_15_1_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_28_1_2 = new JPanel();
		panel_28_1_2.setBackground(new Color(255, 230, 220));
		panel_28_1_2.setPreferredSize(new Dimension(26, 70));
		panel_15_1_4.add(panel_28_1_2, BorderLayout.WEST);

		JPanel panel_29_1_2 = new JPanel();
		panel_29_1_2.setBackground(new Color(255, 230, 220));
		panel_15_1_4.add(panel_29_1_2, BorderLayout.CENTER);

		JLabel lblNewLabel_5_2_1_2 = new JLabel("");
		lblNewLabel_5_2_1_2.setIcon(new ImageIcon("images/aa.png"));
		lblNewLabel_5_2_1_2.setPreferredSize(new Dimension(70, 70));
		panel_29_1_2.add(lblNewLabel_5_2_1_2);

		JPanel panel_10_1_4_1_2 = new JPanel();
		panel_10_1_4_1_2.setBackground(new Color(255, 230, 220));
		panel_15_1_4.add(panel_10_1_4_1_2, BorderLayout.SOUTH);

		JPanel panel_19_1_2_1 = new JPanel();
		panel_19_1_2_1.setPreferredSize(new Dimension(16, 16));
		panel_19_1_2_1.setBackground(new Color(255, 230, 220));
		panel_14_1_1_1.add(panel_19_1_2_1, BorderLayout.NORTH);

		JPanel panel_19_1_2_2 = new JPanel();
		panel_19_1_2_2.setPreferredSize(new Dimension(16, 16));
		panel_19_1_2_2.setBackground(new Color(255, 230, 220));
		panel_14_1_1_1.add(panel_19_1_2_2, BorderLayout.SOUTH);

		JPanel panel_19_1_2_3 = new JPanel();
		panel_19_1_2_3.setPreferredSize(new Dimension(16, 16));
		panel_19_1_2_3.setBackground(new Color(255, 230, 220));
		panel_14_1_1_1.add(panel_19_1_2_3, BorderLayout.EAST);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setPreferredSize(new Dimension(24, 24));
		panel_2_1.setBackground(Color.WHITE);
		panel.add(panel_2_1, BorderLayout.NORTH);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setPreferredSize(new Dimension(24, 24));
		panel_2_2.setBackground(Color.WHITE);
		panel.add(panel_2_2, BorderLayout.SOUTH);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setPreferredSize(new Dimension(24, 24));
		panel_2_3.setBackground(Color.WHITE);
		panel.add(panel_2_3, BorderLayout.EAST);

		// Đặt JFrame ở giữa màn hình
//		frame.setLocationRelativeTo(null);
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

	private void drawRevenueChartByMonth() {
		ArrayList<HoaDon> hoaDonList = thongKeBUS.getHoaDon();

		// Tạo một mảng để lưu tổng doanh thu của các sản phẩm theo từng tháng
		double[] totalRevenue = new double[12];

		// Lặp qua từng hóa đơn
		for (HoaDon hoaDon : hoaDonList) {
			// Lấy ngày lập hóa đơn
			Date ngayLapHoaDon = (Date) hoaDon.getNgayLap();
			LocalDate localDate = ngayLapHoaDon.toLocalDate();
			int month = localDate.getMonthValue();
			double hoaDonTotalRevenue = 0;

			// Tính tổng doanh thu của hóa đơn
			hoaDonTotalRevenue = hoaDon.getTongTien();

			// Cộng vào tổng doanh thu của tháng tương ứng
			totalRevenue[month - 1] += hoaDonTotalRevenue;
		}

		List<String> months = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			months.add(String.valueOf(i));
		}

		// Tạo biểu đồ
		XYChart chart = new XYChartBuilder().width(1020).height(400).title("Doanh thu theo tháng").xAxisTitle("Tháng")
				.yAxisTitle("Doanh thu (VNĐ)").build();

		// Thiết lập định dạng số thập phân cho trục y (doanh thu)
		chart.getStyler().setDecimalPattern("#,##0");

		// Tạo mảng double[] chứa số tháng tương ứng
		double[] monthsDouble = new double[months.size()];
		for (int i = 0; i < months.size(); i++) {
			monthsDouble[i] = i + 1; // Bắt đầu từ 1
		}

		// Thêm dữ liệu vào biểu đồ
		chart.addSeries("Doanh thu", monthsDouble, totalRevenue);

		// Thêm biểu đồ vào JPanel
		panel_cyan.add(new XChartPanel<>(chart));
	}

	private void drawProductSoldChartByMonth() {
		ArrayList<HoaDon> hoaDonList = thongKeBUS.getAllHoaDon();

		// Tạo một mảng để lưu số lượng sản phẩm đã bán theo từng tháng (12 tháng)
		int[] productSoldByMonth = new int[12];

		// Lặp qua từng hóa đơn để tính số lượng sản phẩm đã bán trong từng tháng
		for (HoaDon hoaDon : hoaDonList) {
			Date ngayLapHoaDon = (Date) hoaDon.getNgayLap();
			LocalDate localDate = ngayLapHoaDon.toLocalDate();
			int month = localDate.getMonthValue() - 1; // Trừ 1 vì mảng bắt đầu từ 0
			ArrayList<ChiTietHoaDon> chiTietHoaDonList = thongKeBUS.getChiTietHoaDonByHoaDonId(hoaDon.getidHD());

			// Tính tổng số lượng sản phẩm đã bán trong hóa đơn và cộng vào mảng tương ứng
			for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
				productSoldByMonth[month] += chiTietHoaDon.getSoLuong();
			}
		}

		// Tạo danh sách các tháng
		List<String> months = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			months.add(String.valueOf(i));
		}

		// Vẽ biểu đồ cột
		CategoryChart chart = new CategoryChartBuilder().width(1020).height(400)
				.title("Số lượng sản phẩm đã bán theo tháng").xAxisTitle("Tháng").yAxisTitle("Số lượng sản phẩm đã bán")
				.build();

		// Chuyển đổi IntStream sang List<Integer>
		List<Integer> productSoldList = Arrays.stream(productSoldByMonth).boxed().collect(Collectors.toList());

		// Thêm dữ liệu vào biểu đồ
		chart.addSeries("Số lượng sản phẩm đã bán", months, productSoldList);

		// Thêm biểu đồ vào panel
		panel_red.add(new XChartPanel<>(chart));

	}

	private void drawTop10BestSellingProductsChart() {
		ArrayList<ChiTietHoaDon> chiTietHoaDonList = thongKeBUS.getAllChiTietHoaDon(); // Lấy danh sách chi tiết hóa đơn

		// Tạo một HashMap để lưu tổng số lượng sản phẩm đã bán của mỗi sản phẩm
		HashMap<Integer, Integer> productIdToTotalQuantityMap = new HashMap<>();

		// Lặp qua danh sách chi tiết hóa đơn để tính tổng số lượng sản phẩm đã bán của
		// mỗi sản phẩm
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
			int productId = chiTietHoaDon.getIdSanPham();
			int quantity = chiTietHoaDon.getSoLuong();

			// Kiểm tra xem sản phẩm đã tồn tại trong HashMap chưa, nếu chưa thì thêm vào và
			// gán số lượng bán
			// Nếu đã tồn tại thì cộng thêm số lượng bán vào tổng số lượng đã có
			productIdToTotalQuantityMap.put(productId,
					productIdToTotalQuantityMap.getOrDefault(productId, 0) + quantity);
		}

		// Chuyển đổi HashMap sang một danh sách để có thể sắp xếp theo số lượng bán
		List<Map.Entry<Integer, Integer>> sortedProductList = new ArrayList<>(productIdToTotalQuantityMap.entrySet());
		sortedProductList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		// Chọn ra top 10 sản phẩm được bán nhiều nhất
		List<SanPham> top10Products = new ArrayList<>();
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : sortedProductList) {
			int productId = entry.getKey();
			int totalQuantity = entry.getValue();

			SanPham product = thongKeBUS.getProductById(productId); // Lấy thông tin sản phẩm từ cơ sở dữ liệu
			if (product != null) {
				top10Products.add(product);
				count++;
				if (count >= 10) {
					break; // Đã đủ 10 sản phẩm, thoát khỏi vòng lặp
				}
			}
		}

		// Tạo danh sách tên sản phẩm và số lượng đã bán để vẽ biểu đồ
		List<String> productNames = new ArrayList<>();
		List<Integer> productQuantities = new ArrayList<>();
		for (SanPham product : top10Products) {
			productNames.add(product.getTenSP());
			productQuantities.add(productIdToTotalQuantityMap.get(product.getId()));
		}

		// Vẽ biểu đồ cột
		CategoryChart chart = new CategoryChartBuilder().width(1020).height(400)
				.title("Top 10 sản phẩm được bán nhiều nhất").xAxisTitle("Sản phẩm").yAxisTitle("Số lượng đã bán")
				.build();

		// Thêm dữ liệu vào biểu đồ
		chart.addSeries("Số lượng đã bán", productNames, productQuantities);

		// Thêm biểu đồ vào panel
		panel_green.add(new XChartPanel<>(chart));
	}

}