import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student_Admision extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nametextField;
	private JTextField agetextField_1;
	private JTextField degreetextField_2;
	private JTextField emailtextField_3;
	private JTextField coursetextField_4;
	private JTextField feestextField_5;
	private JTextField mobiletextField_6;
	private JTextField addresstextField_7;
	private JTextField idtextField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Admision frame = new Student_Admision();
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
			String sql ="Select *from studentad";
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
	
		}catch(Exception e) {System.out.print(e);}
		
	}
	
	
	
	
	
	public Student_Admision() {
		setTitle("Students Admision");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Students Details", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel.setBackground(Color.RED);
		panel.setBounds(10, 174, 475, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 62, 46, 14);
		panel.add(lblAge);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(10, 73, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Degree");
		lblNewLabel_1_1_1.setBounds(10, 98, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setBounds(10, 134, 46, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Mobile");
		lblNewLabel_1_1_1_1_1.setBounds(253, 62, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1_1_1_1.setBounds(253, 98, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Course");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 169, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Fees");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(253, 22, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Date");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(253, 134, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setBounds(253, 169, 46, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(54, 19, 86, 20);
		panel.add(nametextField);
		nametextField.setColumns(10);
		
		agetextField_1 = new JTextField();
		agetextField_1.setColumns(10);
		agetextField_1.setBounds(54, 59, 86, 20);
		panel.add(agetextField_1);
		
		degreetextField_2 = new JTextField();
		degreetextField_2.setColumns(10);
		degreetextField_2.setBounds(54, 95, 86, 20);
		panel.add(degreetextField_2);
		
		emailtextField_3 = new JTextField();
		emailtextField_3.setColumns(10);
		emailtextField_3.setBounds(54, 131, 86, 20);
		panel.add(emailtextField_3);
		
		coursetextField_4 = new JTextField();
		coursetextField_4.setColumns(10);
		coursetextField_4.setBounds(54, 166, 86, 20);
		panel.add(coursetextField_4);
		
		feestextField_5 = new JTextField();
		feestextField_5.setColumns(10);
		feestextField_5.setBounds(293, 19, 86, 20);
		panel.add(feestextField_5);
		
		mobiletextField_6 = new JTextField();
		mobiletextField_6.setColumns(10);
		mobiletextField_6.setBounds(293, 59, 86, 20);
		panel.add(mobiletextField_6);
		
		addresstextField_7 = new JTextField();
		addresstextField_7.setColumns(10);
		addresstextField_7.setBounds(293, 95, 86, 20);
		panel.add(addresstextField_7);
		
		JDateChooser Date = new JDateChooser();
		Date.setBounds(293, 128, 86, 20);
		panel.add(Date);
		
		JRadioButton malebtn = new JRadioButton("male");
		malebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender ="male";
			}
		});
		malebtn.setBounds(292, 165, 52, 23);
		panel.add(malebtn);
		
		JRadioButton femalebtn = new JRadioButton("female");
		femalebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "female";
			}
		});
		femalebtn.setBounds(360, 165, 62, 23);
		panel.add(femalebtn);
		ButtonGroup group = new ButtonGroup ();{
			group.add(malebtn);
			group.add(femalebtn);
			
		}
		table_load();
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(495, 174, 179, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("ID");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(10, 21, 26, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1_2);
		
		idtextField_8 = new JTextField();
		idtextField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					String id = idtextField_8.getText();
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("select name,age,degree,email,course,fees,mobile,address from studentad where id =?");
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
						String fees = rs.getString(6);
						String mobile=rs.getString(7);
						String address=rs.getString(8);
						
						
						
						     nametextField.setText(name);
							 agetextField_1.setText(age);
							 degreetextField_2.setText(degree);
							 emailtextField_3.setText(email);
							 coursetextField_4.setText(course);
							 feestextField_5.setText(fees);
							 mobiletextField_6.setText(mobile);
							 addresstextField_7.setText(address);
							 
							 
						
						
					}else {
						
						 nametextField.setText("");
						 agetextField_1.setText("");
						 degreetextField_2.setText("");
						 emailtextField_3.setText("");
						 coursetextField_4.setText("");
						 feestextField_5.setText("");
						 mobiletextField_6.setText("");
						 addresstextField_7.setText("");
						 
						
						
						
						
						
					}
					
					
					
					
					
				}catch(Exception e){System.out.print(e);}
				
				
				
			}
		});
		idtextField_8.setColumns(10);
		idtextField_8.setBounds(47, 18, 86, 20);
		panel_1.add(idtextField_8);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name =nametextField.getText();
				String age = agetextField_1.getText();
				String degree = degreetextField_2.getText();
				String email = emailtextField_3.getText();
				String course = coursetextField_4.getText();
				String fees = feestextField_5.getText();
				String mob=mobiletextField_6.getText();
				int len=mob.length();
				String address = addresstextField_7.getText();
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
					PreparedStatement stmt = con.prepareStatement("INSERT INTO  studentad (name ,age,degree,email,course,fees,mobile,address,gender,date)values(?,?,?,?,?,?,?,?,?,?)");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,degree);
					 stmt.setString(4,email);
					 stmt.setString(5,course);
					 stmt.setString(6,fees);
					 stmt.setString(7,mob);
					 stmt.setString(8, address);
                     stmt.setString(9, gender);
                     stmt.setDate(10, sqldate);
                      
					 stmt.executeUpdate();
					 table_load();				
					 JOptionPane.showMessageDialog(null,"students data added succesfully");
					 
					 nametextField.setText("");
					 agetextField_1.setText("");
					 degreetextField_2.setText("");
					 emailtextField_3.setText("");
					 coursetextField_4.setText("");
					 feestextField_5.setText("");
					 mobiletextField_6.setText("");
					 addresstextField_7.setText("");
					 nametextField.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(25, 460, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				 Dashboard db = new Dashboard();
				db.setVisible(true);
			}
		});
		btnExit.setBounds(141, 460, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton_1_1 = new JButton("CLEAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 nametextField.setText("");
				 agetextField_1.setText("");
				 degreetextField_2.setText("");
				 emailtextField_3.setText("");
				 coursetextField_4.setText("");
				 feestextField_5.setText("");
				 mobiletextField_6.setText("");
				 addresstextField_7.setText("");
				 idtextField_8.setText("");
			}
		});
		btnNewButton_1_1.setBounds(275, 460, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("UPDATE");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id =idtextField_8.getText();
				String name =nametextField.getText();
				String age = agetextField_1.getText();
				String degree = degreetextField_2.getText();
				String email = emailtextField_3.getText();
				String course = coursetextField_4.getText();
				String fees = feestextField_5.getText();
				String mob=mobiletextField_6.getText();
				int len=mob.length();
				String address = addresstextField_7.getText();
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
					PreparedStatement stmt = con.prepareStatement("update  studentad set name=? ,age=?,degree=?,email=?,course=?,fees=?,mobile=?,address=?,gender=?,date=? where id=?");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,degree);
					 stmt.setString(4,email);
					 stmt.setString(5,course);
					 stmt.setString(6,fees);
					 stmt.setString(7,mob);
					 stmt.setString(8, address);
                     stmt.setString(9, gender);
                     stmt.setDate(10, sqldate);
                     stmt.setString(11, id);
					 stmt.executeUpdate();
					 table_load();				
					 JOptionPane.showMessageDialog(null,"students data updated succesfully");
					 
					 nametextField.setText("");
					 agetextField_1.setText("");
					 degreetextField_2.setText("");
					 emailtextField_3.setText("");
					 coursetextField_4.setText("");
					 feestextField_5.setText("");
					 mobiletextField_6.setText("");
					 addresstextField_7.setText("");
					 nametextField.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1_1.setBounds(396, 460, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idtextField_8.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("delete from studentad  where id=?");

					
                     stmt.setString(1, id);
                      
					 stmt.executeUpdate();
										
					 JOptionPane.showMessageDialog(null,"record deleted....");
					 table_load();
					 nametextField.setText("");
					 agetextField_1.setText("");
					 degreetextField_2.setText("");
					 emailtextField_3.setText("");
					 coursetextField_4.setText("");
					 feestextField_5.setText("");
					 mobiletextField_6.setText("");
					 addresstextField_7.setText("");
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
			}
		});
		btnNewButton_1_1_1_1.setBounds(536, 460, 89, 23);
		contentPane.add(btnNewButton_1_1_1_1);
	}
	
	private String gender ;
}
