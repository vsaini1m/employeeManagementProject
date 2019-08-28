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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(418, 11, 261, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(884, 17, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
	
		btnSearch.setBounds(1023, 16, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblEnterId = new JLabel("Enter id");
		lblEnterId.setBounds(884, 0, 48, 14);
		contentPane.add(lblEnterId);
		
		JTextField lblNewLabel_1 = new JTextField("ID");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 113, 264, 27);
		contentPane.add(lblNewLabel_1);
		
		JTextField lblNewLabel_2 = new JTextField("First Name");
		lblNewLabel_2.setForeground(Color.MAGENTA);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 236, 264, 25);
		contentPane.add(lblNewLabel_2);
		
		JTextField lblNewLabel_3 = new JTextField("Last Name");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 352, 264, 27);
		contentPane.add(lblNewLabel_3);
		
		JTextField lblNewLabel_4 = new JTextField("Email Id");
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 465, 264, 27);
		contentPane.add(lblNewLabel_4);
		
		JTextField lblNewLabel_5 = new JTextField("Countery");
		lblNewLabel_5.setForeground(Color.MAGENTA);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(418, 465, 261, 27);
		contentPane.add(lblNewLabel_5);
		
		JTextField lblNewLabel_6 = new JTextField("Age");
		lblNewLabel_6.setForeground(Color.MAGENTA);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(418, 113, 261, 27);
		contentPane.add(lblNewLabel_6);
		
		JTextField lblNewLabel_7 = new JTextField("Mobile No.");
		lblNewLabel_7.setForeground(Color.MAGENTA);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(418, 223, 261, 27);
		contentPane.add(lblNewLabel_7);
		
		JTextField label = new JTextField("Position");
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
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
				PreparedStatement st=con.prepareStatement("Update emp values(?,?,?,?,?,?,?,?)Where id='"+(textField.getText()) );
				
				st.setInt(1, ii);
				st.setString(2, firstname);
				st.setString(3, lastname);
				st.setString(4, emailid);
				st.setString(5, agee);
				st.setString(6, mobilee);
				st.setString(7, positionn);
				st.setString(8, counteryy);
				
				int count=st.executeUpdate();
				
				
	//			ResultSet rs=st.executeQuery("Update emp set id='"+ii+"','"+firstname+"','"+lastname+"','"+emailid+"','"+agee+"','"+mobilee+"','"+positionn+"','"+counteryy);
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
					lblNewLabel_5.setText(ee);
					lblNewLabel_6.setText(f);
					lblNewLabel_7.setText(g);
					label.setText(h);
					//lblNewLabel_9.setText();
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
	}
}
