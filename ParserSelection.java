package proelite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.Document;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.*;

import java.awt.event.*;
	import java.awt.*;
	import java.io.*;
	import java.util.*;
public class ParserSelection extends JFrame  {
	 public MenuPage mpage;
	 public String path;
	 public static Vector<Vector> rowData = new Vector<Vector>();
	 public static Vector<String> rowOne = new Vector<String>();
	 public static Vector<Vector> data = new Vector<Vector>();
	 public static Vector<String> columns = new Vector<String>();
	 private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public ParserSelection(MenuPage page) {
		setAlwaysOnTop(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1784, 1042);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(32, 178, 170));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mpage = page;
		
		JButton btnDomparser = new JButton("DOMparser");
		btnDomparser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDomparser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				     try {
				     SAXParserFactory factory = SAXParserFactory.newInstance();
	                SAXParser saxParser = factory.newSAXParser();
	                 DefaultHandler handler;
	                 handler = new DefaultHandler() {
	                     // private List<Personne> satff;
	                	 boolean bauthor = false;
	                	 boolean btitle = false;
	                	 boolean bgenre = false;
	                	 boolean bprice = false;
	                	 boolean bpublish_date = false;
	                	 boolean bdescription = false;
	                     private int i;
 
	                     public void startElement(String uri, String localName, String
	                         qName, Attributes attributes) throws SAXException {
	                         System.out.println("Start Element :" + qName);
	                         if(qName.equalsIgnoreCase("book"))
	                         {
	                             rowOne = new Vector<String>();  
	                             String id = attributes.getValue("id");
	                         }
	                         if (qName.equalsIgnoreCase("author")) {
	                             bauthor = true;
	                         }
	                         if (qName.equalsIgnoreCase("title")) {
	                             btitle = true;
	                         }
	                         if (qName.equalsIgnoreCase("genre")) {
	                             bgenre = true;
	                         }
	                         if (qName.equalsIgnoreCase("price")) {
	                             bprice = true;
	                         }
	                         if (qName.equalsIgnoreCase("publish_date")) {
	                             bpublish_date = true;
	                         }
	                         if (qName.equalsIgnoreCase("description")) {
	                             bdescription = true;
	                         }
	                     }

	                     public void endElement(String uri, String localName,
	                         String qName) throws SAXException {
	                         System.out.println("End Element :" + qName);
	                         if ("book".equals(qName)) {
	                             rowData.addElement(rowOne);
	                         };
	                     }

	                     @Override
	                     public void characters(char ch[], int start, int length) {
	                         if (bauthor) {
	                             String s = new String(ch, start, length);
	                             rowOne.addElement(s);
	                             System.out.println("First Name : " + new String(ch, start, length));
	                             bauthor = false;
	                         }
	                         if (btitle) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Last Name : " + new String(ch, start, length));
	                             btitle = false;
	                         }
	                         if (bgenre) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Nick Name : " + new String(ch, start, length));
	                             bgenre = false;
	                         }
	                         if (bprice) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bprice = false;
	                         }
	                         if (bpublish_date) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bpublish_date = false;
	                         }
	                         if (bdescription) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bdescription = false;
	                         }
	                         System.out.println("longueur" + rowOne.size());
	                     }
	                 };
	                 path = mpage.getLinkField();
	                 System.out.println("Message!!!!!!!" +path);
	                //InputStream stream = new ByteArrayInputStream(path.getBytes(StandardCharsets.UTF_8));
	                 saxParser.parse(path, handler);
	                // saxParser.parse("C:\\Users\\Minoiu Emi\\eclipse-workspace\\parsetest.txt", handler);
	                 JFrame frame = new JFrame();
	                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                 Vector<String> columnNames = new Vector<String>();
	                 columnNames.addElement("author");
	                 columnNames.addElement("title");
	                 columnNames.addElement("genre");
	                 columnNames.addElement("price");
	                 columnNames.addElement("publish_date");
	                 columnNames.addElement("description");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 TableModel model = new DefaultTableModel(rowData, columnNames);
	                 JTable table = new JTable(rowData, columnNames);
	                 JScrollPane scrollPane = new JScrollPane(table);
	                 RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(model);
	                 table.setRowSorter(sorter);
	                 frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	                 frame.setSize(300, 150);
	                 frame.setVisible(true);
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	        	 
	        	 ParserSelection.this.setVisible(false);
	        	
	         
	    
			}
		});
		
		btnDomparser.setForeground(new Color(0, 128, 128));
		btnDomparser.setBackground(new Color(192, 192, 192));
		btnDomparser.setBounds(664, 286, 228, 59);
		contentPane.add(btnDomparser);
		
		JButton btnNewButton = new JButton("SAXparser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
	                 SAXParserFactory factory = SAXParserFactory.newInstance();
	                 SAXParser saxParser = factory.newSAXParser();
	                 DefaultHandler handler;
	                 handler = new DefaultHandler() {
	                     // private List<Personne> satff;
	                	 boolean bauthor = false;
	                	 boolean btitle = false;
	                	 boolean bgenre = false;
	                	 boolean bprice = false;
	                	 boolean bpublish_date = false;
	                	 boolean bdescription = false;
	                     private int i;

	                     public void startElement(String uri, String localName, String
	                         qName, Attributes attributes) throws SAXException {
	                         System.out.println("Start Element :" + qName);
	                         if(qName.equalsIgnoreCase("book"))
	                         {
	                             rowOne = new Vector<String>();  
	                             String id = attributes.getValue("id");
	                         }
	                         if (qName.equalsIgnoreCase("author")) {
	                             bauthor = true;
	                         }
	                         if (qName.equalsIgnoreCase("title")) {
	                             btitle = true;
	                         }
	                         if (qName.equalsIgnoreCase("genre")) {
	                             bgenre = true;
	                         }
	                         if (qName.equalsIgnoreCase("price")) {
	                             bprice = true;
	                         }
	                         if (qName.equalsIgnoreCase("publish_date")) {
	                             bpublish_date = true;
	                         }
	                         if (qName.equalsIgnoreCase("description")) {
	                             bdescription = true;
	                         }
	                     }

	                     public void endElement(String uri, String localName,
	                         String qName) throws SAXException {
	                         System.out.println("End Element :" + qName);
	                         if ("book".equals(qName)) {
	                             rowData.addElement(rowOne);
	                         };
	                     }

	                     @Override
	                     public void characters(char ch[], int start, int length) {
	                         if (bauthor) {
	                             String s = new String(ch, start, length);
	                             rowOne.addElement(s);
	                             System.out.println("First Name : " + new String(ch, start, length));
	                             bauthor = false;
	                         }
	                         if (btitle) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Last Name : " + new String(ch, start, length));
	                             btitle = false;
	                         }
	                         if (bgenre) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Nick Name : " + new String(ch, start, length));
	                             bgenre = false;
	                         }
	                         if (bprice) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bprice = false;
	                         }
	                         if (bpublish_date) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bpublish_date = false;
	                         }
	                         if (bdescription) {
	                             rowOne.addElement(new String(ch, start, length));
	                             System.out.println("Salary : " + new String(ch, start, length));
	                             //rowData.addElement(rowOne);
	                             bdescription = false;
	                         }
	                         System.out.println("longueur" + rowOne.size());
	                     }
	                 };
	                 path = mpage.getLinkField();
	                 System.out.println("Message!!!!!!!" +path);
	                //InputStream stream = new ByteArrayInputStream(path.getBytes(StandardCharsets.UTF_8));
	                 saxParser.parse(path, handler);
	                // saxParser.parse("C:\\Users\\Minoiu Emi\\eclipse-workspace\\parsetest.txt", handler);
	                 JFrame frame = new JFrame();
	                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                 Vector<String> columnNames = new Vector<String>();
	                 columnNames.addElement("author");
	                 columnNames.addElement("title");
	                 columnNames.addElement("genre");
	                 columnNames.addElement("price");
	                 columnNames.addElement("publish_date");
	                 columnNames.addElement("description");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 columnNames.addElement(" ");
	                 TableModel model = new DefaultTableModel(rowData, columnNames);
	                 JTable table = new JTable(rowData, columnNames);
	                 JScrollPane scrollPane = new JScrollPane(table);
	                 RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(model);
	                 table.setRowSorter(sorter);
	                 frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	                 frame.setSize(300, 150);
	                 frame.setVisible(true);
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	        	 
	        	 ParserSelection.this.setVisible(false);
	        	
	         
	    
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(148, 0, 211));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(664, 347, 228, 59);
		contentPane.add(btnNewButton);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFinish.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x)
         {
        	 try {
                 SAXParserFactory factory = SAXParserFactory.newInstance();
                 SAXParser saxParser = factory.newSAXParser();
                 DefaultHandler handler;
                 handler = new DefaultHandler() {
                     // private List<Personne> satff;
                	 boolean bauthor = false;
                	 boolean btitle = false;
                	 boolean bgenre = false;
                	 boolean bprice = false;
                	 boolean bpublish_date = false;
                	 boolean bdescription = false;
                     private int i;

                     public void startElement(String uri, String localName, String
                         qName, Attributes attributes) throws SAXException {
                         System.out.println("Start Element :" + qName);
                         if(qName.equalsIgnoreCase("book"))
                         {
                             rowOne = new Vector<String>();  
                             String id = attributes.getValue("id");
                         }
                         if (qName.equalsIgnoreCase("author")) {
                             bauthor = true;
                         }
                         if (qName.equalsIgnoreCase("title")) {
                             btitle = true;
                         }
                         if (qName.equalsIgnoreCase("genre")) {
                             bgenre = true;
                         }
                         if (qName.equalsIgnoreCase("price")) {
                             bprice = true;
                         }
                         if (qName.equalsIgnoreCase("publish_date")) {
                             bpublish_date = true;
                         }
                         if (qName.equalsIgnoreCase("description")) {
                             bdescription = true;
                         }
                     }

                     public void endElement(String uri, String localName,
                         String qName) throws SAXException {
                         System.out.println("End Element :" + qName);
                         if ("book".equals(qName)) {
                             rowData.addElement(rowOne);
                         };
                     }

                     @Override
                     public void characters(char ch[], int start, int length) {
                         if (bauthor) {
                             String s = new String(ch, start, length);
                             rowOne.addElement(s);
                             System.out.println("First Name : " + new String(ch, start, length));
                             bauthor = false;
                         }
                         if (btitle) {
                             rowOne.addElement(new String(ch, start, length));
                             System.out.println("Last Name : " + new String(ch, start, length));
                             btitle = false;
                         }
                         if (bgenre) {
                             rowOne.addElement(new String(ch, start, length));
                             System.out.println("Nick Name : " + new String(ch, start, length));
                             bgenre = false;
                         }
                         if (bprice) {
                             rowOne.addElement(new String(ch, start, length));
                             System.out.println("Salary : " + new String(ch, start, length));
                             //rowData.addElement(rowOne);
                             bprice = false;
                         }
                         if (bpublish_date) {
                             rowOne.addElement(new String(ch, start, length));
                             System.out.println("Salary : " + new String(ch, start, length));
                             //rowData.addElement(rowOne);
                             bpublish_date = false;
                         }
                         if (bdescription) {
                             rowOne.addElement(new String(ch, start, length));
                             System.out.println("Salary : " + new String(ch, start, length));
                             //rowData.addElement(rowOne);
                             bdescription = false;
                         }
                         System.out.println("longueur" + rowOne.size());
                     }
                 };
                 path = mpage.getLinkField();
                 System.out.println("Message!!!!!!!" +path);
                //InputStream stream = new ByteArrayInputStream(path.getBytes(StandardCharsets.UTF_8));
                 saxParser.parse(path, handler);
                // saxParser.parse("C:\\Users\\Minoiu Emi\\eclipse-workspace\\parsetest.txt", handler);
                 JFrame frame = new JFrame();
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 Vector<String> columnNames = new Vector<String>();
                 columnNames.addElement("author");
                 columnNames.addElement("title");
                 columnNames.addElement("genre");
                 columnNames.addElement("price");
                 columnNames.addElement("publish_date");
                 columnNames.addElement("description");
                 columnNames.addElement(" ");
                 columnNames.addElement(" ");
                 columnNames.addElement(" ");
                 columnNames.addElement(" ");
                 columnNames.addElement(" ");
                 columnNames.addElement(" ");
                 TableModel model = new DefaultTableModel(rowData, columnNames);
                 JTable table = new JTable(rowData, columnNames);
                 JScrollPane scrollPane = new JScrollPane(table);
                 RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(model);
                 table.setRowSorter(sorter);
                 frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
                 frame.setSize(300, 150);
                 frame.setVisible(true);
             } catch (Exception e) {
                 e.printStackTrace();
             }
        	 
        	 ParserSelection.this.setVisible(false);
        	
         }
    	});
		btnFinish.setForeground(Color.BLUE);
		btnFinish.setBackground(new Color(192, 192, 192));
		btnFinish.setBounds(890, 560, 153, 44);
		contentPane.add(btnFinish);
		
		JButton button = new JButton("<-BACK");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x)
         {
        	 mpage.setVisible(true);
        	 ParserSelection.this.setVisible(false);
        	
         }
    	});
		button.setForeground(new Color(0, 0, 255));
		button.setBackground(new Color(192, 192, 192));
		button.setBounds(510, 560, 153, 44);
		contentPane.add(button);
		
		JButton txtButton = new JButton("TXT FILE");
		txtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    path = mpage.getLinkField();
				DataFileTable dft = new  DataFileTable(path);
				dft.setVisible(true);
				
			}
		});
		txtButton.setForeground(Color.RED);
		txtButton.setFont(new Font("Tahoma", Font.ITALIC, 25));
		txtButton.setBounds(664, 409, 228, 59);
		contentPane.add(txtButton);
		
		JButton btnNewButton_2 = new JButton("SQL FILE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(664, 224, 228, 59);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("ParserSelection");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(706, 36, 374, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select one of the following parsers bellow to start parsing your file");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(523, 141, 791, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		label.setBounds(191, 11, 1844, 941);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		lblNewLabel_2.setBounds(0, 16, 201, 936);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1762, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(1678, 0, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		lblNewLabel_5.setBounds(1688, 0, 74, 986);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		lblNewLabel_6.setBounds(1599, 0, 163, 37);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(1599, 932, 69, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(1599, 932, 69, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573251.jpg"));
		label_1.setBounds(0, 932, 1779, 54);
		contentPane.add(label_1);
		
	}
}

