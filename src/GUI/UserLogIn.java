package GUI;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Users.newUser;
import files.User;

/**
 * Title      : UserLogIn.java
 * Description: The login interface for users. 
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class UserLogIn implements ActionListener,newUser{

	private JFrame UserLogInFrame = new JFrame("User Log In");
	private JPanel []panel = new JPanel[3];
	private JPanel []subpanel = new JPanel[2];
	private JLabel title = new JLabel("Login",JLabel.CENTER);
	private JLabel QMID = new JLabel("Username:",JLabel.RIGHT);
	private JLabel Password = new JLabel("Password:",JLabel.RIGHT);
	public JTextField LogInField1 = new JTextField(15);
	public JTextField LogInField2 = new JTextField(15);
	public  JButton UserLogInBack = new JButton("back");
	public  JButton UserLogInOK = new JButton("Log in");
	public String rightQMID;
	public String rightPsw;
	public String qmid;
	
	/*
	 * Set the interface of login for users.
	 */
	public void setArea() {
		UserLogInFrame.setPreferredSize(new Dimension(500,500));
		UserLogInFrame.setLocation(400,100);
		UserLogInFrame.getContentPane().setLayout(new GridLayout(3,1,20,150));
		title.setFont(new Font("ºÚÌå", Font.PLAIN, 30));
		QMID.setFont(new Font("ºÚÌå", Font.PLAIN, 15));
		Password.setFont(new Font("ºÚÌå", Font.PLAIN, 15));
		for(int i=0;i<3;i++) {
			panel[i] = new JPanel();
			UserLogInFrame.add(panel[i]);
		}
		panel[1].setLayout(new GridLayout(2,1));
		for(int i=0;i<2;i++) {
			subpanel[i] = new JPanel();	
			panel[1].add(subpanel[i]);
		}	
		panel[0].setPreferredSize(new Dimension(500,100));
		panel[1].setPreferredSize(new Dimension(300,300));
		panel[2].setPreferredSize(new Dimension(500,100));
	
		panel[0].add(title);
		subpanel[0].add(QMID,JPanel.RIGHT_ALIGNMENT);
		subpanel[0].add(LogInField1,JPanel.LEFT_ALIGNMENT);
		subpanel[1].add(Password);
		subpanel[1].add(LogInField2);
	
		panel[2].add(UserLogInBack);
		panel[2].add(UserLogInOK);
		
		UserLogInFrame.pack();
		UserLogInFrame.setVisible(true);
		UserLogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add action to the buttons
		UserLogInBack.addActionListener(this);
		UserLogInOK.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==UserLogInBack) {
			UserLogInFrame.dispose();
		}
		if(event.getSource()==UserLogInOK) {
			checkIDandPSW();//check ID number and Password
		}
	}
	
	/*
	 * Check whether the input ID exists.
	 * If ID exists then check whether the password is correct.
	 */
	void checkIDandPSW(){
		qmid = LogInField1.getText();
		a.QMID = qmid;
		File file = new File("D:/"+qmid+".txt");
		if(file.exists()) {//check the password
			a.readUserInfo(a);
			String psw = LogInField2.getText();
			if(a.Password.equals(psw)) {
				new UserMainArea().setArea(a.QMID);//user log in seccess
				UserLogInFrame.dispose();
			}else {
				new FeedBack().WrongPIN();
			}
		}else {
			new FeedBack().unExistScanID();
		}
	}
	

	
	
}
