package lam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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

        // Đẩy dữ liệu vào bảng
        pushDataToTable();

        // Thêm bảng vào panel
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
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
