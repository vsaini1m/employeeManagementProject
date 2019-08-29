package employeemanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menuframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuframe frame = new menuframe();
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
	public menuframe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addnewframe a=new addnewframe();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\00mm.png"));
		btnNewButton.setBounds(0, 0, 282, 234);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editframe d=new editframe();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\Untitled-1.png"));
		btnNewButton_1.setBounds(280, 0, 322, 234);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\data.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				showdata s=new showdata();
				s.setVisible(true);
			}
		});
		button.setBounds(0, 234, 282, 234);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				change c=new change();
				c.setVisible(true);
				
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Eclipse_prjects2\\employeemanagement\\eimg\\change.png"));
		button_1.setBounds(280, 234, 322, 234);
		contentPane.add(button_1);
	}

}
