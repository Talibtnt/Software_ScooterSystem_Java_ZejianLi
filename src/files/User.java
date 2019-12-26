package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Func.Fine;
/**
 * Title      : User.java
 * Description: Entity class, recording user information
 * @author    : Feng Yining
 * @version   : 3.0
 */
public class User extends Fine{
	
	public String QMID;
	public String Password;
	public String Name;
	public String Email;
	public String State;
	public String Balance;
	public String Time;
	
	public User(String QMID, String Password, String Name, String Email, String State, String Balance, String Time) {
		this.QMID = QMID;
		this.Password = Password;
		this.Name = Name;
		this.Email = Email;
		this.State = State;
		this.Balance = Balance;
		this.Time = Time;
	}

	public User() {
		
	}

	public String getQMID() {
		return QMID;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getState() {
		return State;
	}
	
	public String getBalance() {
		return Balance;
	}
	
	public String getTime() {
		return Time;
	}
	
	/*
	 * Write the ID of all registered users to the file
	 */
	public void writeAllUsers(String qmid) {
		File file = new File("D:/Users.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(qmid);
			bw.newLine();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Write the information of the registered new user to the file
	 */
	public void writeUserInfo(User a) {
		File file = new File("D:/"+a.QMID+".txt");//+Info.getName()
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile(),false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(a.QMID);
			bw.newLine();
			bw.write(a.Password);
			bw.newLine();
			bw.write(a.Name);
			bw.newLine();
			bw.write(a.Email);
			bw.newLine();
			bw.write(a.State);
			bw.newLine();
			bw.write(a.Balance);
			bw.newLine();
			bw.write(a.Time);
			bw.newLine();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Modify the user's usage time and write to the file.
	 */
	public void changeUserTime(String qmid) {
		a.QMID = qmid;
		a.readUserInfo(a);
		try {
			a.Time = String.valueOf(a.addMinutesSum(a.QMID)/2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	File file = new File("D:/"+a.QMID+".txt");
	
	System.out.println("String"+a.Time);
	FileWriter fw;
	try {
		fw = new FileWriter(file.getAbsoluteFile(),false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(a.QMID);
		bw.newLine();
		bw.write(a.Password);
		bw.newLine();
		bw.write(a.Name);
		bw.newLine();
		bw.write(a.Email);
		bw.newLine();
		bw.write(a.State);
		bw.newLine();
		bw.write(a.Balance);
		bw.newLine();
		bw.write(a.Time);
		bw.newLine();
		bw.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	/*
	 * Read user files to get user information.
	 */
	public void readUserInfo(User a) {
		String pathName = "D:/"+a.QMID+".txt";
		try (FileReader fr = new FileReader(pathName);
			BufferedReader bf = new BufferedReader(fr);){

			QMID = bf.readLine();
			Password = bf.readLine();
			Name = bf.readLine();
			Email = bf.readLine();
			State = bf.readLine();
			Balance = bf.readLine();
			Time = bf.readLine();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

	

}
