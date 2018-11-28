package pack;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExploreFrame {

	static JFrame frame;
	private JTextField textField;
	private String textField_text = "                 Search for a course or tutor";
	private JLabel lblNewLabel;
	private File image_file = new File("images/search-icon-white-one-md.png");
	private File icon_file = new File("images/Cup-gold-icon.png");
	private File revision_file = new File("images/202110-200.png");
	private File revisionBtn_file = new File("images/grey-right-arrow-hi.png");
	private File mostpop_file = new File("images/first_course.jpeg");
	private File mostpop_file2 = new File("images/second_course.jpeg");
	private File mostpop_file3 = new File("images/third_course.jpeg");
	private URL url1;
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblReward;
	private JLabel lblHi;
	private JLabel lblFreeHours;
	private JPanel panel_2;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblS;
	private JLabel lblButn;
	private JPanel panel_3;
	private JLabel lblMostPopularCourses;
	private JLabel labelMostPop1;
	private JLabel labelMostPop3;
	private JLabel lblSearch;
	private JPanel panel_4;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExploreFrame window = new ExploreFrame();
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
	public ExploreFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			url1 = new URL("https://www.facebook.com/Synkers/");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 571, 63);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel();
		Image dimg = null;
		try {
			dimg = ImageIO.read(image_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg2 = dimg.getScaledInstance(20, 16, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(dimg2));
		lblNewLabel.setBounds(22, 13, 56, 34);
		lblNewLabel.setBackground(new Color(0,102,102));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					SearchFrame search = new SearchFrame(textField.getText());
				}
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
			}
		});
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
			}
		});
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText(textField_text);
		textField.setBounds(55, 13, 403, 34);
		panel.add(textField);
		textField.setBackground(new Color(0, 102, 102));
		textField.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchFrame search = new SearchFrame(textField.getText());
			}
		});
		panel_4.setBackground(new Color(0,102,102));
		panel_4.setBounds(470, 15, 89, 30);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setBounds(12, 6, 65, 16);
		panel_4.add(lblSearch);
		lblSearch.setBackground(new Color(0,102,102));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 83, 550, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel();		
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(12, 13, 89, 69);
		Image dimg3 = null;
		try {
			dimg3 = ImageIO.read(icon_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg4 = dimg3.getScaledInstance(79, 59, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(dimg4));

		panel_1.add(label);
		
		lblReward = new JLabel("Reward");
		lblReward.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReward.setBounds(127, 7, 128, 31);
		panel_1.add(lblReward);
		
		lblHi = new JLabel("Hi " + LogInFrame.getUsername() + ", you're 10 hours away from your free tutoring hour!");
		lblHi.setBounds(127, 41, 353, 16);
		panel_1.add(lblHi);
		
		lblFreeHours = new JLabel("0 free hours                      |                 0 redeemed");
		lblFreeHours.setBounds(127, 66, 335, 16);
		panel_1.add(lblFreeHours);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setBackground(Color.LIGHT_GRAY);				
			}
		});
		
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 194, 550, 95);
		frame.getContentPane().add(panel_2);
		
		label_1 = new JLabel();
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(12, 13, 89, 69);
		Image dimg5 = null;
		try {
			dimg5 = ImageIO.read(revision_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg6 = dimg5.getScaledInstance(79, 69, Image.SCALE_SMOOTH);
		label_1.setIcon(new ImageIcon(dimg6));
		panel_2.add(label_1);
		
		label_2 = new JLabel("Revision Sessions");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(127, 7, 243, 31);
		panel_2.add(label_2);
		
		label_3 = new JLabel("Join the revision Sessions with Synkers! Our");
		label_3.setBounds(127, 39, 353, 16);
		panel_2.add(label_3);
		
		label_4 = new JLabel("professional tutors are in your universities or school");
		label_4.setBounds(127, 54, 335, 16);
		panel_2.add(label_4);
		
		lblS = new JLabel("to help you review before your exams.");
		lblS.setBounds(127, 68, 335, 16);
		panel_2.add(lblS);
		
		lblButn = new JLabel("");
		lblButn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage(url1);
			}
		});
		lblButn.setBounds(452, 24, 72, 47);
		Image dimg7 = null;
		try {
			dimg7 = ImageIO.read(revisionBtn_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg8 = dimg7.getScaledInstance(72, 47, Image.SCALE_SMOOTH);
		lblButn.setIcon(new ImageIcon(dimg8));
		panel_2.add(lblButn);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 305, 550, 171);
		frame.getContentPane().add(panel_3);
		
		lblMostPopularCourses = new JLabel("Most Popular Courses");
		lblMostPopularCourses.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMostPopularCourses.setBounds(153, 7, 293, 31);
		panel_3.add(lblMostPopularCourses);
		
		labelMostPop1 = new JLabel();
		
		labelMostPop1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CourseTeachersFrame MGT_420 = new CourseTeachersFrame("MGT 420");
			}
		});
		
		labelMostPop1.setBounds(50, 45, 161, 121);
		Image dimg9 = null;
		try {
			dimg9 = ImageIO.read(mostpop_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg10 = dimg9.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
		labelMostPop1.setIcon(new ImageIcon(dimg10));
		panel_3.add(labelMostPop1);
		
		JLabel labelMostPop2 = new JLabel();
		
		labelMostPop2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CourseTeachersFrame MATH_201 = new CourseTeachersFrame("MATH 201");
			}
		});
		
		labelMostPop2.setBounds(217, 45, 161, 121);
		Image dimg11 = null;
		try {
			dimg11 = ImageIO.read(mostpop_file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg12 = dimg11.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
		labelMostPop2.setIcon(new ImageIcon(dimg12));
		
		panel_3.add(labelMostPop2);
		
		labelMostPop3 = new JLabel();
		
		labelMostPop3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CourseTeachersFrame SAT_M = new CourseTeachersFrame("SAT M");
			}
		});
		
		labelMostPop3.setBounds(381, 45, 161, 121);
		Image dimg13 = null;
		try {
			dimg13 = ImageIO.read(mostpop_file3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image dimg14 = dimg13.getScaledInstance(125, 100, Image.SCALE_SMOOTH);
		labelMostPop3.setIcon(new ImageIcon(dimg14));
		panel_3.add(labelMostPop3);
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField_text);
			}
		});


		
		
		frame.setVisible(true);
	}
	
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
}
