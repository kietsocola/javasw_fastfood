package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import BUS.NhanVienBus;
import DTO.NhanVien;
import Custom.MyColor;

public class NhanVienGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    DefaultTableModel model;
    private NhanVienBus nhanVienBUS = new NhanVienBus();

    JTable table;
    JPanel contentPane, jPanel_TieuDe, panel_tableNhanVien, panel_nhap_timKiem_duLieu, panel_dienThongTin,
            panel_dienMa, panel_dienTen, panel_ngaySinh, panel_14, panel_gioiTinh, panel_soDT, panel_btn, panel,
            panel_TimKiem;
    JLabel Label_TieuDe, label_dienMa, label_ngaySinh, label_3, label_8, lblNewLabel;
    JTextField textField_maNV, textField_tenNV, textField_soDT, textField_timKiem;
    JSpinner  spinner_ngaySinh, spinner_thangSinh, spinner_namSinh;
    JRadioButton radioButton_Nam, radioButton_Nu;
    JButton themButton, xoaButton, suaButton, resetButton, btnTimKiem;


    /**
     * Create the frame.
     */
    public NhanVienGUI() {
        addControlsNhanVien();
        model = (DefaultTableModel) table.getModel();
        addEventsNhanVien();
    }

    private void addControlsNhanVien() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 791, 376);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
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
        Label_TieuDe.setForeground(new Color(255, 255, 255));
        Label_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jPanel_TieuDe.add(Label_TieuDe, BorderLayout.CENTER);

        // Panel for table
        panel_tableNhanVien = new JPanel();
        panel_tableNhanVien.setPreferredSize(new Dimension(780, 170));
        contentPane.add(panel_tableNhanVien, BorderLayout.CENTER);
        panel_tableNhanVien.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        String[] column = { "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Số ĐT" };
        Object[][] data = {};
        table = new JTable(data, column);
        table.setPreferredSize(new Dimension(453, 150));
        JScrollPane sp = new JScrollPane(table);
        panel_tableNhanVien.add(sp, BorderLayout.CENTER);
        sp.setPreferredSize(new Dimension(453, 150));
        sp.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Panel for input and search
        panel_nhap_timKiem_duLieu = new JPanel();
        panel_nhap_timKiem_duLieu.setPreferredSize(new Dimension(780, 250));
        contentPane.add(panel_nhap_timKiem_duLieu, BorderLayout.SOUTH);
        panel_nhap_timKiem_duLieu.setBackground(MyColor.BORDER_COLOR);
        panel_nhap_timKiem_duLieu.setLayout(new BorderLayout());

        // Panel for input data
        panel_dienThongTin = new JPanel();
        panel_dienThongTin.setPreferredSize(new Dimension(400, 250));
        panel_nhap_timKiem_duLieu.add(panel_dienThongTin, BorderLayout.WEST);
        panel_dienThongTin.setBackground(MyColor.BORDER_COLOR);
        panel_dienThongTin.setLayout(new GridLayout(0, 1, 10, 10));

        // Panel for Ma NV
        panel_dienMa = new JPanel();
        panel_dienMa.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienMa);
        panel_dienMa.setLayout(new BorderLayout(10, 10));
        panel_dienMa.setBackground(MyColor.BORDER_COLOR);

        // Label for Ma NV
        label_dienMa = new JLabel("Mã Nhân Viên");
        label_dienMa.setPreferredSize(new Dimension(110, 10));
        label_dienMa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienMa.add(label_dienMa, BorderLayout.WEST);
        label_dienMa.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ma NV
        textField_maNV = new JTextField();
        textField_maNV.setColumns(10);
        textField_maNV.setPreferredSize(new Dimension(50, 17));
        panel_dienMa.add(textField_maNV, BorderLayout.CENTER);
        textField_maNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for Ten NV
        panel_dienTen = new JPanel();
        panel_dienTen.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_dienTen);
        panel_dienTen.setLayout(new BorderLayout(10, 10));
        panel_dienTen.setBackground(MyColor.BORDER_COLOR);

        // Label for Ten NV
        JLabel label_tenNV = new JLabel("Tên Nhân Viên");
        label_tenNV.setPreferredSize(new Dimension(110, 10));
        label_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_dienTen.add(label_tenNV, BorderLayout.WEST);
        label_tenNV.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for Ten NV
        textField_tenNV = new JTextField();
        textField_tenNV.setColumns(10);
        textField_tenNV.setPreferredSize(new Dimension(50, 17));
        panel_dienTen.add(textField_tenNV, BorderLayout.CENTER);
        textField_tenNV.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for ngaySinh
        panel_ngaySinh = new JPanel();
        panel_ngaySinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_ngaySinh);
        panel_ngaySinh.setLayout(new BorderLayout(10, 10));
        panel_ngaySinh.setBackground(MyColor.BORDER_COLOR);

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
        spinner_ngaySinh = new JSpinner();
        panel_14.add(spinner_ngaySinh);
        spinner_ngaySinh.setPreferredSize(new Dimension(50, 10));
        spinner_ngaySinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Spinner for month
        spinner_thangSinh = new JSpinner();
        panel_14.add(spinner_thangSinh);
        spinner_thangSinh.setPreferredSize(new Dimension(50, 10));
        spinner_thangSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Spinner for year
        spinner_namSinh = new JSpinner();
        panel_14.add(spinner_namSinh);
        spinner_namSinh.setPreferredSize(new Dimension(50, 10));
        spinner_namSinh.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for gioiTinh
        panel_gioiTinh = new JPanel();
        panel_gioiTinh.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_gioiTinh);
        panel_gioiTinh.setLayout(new BorderLayout(10, 10));
        panel_gioiTinh.setBackground(MyColor.BORDER_COLOR);

        // Label for gioiTinh
        label_3 = new JLabel("Giới Tính");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_3.setPreferredSize(new Dimension(150, 17));
        panel_gioiTinh.add(label_3, BorderLayout.WEST);
        label_3.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Radio button for Nam
        radioButton_Nam = new JRadioButton("Nam");
        radioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 11));
        radioButton_Nam.setPreferredSize(new Dimension(20, 17));
        panel_gioiTinh.add(radioButton_Nam, BorderLayout.CENTER);
        radioButton_Nam.setForeground(MyColor.SECOND_TEXT_COLOR);
        radioButton_Nam.setBackground(MyColor.BORDER_COLOR);

        // Radio button for Nu
        radioButton_Nu = new JRadioButton("Nữ");
        radioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 11));
        radioButton_Nu.setPreferredSize(new Dimension(80, 17));
        panel_gioiTinh.add(radioButton_Nu, BorderLayout.EAST);
        radioButton_Nu.setForeground(MyColor.SECOND_TEXT_COLOR);
        radioButton_Nu.setBackground(MyColor.BORDER_COLOR);

        // Panel for soDT
        panel_soDT = new JPanel();
        panel_soDT.setPreferredSize(new Dimension(385, 40));
        panel_dienThongTin.add(panel_soDT);
        panel_soDT.setLayout(new BorderLayout(10, 10));
        panel_soDT.setBackground(MyColor.BORDER_COLOR);

        // Label for soDT
        label_8 = new JLabel("Số ĐT");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_8.setPreferredSize(new Dimension(110, 10));
        panel_soDT.add(label_8, BorderLayout.WEST);
        label_8.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for soDT
        textField_soDT = new JTextField();
        textField_soDT.setPreferredSize(new Dimension(50, 17));
        panel_soDT.add(textField_soDT, BorderLayout.CENTER);
        textField_soDT.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);

        // Panel for buttons
        panel_btn = new JPanel();
        panel_btn.setBackground(MyColor.BORDER_COLOR);
        panel_btn.setLayout(new GridLayout(0, 1, 10, 10));
        panel_nhap_timKiem_duLieu.add(panel_btn, BorderLayout.CENTER);
        panel_btn.setPreferredSize(new Dimension(150, 250));

        panel = new JPanel();
        panel_btn.add(panel);
        panel.setPreferredSize(new Dimension(140, 30));
        panel.setBackground(MyColor.BORDER_COLOR);
        xoaButton = new JButton("Xoá");
        suaButton = new JButton("Sửa");
        resetButton = new JButton("Reset");

        themButton = new JButton("Thêm");
        themButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Thêm sự kiện thêm nhân viên
            }
        });
        themButton.setPreferredSize(new Dimension(89, 32));
        themButton.setForeground(Color.WHITE);
        themButton.setBackground(new Color(234, 124, 105));
        panel_btn.add(themButton);
        panel_btn.add(xoaButton);
        panel_btn.add(suaButton);
        panel_btn.add(resetButton);
        xoaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        xoaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        suaButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        suaButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        resetButton.setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        resetButton.setForeground(MyColor.SECOND_TEXT_COLOR);
        xoaButton.setPreferredSize(new Dimension(89, 32));
        suaButton.setPreferredSize(new Dimension(89, 32));
        resetButton.setPreferredSize(new Dimension(89, 32));

        panel = new JPanel();
        panel_btn.add(panel);
        panel.setPreferredSize(new Dimension(140, 30));
        panel.setBackground(MyColor.BORDER_COLOR);

     // Panel for search
        panel_TimKiem = new JPanel();
        panel_TimKiem.setPreferredSize(new Dimension(250, 250));
        panel_nhap_timKiem_duLieu.add(panel_TimKiem, BorderLayout.EAST);
        panel_TimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_TimKiem.setBackground(MyColor.BORDER_COLOR);

        // Label for search
        lblNewLabel = new JLabel("Tìm kiếm");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setPreferredSize(new Dimension(250, 110));
        panel_TimKiem.add(lblNewLabel, BorderLayout.NORTH);
        lblNewLabel.setForeground(MyColor.SECOND_TEXT_COLOR);

        // Text field for search
        textField_timKiem = new JTextField();
        textField_timKiem.setPreferredSize(new Dimension(200, 25));
        panel_TimKiem.add(textField_timKiem, BorderLayout.CENTER);
        textField_timKiem.setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
        
        btnTimKiem = new JButton("Tìm");
        btnTimKiem.setPreferredSize(new Dimension(89, 32));
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setBackground(new Color(234, 124, 105));
        panel_TimKiem.add(btnTimKiem);
        

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
        textField_timKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	xuLyTimKiemNhanVien();
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	xuLyTimKiemNhanVien();
            }
        });
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemNhanVien();
            }
        });

        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaNhanVien();
            }
        });

        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	xuLyXoaNhanVien();
            }
        });
        
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	xuLyReset();
            }
        });
        
    }

    private void xuLyReset(){
    	
                loadDataTblNhanVien();
                textField_maNV.setText("");
                textField_tenNV.setText("");
                textField_soDT.setText("");
                spinner_ngaySinh.setValue(1);
                spinner_thangSinh.setValue(1);
                spinner_namSinh.setValue(2000);
                radioButton_Nam.setSelected(true);
    }
    
     private void xuLyXoaNhanVien() {
    	String ma=textField_maNV.getText();
    	boolean flag =nhanVienBUS.xoaNhanVien(ma);
    	if(flag) {
    		nhanVienBUS.docDanhSach();
    		loadDataTblNhanVien();
    	}
    }
    
    private void xuLySuaNhanVien() {
    	if (!radioButton_Nam.isSelected() && !radioButton_Nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tenNV = textField_tenNV.getText();
        String ngaySinh = spinner_ngaySinh.getValue().toString() + "-" + spinner_thangSinh.getValue().toString() + "-" + spinner_namSinh.getValue().toString();
        String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
        String soDT = textField_soDT.getText();

        if(nhanVienBUS.themNhanVien(tenNV, ngaySinh, gioiTinh, soDT)) {
            nhanVienBUS.docDanhSach();
            loadDataTblNhanVien();
        }
    }
    
    private void xuLyThemNhanVien() {
        if (!radioButton_Nam.isSelected() && !radioButton_Nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tenNV = textField_tenNV.getText();
        String ngaySinh = spinner_ngaySinh.getValue().toString() + "-" + spinner_thangSinh.getValue().toString() + "-" + spinner_namSinh.getValue().toString();
        String gioiTinh = radioButton_Nam.isSelected() ? "Nam" : "Nữ";
        String soDT = textField_soDT.getText();

        if(nhanVienBUS.themNhanVien(tenNV, ngaySinh, gioiTinh, soDT)) {
            nhanVienBUS.docDanhSach();
            loadDataTblNhanVien();
            resetButton.doClick();
        }
    }

    
    private void xuLyTimKiemNhanVien() {
    	ArrayList<NhanVien> dsnv =nhanVienBUS.timNhanVien(textField_timKiem.getText());
    	((DefaultTableModel) table.getModel()).removeRow(0);
    	for(NhanVien nv :dsnv) {
    		Object[] rowData = new Object[5];
    		rowData[0] = nv.getMaNV();
            rowData[1] = nv.getTen();
            rowData[2] = nv.getNgaySinh();
            rowData[3] = nv.getGioiTinh();
            rowData[4] = nv.getSoDT();
            ((DefaultTableModel) table.getModel()).addRow(rowData);
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

            textField_maNV.setText(maNV);
            textField_tenNV.setText(tenNV);
            textField_soDT.setText(soDT);

            // Tách thông tin ngày sinh từ bảng thành ngày, tháng, năm
            String[] parts = ngaySinh.split("-");
            if (parts.length == 3) {
                spinner_ngaySinh.setValue(Integer.parseInt(parts[0]));
                spinner_thangSinh.setValue(Integer.parseInt(parts[1]));
                spinner_namSinh.setValue(Integer.parseInt(parts[2]));

            }
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                radioButton_Nam.setSelected(true);
                radioButton_Nu.setSelected(false);
            } else {
                radioButton_Nam.setSelected(false);
                radioButton_Nu.setSelected(true);
            }

        }
    }

    private void loadDataTblNhanVien() {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }

        ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();

        for (NhanVien nv : dsnv) {
            Object[] rowData = new Object[5];

            rowData[0] = nv.getMaNV();
            rowData[1] = nv.getTen();
            rowData[2] = nv.getNgaySinh();
            rowData[3] = nv.getGioiTinh();
            rowData[4] = nv.getSoDT();

            ((DefaultTableModel) table.getModel()).addRow(rowData);
        }
    }

   

}
