package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Custom.MyColor;
import BUS.NhanVien_BUS;
import DTO.NhanVien;

public class QuanLyNhanVienGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	 private DefaultTableModel tableModel;
	 private NhanVien_BUS nhanVienBUS = new NhanVien_BUS();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyNhanVien frame = new QuanLyNhanVien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	JTable table;
    JPanel contentPane, jPanel_TieuDe, panel_tableNhanVien, panel_nhap_timKiem_duLieu, panel_dienThongTin,
            panel_dienMa, panel_dienTen, panel_ngaySinh, panel_14, panel_gioiTinh, panel_soDT, panel_btn,
            panel_TimKiem;
    JLabel Label_TieuDe, label_dienMa, label_ngaySinh, label_3, label_8, lblNewLabel;
    JTextField txtMaNV, txtTenNV, txt_soDT, txtTimKiem;
    JSpinner  sprNgaySinh, sprThangSinh, sprNamSinh;
    JRadioButton rdoBtn_Nam, rdoBtn_Nu;
    JButton btnThem, btnXoa, btnSua, btnReset, btnTimKiem;

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVienGUI() {
		addControlsNhanVien(); 
		addEventsNhanVien();
		tableModel=(DefaultTableModel) table.getModel();
	}
	
	 private void addControlsNhanVien(){

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

        Label_TieuDe = new JLabel();
        Label_TieuDe.setText("NHÂN VIÊN");
        Label_TieuDe.setPreferredSize(new Dimension(119, 120));
        Label_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        Label_TieuDe.setForeground(MyColor.PRIMARY_TEXT_COLOR);
        Label_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jPanel_TieuDe.add(Label_TieuDe, BorderLayout.CENTER);

        // Panel for table
        
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT"});
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
        panel_dienThongTin.setPreferredSize(new Dimension(400, 270));
        panel_nhap_timKiem_duLieu.add(panel_dienThongTin, BorderLayout.WEST);
        panel_dienThongTin.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_dienThongTin.setLayout((LayoutManager) new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));
        
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Panel for Ma NV
        panel_dienMa = new JPanel();
        panel_dienMa.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienMa);
        panel_dienMa.setLayout(new BorderLayout(10, 10));
        panel_dienMa.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_dienMa.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Label for Ma NV
        label_dienMa = new JLabel("Mã Nhân Viên");
        label_dienMa.setPreferredSize(new Dimension(110, 10));
        label_dienMa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienMa.add(label_dienMa, BorderLayout.WEST);
        label_dienMa.setForeground(MyColor.SECOND_TEXT_COLOR);
        

        // Text field for Ma NV
        txtMaNV = new JTextField();
        txtMaNV.setColumns(10);
        txtMaNV.setPreferredSize(new Dimension(50, 17));
        panel_dienMa.add(txtMaNV, BorderLayout.CENTER);
        txtMaNV.setBackground(MyColor.BORDER_COLOR);

        // Panel for Ten NV
        panel_dienTen = new JPanel();
        panel_dienTen.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienTen);
        panel_dienTen.setLayout(new BorderLayout(10, 10));
        panel_dienTen.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_dienTen.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Label for Ten NV
        JLabel label_tenNV = new JLabel("Tên Nhân Viên");
        label_tenNV.setPreferredSize(new Dimension(110, 10));
        label_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienTen.add(label_tenNV, BorderLayout.WEST);
        label_tenNV.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ten NV
        txtTenNV = new JTextField();
        txtTenNV.setColumns(10);
        txtTenNV.setPreferredSize(new Dimension(50, 17));
        panel_dienTen.add(txtTenNV, BorderLayout.CENTER);
        txtTenNV.setBackground(MyColor.BORDER_COLOR);

        // Panel for ngaySinh
        panel_ngaySinh = new JPanel();
        panel_ngaySinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_ngaySinh);
        panel_ngaySinh.setLayout(new BorderLayout(10, 10));
        panel_ngaySinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_ngaySinh.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Label for ngaySinh
        label_ngaySinh = new JLabel("Ngày Sinh");
        label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_ngaySinh.setPreferredSize(new Dimension(110, 10));
        panel_ngaySinh.add(label_ngaySinh, BorderLayout.WEST);
        label_ngaySinh.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Panel for date spinners
        panel_14 = new JPanel();
        panel_14.setPreferredSize(new Dimension(15, 5));
        panel_ngaySinh.add(panel_14, BorderLayout.CENTER);
        panel_14.setBackground(MyColor.BORDER_COLOR);
        panel_14.setLayout(new GridLayout(0, 3, 10, 10));

        // Spinner for day
        sprNgaySinh = new JSpinner();
        panel_14.add(sprNgaySinh);
        sprNgaySinh.setPreferredSize(new Dimension(50, 10));
        sprNgaySinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Spinner for month
        sprThangSinh = new JSpinner();
        panel_14.add(sprThangSinh);
        sprThangSinh.setPreferredSize(new Dimension(50, 10));
        sprThangSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Spinner for year
        sprNamSinh = new JSpinner();
        panel_14.add(sprNamSinh);
        sprNamSinh.setPreferredSize(new Dimension(50, 10));
        sprNamSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for gioiTinh
        panel_gioiTinh = new JPanel();
        panel_gioiTinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_gioiTinh);
        panel_gioiTinh.setLayout(new BorderLayout(10, 10));
        panel_gioiTinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_gioiTinh.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Label for gioiTinh
        label_3 = new JLabel("Giới Tính");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_3.setPreferredSize(new Dimension(150, 17));
        panel_gioiTinh.add(label_3, BorderLayout.WEST);
        label_3.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Radio button for Nam
        rdoBtn_Nam = new JRadioButton("Nam");
        rdoBtn_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdoBtn_Nam.setPreferredSize(new Dimension(20, 17));
        panel_gioiTinh.add(rdoBtn_Nam, BorderLayout.CENTER);
        rdoBtn_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
        rdoBtn_Nam.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Radio button for Nu
        rdoBtn_Nu = new JRadioButton("Nữ");
        rdoBtn_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rdoBtn_Nu.setPreferredSize(new Dimension(80, 17));
        panel_gioiTinh.add(rdoBtn_Nu, BorderLayout.EAST);
        rdoBtn_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
        rdoBtn_Nu.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        ButtonGroup gioiTinhGroup = new ButtonGroup();
        gioiTinhGroup.add(rdoBtn_Nam);
        gioiTinhGroup.add(rdoBtn_Nu);
        
        // Panel for soDT
        panel_soDT = new JPanel();
        panel_soDT.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soDT);
        panel_soDT.setLayout(new BorderLayout(10, 10));
        panel_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        panel_soDT.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_dienThongTin.add(Box.createVerticalStrut(10));

        // Label for soDT
        label_8 = new JLabel("Số ĐT");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_8.setPreferredSize(new Dimension(110, 10));
        panel_soDT.add(label_8, BorderLayout.WEST);
        label_8.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soDT
        txt_soDT = new JTextField();
        txt_soDT.setPreferredSize(new Dimension(50, 17));
        panel_soDT.add(txt_soDT, BorderLayout.CENTER);
        txt_soDT.setBackground(MyColor.BORDER_COLOR);
        

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
        lblNewLabel.setPreferredSize(new Dimension(250, 110));
        panel_TimKiem.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for search
        txtTimKiem = new JTextField();
        txtTimKiem.setPreferredSize(new Dimension(200, 25));
        panel_TimKiem.add(txtTimKiem, BorderLayout.CENTER);
        txtTimKiem.setBackground(MyColor.BORDER_COLOR);
        
        btnTimKiem = new JButton("Tìm");
        btnTimKiem.setPreferredSize(new Dimension(89, 32));
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setBackground(new Color(234, 124, 105));
        panel_TimKiem.add(btnTimKiem);
        
        txtMaNV.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTenNV.setForeground(MyColor.SECOND_TEXT_COLOR);
        txt_soDT.setForeground(MyColor.SECOND_TEXT_COLOR);
        txtTimKiem.setForeground(MyColor.SECOND_TEXT_COLOR);
        rdoBtn_Nam.setBackground(MyColor.BORDER_COLOR);
        rdoBtn_Nu.setBackground(MyColor.BORDER_COLOR);
        
        loadDataTblNhanVien();
	}
	 
	  private void addEventsNhanVien() {
		  table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyClickTblNhanVien();
				
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


	        btnTimKiem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	xuLyTimKiemNhanVien();
	            }
	        });
		  
	        btnThem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                xuLyThemNhanVien();
	            }
	        });

	        btnSua.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                xuLySuaNhanVien();
	            }
	        });

	        btnXoa.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	xuLyXoaNhanVien();
	            }
	        });
	        
	        btnReset.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	xuLyReset();
	            }
	        });
	        
	    
	  }
	  
	  private void xuLyReset(){
	    	
          loadDataTblNhanVien();
          txtMaNV.setText("");
          txtTenNV.setText("");
          txt_soDT.setText("");
          sprNgaySinh.setValue(1);
          sprThangSinh.setValue(1);
          sprNamSinh.setValue(2000);
          rdoBtn_Nam.setSelected(true);
}

private void xuLyXoaNhanVien() {
	String ma=txtMaNV.getText();
	boolean flag =nhanVienBUS.xoaNhanVien(ma);
	if(flag) {
		nhanVienBUS.docDanhSach();
		loadDataTblNhanVien();
	}
}

private void xuLySuaNhanVien() {
	if (!rdoBtn_Nam.isSelected() && !rdoBtn_Nu.isSelected()) {
      JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
      return;
  }
	String maNV = txtMaNV.getText();
  String tenNV = txtTenNV.getText();
  String ngaySinh = sprNgaySinh.getValue().toString() + "-" + sprThangSinh.getValue().toString() + "-" + sprNamSinh.getValue().toString();
  String gioiTinh = rdoBtn_Nam.isSelected() ? "Nam" : "Nữ";
  String soDT = txt_soDT.getText();

  if(nhanVienBUS.suaNhanVien(maNV, tenNV, ngaySinh, gioiTinh, soDT)) {
      nhanVienBUS.docDanhSach();
      loadDataTblNhanVien();
  }
}

private void xuLyThemNhanVien() {
  if (!rdoBtn_Nam.isSelected() && !rdoBtn_Nu.isSelected()) {
      JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
      return;
  }

  String tenNV = txtTenNV.getText();
  String ngaySinh = sprNgaySinh.getValue().toString() + "-" + sprThangSinh.getValue().toString() + "-" + sprNamSinh.getValue().toString();

  String gioiTinh = rdoBtn_Nam.isSelected() ? "Nam" : "Nữ";
  String soDT = txt_soDT.getText();

  if(nhanVienBUS.themNhanVien(tenNV, ngaySinh, gioiTinh, soDT)) {
      nhanVienBUS.docDanhSach();
      loadDataTblNhanVien();

  }
}


private void xuLyTimKiemNhanVien() {
   
    	tableModel.setRowCount(0);
    
    ArrayList<NhanVien> dsnv = nhanVienBUS.timNhanVien(txtTimKiem.getText());
    for (NhanVien nv : dsnv) {
        Object[] rowData = new Object[5];
        rowData[0] = nv.getMaNV();
        rowData[1] = nv.getTen();
        rowData[2] = nv.getNgaySinh();
        rowData[3] = nv.getGioiTinh();
        rowData[4] = nv.getSoDT();
        tableModel.addRow(rowData);
    }
}

	  
	  private void xuLyClickTblNhanVien() {
	        int row = table.getSelectedRow();
	        if (row > -1) {
	            String maNV = table.getValueAt(row, 0).toString();
	            String tenNV = table.getValueAt(row, 1).toString();
	            String ngaySinh = table.getValueAt(row, 2).toString();
	            String gioiTinh = table.getValueAt(row, 3).toString();
	            String soDT = table.getValueAt(row, 4).toString();

	            txtMaNV.setText(maNV);
	            txtTenNV.setText(tenNV);
	            txt_soDT.setText(soDT);

	            // Tách thông tin ngày sinh từ bảng thành ngày, tháng, năm
	            String[] parts = ngaySinh.split("-");
	            if (parts.length == 3) {
	            	sprNgaySinh.setValue(Integer.parseInt(parts[2]));
	            	sprThangSinh.setValue(Integer.parseInt(parts[1]));
	                sprNamSinh.setValue(Integer.parseInt(parts[0]));

	            }
	            if (gioiTinh.equalsIgnoreCase("Nam")) {
	                rdoBtn_Nam.setSelected(true);
	                rdoBtn_Nu.setSelected(false);
	            } else {
	            	rdoBtn_Nam.setSelected(false);
	            	rdoBtn_Nu.setSelected(true);
	            }

	        }
	    }
	 
	 private void loadDataTblNhanVien() {	    
		    
		    	tableModel.setRowCount(0);
		    
	        ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();

	        for (NhanVien nv : dsnv) {
	            Object[] rowData = new Object[5];

	            rowData[0] = nv.getMaNV();
	            rowData[1] = nv.getTen();
	            rowData[2] = nv.getNgaySinh();
	            rowData[3] = nv.getGioiTinh();
	            rowData[4] = nv.getSoDT();

	            tableModel.addRow(rowData);
	        }
	    }
	 

}