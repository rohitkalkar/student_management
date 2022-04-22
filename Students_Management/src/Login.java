import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
				
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
	public Login() {
		setTitle("Spark Institute");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 101, -109, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/students.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(0, 0, 484, 311);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.add(lblNewLabel_2);
		lblNewLabel_2.setBounds(104, 140, 111, 31);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(101, 83, 99, 30);
		
		pass = new JPasswordField();
		pass.setBounds(225, 145, 126, 20);
		lblNewLabel.add(pass);
		
		user = new JTextField();
		lblNewLabel.add(user);
		user.setBounds(224, 88, 121, 20);user.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					Statement stmt = con.createStatement();
					String sql ="Select *from tblogin where username='"+user.getText()+"' and password ='"+pass.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					Dashboard db = new Dashboard();
					if(rs.next())
						
					db.setVisible(true);
					else JOptionPane.showMessageDialog(null,"Incorrect username and password..");
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(98, 226, 80, 23);
		lblNewLabel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		lblNewLabel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnNewButton_1) {

                dispose();
				Registration reg = new Registration();
			
				reg.setVisible(true);
				
				
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(298, 224, 95, 23);
	}

	protected static void close() {
		// TODO Auto-generated method stub
		
	}

	private void setColumns(int i) {
		// TODO Auto-generated method stub
		
	}
}
