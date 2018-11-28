package pack;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class SearchFrame {

	private JFrame frame;
	private static String search = "";
	private static String teacher1_username = "";
	private static String teacher2_username = "";
	private static String teacher3_username = "";
	private static String teacher4_username = "";
	private static String teacher5_username = "";
	private static String teacher6_username = "";
	private static String teacher1_course = "";
	private static String teacher2_course = "";
	private static String teacher3_course = "";
	private static String teacher4_course = "";
	private static String teacher5_course = "";
	private static String teacher6_course = "";
	
	static JLabel labelPic1 = new JLabel();
	static JLabel labelPic2 = new JLabel();
	static JLabel labelPic3 = new JLabel();
	static JLabel labelPic4 = new JLabel();
	static JLabel labelPic5 = new JLabel();
	static JLabel labelPic6 = new JLabel();
	
	private static int number_of_rows = -1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame window = new SearchFrame(search);
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
	public SearchFrame(String search) {
		initialize(search);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String search) {
		
		SearchFrame.search = search;
		labelPic1.setBounds(22, 13, 63, 63);
		labelPic2.setBounds(22, 13, 63, 63);
		labelPic3.setBounds(22, 13, 63, 63);
		labelPic4.setBounds(22, 13, 63, 63);
		labelPic5.setBounds(22, 13, 63, 63);
		labelPic6.setBounds(22, 13, 63, 63);
		
		getSearch();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 722);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 482, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setFont(new Font("Pristina", Font.BOLD, 40));
		lblSearch.setBounds(135, 6, 196, 47);
		panel.add(lblSearch);
		
		if(number_of_rows >=1){
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 60, 460, 89);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(labelPic1);
		
		JLabel lblName = new JLabel(teacher1_username);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(125, 26, 170, 38);
		panel_1.add(lblName);
		
		JLabel lblCode = new JLabel(teacher1_course);
		lblCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCode.setForeground(new Color(0, 153, 153));
		lblCode.setBounds(318, 26, 99, 39);
		panel_1.add(lblCode);
		
		}
		
		if(number_of_rows >=2){
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 162, 460, 89);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		panel_2.add(labelPic2);
		
		JLabel label_5 = new JLabel(teacher2_username);
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_5.setBounds(125, 26, 170, 38);
		panel_2.add(label_5);
		
		JLabel label_10 = new JLabel(teacher2_course);
		label_10.setForeground(new Color(0, 153, 153));
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_10.setBounds(318, 26, 99, 39);
		panel_2.add(label_10);
		}
		
		if(number_of_rows >=3){
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 264, 460, 89);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel_3.add(labelPic3);
		
		JLabel label_6 = new JLabel(teacher3_username);
		label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_6.setBounds(125, 26, 170, 38);
		panel_3.add(label_6);
		
		JLabel label_11 = new JLabel(teacher3_course);
		label_11.setForeground(new Color(0, 153, 153));
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_11.setBounds(318, 26, 99, 39);
		panel_3.add(label_11);
		}
		
		if(number_of_rows >=4){
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 366, 460, 89);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(labelPic4);
		
		JLabel label_7 = new JLabel(teacher4_username);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_7.setBounds(125, 26, 170, 38);
		panel_4.add(label_7);
		
		JLabel label_12 = new JLabel(teacher4_course);
		label_12.setForeground(new Color(0, 153, 153));
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_12.setBounds(318, 26, 99, 39);
		panel_4.add(label_12);
		}
		
		if(number_of_rows >=5){
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 469, 460, 89);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		

		panel_5.add(labelPic5);
		
		JLabel label_8 = new JLabel(teacher5_username);
		label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_8.setBounds(125, 26, 170, 38);
		panel_5.add(label_8);
		
		JLabel label_13 = new JLabel(teacher5_course);
		label_13.setForeground(new Color(0, 153, 153));
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_13.setBounds(318, 26, 99, 39);
		panel_5.add(label_13);
		}
		
		if(number_of_rows >=6){
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 573, 460, 89);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		
		panel_6.add(labelPic6);
		
		JLabel label_9 = new JLabel(teacher6_username);
		label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_9.setBounds(125, 26, 170, 38);
		panel_6.add(label_9);
		
		JLabel label_14 = new JLabel(teacher6_course);
		label_14.setForeground(new Color(0, 153, 153));
		label_14.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_14.setBounds(318, 26, 99, 39);
		panel_6.add(label_14);
		}
		
		frame.setVisible(true);
	}
	
	
	
	public void getSearch(){
		Connection connection = DBMS.getConnection();
		
		try {
			PreparedStatement ps2;
			PreparedStatement ps3;
			PreparedStatement ps4;
			PreparedStatement ps5;
			PreparedStatement ps6;
			PreparedStatement ps7;
		
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username LIKE ? OR teaching_course LIKE ?");
			ps.setString(1, "%"+search+"%");
			ps.setString(2, "%"+search+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				if(rs.next()){
					 teacher1_username = rs.getString("username");
					 teacher1_course = rs.getString("teaching_course");
				}
				if(rs.next()){
					teacher2_username = rs.getString("username");
					teacher2_course = rs.getString("teaching_course");
				}
				if(rs.next()){
					teacher3_username = rs.getString("username");
					teacher3_course = rs.getString("teaching_course");
				}
				if(rs.next()){
					teacher4_username = rs.getString("username");
					teacher4_course = rs.getString("teaching_course");
				}
				if(rs.next()){
					teacher5_username = rs.getString("username");
					teacher5_course = rs.getString("teaching_course");
				}
				if(rs.next()){
					teacher6_username = rs.getString("username");
					teacher6_course = rs.getString("teaching_course");
				}
				
				PreparedStatement ps_get = connection.prepareStatement("SELECT * FROM sessions WHERE student_username = ?");
				ps_get.setString(1, LogInFrame.getUsername());
				ResultSet rs_get = ps_get.executeQuery();
		
				while(rs_get.next()){
					number_of_rows++;
				}
				
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
					
					if(number_of_rows >= 5){
						
						ps6 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
						ps6.setInt(1, CourseTeachersFrame.getID(teacher5_username));
						 byte[] imgBytes6;
							ResultSet rs6 = ps6.executeQuery();
							 ByteArrayOutputStream output6 = new ByteArrayOutputStream();
						     // save the image to the output stream
						     @SuppressWarnings("unused")
							ByteArrayInputStream input6 = new ByteArrayInputStream(output6.toByteArray());
							if (rs6 != null) {
							    while (rs6.next()) {
							        imgBytes6 = rs6.getBytes(1);
							        // use the data in some way here
							        BufferedImage img6 = null;
									try {
										img6 = ImageIO.read(new ByteArrayInputStream(imgBytes6));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image new7 = img6.getScaledInstance(labelPic5.getWidth(), labelPic5.getHeight(), Image.SCALE_SMOOTH);
							        labelPic5.setIcon(new ImageIcon(new7));
							    
							    }
							}
			}
					if(number_of_rows >= 6){
						
						ps6 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
						ps6.setInt(1, CourseTeachersFrame.getID(teacher6_username));
						 byte[] imgBytes7;
							ResultSet rs7 = ps6.executeQuery();
							 ByteArrayOutputStream output7 = new ByteArrayOutputStream();
						     // save the image to the output stream
						     @SuppressWarnings("unused")
							ByteArrayInputStream input7 = new ByteArrayInputStream(output7.toByteArray());
							if (rs7 != null) {
							    while (rs7.next()) {
							        imgBytes7 = rs7.getBytes(1);
							        // use the data in some way here
							        BufferedImage img7 = null;
									try {
										img7 = ImageIO.read(new ByteArrayInputStream(imgBytes7));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image new8 = img7.getScaledInstance(labelPic6.getWidth(), labelPic6.getHeight(), Image.SCALE_SMOOTH);
							        labelPic6.setIcon(new ImageIcon(new8));
							    
							    }
							}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
