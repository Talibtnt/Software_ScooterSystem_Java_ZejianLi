package Func;

import static Users.newUser.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import GUI.ChooseDockPickup;
import GUI.FeedBack;
import GUI.FineArea;
import GUI.PickupSlot;
import Users.newUser;
import files.Dock;

/**
 * Title      : ChooseDockFunc1.java
 * Description: This class includes specific function: 
 *              the user enters the corresponding different interface 
 *              when selecting one docking from ABC.
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class ChooseDockFunc1 extends PickupSlot implements newUser{

    Dock dock = new Dock();
    
    /*
     * check the user's current status when picking up the car: 
     * Whether the user has not returned the car / the user is in a fine state
     */
    public void pickUp(String qmid) throws FileNotFoundException, IOException {
		
		
		File file = new File("D:/"+qmid+".txt");
		
		
		if(file.exists()) {
			a.QMID = qmid;
			a.readUserInfo(a);
			
			
			if(a.State.equals("1")) {
				new ChooseDockPickup().setArea(qmid);
			}else {
				
				
				new FeedBack().remindReturn();
				
			}
			
		}else if(!file.exists()) {
			new FeedBack().unExistScanID();
		}
		
	}
/*
 * Verify that the user is in a fine state
 */
public void checkBalance(String qmid) {
	a.QMID = qmid;
	a.readUserInfo(a);
	if(a.Balance.equals("1")) {
		new FineArea().setArea(a.QMID);
		System.out.println("Please pay the fine.");
	}else if(a.Balance.equals("0")) {
		try {
			pickUp(qmid);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public String dockingA(String qmid) throws FileNotFoundException, IOException {
	
	DockingNum = "A";
		try {
		new PickupSlot().setArea(DockingNum,qmid);
		
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
		new PickupSlot().setArea(DockingNum,qmid);
		
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
		new PickupSlot().setArea(DockingNum,qmid);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return DockingNum;
}

}
