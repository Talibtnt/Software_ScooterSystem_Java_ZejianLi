package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Func.Fine;
import Users.newUser;
import files.Dock;
import files.User;

/**
 * Title      : PickupSlot.java
 * Description: This class provides the user with 8 slots for picking up the scotter, 
 *              including timing pickup function and flashing function.
 * @author    : Liu Yucheng 
 * @version   : 3.0
 */

public class PickupSlot implements ActionListener,newUser{
	public Timer timer = new Timer();
	public JFrame slotFrame = new JFrame();
	public JPanel []slotPanel = new JPanel[16];
    public JButton[] Slots = new JButton[16];
    public JLabel message = new JLabel();
    public JPanel []superPanel = new JPanel[3];
    public JButton back = new JButton("back");
    public Dock d = new Dock();
    public static int time = 60; 
    public String DockingNum;
   
    
    /*
     * set interface
     */
    public void setArea(String DockingNum,String qmid) throws FileNotFoundException, IOException {
    	
    	a.QMID = qmid;
    	a.readUserInfo(a);
    	slotFrame.setPreferredSize(new Dimension(500,500));
    	slotFrame.setLocation(400,100);
    	slotFrame.getContentPane().setLayout(new GridLayout(3,1));
    	for(int i=0;i<3;i++) {
    		superPanel[i] = new JPanel();
    	}

    	superPanel[0].add(message);
    	superPanel[1].setLayout(new GridLayout(2,4));
    	superPanel[2].add(back);
    	
    	File file = new File("D:/"+DockingNum+".txt");
    	d.dockingNum=DockingNum;
    	try {
			d.readDocking(d);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    	for(int i=0;i<8;i++) {
    		slotPanel[i] = new JPanel();
    		Slots[i] = new JButton();
    		Slots[i].setPreferredSize(new Dimension(100,40));
    		superPanel[1].add(slotPanel[i]);
    		try {
    			slotPanel[i].add(Slots[i]);
    			if(d.slots[i].equals("true")) {
    				Slots[i].setText("OCCUPIED");
    			}else if(d.slots[i].equals("false")) {
    				Slots[i].setText("EMPTY");
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    		}	
    	}
    	for(int i=0;i<3;i++) {
    		slotFrame.getContentPane().add(superPanel[i]);
    	}
    	
    	getOccupiedSlot(DockingNum, d);/////
    	
    	slotFrame.pack();  
        slotFrame.setVisible(true);  
        slotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        back.addActionListener(this);
        for(int i=0;i<8;i++) {
        	Slots[i].addActionListener(this);
        }
    }

    /*
     * Change the slot status and user status 
     * after picking up the car
     */
    public void pickUp(int slotNum,String qq) throws IOException {
    
    	a.QMID = qq;
    	a.readUserInfo(a);
    	a.State="0";
    	a.writeUserInfo(a);
    	
    		d.modifySlot(slotNum,d);

    		String c = d.slots[slotNum];
            if(c.equals("true")) {
         		Slots[slotNum].setText("OCCUPIED");
         	}else if(c.equals("false")) {
         		Slots[slotNum].setText("EMPTY");
         		
         	} 
   
    	}
    
    
    public void check(String DockingNum,Dock d,int i,String qmid) throws FileNotFoundException, IOException {
    	
    	a.QMID = qmid;
    	a.readUserInfo(a);
    	
    	d.dockingNum=DockingNum;
    	File file = new File("D:/"+DockingNum+".txt");
    	try {
			d.readDocking(d);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(d.slots[i].equals("true")) {
			try {
				d.dockingNum = DockingNum;
				d.readDocking(d);
				pickUp(i,qmid);
				message.setText("Please return within 30 minutes.");
				timer.cancel();
				time=60;
				try {
					new Fine().pickTime(a.QMID);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			message.setText("You can not pick up.");
			}
		for(int j=0;j<8;j++) {
			
			Slots[j].removeActionListener(this);
		}
    }
    
    
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==back) {
			timer.cancel();
			time=60;
			slotFrame.dispose();
		}
		for( int i=0;i<8;i++) {
        	if(event.getSource()==Slots[i]) {
        		Slots[i].setIcon(null);
        		Slots[i].setEnabled(false);
                                try {  
                                	check(d.dockingNum,d,i,a.QMID);} catch (FileNotFoundException e) {
                					e.printStackTrace();
                				} catch (IOException e) {
                					e.printStackTrace();
                				}
                                
				
    			}
        }
		
	}

    /*
     * In the slot with the status "occupied", randomly select one to flash
     */
	public void getOccupiedSlot(String docking, Dock d) throws FileNotFoundException, IOException {
		d.dockingNum = docking;
		File file = new File("D:/"+docking+".txt");
		if(file.exists()) {
			
			d.readDocking(d);
		
		ArrayList<Integer> slotNum = new ArrayList<Integer>();
		for(int i=0;i<8;i++) {
			if(d.slots[i].equals("true")) {
				slotNum.add(i);
			}
		}
		Random random = new Random();
		int length = slotNum.size();System.out.println("length"+length);
        if (length==0)new FeedBack().dockempty();

		int index = random.nextInt(length);
		 String url="D:\\gflash.gif";
         ImageIcon icon=new ImageIcon(url); 
         icon.getImage().flush(); 
         Slots[slotNum.get(index)].setEnabled(true);
         Slots[slotNum.get(index)].setIcon(icon); 
         Slots[slotNum.get(index)].setText(null); 
         for(int i=0;i<8;i++) {
         if (i!=slotNum.get(index))Slots[i].setEnabled(false);
		
		}
         timer.schedule( 
                 new TimerTask(){//Overwriting scheduled tasks 
                     public void run(){ 
                        
                    	 message.setText("Please pick up your scooter in "+String.valueOf(time)+" second."); 
                    	 message.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
    	 time--; 
         if(time <= 0) {//Operating time exceeds 1min
        	 timer.cancel();
        	 time=60;
        	 for(int i=0;i<8;i++) {
        		 Slots[i].setIcon(null);
            	 Slots[i].setEnabled(false);
            	
            	 } message.setText("Fail to pick up, please go back.");
            	   message.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
           }

     } 
    }, 0, 1000);
		}
	}

}
