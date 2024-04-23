package lam;

import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    public MyDialog(JFrame parent, String title, String message) {
        super(parent, title, true);

        // Tạo một nhãn chứa thông điệp
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm nhãn vào JDialog
        getContentPane().add(label, BorderLayout.CENTER);

        // Pack để co dãn kích thước JDialog
        pack();

        // Đặt vị trí hiển thị của JDialog
        setLocationRelativeTo(parent);
    }
    
    

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Show Dialog");
        button.addActionListener(e -> {
            MyDialog dialog = new MyDialog(null, "Message", "This is a custom dialog with auto resizing");
            dialog.setVisible(true);
        });

        frame.getContentPane().add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
