package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import files.Dock;

/**
 * Title      : ManagerDocks.java
 * Description: Read the file and display the parking status in all Dockings.
 * @author    : Feng Yining
 * @version   : 3.0
 */

public class ManagerDocks implements ActionListener {
	
	int numA = 0;
	int numB = 0;
	int numC = 0;
	
	JFrame jf = new JFrame("Docks");
	JButton back = new JButton("back");
	JPanel backPanel = new JPanel();
	
	/*
	 * set the table
	 */
	public void setArea() throws FileNotFoundException, IOException {
		
		
		
		 jf.setPreferredSize(new Dimension(500,500));
		 jf.setLocation(400,100);
	        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel(new BorderLayout());

	        Object[] columnNames = {"Docking", "Empty", "Occupied"};

	        
	        Dock a = new Dock();
	        a.dockingNum="A";
	        a.readDocking(a);
	        for(int i=0;i<8;i++) {
	        	if(a.slots[i].equals("false")){
	        		numA++;
	        	}
	        }

	        Dock b = new Dock();
	        b.dockingNum="B";
	        b.readDocking(b);
	        for(int i=0;i<8;i++) {
	        	if(b.slots[i].equals("false")){
	        		numB++;
	        	}
	        }
	        
	        Dock c = new Dock();
	        c.dockingNum="C";
	        c.readDocking(c);
	        for(int i=0;i<8;i++) {
	        	if(c.slots[i].equals("false")){
	        		numC++;
	        	}
	        }
	        // Table all row data
	        Object[][] rowData = {
	                {a.dockingNum, numA, 8-numA},
	                {b.dockingNum, numB, 8-numB},
	                {c.dockingNum, numC, 8-numC},
	          
	        };

	        // Create a table that specifies all row data and headers
	        JTable table = new JTable(rowData, columnNames);
	        panel.add(table.getTableHeader(), BorderLayout.NORTH);
	        panel.add(table, BorderLayout.CENTER);
	        panel.add(backPanel, BorderLayout.SOUTH);
	        backPanel.add(back);
	        
	        jf.setContentPane(panel);
	        jf.pack();
	        jf.setLocationRelativeTo(null);
	        jf.setVisible(true);
	        
	        back.addActionListener(this);
	
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new ManagerDocks().setArea();
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==back) {
			jf.dispose();
		}
		
	}
}
