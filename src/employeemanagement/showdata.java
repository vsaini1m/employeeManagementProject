package employeemanagement;
import java.sql.Statement;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;


public class showdata extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showdata frame = new showdata();
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
	
	
	JTextArea textArea = new JTextArea();
	
	public showdata() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 570);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show all data");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM emp");
			
				while(rs.next()) {
					
					textArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+" \n ");
				}
				
				
			}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Error");
			}
				
				
				
				
				
				
			
			}
		});
		btnNewButton.setBounds(24, 269, 129, 35);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuframe m=new menuframe();
				m.setVisible(true);
			}
		});
		btnCancel.setBounds(40, 458, 88, 23);
		contentPane.add(btnCancel);
		JScrollPane jsp;
		
		textField = new JTextField();
		textField.setBounds(0, 75, 173, 20);
		
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\search.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
						Statement st=con.createStatement();
						){
																 ///Where id="+(textField.getText())
					ResultSet rs=st.executeQuery("SELECT * FROM emp Where id="+(textField.getText()));
					rs.next();
					textArea.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSearch.setBounds(73, 95, 100, 35);
		contentPane.add(btnSearch);
		
		JLabel lblSearchById = new JLabel("Search By Id");
		lblSearchById.setBounds(3, 99, 75, 14);
		contentPane.add(lblSearchById);
		
		JLabel lblId = new JLabel("ID ");
		lblId.setBounds(183, 5, 48, 14);
		contentPane.add(lblId);
		
		JLabel lblFirst = new JLabel("First");
		lblFirst.setBounds(273, 5, 48, 14);
		contentPane.add(lblFirst);
		
		JLabel lblLast = new JLabel("Last");
		lblLast.setBounds(370, 5, 48, 14);
		contentPane.add(lblLast);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(470, 5, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(614, 5, 48, 14);
		contentPane.add(lblAge);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(672, 5, 48, 14);
		contentPane.add(lblMobile);
		
		JLabel lblOccat = new JLabel("Occupation");
		lblOccat.setBounds(820, 11, 65, 14);
		contentPane.add(lblOccat);
		
		JLabel lblCountery = new JLabel("Countery");
		lblCountery.setBounds(942, 11, 75, 14);
		contentPane.add(lblCountery);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 30, 883, 508);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		
		textArea.setBackground(new Color(220, 220, 220));
	}
}
