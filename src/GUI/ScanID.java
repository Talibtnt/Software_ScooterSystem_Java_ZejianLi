package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Func.ChooseDockFun2;
import Func.ChooseDockFunc1;
import Users.newUser;

/**
 * Title      : ScanID.java
 * Description: Scan user IDs and provide options for picking up and returning.
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class ScanID implements ActionListener,newUser{

	public JFrame scanFrame = new JFrame("Scan ID");
	private JPanel []panel = new JPanel[4];
	private JButton pickUp = new JButton("pickUp");
	private JButton Return = new JButton("return");
	private JButton scanBack = new JButton("back");
	
	/*
	 * set interface
	 */
	public void setArea(String qmid) {
		a.QMID = qmid;
		a.readUserInfo(a);
		
		scanFrame.setPreferredSize(new Dimension(500,500));
		scanFrame.setLocation(400,100);
		JLabel message_scanID = new JLabel("Welcome, "+a.Name);/////////////
		message_scanID.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		scanFrame.getContentPane().setLayout(new GridLayout(4,1));
		for(int i=0;i<4;i++) {
			panel[i] = new JPanel();
			scanFrame.add(panel[i]);
		}
		pickUp.setPreferredSize(new Dimension(300,30));
		Return.setPreferredSize(new Dimension(300,30));
		panel[0].add(message_scanID);
		//panel[1].add(field);
		//panel[1].setLayout(new GridLayout(2,1));
		panel[1].add(pickUp);
		panel[2].add(Return);
		panel[3].add(scanBack);
		
		scanFrame.pack();
		scanFrame.setVisible(true);
		scanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pickUp.addActionListener(this);
		Return.addActionListener(this);
		scanBack.addActionListener(this);
		
	
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==scanBack) {
			scanFrame.dispose();
		}else if(event.getSource()==pickUp) {
			new ChooseDockFunc1().checkBalance(a.QMID);
		}else if(event.getSource()==Return) {
			new ChooseDockFun2().Return(a.QMID);
		}
		
	}
	
	public static void main(String[] args) {
		new ScanID().setArea("161196606");
	}
}
