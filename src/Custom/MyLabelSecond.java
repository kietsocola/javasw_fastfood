package Custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabelSecond extends JLabel{
	public MyLabelSecond(String name) {
        super(name);
        setForeground(MyColor.SECOND_TEXT_COLOR);
        setPreferredSize(new Dimension(80, 40));
        setMaximumSize(new Dimension(80, 40));
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
