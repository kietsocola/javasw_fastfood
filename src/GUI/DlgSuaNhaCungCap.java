package GUI;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.NhaCungCap_BUS;
import Custom.MyButton;
import Custom.MyPanel;

import DTO.NhaCungCap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import javax.swing.JTextField;

public class DlgSuaNhaCungCap extends JDialog {

	private JPanel contentPane;
	private MyPanel pnTitle;
	private MyButton btnLuu, btnHuy;
	private JTextField txtSoDT;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtMaNCC;
	private boolean checkSuaNCC = false;

    public boolean getCheckSuaNCC() {
        return checkSuaNCC;
    }
    
	public DlgSuaNhaCungCap(NhaCungCap ncc) {
		checkSuaNCC = false;
		addControlsNCC();
		 this.setLocationRelativeTo(null);
		 this.setModal(true);
	     this.setResizable(false);
	     
	     txtMaNCC.setText(ncc.getMaNCC()+"");
	     txtTenNCC.setText(ncc.getTenNCC());
	     txtSoDT.setText(ncc.getSoDT());
	     txtDiaChi.setText(ncc.getDiaChi());
	}
	
	

	public void addControlsNCC() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 524, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		
		 pnTitle = new MyPanel();
		
		 JPanel pnBtn = new JPanel();
        
        JPanel panel = new JPanel();
		
		
		
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addComponent(pnBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnBtn, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        txtMaNCC = new JTextField();
        txtMaNCC.setEditable(false);
        txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMaNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã NCC"));
        txtMaNCC.setColumns(15);
        
        txtTenNCC = new JTextField();
        txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtTenNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên NCC"));
        txtTenNCC.setColumns(15);
        txtTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNCCActionPerformed(evt);
            }
        });
        
        txtSoDT = new JTextField();
        txtSoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtSoDT.setBorder(javax.swing.BorderFactory.createTitledBorder("Điện thoại"));
        txtSoDT.setColumns(15);
        txtSoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiNCCActionPerformed(evt);
            }
        });
        
        
        txtDiaChi = new JTextField();
        txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder("Địa Chỉ"));
        txtDiaChi.setColumns(15);
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiNCCActionPerformed(evt);
            }
        });
        
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txtSoDT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(txtDiaChi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(txtMaNCC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(txtTenNCC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(txtMaNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtTenNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel.setLayout(gl_panel);

		
		JLabel lblTitle = new JLabel("Sửa Thông Tin Nhà Cung Cấp");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTitle.add(lblTitle);
		contentPane.setLayout(gl_contentPane);

	
		btnLuu = new MyButton("Lưu");
		btnHuy = new MyButton("Huỷ");

		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnLuuActionPerformed(evt);
            }
        });
		
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
 GroupLayout gl_pnBtn = new GroupLayout(pnBtn);
 gl_pnBtn.setHorizontalGroup(
 	gl_pnBtn.createParallelGroup(Alignment.LEADING)
 		.addGroup(gl_pnBtn.createSequentialGroup()
 			.addGap(111)
 			.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addGap(32)
 			.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addGap(117))
 );
 gl_pnBtn.setVerticalGroup(
 	gl_pnBtn.createParallelGroup(Alignment.TRAILING)
 		.addGroup(gl_pnBtn.createSequentialGroup()
 			.addContainerGap(21, Short.MAX_VALUE)
 			.addGroup(gl_pnBtn.createParallelGroup(Alignment.BASELINE)
 				.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
 				.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
 			.addContainerGap())
 );
 pnBtn.setLayout(gl_pnBtn);
	        
	    pack();
	}
	
	 private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
		 NhaCungCap_BUS nccbus=new NhaCungCap_BUS();
		 checkSuaNCC=nccbus.suaNCC(txtMaNCC.getText(),txtTenNCC.getText(), txtSoDT.getText(), txtDiaChi.getText());
		 if(checkSuaNCC) {
			 this.dispose();
		 }
	 }
	
	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

	private void txtTenNCCActionPerformed(java.awt.event.ActionEvent evt) {
        txtSoDT.requestFocus();
    }
	
	 private void txtDienThoaiNCCActionPerformed(java.awt.event.ActionEvent evt) {
	        txtDiaChi.requestFocus();
	}
	 private void txtDiaChiNCCActionPerformed(java.awt.event.ActionEvent evt) {
	        btnLuu.doClick();
	}
}
