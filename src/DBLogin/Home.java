package DBLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel usernamelbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Home frame = new Home("enteredUsername");  // Pass the entered username here
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}


	/**
	 * Create the frame.
	 */
	public Home(String enteredUsername) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setBounds(358, 86, 73, 15);
		contentPane.add(lblWelcome);
		
		usernamelbl = new JLabel(enteredUsername);
		usernamelbl.setFont(new Font("Dialog", Font.BOLD, 20));
		usernamelbl.setForeground(Color.GREEN);
		usernamelbl.setBounds(433, 86, 161, 21);
		contentPane.add(usernamelbl);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginPage().setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(441, 335, 117, 25);
		contentPane.add(btnLogout);
	}
}
