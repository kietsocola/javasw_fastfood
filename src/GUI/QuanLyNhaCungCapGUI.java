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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungCap_BUS;
import Custom.*;
import DTO.NhaCungCap;
import javax.swing.ImageIcon;



public class QuanLyNhaCungCapGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	 private NhaCungCap_BUS nccbus = new NhaCungCap_BUS();

	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyNhaCungCapGUI frame = new QuanLyNhaCungCapGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private MyPanel  panel_main, panel_input, panel_dienThongTin;
	private MyTable table;
	private MyPanelSecond pnMaNCC,pnTenNCC,pnSoDT, pnDiaChi,pnButton,pnTimKiem, pnChuaTimKiem, pnBtnTimKiem ;
	private MyLabel lblTitle;
	private MyLabelSecond lblMaNCC, lblTenNCC,lblSoDT,lblDiaChi,lblTimKiem;
	private MyButton btnThem, btnXoa, btnSua, btnReset, btnTimKiem;
	private MyTextField txtMaNCC, txtTenNCC, txt_soDT,txtDiaChi, txtTimKiem;

	/**
	 * Create the frame.
	 */
	public QuanLyNhaCungCapGUI() {
		addControlsNCC(); 
		addEventsNCC();
		tableModel=(DefaultTableModel) table.getModel();

	}
	 private void addControlsNCC(){
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
			lblTitle = new MyLabel("Quản Lý Nhà Cung Cấp");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
			panel_input.add(lblTitle, BorderLayout.NORTH);
			
			// Panel for dien thong tin
			panel_dienThongTin = new MyPanel();
			panel_input.add(panel_dienThongTin,BorderLayout.CENTER);
			panel_dienThongTin.setLayout(new BoxLayout(panel_dienThongTin, BoxLayout.Y_AXIS));
			
			// Panel for maNV
			pnMaNCC = new MyPanelSecond();
			txtMaNCC = new MyTextField();
			txtMaNCC.setFocusable(false);
			lblMaNCC = new MyLabelSecond("Mã NCC");
			pnMaNCC.add(lblMaNCC);
			pnMaNCC.add(txtMaNCC);
			 
			
			// Panel for tenNV
			pnTenNCC = new MyPanelSecond();
			txtTenNCC = new MyTextField();
			lblTenNCC = new MyLabelSecond("Tên NCC");
			pnTenNCC.add(lblTenNCC);
			pnTenNCC.add(txtTenNCC);
		      
		   // Panel for soDT
			pnSoDT = new MyPanelSecond();
			txt_soDT = new MyTextField();
			lblSoDT = new MyLabelSecond("Số Điện Thoại");
			pnSoDT.add(lblSoDT);
			pnSoDT.add(txt_soDT);
			
			// Panel for soDT
			pnDiaChi = new MyPanelSecond();
			txtDiaChi = new MyTextField();
			lblDiaChi = new MyLabelSecond("Địa Chỉ");
			pnDiaChi.add(lblDiaChi);
			pnDiaChi.add(txtDiaChi);
			
			panel_dienThongTin.add(pnMaNCC);
			panel_dienThongTin.add(pnTenNCC);
			panel_dienThongTin.add(pnSoDT);
			panel_dienThongTin.add(pnDiaChi);
			
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
	        pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
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
	        tableModel.setColumnIdentifiers(new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số ĐT", "Địa Chỉ"});
	        table = new MyTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setPreferredSize(new Dimension(453, 150)); 
	        panel_table.setLayout(new BorderLayout(0, 0));
	        panel_table.add(scrollPane, BorderLayout.NORTH);
	        

	        loadDataTblNCC();

		}
	 
	 private void addEventsNCC() {
		  table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyClickTblNCC();
				
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
	            	xuLyTimKiemNCC();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	xuLyTimKiemNCC();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	            	xuLyTimKiemNCC();
	            }
	        });

		  	
	        btnTimKiem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	xuLyTimKiemNCC();
	            }
	        });
		  
	        btnThem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                xuLyThemNCC();
	            }
	        });

	        btnSua.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                xuLySuaNCC();
	            }
	        });

	        btnXoa.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	xuLyXoaNCC();
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
        loadDataTblNCC();
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txt_soDT.setText("");
        txtDiaChi.setText("");
	  }
	  

			private void xuLyTimKiemNCC() {
				  
			   	tableModel.setRowCount(0);
			   
			   ArrayList<NhaCungCap> dsncc = nccbus.timNCC(txtTimKiem.getText());
			   for (NhaCungCap ncc : dsncc) {
			       Object[] rowData = new Object[4];
			       rowData[0] = ncc.getMaNCC();
			       rowData[1] = ncc.getTenNCC();
			       rowData[2] = ncc.getSoDT();
			       rowData[3] = ncc.getSoDT();
			       tableModel.addRow(rowData);
			   }
			}
		
		private void xuLyThemNCC() {
			if (txtTenNCC.getText().isEmpty() && txt_soDT.getText().isEmpty() && txtDiaChi.getText().isEmpty() ) {
			    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			    return;
			}

		 if(nccbus.themNCC(txtTenNCC.getText(), txt_soDT.getText(),txtDiaChi.getText())) {
			 nccbus.docDS();
		     btnReset.doClick();
		 }
		}
		
		private void xuLySuaNCC() {
			 if(nccbus.suaNCC(txtMaNCC.getText(),txtTenNCC.getText(), txt_soDT.getText(), txtDiaChi.getText())) {
				 nccbus.docDS();
			     btnReset.doClick();
			 }
		}
		
		private void xuLyXoaNCC() {
			
			boolean flag =nccbus.xoaNCC(txtMaNCC.getText());
			if(flag) {
				nccbus.docDS();
				loadDataTblNCC();
				 btnReset.doClick();
			}
		}

		
	  
	  private void xuLyClickTblNCC() {
	        int row = table.getSelectedRow();
	        if (row > -1) {
	            String maNV = table.getValueAt(row, 0).toString();
	            String tenNV = table.getValueAt(row, 1).toString();
	            String soDT = table.getValueAt(row, 2).toString();
	            String diaChi = table.getValueAt(row, 3).toString();

	            txtMaNCC.setText(maNV);
	            txtTenNCC.setText(tenNV);
	            txt_soDT.setText(soDT);
	            txtDiaChi.setText(diaChi);

	        }
	    }

	 
	 private void loadDataTblNCC() {	    
		    
		 tableModel.setRowCount(0);
		 nccbus.docDS();
		 ArrayList<NhaCungCap> dsncc=nccbus.getListNhaCungCap();
		 
		 for(NhaCungCap ncc : dsncc) {
			 Object[] row= new Object[4];
			 
			 row[0]=ncc.getMaNCC();
			 row[1]=ncc.getTenNCC();
			 row[2]=ncc.getSoDT();
			 row[3]=ncc.getDiaChi();
			 
			 tableModel.addRow(row);
			 
		 }
	    }


}
