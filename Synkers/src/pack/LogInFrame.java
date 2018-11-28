package pack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;

import pack.PasswordFrame;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogInFrame {

	private JFrame frame;
	private JTextField txtUsername;
	static private String username;
	@SuppressWarnings("unused")
	private String DBMS_username = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame window = new LogInFrame();
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
	public LogInFrame() {
		initialize();
		
	}
	
	public LogInFrame(String username){
		LogInFrame.username = username;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static String getUsername(){
		return username;
	}
	
	private void initialize() {
		frame = new JFrame("Log in");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(100, 41, 217, 33);
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 username = txtUsername.getText();
					 frame.dispose();
					 @SuppressWarnings("unused")
					PasswordFrame pass_frame = new PasswordFrame();
				}
				}
			});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("               ");
		lblNewLabel.setBounds(0, 0, 444, 41);
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("      Username:    ");
		lblNewLabel_2.setBounds(-12, 40, 122, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("      ");
		label.setBounds(0, 74, 444, 41);
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(label);
		
		JButton btnNext = new JButton("      Next      ");
		btnNext.setBounds(329, 41, 105, 33);
		btnNext.addKeyListener(new KeyAdapter() {
			
		});
		
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(0, 153, 153));
		btnNext.setFocusPainted(false);
		frame.getContentPane().add(btnNext);
		frame.setVisible(true);
		
		/*  try{
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", "postgres", "houssam123");
		Statement statement =  (Statement) connection.createStatement();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM registered");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
		while (rs.next()) {
			//Print one row          
			for(int i = 1 ; i <= columnsNumber; i++){
					
			      DBMS_username = rs.getString(i); //Print one element of a row
			      System.out.println(DBMS_username);
			}

		 // System.out.println(DBMS_username);//Move to the next line to print the next row.           

			    }
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
		/*for(String i : DBMS_username){
			System.out.println(i);
		}*/
		
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 username = txtUsername.getText();
				// if(username.equals(DBMS_username)){
				  frame.dispose();
				 @SuppressWarnings("unused")
				PasswordFrame pass_frame = new PasswordFrame();
			}
		});
		
	}

}
