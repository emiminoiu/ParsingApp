package proelite;
import java.awt.BorderLayout;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class DomParsing extends AbstractTableModel {
	public static Vector<Vector> data = new Vector<Vector>();
    public static Vector<String> columns = new Vector<String>();

	public {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("C:\\Users\\Minoiu Emi\\eclipse-workspace\\parsetest.txt");

			NodeList nl = doc.getElementsByTagName("Name");
			NodeList n2 = doc.getElementsByTagName("Address");
			NodeList n3 = doc.getElementsByTagName("ContactNo");
			NodeList listOfPersons = doc.getElementsByTagName("person");
			
			String data1 = "", data2 = "", data3 = "";
			
			for (int i = 0; i < listOfPersons.getLength(); i++) {
				data1 = nl.item(i).getFirstChild().getNodeValue();
				data2 = n2.item(i).getFirstChild().getNodeValue();
				data3 = n3.item(i).getFirstChild().getNodeValue();
				String line = data1 + " " + data2 + " " + data3;
				StringTokenizer st2 = new StringTokenizer(line, " ");
			//	while (st2.hasMoreTokens())
					//data.addElement(st2.nextToken());
			}
			columns.add("");
			columns.add("");
			columns.add("");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return data.size() / getColumnCount();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.elementAt((rowIndex * getColumnCount())
				+ columnIndex);
	}

	public static void main(String argv[]) throws Exception {
		  JFrame frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  Vector<String> columns = new Vector<String>();
          columns.addElement("author");
          columns.addElement("title");
          columns.addElement("genre");
          columns.addElement("price");
          columns.addElement("publish_date");
          columns.addElement("description");
          columns.addElement(" ");
          columns.addElement(" ");
          columns.addElement(" ");
          columns.addElement(" ");
          columns.addElement(" ");
          columns.addElement(" ");
          TableModel model = new DefaultTableModel(data, columns);
         
          JTable table = new JTable(data, columns);
          JScrollPane scrollPane = new JScrollPane(table);
          RowSorter<TableModel> sorter =  new TableRowSorter<TableModel>(model);
          table.setRowSorter(sorter);
          frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
          frame.setSize(300, 150);
          frame.setVisible(true);
		DomParsing t = new DomParsing();
	
		table.setModel(t);
		JScrollPane scrollpane = new JScrollPane(table);
		JPanel panel = new JPanel();
		panel.add(scrollpane);
		
		
		frame.setVisible(true);
	}
}