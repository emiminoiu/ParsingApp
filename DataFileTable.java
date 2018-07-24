package proelite;


	import javax.swing.*;

import java.awt.event.*;
	import java.awt.*;
	import java.io.*;
	import java.util.*;

	public class DataFileTable extends JPanel {
		 public Dimension getPreferredSize(){
			    return new Dimension(400, 300);
			    }
			    
	  public DataFileTable(String dataFilePath) {
	    JTable table;
	    DataFileTableModel model;
	    Font f;

	    f = new Font("SanSerif",Font.PLAIN,24);
	    setFont(f);
	    setLayout(new BorderLayout());

	    model = new DataFileTableModel(dataFilePath);

	    table = new JTable();
	    table.setModel(model);
	    table.createDefaultColumnsFromModel();

	    JScrollPane scrollpane = new JScrollPane(table);
	    add(scrollpane);
	    

	

	
	 JFrame frame = new JFrame("Data File Table");
	
	  DataFileTable panel = this;
	        
	   //panel = new DataFileTable("C:\\Users\\Minoiu Emi\\eclipse-workspace\\txttest.txt");

	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.setForeground(Color.black);
	    frame.setBackground(Color.lightGray);
	    frame.getContentPane().add(panel,"Center");
	        
	    frame.setSize(panel.getPreferredSize());
	    frame.setVisible(true);
	    frame.addWindowListener(new WindowCloser());
	   
	    }
	 

	class WindowCloser extends WindowAdapter {
	 public void windowClosing(WindowEvent e) {
	   Window win = e.getWindow();
	   win.setVisible(false);
	   System.exit(0);
	    }
	}
	}
