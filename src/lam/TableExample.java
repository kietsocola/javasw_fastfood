package lam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class TableExample extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public TableExample() {
        setTitle("Table Example");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo một bảng với một mô hình mặc định
        model = new DefaultTableModel();
        table = new JTable(model);

        // Thêm cột vào bảng
        model.addColumn("Column 1");
        model.addColumn("Column 2");
        model.addColumn("Column 3");
        model.addColumn("Column 4");
        model.addColumn("Column 5");
        model.addColumn("Column 6");
        model.addColumn("Column 7");
        model.addColumn("Column 8");
        model.addColumn("Column 9");

        // Đẩy dữ liệu vào bảng
        pushDataToTable();

        // Thêm bảng vào panel
        JScrollPane scrollPane = new JScrollPane(table);
        JButton importExcel = new JButton("import");
        importExcel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("hellop");
        		importDataExcel();
        	}

        });
        getContentPane().add(importExcel,BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
    }
    
    public void importDataExcel() {
    	JFileChooser fileChoose = new JFileChooser();
    	fileChoose.setDialogTitle("Chon file can import");
    	
        int optionSelect = fileChoose.showOpenDialog(null);
        if(optionSelect == fileChoose.OPEN_DIALOG) {
        	try {

            	
                File file = fileChoose.getSelectedFile(); // Đường dẫn đến tệp Excel của bạn
                FileInputStream fis = new FileInputStream(file);
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheetAt(0);


                // Lấy hàng đầu tiên làm tiêu đề cột
                if(model.getRowCount() == 0)
                {	
                    Row headerRow = sheet.getRow(0);
//                	for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//                        model.addColumn(headerRow.getCell(i).getStringCellValue());
//                    }
                }

                // Đọc dữ liệu từ các hàng còn lại
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Object[] rowData = new Object[row.getLastCellNum()];
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        switch (cell.getCellType()) {
                            case STRING:
                                rowData[j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                rowData[j] = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                rowData[j] = cell.getBooleanCellValue();
                                break;
                            default:
                                rowData[j] = "";
                        }
                    }
                    model.addRow(rowData);
                }

                table.setModel(model);
                workbook.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        
    }

    private void pushDataToTable() {
        // Dữ liệu mẫu
        Vector<Object> row1 = new Vector<>();
        row1.add(1);
        row1.add("Data 2");
        row1.add("Data 3");
        row1.add("Data 4");

        Vector<Object> row2 = new Vector<>();
        row2.add("Data 5");
        row2.add("Data 6");
        row2.add("Data 7");
        row2.add("Data 8");

        Vector<Object> row3 = new Vector<>();
        row3.add("Data 9");
        row3.add("Data 10");
        row3.add("Data 11");
        row3.add("Data 12");

        // Đẩy dữ liệu vào mô hình bảng
        model.addRow(row1);
        model.addRow(row2);
        model.addRow(row3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableExample().setVisible(true));
    }
}
