package Custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabelSecond extends JLabel{
	public MyLabelSecond(String name) {
        super(name);
        setForeground(new Color(85, 85, 85));
        setPreferredSize(new Dimension(115, 40));
        setMaximumSize(new Dimension(80, 40));
        Font defaultFont = new Font("Arial", Font.PLAIN, 15);
        Font boldFont = defaultFont.deriveFont(Font.BOLD);
        setFont(boldFont);
    }
}
