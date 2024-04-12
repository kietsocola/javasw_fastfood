package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHang_BUS;
import Custom.MyColor;
import Custom.MyPanelSecond;
import DTO.KhachHang;
import DTO.NhanVien;

import java.awt.GridLayout;
import java.awt.LayoutManager;

public class QuanLyKhachHangGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	 private DefaultTableModel tableModel;
	 private KhachHang_BUS khachHangBUS = new KhachHang_BUS();
	    
		/**
		 * Launch the application.
		 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						QuanLyKhachHang frame = new QuanLyKhachHang();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

	    JTable table;
	    JPanel contentPane, jPanel_TieuDe, panel_tableKhachHang, panel_nhap_timKiem_duLieu, panel_dienThongTin,
	            panel_dienMa, panel_dienTen, panel_14, panel_gioiTinh, panel_soDT,panel_soChiTieu, panel_btn, panel,
	            panel_TimKiem,panel_TimChiTieu;
	    JLabel lblKhachHang, lblMKhachHang,  label_3, label_8, lblNewLabel,lblChiTieu,lblTimMin,lblTimMax;
	    JTextField txtMaKH, txtTenKH, txt_SoDT, txtTimKiem,txtTimMin,txtTimMax,txtSoChiTieu;   
	    JRadioButton radioButton_Nam, radioButton_Nu;
	    JButton btnThem, btnXoa, btnSua, btnReset, btnTimKiem;

	/**
	 * Create the frame.
	 */
	public QuanLyKhachHangGUI() {
		addControlsKhachHang();
		tableModel = (DefaultTableModel) table.getModel();
        addEventsKhachHang();
	}
	
	private void addControlsKhachHang() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 791, 376);
        contentPane = new JPanel();

		this.setLayout(new BorderLayout());
		this.add(contentPane, BorderLayout.CENTER);
		
        contentPane.setBorder(null);
//        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(20, 50));
        contentPane.setBackground(MyColor.BORDER_COLOR);

        // Panel for title
        jPanel_TieuDe = new JPanel();
        jPanel_TieuDe.setPreferredSize(new Dimension(400, 40));
        jPanel_TieuDe.setBackground(MyColor.BORDER_COLOR);
        contentPane.add(jPanel_TieuDe, BorderLayout.NORTH);
        jPanel_TieuDe.setLayout(new BorderLayout());

        lblKhachHang = new JLabel();
        lblKhachHang.setText("KHÁCH HÀNG");
        lblKhachHang.setPreferredSize(new Dimension(119, 120));
        lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        lblKhachHang.setForeground(MyColor.PRIMARY_TEXT_COLOR);
        lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jPanel_TieuDe.add(lblKhachHang, BorderLayout.CENTER);

 // Panel for table    
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số ĐT" ,"Số Chi Tiêu"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table.setPreferredSize(new Dimension(453, 150));
        scrollPane.setPreferredSize(new Dimension(453, 150));
       

        // Panel for input and search
        panel_nhap_timKiem_duLieu = new JPanel();
        panel_nhap_timKiem_duLieu.setPreferredSize(new Dimension(780, 250));
        contentPane.add(panel_nhap_timKiem_duLieu, BorderLayout.SOUTH);
        panel_nhap_timKiem_duLieu.setBackground(MyColor.BORDER_COLOR);
        panel_nhap_timKiem_duLieu.setLayout(new BorderLayout());

        // Panel for input data
        panel_dienThongTin = new JPanel();
        panel_dienThongTin.setPreferredSize(new Dimension(400, 250));
        panel_nhap_timKiem_duLieu.add(panel_dienThongTin, BorderLayout.WEST);
        panel_dienThongTin.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_dienThongTin.setLayout((LayoutManager) new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));

        panel_dienThongTin.add(Box.createVerticalStrut(10));
        // Panel for Ma KH
        panel_dienMa = new JPanel();
        panel_dienMa.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienMa);
        panel_dienMa.setLayout(new BorderLayout(10, 10));
        panel_dienMa.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for Ma KH
        lblMKhachHang = new JLabel("Mã Khách Hàng");
        lblMKhachHang.setPreferredSize(new Dimension(110, 10));
        lblMKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienMa.add(lblMKhachHang, BorderLayout.WEST);
        lblMKhachHang.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ma KH
        txtMaKH = new JTextField();
        txtMaKH.setForeground(new Color(255, 255, 255));
        txtMaKH.setColumns(10);
        txtMaKH.setPreferredSize(new Dimension(50, 17));
        panel_dienMa.add(txtMaKH, BorderLayout.CENTER);
        txtMaKH.setBackground(MyColor.BORDER_COLOR);

        
        panel_dienThongTin.add(Box.createVerticalStrut(10));
        // Panel for Ten KH
        panel_dienTen = new JPanel();
        panel_dienTen.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienTen);
        panel_dienTen.setLayout(new BorderLayout(10, 10));
        panel_dienTen.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for Ten KH
        JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
        lblTnKhchHng.setPreferredSize(new Dimension(110, 10));
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienTen.add(lblTnKhchHng, BorderLayout.WEST);
        lblTnKhchHng.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ten KH
        txtTenKH = new JTextField();
        txtTenKH.setColumns(10);
        txtTenKH.setPreferredSize(new Dimension(50, 17));
        panel_dienTen.add(txtTenKH, BorderLayout.CENTER);
        txtTenKH.setBackground(MyColor.BORDER_COLOR);

       
        
        panel_dienThongTin.add(Box.createVerticalStrut(10));
        // Panel for gioiTinh
        panel_gioiTinh = new JPanel();
        panel_gioiTinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_gioiTinh);
        panel_gioiTinh.setLayout(new BorderLayout(10, 10));
        panel_gioiTinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for gioiTinh
        label_3 = new JLabel("Giới Tính");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_3.setPreferredSize(new Dimension(150, 17));
        panel_gioiTinh.add(label_3, BorderLayout.WEST);
        label_3.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Radio button for Nam
        radioButton_Nam = new JRadioButton("Nam");
        radioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
        radioButton_Nam.setPreferredSize(new Dimension(20, 17));
        panel_gioiTinh.add(radioButton_Nam, BorderLayout.CENTER);
        radioButton_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
        radioButton_Nam.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Radio button for Nu
        radioButton_Nu = new JRadioButton("Nữ");
        radioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        radioButton_Nu.setPreferredSize(new Dimension(80, 17));
        panel_gioiTinh.add(radioButton_Nu, BorderLayout.EAST);
        radioButton_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
        radioButton_Nu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        panel_dienThongTin.add(Box.createVerticalStrut(10));
        // Panel for soDT
        panel_soDT = new JPanel();
        panel_soDT.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soDT);
        panel_soDT.setLayout(new BorderLayout(10, 10));
        panel_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for soDT
        label_8 = new JLabel("Số ĐT");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_8.setPreferredSize(new Dimension(110, 10));
        panel_soDT.add(label_8, BorderLayout.WEST);
        label_8.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soDT
        txt_SoDT = new JTextField();
        txt_SoDT.setPreferredSize(new Dimension(50, 17));
        panel_soDT.add(txt_SoDT, BorderLayout.CENTER);
        txt_SoDT.setBackground(MyColor.BORDER_COLOR);
        
        panel_dienThongTin.add(Box.createVerticalStrut(10));
     // Panel for soChiTieu
        panel_soChiTieu = new JPanel();
        panel_soChiTieu.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soChiTieu);
        panel_soChiTieu.setLayout(new BorderLayout(10, 10));
        panel_soChiTieu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for soChiTieu
        lblChiTieu = new JLabel("Số Chi Tiêu");
        lblChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblChiTieu.setPreferredSize(new Dimension(110, 10));
        panel_soChiTieu.add(lblChiTieu, BorderLayout.WEST);
        lblChiTieu.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soChiTieu
        txtSoChiTieu = new JTextField();
        txtSoChiTieu.setPreferredSize(new Dimension(50, 17));
        panel_soChiTieu.add(txtSoChiTieu, BorderLayout.CENTER);
        txtSoChiTieu.setBackground(MyColor.BORDER_COLOR);
        
        panel_dienThongTin.add(Box.createVerticalStrut(10));
        
        // Panel for buttons
        panel_btn = new JPanel();
        panel_btn.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_nhap_timKiem_duLieu.add(panel_btn, BorderLayout.CENTER);
        panel_btn.setPreferredSize(new Dimension(150, 250));
        panel_btn.setLayout((LayoutManager) new BoxLayout(panel_btn, BoxLayout.Y_AXIS));
        panel_btn.add(Box.createVerticalStrut(50));
        btnXoa = new JButton("Xoá");
        btnSua = new JButton("Sửa");
        btnReset = new JButton("Reset");
        btnThem = new JButton("Thêm");
       
        
        btnThem.setForeground(Color.WHITE);
        btnThem.setBackground(new Color(234, 124, 105));
        panel_btn.add(btnThem);
        panel_btn.add(Box.createVerticalStrut(10));
        panel_btn.add(btnXoa);
        panel_btn.add(Box.createVerticalStrut(10));
        panel_btn.add(btnSua);
        panel_btn.add(Box.createVerticalStrut(10));
        panel_btn.add(btnReset);
        
        btnXoa.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        btnXoa.setForeground(MyColor.SECOND_TEXT_COLOR);
        btnSua.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        btnSua.setForeground(MyColor.SECOND_TEXT_COLOR);
        btnReset.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        btnReset.setForeground(MyColor.SECOND_TEXT_COLOR);
        btnThem.setPreferredSize(new Dimension(120, 40)); 
        btnXoa.setPreferredSize(new Dimension(120, 40)); 
        btnSua.setPreferredSize(new Dimension(120, 40)); 
        btnReset.setPreferredSize(new Dimension(120, 40)); 

        btnThem.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnXoa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSua.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReset.setAlignmentX(Component.CENTER_ALIGNMENT);

     // Panel for search
        panel_TimKiem = new JPanel();
        panel_TimKiem.setPreferredSize(new Dimension(250, 250));
        panel_nhap_timKiem_duLieu.add(panel_TimKiem, BorderLayout.EAST);
        panel_TimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_TimKiem.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Label for search
        lblNewLabel = new JLabel("Tìm kiếm");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setPreferredSize(new Dimension(250, 80));
        panel_TimKiem.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for search
        txtTimKiem = new JTextField();
        txtTimKiem.setPreferredSize(new Dimension(200, 25));
        panel_TimKiem.add(txtTimKiem, BorderLayout.NORTH);
        txtTimKiem.setBackground(MyColor.BORDER_COLOR);
        
     // Panel for search chiTieu
        panel_TimChiTieu = new JPanel();
        panel_TimChiTieu.setPreferredSize(new Dimension(250, 130));
        panel_TimKiem.add(panel_TimChiTieu, BorderLayout.CENTER);
        panel_TimChiTieu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
     // Label for TimSoChiTieuMin
        lblTimMin = new JLabel("Chi tiêu từ:");
        lblTimMin.setFont(new Font("UVN Ai Cap", Font.PLAIN, 14));
        lblTimMin.setPreferredSize(new Dimension(110, 30));
        panel_TimChiTieu.add(lblTimMin, BorderLayout.WEST);
        lblTimMin.setForeground(MyColor.SECOND_TEXT_COLOR);
        
        // Text field for TimSoChiTieuMax
        txtTimMin = new JTextField();
        txtTimMin.setPreferredSize(new Dimension(50, 25));
        panel_TimChiTieu.add(txtTimMin, BorderLayout.CENTER);
        txtTimMin.setBackground(MyColor.BORDER_COLOR);
        
     // Label for TimSoChiTieuMax
        lblTimMax = new JLabel("Đến");
        lblTimMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTimMax.setPreferredSize(new Dimension(110, 30));
        panel_TimChiTieu.add(lblTimMax, BorderLayout.WEST);
        lblTimMax.setForeground(MyColor.SECOND_TEXT_COLOR);
        
        // Text field for TimSoChiTieuMin
        txtTimMax = new JTextField();
        txtTimMax.setPreferredSize(new Dimension(50, 25));
        panel_TimChiTieu.add(txtTimMax, BorderLayout.CENTER);
        txtTimMax.setBackground(MyColor.BORDER_COLOR);
        
        btnTimKiem = new JButton("Tìm");
        btnTimKiem.setPreferredSize(new Dimension(89, 32));
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setBackground(new Color(234, 124, 105));
        panel_TimChiTieu.add(btnTimKiem);
        
        txtMaKH.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTenKH.setForeground(MyColor.SECOND_TEXT_COLOR);
        txt_SoDT.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtSoChiTieu.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTimKiem.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTimMax.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTimMin.setForeground(MyColor.SECOND_TEXT_COLOR);

        loadDataTblKhachHang();
	}

	private void addEventsKhachHang() {
		btnReset.addActionListener(new ActionListener() {
			 @Override
				public void actionPerformed(ActionEvent e) {
			xuLyReset();

			}
				
		});
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyClickTblKhachHang();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	     txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                xuLyLiveSearch();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                xuLyLiveSearch();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                xuLyLiveSearch();
	            }
	        });
		
		txtTimMin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtTimMax.requestFocus();
				
			}
			
		});
		
		txtTimMax.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnTimKiem.doClick();
				
			}
			
		});
		
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyTimKiemTheoKhoang();
				
			}
			
		});
		
		btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemKhachHang();
            }
        });

		btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaKhachHang();
            }
        });

		btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaKhachHang();
            }
        });
	}
		 private void xuLyReset(){
					loadDataTblKhachHang();
					txtMaKH.setText("");
					txtTenKH.setText("");
					txt_SoDT.setText("");
					txtSoChiTieu.setText("");
					txtTimKiem.setText("");
					txtTimMin.setText("");
					txtTimMax.setText("");
					radioButton_Nam.setSelected(true);
					
	}
	
    private void xuLyClickTblKhachHang() {
        int row = table.getSelectedRow();
        if (row > -1) {
            String maKH = table.getValueAt(row, 0).toString();
            String tenKH = table.getValueAt(row, 1).toString();
            String gioiTinh = table.getValueAt(row, 2).toString();
            String soDT = table.getValueAt(row, 3).toString();
            String soChiTieu = table.getValueAt(row, 4).toString();

            txtMaKH.setText(maKH);
            txtTenKH.setText(tenKH);
            txt_SoDT.setText(soDT);
            txtSoChiTieu.setText(soChiTieu);
            
         
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                radioButton_Nam.setSelected(true);
                radioButton_Nu.setSelected(false);
            } else {
                radioButton_Nam.setSelected(false);
                radioButton_Nu.setSelected(true);
            }

        }
    }
	
    private void loadDataTblKhachHang() {

    	khachHangBUS.docDanhSach();
    	ArrayList<KhachHang> dskh = khachHangBUS.getDanhSachKhachHang();
    	loadDataTblKhachHang(dskh);
    }
    
	private void loadDataTblKhachHang(ArrayList<KhachHang> dskh) {
		tableModel.setRowCount(0);

        
        for (KhachHang kh : dskh) {
            Object[] rowData = new Object[5];

            rowData[0] = kh.getMaKH();
            rowData[1] = kh.getTen();
            rowData[2] = kh.getGioiTinh();
            rowData[3] = kh.getSoDT();
            rowData[4] = kh.getTongChiTieu();

            tableModel.addRow(rowData);
        }
    }
	
	private void xuLyTimKiemTheoKhoang() {
		ArrayList<KhachHang> dskh = khachHangBUS.timKhachHang(txtTimMin.getText(),txtTimMax.getText());
		loadDataTblKhachHang(dskh);
	}
	
	private void xuLyLiveSearch() {
		ArrayList<KhachHang> dskh = khachHangBUS.timKhachHang(txtTimKiem.getText());
		loadDataTblKhachHang(dskh);
	}
	
	 private void xuLyThemKhachHang() {
		  if (!radioButton_Nam.isSelected() && !radioButton_Nu.isSelected()) {
		      JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
		      return;
		  }
		 String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
		 if(khachHangBUS.themKhachHang(txtTenKH.getText(),gioiTinh,txt_SoDT.getText()))
			 btnReset.doClick();
	 }
	 
	 private void xuLySuaKhachHang() {
		 String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
		 if(khachHangBUS.suaKhachHang(txtMaKH.getText(),txtTenKH.getText(),gioiTinh,txt_SoDT.getText()))
		 btnReset.doClick(); 
	 }
	 
	 private void xuLyXoaKhachHang() {
		 if(khachHangBUS.xoaKhachHang(txtMaKH.getText()))
			 
			 loadDataTblKhachHang(); 
	 }
}