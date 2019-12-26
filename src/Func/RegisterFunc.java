package Func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import files.User;

/*
 * 读写用户文件【类名修改-UserFile】
 * 
 */

public class RegisterFunc {

	public String QMID;
	public String Password;
	public String Name;
	public String Email;
	public String State;
	public String Balance;
	
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
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
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
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
