package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import pack .LogInFrame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SynkersFrame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JFrame frame;
	//private String username = "houssam";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					SynkersFrame window = new SynkersFrame();
					SynkersFrame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SynkersFrame() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("© 2017 Synkers");		
		frame.getContentPane().setBackground(new Color(153, 153, 153));
		frame.getContentPane().setLayout(null);
		
		JLabel lblHello = new JLabel();
		lblHello.setBounds(0, 71, 782, 511);
		lblHello.setForeground(new Color(0, 0, 0));
		lblHello.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 27));
		lblHello.setIcon(new ImageIcon("images/synk1.PNG"));
		frame.getContentPane().add(lblHello);
		JButton btnLogIn = new JButton("Log in");
		
		btnLogIn.setBounds(0, 582, 782, 71);
		
		btnLogIn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				LogInFrame login_frame = new LogInFrame();
			}
		});
		
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Segoe Print", Font.BOLD, 35));
		btnLogIn.setFocusPainted(false);
		
		
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnLogIn.setBackground(new Color(0, 153, 153));
		frame.getContentPane().add(btnLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(0, 0, 782, 71);
		
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("unused")
				RegisterFrame register_frame = new RegisterFrame();
			}
		});
		
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(0, 153, 153));
		btnRegister.setFont(new Font("Segoe Print", Font.BOLD, 35));
		btnRegister.setFocusPainted(false);
		frame.getContentPane().add(btnRegister);
	        frame.setVisible(true);
		 
	}
}
