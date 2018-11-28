package pack;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SessionsFrame {

	static JFrame frame;
	private static String teacher1_username = "";
	private static String teacher2_username = "";
	private static String teacher3_username = "";
	private static String teacher4_username = "";
	private static String teacher1_address = "";
	private static String teacher2_address = "";
	private static String teacher3_address = "";
	private static String teacher4_address = "";
	private static String teacher1_time = "";
	private static String teacher2_time = "";
	private static String teacher3_time = "";
	private static String teacher4_time = "";
	private static String user_type;
	static JLabel labelPic1 = new JLabel();
	static JLabel labelPic2 = new JLabel();
	static JLabel labelPic3 = new JLabel();
	static JLabel labelPic4 = new JLabel();
	private static int number_of_rows=-1;
	static File backarrow_file = new File("images/arrows.png");
	private File statistics_file = new File("images/statistics.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionsFrame window = new SessionsFrame();
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
	public SessionsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		labelPic1.setBounds(12, 13, 71, 84);
		labelPic2.setBounds(12, 13, 71, 84);
		labelPic3.setBounds(12, 13, 71, 84);
		labelPic4.setBounds(12, 13, 71, 84);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 620);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		getTeachers();
		
		if(number_of_rows >= 1){
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 77, 480, 110);
		frame.getContentPane().add(panel);
		

		panel.add(labelPic1);
		
		JLabel first_name = new JLabel(teacher1_username);
		first_name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		first_name.setBounds(112, 13, 168, 31);
		panel.add(first_name);
		
		JLabel first_calendar = new JLabel("S M T W T F S");
		first_calendar.setForeground(new Color(0, 153, 153));
		first_calendar.setFont(new Font("Tahoma", Font.BOLD, 13));
		first_calendar.setBounds(112, 50, 153, 16);
		panel.add(first_calendar);
		
		JLabel first_address = new JLabel(teacher1_address);
		first_address.setBounds(112, 76, 210, 16);
		panel.add(first_address);
		
		JLabel first_time = new JLabel(teacher1_time);
		first_time.setHorizontalAlignment(SwingConstants.CENTER);
		first_time.setForeground(new Color(0, 153, 153));
		first_time.setFont(new Font("Tahoma", Font.BOLD, 25));
		first_time.setBounds(266, 13, 202, 31);
		panel.add(first_time);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
				if(yes == JOptionPane.YES_OPTION){
					deleteSession(teacher1_time);
				JOptionPane.showMessageDialog(null, "Your session has been removed!");
				frame.dispose();
				SessionsFrame session = new SessionsFrame();
				}
			}
		});
		btnDelete.setBounds(350, 57, 97, 25);
		btnDelete.setFocusPainted(false);
		panel.add(btnDelete);
		
	}
		
		if(number_of_rows >=2){
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 200, 480, 110);
		frame.getContentPane().add(panel_2);
		
		panel_2.add(labelPic2);
		
		JLabel second_name = new JLabel(teacher2_username);
		second_name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		second_name.setBounds(112, 13, 168, 31);
		panel_2.add(second_name);
		
		JLabel second_calendar = new JLabel("S M T W T F S");
		second_calendar.setForeground(new Color(0, 153, 153));
		second_calendar.setFont(new Font("Tahoma", Font.BOLD, 13));
		second_calendar.setBounds(112, 50, 153, 16);
		panel_2.add(second_calendar);
		
		JLabel second_address = new JLabel(teacher2_address);
		second_address.setBounds(112, 76, 210, 16);
		panel_2.add(second_address);
		
		JLabel second_time = new JLabel(teacher2_time);
		second_time.setHorizontalAlignment(SwingConstants.CENTER);
		second_time.setForeground(new Color(0, 153, 153));
		second_time.setFont(new Font("Tahoma", Font.BOLD, 25));
		second_time.setBounds(266, 13, 202, 31);
		panel_2.add(second_time);
		
		JButton button = new JButton("Delete");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
				if(yes == JOptionPane.YES_OPTION){
					deleteSession(teacher2_time);
				JOptionPane.showMessageDialog(null, "Your session has been removed, please refresh!");
				frame.dispose();
				SessionsFrame session = new SessionsFrame();
				}
			}
		});
		
		button.setFocusPainted(false);
		button.setBounds(350, 57, 97, 25);
		panel_2.add(button);
		
		}
		
		if(number_of_rows >= 3){
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 323, 480, 110);
		frame.getContentPane().add(panel_4);

		panel_4.add(labelPic3);
		
		JLabel third_name = new JLabel(teacher3_username);
		third_name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		third_name.setBounds(112, 13, 168, 31);
		panel_4.add(third_name);
		
		JLabel third_calendar = new JLabel("S M T W T F S");
		third_calendar.setForeground(new Color(0, 153, 153));
		third_calendar.setFont(new Font("Tahoma", Font.BOLD, 13));
		third_calendar.setBounds(112, 50, 153, 16);
		panel_4.add(third_calendar);
		
		JLabel third_address = new JLabel(teacher3_address);
		third_address.setBounds(112, 76, 210, 16);
		panel_4.add(third_address);
		
		JLabel third_time = new JLabel(teacher3_time);
		third_time.setHorizontalAlignment(SwingConstants.CENTER);
		third_time.setForeground(new Color(0, 153, 153));
		third_time.setFont(new Font("Tahoma", Font.BOLD, 25));
		third_time.setBounds(266, 13, 202, 31);
		panel_4.add(third_time);
		
		JButton button_1 = new JButton("Delete");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
				if(yes == JOptionPane.YES_OPTION){
					deleteSession(teacher3_time);
				JOptionPane.showMessageDialog(null, "Your session has been removed, please refresh!");
				frame.dispose();
				SessionsFrame session = new SessionsFrame();
				}
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBounds(350, 57, 97, 25);
		panel_4.add(button_1);
		
		}
		
		if(number_of_rows >=4){
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 446, 480, 110);
		frame.getContentPane().add(panel_6);
		
		panel_6.add(labelPic4);
		
		JLabel fourth_name = new JLabel(teacher4_username);
		fourth_name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		fourth_name.setBounds(112, 13, 168, 31);
		panel_6.add(fourth_name);
		
		JLabel fourth_calendar = new JLabel("S M T W T F S");
		fourth_calendar.setForeground(new Color(0, 153, 153));
		fourth_calendar.setFont(new Font("Tahoma", Font.BOLD, 13));
		fourth_calendar.setBounds(112, 50, 153, 16);
		panel_6.add(fourth_calendar);
		
		JLabel fourth_address = new JLabel(teacher4_address);
		fourth_address.setBounds(112, 76, 210, 16);
		panel_6.add(fourth_address);
		
		JLabel fourth_time = new JLabel(teacher4_time);
		fourth_time.setHorizontalAlignment(SwingConstants.CENTER);
		fourth_time.setForeground(new Color(0, 153, 153));
		fourth_time.setFont(new Font("Tahoma", Font.BOLD, 25));
		fourth_time.setBounds(266, 13, 202, 31);
		panel_6.add(fourth_time);
		
		JButton button_2 = new JButton("Delete");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
				if(yes == JOptionPane.YES_OPTION){
					deleteSession(teacher4_time);
				JOptionPane.showMessageDialog(null, "Your session has been removed, please refresh!");
				frame.dispose();
				SessionsFrame session = new SessionsFrame();
				}
			}
		});
		button_2.setFocusPainted(false);
		button_2.setBounds(350, 57, 97, 25);
		panel_6.add(button_2);
		
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 153, 153));
		panel_1.setBounds(0, 0, 502, 56);
		frame.getContentPane().add(panel_1);
		
		JLabel labelSessions = new JLabel();
		labelSessions.setHorizontalAlignment(SwingConstants.CENTER);
		labelSessions.setText("Sessions");
		labelSessions.setForeground(new Color(255, 255, 255));
		labelSessions.setFont(new Font("Pristina", Font.BOLD, 45));
		labelSessions.setBounds(42, 11, 417, 44);
		panel_1.add(labelSessions);
		
		JLabel backArrow = new JLabel();
		backArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		backArrow.setBounds(12, 4, 50, 44);
		Image dimg = null;
		try {
			dimg = ImageIO.read(backarrow_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg2 = dimg.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		backArrow.setIcon(new ImageIcon(dimg2));
		panel_1.add(backArrow);
		
		JLabel statistics = new JLabel();
		statistics.setBounds(463, 4, 39, 44);
		Image dimg3 = null;
		try {
			dimg3 = ImageIO.read(statistics_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg4 = dimg3.getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		statistics.setIcon(new ImageIcon(dimg4));
		panel_1.add(statistics);
		
		frame.setVisible(true);
	}
	
	
	public static void getTeachers(){
		number_of_rows = 0;
		Connection connection = null;
		connection = DBMS.getConnection();
		PreparedStatement ps_get;
		PreparedStatement ps_get_type;
		PreparedStatement ps;
		PreparedStatement ps2;
		PreparedStatement ps3;
		PreparedStatement ps4;
		PreparedStatement ps5;
		try {
			ps_get = connection.prepareStatement("SELECT * FROM sessions WHERE student_username = ? OR teacher_username = ?");
			ps_get.setString(1, LogInFrame.getUsername());
			ps_get.setString(2, LogInFrame.getUsername());
			ResultSet rs_get = ps_get.executeQuery();
			
			ps_get_type = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
			ps_get_type.setString(1, LogInFrame.getUsername());
			ResultSet rs_get_type = ps_get_type.executeQuery();
			while(rs_get_type.next()){
				user_type = rs_get_type.getString("type");
			}
			
			ps = connection.prepareStatement("SELECT * FROM sessions WHERE student_username = ? OR teacher_username = ? ORDER BY time");
			ps.setString(1, LogInFrame.getUsername());
			ps.setString(2, LogInFrame.getUsername());
			ResultSet rs = ps.executeQuery();
	
			while(rs_get.next()){
				number_of_rows++;
			}
			
			if(user_type.equals("Student")){
			if(rs.next()){
				
				 teacher1_username = rs.getString("teacher_username");
				 teacher1_time = rs.getString("time");
			}
			if(rs.next()){
				teacher2_username = rs.getString("teacher_username");
				teacher2_time = rs.getString("time");
			}
			if(rs.next()){
				teacher3_username = rs.getString("teacher_username");
				teacher3_time = rs.getString("time");
			}
			if(rs.next()){
				teacher4_username = rs.getString("teacher_username");
				teacher4_time = rs.getString("time");
			}
			
			}
			
			if(user_type.equals("Teacher")){
				if(rs.next()){
					
					 teacher1_username = rs.getString("student_username");
					 teacher1_time = rs.getString("time");
				}
				if(rs.next()){
					teacher2_username = rs.getString("student_username");
					teacher2_time = rs.getString("time");
				}
				if(rs.next()){
					teacher3_username = rs.getString("student_username");
					teacher3_time = rs.getString("time");
				}
				if(rs.next()){
					teacher4_username = rs.getString("student_username");
					teacher4_time = rs.getString("time");
				}
				
				}
			
			ps_get.close();
			rs_get.close();
			ps.close();
			rs.close();
			
			PreparedStatement ps_address1 = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
			ps_address1.setInt(1, CourseTeachersFrame.getID(teacher1_username));
			//System.out.println(CourseTeachersFrame.getID(teacher1_username));
			ResultSet rs_address1 = ps_address1.executeQuery();
			//System.out.println(rs_address1.getRow());
				if(rs_address1.next()){
				//	System.out.println(rs_address1.getRow());
					 teacher1_address = rs_address1.getString(10);
				}
				ps_address1.close();
				rs_address1.close();
		
				PreparedStatement ps_address2 = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
				ps_address2.setInt(1, CourseTeachersFrame.getID(teacher2_username));
				ResultSet rs_address2 = ps_address2.executeQuery();
		
					if(rs_address2.next()){
						 teacher2_address = rs_address2.getString("address");
					}
					ps_address2.close();
					rs_address2.close();
					PreparedStatement ps_address3 = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
					ps_address3.setInt(1, CourseTeachersFrame.getID(teacher3_username));
					ResultSet rs_address3 = ps_address3.executeQuery();
			
						if(rs_address3.next()){
							 teacher3_address = rs_address3.getString("address");
						}
						ps_address3.close();
						rs_address3.close();
						
						PreparedStatement ps_address4 = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
						ps_address4.setInt(1, CourseTeachersFrame.getID(teacher4_username));
						ResultSet rs_address4 = ps_address4.executeQuery();
				
							if(rs_address4.next()){
								 teacher4_address = rs_address4.getString("address");
							}
							ps_address4.close();
							rs_address4.close();
	
			if(number_of_rows >= 1){
			ps2 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
			ps2.setInt(1, CourseTeachersFrame.getID(teacher1_username));
			 byte[] imgBytes;
				ResultSet rs2 = ps2.executeQuery();
				 ByteArrayOutputStream output = new ByteArrayOutputStream();
			     // save the image to the output stream
			     @SuppressWarnings("unused")
				ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
				if(rs2!=null){
				    while (rs2.next()) {
				        imgBytes = rs2.getBytes(1);
				        // use the data in some way here
				        BufferedImage img = null;
						try {
							img = ImageIO.read(new ByteArrayInputStream(imgBytes));
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						Image newimg1 = img.getScaledInstance(labelPic1.getWidth(), labelPic1.getHeight(), Image.SCALE_SMOOTH);
				        labelPic1.setIcon(new ImageIcon(newimg1));
				    }
				}
			}
				
			if(number_of_rows>=2){
				
				ps3 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
				ps3.setInt(1, CourseTeachersFrame.getID(teacher2_username));
				 byte[] imgBytes3;
					ResultSet rs3 = ps3.executeQuery();
					 ByteArrayOutputStream output3 = new ByteArrayOutputStream();
				     // save the image to the output stream
				     @SuppressWarnings("unused")
					ByteArrayInputStream input3 = new ByteArrayInputStream(output3.toByteArray());
					if (rs3 != null) {
					    while (rs3.next()) {
					        imgBytes3 = rs3.getBytes(1);
					        // use the data in some way here
					        BufferedImage img3 = null;
							try {
								img3 = ImageIO.read(new ByteArrayInputStream(imgBytes3));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Image new1 = img3.getScaledInstance(labelPic2.getWidth(), labelPic2.getHeight(), Image.SCALE_SMOOTH);
					        labelPic2.setIcon(new ImageIcon(new1));
					    
					    }
					}
			}
			
			if(number_of_rows >=3){
			
					ps4 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
					ps4.setInt(1, CourseTeachersFrame.getID(teacher3_username));
					 byte[] imgBytes4;
						ResultSet rs4 = ps4.executeQuery();
						 ByteArrayOutputStream output4 = new ByteArrayOutputStream();
					     // save the image to the output stream
					     @SuppressWarnings("unused")
						ByteArrayInputStream input4 = new ByteArrayInputStream(output4.toByteArray());
						if (rs4 != null) {
						    while (rs4.next()) {
						        imgBytes4 = rs4.getBytes(1);
						        // use the data in some way here
						        BufferedImage img4 = null;
								try {
									img4 = ImageIO.read(new ByteArrayInputStream(imgBytes4));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								Image new2 = img4.getScaledInstance(labelPic3.getWidth(), labelPic3.getHeight(), Image.SCALE_SMOOTH);
						        labelPic3.setIcon(new ImageIcon(new2));
						    
						    }
						}
			}
			
			if(number_of_rows >= 4){
			
						ps5 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
						ps5.setInt(1, CourseTeachersFrame.getID(teacher4_username));
						 byte[] imgBytes5;
							ResultSet rs5 = ps5.executeQuery();
							 ByteArrayOutputStream output5 = new ByteArrayOutputStream();
						     // save the image to the output stream
						     @SuppressWarnings("unused")
							ByteArrayInputStream input5 = new ByteArrayInputStream(output5.toByteArray());
							if (rs5 != null) {
							    while (rs5.next()) {
							        imgBytes5 = rs5.getBytes(1);
							        // use the data in some way here
							        BufferedImage img5 = null;
									try {
										img5 = ImageIO.read(new ByteArrayInputStream(imgBytes5));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image new4 = img5.getScaledInstance(labelPic4.getWidth(), labelPic4.getHeight(), Image.SCALE_SMOOTH);
							        labelPic4.setIcon(new ImageIcon(new4));
							    
							    }
							}
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteSession(String time){
		Connection connection = DBMS.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM sessions WHERE time = ?");
			ps.setString(1, time);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
