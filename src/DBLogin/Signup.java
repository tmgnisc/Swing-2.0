package DBLogin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.apache.commons.codec.digest.*;
import DesktopSwing.Login;

public class Signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;

    // Declare labels at the class level
    private JLabel emptyusernamelbl;
    private JLabel emptypasswordlbl;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signup frame = new Signup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 875, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Set background color
        contentPane.setBackground(new Color(240, 240, 240));

        JLabel lblNewUserPlease = new JLabel("Sign Up");
        lblNewUserPlease.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewUserPlease.setBounds(272, 50, 300, 30);
        contentPane.add(lblNewUserPlease);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setBounds(165, 130, 71, 15);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(166, 195, 70, 15);
        contentPane.add(lblPassword);

        user = new JTextField();
        user.setBounds(254, 125, 262, 30);
        contentPane.add(user);
        user.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(254, 190, 262, 30);
        contentPane.add(pass);

        // Initialize labels
        emptyusernamelbl = new JLabel(" ");
        emptyusernamelbl.setForeground(Color.RED);
        emptyusernamelbl.setBounds(282, 98, 194, 15);
        contentPane.add(emptyusernamelbl);

        emptypasswordlbl = new JLabel(" ");
        emptypasswordlbl.setForeground(Color.RED);
        emptypasswordlbl.setBounds(264, 167, 194, 15);
        contentPane.add(emptypasswordlbl);

        JButton btnSignup = new JButton("Signup");
        btnSignup.setForeground(Color.WHITE);
        btnSignup.setBackground(new Color(0, 128, 0));
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignup.addActionListener(e -> {
            // Handle signup logic
            String enteredUsername = user.getText();
            String enteredPassword = new String(pass.getPassword());

            if (enteredUsername.isEmpty()) {
                emptyusernamelbl.setText("Username is empty");
                emptypasswordlbl.setText("");

            } else if (enteredPassword.isEmpty()) {
                emptyusernamelbl.setText("");
                emptypasswordlbl.setText("Password is empty.");
            } else {
                emptyusernamelbl.setText("");
                emptypasswordlbl.setText("");

                // Move registration logic here
                String hashedpassword = DigestUtils.md5Hex(enteredPassword);

                String url = "jdbc:mysql://localhost:3306/testdb";
                String dbusername = "root";
                String dbpassword = "";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
                    String insertquery = "Insert into login (username, password) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(insertquery)) {
                        preparedStatement.setString(1, enteredUsername);
                        preparedStatement.setString(2, hashedpassword);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("User registered successfully!");
                        } else {
                            System.out.println("Failed to register user.");
                        }
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnSignup.setBounds(322, 260, 117, 30);
        contentPane.add(btnSignup);

        JButton btnBackToLogin = new JButton("Back to Login");
        btnBackToLogin.setForeground(Color.WHITE);
        btnBackToLogin.setBackground(new Color(0, 0, 128));
        btnBackToLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBackToLogin.addActionListener(e -> {
            // Handle back to login logic
            new LoginPage().setVisible(true);
            dispose();
        });
        btnBackToLogin.setBounds(312, 316, 140, 27);
        contentPane.add(btnBackToLogin);
    }
}
