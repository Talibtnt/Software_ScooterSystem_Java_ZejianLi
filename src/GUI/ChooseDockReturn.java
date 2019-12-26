package GUI;

import java.awt.event.ActionEvent;
import java.io.IOException;

import Func.ChooseDockFun2;

/**
 * Title      : ChooseDockReturn.java
 * Description: Provide three docking for users to choose
 * @author    : Feng Yining 
 * @version   : 3.0
 */

public class ChooseDockReturn extends ChooseDockPickup{
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==DockBack) {
			docksFrame.dispose();
		}else if(event.getSource()==A) {
			try {
				dock.dockingNum = "A";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("true")&dock.slots[1].equals("true")&dock.slots[2].equals("true")&
						dock.slots[3].equals("true")&dock.slots[4].equals("true")&dock.slots[5].equals("true")&
						dock.slots[6].equals("true")&dock.slots[7].equals("true")) {
					new FeedBack().allOccupied();
				}else {
					new ChooseDockFun2().dockingA(a.QMID);///dockingA(q)
				    docksFrame.dispose();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(event.getSource()==B) {
			try {
				dock.dockingNum = "B";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("true")&dock.slots[1].equals("true")&dock.slots[2].equals("true")&
						dock.slots[3].equals("true")&dock.slots[4].equals("true")&dock.slots[5].equals("true")&
						dock.slots[6].equals("true")&dock.slots[7].equals("true")) {
					new FeedBack().allOccupied();
				}else {
					new ChooseDockFun2().dockingB(a.QMID);
				    docksFrame.dispose();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(event.getSource()==C) {
			try {
				dock.dockingNum = "C";
				dock.readDocking(dock);
				System.out.println("docks");
				if(dock.slots[0].equals("true")&dock.slots[1].equals("true")&dock.slots[2].equals("true")&
						dock.slots[3].equals("true")&dock.slots[4].equals("true")&dock.slots[5].equals("true")&
						dock.slots[6].equals("true")&dock.slots[7].equals("true")) {
					new FeedBack().allOccupied();
				}else {
					new ChooseDockFun2().dockingC(a.QMID);
				    docksFrame.dispose();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

}
