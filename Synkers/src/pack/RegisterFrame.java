package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JRadioButton;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class RegisterFrame {

	private JFrame frame;
	private JTextField emailField;
	private JTextField usernameField;
	private JTextField teachingField;
	private boolean teacher = false;
	private JPasswordField passwordField;
	static String image_path = null;
	private char[] password_array;	
	private String password_string;
	private String gender;
	private String type;
	private File image_file;
	private static String[] universities_array; 
	private JTextField addressField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame window = new RegisterFrame();
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
	public RegisterFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		universities_array = new String[]{"BME", "ELTE", "ATE", "BCE", "BGE", "LFZE", "MKE", "MTE", "MOME", "NKE", "OE", "SOTE", "SZFE", "PTE", "TE", "Other"};
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 994, 715);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(125, 623, 766, 60);
		registerButton.setFocusPainted(false);
		panel.add(registerButton);
		registerButton.setForeground(new Color(0, 153, 153));
		registerButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		registerButton.setBackground(SystemColor.inactiveCaptionBorder);
		
		JTextArea descriptionField = new JTextArea();
		descriptionField.setBounds(138, 409, 515, 110);
		panel.add(descriptionField);
		
		JLabel lblNewLabel_1 = new JLabel("Description:");
		lblNewLabel_1.setBounds(44, 408, 90, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lblTeachingCourse = new JLabel("Teaching:");
		lblTeachingCourse.setBounds(44, 355, 90, 25);
		panel.add(lblTeachingCourse);
		lblTeachingCourse.setForeground(new Color(255, 255, 255));
		lblTeachingCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		teachingField = new JTextField();
		teachingField.setBounds(138, 355, 392, 25);
		panel.add(teachingField);
		teachingField.setEditable(false);
		teachingField.setColumns(10);
		
		JComboBox<String> universitiesField = new JComboBox<String>();
		universitiesField.setModel(new DefaultComboBoxModel<String>(universities_array));
		universitiesField.setBounds(138, 305, 392, 22);
		panel.add(universitiesField);
		JLabel lblUniversity = new JLabel("University:");
		lblUniversity.setBounds(44, 304, 81, 25);
		panel.add(lblUniversity);
		lblUniversity.setForeground(new Color(255, 255, 255));
		lblUniversity.setFont(new Font("Tahoma", Font.BOLD, 13));
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(192, 250, 82, 25);
		panel.add(rdbtnTeacher);
		rdbtnTeacher.setForeground(new Color(255, 255, 255));
		rdbtnTeacher.setBackground(new Color(0, 153, 153));
		rdbtnTeacher.setFocusPainted(false);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(331, 250, 90, 25);
		panel.add(rdbtnStudent);
		rdbtnStudent.setForeground(new Color(255, 255, 255));
		rdbtnStudent.setBackground(new Color(0, 153, 153));
		rdbtnStudent.setFocusPainted(false);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(44, 254, 56, 16);
		panel.add(lblType);
		lblType.setForeground(new Color(255, 255, 255));
		lblType.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		emailField = new JTextField();
		emailField.setBounds(138, 200, 392, 25);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(44, 200, 82, 25);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(192, 140, 103, 25);
		panel.add(rdbtnMale);
		rdbtnMale.setForeground(new Color(255, 255, 255));
		rdbtnMale.setBackground(new Color(0, 153, 153));
		rdbtnMale.setFocusPainted(false);
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(331, 140, 112, 25);
		panel.add(rdbtnFemale);
		rdbtnFemale.setForeground(new Color(255, 255, 255));
		rdbtnFemale.setBackground(new Color(0, 153, 153));
		rdbtnFemale.setFocusPainted(false);
		
		JLabel label = new JLabel("Gender:");
		label.setBounds(44, 144, 51, 16);
		panel.add(label);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 87, 392, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(44, 87, 112, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBackground(new Color(0, 153, 153));
		
		usernameField = new JTextField();
		usernameField.setBounds(138, 34, 392, 25);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(44, 34, 90, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 153, 153));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(640, 48, 233, 257);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(0, 0, 233, 257);
		panel_1.add(imageLabel);
		
		password_array = passwordField.getPassword();
		password_string = new String(password_array);
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(706, 318, 97, 25);	
		
		panel.add(btnBrowse);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(44, 546, 90, 25);
		panel.add(lblAddress);
		
		addressField = new JTextField();
		addressField.setBounds(138, 547, 392, 22);
		panel.add(addressField);
		addressField.setColumns(10);
		

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
		
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
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
		
		
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				password_array = passwordField.getPassword();
				password_string = new String(password_array);
				
				Connection connection = null;
				try {
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "houssam123");
					PreparedStatement st;
					st = connection.prepareStatement("INSERT INTO users (username, password, gender, email, university, type, teaching_course, description, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					//		+ "'" + usernameField.getText() + "','" + password_string + "','" + gender + "','" + emailField.getText() + "','" + universitiesField.getSelectedItem().toString()
					//		+ "','" + type + "','" + teachingField.getText() + "','" + descriptionField.getText() + "');");
					st.setString(1, usernameField.getText());
					st.setString(2, password_string);
					st.setString(3, gender);
					st.setString(4, emailField.getText());
					st.setString(5, universitiesField.getSelectedItem().toString());
					st.setString(6, type);
					st.setString(7, teachingField.getText());
					st.setString(8, descriptionField.getText());
					st.setString(9, addressField.getText());
				    st.executeUpdate();
					
					  int userid = 0;
					  if(image_file!= null){
					  FileInputStream fis = new FileInputStream(image_file);
					  PreparedStatement ps_id = connection.prepareStatement("SELECT userid FROM users WHERE username = '" + usernameField.getText() + "'" );
					  ResultSet rs = ps_id.executeQuery();
					  while(rs.next()){
						 userid = rs.getInt("userid");
					  }
					  
					  PreparedStatement ps = connection.prepareStatement("INSERT INTO images (imgname, img, userid) VALUES (?, ?, ?)");
					  ps.setString(1, image_file.getName());
					  ps.setBinaryStream(2, fis, image_file.length());
					  ps.setInt(3, userid);
					 // System.out.println(fis);
					 // System.out.println(file.length());
					  
					  ps.executeUpdate();
					  
					  ps.close();
					  fis.close();
					  JOptionPane.showMessageDialog(null, "You have successfully registered!");
					  }
				} catch (ClassNotFoundException | SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, "Warning! Please make sure to fill the required information.");
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		frame.setVisible(true);
		
		
	}

	public boolean isTeacher() {
		return teacher;
	}

	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}

}
