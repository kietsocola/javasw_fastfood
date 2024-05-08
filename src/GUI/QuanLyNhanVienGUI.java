package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import BUS.NhanVien_BUS;
import BUS.phanquyen_BUS;
import BUS.taiKhoan_BUS;
import Custom.MyButton;
import Custom.MyColor;
import Custom.MyLabel;
import Custom.MyLabelSecond;
import Custom.MyPanel;
import Custom.MyPanelSecond;
import Custom.MyTable;
import Custom.MyTextField;
import DTO.NhanVien;
import DTO.phanquyen_DTO;
import DTO.taiKhoan_DTO;

public class QuanLyNhanVienGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private NhanVien_BUS nhanVienBUS = new NhanVien_BUS();
	private taiKhoan_BUS taiKhoanBUS = new taiKhoan_BUS();
	private phanquyen_BUS pqbus = new phanquyen_BUS();

	private MyPanel panel_main, panel_input, panel_dienThongTin;
	private MyTable table;
	private MyPanelSecond pnMaNV, pnTenDN, pnMatKhau, pnTenNV, pnNgaySinh, pnGioiTinh, pnSoDT, pnChucVu, pnButton,
			pnTimKiem, pnChuaTimKiem, pnBtnTimKiem;
	private MyLabel lblTitle;
	private MyLabelSecond lblMaNV, lblTenDN, lblMatKhau, lblTenNV, lblNgaySinh, lblSoDT, lblGioiTinh, lblChucVu,
			lblTimKiem;
	private MyButton btnThem, btnXoa, btnSua, btnReset, btnNhap, btnXuat, btnKhoa, btnTimKiem;
	private MyTextField txtMaNV, txtTenDN, txtMatKhau, txtTenNV, txt_soDT, txtTimKiem;
	private JRadioButton rdoBtn_Nam, rdoBtn_Nu;
	private JDateChooser dateChooser;
	private JComboBox<String> cmbChucVu;

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVienGUI() {
		addControlsNhanVien();
		addEventsNhanVien();
		tableModel = (DefaultTableModel) table.getModel();
	}

	private void addControlsNhanVien() {
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

		// label for tieu de
		lblTitle = new MyLabel("Quản Lý Nhân Viên");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblTitle, BorderLayout.NORTH);

		// Panel for dien thong tin
		panel_dienThongTin = new MyPanel();
		panel_input.add(panel_dienThongTin, BorderLayout.CENTER);
		panel_dienThongTin.setLayout(new GridLayout(1, 2));
		
		MyPanel panel_leftRow = new MyPanel();
		panel_leftRow.setLayout(new GridLayout(4, 1)); 
		
		MyPanel panel_rightRow = new MyPanel();
		panel_rightRow.setLayout(new GridLayout(4, 1));

		// Panel for maNV
		pnMaNV = new MyPanelSecond();
		txtMaNV = new MyTextField();
		txtMaNV.setFocusable(false);
		lblMaNV = new MyLabelSecond("Mã Nhân Viên");
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);

		// Panel for tenDN
		pnTenDN = new MyPanelSecond();
		txtTenDN = new MyTextField();
		lblTenDN = new MyLabelSecond("Tên Đăng nhập");
		pnTenDN.add(lblTenDN);
		pnTenDN.add(txtTenDN);

		// Panel for matKhau
		pnMatKhau = new MyPanelSecond();
		txtMatKhau = new MyTextField();
		lblMatKhau = new MyLabelSecond("Mật khẩu");
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(txtMatKhau);

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

		panel_leftRow.add(pnMaNV);
		panel_leftRow.add(pnTenDN);
		panel_leftRow.add(pnMatKhau);
		panel_leftRow.add(pnTenNV);
	
		
		panel_rightRow.add(pnNgaySinh);
		panel_rightRow.add(pnGioiTinh);
		panel_rightRow.add(pnSoDT);
		panel_rightRow.add(pnChucVu);

		// Thêm các panel con vào panel chính
		panel_dienThongTin.add(panel_leftRow);
		panel_dienThongTin.add(panel_rightRow);

		// Panel for Tìm Kiếm
		pnTimKiem = new MyPanelSecond();
		pnTimKiem.setPreferredSize(new Dimension(300, 10));
		panel_input.add(pnTimKiem, BorderLayout.EAST);

		// Panel for lbl vs txt tìm kiếm
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

		btnTimKiem = new MyButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		ImageIcon iconTimkiem = new ImageIcon("images/loupe.png");
		Image img0 = iconTimkiem.getImage();
		Image newImg0 = img0.getScaledInstance(26, 26, java.awt.Image.SCALE_SMOOTH);
		iconTimkiem.setImage(newImg0);
		btnTimKiem.setIcon(iconTimkiem);
		pnBtnTimKiem.add(btnTimKiem);

		// Panel for buttons
		pnButton = new MyPanelSecond();
		pnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

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
		Image resizedImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và
		// chiều rộng mong muốn
		ImageIcon resizedIcon2 = new ImageIcon(resizedImg2);
		btnXoa.setIcon(resizedIcon2);
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnSua = new MyButton("Sửa");
		ImageIcon icon1 = new ImageIcon("images/edit2.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của
		// bạn
		Image img1 = icon1.getImage();
		Image resizedImg1 = img1.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và
		// chiều rộng mong muốn
		ImageIcon resizedIcon1 = new ImageIcon(resizedImg1);
		btnSua.setIcon(resizedIcon1);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnReset = new MyButton("Reset");
		ImageIcon icon5 = new ImageIcon("images/LamMoi.png"); // Thay đổi "icon.png" bằng đường dẫn đến biểu tượng của
		// bạn
		Image img5 = icon5.getImage();
		Image resizedImg5 = img5.getScaledInstance(25, 25, Image.SCALE_SMOOTH); // Thay đổi 50, 50 thành chiều cao và
		// chiều rộng mong muốn
				ImageIcon resizedIcon5 = new ImageIcon(resizedImg5);
				btnReset.setIcon(resizedIcon5);
				btnReset.setFont(new Font("Arial", Font.PLAIN, 16));
				
		
				btnKhoa = new MyButton("Khoá");
				ImageIcon icon9 = new ImageIcon("images/denied.png");
				Image img9 = icon9.getImage();
				Image resizedImg9 = img9.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				ImageIcon resizedIcon9 = new ImageIcon(resizedImg9);
				btnKhoa.setIcon(resizedIcon9);
				btnKhoa.setFont(new Font("Arial", Font.PLAIN, 16));
				
		
		// nut nhap excel
		btnNhap = new MyButton("Nhập Excel");
		ImageIcon iconNhap = new ImageIcon("images/excel.png");
		Image imgNhap = iconNhap.getImage();
		Image resizedImgNhap = imgNhap.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizedIconNhap = new ImageIcon(resizedImgNhap);
		btnNhap.setIcon(resizedIconNhap);
		btnNhap.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importDataExcel();
			}
		});

		// Nút xuất Excel
		btnXuat = new MyButton("Xuất Excel");
		ImageIcon iconXuat = new ImageIcon("images/excel.png");
		Image imgXuat = iconXuat.getImage();
		Image resizedImgXuat = imgXuat.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizedIconXuat = new ImageIcon(resizedImgXuat);
		btnXuat.setIcon(resizedIconXuat);
		btnXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyXuatExcel();
			}
		});

		
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnReset);
		pnButton.add(btnNhap);pnButton.add(btnXuat);pnButton.add(btnKhoa);

		panel_input.add(pnButton, BorderLayout.SOUTH);

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
	        tableModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Đăng Nhập", "Mật khẩu", "Tên Nhân Viên",
					"Ngày Sinh", "Giới Tính", "Số ĐT", "Chức Vụ", "Trạng Thái"});
	        table = new MyTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setPreferredSize(new Dimension(453, 310)); 
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
		btnKhoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyKhoaNhanVien();
			}
		});
	}

	private void xuLyReset() {
		loadDataTblNhanVien();
		txtMaNV.setText("");
		txtTenNV.setText("");
		txt_soDT.setText("");
		txtTenDN.setText("");
		txtMatKhau.setText("");
		dateChooser.setDate(null);
		rdoBtn_Nam.setSelected(true);
		cmbChucVu.setSelectedIndex(0);
	}

	private void xuLyXoaNhanVien() {
		String ma=txtMaNV.getText();

			   nhanVienBUS.xoaNhanVien(ma) ;
			   taiKhoanBUS.xoaTaiKhoan(nhanVienBUS.getIdTaiKhoan(ma));
			
				nhanVienBUS.docDanhSach();
				taiKhoanBUS.docDanhSach();
			
				 btnReset.doClick();


	}

	private void xuLySuaNhanVien() {
		ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();
	    ArrayList<taiKhoan_DTO> dstk = taiKhoanBUS.getDanhSachTaiKhoan();
	    
	    String ngaySinh = "";
	    // Lấy ngày sinh từ dateChooser
	    if (dateChooser.getDate() != null) {
	        // Chuyển định dạng ngày tháng năm thành yyyy-MM-dd
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        ngaySinh = dateFormat.format(dateChooser.getDate());
	    }
	
	    int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
	    
		 int selectedItem=cmbChucVu.getSelectedIndex();
		 int so;
		 switch (selectedItem) {
		     case 0:
		         so = 2;
		         break;
		     case 1:
		         so = 3;
		         break;
		     case 2:
		         so = 4;
		         break;
		     case 3:
		         so = 5;
		         break;
		     default:
		         so = 2;
		         break;
		 }
	   boolean fad=false;
	   int id=1;
	    for (NhanVien nv : dsnv) {
	    	for(taiKhoan_DTO tk: dstk) {
	    		if (tk.getMa() == nv.getIdTaiKhoan()) {
	    			fad=true;
	    			id=tk.getMa();
	    		}
	    	}
	    }
	    if(fad) {
	    	 if (txtMaNV.getText().isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Vui lòng nhập chọn nhân viên cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
	    	
	    	if(!taiKhoanBUS.kiemTraTaiKhoan2(txtTenDN.getText(), txtMatKhau.getText())){
	    		return;
	    	}
	    	
	    	if(!nhanVienBUS.kiemTraNhanVien2(txtMaNV.getText(),gioiTinh, txt_soDT.getText())){
	    		return;
	    	}
	    	
		    	nhanVienBUS.suaNhanVien(txtMaNV.getText(), txtTenNV.getText(), ngaySinh, gioiTinh, txt_soDT.getText());
    			taiKhoanBUS.suaTaiKhoan(id,txtTenDN.getText(), txtMatKhau.getText(), so);
    			taiKhoanBUS.docDanhSach();
    			nhanVienBUS.docDanhSach();
    			btnReset.doClick();
	    	
	    }
	    

	}

	private void xuLyThemNhanVien() {
		 String ngaySinh = "";
		 if (dateChooser.getDate() != null) {
		     // Chuyển định dạng ngày tháng năm thành yyyy-MM-dd
		     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		     ngaySinh = dateFormat.format(dateChooser.getDate());
		 }
		 int gioiTinh = rdoBtn_Nam.isSelected() ? 1 : 0;
		 
		 int selectedItem=cmbChucVu.getSelectedIndex();
		 int so;
		 switch (selectedItem) {
		     case 0:
		         so = 2;
		         break;
		     case 1:
		         so = 3;
		         break;
		     case 2:
		         so = 4;
		         break;
		     case 3:
		         so = 5;
		         break;
		     default:
		         so = 2;
		         break;
		 }
		 
		 if (txtTenDN.getText().isEmpty() && txtMatKhau.getText().isEmpty() && txtTenNV.getText().isEmpty() && txt_soDT.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 
		 if(!taiKhoanBUS.kiemTraTaiKhoan(txtTenDN.getText(), txtMatKhau.getText()) ) {
			 return;
		 }
		 if(!nhanVienBUS.kiemTraNhanVien(txtTenNV.getText(), gioiTinh, txt_soDT.getText())) {
			 return;
		 }

		
		 if(taiKhoanBUS.themTaiKhoan(txtTenDN.getText(), txtMatKhau.getText(),so) ) {
			 taiKhoanBUS.docDanhSach();
			 int idTaiKhoan=taiKhoanBUS.idTaiKhoanMax();
			 
			 if(nhanVienBUS.themNhanVien(txtTenNV.getText(), ngaySinh, gioiTinh, txt_soDT.getText(),idTaiKhoan,1)) {
			     nhanVienBUS.docDanhSach();

			     btnReset.doClick();
			 }
		 }
		 
		
		}


	private void xuLyTimKiemNhanVien() {
		  
	   	tableModel.setRowCount(0);
	   
	   ArrayList<NhanVien> dsnv = nhanVienBUS.timNhanVien(txtTimKiem.getText());
	   for (NhanVien nv : dsnv) {
		   Object[] rowData = new Object[9];

	        rowData[0] = nv.getMaNV();
	        rowData[1]=taiKhoanBUS.getTenDangNhap(nv.getIdTaiKhoan());
	        rowData[2]=taiKhoanBUS.getMatKhau(nv.getIdTaiKhoan());
	        rowData[3] = nv.getTen();
	        rowData[4] = nv.getNgaySinh();
	        rowData[5] = nv.getGioiTinh() == 1 ? "Nam" : "Nữ";
	        rowData[6] = nv.getSoDT();		            
	        rowData[7] = taiKhoanBUS.getTenQuyen(nv.getIdTaiKhoan());
	        int trangThai = taiKhoanBUS.getTrangThai(nv.getIdTaiKhoan());
	        rowData[8] = (trangThai == 0) ? "Khoá" : ((trangThai == 1) ? "Hiệu lực" : "Chưa có");
	       tableModel.addRow(rowData);
	   }
	}


	private void loadDataCmbChucVu() {
		cmbChucVu.removeAllItems();

		ArrayList<phanquyen_DTO> dspq;
		try {
			dspq = pqbus.getData();
			for (phanquyen_DTO pq : dspq) {
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
            String tenDN = table.getValueAt(row, 1).toString();
            String matKhau = table.getValueAt(row, 2).toString();
            String tenNV = table.getValueAt(row, 3).toString();
            String ngaySinh = table.getValueAt(row, 4).toString();
            String gioiTinh = table.getValueAt(row, 5).toString();
            String soDT = table.getValueAt(row, 6).toString();
            String chucVu = table.getValueAt(row, 7).toString();

            txtMaNV.setText(maNV);
            txtTenNV.setText(tenNV);
            txt_soDT.setText(soDT);
            txtTenDN.setText(tenDN);
            txtMatKhau.setText(matKhau);
            
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
	        Object[] rowData = new Object[9];

	        rowData[0] = nv.getMaNV();
	        rowData[1]=taiKhoanBUS.getTenDangNhap(nv.getIdTaiKhoan());
	        rowData[2]=taiKhoanBUS.getMatKhau(nv.getIdTaiKhoan());
	        rowData[3] = nv.getTen();
	        rowData[4] = nv.getNgaySinh();
	        rowData[5] = nv.getGioiTinh() == 1 ? "Nam" : "Nữ";
	        rowData[6] = nv.getSoDT();		            
	        rowData[7] = taiKhoanBUS.getTenQuyen(nv.getIdTaiKhoan());
	        int trangThai = taiKhoanBUS.getTrangThai(nv.getIdTaiKhoan());
	        rowData[8] = (trangThai == 0) ? "Khoá" : ((trangThai == 1) ? "Hiệu lực" : "Chưa có");
	        
	        tableModel.addRow(rowData);
	    }
	}
	
	private void xuLyKhoaNhanVien() {
		String ma=txtMaNV.getText();
		 if (ma.trim().equals("")) {
	            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

		   int row = table.getSelectedRow();
	            String trangThai = table.getValueAt(row, 8).toString();
	            int trangThaiMoi = -1; 
	            
	            if (trangThai=="Hiệu lực") {
	                trangThaiMoi = 0; // Khoá
	            } else {
	                trangThaiMoi = 1; // Hiệu lực
	            }
	            taiKhoanBUS.setTrangThai(nhanVienBUS.getIdTaiKhoan(ma), trangThaiMoi);
	            btnReset.doClick(); 
	}



	private void xuLyXuatExcel() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn nơi lưu tệp Excel");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			if (!fileToSave.getAbsolutePath().toLowerCase().endsWith(".xlsx")) {
				fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
			}
			try {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Danh sách nhân viên");

				// Thêm ba dòng trống ở phía trên
				for (int i = 0; i < 3; i++) {
					sheet.createRow(i);
				}

				// Thêm ba cột trống ở bên trái
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sheet.getRow(j).createCell(i);
					}
				}

				// Tiêu đề cột
				XSSFRow headerRow = sheet.createRow(3);
				for (int i = 0; i < tableModel.getColumnCount(); i++) {
					XSSFCell cell = headerRow.createCell(i + 3); // Bắt đầu từ cột thứ 4
					cell.setCellValue(tableModel.getColumnName(i));
				}

				// Dữ liệu
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					XSSFRow row = sheet.createRow(i + 4); // Bắt đầu từ dòng thứ 5
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						XSSFCell cell = row.createCell(j + 3); // Bắt đầu từ cột thứ 4
						cell.setCellValue(String.valueOf(tableModel.getValueAt(i, j)));
					}
				}
				// Lưu workbook vào tệp
				FileOutputStream fileOut = new FileOutputStream(fileToSave.getAbsolutePath());
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();

				JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
			} catch (IOException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + ex.getMessage());
			}
		}
	}

	public void importDataExcel() {
		JFileChooser fileChoose = new JFileChooser();
		fileChoose.setDialogTitle("Chon file can import");

		int optionSelect = fileChoose.showOpenDialog(null);
		if (optionSelect == fileChoose.OPEN_DIALOG) {
			try {

				File file = fileChoose.getSelectedFile(); // Đường dẫn đến tệp Excel của bạn
				FileInputStream fis = new FileInputStream(file);
				Workbook workbook = WorkbookFactory.create(fis);
				Sheet sheet = workbook.getSheetAt(0);

				// Đọc dữ liệu từ các hàng còn lại
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					Object[] rowData = new Object[0];
					if (row != null)
						rowData = new Object[row.getLastCellNum()];
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						switch (cell.getCellType()) {
							case STRING:
								rowData[j] = cell.getStringCellValue();
								break;
							case NUMERIC:
								if (DateUtil.isCellDateFormatted(cell)) {
									Date date = cell.getDateCellValue();
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
									rowData[j] = sdf.format(date);
								} else
									rowData[j] = cell.getNumericCellValue();
								break;
							case BOOLEAN:
								rowData[j] = cell.getBooleanCellValue();
								break;
							default:
								rowData[j] = "";
								break;
						}
					}
					rowData[0] = Integer.parseInt(tableModel.getValueAt(tableModel.getRowCount() - 1, 0).toString())
							+ 1;

					phanquyen_BUS pbB = new phanquyen_BUS();
					ArrayList<phanquyen_DTO> data = new ArrayList<>();
					try {
						data = pbB.getData();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int idQuyen = -1;
					System.out.println(rowData[2]);
					for (phanquyen_DTO item : data) {
						if (item.getTenPhanQuyen().equals(rowData[7].toString())) {
							idQuyen = item.getIdPhanQuyen();
							break;
						}
					}

					if (taiKhoanBUS.themTaiKhoan(rowData[1].toString(), rowData[2].toString(), idQuyen)) {
						if (nhanVienBUS.themNhanVien(rowData[3].toString(), rowData[4].toString(),
								rowData[5].toString().equals("Nam") ? 0 : 1, rowData[6].toString(),
								taiKhoanBUS.idTaiKhoanMax(), 0))
							tableModel.addRow(rowData);
					}

				}
				table.setModel(tableModel);
				workbook.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}