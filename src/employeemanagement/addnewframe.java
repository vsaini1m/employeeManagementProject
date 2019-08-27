package employeemanagement;
import java.sql.Connection;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;
//import com.sun.jdi.connect.spi.Connection;

public class addnewframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addnewframe frame = new addnewframe();
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
	public addnewframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1068, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter New Employee Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(341, 11, 277, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 98, 106, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 181, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(20, 237, 106, 36);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(181, 84, 239, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email Id :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 332, 106, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(489, 84, 96, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblMobileNo = new JLabel("Mobile no. :");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobileNo.setBounds(489, 175, 96, 20);
		contentPane.add(lblMobileNo);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPosition.setBounds(489, 237, 96, 36);
		contentPane.add(lblPosition);
		
		JLabel lblCountery = new JLabel("Countery :");
		lblCountery.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCountery.setBounds(489, 341, 96, 22);
		contentPane.add(lblCountery);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(181, 159, 239, 41);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(181, 237, 239, 41);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(181, 332, 239, 41);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(631, 82, 273, 41);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(631, 159, 273, 39);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(631, 237, 273, 41);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(631, 332, 273, 41);
		contentPane.add(textField_7);
		
		btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(292, 443, 82, 41);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Save Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idd=textField.getText();
				String firstname=textField_1.getText();
				String lastname=textField_2.getText();
				String emailid=textField_3.getText();
				String agee=textField_4.getText();
				String mobilee=textField_5.getText();
				String positionn=textField_6.getText();
				String counteryy=textField_7.getText();
				int ii=Integer.parseInt(idd);
				Connection con;
				PreparedStatement st;
				ResultSet rs;			
				
				
				
			
				try {
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
					
					
					st=con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
					
					st.setInt(1,ii );
					st.setString(2,firstname);
					st.setString(3, lastname);
					st.setString(4, emailid);
					st.setString(5,agee);
					st.setString(6, mobilee);
					st.setString(7, positionn);
					st.setString(8, counteryy);
					
					int count=st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Inserted ");
					
					st.close();
					con.close();
					menuframe f=new menuframe();
					f.setVisible(true);
					dispose();
					
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Data Insertation Faild !!!"+ee);
				}
			}
			
	
				
				
			//}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kaal\\Desktop\\eimg\\save1.png"));
		btnNewButton_1.setBounds(412, 443, 173, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuframe f=new menuframe();
				f.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(618, 446, 96, 36);
		contentPane.add(btnNewButton_2);
	}
}
