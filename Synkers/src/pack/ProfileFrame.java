package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class ProfileFrame {

	private JFrame frame;
	private int userid = SuccessfulLoginFrame.getID();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField teachingField;
	private File image_file;
	private String gender;
	private String type;
	private String description_cut = "";
	private String description_cut_2 = "";
	private String description_cut_3 = "";
	private String description_cut_4 = "";
	private String description_cut_5 = "";
	private String description_cut_6 = "";
	private char[] password_array;	
	private String password_string;
	private boolean image_changed = false;
	private static String[] universities_array;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame window = new ProfileFrame();
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
	public ProfileFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		universities_array = new String[]{"BME", "ELTE", "ATE", "BCE", "BGE", "LFZE", "MKE", "MTE", "MOME", "NKE", "OE", "SOTE", "SZFE", "PTE", "TE", "Other"};
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(374, 37, 242, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel imageLabel = new JLabel();
		//imageLabel.setIcon(new ImageIcon("D:\\Desktop\\magnus2.jpg"));
		imageLabel.setBounds(12, 13, 218, 214);
		panel.add(imageLabel);
		
		 try{
			  Connection conn = DBMS.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT img FROM images WHERE userid = ?");
			//ps.setInt(1, SuccessfulLoginFrame.getID());
			ps.setInt(1, userid);
			 byte[] imgBytes;
			ResultSet rs = ps.executeQuery();
			 ByteArrayOutputStream output = new ByteArrayOutputStream();
		     // save the image to the output stream
		     @SuppressWarnings("unused")
			ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
			if (rs != null) {
			    while (rs.next()) {
			        imgBytes = rs.getBytes(1);
			        // use the data in some way here
			        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
					Image dimg2 = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
			        imageLabel.setIcon(new ImageIcon(dimg2));
			        
			    }
			    rs.close();
			}
			ps.close();
			
		  }catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		
		JLabel lblName = new JLabel(LogInFrame.getUsername());
		lblName.setFont(new Font("MS Gothic", Font.BOLD, 30));
		lblName.setBounds(23, 37, 308, 33);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(23, 101, 78, 16);
		frame.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setText("usernamefield");
		usernameField.setBounds(113, 98, 185, 22);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText("password");
		passwordField.setBounds(113, 144, 185, 22);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(23, 147, 78, 16);
		frame.getContentPane().add(lblPassword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(0, 153, 153));
		rdbtnMale.setBounds(113, 189, 78, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(0, 153, 153));
		rdbtnFemale.setBounds(204, 189, 127, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(23, 193, 56, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(23, 234, 56, 16);
		frame.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setText("emailfield");
		emailField.setBounds(113, 231, 185, 22);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblType.setBounds(23, 277, 56, 16);
		frame.getContentPane().add(lblType);
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBackground(new Color(0, 153, 153));
		rdbtnTeacher.setBounds(113, 273, 78, 25);
		frame.getContentPane().add(rdbtnTeacher);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBackground(new Color(0, 153, 153));
		rdbtnStudent.setBounds(204, 273, 78, 25);
		frame.getContentPane().add(rdbtnStudent);
		
		JLabel lblUniversity = new JLabel("University:");
		lblUniversity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUniversity.setBounds(23, 323, 78, 16);
		frame.getContentPane().add(lblUniversity);
		
		JComboBox<String> universitiesField = new JComboBox<String>();
		universitiesField.setBounds(113, 320, 185, 22);
		universitiesField.setModel(new DefaultComboBoxModel<String>(universities_array));
		frame.getContentPane().add(universitiesField);
		
		JLabel lblTeaching = new JLabel("Teaching:");
		lblTeaching.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeaching.setBounds(23, 366, 78, 16);
		frame.getContentPane().add(lblTeaching);
		
		teachingField = new JTextField();
		teachingField.setEditable(false);
		teachingField.setBounds(113, 363, 185, 22);
		frame.getContentPane().add(teachingField);
		teachingField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(453, 346, 78, 16);
		frame.getContentPane().add(lblDescription);
		
		JTextArea descriptionField = new JTextArea();
		descriptionField.setText("descriptionfield");
		descriptionField.setBounds(346, 375, 300, 96);
		frame.getContentPane().add(descriptionField);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setFocusPainted(false);
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Dubai Light", Font.BOLD, 27));
		btnUpdate.setBounds(59, 428, 185, 33);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFocusPainted(false);
		btnBrowse.setBounds(449, 290, 97, 25);
		frame.getContentPane().add(btnBrowse);
		

		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				image_changed = true;
				JFileChooser file_chooser = new JFileChooser();
				 int result = file_chooser.showOpenDialog(null);
				 
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    image_file = file_chooser.getSelectedFile();
	                    
	                    try {
	                    	
							Image dimg = ImageIO.read(image_file);
							Image dimg2 = dimg.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
							imageLabel.setIcon(new ImageIcon(dimg2));
							
                    } catch (IOException e) {
                        e.printStackTrace();
	                }
	                }
			}
		});
		
			
		  Connection conn = DBMS.getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("SELECT * FROM users WHERE userid = ?");

			ps.setInt(1, userid);

			ResultSet rs = ps.executeQuery();

			    while (rs.next()) {
			        usernameField.setText(rs.getString(2));
			        passwordField.setText(rs.getString(3));
			        if(rs.getString(4).equals("Male")){
			        	rdbtnMale.setSelected(true);
			        	gender = "Male";
			        }
			        if(rs.getString(4).equals("Female")){
			        	rdbtnFemale.setSelected(true);
			        	gender = "Female";
			        }
			        emailField.setText(rs.getString(5));
			        universitiesField.setSelectedItem((String) rs.getString(6));
			        if(rs.getString(7).equals("Student")){
			        	rdbtnStudent.setSelected(true);
			        	type = "Student";
			        }
			        if(rs.getString(7).equals("Teacher")){
			        	rdbtnTeacher.setSelected(true);
			        	teachingField.setEditable(true);
			        	type = "Teacher";
			        }
			        if(type.equals("Teacher")){
			        	teachingField.setText(rs.getString(8));
			        }
			        description_cut = rs.getString(9);
			        if(description_cut.length() > 50){
			        	String[] tokens = description_cut.split("(?<=\\G.{50})");
			        	description_cut = tokens[0];
			        	description_cut_2 = tokens[1];
			        
			        	if(description_cut_2.length() > 49){
			        		//@SuppressWarnings("unused")
							String[] tokens2 = description_cut_2.split("(?<=\\G.{49})");
			        		description_cut_2 = tokens2[0];
			        	/*	System.out.println(description_cut + "//");
			        		System.out.println(description_cut_2 + "//");
			        		System.out.println(tokens2[1] + "//");
			        		System.out.println(description_cut_3 + "//");
			        		System.out.println(".");*/
			        		description_cut_3 = tokens2[1];
			        	
			        	if(description_cut_3.length() > 48){
			        	//	@SuppressWarnings("unused")
							String[] tokens3 = description_cut_3.split("(?<=\\G.{48})");
			        		description_cut_3 = tokens3[0];
			        		description_cut_4 = tokens3[1];
			        	
			        	if(description_cut_4.length() > 47){
			        	//	@SuppressWarnings("unused")
							String[] tokens4 = description_cut_4.split("(?<=\\G.{47})");
			        		description_cut_4 = tokens4[0];
			        		description_cut_5 = tokens4[1];
			        	
			        	if(description_cut_5.length() > 46){
			        	//	@SuppressWarnings("unused")
							String[] tokens5 = description_cut_5.split("(?<=\\G.{46})");
			        		description_cut_5 = tokens5[0];
			        		description_cut_6 = tokens5[1];
			        	}
			        	}
			        	}
			        	}
			        }
			        
			        descriptionField.setText(description_cut+"\n"
			        +description_cut_2+"\n"+description_cut_3+"\n"+
			        		description_cut_4+"\n"+description_cut_5+"\n"+
			        description_cut_6);
			       
			    }
			    
			} catch (SQLException e) {			
				e.printStackTrace();
			}
	
			rdbtnFemale.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnFemale.isSelected()){
						rdbtnMale.setSelected(false);
						gender = "Female";
					}
				}
			});
			
			rdbtnMale.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnMale.isSelected()){
						rdbtnFemale.setSelected(false);
						gender = "Male";
					}
				}
			});
			
			
			rdbtnStudent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnStudent.isSelected()){
						rdbtnTeacher.setSelected(false);
						teachingField.setEditable(false);
						type = "Student";
					}
					
				}
			});
			
			rdbtnTeacher.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(rdbtnTeacher.isSelected()){
						rdbtnStudent.setSelected(false);
						teachingField.setEditable(true);
						type = "Teacher";
					}
					if(!rdbtnTeacher.isSelected()){
						teachingField.setEditable(false);
					}
				}
			});
			
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					password_array = passwordField.getPassword();
					password_string = new String(password_array);
					
					Connection connection = null;
					try {
						Class.forName("org.postgresql.Driver");
						connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "houssam123");
						PreparedStatement ps;
						ps = connection.prepareStatement("UPDATE users SET username = ?, password = ?, gender = ?, email = ?, university = ?, type = ?, teaching_course = ?, description = ? WHERE userid = ?");
						//		+ "'" + usernameField.getText() + "','" + password_string + "','" + gender + "','" + emailField.getText() + "','" + universitiesField.getSelectedItem().toString()
						//		+ "','" + type + "','" + teachingField.getText() + "','" + descriptionField.getText() + "');");
						ps.setString(1, usernameField.getText());
						ps.setString(2, password_string);
						ps.setString(3, gender);
						ps.setString(4, emailField.getText());
						ps.setString(5, universitiesField.getSelectedItem().toString());
						ps.setString(6, type);
						ps.setString(7, teachingField.getText());
						ps.setString(8, descriptionField.getText());
						ps.setInt(9, userid);
						ps.executeUpdate();
						ps.close();
						
						  if(image_changed){
						  FileInputStream fis = new FileInputStream(image_file);	  
						  PreparedStatement ps_image = connection.prepareStatement("INSERT INTO images (imgname, img, userid) VALUES (?, ?, ?)");
						  ps_image.setString(1, image_file.getName());
						  ps_image.setBinaryStream(2, fis, image_file.length());
						  ps_image.setInt(3, userid);
						 // System.out.println(fis);
						 // System.out.println(file.length());
						  
						  ps_image.executeUpdate();
						  ps_image.close();
						  fis.close();
						  }
						  
						  connection.close();
						  JOptionPane.showMessageDialog(null, "You have successfully updated your profile!");
						  frame.dispose();
						  SuccessfulLoginFrame.frame.dispose();
						  SuccessfulLoginFrame new_frame = new SuccessfulLoginFrame();
						  
					} catch (ClassNotFoundException | SQLException | IOException e1) {
						  JOptionPane.showMessageDialog(null, "Warning! Some information is missing. Please try again!");
					}
				}
			});
	
		frame.setVisible(true);
}
	
	
	
}
