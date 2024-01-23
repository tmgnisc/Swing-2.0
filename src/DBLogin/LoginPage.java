package DBLogin;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.digest.DigestUtils;

import DesktopSwing.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLogin.setBounds(287, 57, 72, 36);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setBounds(141, 164, 72, 15);
		contentPane.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(141, 108, 72, 15);
		contentPane.add(lblUsername_1);
		
		user = new JTextField();
		user.setBounds(229, 106, 154, 29);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(231, 162, 154, 29);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
					Statement stm = con.createStatement();
					String enteredUsername = user.getText();
					String enteredPassword = pass.getText();
					String hashedEnteredPassword = DigestUtils.md5Hex(enteredPassword);
					String sql = "select * from login where username='" + enteredUsername + "' and password='" +hashedEnteredPassword + "'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Login Done");
				Home homePage = new Home(enteredUsername);
				homePage.setVisible(true);
				dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Details");
				}
					con.close();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			}
		});
		btnLogin.setBounds(373, 227, 117, 25);
		contentPane.add(btnLogin);
		
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Signup().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(141, 227, 117, 25);
		contentPane.add(btnNewButton);
	}
}
