package pack;

import java.awt.EventQueue;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeachersProfileFrame {

	static JFrame frame;
	JLabel imageLabel = new JLabel();
	static String teacher_username = "";
	private String teacher_address = "";
	private String teacher_description = "";
	private String teacher_university = "";
	private File verified_file = new File("images/Ok-icon.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachersProfileFrame window = new TeachersProfileFrame(teacher_username);
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
	public TeachersProfileFrame(String teacher_username) {
		initialize(teacher_username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String teacher_username) {
		TeachersProfileFrame.teacher_username = teacher_username;
		imageLabel.setBounds(27, 64, 131, 130);
		getInfo();
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 562, 51);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelBackArrow = new JLabel();
		labelBackArrow.setBounds(12, 5, 50, 44);
		Image dimg = null;
		try {
			dimg = ImageIO.read(CourseTeachersFrame.backarrow_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg2 = dimg.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		labelBackArrow.setIcon(new ImageIcon(dimg2));
		panel.add(labelBackArrow);
		panel.add(labelBackArrow);
		
		JLabel labelName = new JLabel();
		labelName.setText(teacher_username);
		labelName.setForeground(new Color(0, 153, 153));
		labelName.setFont(new Font("Tahoma", Font.BOLD, 19));
		labelName.setBounds(75, 10, 417, 29);
		panel.add(labelName);
	
		frame.getContentPane().add(imageLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 219, 538, 79);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbout.setBounds(12, 4, 56, 16);
		panel_1.add(lblAbout);
		
		JLabel lblNewLabel = new JLabel(teacher_description);
		lblNewLabel.setBounds(12, 33, 514, 16);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 326, 538, 51);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEducation = new JLabel("Education");
		lblEducation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEducation.setBounds(12, 4, 104, 16);
		panel_2.add(lblEducation);
		
		JLabel lblNewLabel_1 = new JLabel(teacher_university);
		lblNewLabel_1.setBounds(12, 25, 424, 16);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 401, 538, 51);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblVerifiedTutor = new JLabel("Verified Tutor");
		lblVerifiedTutor.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblVerifiedTutor.setBounds(28, 0, 177, 51);
		panel_3.add(lblVerifiedTutor);
		
		JLabel verified_image = new JLabel("");
		verified_image.setBounds(401, 0, 69, 51);
		Image vimg = null;
		try {
			vimg = ImageIO.read(verified_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image vimg2 = vimg.getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		verified_image.setIcon(new ImageIcon(vimg2));
		panel_3.add(verified_image);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(12, 473, 538, 67);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(new Color(0, 153, 153));
		panel_5.setBounds(302, 13, 208, 41);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblCheck = new JLabel("Check Availability");
		
		lblCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CalendarFrame calendar = new CalendarFrame();
			}
		});
		
		lblCheck.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCheck.setBounds(7, 13, 189, 16);
		panel_5.add(lblCheck);
		lblCheck.setForeground(new Color(255, 255, 255));
		lblCheck.setBackground(new Color(0, 153, 153));
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPerHour = new JLabel("32$");
		lblPerHour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPerHour.setBounds(22, 13, 40, 16);
		panel_4.add(lblPerHour);
		
		JLabel lblPerHour_1 = new JLabel("per hour");
		lblPerHour_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPerHour_1.setBounds(57, 13, 56, 16);
		panel_4.add(lblPerHour_1);
		
		JLabel labelCourse = new JLabel(CourseTeachersFrame.course_name);
		labelCourse.setBounds(22, 38, 253, 16);
		panel_4.add(labelCourse);
		
		JLabel labelUserName = new JLabel(teacher_username);
		labelUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelUserName.setBounds(187, 97, 231, 16);
		frame.getContentPane().add(labelUserName);
		
		JLabel labelAddress = new JLabel(teacher_address);
		labelAddress.setBounds(187, 134, 308, 16);
		frame.getContentPane().add(labelAddress);
		
		frame.setVisible(true);
	}
	
	
	public void getInfo(){
		
		Connection connection = DBMS.getConnection();
		PreparedStatement ps;
		try{
		ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
		ps.setString(1, teacher_username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			teacher_description = rs.getString("description");
			teacher_university = rs.getString("university");
			teacher_address = rs.getString("address");
			
		}
		
		PreparedStatement ps_img = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
		ps_img.setInt(1, getID(teacher_username));
		 byte[] imgBytes;
		ResultSet rs_img = ps_img.executeQuery();
		 ByteArrayOutputStream output = new ByteArrayOutputStream();
	     // save the image to the output stream
	     @SuppressWarnings("unused")
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());

		    while (rs_img.next()) {
		        imgBytes = rs_img.getBytes(1);
		        // use the data in some way here
		        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
				Image dimg2 = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		        imageLabel.setIcon(new ImageIcon(dimg2));
		    }
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static int getID(String username){
			
			int id=-1;
			
			Connection connection = DBMS.getConnection();
			PreparedStatement st;
			
			try {
				st = connection.prepareStatement("SELECT userid FROM users WHERE username = ?");
				st.setString(1, username);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					id = rs.getInt("userid");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return id;
			}
}
