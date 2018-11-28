package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalendarFrame {

	private JFrame frame;
	private static String time = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarFrame window = new CalendarFrame();
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
	public CalendarFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 432, 62);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel month = new JLabel("NOV");
		month.setFont(new Font("Tahoma", Font.BOLD, 15));
		month.setBounds(8, 20, 38, 16);
		month.setForeground(new Color(0, 0, 0));
		panel_2.add(month);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel day_1 = new JLabel("25");
		day_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_1.setBounds(18, 7, 19, 16);
		panel_8.add(day_1);
		
		JLabel date_1 = new JLabel("SAT");
		date_1.setBounds(15, 29, 24, 16);
		panel_8.add(date_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel day_2 = new JLabel("26");
		day_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_2.setBounds(18, 7, 21, 16);
		panel_4.add(day_2);
		
		JLabel date_2 = new JLabel("SUN");
		date_2.setBounds(15, 29, 24, 16);
		panel_4.add(date_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel day_3 = new JLabel("27");
		day_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_3.setBounds(18, 7, 19, 16);
		panel_9.add(day_3);
		
		JLabel date_3 = new JLabel("MON");
		date_3.setBounds(15, 29, 30, 16);
		panel_9.add(date_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel day_4 = new JLabel("28");
		day_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_4.setBounds(18, 7, 19, 16);
		panel_6.add(day_4);
		
		JLabel date_4 = new JLabel("TUE");
		date_4.setBounds(15, 29, 24, 16);
		panel_6.add(date_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel day_5 = new JLabel("29");
		day_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_5.setBounds(18, 7, 19, 16);
		panel_7.add(day_5);
		
		JLabel date_5 = new JLabel("WED");
		date_5.setBounds(15, 29, 30, 16);
		panel_7.add(date_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel day_6 = new JLabel("30");
		day_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_6.setBounds(18, 7, 19, 16);
		panel_3.add(day_6);
		
		JLabel date_6 = new JLabel("THU");
		date_6.setBounds(15, 29, 24, 16);
		panel_3.add(date_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel day_7 = new JLabel("31");
		day_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		day_7.setBounds(18, 7, 19, 16);
		panel_5.add(day_7);
		
		JLabel date_7 = new JLabel("FRI");
		date_7.setBounds(15, 29, 24, 16);
		panel_5.add(date_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 61, 54, 392);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_90 = new JPanel();
		panel_90.setBackground(Color.WHITE);
		panel_90.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_90);
		panel_90.setLayout(null);
		
		JLabel time_1 = new JLabel("2");
		time_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_1.setHorizontalAlignment(SwingConstants.CENTER);
		time_1.setBounds(12, 10, 23, 16);
		panel_90.add(time_1);
		
		JLabel lblPm = new JLabel("pm");
		lblPm.setBounds(15, 28, 23, 16);
		panel_90.add(lblPm);
		
		JPanel panel_64 = new JPanel();
		panel_64.setBackground(Color.WHITE);
		panel_64.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_64);
		panel_64.setLayout(null);
		
		JLabel time_2 = new JLabel("3");
		time_2.setHorizontalAlignment(SwingConstants.CENTER);
		time_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_2.setBounds(12, 10, 23, 16);
		panel_64.add(time_2);
		
		JLabel label_8 = new JLabel("pm");
		label_8.setBounds(15, 28, 23, 16);
		panel_64.add(label_8);
		
		JPanel panel_63 = new JPanel();
		panel_63.setBackground(Color.WHITE);
		panel_63.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_63);
		panel_63.setLayout(null);
		
		JLabel time_3 = new JLabel("4");
		time_3.setHorizontalAlignment(SwingConstants.CENTER);
		time_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_3.setBounds(12, 10, 23, 16);
		panel_63.add(time_3);
		
		JLabel label_9 = new JLabel("pm");
		label_9.setBounds(15, 28, 23, 16);
		panel_63.add(label_9);
		
		JPanel panel_65 = new JPanel();
		panel_65.setBackground(Color.WHITE);
		panel_65.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_65);
		panel_65.setLayout(null);
		
		JLabel time_4 = new JLabel("5");
		time_4.setHorizontalAlignment(SwingConstants.CENTER);
		time_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_4.setBounds(12, 10, 23, 16);
		panel_65.add(time_4);
		
		JLabel label_10 = new JLabel("pm");
		label_10.setBounds(15, 28, 23, 16);
		panel_65.add(label_10);
		
		JPanel panel_61 = new JPanel();
		panel_61.setBackground(Color.WHITE);
		panel_61.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_61);
		panel_61.setLayout(null);
		
		JLabel time_5 = new JLabel("6");
		time_5.setHorizontalAlignment(SwingConstants.CENTER);
		time_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_5.setBounds(12, 10, 23, 16);
		panel_61.add(time_5);
		
		JLabel label_11 = new JLabel("pm");
		label_11.setBounds(15, 28, 23, 16);
		panel_61.add(label_11);
		
		JPanel panel_66 = new JPanel();
		panel_66.setBackground(Color.WHITE);
		panel_66.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_66);
		panel_66.setLayout(null);
		
		JLabel time_6 = new JLabel("7");
		time_6.setHorizontalAlignment(SwingConstants.CENTER);
		time_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_6.setBounds(12, 10, 23, 16);
		panel_66.add(time_6);
		
		JLabel label_12 = new JLabel("pm");
		label_12.setBounds(15, 28, 23, 16);
		panel_66.add(label_12);
		
		JPanel panel_62 = new JPanel();
		panel_62.setBackground(Color.WHITE);
		panel_62.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_62);
		panel_62.setLayout(null);
		
		JLabel time_7 = new JLabel("8");
		time_7.setHorizontalAlignment(SwingConstants.CENTER);
		time_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		time_7.setBounds(12, 10, 23, 16);
		panel_62.add(time_7);
		
		JLabel label_13 = new JLabel("pm");
		label_13.setBounds(15, 28, 23, 16);
		panel_62.add(label_13);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(52, 61, 380, 392);
		frame.getContentPane().add(panel_10);
		panel_10.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_10.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_10.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_10.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_10.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_10.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_10.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_10.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_10.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_10.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_10.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_10.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_10.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_10.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_10.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_10.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_10.add(panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_10.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_10.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_10.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_10.add(panel_33);
		
		JPanel panel_34 = new JPanel();
		panel_10.add(panel_34);
		
		JPanel panel_35 = new JPanel();
		panel_10.add(panel_35);
		
		JPanel panel_36 = new JPanel();
		panel_10.add(panel_36);
		
		JPanel panel_37 = new JPanel();
		panel_10.add(panel_37);
		
		JPanel panel_38 = new JPanel();
		panel_10.add(panel_38);
		
		JPanel panel_39 = new JPanel();
		panel_10.add(panel_39);
		
		JPanel panel_40 = new JPanel();
		panel_10.add(panel_40);
		
		JPanel panel_41 = new JPanel();
		panel_10.add(panel_41);
		
		JPanel panel_42 = new JPanel();
		panel_10.add(panel_42);
		
		JPanel panel_43 = new JPanel();
		panel_10.add(panel_43);
		
		JPanel panel_44 = new JPanel();
		panel_10.add(panel_44);
		
		JPanel panel_45 = new JPanel();
		panel_10.add(panel_45);
		
		JPanel panel_46 = new JPanel();
		panel_10.add(panel_46);
		
		JPanel panel_47 = new JPanel();
		panel_10.add(panel_47);
		
		JPanel panel_48 = new JPanel();
		panel_10.add(panel_48);
		
		JPanel panel_49 = new JPanel();
		panel_10.add(panel_49);
		
		JPanel panel_50 = new JPanel();
		panel_10.add(panel_50);
		
		JPanel panel_51 = new JPanel();
		panel_10.add(panel_51);
		
		JPanel panel_52 = new JPanel();
		panel_10.add(panel_52);
		
		JPanel panel_53 = new JPanel();
		panel_10.add(panel_53);
		
		JPanel panel_54 = new JPanel();
		panel_10.add(panel_54);
		
		JPanel panel_55 = new JPanel();
		panel_10.add(panel_55);
		
		JPanel panel_56 = new JPanel();
		panel_10.add(panel_56);
		
		JPanel panel_57 = new JPanel();
		panel_10.add(panel_57);
		
		JPanel panel_58 = new JPanel();
		panel_10.add(panel_58);
		
		JPanel panel_59 = new JPanel();
		panel_10.add(panel_59);
		
		
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_18.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_19.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_20.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_21.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_22.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_23.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_24.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_25.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_26.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_27.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_28.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_29.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_30.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_31.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_32.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_39.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_46.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_53.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_33.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_34.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_35.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_36.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_37.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_38.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_40.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_47.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_54.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_41.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_48.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_55.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_42.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_49.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_56.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_43.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_50.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_57.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_44.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_51.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_58.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_45.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_52.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_59.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		


		panel_11.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_11.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_11.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_12.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_12.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_12.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_13.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_13.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_13.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_14.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_14.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_14.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_15.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_15.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_15.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_16.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_16.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_16.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_17.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_17.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_17.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0);
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_1.getText()+"pm"; storeSession();}}});
		
		panel_18.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_18.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_18.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_19.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_19.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_19.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_20.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_20.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_20.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_21.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_21.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_21.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_22.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_22.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_22.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_23.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_23.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_23.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_24.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_24.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_24.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_2.getText()+"pm"; storeSession();}}});
		
		panel_25.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_25.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_25.setBackground(new Color(240, 240, 240));}
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_26.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_26.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_26.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_27.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_27.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_27.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_28.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_28.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_28.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_29.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_29.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_29.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_30.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_30.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_30.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_31.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_31.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_31.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_3.getText()+"pm"; storeSession();}}});
		
		panel_32.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_32.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_32.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_33.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_33.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_33.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_34.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_34.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_34.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_35.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_35.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_35.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_36.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_36.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_36.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_37.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_37.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_37.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
		
		panel_38.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_38.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_38.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_4.getText()+"pm"; storeSession();}}});
					
		panel_39.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_39.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_39.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
		
		panel_40.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_40.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_40.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
		
		panel_41.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_41.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_41.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
		
		panel_42.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_42.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_42.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
			
		panel_43.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_43.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_43.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
		
		panel_44.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_44.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_44.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_5.getText()+"pm"; storeSession();}}});	
		
		panel_45.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_45.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_45.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_5.getText()+"pm"; storeSession();}}});
		
		panel_46.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_46.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_46.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_47.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_47.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_47.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_48.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_48.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_48.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_49.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_49.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_49.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_50.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_50.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_50.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_51.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_51.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_51.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
		
		panel_52.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_52.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_52.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_6.getText()+"pm"; storeSession();}}});
			
		panel_53.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_53.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_53.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_1.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
		
		panel_54.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_54.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_54.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_2.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
				
		panel_55.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_55.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_55.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_3.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
		
		panel_56.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_56.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_56.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_4.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
		
		panel_57.addMouseListener(new MouseAdapter() {
		@Override public void mouseEntered(MouseEvent arg0) { panel_57.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_57.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_5.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
		
		panel_58.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_58.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_58.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_6.getText()+" "+time_7.getText()+"pm"; storeSession();}}});
		
		panel_59.addMouseListener(new MouseAdapter() { 
		@Override public void mouseEntered(MouseEvent arg0) { panel_59.setBackground(new Color(0, 153, 153));} 
		@Override public void mouseExited(MouseEvent e) { panel_59.setBackground(new Color(240, 240, 240));} 
		@Override public void mouseClicked(MouseEvent e) { int yes=JOptionPane.showConfirmDialog(frame,"Are you sure you would like to book this session?", null, 0); 
		if(yes == JOptionPane.YES_OPTION){frame.dispose(); CourseTeachersFrame.frame.dispose(); TeachersProfileFrame.frame.dispose(); ExploreFrame.frame.dispose(); time = month.getText()+" "+day_7.getText()+" "+time_7.getText()+"pm"; storeSession();}}});

		
		
		
		
		frame.setVisible(true);
		
	}
	
	public void storeSession(){
		Connection connection = DBMS.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO sessions VALUES (?, ?, ?)");
			ps.setString(1,LogInFrame.getUsername());
			ps.setString(2, TeachersProfileFrame.teacher_username);
			ps.setString(3, time);
			ps.executeUpdate();
			ps.close();
			connection.close();
			JOptionPane.showMessageDialog(null, "You have successfuly booked this session!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Warning! Please try again.");
		}
		
	}
	
}
