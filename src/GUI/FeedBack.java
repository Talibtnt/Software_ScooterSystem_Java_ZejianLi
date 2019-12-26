package GUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Title      : FeedBack.java
 * Description: All feedback windows
 * @author    : Feng Yining
 * @version   : 3.0
 */

public class FeedBack implements ActionListener{
	
	
	 //Register related feedback
	
	/*
	 * Register successfully
	 */
	JFrame register_Success_frame = new JFrame();
	JPanel register_Success_panel1 = new JPanel();
	JPanel register_Success_panel2 = new JPanel();
	JButton register_Success_ok = new JButton("ok");
	public void RegisterSuccess(String a) {
		
		register_Success_frame.setLocation(500,300);
		JLabel register_Success_label1 = new JLabel("Register success!");
		JLabel register_Success_label2 = new JLabel("Your password is:"+a);
		register_Success_frame.getContentPane().setLayout(new GridLayout(2,1));
		register_Success_panel1.setLayout(new GridLayout(2,1));
		register_Success_frame.add(register_Success_panel1);
		register_Success_frame.add(register_Success_panel2);
		register_Success_panel1.add(register_Success_label1);
		register_Success_panel1.add(register_Success_label2);
		register_Success_panel2.add(register_Success_ok);
		
		register_Success_frame.pack();
		register_Success_frame.setVisible(true);
		register_Success_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		register_Success_ok.addActionListener(this);
		
	}
	
	/*
	 * Account already exists.
	 */
	JFrame existID_frame = new JFrame();
	JPanel existID_panel1 = new JPanel();
	JPanel existID_panel2 = new JPanel();
	JLabel existID_label = new JLabel("Account exists!");
	JButton existID_ok = new JButton("ok");
	public void ExistAccount() {
		
		existID_frame.setLocation(500,300);
		existID_frame.getContentPane().setLayout(new GridLayout(2,1));
		existID_frame.add(existID_panel1);
		existID_frame.add(existID_panel2);
		existID_panel1.add(existID_label);
		existID_panel2.add(existID_ok);
		
		existID_frame.pack();
		existID_frame.setVisible(true);
		existID_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		existID_ok.addActionListener(this);
		
	}
	
	
	/*
	 * Incorrect QMID format
	 */
	JFrame wrongID_frame = new JFrame();
	JPanel wrongID_panel1 = new JPanel();
	JPanel wrongID_panel2 = new JPanel();
	JLabel wrongID_label = new JLabel("Wrong QMID!");
	JButton wrongID_ok = new JButton("ok");
	public void WrongQMID() {
		
		wrongID_frame.setLocation(500,300);
		wrongID_frame.getContentPane().setLayout(new GridLayout(2,1));
		wrongID_frame.add(wrongID_panel1);
		wrongID_frame.add(wrongID_panel2);
		wrongID_panel1.add(wrongID_label);
		wrongID_panel2.add(wrongID_ok);
		
		wrongID_frame.pack();
		wrongID_frame.setVisible(true);
		wrongID_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wrongID_ok.addActionListener(this);
		
	}
	
	/*
	 * Incorrect email format
	 */
	JFrame wrongEmail_frame = new JFrame();
	JPanel wrongEmail_panel1 = new JPanel();
	JPanel wrongEmail_panel2 = new JPanel();
	JLabel wrongEmail_label = new JLabel("Wrong Email!");
	JButton wrongEmail_ok = new JButton("ok");
	public void WrongEmail() {
		
		wrongEmail_frame.setLocation(500,300);
		wrongEmail_frame.getContentPane().setLayout(new GridLayout(2,1));
		wrongEmail_frame.add(wrongEmail_panel1);
		wrongEmail_frame.add(wrongEmail_panel2);
		wrongEmail_panel1.add(wrongEmail_label);
		wrongEmail_panel2.add(wrongEmail_ok);
		
		wrongEmail_frame.pack();
		wrongEmail_frame.setVisible(true);
		wrongEmail_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wrongEmail_ok.addActionListener(this);
		
	}
	
	
	//login feedback
	
	/*
	 * wrong password
	 */
	JFrame wrongPIN_frame = new JFrame();
	JPanel wrongPIN_panel1 = new JPanel();
	JPanel wrongPIN_panel2 = new JPanel();
	JLabel wrongPIN_label = new JLabel("Wrong Password!");
	JButton wrongPIN_ok = new JButton("ok");
	public void WrongPIN() {
		
		wrongPIN_frame.setLocation(500,300);
		wrongPIN_frame.getContentPane().setLayout(new GridLayout(2,1));
		wrongPIN_frame.add(wrongPIN_panel1);
		wrongPIN_frame.add(wrongPIN_panel2);
		wrongPIN_panel1.add(wrongPIN_label);
		wrongPIN_panel2.add(wrongPIN_ok);
		
		wrongPIN_frame.pack();
		wrongPIN_frame.setVisible(true);
		wrongPIN_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wrongPIN_ok.addActionListener(this);
		
	}
	
	
	/*
	 * The entered ID does not exist
	 */
	JFrame unexistID_frame = new JFrame();
	JPanel unexistID_panel1 = new JPanel();
	JPanel unexistID_panel2 = new JPanel();
	JLabel unexistID_label = new JLabel("Your ID does not exist!");
	JButton unexistID_ok = new JButton("ok");
	public void unExistScanID() {
		
		unexistID_frame.setLocation(500,300);
		unexistID_frame.getContentPane().setLayout(new GridLayout(2,1));
		unexistID_frame.add(unexistID_panel1);
		unexistID_frame.add(unexistID_panel2);
		unexistID_panel1.add(unexistID_label);
		unexistID_panel2.add(unexistID_ok);
		
		unexistID_frame.pack();
		unexistID_frame.setVisible(true);
		unexistID_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		unexistID_ok.addActionListener(this);
		
	}
	

	
	/*
	 * remind return first
	 */
	JFrame remind_return_frame = new JFrame();
	JPanel remind_return_panel1 = new JPanel();
	JPanel remind_return_panel2 = new JPanel();
	JLabel remind_return_label = new JLabel("Please return your scooter first!");
	JButton remind_return_ok = new JButton("ok");
	public void remindReturn() {
		
		remind_return_frame.setLocation(500,300);
		remind_return_frame.getContentPane().setLayout(new GridLayout(2,1));
		remind_return_frame.add(remind_return_panel1);
		remind_return_frame.add(remind_return_panel2);
		remind_return_panel1.add(remind_return_label);
		remind_return_panel2.add(remind_return_ok);
		
		remind_return_frame.pack();
		remind_return_frame.setVisible(true);
		remind_return_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		remind_return_ok.addActionListener(this);
		
	}
	
	/*
	 * remind pick up first
	 */
	JFrame remind_pickup_frame = new JFrame();
	JPanel remind_pickup_panel1 = new JPanel();
	JPanel remind_pickup_panel2 = new JPanel();
	JLabel remind_pickup_label = new JLabel("Please pick up a scooter first!");
	JButton remind_pickup_ok = new JButton("ok");
	public void remindPickUp() {
		
		remind_pickup_frame.setLocation(500,300);
		remind_pickup_frame.getContentPane().setLayout(new GridLayout(2,1));
		remind_pickup_frame.add(remind_pickup_panel1);
		remind_pickup_frame.add(remind_pickup_panel2);
		remind_pickup_panel1.add(remind_pickup_label);
		remind_pickup_panel2.add(remind_pickup_ok);
		
		remind_pickup_frame.pack();
		remind_pickup_frame.setVisible(true);
		remind_pickup_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		remind_pickup_ok.addActionListener(this);
		
	}
	/*
	 * dock empty or full
	 */
	JFrame docke_frame = new JFrame();
	JPanel docke_panel1 = new JPanel();
	JPanel docke_panel2 = new JPanel();
	JLabel docke_label = new JLabel("There is no scooter, please choose another dock");
	JButton docke_ok = new JButton("ok");
	public void dockempty() {
		
		docke_frame.setLocation(500,300);
		docke_frame.getContentPane().setLayout(new GridLayout(2,1));
		docke_frame.add(docke_panel1);
		docke_frame.add(docke_panel2);
		docke_panel1.add(docke_label);
		docke_panel2.add(docke_ok);
		
		docke_frame.pack();
		docke_frame.setVisible(true);
		docke_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		docke_ok.addActionListener(this);
		
	}
	JFrame dockf_frame = new JFrame();
	JPanel dockf_panel1 = new JPanel();
	JPanel dockf_panel2 = new JPanel();
	JLabel dockf_label = new JLabel("Parking is full, please choose another dock");
	JButton dockf_ok = new JButton("ok");
	public void dockfull() {
		
		dockf_frame.setLocation(500,300);
		dockf_frame.getContentPane().setLayout(new GridLayout(2,1));
		dockf_frame.add(dockf_panel1);
		dockf_frame.add(dockf_panel2);
		dockf_panel1.add(dockf_label);
		dockf_panel2.add(dockf_ok);
		
		dockf_frame.pack();
		dockf_frame.setVisible(true);
		dockf_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dockf_ok.addActionListener(this);
		
	}
	
	/*
	 * Don not need to pay fine
	 */
	JFrame noFine_frame = new JFrame();
	JPanel noFine_panel1 = new JPanel();
	JPanel noFine_panel2 = new JPanel();
	JLabel noFine_label = new JLabel("You need not pay fine.");
	JButton noFine_ok = new JButton("ok");
	public void noFine() {
		
		noFine_frame.setLocation(500,300);
		noFine_frame.getContentPane().setLayout(new GridLayout(2,1));
		noFine_frame.add(noFine_panel1);
		noFine_frame.add(noFine_panel2);
		noFine_panel1.add(noFine_label);
		noFine_panel2.add(noFine_ok);
		
		noFine_frame.pack();
		noFine_frame.setVisible(true);
		noFine_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		noFine_ok.addActionListener(this);
		
	}
	
	/*
	 * manager send message to user
	 */
	JFrame send_frame = new JFrame();
	JPanel send_panel1 = new JPanel();
	JPanel send_panel2 = new JPanel();
	JLabel send_label = new JLabel("Usage is sent to users seccessfully!");
	JButton send_ok = new JButton("ok");
	public void sendSuccess() {
		
		send_frame.setLocation(500,300);
		send_frame.getContentPane().setLayout(new GridLayout(2,1));
		send_frame.add(send_panel1);
		send_frame.add(send_panel2);
		send_panel1.add(send_label);
		send_panel2.add(send_ok);
		
		send_frame.pack();
		send_frame.setVisible(true);
		send_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		send_ok.addActionListener(this);
		
	}
	
	/*
	 * all slots are occupied
	 */
	JFrame occupied_frame = new JFrame();
	JPanel occupied_panel1 = new JPanel();
	JPanel occupied_panel2 = new JPanel();
	JLabel occupied_label = new JLabel("All slots are occupied,please change dock.");
	JButton occupied_ok = new JButton("ok");
	public void allOccupied() {
		
		occupied_frame.setLocation(500,300);
		occupied_frame.getContentPane().setLayout(new GridLayout(2,1));
		occupied_frame.add(occupied_panel1);
		occupied_frame.add(occupied_panel2);
		occupied_panel1.add(occupied_label);
		occupied_panel2.add(occupied_ok);
		
		occupied_frame.pack();
		occupied_frame.setVisible(true);
		occupied_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		occupied_ok.addActionListener(this);
		
	}
	
	/*
	 * all slots are empty
	 */
	JFrame empty_frame = new JFrame();
	JPanel empty_panel1 = new JPanel();
	JPanel empty_panel2 = new JPanel();
	JLabel empty_label = new JLabel("All slots are empty,please change dock.");
	JButton empty_ok = new JButton("ok");
	public void allEmpty() {
		
		empty_frame.setLocation(500,300);
		empty_frame.getContentPane().setLayout(new GridLayout(2,1));
		empty_frame.add(empty_panel1);
		empty_frame.add(empty_panel2);
		empty_panel1.add(empty_label);
		empty_panel2.add(empty_ok);
		
		empty_frame.pack();
		empty_frame.setVisible(true);
		empty_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		empty_ok.addActionListener(this);
		
	}
	
	/*
	 * pay the fine successfully
	 */
	JFrame fine_frame = new JFrame();
	JPanel fine_panel1 = new JPanel();
	JPanel fine_panel2 = new JPanel();
	JLabel fine_label = new JLabel("You have pay the fine successfully.");
	JButton fine_ok = new JButton("ok");
	public void payFine() {
		
		fine_frame.setLocation(500,300);
		fine_frame.getContentPane().setLayout(new GridLayout(2,1));
		fine_frame.add(fine_panel1);
		fine_frame.add(fine_panel2);
		fine_panel1.add(fine_label);
		fine_panel2.add(fine_ok);
		
		fine_frame.pack();
		fine_frame.setVisible(true);
		fine_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fine_ok.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==register_Success_ok) {
			register_Success_frame.dispose();
		}
		if(event.getSource()==existID_ok) {
			existID_frame.dispose();
		}
		if(event.getSource()==wrongID_ok) {
			wrongID_frame.dispose();
		}
		if(event.getSource()==wrongEmail_ok) {
			wrongEmail_frame.dispose();
		}
		if(event.getSource()==unexistID_ok) {
			unexistID_frame.dispose();
		}
		if(event.getSource()==wrongPIN_ok) {
			wrongPIN_frame.dispose();
		}
		if(event.getSource()==remind_return_ok) {
			remind_return_frame.dispose();
		}
		if(event.getSource()==remind_pickup_ok) {
			remind_pickup_frame.dispose();
		}
		if(event.getSource()==docke_ok) {
			docke_frame.dispose();
		}
		if(event.getSource()==dockf_ok) {
			dockf_frame.dispose();
		}
		if(event.getSource()==noFine_ok) {
			noFine_frame.dispose();
		}
		if(event.getSource()==send_ok) {
			send_frame.dispose();
		}
		if(event.getSource()==occupied_ok) {
			occupied_frame.dispose();
		}
		if(event.getSource()==empty_ok) {
			empty_frame.dispose();
		}
		if(event.getSource()==fine_ok) {
			fine_frame.dispose();
		}
	}
	
	
}
