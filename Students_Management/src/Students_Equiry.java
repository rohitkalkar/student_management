import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EtchedBorder;

public class Students_Equiry extends JFrame {

	private JPanel contentPane;
	private JTextField NAMEtextField_1;
	private JTextField AGEtextField_2;
	private JTextField UNIVRtextField_3;
	private JTextField EMAILtextField_4;
	private JTextField MOBtextField_5;
	private JTextField ADDRtextField_6;
	private JTextField INTRESTtextField_7;
	private JTextField SIDtextField_8;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Students_Equiry frame = new Students_Equiry();
					 
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
			String sql ="Select *from studentenq";
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
	
		}catch(Exception e) {System.out.print(e);}
		
		
		
		
	}
	
	public Students_Equiry() {
		setBackground(Color.RED);
		setTitle("Students Enquiry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Details ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 183, 446, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 660, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(10, 134, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 23, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("University");
		lblNewLabel_2.setBounds(6, 103, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setBounds(10, 61, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mob No");
		lblNewLabel_6.setBounds(206, 61, 60, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setBounds(206, 103, 60, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Email id");
		lblNewLabel_3.setBounds(206, 23, 60, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Intrested in");
		lblNewLabel_4.setBounds(206, 131, 69, 14);
		panel.add(lblNewLabel_4);
		
		NAMEtextField_1 = new JTextField();
		NAMEtextField_1.setBounds(66, 20, 86, 20);
		panel.add(NAMEtextField_1);
		NAMEtextField_1.setColumns(10);
		
		AGEtextField_2 = new JTextField();
		AGEtextField_2.setBounds(66, 58, 86, 20);
		panel.add(AGEtextField_2);
		AGEtextField_2.setColumns(10);
		
		UNIVRtextField_3 = new JTextField();
		UNIVRtextField_3.setBounds(66, 103, 86, 20);
		panel.add(UNIVRtextField_3);
		UNIVRtextField_3.setColumns(10);
		
		EMAILtextField_4 = new JTextField();
		EMAILtextField_4.setBounds(297, 20, 110, 20);
		panel.add(EMAILtextField_4);
		EMAILtextField_4.setColumns(10);
		
		MOBtextField_5 = new JTextField();
		MOBtextField_5.setBounds(297, 58, 110, 20);
		panel.add(MOBtextField_5);
		MOBtextField_5.setColumns(10);
		
		ADDRtextField_6 = new JTextField();
		ADDRtextField_6.setBounds(297, 100, 110, 20);
		panel.add(ADDRtextField_6);
		ADDRtextField_6.setColumns(10);
		
		INTRESTtextField_7 = new JTextField();
		INTRESTtextField_7.setBounds(297, 128, 110, 20);
		panel.add(INTRESTtextField_7);
		INTRESTtextField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Date");
		lblNewLabel_9.setBounds(206, 169, 46, 14);
		panel.add(lblNewLabel_9);
		
		JDateChooser Date = new JDateChooser();
		Date.setBounds(297, 169, 110, 20);
		panel.add(Date);
		
		JRadioButton rmalebtn = new JRadioButton("male");
		rmalebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gender = "male";
			}
		});
		rmalebtn.setBackground(Color.GREEN);
		rmalebtn.setBounds(62, 130, 90, 23);
		panel.add(rmalebtn);
		
		JRadioButton rfemalebtn = new JRadioButton("female");
		rfemalebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gender = "female";
			}
		});
		rfemalebtn.setBackground(Color.GREEN);
		rfemalebtn.setBounds(62, 167, 90, 18);
		panel.add(rfemalebtn);
		ButtonGroup group = new ButtonGroup();{
			group.add(rmalebtn);
			group.add(rfemalebtn);
			
		}
		 table_load();
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name =NAMEtextField_1.getText();
				String age = AGEtextField_2.getText();
				String university = UNIVRtextField_3.getText();
				String email = EMAILtextField_4.getText();
				String mob = MOBtextField_5.getText();
				int len=mob.length();
				String address = ADDRtextField_6.getText();
				String interest = INTRESTtextField_7.getText();
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
					PreparedStatement stmt = con.prepareStatement("INSERT INTO  studentenq (name ,age,university,email,mobile,address,interest,date,gender)values(?,?,?,?,?,?,?,?,?)");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,university);
					 stmt.setString(4,email);
					 stmt.setString(5,mob);
					 stmt.setString(6,address);
					 stmt.setString(7,interest);
					 stmt.setDate(8, sqldate);
                     stmt.setString(9, gender);
                      
					 stmt.executeUpdate();
										
					 JOptionPane.showMessageDialog(null,"students data added succesfully");
					 table_load();
					 NAMEtextField_1.setText("");
					 AGEtextField_2.setText("");
					 UNIVRtextField_3.setText("");
					 EMAILtextField_4.setText("");
					 MOBtextField_5.setText("");
					 ADDRtextField_6.setText("");
					 INTRESTtextField_7.setText("");
					 NAMEtextField_1.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
			}
		});
		btnNewButton.setBounds(10, 429, 89, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 dispose();
				 Dashboard db = new Dashboard();
				db.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(150, 429, 89, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SIDtextField_8.setText("");
				 NAMEtextField_1.setText("");
				 AGEtextField_2.setText("");
				 UNIVRtextField_3.setText("");
				 EMAILtextField_4.setText("");
				 MOBtextField_5.setText("");
				 ADDRtextField_6.setText("");
				 INTRESTtextField_7.setText("");
				 NAMEtextField_1.requestDefaultFocus();
				 
				
			}
		});
		btnNewButton_2.setBounds(290, 429, 89, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				String sid = SIDtextField_8.getText();
				String name =NAMEtextField_1.getText();
				String age = AGEtextField_2.getText();
				String university = UNIVRtextField_3.getText();
				String email = EMAILtextField_4.getText();
				String mob = MOBtextField_5.getText();
				int len=mob.length();
				String address = ADDRtextField_6.getText();
				String interest = INTRESTtextField_7.getText();
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
					PreparedStatement stmt = con.prepareStatement("update studentenq set name=? ,age=?,university=?,email=?,mobile=?,address=?,interest=?,date=?,gender=? where id=?");

					 stmt.setString(1,name);
					 stmt.setString(2,age);
					 stmt.setString(3,university);
					 stmt.setString(4,email);
					 stmt.setString(5,mob);
					 stmt.setString(6,address);
					 stmt.setString(7,interest);
					 stmt.setDate(8, sqldate);
					 stmt.setString(9, gender);
                     stmt.setString(10, sid);
                     
					 stmt.executeUpdate();
										
					 JOptionPane.showMessageDialog(null,"updated succesfully");
					 table_load();
					 NAMEtextField_1.setText("");
					 AGEtextField_2.setText("");
					 UNIVRtextField_3.setText("");
					 EMAILtextField_4.setText("");
					 MOBtextField_5.setText("");
					 ADDRtextField_6.setText("");
					 INTRESTtextField_7.setText("");
					 NAMEtextField_1.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
				
				
				
				
			}
		});
		btnNewButton_3.setBounds(416, 429, 89, 44);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBackground(Color.PINK);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sid = SIDtextField_8.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("delete from studentenq  where id=?");

					
                     stmt.setString(1, sid);
                      
					 stmt.executeUpdate();
										
					 JOptionPane.showMessageDialog(null,"record deleted....");
					 table_load();
					 NAMEtextField_1.setText("");
					 AGEtextField_2.setText("");
					 UNIVRtextField_3.setText("");
					 EMAILtextField_4.setText("");
					 MOBtextField_5.setText("");
					 ADDRtextField_6.setText("");
					 INTRESTtextField_7.setText("");
					 NAMEtextField_1.requestDefaultFocus();
					
					con.close();
					
					
					
				}catch(Exception e) {System.out.print(e);}
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_4.setBounds(548, 429, 89, 44);
		contentPane.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(476, 183, 194, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("ID");
		lblNewLabel_8.setBounds(10, 22, 20, 14);
		panel_1.add(lblNewLabel_8);
		
		SIDtextField_8 = new JTextField();
		SIDtextField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String id = SIDtextField_8.getText();
					Class.forName("com.mysql.jdbc.Driver") ;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					PreparedStatement stmt = con.prepareStatement("select name,age,university,email,mobile,address,interest,date,gender from studentenq where id =?");
					stmt.setString(1, id);
					ResultSet rs = stmt.executeQuery();
					table_load();
					if(rs.next()==true)
					{
						
						String name = rs.getString(1);
						String age = rs.getString(2);
						String university = rs.getString(3);
						String email = rs.getString(4);
						String mob = rs.getString(5);
						String address = rs.getString(6);
						String interest=rs.getString(7);
						  Date sqldate =rs.getDate(8);
						gender =rs.getString(9);
						
						 NAMEtextField_1.setText(name);
						 AGEtextField_2.setText(age);
						 UNIVRtextField_3.setText(university);
						 EMAILtextField_4.setText(email);
						 MOBtextField_5.setText(mob);
						 ADDRtextField_6.setText(address);
						 INTRESTtextField_7.setText(interest);
						
						
					}else {
						
						 NAMEtextField_1.setText("");
						 AGEtextField_2.setText("");
						 UNIVRtextField_3.setText("");
						 EMAILtextField_4.setText("");
						 MOBtextField_5.setText("");
						 ADDRtextField_6.setText("");
						 INTRESTtextField_7.setText("");
						
						
						
						
						
					}
					
					
					
					
					
				}catch(Exception e){System.out.print(e);}
			}
		});
		SIDtextField_8.setBounds(40, 19, 117, 20);
		panel_1.add(SIDtextField_8);
		SIDtextField_8.setColumns(10);
		
		
		
	}
	private String gender;
}
