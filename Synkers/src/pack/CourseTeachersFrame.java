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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CourseTeachersFrame {

	static JFrame frame;
	private String MGT_420 = "Strategic Planning and Policy Formulation";
	private String MATH_201 = "Calculus and Analytic Geometry III";
	private String SAT_M = "SAT Math";
	static String course_name = "";
	static File backarrow_file = new File("images/arrows.png");
	private File statistics_file = new File("images/statistics.png");
	private File star_file = new File("images/star.png");
	private File blackstar_file = new File("images/blackstar.png");
	private static String teacher1_username = "";
	private static String teacher2_username = "";
	private static String teacher3_username = "";
	private static String teacher4_username = "";
	private static String teacher1_address = "";
	private static String teacher2_address = "";
	private static String teacher3_address = "";
	private static String teacher4_address = "";
	private static int star_chooser_1 = 0;
	private static int star_chooser_2 = 0;
	private static int star_chooser_3 = 0;
	private static int star_chooser_4 = 0;
	private static int star_chooser_5 = 0;
	private static int star_chooser = 0;
	private static int star_chooser1 = 0;
	private static int star_chooser2 = 0;
	private static int star_chooser6 = 0;
	private static int star_chooser7 = 0;
	private static int star_chooser8 = 0;
	private static int star_chooser9 = 0;
	private static int star_chooser10 = 0;
	private static int star_chooser11 = 0;
	private static int star_chooser12 = 0;
	private static int star_chooser13 = 0;
	private static int star_chooser14 = 0;
	private static int star_chooser15 = 0;
	private static int star_chooser16 = 0;
	private static int star_chooser17 = 0;
	private static int panel_clicked1 = 0;
	private static int panel_clicked2 = 0;
	private static int panel_clicked3 = 0;
	private static int panel_clicked4 = 0;
	private static int panel_clicked5 = 0;
	static JLabel labelPic1 = new JLabel();
	static JLabel labelPic2 = new JLabel();
	static JLabel labelPic3 = new JLabel();
	static JLabel labelPic4 = new JLabel();
	private static int number_of_rows=-1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseTeachersFrame window = new CourseTeachersFrame(course_name);
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
	public CourseTeachersFrame(String course_name) {
		initialize(course_name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String course_name) {
		CourseTeachersFrame.course_name = course_name;
		labelPic1.setBounds(12, 13, 71, 84);
		labelPic2.setBounds(12, 13, 71, 84);
		labelPic3.setBounds(12, 13, 71, 84);
		labelPic4.setBounds(12, 13, 71, 84);
		
		
		getTeachers();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 620);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 502, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVourse = new JLabel();
		if(course_name.equals("MGT 420")){
		lblVourse.setText(MGT_420);
		}
		if(course_name.equals("MATH 201")){
			lblVourse.setText(MATH_201);
		}
		if(course_name.equals("SAT M")){
			lblVourse.setText(SAT_M);
		}
		lblVourse.setForeground(new Color(0, 153, 153));
		lblVourse.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblVourse.setBounds(55, 4, 417, 29);
		panel.add(lblVourse);
		
		
		JLabel lblCode = new JLabel(course_name);
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCode.setForeground(new Color(0, 153, 153));
		lblCode.setBounds(55, 32, 72, 16);
		panel.add(lblCode);
		
		JLabel labelBackArrow = new JLabel();
		labelBackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		labelBackArrow.setBounds(12, 4, 50, 44);
		Image dimg = null;
		try {
			dimg = ImageIO.read(backarrow_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg2 = dimg.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		labelBackArrow.setIcon(new ImageIcon(dimg2));
		panel.add(labelBackArrow);
		
		JLabel lblS = new JLabel();
		lblS.setBounds(463, 4, 39, 44);
		Image dimg3 = null;
		try {
			dimg3 = ImageIO.read(statistics_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg4 = dimg3.getScaledInstance(30, 25, Image.SCALE_SMOOTH);
		
		Image star_image1 = null;
		try {
			star_image1 = ImageIO.read(star_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image star_image2 = star_image1.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		Image star_image3 = null;
		try {
			star_image3 = ImageIO.read(blackstar_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image blackstar_image = star_image3.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		
		lblS.setIcon(new ImageIcon(dimg4));
		panel.add(lblS);
		
		if(number_of_rows >=1){
			
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 77, 480, 110);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeachersProfileFrame teacher_profile = new TeachersProfileFrame(teacher1_username);
		}});
		
		
		panel_1.add(labelPic1);
		
		JLabel labelName1 = new JLabel(teacher1_username);
		labelName1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelName1.setBounds(112, 13, 168, 31);
		panel_1.add(labelName1);
		
		JLabel lblSMT = new JLabel("S M T W T F S");
		lblSMT.setForeground(new Color(0, 153, 153));
		lblSMT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSMT.setBounds(112, 50, 153, 16);
		panel_1.add(lblSMT);
		
		JLabel lblAddress1 = new JLabel(teacher1_address);
		lblAddress1.setBounds(112, 76, 210, 16);
		panel_1.add(lblAddress1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(290, 23, 153, 36);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 5, 0, 0));

		

		JLabel labelStar1 = new JLabel();
		labelStar1.setIcon(new ImageIcon(star_image2));
		panel_5.add(labelStar1);
		
		JLabel labelStar2 = new JLabel();
		labelStar2.setIcon(new ImageIcon(star_image2));
		panel_5.add(labelStar2);
		
		JLabel labelStar3 = new JLabel();
		labelStar3.setIcon(new ImageIcon(star_image2));
		panel_5.add(labelStar3);
		
		JLabel labelStar4 = new JLabel();
		labelStar4.setIcon(new ImageIcon(star_image2));
		panel_5.add(labelStar4);
		
		JLabel labelStar5 = new JLabel();
		labelStar5.setIcon(new ImageIcon(star_image2));
		panel_5.add(labelStar5);
		
		labelStar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(star_chooser_1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				star_chooser_1 = 1;
				panel_clicked1 = 1;
				}
				else {
					labelStar1.setIcon(new ImageIcon(star_image2));
					labelStar2.setIcon(new ImageIcon(star_image2));
					labelStar3.setIcon(new ImageIcon(star_image2));
					labelStar4.setIcon(new ImageIcon(star_image2));
					labelStar5.setIcon(new ImageIcon(star_image2));
					star_chooser_1 = 0;
					panel_clicked1 = 0;
				}		
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(star_image2));
				}
			}
			
		});
		labelStar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser_2 == 0){
					labelStar1.setIcon(new ImageIcon(blackstar_image));
					labelStar2.setIcon(new ImageIcon(blackstar_image));
					star_chooser_2 = 1;
					panel_clicked1 = 1;
					}
					else {
						labelStar2.setIcon(new ImageIcon(star_image2));
						labelStar3.setIcon(new ImageIcon(star_image2));
						labelStar4.setIcon(new ImageIcon(star_image2));
						labelStar5.setIcon(new ImageIcon(star_image2));
						star_chooser_2 = 0;
						panel_clicked1 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				labelStar2.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(star_image2));
				labelStar2.setIcon(new ImageIcon(star_image2));
				}
			}

		});
		labelStar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser_3 == 0){
					labelStar1.setIcon(new ImageIcon(blackstar_image));
					labelStar2.setIcon(new ImageIcon(blackstar_image));
					labelStar3.setIcon(new ImageIcon(blackstar_image));
					star_chooser_3 = 1;
					panel_clicked1 = 1;
					}
					else {
						labelStar3.setIcon(new ImageIcon(star_image2));
						labelStar4.setIcon(new ImageIcon(star_image2));
						labelStar5.setIcon(new ImageIcon(star_image2));
						star_chooser_3 = 0;
						panel_clicked1 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				labelStar2.setIcon(new ImageIcon(blackstar_image));
				labelStar3.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(star_image2));
				labelStar2.setIcon(new ImageIcon(star_image2));
				labelStar3.setIcon(new ImageIcon(star_image2));
			}
			}
		});
		labelStar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser_4 == 0){
					labelStar1.setIcon(new ImageIcon(blackstar_image));
					labelStar2.setIcon(new ImageIcon(blackstar_image));
					labelStar3.setIcon(new ImageIcon(blackstar_image));
					labelStar4.setIcon(new ImageIcon(blackstar_image));
					star_chooser_4 = 1;
					panel_clicked1 = 1;
					}
					else {
						labelStar4.setIcon(new ImageIcon(star_image2));
						labelStar5.setIcon(new ImageIcon(star_image2));
						star_chooser_4 = 0;
						panel_clicked1 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				labelStar2.setIcon(new ImageIcon(blackstar_image));
				labelStar3.setIcon(new ImageIcon(blackstar_image));
				labelStar4.setIcon(new ImageIcon(blackstar_image));
			}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if( panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(star_image2));
				labelStar2.setIcon(new ImageIcon(star_image2));
				labelStar3.setIcon(new ImageIcon(star_image2));
				labelStar4.setIcon(new ImageIcon(star_image2));
			}
			}
		});
		labelStar5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser_5 == 0){
					labelStar1.setIcon(new ImageIcon(blackstar_image));
					labelStar2.setIcon(new ImageIcon(blackstar_image));
					labelStar3.setIcon(new ImageIcon(blackstar_image));
					labelStar4.setIcon(new ImageIcon(blackstar_image));
					labelStar5.setIcon(new ImageIcon(blackstar_image));
					star_chooser_5 = 1;
					panel_clicked1 = 1;
					}
					else {
						labelStar5.setIcon(new ImageIcon(star_image2));
						star_chooser_5 = 0;
						panel_clicked1 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(blackstar_image));
				labelStar2.setIcon(new ImageIcon(blackstar_image));
				labelStar3.setIcon(new ImageIcon(blackstar_image));
				labelStar4.setIcon(new ImageIcon(blackstar_image));
				labelStar5.setIcon(new ImageIcon(blackstar_image));
			}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked1 == 0){
				labelStar1.setIcon(new ImageIcon(star_image2));
				labelStar2.setIcon(new ImageIcon(star_image2));
				labelStar3.setIcon(new ImageIcon(star_image2));
				labelStar4.setIcon(new ImageIcon(star_image2));
				labelStar5.setIcon(new ImageIcon(star_image2));
			}
			}
		});
		
		}		
		
		if(number_of_rows >= 2){
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 200, 480, 110);
		frame.getContentPane().add(panel_2);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeachersProfileFrame teacher_profile2 = new TeachersProfileFrame(teacher2_username);
		}});
		
		panel_2.add(labelPic2);
		
		JLabel labelName2 = new JLabel(teacher2_username);
		labelName2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelName2.setBounds(112, 13, 168, 31);
		panel_2.add(labelName2);
		
		JLabel label_3 = new JLabel("S M T W T F S");
		label_3.setForeground(new Color(0, 153, 153));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(112, 50, 153, 16);
		panel_2.add(label_3);
		
		JLabel lblAddress2 = new JLabel(teacher2_address);
		lblAddress2.setBounds(112, 76, 210, 16);
		panel_2.add(lblAddress2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(290, 23, 153, 36);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(star_image2));
		panel_6.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(star_image2));
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon(star_image2));
		panel_6.add(label_2);
		
		JLabel label_6 = new JLabel();
		label_6.setIcon(new ImageIcon(star_image2));
		panel_6.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setIcon(new ImageIcon(star_image2));
		panel_6.add(label_7);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser == 0){
					label.setIcon(new ImageIcon(blackstar_image));
					star_chooser = 1;
					panel_clicked2 = 1;
					}
					else {
						label.setIcon(new ImageIcon(star_image2));
						label_1.setIcon(new ImageIcon(star_image2));
						label_2.setIcon(new ImageIcon(star_image2));
						label_6.setIcon(new ImageIcon(star_image2));
						label_7.setIcon(new ImageIcon(star_image2));
						star_chooser = 0;
						panel_clicked2 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
			
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser1 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				star_chooser1 = 1;
				panel_clicked2 = 1;
				}
				else {
					label_1.setIcon(new ImageIcon(star_image2));
					label_2.setIcon(new ImageIcon(star_image2));
					label_6.setIcon(new ImageIcon(star_image2));
					label_7.setIcon(new ImageIcon(star_image2));
					star_chooser1 = 0;
					panel_clicked2 = 0;
				}		
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(star_image2));
				label_1.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				star_chooser2 = 1;
				panel_clicked2 = 1;
				}
				else {
					label_2.setIcon(new ImageIcon(star_image2));
					label_6.setIcon(new ImageIcon(star_image2));
					label_7.setIcon(new ImageIcon(star_image2));
					star_chooser2 = 0;
					panel_clicked2 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(star_image2));
				label_1.setIcon(new ImageIcon(star_image2));
				label_2.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser6 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				label_6.setIcon(new ImageIcon(blackstar_image));
				star_chooser6 = 1;
				panel_clicked2 = 1;
				}
				else {
					label_6.setIcon(new ImageIcon(star_image2));
					label_7.setIcon(new ImageIcon(star_image2));
					star_chooser6 = 0;
					panel_clicked2 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				label_6.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(star_image2));
				label_1.setIcon(new ImageIcon(star_image2));
				label_2.setIcon(new ImageIcon(star_image2));
				label_6.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser7 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				label_6.setIcon(new ImageIcon(blackstar_image));
				label_7.setIcon(new ImageIcon(blackstar_image));
				star_chooser7= 1;
				panel_clicked2 = 1;
				}
				else {
					label_7.setIcon(new ImageIcon(star_image2));
					star_chooser7 = 0;
					panel_clicked2 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(blackstar_image));
				label_1.setIcon(new ImageIcon(blackstar_image));
				label_2.setIcon(new ImageIcon(blackstar_image));
				label_6.setIcon(new ImageIcon(blackstar_image));
				label_7.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked2 == 0){
				label.setIcon(new ImageIcon(star_image2));
				label_1.setIcon(new ImageIcon(star_image2));
				label_2.setIcon(new ImageIcon(star_image2));
				label_6.setIcon(new ImageIcon(star_image2));
				label_7.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		}
		
		if(number_of_rows >= 3){
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 323, 480, 110);
		frame.getContentPane().add(panel_3);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeachersProfileFrame teacher_profile3 = new TeachersProfileFrame(teacher3_username);
		}});
		
		
		panel_3.add(labelPic3);
		
		JLabel labelName3 = new JLabel(teacher3_username);
		labelName3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelName3.setBounds(112, 13, 168, 31);
		panel_3.add(labelName3);
		
		JLabel label_4 = new JLabel("S M T W T F S");
		label_4.setForeground(new Color(0, 153, 153));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(112, 50, 153, 16);
		panel_3.add(label_4);
		
		JLabel lblAddress3 = new JLabel(teacher3_address);
		lblAddress3.setBounds(112, 76, 210, 16);
		panel_3.add(lblAddress3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(290, 23, 153, 36);
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 5, 0, 0));
	
		JLabel label_8 = new JLabel();
		label_8.setIcon(new ImageIcon(star_image2));
		panel_7.add(label_8);
		
		JLabel label_9 = new JLabel();
		label_9.setIcon(new ImageIcon(star_image2));
		panel_7.add(label_9);
		
		JLabel label_10 = new JLabel();
		label_10.setIcon(new ImageIcon(star_image2));
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel();
		label_11.setIcon(new ImageIcon(star_image2));
		panel_7.add(label_11);
		
		JLabel label_12 = new JLabel();
		label_12.setIcon(new ImageIcon(star_image2));
		panel_7.add(label_12);
		
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser8 == 0){
					label_8.setIcon(new ImageIcon(blackstar_image));
					star_chooser8 = 1;
					panel_clicked3 = 1;
					}
					else {
						label_8.setIcon(new ImageIcon(star_image2));
						label_9.setIcon(new ImageIcon(star_image2));
						label_10.setIcon(new ImageIcon(star_image2));
						label_11.setIcon(new ImageIcon(star_image2));
						label_12.setIcon(new ImageIcon(star_image2));
						star_chooser8 = 0;
						panel_clicked3 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
			
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser9 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				star_chooser9 = 1;
				panel_clicked3 = 1;
				}
				else {
					label_9.setIcon(new ImageIcon(star_image2));
					label_10.setIcon(new ImageIcon(star_image2));
					label_11.setIcon(new ImageIcon(star_image2));
					label_12.setIcon(new ImageIcon(star_image2));
					star_chooser9 = 0;
					panel_clicked3 = 0;
				}		
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(star_image2));
				label_9.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser10 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				star_chooser10 = 1;
				panel_clicked3 = 1;
				}
				else {
					label_10.setIcon(new ImageIcon(star_image2));
					label_11.setIcon(new ImageIcon(star_image2));
					label_12.setIcon(new ImageIcon(star_image2));
					star_chooser10 = 0;
					panel_clicked3 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(star_image2));
				label_9.setIcon(new ImageIcon(star_image2));
				label_10.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser11 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				label_11.setIcon(new ImageIcon(blackstar_image));
				star_chooser11 = 1;
				panel_clicked3 = 1;
				}
				else {
					label_11.setIcon(new ImageIcon(star_image2));
					label_12.setIcon(new ImageIcon(star_image2));
					star_chooser11 = 0;
					panel_clicked3 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				label_11.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(star_image2));
				label_9.setIcon(new ImageIcon(star_image2));
				label_10.setIcon(new ImageIcon(star_image2));
				label_11.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser12 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				label_11.setIcon(new ImageIcon(blackstar_image));
				label_12.setIcon(new ImageIcon(blackstar_image));
				star_chooser12 = 1;
				panel_clicked3 = 1;
				}
				else {
					label_12.setIcon(new ImageIcon(star_image2));
					star_chooser12 = 0;
					panel_clicked3 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(blackstar_image));
				label_9.setIcon(new ImageIcon(blackstar_image));
				label_10.setIcon(new ImageIcon(blackstar_image));
				label_11.setIcon(new ImageIcon(blackstar_image));
				label_12.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked3 == 0){
				label_8.setIcon(new ImageIcon(star_image2));
				label_9.setIcon(new ImageIcon(star_image2));
				label_10.setIcon(new ImageIcon(star_image2));
				label_11.setIcon(new ImageIcon(star_image2));
				label_12.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		}
		
		if(number_of_rows >= 4){
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 446, 480, 110);
		frame.getContentPane().add(panel_4);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TeachersProfileFrame teacher_profile4 = new TeachersProfileFrame(teacher4_username);
		}});

		panel_4.add(labelPic4);
		
		JLabel labelName4 = new JLabel(teacher4_username);
		labelName4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelName4.setBounds(112, 13, 168, 31);
		panel_4.add(labelName4);
		
		JLabel label_5 = new JLabel("S M T W T F S");
		label_5.setForeground(new Color(0, 153, 153));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(112, 50, 153, 16);
		panel_4.add(label_5);
		
		JLabel lblAddress4 = new JLabel(teacher4_address);
		lblAddress4.setBounds(112, 76, 210, 16);
		panel_4.add(lblAddress4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(290, 23, 153, 36);
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel label_13 = new JLabel();
		label_13.setIcon(new ImageIcon(star_image2));
		panel_8.add(label_13);
		
		JLabel label_14 = new JLabel();
		label_14.setIcon(new ImageIcon(star_image2));
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel();
		label_15.setIcon(new ImageIcon(star_image2));
		panel_8.add(label_15);
		
		JLabel label_16 = new JLabel();
		label_16.setIcon(new ImageIcon(star_image2));
		panel_8.add(label_16);
		
		JLabel label_17 = new JLabel();
		label_17.setIcon(new ImageIcon(star_image2));
		panel_8.add(label_17);
		
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser13 == 0){
					label_13.setIcon(new ImageIcon(blackstar_image));
					star_chooser13 = 1;
					panel_clicked4 = 1;
					}
					else {
						label_13.setIcon(new ImageIcon(star_image2));
						label_14.setIcon(new ImageIcon(star_image2));
						label_15.setIcon(new ImageIcon(star_image2));
						label_16.setIcon(new ImageIcon(star_image2));
						label_17.setIcon(new ImageIcon(star_image2));
						star_chooser13 = 0;
						panel_clicked4 = 0;
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
			
		label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser14 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				star_chooser14 = 1;
				panel_clicked4 = 1;
				}
				else {
					label_14.setIcon(new ImageIcon(star_image2));
					label_15.setIcon(new ImageIcon(star_image2));
					label_16.setIcon(new ImageIcon(star_image2));
					label_17.setIcon(new ImageIcon(star_image2));
					star_chooser14 = 0;
					panel_clicked4 = 0;
				}		
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(star_image2));
				label_14.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser15 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				star_chooser15 = 1;
				panel_clicked4 = 1;
				}
				else {
					label_15.setIcon(new ImageIcon(star_image2));
					label_16.setIcon(new ImageIcon(star_image2));
					label_17.setIcon(new ImageIcon(star_image2));
					star_chooser15 = 0;
					panel_clicked4 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(star_image2));
				label_14.setIcon(new ImageIcon(star_image2));
				label_15.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser16 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				label_16.setIcon(new ImageIcon(blackstar_image));
				star_chooser16 = 1;
				panel_clicked4 = 1;
				}
				else {
					label_16.setIcon(new ImageIcon(star_image2));
					label_17.setIcon(new ImageIcon(star_image2));
					star_chooser16 = 0;
					panel_clicked4 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				label_16.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(star_image2));
				label_14.setIcon(new ImageIcon(star_image2));
				label_15.setIcon(new ImageIcon(star_image2));
				label_16.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(star_chooser17 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				label_16.setIcon(new ImageIcon(blackstar_image));
				label_17.setIcon(new ImageIcon(blackstar_image));
				star_chooser17 = 1;
				panel_clicked4 = 1;
				}
				else {
					label_17.setIcon(new ImageIcon(star_image2));
					star_chooser17 = 0;
					panel_clicked4 = 0;
				}		
			}	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(blackstar_image));
				label_14.setIcon(new ImageIcon(blackstar_image));
				label_15.setIcon(new ImageIcon(blackstar_image));
				label_16.setIcon(new ImageIcon(blackstar_image));
				label_17.setIcon(new ImageIcon(blackstar_image));
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0){
				if(panel_clicked4 == 0){
				label_13.setIcon(new ImageIcon(star_image2));
				label_14.setIcon(new ImageIcon(star_image2));
				label_15.setIcon(new ImageIcon(star_image2));
				label_16.setIcon(new ImageIcon(star_image2));
				label_17.setIcon(new ImageIcon(star_image2));
				}
			}
		});
		}
		
		
		frame.setVisible(true);
	}
	
	public static int getID(String username){
		int id= -1;
		Connection connection = null;
		connection = DBMS.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT userid FROM users WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static void getTeachers(){
		number_of_rows = 0;
		Connection connection = null;
		connection = DBMS.getConnection();
		PreparedStatement ps_get;
		PreparedStatement ps;
		PreparedStatement ps2;
		PreparedStatement ps3;
		PreparedStatement ps4;
		PreparedStatement ps5;
		try {
			ps_get = connection.prepareStatement("SELECT * FROM users WHERE teaching_course = ? ORDER BY userid");
			ps_get.setString(1, CourseTeachersFrame.course_name);
			ResultSet rs_get = ps_get.executeQuery();
			
			ps = connection.prepareStatement("SELECT * FROM users WHERE teaching_course = ? ORDER BY userid");
			ps.setString(1, CourseTeachersFrame.course_name);
			ResultSet rs = ps.executeQuery();
	
			while(rs_get.next()){
				number_of_rows++;
			}
			
			if(rs.next()){
				 teacher1_username = rs.getString("username");
				 teacher1_address = rs.getString("address");
			}
			if(rs.next()){
				teacher2_username = rs.getString("username");
				teacher2_address = rs.getString("address");
			}
			if(rs.next()){
				teacher3_username = rs.getString("username");
				teacher3_address = rs.getString("address");
			}
			if(rs.next()){
				teacher4_username = rs.getString("username");
				teacher4_address = rs.getString("address");
			}
	
			if(number_of_rows >= 1){
			ps2 = connection.prepareStatement("SELECT img FROM images WHERE userid = ?");
			ps2.setInt(1, getID(teacher1_username));
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
				ps3.setInt(1, getID(teacher2_username));
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
					ps4.setInt(1, getID(teacher3_username));
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
						ps5.setInt(1, getID(teacher4_username));
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
}
