package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InboxFrame {

	private JFrame frame;
	Connection connection = DBMS.getConnection();
	@SuppressWarnings("unused")
	private int user_id = -1;
	private String[] emails_content = new String[]{"","","","","","","","","","","",""};
	private String[] emails_content_2= new String[]{"","","","","","","","","","","",""};
	private String[] sender_emails= new String[]{"","","","","","","","","","",""};
	private String[] sender_username = new String[]{"","","","","","","","","","",""};
	private int[] senders_id = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
	int sender_emails_index = 0;
	
	
//	private ArrayList<String> messagetest;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InboxFrame window = new InboxFrame();
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
	public InboxFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		user_id = getReceiverID();
	
	//	getSenderID(user_id);
		getEverything();
		
		for(int id : senders_id){
			getSenderEmail(id);
		}
	//	getEmailContent(user_id);
	//	for(int test : senders_id){
	//		getSenderEmail(test);
		//}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		frame = new JFrame("© 2017 Synkers - Logged in as ["+ LogInFrame.getUsername() + "] at " + dtf.format(now));
		frame.setBounds(100, 100, 700, 767);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		for(int i=0; i < 8; i++){
		if(emails_content[i].length() > 88){
			String[] tokens = emails_content[i].split("(?<=\\G.{88})");
			
			emails_content[i] = tokens[0];
			emails_content_2[i] = tokens[1];
			}
		}
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.setBounds(0, 2, 694, 35);
		lblMessages.setForeground(new Color(255, 255, 255));
		lblMessages.setBackground(new Color(0, 153, 153));
		lblMessages.setOpaque(true);
		lblMessages.setFont(new Font("Pristina", Font.BOLD, 30));
		lblMessages.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessages.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblMessages);
		JLabel lblText = new JLabel(" Account: " + LogInFrame.getUsername());
		lblText.setBounds(0, 37, 694, 35);
		lblText.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblText);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), sender_emails[0]+"  "+ sender_username[0], TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 85, 670, 68);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel first_email_content_1 = new JLabel(emails_content[0]);
		first_email_content_1.setBounds(12, 23, 623, 16);
		panel.add(first_email_content_1);
		
		JLabel first_email_content_2 = new JLabel(emails_content_2[0]);
		first_email_content_2.setBounds(12, 42, 623, 16);
		panel.add(first_email_content_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, sender_emails[1]+"  "+ sender_username[1], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 166, 670, 68);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel second_email_content_1 = new JLabel(emails_content[1]);
		second_email_content_1.setBounds(12, 23, 623, 16);
		panel_1.add(second_email_content_1);
		
		JLabel second_email_content_2 = new JLabel(emails_content_2[1]);
		second_email_content_2.setBounds(12, 39, 623, 16);
		panel_1.add(second_email_content_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, sender_emails[2]+"  "+ sender_username[2], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 247, 670, 68);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel(emails_content[2]);
		label.setBounds(12, 23, 623, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel(emails_content_2[2]);
		label_1.setBounds(12, 39, 623, 16);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, sender_emails[3]+"  "+ sender_username[3], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 328, 670, 68);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel(emails_content[3]);
		label_2.setBounds(12, 23, 623, 16);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel(emails_content_2[3]);
		label_3.setBounds(12, 39, 623, 16);
		panel_3.add(label_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, sender_emails[4]+"  "+ sender_username[4], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(12, 409, 670, 68);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel(emails_content[4]);
		label_4.setBounds(12, 23, 623, 16);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel(emails_content_2[4]);
		label_5.setBounds(12, 39, 623, 16);
		panel_4.add(label_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, sender_emails[5]+"  "+ sender_username[5], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(12, 490, 670, 68);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_6 = new JLabel(emails_content[5]);
		label_6.setBounds(12, 23, 623, 16);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel(emails_content_2[5]);
		label_7.setBounds(12, 39, 623, 16);
		panel_5.add(label_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, sender_emails[6]+"  "+ sender_username[6], TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(12, 571, 670, 68);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_8 = new JLabel(emails_content[6]);
		label_8.setBounds(12, 23, 623, 16);
		panel_6.add(label_8);
		
		JLabel label_9 = new JLabel(emails_content_2[6]);
		label_9.setBounds(12, 39, 623, 16);
		panel_6.add(label_9);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 153, 153));
		panel_7.setBounds(22, 658, 649, 61);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewMessage = new JLabel("+ New Message");
		lblNewMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewMessageFrame message = new NewMessageFrame();
			}
		});
		lblNewMessage.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewMessage.setForeground(new Color(255, 255, 255));
		lblNewMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMessage.setBounds(0, 0, 649, 61);
		panel_7.add(lblNewMessage);
		panel.repaint();
		
			
			//temp2 = tokens[1];

		/*	for(String s : tokens)
			{
		
			if(temp.length() < 30){
			   if(s.length() + temp.length() < 30 )
			   {
			     temp.concat(s);
			   }
			}
			else if(temp2.length() < 30){
				temp2.concat(s);
			}
			}*/
			

		 //"  "+ "<html> hello"+ temp + "<br>" + temp2 + "</html>");


		frame.setVisible(true);
	}

	
public int getReceiverID(){
		
		int userid=0;
		

		PreparedStatement st;
		try {		
			st = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
			st.setString(1, LogInFrame.getUsername());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				userid = rs.getInt("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
		}

	
	
	public void getSenderID(int userid){

		PreparedStatement st;
		try {
			st = connection.prepareStatement("SELECT * FROM inbox WHERE userid = ?");
			st.setInt(1, userid);
			ResultSet rs = st.executeQuery();
			int i = 0;
			while (rs.next()) {
				senders_id[i] = rs.getInt("sender");
				System.out.println(senders_id[i]);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		}

	
	
	
	public void getSenderEmail(int sender_id){
		
		try {
			PreparedStatement st;
			st = connection.prepareStatement("SELECT * FROM users WHERE userid = ?");
			st.setInt(1, sender_id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				sender_emails[sender_emails_index] = rs.getString("email");
				sender_username[sender_emails_index] = rs.getString("username");
				sender_emails_index++;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void getEmailContent(int userid){
				
		try {

			PreparedStatement st;
			st = connection.prepareStatement("SELECT message FROM inbox WHERE userid = ?");
			st.setInt(1, userid);
			System.out.println(userid);
			ResultSet rs = st.executeQuery();
			 int i=0;
			while(rs.next() && i < 8){
				emails_content[i] = rs.getString("message");
			//	System.out.println(test);
				i++;
			}

		} catch (SQLException e) {
			e.getSQLState();
			e.printStackTrace();
		}
	}
	
	
	public void getEverything(){
		
		try{
			
			PreparedStatement st;
			st = connection.prepareStatement("SELECT * FROM inbox WHERE userid = ?");
			//System.out.println(connection.getAutoCommit());
			st.setInt(1, SuccessfulLoginFrame.getID());
			ResultSet rs = st.executeQuery();
			int i =0;
			while (rs.next()) {

			       emails_content[i] = rs.getString(1);
			       senders_id[i] = rs.getInt(2);
			       i++;
					}
			
			//	sender[i] = rs.getInt("sender");
			//	userid_test[i] = rs.getInt("userid");
			
		/*	for(String what : message){
			 System.out.println(what);
			}
			for(int k : sender){
				System.out.println(k);
			}
			for(int kk : userid_test){
				System.out.println(kk);
			}*/
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
