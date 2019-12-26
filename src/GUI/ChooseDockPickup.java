package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Func.ChooseDockFunc1;
import Users.newUser;
import files.Dock;
import files.User;


/**
 * Title      : ChooseDockPickup.java
 * Description: Provide three docking for users to choose
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class ChooseDockPickup implements ActionListener,newUser{
	
	public JFrame docksFrame = new JFrame("Choose a Dock");
	private JPanel[] panels = new JPanel[3];
	public JLabel messagec = new JLabel();
	public JButton A = new JButton("A");
	public JButton B = new JButton("B");
	public JButton C = new JButton("C");
	public JButton DockBack = new JButton("back");
	Dock dock = new Dock();

	/*
	 * set interface for 3 dockings
	 */
	public void setArea(String qmid) {
		
		a.QMID = qmid;
		a.readUserInfo(a);
		
		docksFrame.setPreferredSize(new Dimension(500,500));
		docksFrame.setLocation(400,100);
		docksFrame.getContentPane().setLayout(new GridLayout(3,1));
		for(int i=0;i<3;i++) {
			panels[i] = new JPanel();
			docksFrame.add(panels[i]);
		}
		messagec.setText(a.Name+",Please choose a dock.");
		messagec.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		A.setPreferredSize(new Dimension(120,100));
		B.setPreferredSize(new Dimension(120,100));
		C.setPreferredSize(new Dimension(120,100));
		panels[0].add(messagec);
		panels[1].add(A);
		panels[1].add(B);
		panels[1].add(C);
		panels[2].add(DockBack);
		
		docksFrame.pack();
		docksFrame.setVisible(true);
		docksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		A.addActionListener(this);
		B.addActionListener(this);
		C.addActionListener(this);
		DockBack.addActionListener(this);		
	}
	

	/*
	 * Actions performed when select different dockings
	 */
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==DockBack) {
			docksFrame.dispose();
		}else if(event.getSource()==A) {
			try {
				dock.dockingNum = "A";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("false")&dock.slots[1].equals("false")&dock.slots[2].equals("false")&
						dock.slots[3].equals("false")&dock.slots[4].equals("false")&dock.slots[5].equals("false")&
						dock.slots[6].equals("false")&dock.slots[7].equals("false")) {
					new FeedBack().allEmpty();
				}else {
					new ChooseDockFunc1().dockingA(a.QMID); 
				    docksFrame.dispose();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(event.getSource()==B) {
			try {
				dock.dockingNum = "B";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("false")&dock.slots[1].equals("false")&dock.slots[2].equals("false")&
						dock.slots[3].equals("false")&dock.slots[4].equals("false")&dock.slots[5].equals("false")&
						dock.slots[6].equals("false")&dock.slots[7].equals("false")) {
					new FeedBack().allEmpty();
				}else {
				    new ChooseDockFunc1().dockingB(a.QMID);
				    docksFrame.dispose();	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(event.getSource()==C) {
			try {
				dock.dockingNum = "C";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("false")&dock.slots[1].equals("false")&dock.slots[2].equals("false")&
						dock.slots[3].equals("false")&dock.slots[4].equals("false")&dock.slots[5].equals("false")&
						dock.slots[6].equals("false")&dock.slots[7].equals("false")) {
					new FeedBack().allEmpty();
				}else {
					new ChooseDockFunc1().dockingC(a.QMID);
				    docksFrame.dispose();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
