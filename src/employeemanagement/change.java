package employeemanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class change extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change frame = new change();
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
	public change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password and username carefully");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(281, 11, 403, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New User Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(52, 110, 196, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewUserPassword = new JLabel("New User Password  :");
		lblNewUserPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewUserPassword.setBounds(52, 205, 196, 40);
		contentPane.add(lblNewUserPassword);
		
		textField = new JTextField();
		textField.setBounds(340, 112, 262, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(340, 205, 262, 40);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
					PreparedStatement st=con.prepareStatement("Update userlogin set userpassword='"+textField_1.getText()+"' where username='"+textField.getText()+"'   ");
					st.execute();
					JOptionPane.showMessageDialog(null, "Password Updated");
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Password Updation faild!!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(352, 327, 139, 40);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuframe m=new menuframe();
			m.setVisible(true);
			
			}
		});
		btnCancel.setBounds(582, 327, 94, 40);
		contentPane.add(btnCancel);
	}
}
