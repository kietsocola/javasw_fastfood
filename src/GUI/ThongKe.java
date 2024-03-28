package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ThongKe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe window = new ThongKe();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThongKe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel navthongke = new JPanel();
		navthongke.setBackground(new Color(0, 0, 0));
		navthongke.setBounds(0, 0, 104, 835);
		frame.getContentPane().add(navthongke);
		
		JLabel thongkeHeading = new JLabel("Dashboard");
		thongkeHeading.setForeground(new Color(255, 255, 255));
		thongkeHeading.setFont(new Font("Tahoma", Font.BOLD, 28));
		thongkeHeading.setBounds(128, 24, 152, 41);
		frame.getContentPane().add(thongkeHeading);
		
		JLabel lblNewLabel = new JLabel("Tuesday 2 Feb, 2021");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(204, 204, 204));
		lblNewLabel.setBounds(128, 75, 152, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(128, 119, 738, 1);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("+32.40%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(51, 255, 0));
		lblNewLabel_1.setBounds(213, 164, 59, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("$10,243.00");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(154, 186, 167, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Revenue");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_3.setBounds(157, 237, 110, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Order Report");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(169, 300, 144, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Filter Order");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(706, 291, 128, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Customer");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(169, 371, 95, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Menu");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(369, 371, 48, 13);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Total Payment");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(526, 371, 128, 13);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Status");
		lblNewLabel_5_3.setForeground(Color.WHITE);
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_3.setBounds(739, 371, 95, 13);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(128, 416, 738, 1);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("+32.40%");
		lblNewLabel_1_1.setForeground(new Color(51, 255, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(468, 164, 59, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("$10,243.00");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1.setBounds(409, 186, 167, 41);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Total Revenue");
		lblNewLabel_3_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(412, 237, 110, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("+32.40%");
		lblNewLabel_1_1_1.setForeground(new Color(51, 255, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(702, 164, 59, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("$10,243.00");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1.setBounds(643, 186, 167, 41);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Total Revenue");
		lblNewLabel_3_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(646, 237, 110, 13);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(926, 24, 380, 429);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Most Ordered");
		lblNewLabel_6.setBounds(22, 34, 136, 25);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_6);
		
		JButton btnToday = new JButton("Today");
		btnToday.setForeground(Color.WHITE);
		btnToday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnToday.setBackground(new Color(102, 102, 102));
		btnToday.setBounds(267, 25, 95, 45);
		panel_2.add(btnToday);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(22, 93, 340, 1);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(22, 104, 60, 60);
		panel_2.add(panel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(92, 113, 220, 13);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("200 dishes ordered");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setForeground(new Color(204, 204, 204));
		lblNewLabel_8.setBounds(92, 136, 113, 13);
		panel_2.add(lblNewLabel_8);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBounds(22, 192, 60, 60);
		panel_2.add(panel_4_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_1.setBounds(92, 201, 220, 13);
		panel_2.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("200 dishes ordered");
		lblNewLabel_8_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8_1.setBounds(92, 224, 113, 13);
		panel_2.add(lblNewLabel_8_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBounds(22, 277, 60, 60);
		panel_2.add(panel_4_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("Spicy seasoned seafood noodles");
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_2.setBounds(92, 286, 220, 13);
		panel_2.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("200 dishes ordered");
		lblNewLabel_8_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8_2.setBounds(92, 309, 113, 13);
		panel_2.add(lblNewLabel_8_2);
		
		JButton btnView = new JButton("View All");
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnView.setBackground(new Color(102, 102, 102));
		btnView.setBounds(22, 358, 340, 48);
		panel_2.add(btnView);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(169, 460, 32, 32);
		frame.getContentPane().add(panel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Eren Jaegar");
		lblNewLabel_9.setForeground(new Color(204, 204, 204));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(220, 470, 78, 13);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Spicy seasoned seafood noodles ");
		lblNewLabel_9_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1.setBounds(369, 464, 122, 25);
		frame.getContentPane().add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("$125");
		lblNewLabel_9_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2.setBounds(526, 470, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_2);
		
		JButton btnCompleted = new JButton("Completed");
		btnCompleted.setForeground(new Color(0, 255, 0));
		btnCompleted.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompleted.setBackground(new Color(0, 102, 0));
		btnCompleted.setBounds(739, 460, 90, 26);
		frame.getContentPane().add(btnCompleted);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(169, 527, 32, 32);
		frame.getContentPane().add(panel_5_1);
		
		JLabel lblNewLabel_9_3 = new JLabel("Eren Jaegar");
		lblNewLabel_9_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_3.setBounds(220, 537, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Spicy seasoned seafood noodles ");
		lblNewLabel_9_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1_1.setBounds(369, 531, 122, 25);
		frame.getContentPane().add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("$125");
		lblNewLabel_9_2_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2_1.setBounds(526, 537, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_2_1);
		
		JButton btnCompleted_1 = new JButton("Completed");
		btnCompleted_1.setForeground(Color.GREEN);
		btnCompleted_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompleted_1.setBackground(new Color(0, 102, 0));
		btnCompleted_1.setBounds(739, 527, 90, 26);
		frame.getContentPane().add(btnCompleted_1);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBounds(169, 593, 32, 32);
		frame.getContentPane().add(panel_5_1_1);
		
		JLabel lblNewLabel_9_3_1 = new JLabel("Eren Jaegar");
		lblNewLabel_9_3_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_3_1.setBounds(220, 603, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_3_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Spicy seasoned seafood noodles ");
		lblNewLabel_9_1_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1_1_1.setBounds(369, 597, 122, 25);
		frame.getContentPane().add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_2_1_1 = new JLabel("$125");
		lblNewLabel_9_2_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2_1_1.setBounds(526, 603, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_2_1_1);
		
		JButton btnCompleted_1_1 = new JButton("Completed");
		btnCompleted_1_1.setForeground(Color.GREEN);
		btnCompleted_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompleted_1_1.setBackground(new Color(0, 102, 0));
		btnCompleted_1_1.setBounds(739, 593, 90, 26);
		frame.getContentPane().add(btnCompleted_1_1);
		
		JPanel panel_5_1_2 = new JPanel();
		panel_5_1_2.setBounds(169, 660, 32, 32);
		frame.getContentPane().add(panel_5_1_2);
		
		JLabel lblNewLabel_9_3_2 = new JLabel("Eren Jaegar");
		lblNewLabel_9_3_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_3_2.setBounds(220, 670, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_3_2);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("Spicy seasoned seafood noodles ");
		lblNewLabel_9_1_1_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1_1_2.setBounds(369, 664, 122, 25);
		frame.getContentPane().add(lblNewLabel_9_1_1_2);
		
		JLabel lblNewLabel_9_2_1_2 = new JLabel("$125");
		lblNewLabel_9_2_1_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2_1_2.setBounds(526, 670, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_2_1_2);
		
		JButton btnCompleted_1_2 = new JButton("Completed");
		btnCompleted_1_2.setForeground(Color.GREEN);
		btnCompleted_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompleted_1_2.setBackground(new Color(0, 102, 0));
		btnCompleted_1_2.setBounds(739, 660, 90, 26);
		frame.getContentPane().add(btnCompleted_1_2);
		
		JPanel panel_5_1_3 = new JPanel();
		panel_5_1_3.setBounds(169, 727, 32, 32);
		frame.getContentPane().add(panel_5_1_3);
		
		JLabel lblNewLabel_9_3_3 = new JLabel("Eren Jaegar");
		lblNewLabel_9_3_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_3_3.setBounds(220, 737, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_3_3);
		
		JLabel lblNewLabel_9_1_1_3 = new JLabel("Spicy seasoned seafood noodles ");
		lblNewLabel_9_1_1_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1_1_3.setBounds(369, 731, 122, 25);
		frame.getContentPane().add(lblNewLabel_9_1_1_3);
		
		JLabel lblNewLabel_9_2_1_3 = new JLabel("$125");
		lblNewLabel_9_2_1_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_9_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2_1_3.setBounds(526, 737, 78, 13);
		frame.getContentPane().add(lblNewLabel_9_2_1_3);
		
		JButton btnCompleted_1_3 = new JButton("Completed");
		btnCompleted_1_3.setForeground(Color.GREEN);
		btnCompleted_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompleted_1_3.setBackground(new Color(0, 102, 0));
		btnCompleted_1_3.setBounds(739, 727, 90, 26);
		frame.getContentPane().add(btnCompleted_1_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 0));
		panel_6.setBounds(926, 470, 380, 300);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("Most Type of Order");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(23, 32, 197, 25);
		panel_6.add(lblNewLabel_6_1);
		
		JButton btnToday_1 = new JButton("Today");
		btnToday_1.setForeground(Color.WHITE);
		btnToday_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnToday_1.setBackground(new Color(102, 102, 102));
		btnToday_1.setBounds(263, 23, 95, 45);
		panel_6.add(btnToday_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(204, 204, 204));
		panel_3_1.setBounds(23, 89, 340, 1);
		panel_6.add(panel_3_1);
	}
}