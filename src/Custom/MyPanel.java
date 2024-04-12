package Custom;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	public MyPanel() {
        super();
        setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
    }
	public MyPanel(CardLayout layout) {
        super(layout);
        setBackground(MyColor.PRIMARY_BAKCGROUND_COLOR);
    }
}
