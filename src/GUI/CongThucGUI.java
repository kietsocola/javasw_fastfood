package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.CheBienBUS;
import BUS.CongThucBUS;
import BUS.NguyenLieuBUS;
import BUS.SanPhamBUS;
import Custom.MyButton;
import Custom.MyColor;
import Custom.MyLabel;
import Custom.MyLabelSecond;
import Custom.MyPanel;
import Custom.MyPanelSecond;
import Custom.MyTable;
import Custom.MyTextField;
import DTO.ChiTietHoaDon;
import DTO.CongThuc;
import DTO.LoaiSanPham;
import DTO.NguyenLieu;
import DTO.SanPham;

public class CongThucGUI extends JPanel{
	
	private MyTextField txtSoLuongCB;
	private MyButton btnCheBien;
	private DefaultTableModel modelTableSPCheBien;
	private MyTable tableSanPhamCheBien;
	private DefaultTableModel modelTableNguyenLieuCB;
	private MyTable tableNguyenLieuCheBien;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private NguyenLieuBUS nlBUS = new NguyenLieuBUS();
	private CongThucBUS ctBUS = new CongThucBUS();
	private CheBienBUS chebienBUS = new CheBienBUS();
	private Map<Integer, String> optionMap;
	private ArrayList<NguyenLieu> arrNguyenLieu;
	private JComboBox comboBox;
	private MyTextField txtmaSP;
	private MyButton btnUpdate;
	private MyButton btnReset;
	private MyButton btnXoa;
	public CongThucGUI() {
		addControlsCongThuc();
		addEventsCongThuc();
	}
	public void addControlsCongThuc() {
		this.setLayout(new BorderLayout());
//		MyPanelSecond panel_main = new MyPanelSecond();
//		this.add(panel_main, BorderLayout.CENTER);
		
		

		MyPanel panelMenuCheBien = new MyPanel();
		panelMenuCheBien.setLayout(new BorderLayout(0, 0));
		
		MyPanel pnSpace = new MyPanel();
		panelMenuCheBien.add(pnSpace, BorderLayout.NORTH);
		
		this.add(panelMenuCheBien, BorderLayout.CENTER);

		MyPanel Contain_panelBtnCheBien = new MyPanel();
		Contain_panelBtnCheBien.setLayout(new BorderLayout());
		MyPanel pnSpace7 = new MyPanel();
		Contain_panelBtnCheBien.add(pnSpace7, BorderLayout.SOUTH);
		MyPanelSecond panelBtnCheBien = new MyPanelSecond();
		Contain_panelBtnCheBien.add(panelBtnCheBien, BorderLayout.CENTER);
		panelMenuCheBien.add(Contain_panelBtnCheBien, BorderLayout.EAST);
		panelMenuCheBien.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		panelBtnCheBien.setLayout(new BorderLayout());
		
		MyPanelSecond containSelectNL = new MyPanelSecond();
		containSelectNL.setLayout(new BoxLayout(containSelectNL, BoxLayout.Y_AXIS));
        txtmaSP = new MyTextField();
        txtmaSP.setEnabled(false);
		MyPanelSecond pnMaSP = new MyPanelSecond();
        MyLabelSecond lblMaSP = new MyLabelSecond("Mã SP");
        pnMaSP.add(lblMaSP);
        pnMaSP.add(txtmaSP);
        containSelectNL.add(pnMaSP);
        
		panelBtnCheBien.add(containSelectNL, BorderLayout.NORTH);
		optionMap = new HashMap<>();
		arrNguyenLieu = new ArrayList<>();
		arrNguyenLieu = getListNguyenLieu();
		if(arrNguyenLieu != null) {
			for(NguyenLieu x : arrNguyenLieu) {
				optionMap.put(x.getMaNguyenLieu(), x.getTenNL());
			}
		}

        // Tạo một mảng các ID để sử dụng trong JComboBox
        Integer[] ids = optionMap.keySet().toArray(new Integer[0]);

        // Tạo một JComboBox và thiết lập dữ liệu từ Map
        comboBox = new JComboBox<>(optionMap.values().toArray(new String[0]));
        
        MyPanelSecond pnNL = new MyPanelSecond();
        MyLabelSecond lblNL = new MyLabelSecond("Nguyên liệu");
        pnNL.add(lblNL);
        pnNL.add(comboBox);
        containSelectNL.add(pnNL);

        txtSoLuongCB = new MyTextField();
        MyPanelSecond pnSL = new MyPanelSecond();
        MyLabelSecond lblSL = new MyLabelSecond("Số lượng");
        pnSL.add(lblSL);
        pnSL.add(txtSoLuongCB);
        containSelectNL.add(pnSL);
        
        MyPanelSecond containBTN = new MyPanelSecond();
        btnCheBien = new MyButton("Thêm");
        containBTN.add(btnCheBien);
        btnUpdate = new MyButton("Cập nhật");
        containBTN.add(btnUpdate);
        
        MyPanelSecond containBTN2 = new MyPanelSecond();
        btnReset = new MyButton("Làm mới");
        btnXoa = new MyButton("Xóa");
//        btnXoa.setEnabled(false);
        containBTN2.add(btnXoa);
        containBTN2.add(btnReset);
        
        containSelectNL.add(containBTN);
        containSelectNL.add(containBTN2);
        
//		txtSoLuongCB = new MyTextField();
//		panelBtnCheBien.add(txtSoLuongCB);
//		txtSoLuongCB.setColumns(10);
//		btnCheBien = new MyButton("Chế biến");
//		panelBtnCheBien.add(btnCheBien);

		MyPanel panelTableCheBien = new MyPanel();
		panelTableCheBien.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		panelMenuCheBien.add(panelTableCheBien, BorderLayout.CENTER);
		panelTableCheBien.setLayout(new GridLayout(2, 1, 0, 0));

		MyPanel Contain_PanelTableSanPham = new MyPanel();
		Contain_PanelTableSanPham.setLayout(new BorderLayout());
		MyPanel pnSpace6 = new MyPanel();
		pnSpace6.setBorder(new EmptyBorder(0, 0, 5, 0));
		Contain_PanelTableSanPham.add(pnSpace6, BorderLayout.SOUTH);
		MyPanelSecond panelTableSanPham = new MyPanelSecond();
		Contain_PanelTableSanPham.add(panelTableSanPham, BorderLayout.CENTER);
		panelTableCheBien.add(Contain_PanelTableSanPham);
		panelTableSanPham.setLayout(new BorderLayout(0, 0));
		panelTableSanPham.setBorder(new EmptyBorder(10, 10, 10, 10));

		MyLabelSecond lblSanPhamCheBien = new MyLabelSecond("Sản phẩm");
		panelTableSanPham.add(lblSanPhamCheBien, BorderLayout.NORTH);

		JScrollPane scrollPaneSanPham = new JScrollPane();
		panelTableSanPham.add(scrollPaneSanPham, BorderLayout.CENTER);

		modelTableSPCheBien = new DefaultTableModel();
		modelTableSPCheBien.addColumn("Mã SP");
		modelTableSPCheBien.addColumn("Tên SP");
		modelTableSPCheBien.addColumn("Đơn giá");
		modelTableSPCheBien.addColumn("Còn lại");
		tableSanPhamCheBien = new MyTable(modelTableSPCheBien);
		scrollPaneSanPham.setViewportView(tableSanPhamCheBien);
		scrollPaneSanPham.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);
		clickTableSanPhamCheBien();

		MyPanelSecond panelCongThucCheBien = new MyPanelSecond();
		panelCongThucCheBien.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelTableCheBien.add(panelCongThucCheBien);
		panelCongThucCheBien.setLayout(new BorderLayout(0, 0));

		MyLabelSecond lblCTCB = new MyLabelSecond("Nguyên liệu");
		panelCongThucCheBien.add(lblCTCB, BorderLayout.NORTH);

		JScrollPane scrollPaneNguyenLieu = new JScrollPane();
		panelCongThucCheBien.add(scrollPaneNguyenLieu, BorderLayout.CENTER);
		scrollPaneNguyenLieu.getViewport().setBackground(MyColor.SECOND_BAKCGROUND_COLOR);

		modelTableNguyenLieuCB = new DefaultTableModel();
		modelTableNguyenLieuCB.addColumn("Mã SP");
		modelTableNguyenLieuCB.addColumn("Mã NL");
		modelTableNguyenLieuCB.addColumn("Tên nguyên liệu");
		modelTableNguyenLieuCB.addColumn("Số lượng cần");
		modelTableNguyenLieuCB.addColumn("Số lượng còn lại");
		tableNguyenLieuCheBien = new MyTable(modelTableNguyenLieuCB);
		scrollPaneNguyenLieu.setViewportView(tableNguyenLieuCheBien);
		loadDataTableSanPhamCB();
		clickTableNguyenLieuCheBien();
	}
	
	private void addEventsCongThuc() {
		btnXoa.addMouseListener(new MouseListener() {
			
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
				ListSelectionModel selectionModel = tableNguyenLieuCheBien.getSelectionModel();
				selectionModel.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tableNguyenLieuCheBien.getSelectedRow();
						if (selectedRow != -1) { // If a row is selected
							xoaNguyenLieu();
						} else {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm sau đó chọn nguyên liệu cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
				});
			}
		});
		btnReset.addMouseListener(new MouseListener() {
			
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
				btnCheBien.setEnabled(true);
//				btnXoa.setEnabled(false);
				comboBox.setEnabled(true);
				txtSoLuongCB.setText("");
				txtmaSP.setText("");
				tableSanPhamCheBien.clearSelection();
				tableNguyenLieuCheBien.clearSelection();
			}
		});
		btnUpdate.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				updateNguyenLieu();
			}
		});
		btnCheBien.addMouseListener(new MouseListener() {
			
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
				addCongThuc();
			}
		});
	}
	
	
	private void loadDataTableSanPhamCB() {
		ArrayList<SanPham> listSP = spBUS.getDSSanPham();
		addDataToTableSanPhamCB(listSP);
	}
	private void clickTableSanPhamCheBien() {
		comboBox.setFocusable(false);
		ListSelectionModel selectionModel = tableSanPhamCheBien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableSanPhamCheBien.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int maSP = Integer.parseInt(tableSanPhamCheBien.getValueAt(selectedRow, 0) + "");
					txtmaSP.setText(maSP+"");
					ArrayList<CongThuc> listCT = chebienBUS.getCongThucbyIdSanPham(maSP);
					addDataTableNguyenLieu(listCT);
				}
			}
		});

	}
	private void clickTableNguyenLieuCheBien() {
//		btnXoa.setEnabled(true);
		btnCheBien.setEnabled(false);
		comboBox.setEnabled(false);
		ListSelectionModel selectionModel = tableNguyenLieuCheBien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableNguyenLieuCheBien.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int maNL = Integer.parseInt(tableNguyenLieuCheBien.getValueAt(selectedRow, 1) + "");
					int maSP = Integer.parseInt(tableNguyenLieuCheBien.getValueAt(selectedRow, 0) + "");
					int sl = Integer.parseInt(tableNguyenLieuCheBien.getValueAt(selectedRow, 3) + "");
					comboBox.setSelectedItem(optionMap.get(maNL));
					txtSoLuongCB.setText(sl+"");
					txtmaSP.setText(maSP+"");
				}
			}
		});

	}
	private void addDataToTableSanPhamCB(ArrayList<SanPham> listSP) {
		modelTableSPCheBien.setRowCount(0);
		for (SanPham sp : listSP) {
			Vector<String> vec = new Vector<>();
			vec.add(sp.getId() + "");
			vec.add(sp.getTenSP());
			vec.add(sp.getDonGia() + "");
			vec.add(sp.getSoLuong() + "");
			modelTableSPCheBien.addRow(vec);
		}
	}
	private void addDataTableNguyenLieu(ArrayList<CongThuc> listCT) {
		modelTableNguyenLieuCB.setRowCount(0);
		for (CongThuc ct : listCT) {
			Vector<String> vec = new Vector<>();
			vec.add(ct.getIdSanPham() + "");
			vec.add(ct.getIdNguyenLieu() + "");
			NguyenLieu nl = nlBUS.getNguyenLieubyId(ct.getIdNguyenLieu());
			vec.add(nl.getTenNL());
			vec.add(ct.getSoLuongDung() + "");
			vec.add(nl.getsoLuongNL() + "");
			modelTableNguyenLieuCB.addRow(vec);
		}
	}
	private ArrayList<NguyenLieu> getListNguyenLieu() {
		ArrayList<NguyenLieu> arr = new ArrayList<>();
		arr = nlBUS.getDSachNguyenLieu();
		if(arr != null) return arr;
		return null;
	}
	
	private void addCongThuc() {
		int maSP = Integer.parseInt(txtmaSP.getText());
		int maNL=0;
		String selectedOption = (String) comboBox.getSelectedItem();
        for (Map.Entry<Integer, String> entry : optionMap.entrySet()) {
            if (entry.getValue().equals(selectedOption)) {
                maNL = entry.getKey();
                break;
            }
        }
        String num = txtSoLuongCB.getText();
        if(!num.trim().equals("")) {
        	int sl = Integer.parseInt(num);
        	ctBUS.addUpdate(maNL, sl, maSP);
        }
		
	}
	private void updateNguyenLieu(){
		int maSP = Integer.parseInt(txtmaSP.getText());
		int maNL=0;
		String selectedOption = (String) comboBox.getSelectedItem();
        for (Map.Entry<Integer, String> entry : optionMap.entrySet()) {
            if (entry.getValue().equals(selectedOption)) {
                maNL = entry.getKey();
                break;
            }
        }
        String num = txtSoLuongCB.getText();
        if(!num.trim().equals("")) {
        	int sl = Integer.parseInt(num);
        	ctBUS.addUpdate(maNL, sl, maSP);
        }
	}
	private void xoaNguyenLieu(){
		int maSP = Integer.parseInt(txtmaSP.getText());
		int maNL=0;
		String selectedOption = (String) comboBox.getSelectedItem();
        for (Map.Entry<Integer, String> entry : optionMap.entrySet()) {
            if (entry.getValue().equals(selectedOption)) {
                maNL = entry.getKey();
                break;
            }
        }
        ctBUS.deleteCongThuc(maNL, maSP);
	}
	
}
