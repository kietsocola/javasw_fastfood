package BUS;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.swing.filechooser.FileNameExtensionFilter;

public class XuLyFileExcel {
	
	public void xuatExcel(JTable tbl) {
		
		try {
			TableModel model =tbl.getModel();
			
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Lưu vào");
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls","xlsx","xlsm");
			chooser.setFileFilter(fnef);
			if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
				//Lấy đường dẫn vừa chọn + tên tệp
				String path= chooser.getSelectedFile().getPath();
				if(!path.contains(".xlsx")) {
					path+=".xlsx";
				}
				
				// Tạo một workbook Excel mới
				XSSFWorkbook workbook= new XSSFWorkbook();
				 // Tạo một sheet mới
				Sheet sheet = workbook.createSheet("Sheet 1");
				
				// Lặp qua dữ liệu trong JTable và ghi vào workbook
				for(int i=0;i<model.getRowCount();i++) {
					Row row = sheet.createRow(i);
					for(int j=0;j<model.getColumnCount();j++) {
						Object value = model.getValueAt(i, j);
						Cell cell =row.createCell(j);
						if(value != null) {
							cell.setCellValue(value.toString());
						}
					}
				}
				// Ghi file
				try(FileOutputStream fileout =new FileOutputStream(path)){
						workbook.write(fileout);
				}
				
				// Đóng workbook sau khi đã lưu
				workbook.close();
				
				JOptionPane.showMessageDialog(null, "Xuất file thành công!");
			}
			
		}catch (Exception e) {
		       JOptionPane.showMessageDialog(null, "Xuất file thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void nhapExcel(JTable tbl) {
		try {
		TableModel model =tbl.getModel();
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Chọn file");
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls","xlsx","xlsm");
		chooser.setFileFilter(fnef);
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			//lấy file chọn
			File fileSelected = chooser.getSelectedFile();
			FileInputStream fis = new FileInputStream(fileSelected);
			BufferedInputStream bis =new BufferedInputStream(fis);
			
			//đọc file excel
			XSSFWorkbook wb = new XSSFWorkbook(bis);
			Sheet sheet =wb.getSheetAt(0);
			
			//Lấy mô hình bảng và clear
			DefaultTableModel dtmtbl = (DefaultTableModel) model ;
            dtmtbl.setRowCount(0); 
            

         // Lặp qua các dòng trong sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Vector vec = new Vector();

             // Lặp qua các ô của dòng
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (dtmtbl.getColumnCount() != row.getLastCellNum()) {
                        // Nếu số cột trong bảng không khớp với số ô trong hàng thì hiển thị hộp thoại báo lỗi
                    	JOptionPane.showMessageDialog(null, "Nhập file thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Cell cell = row.getCell(j);
                    vec.add(cell.getStringCellValue());
                }
               
                dtmtbl.addRow(vec);
            }
            JOptionPane.showMessageDialog(null, "Nhập file thành công!");
	        }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Nhập file thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
		
	}
	
}
