package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHang_BUS;
import Custom.MyButton;
import Custom.MyColor;
import Custom.MyLabel;
import Custom.MyLabelSecond;
import Custom.MyPanel;
import Custom.MyPanelSecond;
import Custom.MyTable;
import Custom.MyTextField;
import DTO.KhachHang;


public class QuanLyKhachHangGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	 private DefaultTableModel tableModel;
	 private KhachHang_BUS khachHangBUS = new KhachHang_BUS();
	    
		/**
		 * Launch the application.
		 */
		private MyPanel panel_main, panel_input, panel_dienThongTin;
		private MyTable table;
		private MyPanelSecond pnMaNV,pnTenNV,pnGioiTinh,pnSoDT,pnSoChiTieu,pnButton,pnTimKiem, pnChuaTimKiem, pnBtnTimKiem,pnTimMin,pnTimMax ;
		private MyLabel lblTitle;
		private MyLabelSecond lblMaKH, lblTenKH,lblSoDT,lblGioiTinh,lblSoChiTieu,lblTimKiem,lblTimMin,lblTimMax;
		private MyButton btnThem, btnXoa, btnSua, btnReset, btnTimKiem;
		private MyTextField txtMaKH, txtTenKH, txt_soDT,txtSoChiTieu, txtTimKiem,txtTimMin,txtTimMax;
		private JRadioButton rdoBtn_Nam, rdoBtn_Nu;

	/**
	 * Create the frame.
	 */
	public QuanLyKhachHangGUI() {
		addControlsKhachHang();
		tableModel = (DefaultTableModel) table.getModel();
        addEventsKhachHang();
	}
	
	private void addControlsKhachHang() {
		this.setLayout(new BorderLayout());
		panel_main = new MyPanel();
		this.add(panel_main, BorderLayout.CENTER);
		
		panel_main.setLayout(new BorderLayout(0, 0));
// ------------------------------------------------------------------------------------------------------
		MyPanel pnContainInput = new MyPanel();
		pnContainInput.setLayout(new BorderLayout(10, 10));
		MyPanel pnSpace = new MyPanel();
		pnContainInput.add(pnSpace, BorderLayout.EAST);
		MyPanel pnSpace1 = new MyPanel();
		pnContainInput.add(pnSpace1, BorderLayout.WEST);

		panel_input = new MyPanel();
		pnContainInput.add(panel_input, BorderLayout.CENTER);
		panel_main.add(pnContainInput, BorderLayout.NORTH);
		panel_input.setLayout(new BorderLayout(10, 10));
		
		//label for tieu de
		lblTitle = new MyLabel("Quản Lý Khách Hàng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblTitle, BorderLayout.NORTH);
		
		// Panel for dien thong tin
		panel_dienThongTin = new MyPanel();
		panel_input.add(panel_dienThongTin,BorderLayout.CENTER);
		panel_dienThongTin.setLayout(new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));
		
		// Panel for maKH
		pnMaNV = new MyPanelSecond();
		txtMaKH = new MyTextField();
		txtMaKH.setEditable(false); 
		lblMaKH = new MyLabelSecond("Mã Khách Hàng");
		pnMaNV.add(lblMaKH);
		pnMaNV.add(txtMaKH);
		
		// Panel for tenKH
		pnTenNV = new MyPanelSecond();
		txtTenKH = new MyTextField();
		lblTenKH = new MyLabelSecond("Tên Khách Hàng");
		pnTenNV.add(lblTenKH);
		pnTenNV.add(txtTenKH);

		
		// Panel for gioiTinh
		pnGioiTinh = new MyPanelSecond();
		lblGioiTinh = new MyLabelSecond("Giới Tính ");
		
	    ButtonGroup gioiTinhGroup = new ButtonGroup();
	      
	   // Radio button for Nam
	    rdoBtn_Nam = new JRadioButton("Nam");
	    rdoBtn_Nam.setFont(new Font("Arial", Font.BOLD, 15));
	    rdoBtn_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
	    rdoBtn_Nam.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
	    rdoBtn_Nam.setPreferredSize(new Dimension(130, 30));
	    gioiTinhGroup.add(rdoBtn_Nam); 
	
	    // Radio button for Nu
	    rdoBtn_Nu = new JRadioButton("Nữ");
	    rdoBtn_Nu.setFont(new Font("Arial", Font.BOLD, 15));
	    rdoBtn_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
	    rdoBtn_Nu.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
	    rdoBtn_Nu.setPreferredSize(new Dimension(50, 30));
	    gioiTinhGroup.add(rdoBtn_Nu); 
	      
	    pnGioiTinh.add(lblGioiTinh);
	    pnGioiTinh.add(rdoBtn_Nam);
	    pnGioiTinh.add(rdoBtn_Nu);
	      
	   // Panel for soDT
		pnSoDT = new MyPanelSecond();
		txt_soDT = new MyTextField();
		lblSoDT = new MyLabelSecond("Số Điện Thoại");
		pnSoDT.add(lblSoDT);
		pnSoDT.add(txt_soDT);
		
		// Panel for số chi tiêu
		pnSoChiTieu = new MyPanelSecond();
		txtSoChiTieu = new MyTextField();
		txtSoChiTieu.setEditable(false);
		lblSoChiTieu = new MyLabelSecond("Số Chi Tiêu");
		pnSoChiTieu.add(lblSoChiTieu);
		pnSoChiTieu.add(txtSoChiTieu);
				
		panel_dienThongTin.add(pnMaNV);
		panel_dienThongTin.add(pnTenNV);
		panel_dienThongTin.add(pnGioiTinh);
		panel_dienThongTin.add(pnSoDT);
		panel_dienThongTin.add(pnSoChiTieu);
		
		//Panel for Tìm Kiếm
		pnTimKiem = new MyPanelSecond();
		pnTimKiem.setPreferredSize(new Dimension(300, 10));
		panel_input.add(pnTimKiem,BorderLayout.EAST);
			
		//Panel for lbl vs txt tìm kiếm
		pnChuaTimKiem = new MyPanelSecond();
		pnChuaTimKiem.setMaximumSize(new Dimension(120, 120));
		pnChuaTimKiem.setPreferredSize(new Dimension(300, 90));
		pnChuaTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		// Label for search
		lblTimKiem = new MyLabelSecond("Tìm Kiếm");
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setPreferredSize(new Dimension(100, 30));
		pnChuaTimKiem.add(lblTimKiem);
		
		 // Text field for search
		txtTimKiem = new MyTextField();
		txtTimKiem.setPreferredSize(new Dimension(220, 30));
		pnChuaTimKiem.add(txtTimKiem);
		pnTimKiem.add(pnChuaTimKiem);
		
		pnBtnTimKiem = new MyPanelSecond();
		pnBtnTimKiem.setPreferredSize(new Dimension(300, 135));
        pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        pnTimKiem.add(pnBtnTimKiem);
        
        pnTimMin = new MyPanelSecond();
        txtTimMin = new MyTextField();
        lblTimMin = new MyLabelSecond("Chi tiêu từ:");
        txtTimMin.setPreferredSize(new Dimension(120, 30));
        lblTimMin.setPreferredSize(new Dimension(90, 30));
        pnTimMin.add(lblTimMin);
        pnTimMin.add(txtTimMin);
        
        pnTimMax = new MyPanelSecond();
        txtTimMax = new MyTextField();
        lblTimMax = new MyLabelSecond("Đến:");
        
        pnTimMax.add(lblTimMax);
        pnTimMax.add(txtTimMax);
        txtTimMax.setPreferredSize(new Dimension(120, 30));
        lblTimMax.setPreferredSize(new Dimension(90, 30));
        
        btnTimKiem = new  MyButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
        ImageIcon iconTimkiem = new ImageIcon("images/loupe.png");
		Image img0 = iconTimkiem.getImage();
		Image newImg0 = img0.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconTimkiem.setImage(newImg0);
		btnTimKiem.setIcon(iconTimkiem);
        pnBtnTimKiem.add(pnTimMin);
        pnBtnTimKiem.add( pnTimMax);
        pnBtnTimKiem.add(btnTimKiem);
        
      //Panel for buttons
        pnButton = new MyPanelSecond();
        pnButton.setFont(new Font("Arial", Font.PLAIN, 16));
        
        btnThem = new MyButton("Thêm");
        ImageIcon icon = new ImageIcon("images/plus.png");
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        btnThem.setIcon(resizedIcon);
        btnThem.setFont(new Font("Arial", Font.PLAIN, 16));
        
        btnXoa = new MyButton("Xóa");
        ImageIcon icon2 = new ImageIcon("images/remove.png");
        Image img2 = icon2.getImage();
        Image resizedImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon2 = new ImageIcon(resizedImg2);
        btnXoa.setIcon(resizedIcon2);
        btnXoa.setFont(new Font("Arial", Font.PLAIN, 16));
        
        btnSua = new MyButton("Sửa");
        ImageIcon icon1 = new ImageIcon("images/edit2.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        Image img1 = icon1.getImage();
        Image resizedImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
        btnSua.setIcon(resizedIcon1);
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnReset = new MyButton("Reset");
        ImageIcon icon5 = new ImageIcon("images/LamMoi.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của bạn
        Image img5 = icon5.getImage();
        Image resizedImg5 = img5.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và chiều rộng mong muốn
        ImageIcon resizedIcon5 = new ImageIcon(resizedImg5);
        btnReset.setIcon(resizedIcon5);
        btnReset.setFont(new Font("Arial", Font.PLAIN, 16));
        
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa);pnButton.add(btnReset);
        
        panel_input.add(pnButton,BorderLayout.SOUTH);
        
// ------------------------------------------------------------------------------------------------------ 
     // Panel for table
// ------------------------------------------------------------------------------------------------------
        MyPanel pnContainTable = new MyPanel();
        pnContainTable.setLayout(new BorderLayout(10, 10));
		MyPanel pnSpace2 = new MyPanel();
		pnContainTable.add(pnSpace2, BorderLayout.EAST);
		MyPanel pnSpace3 = new MyPanel();
		pnContainTable.add(pnSpace3, BorderLayout.WEST);
        
        MyPanelSecond panel_table = new MyPanelSecond();
        panel_table.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pnContainTable.add(panel_table, BorderLayout.CENTER);
		panel_main.add(pnContainTable, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT"});
        table = new MyTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(453, 150)); // Đặt kích thước ở đây nếu cần
        panel_table.setLayout(new BorderLayout(0, 0));
        panel_table.add(scrollPane, BorderLayout.NORTH);

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
					txt_soDT.setText("");
					txtSoChiTieu.setText("");
					txtTimKiem.setText("");
					txtTimMin.setText("");
					txtTimMax.setText("");
					rdoBtn_Nam.setSelected(true);
					
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
            txt_soDT.setText(soDT);
            txtSoChiTieu.setText(soChiTieu);
            
         
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdoBtn_Nam.setSelected(true);
                rdoBtn_Nu.setSelected(false);
            } else {
                rdoBtn_Nam.setSelected(false);
                rdoBtn_Nu.setSelected(true);
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
            rowData[2] = kh.getGioiTinh()==1?"Nam":"Nữ";
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
		  if (!rdoBtn_Nam.isSelected() && !rdoBtn_Nu.isSelected()) {
		      JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
		      return;
		  }
		  int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
		 if(khachHangBUS.themKhachHang(txtTenKH.getText(),gioiTinh,txt_soDT.getText()))
			 btnReset.doClick();
	 }
	 
	 private void xuLySuaKhachHang() {
		 int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
		 if(khachHangBUS.suaKhachHang(txtMaKH.getText(),txtTenKH.getText(),gioiTinh,txt_soDT.getText()))
		 btnReset.doClick(); 
	 }
	 
	 private void xuLyXoaKhachHang() {
		 if(khachHangBUS.xoaKhachHang(txtMaKH.getText()))
			 loadDataTblKhachHang(); 
		 btnReset.doClick();
	 }
}