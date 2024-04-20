package Custom;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MyButton extends JButton{
	public MyButton(String name) {
        super(name);
        setBackground(MyColor.BACKGROUND_BUTTON_COLOR);
        setForeground(MyColor.PRIMARY_TEXT_COLOR);
        Border border = BorderFactory.createCompoundBorder(
        	    new LineBorder(MyColor.BACKGROUND_BUTTON_COLOR), // Border mặc định
        	    new EmptyBorder(5, 5, 5, 5)); // Khoảng cách giữa border và vùng chứa text
        setBorder(border);
        setPreferredSize(new Dimension(120, 40));
//        setBorder(new RoundedBorder(10));
    }
}