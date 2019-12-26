package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Title      : Dock.java
 * Description: Entity class, including information about all docks
 * @author    : Feng Yining
 * @version   : 3.0
 */

public class Dock {
	
	public String dockingNum;
	public String[]slots = new String[8];
	
	public Dock(String dockingNum,String slots[]) {
		
		this.dockingNum = dockingNum;
		this.slots[0] = slots[0];
		this.slots[1] = slots[1];
		this.slots[2] = slots[2];
		this.slots[3] = slots[3];
		this.slots[4] = slots[4];
		this.slots[5] = slots[5];
		this.slots[6] = slots[6];
		this.slots[7] = slots[7];
		
	}
	
	public Dock() {
		
	}
	
	public String getDockingNum() {
		return dockingNum;
	}	
	
	public String getSlot0() {
		return slots[0];
	}
	public String getSlot1() {
		return slots[1];
	}
	public String getSlot2() {
		return slots[2];
	}
	public String getSlot3() {
		return slots[3];
	}
	public String getSlot4() {
		return slots[4];
	}
	public String getSlot5() {
		return slots[5];
	}
	public String getSlot6() {
		return slots[6];
	}
	public String getSlot7() {
		return slots[7];
	}
	
	/*
	 * Read the information of docking
	 */
	public void readDocking(Dock d) throws FileNotFoundException, IOException  {
		String pathName = "D:/"+d.dockingNum+".txt";
		try (FileReader fr = new FileReader(pathName);
			BufferedReader bf = new BufferedReader(fr);){

			d.dockingNum = bf.readLine();//dockingNum
			d.slots[0] = bf.readLine();
			d.slots[1] = bf.readLine();
			d.slots[2] = bf.readLine();
			d.slots[3] = bf.readLine();
			d.slots[4] = bf.readLine();
			d.slots[5] = bf.readLine();
			d.slots[6] = bf.readLine();
			d.slots[7] = bf.readLine();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeDocking(Dock d) throws IOException {
		File file = new File("D:/"+d.dockingNum+".txt");
		FileWriter fw;
		try {
			
			fw = new FileWriter(file.getAbsoluteFile(),false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(d.dockingNum);
			bw.newLine();
			bw.write(String.valueOf(d.slots[0]));//dockingNum
			bw.newLine();
			bw.write(String.valueOf(d.slots[1]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[2]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[3]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[4]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[5]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[6]));
			bw.newLine();
			bw.write(String.valueOf(d.slots[7]));
			bw.newLine();
			
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Modify the information of docking
	 */
	public void modifySlot(int slotnum,Dock d) throws IOException {////
		
		if(d.slots[slotnum].equals("true")) {
			d.slots[slotnum] = "false";
		}else if(d.slots[slotnum].equals("false")){
			d.slots[slotnum] = "true";
		}
		
		
		d.writeDocking(d);
	}
	
}
