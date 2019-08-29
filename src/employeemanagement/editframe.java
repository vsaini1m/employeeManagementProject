package employeemanagement;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class editframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editframe frame = new editframe();
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
	public editframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(418, 11, 261, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(825, 10, 157, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\search.png"));
	
		btnSearch.setBounds(982, 9, 130, 36);
		contentPane.add(btnSearch);
		
		JLabel lblEnterId = new JLabel("Enter id");
		lblEnterId.setBounds(857, 55, 48, 14);
		contentPane.add(lblEnterId);
		
		JTextField lblNewLabel_1 = new JTextField("");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 113, 264, 27);
		contentPane.add(lblNewLabel_1);
		
		JTextField lblNewLabel_2 = new JTextField("");
		lblNewLabel_2.setForeground(Color.MAGENTA);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 236, 264, 25);
		contentPane.add(lblNewLabel_2);
		
		JTextField lblNewLabel_3 = new JTextField("");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 352, 264, 27);
		contentPane.add(lblNewLabel_3);
		
		JTextField lblNewLabel_4 = new JTextField("");
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 465, 264, 27);
		contentPane.add(lblNewLabel_4);
		
		JTextField lblNewLabel_5 = new JTextField("");
		lblNewLabel_5.setForeground(Color.MAGENTA);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(418, 465, 261, 27);
		contentPane.add(lblNewLabel_5);
		
		JTextField lblNewLabel_6 = new JTextField("");
		lblNewLabel_6.setForeground(Color.MAGENTA);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(418, 113, 261, 27);
		contentPane.add(lblNewLabel_6);
		
		JTextField lblNewLabel_7 = new JTextField("");
		lblNewLabel_7.setForeground(Color.MAGENTA);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(418, 235, 261, 27);
		contentPane.add(lblNewLabel_7);
		
		JTextField label = new JTextField("");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(418, 352, 261, 27);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idd=lblNewLabel_1.getText();
				String firstname=lblNewLabel_2.getText();
				String lastname=lblNewLabel_3.getText();
				String emailid=lblNewLabel_4.getText();
				String agee=lblNewLabel_5.getText();
				String mobilee=lblNewLabel_6.getText();
				String positionn=lblNewLabel_7.getText();
				String counteryy=lblNewLabel.getText();
				
			//	String lblNewLabel
				int ii=Integer.parseInt(idd);
				
				
				
				
			try {

				String sql="Update emp set id='"+lblNewLabel_1.getText()+"',first='"+lblNewLabel_2.getText()+"',last='"+lblNewLabel_3.getText()+"',email='"+lblNewLabel_4.getText()+"',age='"+lblNewLabel_6.getText()+"',mobile='"+lblNewLabel_7.getText()+"',position='"+label.getText()+"',country='"+lblNewLabel_5.getText()+"' where id='"+textField.getText()+"' ";
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
				
				PreparedStatement st=con.prepareStatement(sql);
				
				st.execute();
								

				JOptionPane.showMessageDialog(null, "Data Updated");
	
			
				
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "data updation faild"+e2);
			}
				
			}
		});
		btnNewButton.setBounds(956, 151, 103, 45);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root", "root");
				Statement st=con.createStatement();
			st.execute("Delete from emp Where id="+(textField.getText()));
				
				JOptionPane.showMessageDialog(null, "Delete Sucessfully");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Deletion Faild"+e2);
			}
				
			}
		});
		btnDelete.setBounds(956, 261, 103, 45);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuframe a=new menuframe();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(967, 379, 79, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblId.setBounds(97, 74, 89, 27);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblFirstName.setBounds(88, 198, 117, 27);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblLastName.setBounds(88, 314, 117, 27);
		contentPane.add(lblLastName);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblEmailId.setBounds(88, 427, 117, 27);
		contentPane.add(lblEmailId);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblAge.setBounds(453, 74, 72, 27);
		contentPane.add(lblAge);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblMobile.setBounds(453, 198, 89, 27);
		contentPane.add(lblMobile);
		
		JLabel lblPosition = new JLabel("Occupation");
		lblPosition.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblPosition.setBounds(453, 314, 143, 27);
		contentPane.add(lblPosition);
		
		JLabel lblCountery = new JLabel("Countery");
		lblCountery.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblCountery.setBounds(453, 434, 127, 20);
		contentPane.add(lblCountery);
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
					Statement  st=con.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM emp Where id="+(textField.getText()));
					rs.next();
					
					String a=rs.getString(1);
					String b=rs.getString(2);
					String c=rs.getString(3);
					String d=rs.getString(4);
					String ee=rs.getString(5);
					String f=rs.getString(6);
					String g=rs.getString(7);
					String h=rs.getString(8);
					
					
					lblNewLabel_1.setText(a);
					lblNewLabel_2.setText(b);
					lblNewLabel_3.setText(c);
					lblNewLabel_4.setText(d);
					lblNewLabel_6.setText(ee);
					lblNewLabel_7.setText(f);
					label.setText(g);
					lblNewLabel_5.setText(h);
					//label.setText(h);
					//lblNewLabel_9.setText();
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
	}
}
