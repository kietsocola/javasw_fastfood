package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHangBus;
import Custom.MyColor;
import DTO.KhachHang;

import java.awt.GridLayout;

public class KhachHangGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	  
	    DefaultTableModel model;
	    private KhachHangBus khachHangBUS = new KhachHangBus();

	    JTable table;
	    JPanel contentPane, jPanel_TieuDe, panel_tableKhachHang, panel_nhap_timKiem_duLieu, panel_dienThongTin,
	            panel_dienMa, panel_dienTen, panel_14, panel_gioiTinh, panel_soDT,panel_soChiTieu, panel_btn, panel,
	            panel_TimKiem,lblSoChiTieu;
	    JLabel lblKhachHang, lblMKhachHang,  label_3, label_8, lblNewLabel,lblChiTieu,lblTimMin,lblTimMax;
	    JTextField textField_maKH, textField_tenKH, textField_soDT, textField_timKiem,textField_TimMin,textField_TimMax,textField_soChiTieu;   
	    JRadioButton radioButton_Nam, radioButton_Nu;
	    JButton themButton, xoaButton, suaButton, resetButton, btnTimKiem;

	/**
	 * Create the frame.
	 */
	public KhachHangGUI() {
		addControlsKhachHang();
        model = (DefaultTableModel) table.getModel();
        addEventsKhachHang();
	}
	
	private void addControlsKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 791, 376);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
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
        lblKhachHang.setForeground(new Color(255, 255, 255));
        lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jPanel_TieuDe.add(lblKhachHang, BorderLayout.CENTER);

        // Panel for table
        panel_tableKhachHang = new JPanel();
        panel_tableKhachHang.setPreferredSize(new Dimension(780, 170));
        contentPane.add(panel_tableKhachHang, BorderLayout.CENTER);
        panel_tableKhachHang.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        String[] column = { "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số ĐT" ,"Số Chi Tiêu"};
        Object[][] data = {};
        table = new JTable(data, column);
        table.setPreferredSize(new Dimension(453, 150));
        JScrollPane sp = new JScrollPane(table);
        panel_tableKhachHang.add(sp, BorderLayout.CENTER);
        sp.setPreferredSize(new Dimension(453, 150));
        sp.setFont(new Font("Tahoma", Font.PLAIN, 14));

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
        panel_dienThongTin.setBackground(MyColor.BORDER_COLOR);
        panel_dienThongTin.setLayout(new GridLayout(0, 1, 10, 10));

        // Panel for Ma KH
        panel_dienMa = new JPanel();
        panel_dienMa.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienMa);
        panel_dienMa.setLayout(new BorderLayout(10, 10));
        panel_dienMa.setBackground(MyColor.BORDER_COLOR);

        // Label for Ma KH
        lblMKhachHang = new JLabel("Mã Khách Hàng");
        lblMKhachHang.setPreferredSize(new Dimension(110, 10));
        lblMKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienMa.add(lblMKhachHang, BorderLayout.WEST);
        lblMKhachHang.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ma KH
        textField_maKH = new JTextField();
        textField_maKH.setColumns(10);
        textField_maKH.setPreferredSize(new Dimension(50, 17));
        panel_dienMa.add(textField_maKH, BorderLayout.CENTER);
        textField_maKH.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for Ten KH
        panel_dienTen = new JPanel();
        panel_dienTen.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienTen);
        panel_dienTen.setLayout(new BorderLayout(10, 10));
        panel_dienTen.setBackground(MyColor.BORDER_COLOR);

        // Label for Ten KH
        JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
        lblTnKhchHng.setPreferredSize(new Dimension(110, 10));
        lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienTen.add(lblTnKhchHng, BorderLayout.WEST);
        lblTnKhchHng.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ten KH
        textField_tenKH = new JTextField();
        textField_tenKH.setColumns(10);
        textField_tenKH.setPreferredSize(new Dimension(50, 17));
        panel_dienTen.add(textField_tenKH, BorderLayout.CENTER);
        textField_tenKH.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

       
        

        // Panel for gioiTinh
        panel_gioiTinh = new JPanel();
        panel_gioiTinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_gioiTinh);
        panel_gioiTinh.setLayout(new BorderLayout(10, 10));
        panel_gioiTinh.setBackground(MyColor.BORDER_COLOR);

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
        radioButton_Nam.setBackground(MyColor.BORDER_COLOR);

        // Radio button for Nu
        radioButton_Nu = new JRadioButton("Nữ");
        radioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        radioButton_Nu.setPreferredSize(new Dimension(80, 17));
        panel_gioiTinh.add(radioButton_Nu, BorderLayout.EAST);
        radioButton_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
        radioButton_Nu.setBackground(MyColor.BORDER_COLOR);

        // Panel for soDT
        panel_soDT = new JPanel();
        panel_soDT.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soDT);
        panel_soDT.setLayout(new BorderLayout(10, 10));
        panel_soDT.setBackground(MyColor.BORDER_COLOR);

        // Label for soDT
        label_8 = new JLabel("Số ĐT");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_8.setPreferredSize(new Dimension(110, 10));
        panel_soDT.add(label_8, BorderLayout.WEST);
        label_8.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soDT
        textField_soDT = new JTextField();
        textField_soDT.setPreferredSize(new Dimension(50, 17));
        panel_soDT.add(textField_soDT, BorderLayout.CENTER);
        textField_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
     // Panel for soChiTieu
        panel_soChiTieu = new JPanel();
        panel_soChiTieu.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soChiTieu);
        panel_soChiTieu.setLayout(new BorderLayout(10, 10));
        panel_soChiTieu.setBackground(MyColor.BORDER_COLOR);

        // Label for soChiTieu
        lblChiTieu = new JLabel("Số Chi Tiêu");
        lblChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblChiTieu.setPreferredSize(new Dimension(110, 10));
        panel_soChiTieu.add(lblChiTieu, BorderLayout.WEST);
        lblChiTieu.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soChiTieu
        textField_soChiTieu = new JTextField();
        textField_soChiTieu.setPreferredSize(new Dimension(50, 17));
        panel_soChiTieu.add(textField_soChiTieu, BorderLayout.CENTER);
        textField_soChiTieu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for buttons
        panel_btn = new JPanel();
        panel_btn.setBackground(MyColor.BORDER_COLOR);
        panel_btn.setLayout(new GridLayout(0, 1, 10, 10));
        panel_nhap_timKiem_duLieu.add(panel_btn, BorderLayout.CENTER);
        panel_btn.setPreferredSize(new Dimension(150, 250));

        panel = new JPanel();
        panel_btn.add(panel);
        panel.setPreferredSize(new Dimension(140, 30));
        panel.setBackground(MyColor.BORDER_COLOR);
        xoaButton = new JButton("Xoá");
        suaButton = new JButton("Sửa");
        resetButton = new JButton("Reset");

        themButton = new JButton("Thêm");
        themButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Thêm sự kiện thêm nhân viên
            }
        });
        themButton.setPreferredSize(new Dimension(89, 32));
        themButton.setForeground(Color.WHITE);
        themButton.setBackground(new Color(234, 124, 105));
        panel_btn.add(themButton);
        panel_btn.add(xoaButton);
        panel_btn.add(suaButton);
        panel_btn.add(resetButton);
        xoaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        xoaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        suaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        suaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        resetButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        resetButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        xoaButton.setPreferredSize(new Dimension(89, 32));
        suaButton.setPreferredSize(new Dimension(89, 32));
        resetButton.setPreferredSize(new Dimension(89, 32));

        panel = new JPanel();
        panel_btn.add(panel);
        panel.setPreferredSize(new Dimension(140, 30));
        panel.setBackground(MyColor.BORDER_COLOR);

     // Panel for search
        panel_TimKiem = new JPanel();
        panel_TimKiem.setPreferredSize(new Dimension(250, 250));
        panel_nhap_timKiem_duLieu.add(panel_TimKiem, BorderLayout.EAST);
        panel_TimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_TimKiem.setBackground(MyColor.BORDER_COLOR);

        // Label for search
        lblNewLabel = new JLabel("Tìm kiếm");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setPreferredSize(new Dimension(250, 80));
        panel_TimKiem.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for search
        textField_timKiem = new JTextField();
        textField_timKiem.setPreferredSize(new Dimension(200, 25));
        panel_TimKiem.add(textField_timKiem, BorderLayout.CENTER);
        textField_timKiem.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
     // Label for TimSoChiTieuMin
        lblTimMin = new JLabel("Chi tiêu từ:");
        lblTimMin.setFont(new Font("UVN Ai Cap", Font.PLAIN, 14));
        lblTimMin.setPreferredSize(new Dimension(110, 30));
        panel_TimKiem.add(lblTimMin, BorderLayout.WEST);
        lblTimMin.setForeground(MyColor.SECOND_TEXT_COLOR);
        
        // Text field for TimSoChiTieuMax
        textField_TimMin = new JTextField();
        textField_TimMin.setPreferredSize(new Dimension(50, 25));
        panel_TimKiem.add(textField_TimMin, BorderLayout.CENTER);
        textField_TimMin.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
     // Label for TimSoChiTieuMax
        lblTimMax = new JLabel("đến");
        lblTimMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTimMax.setPreferredSize(new Dimension(110, 30));
        panel_TimKiem.add(lblTimMax, BorderLayout.WEST);
        lblTimMax.setForeground(MyColor.SECOND_TEXT_COLOR);
        
        // Text field for TimSoChiTieuMin
        textField_TimMax = new JTextField();
        textField_TimMax.setPreferredSize(new Dimension(50, 25));
        panel_TimKiem.add(textField_TimMax, BorderLayout.CENTER);
        textField_TimMax.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
        btnTimKiem = new JButton("Tìm");
        btnTimKiem.setPreferredSize(new Dimension(89, 32));
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setBackground(new Color(234, 124, 105));
        panel_TimKiem.add(btnTimKiem);
        

        loadDataTblKhachHang();
	}

	private void addEventsKhachHang() {
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadDataTblKhachHang();
				textField_maKH.setText("");
				textField_tenKH.setText("");
				textField_soDT.setText("");
				textField_soChiTieu.setText("");
				textField_timKiem.setText("");
				textField_TimMin.setText("");
				textField_TimMax.setText("");
				radioButton_Nam.setSelected(true);
				
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
		
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener()  {

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
		
		textField_TimMin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField_TimMax.requestFocus();
				
			}
			
		});
		
		textField_TimMax.addActionListener(new ActionListener() {

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
		
		themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemKhachHang();
            }
        });

		suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaKhachHang();
            }
        });

		xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaKhachHang();
            }
        });
	}
	
    private void xuLyClickTblKhachHang() {
        int row = table.getSelectedRow();
        if (row > -1) {
            String maKH = table.getValueAt(row, 0).toString();
            String tenKH = table.getValueAt(row, 1).toString();
            String gioiTinh = table.getValueAt(row, 2).toString();
            String soDT = table.getValueAt(row, 3).toString();
            String soChiTieu = table.getValueAt(row, 4).toString();

            textField_maKH.setText(maKH);
            textField_tenKH.setText(tenKH);
            textField_soDT.setText(soDT);
            textField_soChiTieu.setText(soChiTieu);
            
         
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
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        DecimalFormat dcf = new DecimalFormat("###,###");
        
        for (KhachHang kh : dskh) {
            Object[] rowData = new Object[5];

            rowData[0] = kh.getMaKH();
            rowData[1] = kh.getTen();
            rowData[2] = kh.getGioiTinh();
            rowData[3] = kh.getSoDT();
            rowData[4] = dcf.format(kh.getTongChiTieu());

            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }
    }
	
	private void xuLyTimKiemTheoKhoang() {
		ArrayList<KhachHang> dskh = khachHangBUS.timKhachHang(textField_TimMin.getText(),textField_TimMax.getText());
		loadDataTblKhachHang(dskh);
	}
	
	private void xuLyLiveSearch() {
		ArrayList<KhachHang> dskh = khachHangBUS.timKhachHang(textField_timKiem.getText());
		resetButton.doClick();
	}
	
	 private void xuLyThemKhachHang() {
		 String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
		 if(khachHangBUS.themKhachHang(textField_tenKH.getText(),gioiTinh,textField_soDT.getText()))
			 resetButton.doClick(); 
	 }
	 
	 private void xuLySuaKhachHang() {
		 String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
		 if(khachHangBUS.suaKhachHang(textField_maKH.getText(),textField_tenKH.getText(),gioiTinh,textField_soDT.getText()))
			 resetButton.doClick(); 
	 }
	 
	 private void xuLyXoaKhachHang() {
		 if(khachHangBUS.xoaKhachHang(textField_maKH.getText()))
			 resetButton.doClick();  
	 }
}
