package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewMessageFrame {

	private JFrame frame;
	private JTextField textField;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMessageFrame window = new NewMessageFrame();
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
	public NewMessageFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 334);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 461, 287);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTousername = new JLabel("To :");
		lblTousername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTousername.setForeground(new Color(255, 255, 255));
		lblTousername.setBounds(45, 39, 193, 32);
		panel.add(lblTousername);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setForeground(new Color(255, 255, 255));
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMessage.setBounds(45, 104, 140, 32);
		panel.add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(100, 37, 321, 42);
		panel.add(textField);
		textField.setColumns(10);
		

		textArea.setBounds(158, 112, 263, 103);
		panel.add(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sendMessage();
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setBackground(new Color(255, 0, 0));
		btnSend.setBounds(293, 228, 110, 46);
		panel.add(btnSend);
		
		frame.setVisible(true);
	}
	
	
	public void sendMessage(){
		Connection connection = DBMS.getConnection();
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO inbox VALUES (? , ? , ?, ?)");
			ps.setString(1, textArea.getText());
			ps.setInt(2, CourseTeachersFrame.getID(LogInFrame.getUsername()));
			ps.setInt(3, CourseTeachersFrame.getID(textField.getText()));
			ps.setString(4, dtf.format(now));
			System.out.println(textArea.getText());
			System.out.println(CourseTeachersFrame.getID(LogInFrame.getUsername()));
			System.out.println(CourseTeachersFrame.getID(textField.getText()));
			System.out.println(dtf.format(now));
			ps.executeUpdate();
			ps.close();
			connection.close();
			JOptionPane.showMessageDialog(null, "Your message has been sent!");
			frame.dispose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please make sure to enter the username of the receiver! Try again.");
		}
	}
}
