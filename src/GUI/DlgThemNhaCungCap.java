package GUI;

import java.awt.BorderLayout;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.NhaCungCap_BUS;
import Custom.MyButton;
import Custom.MyPanel;
import Custom.MyPanelSecond;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;



import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgThemNhaCungCap extends JDialog {


	private MyPanelSecond pnTitle,pnTxt,pnBtn,contentPane ;
	private MyButton btnThem, btnHuy;
	private JTextField txtSoDT,txtTenNCC,txtDiaChi;
	private boolean checkThemNCC = false;

    public boolean getCheckThemNCC() {
        return checkThemNCC;
    }
	
	public DlgThemNhaCungCap() {
		checkThemNCC = false;
		addControlsNCC();
		 this.setLocationRelativeTo(null);
		 this.setModal(true);
	     this.setResizable(false);
	}
	
	public void addControlsNCC() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		contentPane = new MyPanelSecond();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 490, 325);	
		setContentPane(contentPane);
		
		 pnTitle = new MyPanelSecond();
		
		 pnBtn = new MyPanelSecond();
        
		 pnTxt = new MyPanelSecond();

        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(pnTxt, 0, 0, Short.MAX_VALUE)
        				.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(pnBtn, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(50))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnTxt, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        
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
                txtDienThoaiActionPerformed(evt);
            }
        });
        
        txtDiaChi = new JTextField();
        txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder("Địa Chỉ"));
        txtDiaChi.setColumns(15);
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });
        
        GroupLayout gl_panel = new GroupLayout(pnTxt);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtDiaChi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        				.addComponent(txtSoDT, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        				.addComponent(txtTenNCC, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(txtTenNCC, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(7))
        );
        pnTxt.setLayout(gl_panel);

		
		JLabel lblTitle = new JLabel("Thêm Mới Nhà Cung Cấp");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnTitle.add(lblTitle);
		contentPane.setLayout(gl_contentPane);

	
		btnThem = new MyButton("Thêm");
		btnHuy = new MyButton("Huỷ");

		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnThemActionPerformed(evt);
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
 			.addGap(94)
 			.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addGap(33)
 			.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
 			.addGap(103))
 );
 gl_pnBtn.setVerticalGroup(
 	gl_pnBtn.createParallelGroup(Alignment.TRAILING)
 		.addGroup(gl_pnBtn.createSequentialGroup()
 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 			.addGroup(gl_pnBtn.createParallelGroup(Alignment.BASELINE)
 				.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
 				.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
 			.addContainerGap())
 );
 pnBtn.setLayout(gl_pnBtn);
	        
	}
	
	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
		NhaCungCap_BUS nccbus = new NhaCungCap_BUS();
		checkThemNCC = nccbus.themNCC(txtTenNCC.getText(), txtSoDT.getText(), txtDiaChi.getText());
        if (checkThemNCC) {
            this.dispose();
        }
	}
	
	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
	
	private void txtTenNCCActionPerformed(java.awt.event.ActionEvent evt) {
		txtSoDT.requestFocus();
    }

	private void txtDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {
		txtDiaChi.requestFocus();
    }
	
    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {
    	btnThem.doClick();
    }

    
	
	

}
