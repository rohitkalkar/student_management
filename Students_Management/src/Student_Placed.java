import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student_Placed extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nametxt;
	private JTextField agetxt;
	private JTextField degreetxt;
	private JTextField emailtxt;
	private JTextField coursetxt;
	private JTextField addresstxt;
	private JTextField companytxt;
	private JTextField pakagetxt;
	private JTextField mobiletxt;
	private JTextField idtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Placed frame = new Student_Placed();
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
	public   void table_load() {
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			Statement stmt = con.createStatement();
			String sql ="Select *from placement";
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
	
		}catch(Exception e) {System.out.print(e);}
		
	}
	public Student_Placed() {
		setTitle("Student Placed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Placement Details", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 168, 404, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 32, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 57, 46, 14);
		panel.add(lblAge);
		
		JLabel lblNewLabel_1_1 = new JLabel("Degree");
		lblNewLabel_1_1.setBounds(10, 82, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setBounds(10, 107, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course");
		lblNewLabel_1_1_1_1.setBounds(10, 132, 46, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1_1_1.setBounds(218, 32, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Company");
		lblNewLabel_1_1_1_1_1_1.setBounds(218, 57, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Pakage");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(218, 82, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Mobile");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(218, 107, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Date");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(218, 132, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setBounds(84, 174, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1);
		
		JRadioButton rdbtnmale = new JRadioButton("Male");
		rdbtnmale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender= "male";
			}
		});
		rdbtnmale.setBackground(Color.ORANGE);
		rdbtnmale.setBounds(122, 170, 70, 23);
		panel.add(rdbtnmale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="female";
			}
		});
		rdbtnFemale.setBackground(Color.ORANGE);
		rdbtnFemale.setBounds(218, 170, 76, 23);
		panel.add(rdbtnFemale);
		javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();{
			group.add(rdbtnmale);
			group.add(rdbtnFemale);
			
		}
		
		nametxt = new JTextField();
		nametxt.setBounds(63, 29, 86, 20);
		panel.add(nametxt);
		nametxt.setColumns(10);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		agetxt.setBounds(63, 54, 86, 20);
		panel.add(agetxt);
		
		degreetxt = new JTextField();
		degreetxt.setColumns(10);
		degreetxt.setBounds(63, 79, 86, 20);
		panel.add(degreetxt);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(63, 104, 86, 20);
		panel.add(emailtxt);
		
		coursetxt = new JTextField();
		coursetxt.setColumns(10);
		coursetxt.setBounds(63, 129, 86, 20);
		panel.add(coursetxt);
		
		addresstxt = new JTextField();
		addresstxt.setColumns(10);
		addresstxt.setBounds(274, 29, 86, 20);
		panel.add(addresstxt);
		
		companytxt = new JTextField();
		companytxt.setColumns(10);
		companytxt.setBounds(274, 54, 86, 20);
		panel.add(companytxt);
		
		pakagetxt = new JTextField();
		pakagetxt.setColumns(10);
		pakagetxt.setBounds(274, 79, 86, 20);
		panel.add(pakagetxt);
		
		mobiletxt = new JTextField();
		mobiletxt.setColumns(10);
		mobiletxt.setBounds(274, 104, 86, 20);
		panel.add(mobiletxt);
		
		JDateChooser Date = new JDateChooser();
		Date.setBounds(271, 132, 89, 20);
		panel.add(Date);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(424, 168, 150, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setBounds(10, 14, 46, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1);
		 table_load();
		idtxt = new JTextField();
		idtxt.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				try {
					String id = idtxt.getText();
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("select name,age,degree,email,course,address,company,pakage,mobile from placement where id =?");
					stmt.setString(1, id);
					ResultSet rs = stmt.executeQuery();
					table_load();
					if(rs.next()==true)
					{
						
						String name = rs.getString(1);
						String age = rs.getString(2);
						String degree = rs.getString(3);
						String email = rs.getString(4);
						String course = rs.getString(5);
						String address = rs.getString(6);
						String company=rs.getString(7);
						String pakage=rs.getString(8);
						String mobile=rs.getString(9);
						
						
						
						     nametxt.setText(name);
							 agetxt.setText(age);
							 degreetxt.setText(degree);
							 emailtxt.setText(email);
							 coursetxt.setText(course);
							 addresstxt.setText(address);
							 companytxt.setText(company);
							 pakagetxt.setText(pakage);
							 mobiletxt.setText(mobile);
							 
							 
						
						
					}else {
						
						nametxt.setText("");
						 agetxt.setText("");
						 degreetxt.setText("");
						 emailtxt.setText("");
						 coursetxt.setText("");
						 addresstxt.setText("");
						 companytxt.setText("");
						pakagetxt.setText("");
						 mobiletxt.setText("");
						 
						
						
						
						
						
					}
					
					
					
					
					
				}catch(Exception e){System.out.print(e);}
				
				
				
			}
		});
		idtxt.setColumns(10);
		idtxt.setBounds(42, 11, 86, 20);
		panel_1.add(idtxt);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name =nametxt.getText();
				String age = agetxt.getText();
				String degree = degreetxt.getText();
				String email = emailtxt.getText();
				String course = coursetxt.getText();
				String company = companytxt.getText();
				String pakage = pakagetxt.getText();				
				String mob=mobiletxt.getText();
				int len=mob.length();
				String address = addresstxt.getText();
				java.util.Date date;
				java.sql.Date sqldate;
				date=Date.getDate();
				sqldate=new java.sql.Date(date.getTime());
				if(len != 10) {
					 JOptionPane.showMessageDialog(null,"Enter a valid mobile number");
				}
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("INSERT INTO  placement (name ,age,degree,email,course,address,company,pakage,mobile,gender,date)values(?,?,?,?,?,?,?,?,?,?,?)");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,degree);
					 stmt.setString(4,email);
					 stmt.setString(5,course);
					 stmt.setString(6,address);
					 stmt.setString(7,company);
					 stmt.setString(8, pakage);
                     stmt.setString(9, mob);
                     stmt.setString(10, gender);
                     stmt.setDate(11, sqldate);
                      
					 stmt.executeUpdate();
					 table_load();				
					 JOptionPane.showMessageDialog(null,"students data added succesfully");
					 
					 nametxt.setText("");
					 agetxt.setText("");
					 degreetxt.setText("");
					 emailtxt.setText("");
					 coursetxt.setText("");
					 addresstxt.setText("");
					 companytxt.setText("");
					pakagetxt.setText("");
					 mobiletxt.setText("");
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
			}
		});
		btnNewButton.setBounds(10, 418, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				 Dashboard db = new Dashboard();
				db.setVisible(true);
			}
		});
		btnExit.setBounds(122, 418, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton_1_1 = new JButton("CLEAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 nametxt.setText("");
				 agetxt.setText("");
				 degreetxt.setText("");
				 emailtxt.setText("");
				 coursetxt.setText("");
				 addresstxt.setText("");
				 companytxt.setText("");
				pakagetxt.setText("");
				 mobiletxt.setText("");
			}
		});
		btnNewButton_1_1.setBounds(225, 418, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("UPDATE");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id =idtxt.getText();
				String name =nametxt.getText();
				String age = agetxt.getText();
				String degree = degreetxt.getText();
				String email = emailtxt.getText();
				String course = coursetxt.getText();
				String company = companytxt.getText();
				String pakage = pakagetxt.getText();				
				String mob=mobiletxt.getText();
				int len=mob.length();
				String address = addresstxt.getText();
				java.util.Date date;
				java.sql.Date sqldate;
				date=Date.getDate();
				sqldate=new java.sql.Date(date.getTime());
				if(len != 10) {
					 JOptionPane.showMessageDialog(null,"Enter a valid mobile number");
				}
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("update  placement set name=? ,age=?,degree=?,email=?,course=?,address=?,company=?,pakage=?,mobile=?,gender=?,date=? where id=?");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,degree);
					 stmt.setString(4,email);
					 stmt.setString(5,course);
					 stmt.setString(6,address);
					 stmt.setString(7,company);
					 stmt.setString(8, pakage);
                     stmt.setString(9, mob);
                     stmt.setString(10, gender);
                     stmt.setDate(11, sqldate);
                     stmt.setString(12,id); 
					 stmt.executeUpdate();
					 table_load();				
					 JOptionPane.showMessageDialog(null,"students data updated succesfully");
					 
					 nametxt.setText("");
					 agetxt.setText("");
					 degreetxt.setText("");
					 emailtxt.setText("");
					 coursetxt.setText("");
					 addresstxt.setText("");
					 companytxt.setText("");
					pakagetxt.setText("");
					 mobiletxt.setText("");
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
				
				
			}
		});
		btnNewButton_1_1_1.setBounds(325, 418, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = idtxt.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("delete from placement  where id=?");

					
                     stmt.setString(1, id);
                      
					 stmt.executeUpdate();
										
					 JOptionPane.showMessageDialog(null,"record deleted....");
					 table_load();
					 nametxt.setText("");
					 agetxt.setText("");
					 degreetxt.setText("");
					 emailtxt.setText("");
					 coursetxt.setText("");
					 addresstxt.setText("");
					 companytxt.setText("");
					pakagetxt.setText("");
					 mobiletxt.setText("");
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
			}
		});
		btnNewButton_1_1_1_1.setBounds(440, 418, 89, 23);
		contentPane.add(btnNewButton_1_1_1_1);
	}
	
	
	private String gender;
}
