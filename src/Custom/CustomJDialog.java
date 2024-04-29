package Custom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;


public class CustomJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	public String inputTemp ;
//	private InputDialogListener listener;
	public boolean isRun = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomJDialog dialog = new CustomJDialog();
//			dialog.notifi("day la 1 tin nhan");
//			dialog.run(dialog);
			String k1 = dialog.getInput();
			System.out.println(k1 + " la du lieu vua nhap vao");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomJDialog() {
		
	}
	
	public String getInput() {
		EnterInput();
		inputTemp = waitForInput();
		return inputTemp;
	}
	
    public String waitForInput() {
    	while (!isRun) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return inputTemp;
    }
	
	public void notifi(String message) {
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		JLabel text = new JLabel(message);
		JPanel buttonPane = new JPanel();
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		contentPane.add(text);
		getContentPane().add(contentPane , BorderLayout.CENTER);
		
		buttonPane.add(okButton);
		getContentPane().add(buttonPane,BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void EnterInput() {
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		JLabel text = new JLabel("Nhập tên quyền : ");
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200,30));
		JPanel buttonPane = new JPanel();
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTemp = input.getText();
				isRun = true;
				dispose();
			}
		});
		
		contentPane.add(text);
		contentPane.add(input);
		getContentPane().add(contentPane , BorderLayout.CENTER);
		
		buttonPane.add(okButton);
		getContentPane().add(buttonPane,BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	

}
