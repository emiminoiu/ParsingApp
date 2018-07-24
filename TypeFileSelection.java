package proelite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TypeFileSelection extends JFrame {
    public static MenuPage mpage;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeFileSelection frame = new TypeFileSelection();
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
	public TypeFileSelection() {
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("StudentRecordsApp");
		btnNewButton_1.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x) 
         {
        
        	     try {
        		 Main m = new Main();
        		 m.setVisible(true);
        	
        	 TypeFileSelection.this.setVisible(false);
         }catch (Exception e) {
             e.printStackTrace();
         }}
    	});
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(0, 0, 228, 267);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ParsingApp");
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MenuPage mpage = new MenuPage();
	        	 mpage.setVisible(true);
	        	 TypeFileSelection.this.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(220, 0, 222, 267);
		contentPane.add(btnNewButton_2);
	
		
		ImageIcon image = new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\3091347-computer-programing-source-code-on-blue-electronics-background.jpg\"");
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(image);
	
	}
}
