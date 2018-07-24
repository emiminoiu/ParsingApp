package proelite;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Component;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.awt.Font;



public class Main extends JFrame  {
    private JTextField Searchtextfield;
    private JTable table;
    private JTextField Firstnametext;
    private JTextField lastnametext;
    private JTextField Phonenumbertext;
    private JTextField Emailtext;
    private JTextField Faculty;
    private JTextField Mark;

    /**
     * Instantiates a new main.
     * 
     * This program allow you to store information in a table and export out and excel file
     * or save as a text file
     *
     * @throws Exception the exception
     */
    public Main() throws Exception  {

        getContentPane().setLayout(null);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(189, 183, 107));
        tabbedPane.setBounds(0, 32, 732, 458);
        getContentPane().add(tabbedPane);
        MaskFormatter mf2 = new MaskFormatter("(###) ###-####");

        // the main panel that hold the search bar and table
        JPanel MainPanel = new JPanel(); 
        MainPanel.setBackground(Color.LIGHT_GRAY);
        tabbedPane.addTab("Main", null, MainPanel, null);
        MainPanel.setLayout(null);

        // the search text field
        Searchtextfield = new JTextField(); 
        Searchtextfield.setBounds(485, 11, 129, 20);
        MainPanel.add(Searchtextfield);
        Searchtextfield.setColumns(10);

        // the search label on the main panel
        JLabel Searchlabel = new JLabel("Seach:"); 
        Searchlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        Searchlabel.setForeground(Color.GREEN);
        Searchlabel.setBounds(396, 11, 87, 20);
        MainPanel.add(Searchlabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 42, 604, 195);
        MainPanel.add(scrollPane);

        table = new JTable();
        table.setBorder(UIManager.getBorder("DesktopIcon.border"));
        scrollPane.setViewportView(table);

        // the column in the table
        table.setModel(new DefaultTableModel(

                new Object[][] {
                	{"1","Man Utd",new Integer(2013),"21"},
                {"2","Man City",new Integer(2014),"3"},
                {"3","Chelsea",new Integer(2015),"7"},
                {"4","Arsenal",new Integer(1999),"10"},
                {"5","Liverpool",new Integer(1990),"19"},
                {"6","Everton",new Integer(1974),"1"},
            },
            new String[] {
                "First Name", "Last Name", "Phone Number", "Email","Faculty","Mark"
            }
            
        ));
  
        
        JButton btnNewButton = new JButton("Save&ExportTable");
        btnNewButton.setForeground(Color.BLUE);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(388, 302, 226, 51);
        MainPanel.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573245.jpg"));
        lblNewLabel_2.setBounds(615, 0, 112, 237);
        MainPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573260.jpg"));
        lblNewLabel_3.setBounds(0, 0, 9, 237);
        MainPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\x.jpg.jpg"));
        lblNewLabel_4.setBounds(10, 0, 597, 38);
        MainPanel.add(lblNewLabel_4);
        
        JButton btnNewButton_1 = new JButton("EditTable");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setForeground(Color.RED);
        btnNewButton_1.setBounds(65, 302, 199, 51);
        btnNewButton.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x)
         {
        	 //THE MODEL OF OUR TABLE
         }
       
             });

         
        
        MainPanel.add(btnNewButton_1);
        
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573245.jpg"));
        label_1.setBounds(0, 237, 727, 200);
        MainPanel.add(label_1);
        btnNewButton.addActionListener( new ActionListener()
    	{
         public void actionPerformed(ActionEvent x)
         {
        	 try
        	    {
        	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Minoiu Emi\\eclipse-workspace\\payrollData.txt"));
        	        PrintWriter fileWriter = new PrintWriter(bufferedWriter);

        	        for(int i = 0; i < table.getRowCount()+1; i++)
        	        {     
        	            String headers = String.valueOf(table.getColumnName(i));
        	            fileWriter.print(headers);
        	            fileWriter.print("\t");
        	        }   

        	        fileWriter.println("");
        	        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        	        for(int i=0; i<dtm.getRowCount(); ++i)
        	        {
        	            for(int j=0; j<dtm.getColumnCount(); ++j)
        	            {
        	                String s = dtm.getValueAt(i,j).toString();
        	                fileWriter.print(s);
        	                fileWriter.print("\t\t");
        	            }
        	            fileWriter.println("");
        	        }      
        	        fileWriter.close();
        	        JOptionPane.showMessageDialog(null, "Success. File saved to payrollData.txt");
        	    }catch(Exception ex)
        	    {
        	        JOptionPane.showMessageDialog(null, "Failure");
        	    }
         }
    	});


        // a panel that hold the first name, last name, phone number and email text field for entering 
        // information into the table on the main panel 
        JPanel AddentryPanel = new JPanel();
        AddentryPanel.setBackground(Color.LIGHT_GRAY);

        // add the entry tab for inputting information
        tabbedPane.addTab("Add Entry", null, AddentryPanel, null); 
        // set absolute layout
        AddentryPanel.setLayout(null);

        // a text field for entering you first name
        Firstnametext = new JTextField();

        Firstnametext.setBounds(175, 49, 308, 34);

        // add the first name text field to the add entry panel
        AddentryPanel.add(Firstnametext);
        Firstnametext.setColumns(10);

        JLabel lblNewLabel = new JLabel("First Name:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setBounds(15, 47, 147, 34);
        AddentryPanel.add(lblNewLabel);

        JLabel Lastnamelabel = new JLabel("Last Name:");
        Lastnamelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        Lastnamelabel.setForeground(Color.BLUE);
        Lastnamelabel.setBounds(15, 99, 147, 29);
        AddentryPanel.add(Lastnamelabel);

        // a text field for entering you last name
        lastnametext = new JTextField();
        lastnametext.setColumns(10);
        lastnametext.setBounds(175, 94, 308, 34);

        // add the last name to the entry panel
        AddentryPanel.add(lastnametext);

        // add a formatted text field for you phone number. This field only allow number.
        Phonenumbertext = new JFormattedTextField(mf2);
        Phonenumbertext.setColumns(10);
        Phonenumbertext.setBounds(175, 145, 308, 34);

        // add the formatted text field  to entry panel
        AddentryPanel.add(Phonenumbertext);

        // a text field for entering you email 
        Emailtext = new JTextField();
        Emailtext.setColumns(10);
        Emailtext.setBounds(175, 190, 308, 34);

        // add the email text field to the add entry panel
        AddentryPanel.add(Emailtext);

        JLabel Phonenumberlabel = new JLabel("Phone Number:");
        Phonenumberlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        Phonenumberlabel.setForeground(Color.BLUE);
        Phonenumberlabel.setBounds(15, 143, 160, 35);
        AddentryPanel.add(Phonenumberlabel);

        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Tahoma", Font.BOLD, 20));
        Email.setForeground(Color.BLUE);
        Email.setBounds(15, 188, 180, 34);
        AddentryPanel.add(Email);
        
        JLabel lblFaculty = new JLabel("Faculty:");
        lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblFaculty.setForeground(Color.GREEN);
        lblFaculty.setBounds(15, 228, 104, 42);
        AddentryPanel.add(lblFaculty);
        
        Faculty = new JTextField();
        Faculty.setBounds(175, 234, 308, 34);
        AddentryPanel.add(Faculty);
        Faculty.setColumns(10);
        
        JLabel mark = new JLabel("Mark:");
        mark.setForeground(Color.GREEN);
        mark.setFont(new Font("Tahoma", Font.BOLD, 20));
        mark.setBounds(15, 278, 92, 34);
        AddentryPanel.add(mark);
        
        Mark = new JTextField();
        Mark.setBounds(175, 284, 308, 34);
        AddentryPanel.add(Mark);
        Mark.setColumns(10);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Minoiu Emi\\Pictures\\wallpaper2you_573260.jpg"));
        label.setBounds(-70, 16, 727, 424);
        AddentryPanel.add(label);
        
        // a button that add information into the table from the first name, last name, email
        // and you phone number field.
        JButton AddEntrybutton = new JButton("Add");
        AddEntrybutton.setFont(new Font("Tahoma", Font.BOLD, 20));

        AddEntrybutton.setForeground(Color.RED);

        // add a action listener for add entry button
        AddEntrybutton.addActionListener(new ActionListener() {
            /*
             * This action listener for entry button will prompt
             * you, if you want to add information into the table.
             * It also check if all the mandatory field have been filled correctly
             * so that it can proceed with the adding. If field has a error it will 
             * display a error.
             */

            public void actionPerformed(ActionEvent e) {

            // check if the option field are filled and correct before adding.
                if(Firstnametext.getText().equalsIgnoreCase("")|| Phonenumbertext.getText().equalsIgnoreCase("(   )    -    ")){
                    JOptionPane.showMessageDialog (null, "Make sure the the First Name and Phone Number field are filled"); 
                }

                // prompt if you are sure you want to add these information into the table
                else if (JOptionPane.showConfirmDialog(null, "Would you like to add these field to table?", "Request", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                        == JOptionPane.YES_OPTION)
                    {
                    
                    DefaultTableModel dtm = (DefaultTableModel)table.getModel();
                    RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(dtm);
                    table.setRowSorter(sorter);
                    dtm.addRow(new Object[] { Firstnametext.getText(), lastnametext.getText(), Phonenumbertext.getText(), Emailtext.getText(),Faculty.getText(),Mark.getText()});

                    
                    
                    }
                


            }
        });
        AddEntrybutton.setBounds(130, 340, 122, 42);

        // add the add button to the entry panel 
        AddentryPanel.add(AddEntrybutton);
        
        // a button the is use for clearing the field in the add entry panel
        JButton ClearButton = new JButton("Clear");
        ClearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        ClearButton.setForeground(Color.RED);
        ClearButton.addActionListener(new ActionListener() {
            /*
             *  prompt you if you want to clear the first name,
             *  last name, phone number and email text field.
             *  if you select yes the field will be clear.
             *  if you select no the field will not be clear.
             */

            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the field?", "Request", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                        == JOptionPane.YES_OPTION)
                    {
                     Firstnametext.setText("");
                     lastnametext.setText("");
                     Phonenumbertext.setText("");
                     Emailtext.setText("");
                     Faculty.setText("");
                     Mark.setText("");
                    }
                    else
                    {
                     //Go back to normal
                    }

            }
        });
        ClearButton.setBounds(420, 340, 127, 42);

        // add the clear button the entry panel
        AddentryPanel.add(ClearButton);
        
        
        JLabel lblFillWithStudentss = new JLabel("Fill with Students's data");
        lblFillWithStudentss.setBounds(175, 13, 69, 20);
        AddentryPanel.add(lblFillWithStudentss);

        // a menu bar for displaying the option to load contact, save contact, 
        // export contact as excel file and be able to close option
        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(Color.GREEN);
        menuBar.setBounds(0, 0, 650, 21);
        getContentPane().add(menuBar);


        JMenu fileoption = new JMenu("StudentRecordsApp");
        fileoption.setForeground(Color.BLUE);

        menuBar.add(fileoption);


        JMenuItem loadcontact = new JMenuItem("Load Contact");

        // add load contact file to menu
        fileoption.add(loadcontact);

        JMenuItem savecontact = new JMenuItem("Save Contact");

        // add a save contact file to menu
        fileoption.add(savecontact);

        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {

            /*
             * When selected the program will close.
             * 
             */
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        fileoption.add(close);
        table.getColumnModel().getColumn(2).setPreferredWidth(124);
        class ButtonRenderer extends JButton implements  TableCellRenderer
        {

          //CONSTRUCTOR
          public ButtonRenderer() {
            //SET BUTTON PROPERTIES
            setOpaque(true);
          }
          @Override
          public Component getTableCellRendererComponent(JTable table, Object obj,
              boolean selected, boolean focused, int row, int col) {

            //SET PASSED OBJECT AS BUTTON TEXT
              setText((obj==null) ? "":obj.toString());

            return this;
          }

        }
        class ButtonEditor extends DefaultCellEditor
        {
          protected JButton btn;
           private String lbl;
           private Boolean clicked;

           public ButtonEditor(JTextField txt) {
            super(txt);

            btn=new JButton();
            btn.setOpaque(true);

            //WHEN BUTTON IS CLICKED
            btn.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
              }
            });
          }

           //OVERRIDE A COUPLE OF METHODS
           @Override
          public Component getTableCellEditorComponent(JTable table, Object obj,
              boolean selected, int row, int col) {

              //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
             lbl=(obj==null) ? "":obj.toString();
             btn.setText(lbl);
             clicked=true;
            return btn;
          }

          //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
           @Override
          public Object getCellEditorValue() {

             if(clicked)
              {
              //SHOW US SOME MESSAGE
                JOptionPane.showMessageDialog(btn, lbl+" Clicked");
              }
            //SET IT TO FALSE NOW THAT ITS CLICKED
            clicked=false;
            return new String(lbl);
          }

           @Override
          public boolean stopCellEditing() {

                 //SET CLICKED TO FALSE FIRST
              clicked=false;
            return super.stopCellEditing();
          }

           @Override
          protected void fireEditingStopped() {
            // TODO Auto-generated method stub
            super.fireEditingStopped();
          }
        }
    



     /*  Main frame = new Main();
        frame.setTitle("StudentsDataBaseApp by Emi Minoiu");
        frame.setSize(640, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       */
    }
}