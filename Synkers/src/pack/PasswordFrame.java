package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordFrame {

	private JFrame frame;
	private JPasswordField passwordField;
	private char[] password_array;	
	private String password_string;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFrame window = new PasswordFrame();
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
	public PasswordFrame() {
		initialize();

	}
	
	public PasswordFrame(String password){
		password = password_string;
	}

	
	public String getPassword(){
		return password_string;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame("Log in");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("               ");
		lblNewLabel.setBounds(0, 0, 444, 41);
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("      Password:    ");
		lblNewLabel_2.setBounds(-12, 40, 116, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNext = new JButton("      Next      ");
		btnNext.setBounds(332, 41, 105, 33);
		
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				password_array = passwordField.getPassword();
				password_string = new String(password_array);
				if(checkLogin()){
					frame.dispose();
					SynkersFrame.frame.dispose();
					@SuppressWarnings("unused")
					SuccessfulLoginFrame sframenew = new SuccessfulLoginFrame();
				}
				else if(!checkLogin()){
					JOptionPane.showMessageDialog(null, "Warning! Your username/password are incorrect. Please try again!");
					frame.dispose();
				}
				}});
		
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(0, 153, 153));
		btnNext.setFocusPainted(false);
		frame.getContentPane().add(btnNext);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 41, 223, 33);
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					password_array = passwordField.getPassword();
					password_string = new String(password_array);
					if(checkLogin()){
						frame.dispose();
						SynkersFrame.frame.dispose();
						@SuppressWarnings("unused")
						SuccessfulLoginFrame LoggedInFrame = new SuccessfulLoginFrame();
					}
					else if(!checkLogin()){
						JOptionPane.showMessageDialog(null, "Warning! Your username/password are incorrect. Please try again!");
						frame.dispose();
					}
					}
				}});
		
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("   ");
		label.setBounds(0, 74, 444, 41);
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(label);
		frame.setVisible(true);
		
	}
	
	
		public boolean checkLogin(){
		//	DBMS connect_dbms = new DBMS();
			String checked_username = null;
			String checked_password = null;
			
			Connection connection = null;
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/postgres", "postgres",
						"houssam123");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			PreparedStatement st;
			try {
			//	System.out.println("SELECT * FROM registered WHERE username = " + "'" +LogInFrame.getUsername() + "'" + " AND password = " + "'" + passw + "'");
		st = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
		st.setString(1, LogInFrame.getUsername());
		st.setString(2, password_string);
		ResultSet rs = st.executeQuery();
		//for(char i : password){
		
		//ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();
				
				while (rs.next()) {
					checked_username = rs.getString("username");      
					checked_password = rs.getString("password");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(checked_username != null && checked_password != null){
				return true;
			}
				

			return false;
		}
	
}
