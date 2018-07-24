package proelite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.*;
public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public Home() throws Exception{
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\depositphotos_63354647-stock-photo-man-without-identity-programing-in.jpg"));
		
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		lblLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
		lblLogin.setBounds(0, 0, 374, 474);
		lblLogin.setVerticalAlignment(SwingConstants.TOP);
		//label.setIcon(new ImageIcon(Home.class.getResource("C:\\Users\\Minoiu Emi\\Pictures\\x.jpg.jpg")));
		panel.add(lblLogin);
		
		username = new JTextField();
		username.setBounds(395, 121, 283, 36);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setForeground(Color.GREEN);
		lblUsername.setBounds(397, 91, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setBounds(395, 191, 116, 27);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(395, 229, 283, 36);
		contentPane.add(password);
		
		Button button = new Button("Login");
		button.setActionCommand("LogIn");
		button.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x)
         {
        	 Component frame = null;
        	 String uname = username.getText();
        	 String pass = password.getText();
        	 if(uname.equals("parsing")&&(pass.equals("emimi98")))
        	 {
        	    
				JOptionPane.showMessageDialog(frame,"You are successfully logged");
				 TypeFileSelection tsf = new TypeFileSelection();
				 tsf.setVisible(true);
        	     Home.this.setVisible(false);
        	 }
        	 else
        	 {
        		 JOptionPane.showMessageDialog(frame,"Login failed");
        	 }
         }
    	});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(395, 363, 283, 36);
		contentPane.add(button);
		
		
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\prog.jpg"));
		lblNewLabel.setBounds(347, 0, 383, 490);
		contentPane.add(lblNewLabel);
	}
}