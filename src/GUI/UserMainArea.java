package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Users.newUser;
import files.User;

/**
 * Title      : UserMainArea.java
 * Description: The main area of the user system
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class UserMainArea implements ActionListener,newUser{

	private JFrame LogInSuccessFrame = new JFrame("User");
	private JPanel []panel = new JPanel[5];
	//private JLabel title = new JLabel("");
	private JButton ScanID = new JButton("ScanID");
	private JButton Fine = new JButton("Fine");
	private JButton Usage = new JButton("Usage");
	private JButton LogInSuccessBack = new JButton("Exit");
	
	String Name;
	
	/*
	 * Set interface of user main area.
	 */
	public void setArea(String qmid) {
	
		File file = new File("D:/"+qmid+".txt");
		a.QMID = qmid;
		a.readUserInfo(a);
		LogInSuccessFrame.setPreferredSize(new Dimension(500,500));
		LogInSuccessFrame.setLocation(400,100);
		
		JLabel title = new JLabel("Welcome, " + a.Name);
		title.setFont(new Font("黑体", Font.PLAIN, 20));
		LogInSuccessFrame.getContentPane().setLayout(new GridLayout(5,1));
		
		for(int i=0;i<5;i++) {
			panel[i] = new JPanel();
			LogInSuccessFrame.add(panel[i]);
		}
		ScanID.setPreferredSize(new Dimension(200,30));
		Fine.setPreferredSize(new Dimension(200,30));
		Usage.setPreferredSize(new Dimension(200,30));
	
		panel[0].add(title);
		panel[1].add(ScanID);
		panel[2].add(Fine);
		panel[3].add(Usage);
		panel[4].add(LogInSuccessBack);
		
		LogInSuccessFrame.pack();
		LogInSuccessFrame.setVisible(true);
		LogInSuccessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加事件
		LogInSuccessBack.addActionListener(this);
		ScanID.addActionListener(this);
		Fine.addActionListener(this);
		Usage.addActionListener(this);
	
	}

	/*
	 * Confirm twice to log out
	 */
	JFrame logout_frame = new JFrame();
	JPanel logout_panel1 = new JPanel();
	JPanel logout_panel2 = new JPanel();
	JLabel logout_label = new JLabel("Are you sure to logout?");
	JButton logout_yes = new JButton("yes");
	JButton logout_no = new JButton("no");
	public void logout() {
		
		logout_frame.setLocation(500,300);
		logout_frame.getContentPane().setLayout(new GridLayout(2,1));
		logout_frame.add(logout_panel1);
		logout_frame.add(logout_panel2);
		logout_panel1.add(logout_label);
		logout_panel2.add(logout_yes);
		logout_panel2.add(logout_no);
		
		logout_frame.pack();
		logout_frame.setVisible(true);
		logout_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logout_yes.addActionListener(this);
		logout_no.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==LogInSuccessBack) {
			logout();
			}
		if(event.getSource()==ScanID) {
			new ScanID().setArea(a.QMID);
		}
		if(event.getSource()==Usage) {
			new UsageArea().setArea(a.QMID);
		}
		if(event.getSource()==Fine) {
			if(a.Balance.equals("1")) {
				new FineArea().setArea(a.QMID);
			}else {
				new FeedBack().noFine();
			}
			
		}
		if(event.getSource()==logout_yes) {
			logout_frame.dispose();
			LogInSuccessFrame.dispose();
		}
		if(event.getSource()==logout_no) {
			logout_frame.dispose();
		}
			
			
		
	}
	public static void main(String[] args) {
		//new UserMainArea().setArea("161196606");
	}
}
