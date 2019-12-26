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

/**
 * Title      : MeanArea.java
 * Description: The main area of the whole system
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class MainArea implements ActionListener{

	public static JFrame mainArea = new JFrame("Scooter System");
	JPanel panels[] = new JPanel[3];
	JLabel title = new JLabel("Scooter System");
	public static JButton logIn = new JButton("Login");
	public static JButton management = new JButton("Management");
	
	//Set the main area of the whole system. 
	public void setArea() {
		mainArea.setPreferredSize(new Dimension(500,500));
		mainArea.setLocation(400,100);
		mainArea.getContentPane().setLayout(new GridLayout(3,1));
		for(int i=0;i<3;i++) {
			panels[i] = new JPanel();
			mainArea.add(panels[i]);
		}
		title.setFont(new Font("ºÚÌå", Font.PLAIN, 30));
		logIn.setPreferredSize(new Dimension(200,30));
		management.setPreferredSize(new Dimension(200,30));
		panels[0].add(title);
		panels[1].add(logIn);
		panels[2].add(management);
		
		mainArea.pack();
		mainArea.setVisible(true);
		mainArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logIn.addActionListener(this);	
		management.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new MainArea().setArea();
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==logIn) {
			new UserLogIn().setArea();
		}
		if(event.getSource()==management) {
			new ManagerMainArea().setArea();
		}
	}
	
	
}
