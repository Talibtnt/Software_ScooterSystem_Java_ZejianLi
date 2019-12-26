package GUI;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Users.newUser;
import files.User;

/**
 * Title      : RegisterArea.java
 * Description: Register the interface of the new user and specific functions 
 *              such as verifying the format of the input information is incorrect.
 * @author    : Feng Yining
 * @version   : 3.0
 */
public class RegisterArea implements ActionListener,newUser{
	
	private JFrame registerFrame = new JFrame("Register");
	private JPanel[] panels = new JPanel[5];
	private JLabel message = new JLabel("Input user information correctly.");
	private JLabel QMID = new JLabel("QMID: ");
	private JLabel Name = new JLabel("Name: ");
	private JLabel Email = new JLabel("Email:");
	public JTextField QMID_field = new JTextField(20);
	public JTextField Name_field = new JTextField(20);
	public JTextField Email_field = new JTextField(20);
	private JButton registerBack = new JButton("back");
	private JButton ok = new JButton("register");
	
	public User register = new User();
	public String psw;
	/*
	 * set interface
	 */
	public void setArea() throws IOException {
	
		registerFrame.setPreferredSize(new Dimension(500,500));
		registerFrame.setLocation(400,100);
		registerFrame.getContentPane().setLayout(new GridLayout(5,1));
		message.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		
		for(int i=0;i<5;i++) {
			panels[i] = new JPanel();
			registerFrame.getContentPane().add(panels[i]);
		}
		registerBack.setPreferredSize(new Dimension(100,30));
		ok.setPreferredSize(new Dimension(100,30));
		panels[0].add(message);
		panels[1].add(QMID);
		panels[1].add(QMID_field);
		panels[2].add(Name);
		panels[2].add(Name_field);
		panels[3].add(Email);
		panels[3].add(Email_field);
		panels[4].add(registerBack);
		panels[4].add(ok);
		
		registerFrame.pack();
		registerFrame.setVisible(true);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		registerBack.addActionListener(this);	
		ok.addActionListener(this);
	}
	
	

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==registerBack) {
			registerFrame.dispose();
		}else if(event.getSource()==ok) {
			register();
		}
		
	}
	
	
	
	public static String getFixLengthString(int strLength) {
		Random rm = new Random();
		double pross = (1+rm.nextDouble())*Math.pow(10, strLength);
		String fixLenthString = String.valueOf(pross);
		return fixLenthString.substring(1, strLength+1);	
	}
	
	/*
	 * Random six-digit password
	 */
	public String setPassword() {
		psw = getFixLengthString(6);
		return psw;
	}

	/*
	 * Get basic information about user registration
	 */
	public void register() {
		setPassword();
		register.QMID = QMID_field.getText();
		register.Password = psw;
		register.Name = Name_field.getText();
		register.Email = Email_field.getText();
		register.State = "1"; 
		register.Balance = "0";
		register.Time = "0";
		File file = new File("D:/"+register.QMID+".txt");
		if(file.exists()) {
			new FeedBack().ExistAccount();
		}else {
			check();
		}
	}
	
	/*
	 * Verify that the input format is incorrect
	 */
	public void check() {
		if(QMID_field.getText().length()!=9) {
			new FeedBack().WrongQMID();
		}
		else if(!Email_field.getText().matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			new FeedBack().WrongEmail();
		}
		else {
			a.writeUserInfo(register);//Write registration information to file
			a.writeAllUsers(register.QMID);
			
			
			registerFrame.dispose();
			new FeedBack().RegisterSuccess(register.Password);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		new RegisterArea().setArea();
	}
	
}
