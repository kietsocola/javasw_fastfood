package Custom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MyTable extends JTable {

    public MyTable() {
        // Thiết lập các thuộc tính cho JTable
        this.setFocusable(false);
        this.setIntercellSpacing(new Dimension(0, 0));
        this.setRowHeight(26);
        this.setSelectionBackground(new Color(234, 234, 234));
        this.setFont(new Font("Arial", Font.PLAIN, 13));

        // Tạo renderer để căn giữa nội dung của ô
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//
//        // Thiết lập renderer cho từng cột trong JTable
//        TableColumnModel columnModel = this.getColumnModel();
//        for (int i = 0; i < columnModel.getColumnCount(); i++) {
//            columnModel.getColumn(i).setCellRenderer(centerRenderer);
//        }

        // Thiết lập header của JTable
        JTableHeader header = this.getTableHeader();
        header.setBackground(new Color(208, 208, 208));
        header.setFont(new Font("Arial", Font.PLAIN, 15));
        header.setOpaque(false);
        header.setForeground(Color.BLACK);
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(header.getWidth(), 28));
    }

    public MyTable(DefaultTableModel dtm) {
        this();
        this.setModel(dtm);

        //SORT HEADER TABLE
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
        this.setRowSorter(sorter);
    }
}

