package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import Custom.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import BUS.KhuyenMaiBUS;
import DTO.ChiTietHoaDon;
import DTO.KhuyenMai;

import java.awt.Component;
import java.awt.ComponentOrientation;
public class KhuyenMaiGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyPanelSecond pnTimKiem, pnChuaTimKiem, pnBtnTimKiem;
	private JPanel contentPane;
	private JTable tblkhuyenmai;
	private DefaultTableModel dtmKhuyenMai;
	private MyLabelSecond lblMaSP, lblTenSP, lblLoaiSP, lblSoLuong,lblCongThuc, lblDonGia, lblTimKiem;
	private MyButton btnThem,btnXoa,btnSua,btnTimKiem;
	private MyTextField txtMaKM, txtTenKM, txtSoLuong,txtCongThuc, txtPhanTram, txtTimKiem;
	private JComboBox<String> cmbLoaiSP;
	private KhuyenMaiBUS kmBUS = new KhuyenMaiBUS();
	private MyButton btnResfresh;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					khuyenmaiGUI frame = new khuyenmaiGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public KhuyenMaiGUI() {
		addControlskhuyenmai();
		addEventsKhuyenMai();
	}
	public void addControlskhuyenmai() {
		this.setLayout(new BorderLayout());
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);
		
		panel_main.setLayout(new BorderLayout(0, 0));
// ------------------------------------------------------------------------------------------------------		
		MyPanel pnContainInput = new MyPanel();
		pnContainInput.setLayout(new BorderLayout(10, 10));
		MyPanel pnSpace = new MyPanel();
		pnContainInput.add(pnSpace, BorderLayout.EAST);
		MyPanel pnSpace1 = new MyPanel();
		pnContainInput.add(pnSpace1, BorderLayout.WEST);
		
		MyPanel panel_input = new MyPanel();
		pnContainInput.add(panel_input, BorderLayout.CENTER);
		panel_main.add(pnContainInput, BorderLayout.NORTH);
		panel_input.setLayout(new BorderLayout(15, 15));
		
		MyLabel lblTitle = new MyLabel("Quản lý khuyến mãi");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblTitle, BorderLayout.NORTH);
		
		MyPanelSecond pnInputOptions = new MyPanelSecond();
		panel_input.add(pnInputOptions,BorderLayout.CENTER);
		pnInputOptions.setLayout(new BoxLayout(pnInputOptions, BoxLayout.Y_AXIS));
		
		MyPanelSecond pnMaSP = new MyPanelSecond();
		txtMaKM = new MyTextField();
		txtMaKM.setEnabled(false);
		lblMaSP = new MyLabelSecond("Mã KM");
		pnMaSP.add(lblMaSP);
		pnMaSP.add(txtMaKM);
		
		MyPanelSecond pnTenKM = new MyPanelSecond();
		txtTenKM = new MyTextField();
		lblTenSP = new MyLabelSecond("Tên KM");
		pnTenKM.add(lblTenSP);
		pnTenKM.add(txtTenKM);
 		
		MyPanelSecond pnPhanTram = new MyPanelSecond();
		lblLoaiSP = new MyLabelSecond("Phần trăm");
		pnPhanTram.add(lblLoaiSP);
		txtPhanTram = new MyTextField();
		pnPhanTram.add(txtPhanTram);
		
//		MyPanelSecond pnSoLuong = new MyPanelSecond();
//		txtSoLuong = new MyTextField();
//		lblSoLuong = new MyLabelSecond("Ngày bắt đầu");
//		pnSoLuong.add(lblSoLuong);
//		pnSoLuong.add(txtSoLuong);
//		
//		MyPanelSecond pnCongThuc = new MyPanelSecond();
//		txtCongThuc = new MyTextField();
//		lblCongThuc = new MyLabelSecond("Ngày kết thúc");
//		pnCongThuc.add(lblCongThuc);
//		pnCongThuc.add(txtCongThuc);
		
		
		pnInputOptions.add(pnMaSP);
		pnInputOptions.add(pnTenKM);
		pnInputOptions.add(pnPhanTram);
//		pnInputOptions.add(pnSoLuong);
//		pnInputOptions.add(pnCongThuc);
		
		//Panel Ảnh
		pnTimKiem = new MyPanelSecond();
		pnTimKiem.setPreferredSize(new Dimension(300, 10));
		panel_input.add(pnTimKiem,BorderLayout.EAST);
			
		//Panel for lbl vs txt tìm kiếm
		pnChuaTimKiem = new MyPanelSecond();
		pnChuaTimKiem.setMaximumSize(new Dimension(120, 120));
		pnChuaTimKiem.setPreferredSize(new Dimension(300, 90));
		pnChuaTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		// Label for search
//		lblTimKiem = new MyLabelSecond("Nhập mã");
//		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTimKiem.setPreferredSize(new Dimension(100, 30));
//		pnChuaTimKiem.add(lblTimKiem);
		
		 // Text field for search
//		 txtTimKiem = new MyTextField();
//		txtTimKiem.setPreferredSize(new Dimension(220, 30));
//		pnChuaTimKiem.add(txtTimKiem);
//		pnTimKiem.add(pnChuaTimKiem);
		
//		pnBtnTimKiem = new MyPanelSecond();
//		pnBtnTimKiem.setPreferredSize(new Dimension(130, 40));
//        pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
//        pnTimKiem.add(pnBtnTimKiem);
//        
//        btnTimKiem = new  MyButton("Tìm kiếm");
//        ImageIcon iconTimkiem = new ImageIcon("images/loupe.png");
//		Image img0 = iconTimkiem.getImage();
//		Image newImg0 = img0.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
//		iconTimkiem.setImage(newImg0);
//		btnTimKiem.setIcon(iconTimkiem);
//        pnBtnTimKiem.add(btnTimKiem);
        
        
        //Panel nút
        MyPanelSecond pnButton = new MyPanelSecond();
        pnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnThem = new MyButton("Thêm");
        ImageIcon iconThem = new ImageIcon("images/plus.png");
		Image img = iconThem.getImage();
		Image newImg = img.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconThem.setImage(newImg);
		btnThem.setIcon(iconThem);
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnXoa = new MyButton("Xóa");
        ImageIcon iconXoa = new ImageIcon("images/remove.png");
		Image img1 = iconXoa.getImage();
		Image newImg1 = img1.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconXoa.setImage(newImg1);
		btnXoa.setIcon(iconXoa);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnSua = new MyButton("Cập nhật");
        ImageIcon iconSua = new ImageIcon("images/edit2.png");
		Image img2 = iconSua.getImage();
		Image newImg2 = img2.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconSua.setImage(newImg2);
		btnSua.setIcon(iconSua);
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnResfresh = new MyButton("Làm mới");
        ImageIcon iconRe = new ImageIcon("images/LamMoi.png");
		Image img4 = iconRe.getImage();
		Image newImg4 = img4.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconRe.setImage(newImg4);
		btnResfresh.setIcon(iconRe);
		btnResfresh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa); pnButton.add(btnResfresh);
        
        panel_input.add(pnButton,BorderLayout.SOUTH);
// ------------------------------------------------------------------------------------------------------ 
		// Bảng Sản phẩm
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
	
		dtmKhuyenMai = new DefaultTableModel();
		dtmKhuyenMai.addColumn("Mã khuyến mãi");
		dtmKhuyenMai.addColumn("Tên khuyến mãi");
		dtmKhuyenMai.addColumn("Phần trăm");
		
		tblkhuyenmai = new MyTable();
		tblkhuyenmai.setModel(dtmKhuyenMai);
		loadDataToTblkhuyenmai();
		clickTableKhuyenMai();
		JScrollPane  scrTablekhuyenmai= new JScrollPane(tblkhuyenmai);
		scrTablekhuyenmai.getViewport().setBackground(MyColor.PRIMARY_TEXT_COLOR);
		panel_table.setLayout(new BorderLayout(0, 0));
		panel_table.add(scrTablekhuyenmai, BorderLayout.CENTER);
		MyPanel pnSpace4 = new MyPanel();
		pnContainTable.add(pnSpace4, BorderLayout.SOUTH);
//---------------------------------------------------------------------------------------------		

	}
	
	private void addEventsKhuyenMai() {
		btnResfresh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaKM.setText("");
				txtTenKM.setText("");
				txtPhanTram.setText("");
				loadDataToTblkhuyenmai();
			}
		});
		btnSua.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				updateKhuyenMai();
				loadDataToTblkhuyenmai();
			}
		});
		btnThem.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				themKhuyenMai();
				loadDataToTblkhuyenmai();
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaKhuyenMai();
				txtMaKM.setText("");
				txtTenKM.setText("");
				txtPhanTram.setText("");
			}
		});
	}
	
	
	private void loadDataToTblkhuyenmai() {
		kmBUS.getListKhuyenMai();
		dtmKhuyenMai.setRowCount(0);
		
		ArrayList <KhuyenMai> dskm = kmBUS.getListKhuyenMai();
		
		for (KhuyenMai km : dskm) {
			Vector vec = new Vector();
			vec.add(km.getMaKM());
			vec.add(km.getTenKM());
			vec.add(km.getPhanTramKM());
			vec.add(km.getNgayBatDau());
			vec.add(km.getNgayKetThuc());
			
			dtmKhuyenMai.addRow(vec);
		}
	}
	private void themKhuyenMai() {
		String tenKM = txtTenKM.getText();
		String phantram = txtPhanTram.getText();
		if(!tenKM.trim().equals("") && !phantram.trim().equals("")) {
			if(!phantram.matches("\\b(0*(?:[1-9][0-9]?|100))\\b")) {
				JOptionPane.showMessageDialog(null, "Phần trăm không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			int pt = Integer.parseInt(phantram);
			kmBUS.addKhuyenMai(tenKM, pt);
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	private void clickTableKhuyenMai() {
		ListSelectionModel selectionModel = tblkhuyenmai.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblkhuyenmai.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int maKM = Integer.parseInt(tblkhuyenmai.getValueAt(selectedRow, 0) + "");
					KhuyenMai km = kmBUS.getKhuyenMaiById(maKM);
					if(km != null) {
						txtMaKM.setText(maKM+"");
						txtTenKM.setText(km.getTenKM());
						txtPhanTram.setText(km.getPhanTramKM()+"");
					}
				}
			}
		});
	}
	private void updateKhuyenMai() {
		String tenKM = txtTenKM.getText();
		String phantram = txtPhanTram.getText();
		if(!tenKM.trim().equals("") && !phantram.trim().equals("")) {
			int pt = Integer.parseInt(phantram);
			if(pt<=0) {
				JOptionPane.showMessageDialog(null, "Phần trăm phải lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			int maKM = Integer.parseInt(txtMaKM.getText());
			boolean rs = kmBUS.updateKhuyenMai(tenKM, pt, maKM);
			if(rs) JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(null, "Không có thay đổi gì", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	private void xoaKhuyenMai() {
		String maKM = txtMaKM.getText();
		if(maKM.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		boolean rs = kmBUS.xoaKhuyenMai(Integer.parseInt(maKM));
		if(rs) {
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			loadDataToTblkhuyenmai();
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}