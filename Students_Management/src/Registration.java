import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JPasswordField pas;
	private JTextField usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setForeground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setTitle("Wellcome to Spark admin registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 600, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label = new JLabel("New label");
		Label.setForeground(Color.ORANGE);
		ImageIcon img = new ImageIcon (this.getClass().getResource("/spark.png"));
		Label.setIcon(img);
		Label.setBounds(10, 11, 224, 131);
		contentPane.add(Label);
		
		JLabel regLabel = new JLabel("Create Account");
		regLabel.setForeground(Color.WHITE);
		regLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		regLabel.setBounds(244, 11, 315, 45);
		contentPane.add(regLabel);
		
		JLabel userLabel = new JLabel("Username :");
		userLabel.setForeground(Color.ORANGE);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userLabel.setBounds(244, 88, 89, 28);
		contentPane.add(userLabel);
		
		pas = new JPasswordField();
		pas.setBounds(379, 149, 140, 20);
		contentPane.add(pas);
		
		JLabel passLabel = new JLabel(" Password :");
		passLabel.setForeground(Color.ORANGE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passLabel.setBounds(244, 150, 89, 14);
		contentPane.add(passLabel);
		
		usr = new JTextField();
		usr.setBounds(379, 94, 140, 20);
		contentPane.add(usr);
		usr.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usr.getText();
				String password = pas.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					Statement stmt = con.createStatement();
					String sql ="INSERT INTO  tblogin values  ('"+username+"' ,'"+password+"')";
					int rs = stmt.executeUpdate(sql);
					
					
					
					 JOptionPane.showMessageDialog(null,"Registration Successfull..");
					 usr.setText("");
					 pas.setText("");
					 usr.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(337, 225, 134, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(337, 260, 134, 23);
		contentPane.add(btnNewButton_1);
	}
}
