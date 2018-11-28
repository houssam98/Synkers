package pack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SuccessfulLoginFrame {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccessfulLoginFrame window = new SuccessfulLoginFrame();
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
	public SuccessfulLoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		frame = new JFrame("© 2017 Synkers - Logged in as ["+ LogInFrame.getUsername() + "] at " + dtf.format(now));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel synkersLabel = new JLabel("");
		synkersLabel.setBounds(-12, 1, 187, 217);
		synkersLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		synkersLabel.setIcon(new ImageIcon("images/logo.png"));
		frame.getContentPane().add(synkersLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(187, 1, 391, 217);
		lblNewLabel_1.setIcon(new ImageIcon("images/AAEAAQAAAAAAAAk3AAAAJGFlZTJkYjIzLTk0YmEtNGJkMC05NTljLTRhMGQ0MDliNDBiZQ.png"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnExplore = new JButton("Explore");
		btnExplore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExploreFrame explore_frame = new ExploreFrame();
			}
		});
		btnExplore.setBounds(0, 218, 391, 217);
		btnExplore.setForeground(Color.WHITE);
		btnExplore.setBackground(new Color(0, 153, 153));
		btnExplore.setFont(new Font("Pristina", Font.BOLD, 49));
		btnExplore.setFocusPainted(false);
		frame.getContentPane().add(btnExplore);
		
		
		JButton btnSessions = new JButton("Sessions");
		btnSessions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SessionsFrame sessions = new SessionsFrame();
			}
		});
		btnSessions.setBounds(391, 218, 391, 217);
		btnSessions.setForeground(Color.WHITE);
		btnSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSessions.setBackground(new Color(0, 153, 153));
		btnSessions.setFont(new Font("Pristina", Font.BOLD, 50));
		btnSessions.setFocusPainted(false);
		frame.getContentPane().add(btnSessions);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.setBounds(0, 435, 391, 217);
		
		
		btnMessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("unused")
				InboxFrame inbox_frame = new InboxFrame();
			}
		});
		
		btnMessages.setForeground(Color.WHITE);
		btnMessages.setBackground(new Color(0, 153, 153));
		btnMessages.setFont(new Font("Pristina", Font.BOLD, 50));
		btnMessages.setFocusPainted(false);
		frame.getContentPane().add(btnMessages);
		
		JButton btnProfile = new JButton("Profile");
		
		btnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("unused")
				ProfileFrame profile_frame = new ProfileFrame();
			}
		});
		
		btnProfile.setBounds(391, 435, 391, 217);
		btnProfile.setForeground(Color.WHITE);
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnProfile.setBackground(new Color(0, 153, 153));
		btnProfile.setFont(new Font("Pristina", Font.BOLD, 50));
		btnProfile.setFocusPainted(false);
		frame.getContentPane().add(btnProfile);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(578, 1, 204, 217);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(12, 13, 180, 179);
		panel.add(imageLabel);
		
		JLabel hiLabel = new JLabel("Hi, " + LogInFrame.getUsername() + "!");
		hiLabel.setForeground(Color.WHITE);
		hiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hiLabel.setBounds(0, 199, 204, 18);
		panel.add(hiLabel);
		hiLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
		
		
		
		  try{
			  Connection conn = DBMS.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT img FROM images WHERE userid = ?");
			ps.setInt(1, getID());
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
		

		
		
		
		frame.setVisible(true);
	}
	
	
	public static int getID(){
		
		int id=-1;
		
		Connection connection = DBMS.getConnection();
		PreparedStatement st;
		
		try {
			st = connection.prepareStatement("SELECT userid FROM users WHERE username = ?");
			st.setString(1, LogInFrame.getUsername());
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
