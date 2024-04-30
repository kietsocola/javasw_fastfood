package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungCap_BUS;
import Custom.MyButton;
import Custom.MyPanel;
import Custom.MyPanelSecond;
import Custom.MyTable;
import DTO.NhaCungCap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuanLyNhaCungCapGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private NhaCungCap_BUS nccbus=new NhaCungCap_BUS();
	private NhaCungCap nhaCungCapChon = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhaCungCapGUI dialog = new QuanLyNhaCungCapGUI();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	
	private MyPanelSecond pnTitle,panel_table,pnBtn,contentPane ;
	private MyTable table;
	private MyButton btnChon,btnThem, btnSua;
	
	 public NhaCungCap getNhaCungCap() {
	        return nhaCungCapChon;
	    }
	
	public QuanLyNhaCungCapGUI() {
		addControlsNCC();
		 this.setLocationRelativeTo(null);
		 this.setModal(true);
	     this.setResizable(false);
		tableModel=(DefaultTableModel) table.getModel();
	}
	
	public void addControlsNCC() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane = new MyPanelSecond();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		 pnTitle = new MyPanelSecond();
		
		 panel_table = new MyPanelSecond();
		 
		 pnBtn = new MyPanelSecond();
		

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(pnBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(pnTitle, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(panel_table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(pnBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                
        );

		
		JLabel lblTitle = new JLabel("Chọn Nhà Cung Cấp");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnTitle.add(lblTitle);
		contentPane.setLayout(gl_contentPane);
		
		
		contentPane.add(panel_table);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã NCC", "Tên NCC", "Số ĐT", "Địa Chỉ"});
        table = new MyTable(tableModel);
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(453, 150)); 
        panel_table.setLayout(new BorderLayout());
        panel_table.add(scrollPane, BorderLayout.CENTER);
        
		
		
		btnChon = new MyButton("Chọn");
		btnThem = new MyButton("Thêm mới");
		btnSua = new MyButton("Sửa thông tin");

		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnChon.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			btnChonNCCActionPerformed(evt);
        }
    });
		
		btnThem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnThemNCCActionPerformed(evt);
	            }
	     });

		
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaNCCActionPerformed(evt);
	        }

	    });
 GroupLayout gl_pnBtn = new GroupLayout(pnBtn);
 gl_pnBtn.setHorizontalGroup(
 	gl_pnBtn.createParallelGroup(Alignment.LEADING)
 		.addGroup(gl_pnBtn.createSequentialGroup()
 			.addGap(41)
 			.addComponent(btnChon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addPreferredGap(ComponentPlacement.UNRELATED)
 			.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addPreferredGap(ComponentPlacement.RELATED)
 			.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addGap(46))
 );
 gl_pnBtn.setVerticalGroup(
 	gl_pnBtn.createParallelGroup(Alignment.TRAILING)
 		.addGroup(gl_pnBtn.createSequentialGroup()
 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 			.addGroup(gl_pnBtn.createParallelGroup(Alignment.BASELINE)
 				.addComponent(btnChon, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
 				.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
 				.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
 			.addContainerGap())
 );
 pnBtn.setLayout(gl_pnBtn);
 
 pack();
	        
	    loadTableNhaCungCap();
	}
	
	 private void loadTableNhaCungCap() {
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
	 

	 
	 private void btnChonNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNCCActionPerformed
	        int row = table.getSelectedRow();
	        if (row < 0) {
	        	JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        int maNCC = Integer.parseInt(table.getValueAt(row, 0) + "");
	        String tenNCC = table.getValueAt(row, 1) + "";
	        String diaChi = table.getValueAt(row, 2) + "";
	        String soDT = table.getValueAt(row, 3) + "";
	        nhaCungCapChon = new NhaCungCap(maNCC, tenNCC, diaChi, soDT);
	        this.dispose();
	    }
	
	 private void btnThemNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNCCActionPerformed
		 DlgThemNhaCungCap dlg =new DlgThemNhaCungCap();
		dlg.setVisible(true);
		if(dlg.getCheckThemNCC()) {
			loadTableNhaCungCap();
		}
	 }
	 
	 private void btnSuaNCCActionPerformed(java.awt.event.ActionEvent evt) {
		 int row = table.getSelectedRow();
	     if (row < 0) {
	       JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin muốn sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	       return;
	     }
	     
	     NhaCungCap ncc=new NhaCungCap();
	     ncc.setMaNCC(Integer.parseInt(table.getValueAt(row, 0)+""));
	     ncc.setTenNCC(table.getValueAt(row, 1)+"");
	     ncc.setSoDT(table.getValueAt(row, 2)+"");
	     ncc.setDiaChi(table.getValueAt(row, 3)+"");
	     
	     DlgSuaNhaCungCap dlg = new DlgSuaNhaCungCap(ncc);
	     dlg.setVisible(true);
	     if(dlg.getCheckSuaNCC()) {
	    	 loadTableNhaCungCap();
	     }
	        
	 }
	 
}
