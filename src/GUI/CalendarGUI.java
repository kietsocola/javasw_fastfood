package GUI;

import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalendarGUI extends JFrame {
    
    public CalendarGUI() {
        super("JCalendar Example");
        
        // Tạo một lịch JCalendar
        JCalendar calendar = new JCalendar();
        
        // Thêm lịch vào giao diện
        getContentPane().add(calendar, BorderLayout.CENTER);
        
        // Tạo một nút để in ra ngày được chọn
        JButton button = new JButton("Show Selected Date");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy ngày được chọn từ lịch
                java.util.Date selectedDate = calendar.getDate();
                JOptionPane.showMessageDialog(CalendarGUI.this, 
                        "Selected Date: " + selectedDate.toString());
            }
        });
        
        // Thêm nút vào giao diện
        getContentPane().add(button, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	CalendarGUI example = new CalendarGUI();
                example.setVisible(true);
            }
        });
    }
}