package Custom;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MyTextField extends JTextField{
	public MyTextField() {
        super();
        Border grayBorder = BorderFactory.createLineBorder(Color.GRAY);
        this.setBorder(grayBorder);
        this.setBackground(Color.WHITE);
//        setBackground(MyColor.BACKGROUND_TEXTFIELD_COLOR);
//        setForeground(MyColor.TEXTFIELD_TEXT_COLOR);
//        Border border = BorderFactory.createCompoundBorder(
//        	    new LineBorder(MyColor.BORDER_COLOR), // Border mặc định
//        	    new EmptyBorder(0, 5, 0, 5)); // Khoảng cách giữa border và vùng chứa text
//        setBorder(border);
        setPreferredSize(new Dimension(180, 30));
        setMaximumSize(new Dimension(500, 40));
    }
}

