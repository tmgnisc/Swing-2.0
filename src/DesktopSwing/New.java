package DesktopSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class New extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField age_field;
	private JTable table;
	private JTextField address_field;
	private JCheckBox box1;
    private JCheckBox box2;
    private JCheckBox box3;
	
	/**
	 * Create the frame.
	 */
	public New() {
		setTitle("Student Identification Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 98, 103, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(399, 91, 68, 52);
		contentPane.add(lblNewLabel_1);
		
		name_field = new JTextField();
		name_field.setBounds(141, 101, 173, 39);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		age_field = new JTextField();
		age_field.setBounds(457, 104, 162, 39);
		contentPane.add(age_field);
		age_field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("College");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(51, 160, 91, 39);
		contentPane.add(lblNewLabel_2);
		
		JComboBox college_field = new JComboBox();
		college_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		college_field.setModel(new DefaultComboBoxModel(new String[] {"-----SELECT-----", "Virinchi", "patan", "AIMS", "British", "Vedas"}));
		college_field.setBounds(141, 163, 173, 36);
		contentPane.add(college_field);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gender.setBounds(734, 91, 76, 39);
		contentPane.add(gender);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(" Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(824, 98, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(824, 134, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Student Identification Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4.setBounds(51, 21, 351, 39);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=name_field.getText();
			String age=age_field.getText();
			String address=address_field.getText();
			String college=college_field.getSelectedItem().toString();
			String grade="";
			// Inside your actionPerformed method
			if (box1.isSelected()) {
			    grade = box1.getText();
			} else if (box2.isSelected()) {
			    grade = box2.getText();
			} else if (box3.isSelected()) {
			    grade = box3.getText();
			}

			
			String gender="";
			if(rdbtnNewRadioButton.isSelected()) {
				gender="Male";
			}
			if(rdbtnNewRadioButton_1.isSelected()) {
				gender="Female";
			}
			else {
				gender="Other";
			}
			
			//casting
			DefaultTableModel Model=(DefaultTableModel)table.getModel();
			Model.addRow(new Object[] {name,age,gender,college,grade,address});
			JOptionPane.showMessageDialog(null, "Form Submitted");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(804, 224, 111, 39);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Agree to save ?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(616, 235, 164, 30);
		contentPane.add(chckbxNewCheckBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 274, 864, 17);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 297, 884, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Age", "Address", "College","Class", "Gender"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(51, 232, 76, 23);
		contentPane.add(lblNewLabel_5);
		
		address_field = new JTextField();
		address_field.setBounds(141, 224, 173, 39);
		contentPane.add(address_field);
		address_field.setColumns(10);
		
		JLabel class_field = new JLabel("Class");
		class_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		class_field.setBounds(399, 167, 71, 24);
		contentPane.add(class_field);
		
		// Remove the data type (JCheckBox) when initializing checkboxes
		box1 = new JCheckBox("School Level");
		box1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		box1.setBounds(477, 160, 162, 39);
		contentPane.add(box1);

		box2 = new JCheckBox("Bachelors");
		box2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		box2.setBounds(477, 202, 162, 23);
		contentPane.add(box2);

		box3 = new JCheckBox("Masters");
		box3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		box3.setBounds(477, 235, 99, 23);
		contentPane.add(box3);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(box1);
		buttonGroup.add(box2);
		buttonGroup.add(box3);


}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New frame = new New();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
