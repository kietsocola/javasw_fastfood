package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import Custom.*;
import DAO.SanPhamDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import BUS.*;
import DTO.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SanPhamGUI extends JPanel {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private MyTable tblSanPham;
	private DefaultTableModel dtmSanPham;
	private MyLabelSecond lblMaSP, lblTenSP, lblLoaiSP, lblSoLuong,lblCongThuc, lblDonGia, lblHinhAnh;
	private MyButton btnThem,btnXoa,btnSua,btnChonAnh;
	private MyTextField txtMaSP, txtTenSP, txtSoLuong,txtCongThuc, txtDonGia;
	private JComboBox<String> cmbLoai;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private JLabel lblAnhSP;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SanPhamGUI frame = new SanPhamGUI();
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
	public SanPhamGUI() {
		addControlsSanPham();
//		addEventsBanHang();
	}
	public void addControlsSanPham() {
		
		this.setLayout(new BorderLayout());
		MyPanelSecond panel_main = new MyPanelSecond();
		this.add(panel_main, BorderLayout.CENTER);
		
		panel_main.setLayout(new BorderLayout(0, 0));
// ------------------------------------------------------------------------------------------------------		
		MyPanel panel_input = new MyPanel();
		panel_main.add(panel_input, BorderLayout.NORTH);
		panel_input.setLayout(new BorderLayout(10, 10));
		
		MyLabel lblTitle = new MyLabel("Quản lý sản phẩm");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		panel_input.add(lblTitle, BorderLayout.NORTH);
		
		MyPanelSecond pnInputOptions = new MyPanelSecond();
		panel_input.add(pnInputOptions,BorderLayout.CENTER);
		pnInputOptions.setLayout(new BoxLayout(pnInputOptions, BoxLayout.Y_AXIS));
		
		MyPanelSecond pnMaSP = new MyPanelSecond();
		txtMaSP = new MyTextField();
		lblMaSP = new MyLabelSecond("Mã SP");
		pnMaSP.add(lblMaSP);
		pnMaSP.add(txtMaSP);
		
		MyPanelSecond pnTenSP = new MyPanelSecond();
		txtTenSP = new MyTextField();
		lblTenSP = new MyLabelSecond("Tên SP");
		pnTenSP.add(lblTenSP);
		pnTenSP.add(txtTenSP);
 		
		MyPanelSecond pnLoai = new MyPanelSecond();
		cmbLoai = new JComboBox<String>();
		loadDataCmbLoai();
		cmbLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyThemLoai();
			}
		});
		cmbLoai.setPreferredSize(new Dimension(200, 30));
		lblLoaiSP = new MyLabelSecond("Loại");
		pnLoai.add(lblLoaiSP);
		pnLoai.add(cmbLoai);
		
		MyPanelSecond pnSoLuong = new MyPanelSecond();
		txtSoLuong = new MyTextField();
		lblSoLuong = new MyLabelSecond("Số lượng");
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		
		MyPanelSecond pnCongThuc = new MyPanelSecond();
		txtCongThuc = new MyTextField();
		lblCongThuc = new MyLabelSecond("Công Thức");
		pnCongThuc.add(lblCongThuc);
		pnCongThuc.add(txtCongThuc);
		
		MyPanelSecond pnDonGia = new MyPanelSecond();
		txtDonGia = new MyTextField();
		lblDonGia = new MyLabelSecond("Đơn giá");
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		
		pnInputOptions.add(pnMaSP);
		pnInputOptions.add(pnTenSP);
		pnInputOptions.add(pnLoai);
		pnInputOptions.add(pnSoLuong);
		pnInputOptions.add(pnCongThuc);
		pnInputOptions.add(pnDonGia);
		
		//Panel Ảnh
		MyPanelSecond pnAnh = new MyPanelSecond();
		pnAnh.setPreferredSize(new Dimension(300, 10));
		MyPanel panel_containAnh = new MyPanel();
		panel_input.add(panel_containAnh,BorderLayout.EAST);
		panel_containAnh.setLayout(new BorderLayout(0, 0));
		
		panel_containAnh.add(pnAnh);
		JPanel pnChuaAnh = new JPanel();
		lblAnhSP = new JLabel();
        lblAnhSP.setPreferredSize(new Dimension(120, 120));
        lblAnhSP.setIcon(getAnhSP(""));
		FlowLayout flowLayout = (FlowLayout) pnChuaAnh.getLayout();
		pnChuaAnh.add(lblAnhSP);
		pnChuaAnh.setMaximumSize(new Dimension(120, 120));
		pnChuaAnh.setPreferredSize(new Dimension(120, 120));
        
		MyPanelSecond pnButtonAnh = new MyPanelSecond();
		pnButtonAnh.setPreferredSize(new Dimension(
                (int) pnChuaAnh.getPreferredSize().getHeight(), 40));
		pnAnh.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        pnAnh.add(pnChuaAnh);
        pnAnh.add(pnButtonAnh);
        btnChonAnh = new  MyButton("Chọn Ảnh");
        btnChonAnh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		xuLyChonAnh();
        	}
        });
        pnButtonAnh.add(btnChonAnh);
        MyPanel space1_1 = new MyPanel();
        panel_containAnh.add(space1_1, BorderLayout.EAST);
        //Panel nút
        MyPanelSecond pnButton = new MyPanelSecond();
        pnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnThem = new MyButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		xuLyThemSanPham();
        	}
        });
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnXoa = new MyButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSua = new MyButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		xuLySuaSanPham();
        	}
        });
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pnButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btnThem); pnButton.add(btnSua); pnButton.add(btnXoa);
        
        MyPanel panel_containBTN = new MyPanel();
		panel_input.add(panel_containBTN, BorderLayout.SOUTH); 
		panel_containBTN.setLayout(new BorderLayout(0, 0));
		
		MyPanel space6 = new MyPanel();
		panel_containBTN.add(space6, BorderLayout.EAST);
		
		MyPanel space5 = new MyPanel();
		panel_containBTN.add(space5, BorderLayout.SOUTH);
		
		MyPanel space4 = new MyPanel();
		panel_containBTN.add(space4, BorderLayout.WEST);
		
		panel_containBTN.add(pnButton);
        //panel_input.add(pnButton,BorderLayout.SOUTH);
        
       
		
        MyPanel space1 = new MyPanel();
        FlowLayout flowLayout_1 = (FlowLayout) space1.getLayout();
        flowLayout_1.setVgap(0);
        flowLayout_1.setHgap(0);
        panel_input.add(space1, BorderLayout.WEST);
// ------------------------------------------------------------------------------------------------------ 
		// Bảng Sản phẩm
// ------------------------------------------------------------------------------------------------------
		MyPanelSecond panel_table = new MyPanelSecond();
		panel_main.add(panel_table, BorderLayout.CENTER);
	
		dtmSanPham = new DefaultTableModel();
		dtmSanPham.addColumn("Mã sản phẩm");
		dtmSanPham.addColumn("Tên sản phẩm");
		dtmSanPham.addColumn("Loại");
		dtmSanPham.addColumn("Số lượng");
		dtmSanPham.addColumn("Công thức");
		dtmSanPham.addColumn("Đơn giá");
		dtmSanPham.addColumn("Ảnh");
		
		tblSanPham = new MyTable();
		tblSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xulyClickTblSanPham();
			}
		});
		tblSanPham.setModel(dtmSanPham);
		loadDataToTblSanPham();
		JScrollPane  scrTableSanPham= new JScrollPane(tblSanPham);
		scrTableSanPham.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		panel_table.setLayout(new BorderLayout(0, 0));
		panel_table.add(scrTableSanPham, BorderLayout.NORTH);

		MyPanel space2 = new MyPanel();
		panel_table.add(space2, BorderLayout.SOUTH);
		
		MyPanel space3_1 = new MyPanel();
		panel_main.add(space3_1, BorderLayout.SOUTH);
		
		MyPanel space3 = new MyPanel();
		panel_main.add(space3, BorderLayout.WEST);
		
		MyPanel space3_2 = new MyPanel();
		panel_main.add(space3_2, BorderLayout.EAST);
//---------------------------------------------------------------------------------------------		

	}
	private void loadDataToTblSanPham() {
		spBUS.docListSanPham();
		dtmSanPham.setRowCount(0);
		
		ArrayList <SanPham> dssp = spBUS.getDSSanPham();
		
		for (SanPham sp : dssp) {
			Vector vec = new Vector();
			vec.add(sp.getId());
			vec.add(sp.getTenSP());
			vec.add(sp.getIdLoaiSP());
			vec.add(sp.getSoLuong());
			vec.add(sp.getIdCongThuc());
			vec.add(sp.getDonGia());
			vec.add(sp.getHinhAnh());
			
			dtmSanPham.addRow(vec);
		}
	}
	
	private void xulyClickTblSanPham() { // khi ấn vào sẽ hiển thị trên các lbl
		int row = tblSanPham.getSelectedRow();
		if (row > -1) {
			String ma = tblSanPham.getValueAt(row, 0) + "";
			String ten = tblSanPham.getValueAt(row, 1) + "";
			String loai = tblSanPham.getValueAt(row, 2) + "";
			String soLuong = tblSanPham.getValueAt(row, 3) + "";
			String congThuc = tblSanPham.getValueAt(row, 4) + "";
			String donGia = tblSanPham.getValueAt(row, 5) + "";
			String anh = tblSanPham.getValueAt(row, 6) + "";
			
			 txtMaSP.setText(ma);
             txtTenSP.setText(ten);
             cmbLoai.setSelectedItem(loai);
             txtSoLuong.setText(soLuong);
             txtCongThuc.setText(congThuc);
             txtDonGia.setText(donGia);
             
             int flag = 0;
             for (int i = 0; i < cmbLoai.getItemCount(); i++) {
                 if (cmbLoai.getItemAt(i).contains(loai)) {
                     flag = i;
                     break;
                 }
             }
             cmbLoai.setSelectedIndex(flag);
             loadAnh("images/SanPham/" + anh);
		}
	}
	File fileAnhSP;
	private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File(src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("images/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File(src);
        } catch (IOException e) {
            fileAnhSP = new File("images/default.png");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }

        return null;
    }
	 private void loadAnh(String anh) {
	        lblAnhSP.setIcon(getAnhSP(anh));
	    }
//----------------Xử lý các nút chức năng --------------------------------//
	 //nút chọn ảnh
	 private void xuLyChonAnh() {
	        JFileChooser fileChooser = new JFileChooser("images/SanPham/");
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "Tệp hình ảnh", "jpg", "png", "jpeg");
	        fileChooser.setFileFilter(filter);
	        int returnVal = fileChooser.showOpenDialog(null);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            fileAnhSP = fileChooser.getSelectedFile();
	            lblAnhSP.setIcon(getAnhSP(fileAnhSP.getPath()));
	        }
	    }
	 private void luuFileAnh() {
	        BufferedImage bImage = null;
	        try {
	            File initialImage = new File(fileAnhSP.getPath());
	            bImage = ImageIO.read(initialImage);
	            
	            ImageIO.write(bImage, "png" , new File("images/SanPham/" + fileAnhSP.getName()));

	        } catch (IOException e) {
	            System.out.println("Exception occured :" + e.getMessage());
	        }
	    }
	    private void xuLyThemSanPham() {
	    	
	        String ten = txtTenSP.getText();
	        int loai = cmbLoai.getSelectedIndex();
	        int soLuong = Integer.parseInt(txtSoLuong.getText());
	        int idCongThuc = Integer.parseInt(txtCongThuc.getText());
	        String anh = fileAnhSP.getName();
	        int donGia = Integer.parseInt(txtDonGia.getText());
	        // Kiểm tra và xử lý dữ liệu trước khi thêm
	        boolean flag = spBUS.themSanPham(ten, loai, soLuong, idCongThuc, anh, donGia);
	        spBUS.docListSanPham();
	        loadDataToTblSanPham();
	        luuFileAnh();
	    }
	    private void xuLySuaSanPham() {
	    	int id = Integer.parseInt(txtMaSP.getText());
	        String ten = txtTenSP.getText();
	        int loai = cmbLoai.getSelectedIndex();
	        int soLuong = Integer.parseInt(txtSoLuong.getText());
	        int idCongThuc = Integer.parseInt(txtCongThuc.getText());
	        String anh = fileAnhSP.getName();
	        int donGia = Integer.parseInt(txtDonGia.getText());
	        // Kiểm tra và xử lý dữ liệu trước khi thêm
	        boolean flag = spBUS.suaSanPham(id,ten, loai, soLuong, idCongThuc, anh, donGia);
	        spBUS.docListSanPham();
	        loadDataToTblSanPham();
	        luuFileAnh();
	    }
	    private void xuLyThemLoai() {
	    	 int x = cmbLoai.getSelectedIndex();
		        if (x == cmbLoai.getItemCount() - 1) {
		        	DlgQuanLyLoai loaiGUI = new DlgQuanLyLoai();
		            loaiGUI.setVisible(true);
		            loadDataCmbLoai();
		        }
	    } 
	    private void loadDataCmbLoai() {
	        cmbLoai.removeAllItems();
	        
	        ArrayList<LoaiSanPham> dsl = loaiBUS.getListLoaiSP();
	        cmbLoai.addItem("0 - Chọn loại");
	        for (LoaiSanPham loai : dsl) {
	            cmbLoai.addItem(loai.getMaLoai() + " - " + loai.getTenLoaiSP());
	        }
	        cmbLoai.addItem("Khác...");
	    }
}