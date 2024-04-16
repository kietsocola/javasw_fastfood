package Custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabelSecond extends JLabel{
	public MyLabelSecond(String name) {
        super(name);
        setForeground(new Color(43, 42, 63));
        setPreferredSize(new Dimension(80, 40));
        setMaximumSize(new Dimension(80, 40));
        setFont(new Font("Arial", Font.PLAIN, 15));
    }
}
