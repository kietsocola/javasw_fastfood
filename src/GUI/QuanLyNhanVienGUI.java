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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import BUS.NhanVien_BUS;
import BUS.taiKhoan_BUS;
import Custom.*;
import DTO.NhanVien;
import DTO.phanquyen_DTO;
import BUS.XuLyFileExcel;
import BUS.phanquyen_BUS;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class QuanLyNhanVienGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	 private DefaultTableModel tableModel;
	 private NhanVien_BUS nhanVienBUS = new NhanVien_BUS();
	 private taiKhoan_BUS taiKhoanBUS = new taiKhoan_BUS();
	 private phanquyen_BUS pqbus = new phanquyen_BUS();
	
	private MyPanel  panel_main, panel_input, panel_dienThongTin;
	private MyTable table;
	private MyPanelSecond pnMaNV,pnTenNV,pnNgaySinh,pnGioiTinh,pnSoDT,pnChucVu,pnButton,pnTimKiem, pnChuaTimKiem, pnBtnTimKiem ;
	private MyLabel lblTitle;
	private MyLabelSecond lblMaNV, lblTenNV,lblNgaySinh,lblSoDT,lblGioiTinh,lblChucVu,lblTimKiem;
	private MyButton btnThem, btnXoa, btnSua, btnReset, btnNhap,btnXuat, btnTimKiem;
	private MyTextField txtMaNV, txtTenNV, txt_soDT, txtTimKiem;
	private JRadioButton rdoBtn_Nam, rdoBtn_Nu;
	private JDateChooser dateChooser;
	private JComboBox<String> cmbChucVu;



	/**
	 * Create the frame.
	 */
	public QuanLyNhanVienGUI() {
		addControlsNhanVien(); 
		addEventsNhanVien();
		tableModel=(DefaultTableModel) table.getModel();
	}
	
	 private void addControlsNhanVien(){
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
			lblTitle = new MyLabel("Quản Lý Nhân Viên");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
			panel_input.add(lblTitle, BorderLayout.NORTH);
			
			// Panel for dien thong tin
			panel_dienThongTin = new MyPanel();
			panel_input.add(panel_dienThongTin,BorderLayout.CENTER);
			panel_dienThongTin.setLayout(new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));
			
			// Panel for maNV
			pnMaNV = new MyPanelSecond();
			txtMaNV = new MyTextField();
			txtMaNV.setFocusable(false); 
			lblMaNV = new MyLabelSecond("Mã Nhân Viên");
			pnMaNV.add(lblMaNV);
			pnMaNV.add(txtMaNV);
			
			// Panel for tenNV
			pnTenNV = new MyPanelSecond();
			txtTenNV = new MyTextField();
			lblTenNV = new MyLabelSecond("Tên Nhân Viên");
			pnTenNV.add(lblTenNV);
			pnTenNV.add(txtTenNV);
	 		
			// Panel for ngaySinh
			pnNgaySinh = new MyPanelSecond();
			lblNgaySinh = new MyLabelSecond("Ngày Sinh");
			dateChooser = new JDateChooser();
			dateChooser.setPreferredSize(new Dimension(180, 30));
			dateChooser.setForeground(Color.BLUE); 
			dateChooser.setFont(new Font("Arial", Font.BOLD, 15));
			pnNgaySinh.add(lblNgaySinh);
			pnNgaySinh.add(dateChooser);

			
			// Panel for gioiTinh
			pnGioiTinh = new MyPanelSecond();
			lblGioiTinh = new MyLabelSecond("Giới Tính ");
			
		    ButtonGroup gioiTinhGroup = new ButtonGroup();
		      
		   // Radio button for Nam
		    rdoBtn_Nam = new JRadioButton("Nam");
		    rdoBtn_Nam.setFont(new Font("Arial", Font.BOLD, 15));
		    rdoBtn_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
		    rdoBtn_Nam.setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		    rdoBtn_Nam.setPreferredSize(new Dimension(125, 30));
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
			
			// Panel for Chức Vụ
			pnChucVu = new MyPanelSecond();
			cmbChucVu = new JComboBox<String>();
			loadDataCmbChucVu();
			cmbChucVu.setPreferredSize(new Dimension(180, 30));
			lblChucVu = new MyLabelSecond("Chức Vụ");
			pnChucVu.add(lblChucVu);
			pnChucVu.add(cmbChucVu);
			
			panel_dienThongTin.add(pnMaNV);
			panel_dienThongTin.add(pnTenNV);
			panel_dienThongTin.add(pnNgaySinh);
			panel_dienThongTin.add(pnGioiTinh);
			panel_dienThongTin.add(pnSoDT);
			panel_dienThongTin.add(pnChucVu);
			
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
			lblTimKiem.setFont(new Font("Arial", Font.PLAIN, 15));
			lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
			lblTimKiem.setPreferredSize(new Dimension(100, 30));
			pnChuaTimKiem.add(lblTimKiem);
			
			 // Text field for search
			 txtTimKiem = new MyTextField();
			txtTimKiem.setPreferredSize(new Dimension(220, 30));
			pnChuaTimKiem.add(txtTimKiem);
			pnTimKiem.add(pnChuaTimKiem);
			
			pnBtnTimKiem = new MyPanelSecond();
			pnBtnTimKiem.setPreferredSize(new Dimension(130, 40));
	        pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
	        pnTimKiem.add(pnBtnTimKiem);
	        
	        btnTimKiem = new  MyButton("Tìm kiếm");
	        btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
	        btnTimKiem.setIcon(new ImageIcon("images/search.png"));
	        pnBtnTimKiem.add(btnTimKiem);
	        
	        //Panel for buttons
	        pnButton = new MyPanelSecond();
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
	        
	        btnNhap = new MyButton("Nhập");
	        btnNhap.setIcon(new ImageIcon("images/excel.png"));
	        btnNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        
	        btnXuat = new MyButton("Xuất");
	        btnXuat.setIcon(new ImageIcon("images/excel.png"));
	        btnXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        
	        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa);
	        pnButton.add(btnReset);pnButton.add(btnNhap);pnButton.add(btnXuat);
	        
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
	        tableModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT", "Chức Vụ", "Trạng Thái"});
	        table = new MyTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
	        panel_table.setLayout(new BorderLayout(0, 0));
	        panel_table.add(scrollPane, BorderLayout.NORTH);
	        

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
			  txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
		            @Override
		            public void insertUpdate(DocumentEvent e) {
		            	xuLyTimKiemNhanVien();
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		            	xuLyTimKiemNhanVien();
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		            	xuLyTimKiemNhanVien();
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
		        btnXuat.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	xuLyXuatExcel();
		            }
		        });
		        
		        btnNhap.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	xuLyNhapExcel();
		            }
		        });
		  }
		  
		  private void xuLyReset(){
		    	
	         loadDataTblNhanVien();
	         txtMaNV.setText("");
	         txtTenNV.setText("");
	         txt_soDT.setText("");
	         dateChooser.setDate(null);
	         rdoBtn_Nam.setSelected(true);
	         cmbChucVu.setSelectedIndex(0);
		  }

			private void xuLyXoaNhanVien() {
				String ma=txtMaNV.getText();
				boolean flag =nhanVienBUS.xoaNhanVien(ma);
				if(flag) {
					nhanVienBUS.docDanhSach();
					loadDataTblNhanVien();
					 btnReset.doClick();
				}
			}
			
			private void xuLySuaNhanVien() {

			    String ngaySinh = "";
			    // Lấy ngày sinh từ dateChooser
			    if (dateChooser.getDate() != null) {
			        // Chuyển định dạng ngày tháng năm thành yyyy-MM-dd
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        ngaySinh = dateFormat.format(dateChooser.getDate());
			    }
			
			    int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
			    
			    int selectedItem=cmbChucVu.getSelectedIndex();
			    
			    if (nhanVienBUS.suaNhanVien(txtMaNV.getText(), txtTenNV.getText(), ngaySinh, gioiTinh, txt_soDT.getText(), cmbChucVu.getItemAt(selectedItem))) {
			        nhanVienBUS.docDanhSach();
			    	btnReset.doClick();
			    }
			}
			
			
			private void xuLyThemNhanVien() {
			 if (!rdoBtn_Nam.isSelected() && !rdoBtn_Nu.isSelected()) {
			     JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
			     return;
			 }
			
			 String ngaySinh = "";
			 if (dateChooser.getDate() != null) {
			     // Chuyển định dạng ngày tháng năm thành yyyy-MM-dd
			     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			     ngaySinh = dateFormat.format(dateChooser.getDate());
			 }
			 int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
			 
			 int selectedItem=cmbChucVu.getSelectedIndex();
			
			 if(nhanVienBUS.themNhanVien(txtTenNV.getText(), ngaySinh, gioiTinh, txt_soDT.getText(), cmbChucVu.getItemAt(selectedItem))) {
			     nhanVienBUS.docDanhSach();
			     btnReset.doClick();
			 }
			}
			
			
			private void xuLyTimKiemNhanVien() {
			  
			   	tableModel.setRowCount(0);
			   
			   ArrayList<NhanVien> dsnv = nhanVienBUS.timNhanVien(txtTimKiem.getText());
			   for (NhanVien nv : dsnv) {
			       Object[] rowData = new Object[6];
			       rowData[0] = nv.getMaNV();
			       rowData[1] = nv.getTen();
			       rowData[2] = nv.getNgaySinh();
			       rowData[3] = nv.getGioiTinh()==1?"Nam":"Nữ";
			       rowData[4] = nv.getSoDT();
			       rowData[5] = nv.getChucVu();
			       tableModel.addRow(rowData);
			   }
			}
			
			private void loadDataCmbChucVu() {
				cmbChucVu.removeAllItems();
				
				ArrayList<phanquyen_DTO> dspq;
				try {
					dspq = pqbus.getData();
					for(phanquyen_DTO pq : dspq) {
						cmbChucVu.addItem(pq.getTenPhanQuyen());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		            String chucVu = table.getValueAt(row, 5).toString();

		            txtMaNV.setText(maNV);
		            txtTenNV.setText(tenNV);
		            txt_soDT.setText(soDT);
		            
		            int index=-1;
		            for(int i=0; i< cmbChucVu.getItemCount();i++) {
		            	if(cmbChucVu.getItemAt(i).equals(chucVu)) {
		            		index=i;
		            		break;
		            	}
		            }
		            
		            if(index!=-1) {
		            	cmbChucVu.setSelectedIndex(index);
		            }
		            
		            try {
		            	Date date =new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
		            	dateChooser.setDate(date);
		            }catch (Exception e) {
		                e.printStackTrace();
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
		            Object[] rowData = new Object[7];

		            rowData[0] = nv.getMaNV();
		            rowData[1] = nv.getTen();
		            rowData[2] = nv.getNgaySinh();
		            rowData[3] = nv.getGioiTinh()==1?"Nam":"Nữ";
		            rowData[4] = nv.getSoDT();		            
		            rowData[5] = nv.getChucVu();
		            int trangThai=taiKhoanBUS.getTrangThai(nv.getIdTaiKhoan()+"");
		            rowData[6] =trangThai;
		            if(trangThai == 0) {
		            	rowData[6] = "Khoá";
		            }
		            else if(trangThai == 1) {
		            	rowData[6] = "Hiệu lực";
		            }
		            else {
		            	rowData[6] = "Chưa có";
		            }
		            tableModel.addRow(rowData);
		        }
		        
		    }
		 
		 private void xuLyXuatExcel() {
		        XuLyFileExcel xuatExcel = new XuLyFileExcel();
		        xuatExcel.xuatExcel(table);
		 }
		 
		 private void xuLyNhapExcel() {
			 int result = JOptionPane.showConfirmDialog(null, "Dữ liệu cũ sẽ bị xoá, tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			 if (result != JOptionPane.YES_OPTION) {
			     return;
			 }
			 XuLyFileExcel nhapExcel = new  XuLyFileExcel();
			 nhapExcel.nhapExcel(table);
			 
			 int row=table.getRowCount();
			 for (int i=0;i<row;i++) {
		            String tenNV = table.getValueAt(i, 1).toString();
		            String ngaySinh = table.getValueAt(i, 2).toString();
		            int gioiTinh;
		            if(table.getValueAt(i, 3)=="Nam") {
		            	gioiTinh=1;
		            }else {
		            	gioiTinh=0;
		            } 
		            String soDT = table.getValueAt(i, 4).toString();
		            String chucVu = table.getValueAt(i, 5).toString();
		            
		            nhanVienBUS.nhapExcel(tenNV, ngaySinh, gioiTinh, soDT, chucVu);
			 }
		 }
}