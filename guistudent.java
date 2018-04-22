package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.print.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import com.jgoodies.forms.factories.DefaultComponentFactory;

//import com.sun.java.util.jar.pack.Package.File;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;

public class guistudent {

	private JFrame frame;
	private final JLabel lblStudentRegistration = new JLabel("Student Registration");
	private JTextField usn;
	private JTextField name;
	private JTextField fname;
	private JTextField contact;
	private JTextField address;
	private JTextField cet;
	JButton add, reset, delete, print, generate,get;
	/**
	 * @wbp.nonvisual location=181,-1
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guistudent window = new guistudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guistudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblStudentRegistration.setForeground(Color.BLUE);
		lblStudentRegistration.setFont(new Font("Vrinda", Font.BOLD | Font.ITALIC, 14));
		lblStudentRegistration.setBackground(new Color(255, 255, 255));
		lblStudentRegistration.setBounds(68, 0, 137, 31);
		lblStudentRegistration.setLabelFor(frame);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblStudentRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 74, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblFatherName = new JLabel("Father name:");
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFatherName.setBounds(10, 108, 94, 14);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(10, 185, 94, 25);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblContactNumber = new JLabel("Contact No. :");
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNumber.setBounds(10, 149, 74, 14);
		frame.getContentPane().add(lblContactNumber);
		
		JLabel lblCetRank = new JLabel("CET Rank:");
		lblCetRank.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCetRank.setBounds(10, 230, 60, 14);
		frame.getContentPane().add(lblCetRank);
		
		JLabel lblUsn = new JLabel("USN:");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsn.setBounds(10, 33, 46, 14);
		frame.getContentPane().add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(114, 28, 137, 25);
		frame.getContentPane().add(usn);
		usn.setColumns(10);
		
		name = new JTextField();
		name.setBounds(114, 63, 137, 25);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(114, 103, 137, 25);
		frame.getContentPane().add(fname);
		fname.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(114, 144, 137, 25);
		frame.getContentPane().add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setBounds(114, 185, 137, 25);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		cet = new JTextField();
		cet.setBounds(114, 225, 137, 25);
		frame.getContentPane().add(cet);
		cet.setColumns(10);
		
		JButton add = new JButton("ADD");
		add.setFont(new Font("Tahoma", Font.BOLD, 12));
		add.setForeground(Color.GREEN);
		add.setBounds(295, 4, 89, 23);
		frame.getContentPane().add(add);
		
		JButton reset = new JButton("RESET");
		reset.setFont(new Font("Tahoma", Font.BOLD, 12));
		reset.setForeground(Color.ORANGE);
		reset.setBounds(345, 27, 89, 25);
		frame.getContentPane().add(reset);
		
		JButton delete = new JButton("DELETE");
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		delete.setBounds(306, 52, 89, 23);
		frame.getContentPane().add(delete);
		
		JButton print = new JButton("PRINT");
		print.setFont(new Font("Tahoma", Font.BOLD, 12));
		print.setForeground(Color.BLUE);
		print.setBounds(261, 213, 74, 31);
		frame.getContentPane().add(print);
		
		JButton generate = new JButton("GENERATE");
		generate.setFont(new Font("Tahoma", Font.BOLD, 12));
		generate.setForeground(Color.BLUE);
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		generate.setBounds(335, 213, 99, 31);
		frame.getContentPane().add(generate);
		
		JLabel lblNewLabel = new JLabel("Admission Ticket");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(290, 190, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton get = new JButton("Get info");
		get.setFont(new Font("Tahoma", Font.BOLD, 12));
		get.setForeground(Color.ORANGE);
		get.setBounds(261, 27, 84, 25);
		frame.getContentPane().add(get);
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
			String value1=usn.getText();
			String value2=name.getText();
			String value3=fname.getText();
			String value4=contact.getText();
			String value5=address.getText();
			String value6=cet.getText();
			Connection con = null;
			String url = "jdbc:mysql://localhost:3306/";
			String db = "student";
			String driver = "com.mysql.jdbc.Driver";
			String user = "root";
			String pass = "root";
			System.out.println(value1+value2+value3+value4+value5+value6);
			Component p1 = null;
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url+db, user, pass);
			PreparedStatement st=con.prepareStatement("insert into info(usn, name, fname, contact, address, cet) values(?,?,?,?,?,?)");
			st.setString(1,value1);
			st.setString(2,value2);
			st.setString(3,value3);
			st.setString(4,value4);
			st.setString(5,value5);
			st.setString(6,value6);
			st.executeUpdate();
			JOptionPane.showMessageDialog(p1,"Data is successfully inserted into database.");
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(p1,"Error in submitting data!");
			}
			}
			});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){

			String value1=usn.getText();
			Connection con = null;
					 String url = "jdbc:mysql://localhost:3306/";
					 String db = "student";
					 String driver = "com.mysql.jdbc.Driver";
					 String user = "root";
					 String pass = "root";
			Component p3 = null;
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url+db, user, pass);
			PreparedStatement st=con.prepareStatement("DELETE FROM info WHERE usn = ?");
			st.setString(1,value1);
			st.executeUpdate();
			JOptionPane.showMessageDialog(p3,"Record is deleted successfully.");
			con.close();
			}
			catch(Exception exp3)
			{
			JOptionPane.showMessageDialog(p3,"Error in deleting record.");
			}
			}
			});
		
		
		get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){

			String value=usn.getText();
			Connection con = null;
					 String url = "jdbc:mysql://localhost:3306/";
					 String db = "student";
					 String driver = "com.mysql.jdbc.Driver";
					 String user = "root";
					 String pass = "root";
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url+db, user, pass);
			PreparedStatement st=con.prepareStatement("select * from info where usn=?");
			st.setString(1,value);
			ResultSet res=st.executeQuery();
			res.next();
			usn.setText(Integer.toString(res.getInt(1)));
			name.setText(res.getString(2));
			fname.setText(res.getString(3));
			contact.setText(res.getString(4));
			address.setText(res.getString(5));
			cet.setText(Integer.toString(res.getInt(6)));
			con.close();
			}
			catch(Exception e)
			{
			Component p2 = null;
			JOptionPane.showMessageDialog(p2,"Error");
			}
			}
			});
		
		
		   reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
				usn.setText("");
				name.setText("");
				fname.setText("");
				contact.setText("");
				address.setText("");
				cet.setText("");
					}
					});
		   
		   
		   generate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae)
				{
					JFrame f = new JFrame("Admission Letter");
					f.setBounds(100, 100, 500, 300);
					f.setVisible(true);
					
					String value=usn.getText();
					Connection con = null;
							 String url = "jdbc:mysql://localhost:3306/";
							 String db = "student";
							 String driver = "com.mysql.jdbc.Driver";
							 String user = "root";
							 String pass = "root";
					try{
					Class.forName(driver);
					con = DriverManager.getConnection(url+db, user, pass);
					PreparedStatement st=con.prepareStatement("select * from info where usn=?");
					
					st.setString(1,value);
					ResultSet res=st.executeQuery();
					res.next();
					name.setText(res.getString(2));
					JLabel lblName = new JLabel("\tAdmission Letter");
					lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblName.setForeground(Color.RED);
					lblName.setBounds(68, 0, 200, 31);
					f.getContentPane().add(lblName);
					String name1 = name.getText();
					JTextArea receipt = new JTextArea();
					receipt.setText("\r\n \r\n \r\n  \t  Dear " +name1+ " We are happy to inform you \r\n\r\nthat you have been offered a seat in KLETU Hubli");
					//receipt.setText("date:  /  /   . \r\n Time:  :   :");
					receipt.setFont(new Font("Tahoma", Font.BOLD, 14));
					receipt.setForeground(Color.BLACK);
					receipt.setBounds(261, 78, 163, 111);
					f.getContentPane().add(receipt);
					
					Component p2 = null;
					//JOptionPane.showMessageDialog(p2,"success");
					con.close();
					}
					catch(Exception e)
					{
					Component p2 = null;
					JOptionPane.showMessageDialog(p2,"Error");
					}
					}
				});   
		   
		   print.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					JFrame f = new JFrame("Admission Letter");
					f.setBounds(100, 100, 500, 300);
					f.setVisible(true);
					
					JLabel lblName = new JLabel("\tAdmission Letter");
					lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblName.setForeground(Color.RED);
					lblName.setBounds(68, 0, 200, 31);
					f.getContentPane().add(lblName);
					
					String name1 = name.getText();
					JTextArea receipt = new JTextArea();
					receipt.setText("\r\n \r\n \r\n  \t  Dear " +name1+ " We are happy to inform you \r\n\r\nthat you have been offered a seat in KLETU Hubli");
					receipt.setFont(new Font("Tahoma", Font.BOLD, 14));
					receipt.setForeground(Color.BLACK);
					receipt.setBounds(261, 78, 163, 111);
					f.getContentPane().add(receipt);

					File file = new File("D:\file.txt"); // The text file
					PrintWriter pw = null;
					pw.flush();
					try {
						pw = new PrintWriter(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //PrintWriter, its self explanatory
					pw.println("Hello"); //prints a new line of 'Hello' to the file.
					 //Make sure you call this whenever you write to the file
					pw.close(); //Make sure you call this when you're done with the PrintWriter
				    	}
					});
	}
}
