package Custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String name) {
        super(name);
        setForeground(MyColor.PRIMARY_TEXT_COLOR);
        setPreferredSize(new Dimension(120, 40));
        setMaximumSize(new Dimension(120, 40));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
}
