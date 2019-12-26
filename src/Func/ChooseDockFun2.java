package Func;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import GUI.ChooseDockReturn;
import GUI.FeedBack;
import GUI.ReturnSlot;
import Users.newUser;

/**
 * Title      : ChooseDockFunc1.java
 * Description: This class includes specific function: 
 *              the user enters the corresponding different interface 
 *              when selecting one docking from ABC.
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class ChooseDockFun2 extends ReturnSlot implements newUser{
	/*
	 * Check the user's current status when returning the car: 
	 * Whether the user has not picked up the car / the user is in a fine state
	 */
	public void Return(String qmid) {
				File file = new File("D:/"+qmid+".txt");
				
				
				if(file.exists()) {
					a.QMID = qmid;
					a.readUserInfo(a);
					
					
					if(a.State.equals("0")) {
						new ChooseDockReturn().setArea(qmid);
					}else {
						new FeedBack().remindPickUp();
						
					}
					
				}else if(!file.exists()) {
					new FeedBack().unExistScanID();
				}		
	}
	
public String dockingA(String qmid) throws FileNotFoundException, IOException {
		
		DockingNum = "A";
		try {
			new ReturnSlot().setArea(DockingNum,qmid);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DockingNum;
	}
	
	public String dockingB(String qmid) throws FileNotFoundException, IOException {

		DockingNum = "B";
		try {
			new ReturnSlot().setArea(DockingNum,qmid);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return DockingNum;
	}
	
	public String dockingC(String qmid) throws FileNotFoundException, IOException {

		DockingNum = "C";
		try {
			new ReturnSlot().setArea(DockingNum,qmid);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DockingNum;
	}

}
