package employeemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

//import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame.setResizable(false);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 755, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\user.png"));
		label.setBounds(220, 11, 224, 155);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(244, 193, 208, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setEchoChar('*');
		passwordField.setBounds(244, 257, 208, 33);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String u=textField.getText();
					String p=passwordField.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
					Statement  st=con.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM userlogin ");
					rs.next();
					String user=rs.getString(1);
					String password=rs.getString(2);
					
					rs.next();
					String userhid=rs.getString(1);
					String userhide=rs.getString(2);
					
					if(u.equals(user)&&p.equals(password)||u.equals(userhid)&&p.equals(userhide)) {
						menuframe m=new menuframe();
						
						m.setVisible(true);
						frame.dispose();
						
						//dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "User Name or Password is Wrong!!");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kaal\\Desktop\\eimg\\k1.png"));
		btnNewButton.setFont(new Font("Kartika", Font.BOLD, 15));
		btnNewButton.setBounds(265, 329, 155, 42);
		frame.getContentPane().add(btnNewButton);
	}
}
