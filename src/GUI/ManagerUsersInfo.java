package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import files.User;

/**
 * Title      : ManagerUsersInfo.java
 * Description: Read and display all registered user information on the interface.
 * @author    : Liu Yucheng
 * @version   : 3.0
 */

public class ManagerUsersInfo implements ActionListener{

	JButton back = new JButton("back");
	JButton send = new JButton("Send Message to users");
	JFrame jf = new JFrame("Users");
	JPanel backPanel = new JPanel();
	JPanel InfoPanel = new JPanel();
	JPanel pback = new JPanel();
	JPanel psend = new JPanel();
	private JScrollPane jsp = new JScrollPane();
	int i=0;
	String userInfo="";
	String q,m;

	/*
	 * set interface
	 */
	public void setArea() throws FileNotFoundException, IOException {
		 
	        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        jf.setPreferredSize(new Dimension(500,500));
	        jf.setLocation(700,400);
	        JPanel panel = new JPanel(new BorderLayout());
	        
	        
            User a = new User();
	        String pathName = "D:/Users.txt";
			try (FileReader fr = new FileReader(pathName);
				BufferedReader bf = new BufferedReader(fr);){
				
				while((a.QMID=bf.readLine())!=null) {
					
					
					a.readUserInfo(a);
					 if(a.State.equals("0")) {
				        	q = "Using Scooter";
				        }else {
				        	q = "Free";
				        }
				        if(a.Balance.equals("0")) {
				        	m = "not in arrears";
				        }else {
				        	m = "in arrears";
				        }
				        
				       i++;
				       userInfo = userInfo + "<br/>"+i + ":<br/>  QMID: "+ a.QMID 
				    		   					+" <br/>  Name:"+ a.Name
				    		   					+" <br/>  Email:"+ a.Email
				    		   					+" <br/>  State:"+q 
				    		   					+" <br/>  Balance:"+m 
				    		   					+" <br/>  Time:"+a.Time;
				       
				}
			}
	        
	     
	        //Create a label+html, which is then used to print all user information on the label
	        JLabel newLabel = new JLabel("<html>" + userInfo +"</html>",JLabel.CENTER);
	        InfoPanel.add(newLabel, BorderLayout.CENTER);
	        panel.add(backPanel,BorderLayout.SOUTH);
	        jsp = new JScrollPane(InfoPanel);
	        panel.add(jsp);
	        backPanel.setLayout(new GridLayout(2,1));
	        back.setPreferredSize(new Dimension(200,30));
			send.setPreferredSize(new Dimension(200,30));
			pback.add(back);
			psend.add(send);
	        backPanel.add(pback);
	        backPanel.add(psend);
	        
	        jf.setContentPane(panel);
	        jf.pack();
	        jf.setLocationRelativeTo(null);
	        jf.setVisible(true);
	        
	        back.addActionListener(this);
	        send.addActionListener(this);
	
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new ManagerUsersInfo().setArea();
	}

	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==back) {
			jf.dispose();
		}
		if(event.getSource()==send) {
			new FeedBack().sendSuccess();
		}
	}
}
