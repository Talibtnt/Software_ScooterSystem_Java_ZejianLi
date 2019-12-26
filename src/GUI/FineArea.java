package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Users.newUser;

/**
 * Title      : FineArea.java
 * Description: Fine billing interface
 * @author    : Li Zejian
 * @version   : 3.0
 */

public class FineArea implements ActionListener,newUser{

	JFrame fineFrame = new JFrame("Fine");
	JLabel title = new JLabel("Fine Bill");
	JPanel titlePanel = new JPanel();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JButton pay = new JButton("Pay the fine");
	JButton cancel = new JButton("Cancel");
	JLabel message = new JLabel("You used scooter overtime.");
	
	/*
	 * set interface
	 */
	public void setArea(String qmid) {
		a.QMID = qmid;
		File file = new File("D:/"+a.QMID+".txt");
		a.readUserInfo(a);
		fineFrame.setPreferredSize(new Dimension(500,500));
		fineFrame.setLocation(400,100);
		fineFrame.getContentPane().setLayout(new GridLayout(3,1));
		panel.setLayout(new GridLayout(4,1));
		title.setFont(new Font("黑体", Font.PLAIN, 30));
		JLabel QMID = new JLabel("QMID:"+a.QMID,JLabel.CENTER);
		JLabel Name = new JLabel("Name:"+a.Name,JLabel.CENTER);
		//JLabel Time = new JLabel("Time:"+Integer.parseInt(a.Time)/60+"min",JLabel.CENTER);
		JLabel Pay = new JLabel("You have to pay: $100",JLabel.CENTER);
		JLabel message = new JLabel("You used scooter overtime.",JLabel.CENTER);
		QMID.setFont(new Font("黑体", Font.PLAIN, 15));
		Name.setFont(new Font("黑体", Font.PLAIN, 15));
		message.setFont(new Font("黑体", Font.PLAIN, 15));
		Pay.setFont(new Font("黑体", Font.PLAIN, 15));
		pay.setPreferredSize(new Dimension(120,30));
		cancel.setPreferredSize(new Dimension(120,30));
		
		panel.add(message,BorderLayout.CENTER);
		panel.add(QMID,BorderLayout.CENTER);
		panel.add(Name);
		//panel.add(Time);
		panel.add(Pay);
		titlePanel.add(title);
		fineFrame.add(titlePanel);
		fineFrame.getContentPane().add(panel);
		fineFrame.add(panel2);
		panel2.add(pay);
		panel2.add(cancel);
		
		fineFrame.pack();  
        fineFrame.setVisible(true);  
        fineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        pay.addActionListener(this);
        cancel.addActionListener(this);
       
        
		
	}
	

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==pay) {
			a.Balance = "0";
			a.writeUserInfo(a);
			fineFrame.dispose();
			new FeedBack().payFine();
		}
		if(event.getSource()==cancel) {
			fineFrame.dispose();
		}
		
	}
	
	public static void main(String[] args) {
		new FineArea().setArea("161196606");
	}
	
	
}
