package Custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String name) {
        super(name);
        setForeground(Color.black);
        setPreferredSize(new Dimension(180, 50));
        setMaximumSize(new Dimension(200, 50));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
}
