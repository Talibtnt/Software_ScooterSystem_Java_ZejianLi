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

import Users.newUser;

/**
 * Title      : UsageArea.java
 * Description: Read the user file to show how long the user is using the scooter for a week
 * @author    : Feng Yining
 * @version   : 3.0
 */
public class UsageArea implements ActionListener,newUser{

	public JFrame UsageFrame = new JFrame("Usage");
	private JPanel []panel = new JPanel[2];
	private JLabel name = new JLabel();
	private JLabel timeMessage = new JLabel();
	public JButton UsageBack = new JButton("back");
	/*
	 * set interface
	 */
	public void setArea(String qmid) {
		UsageFrame.getContentPane().setLayout(new GridLayout(2,1));
		UsageFrame.setPreferredSize(new Dimension(500,500));
		UsageFrame.setLocation(400,100);
		for(int i=0;i<2;i++) {
			panel[i] = new JPanel();
			UsageFrame.add(panel[i]);
		}
		panel[0].setLayout(new GridLayout(2,1));
		panel[0].add(name);
		panel[0].add(timeMessage);
		panel[1].add(UsageBack);
		
		a.QMID = qmid;
		a.readUserInfo(a);
		int time = Integer.parseInt(a.Time)/60;
		name.setText("Name: "+a.Name);
		name.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		timeMessage.setText("You have used "+time+" minutes this week.");
		timeMessage.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		
		
		UsageFrame.pack();
		UsageFrame.setVisible(true);
		UsageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UsageBack.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==UsageBack) {
			UsageFrame.dispose();
		}
		
	}
}
