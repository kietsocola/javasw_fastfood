package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import Custom.MyTextField;
import DTO.KhachHang;


public class QuanLyKhachHangGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	 private DefaultTableModel tableModel;
	 private KhachHang_BUS khachHangBUS = new KhachHang_BUS();
	    
		/**
		 * Launch the application.
		 */
	 	private JPanel contentPane;
		private MyPanelSecond panel_main, panel_input, panel_dienThongTin;
		private JTable table;
		private MyPanel pnMaNV,pnTenNV,pnGioiTinh,pnSoDT,pnSoChiTieu,pnButton,pnTimKiem, pnChuaTimKiem, pnBtnTimKiem,pnTimMin,pnTimMax ;
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
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);
		
		panel_main.setLayout(new BorderLayout(0, 0));
// ------------------------------------------------------------------------------------------------------


		panel_input = new MyPanelSecond();
		panel_main.add(panel_input, BorderLayout.NORTH);
		panel_input.setLayout(new BorderLayout(10, 10));
		
		//label for tieu de
		lblTitle = new MyLabel("KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblTitle, BorderLayout.NORTH);
		
		// Panel for dien thong tin
		panel_dienThongTin = new MyPanelSecond();
		panel_input.add(panel_dienThongTin,BorderLayout.CENTER);
		panel_dienThongTin.setLayout(new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));
		
		// Panel for maKH
		pnMaNV = new MyPanel();
		txtMaKH = new MyTextField();
		txtMaKH.setEditable(false); 
		lblMaKH = new MyLabelSecond("Mã Khách Hàng");
		pnMaNV.add(lblMaKH);
		pnMaNV.add(txtMaKH);
		
		// Panel for tenKH
		pnTenNV = new MyPanel();
		txtTenKH = new MyTextField();
		lblTenKH = new MyLabelSecond("Tên Khách Hàng");
		pnTenNV.add(lblTenKH);
		pnTenNV.add(txtTenKH);

		
		// Panel for gioiTinh
		pnGioiTinh = new MyPanel();
		lblGioiTinh = new MyLabelSecond("Giới Tính ");
		
	    ButtonGroup gioiTinhGroup = new ButtonGroup();
	      
	   // Radio button for Nam
	    rdoBtn_Nam = new JRadioButton("Nam");
	    rdoBtn_Nam.setFont(new Font("Arial", Font.BOLD, 16));
	    rdoBtn_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
	    rdoBtn_Nam.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
	    rdoBtn_Nam.setPreferredSize(new Dimension(130, 30));
	    gioiTinhGroup.add(rdoBtn_Nam); 
	
	    // Radio button for Nu
	    rdoBtn_Nu = new JRadioButton("Nữ");
	    rdoBtn_Nu.setFont(new Font("Arial", Font.BOLD, 16));
	    rdoBtn_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
	    rdoBtn_Nu.setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
	    rdoBtn_Nu.setPreferredSize(new Dimension(50, 30));
	    gioiTinhGroup.add(rdoBtn_Nu); 
	      
	    pnGioiTinh.add(lblGioiTinh);
	    pnGioiTinh.add(rdoBtn_Nam);
	    pnGioiTinh.add(rdoBtn_Nu);
	      
	   // Panel for soDT
		pnSoDT = new MyPanel();
		txt_soDT = new MyTextField();
		lblSoDT = new MyLabelSecond("Số Điện Thoại");
		pnSoDT.add(lblSoDT);
		pnSoDT.add(txt_soDT);
		
		// Panel for số chi tiêu
		pnSoChiTieu = new MyPanel();
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
		pnTimKiem = new MyPanel();
		pnTimKiem.setPreferredSize(new Dimension(300, 10));
		panel_input.add(pnTimKiem,BorderLayout.EAST);
			
		//Panel for lbl vs txt tìm kiếm
		pnChuaTimKiem = new MyPanel();
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
		
		pnBtnTimKiem = new MyPanel();
		pnBtnTimKiem.setPreferredSize(new Dimension(300, 135));
        pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        pnTimKiem.add(pnBtnTimKiem);
        
        pnTimMin = new MyPanel();
        txtTimMin = new MyTextField();
        lblTimMin = new MyLabelSecond("Chi tiêu từ:");
        txtTimMin.setPreferredSize(new Dimension(120, 30));
        lblTimMin.setPreferredSize(new Dimension(90, 30));
        pnTimMin.add(lblTimMin);
        pnTimMin.add(txtTimMin);
        
        pnTimMax = new MyPanel();
        txtTimMax = new MyTextField();
        lblTimMax = new MyLabelSecond("Đến:");
        
        pnTimMax.add(lblTimMax);
        pnTimMax.add(txtTimMax);
        txtTimMax.setPreferredSize(new Dimension(120, 30));
        lblTimMax.setPreferredSize(new Dimension(90, 30));
        
        btnTimKiem = new  MyButton("Tìm kiếm");
        btnTimKiem.setIcon(new ImageIcon("images/search.png"));
        pnBtnTimKiem.add(pnTimMin);
        pnBtnTimKiem.add( pnTimMax);
        pnBtnTimKiem.add(btnTimKiem);
        
      //Panel for buttons
        pnButton = new MyPanel();
        pnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnThem = new MyButton("Thêm");
        btnThem.setIcon(new ImageIcon("images/add-user.png"));
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnXoa = new MyButton("Xóa");
        btnXoa.setIcon(new ImageIcon("images/trash.png"));
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSua = new MyButton("Sửa");
        btnSua.setIcon(new ImageIcon("images/fix.png"));
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnReset = new MyButton("Reset");
        btnReset.setIcon(new ImageIcon("images/reset.png"));
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa);pnButton.add(btnReset);
        
        panel_input.add(pnButton,BorderLayout.SOUTH);
        
// ------------------------------------------------------------------------------------------------------ 
     // Panel for table
// ------------------------------------------------------------------------------------------------------
        MyPanelSecond panel_table = new MyPanelSecond();
        panel_main.add(panel_table, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT"});
        table = new JTable(tableModel);
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