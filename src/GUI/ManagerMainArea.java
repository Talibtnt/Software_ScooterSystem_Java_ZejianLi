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

/**
 * Title      : ManagerMainArea.java
 * Description: main interface of manager system
 * @author    : Feng Yining
 * @version   : 3.0
 */


public class ManagerMainArea implements ActionListener{

	public JFrame managerFrame = new JFrame("Management");
	private JPanel []panel = new JPanel[5];
	private JLabel management = new JLabel("Management");
	private JButton register = new JButton("Register");
	private JButton users = new JButton("Users");
	private JButton dockings = new JButton("Dockings");
	private JButton managerBack = new JButton("Exit");
	/*
	 * set interface
	 */
	public void setArea() {
		managerFrame.setPreferredSize(new Dimension(500,500));
		managerFrame.setLocation(400,100);
		managerFrame.getContentPane().setLayout(new GridLayout(5,1));
		for(int i=0;i<5;i++) {
			panel[i] = new JPanel();
			managerFrame.add(panel[i]);
		}
		management.setFont(new Font("ºÚÌå", Font.PLAIN, 30));
		register.setPreferredSize(new Dimension(200,30));
		users.setPreferredSize(new Dimension(200,30));
		dockings.setPreferredSize(new Dimension(200,30));
		panel[0].add(management);
		panel[1].add(register);
		panel[2].add(users);
		panel[3].add(dockings);
		panel[4].add(managerBack);
		
		managerFrame.pack();
		managerFrame.setVisible(true);
		managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		register.addActionListener(this);
		users.addActionListener(this);
		dockings.addActionListener(this);
		managerBack.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==managerBack) {
			managerFrame.dispose();
		}
		if(event.getSource()==register) {
			try {
				new RegisterArea().setArea();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(event.getSource()==users) {
			try {
				new ManagerUsersInfo().setArea();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(event.getSource()==dockings) {
			try {
				new ManagerDocks().setArea();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ManagerMainArea().setArea();
	}
}
