package Func;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.FineArea;
import Users.newUser; 
 
/**
 * Title      : Fine.java
 * Description: The specific function of the fine
 * @author    : Li Zejian
 * @version   : 3.0
 */

public class Fine implements ActionListener,newUser { 
	int computeNumOfElements = 0;
	 
	long minutesSum; //用户单次使用的时长，单位：秒
	static String s = ""; 
	int k=0; //用于计算时间记录文件中用户多次使用的时间时进行循环的变量k
	static int allMinutesSum = 0;//时间记录文件中用户多次使用的时间的总和T2，单位：秒
	public static int lines1=0;
	public static int max=0;
	public static int min=99999;
	static List<String> numList = new ArrayList<String>();
	static int[] A=new int[100];
	String readPickTime; 
	String readReturnTime; 
	//UserMessage a = new UserMessage(); 
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
	private JFrame fineFrame = new JFrame("Fine"); 
	private JPanel[] panels = new JPanel[5]; 
	public JLabel message = new JLabel("Please pay a hundred pounds fine."); 
	private JButton pay  = new JButton("pay the fine"); 
	private JButton cancel = new JButton("cancel(scooter unavaliable)"); 
	
	public Fine() {} 
	
	public void setArea() { 
	        fineFrame.getContentPane().setLayout(new GridLayout(2,1)); 
	        for(int i=0;i<2;i++) { 
	            panels[i] = new JPanel(); 
	            fineFrame.add(panels[i]); 
	        } 
	        panels[0].add(message); 
	        panels[1].add(pay); 
	        panels[1].add(cancel); 
	        fineFrame.pack(); 
	        fineFrame.setVisible(true); 
	        fineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        pay.addActionListener(this); 
	        cancel.addActionListener(this);
	        } 
	 
	/*
	 * Get the time when the user picks up the scooter.
	 */
	public void pickTime(String qmid) throws ParseException { 
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Set date format
	Date pickTime = df.parse(df.format(new Date()));    
	String writePickTime = df.format(pickTime);  
	 
	
	a.QMID = qmid;
	File file = new File("D:/"+a.QMID+"Time"+".txt");//+Info.getName() 
	FileWriter fw; 
	try { 
	fw = new FileWriter(file.getAbsoluteFile(),true); 
	BufferedWriter bw = new BufferedWriter(fw); 
	//bw.newLine();  
	bw.write(" "+writePickTime+","); 
	bw.close(); 
	}catch(IOException e) { 
	e.printStackTrace(); 
	} 
	} 
	 
	/*
	 * Get the time when the user returned the scooter.
	 */
	public void returnTime(String qmid) throws ParseException{ 
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Set date format
	Date returnTime = df.parse(df.format(new Date()));    
	String writeReturnTime = df.format(returnTime);  
	  
	a.QMID = qmid;
	File file = new File("D:/"+a.QMID+"Time"+".txt");//+Info.getName() 
	FileWriter fw; 
	try { 
	fw = new FileWriter(file.getAbsoluteFile(),true); 
	BufferedWriter bw = new BufferedWriter(fw); 
	bw.write(" "+writeReturnTime+","); 
	bw.close(); 
	 
	}catch(IOException e) { 
	e.printStackTrace(); 
	 } 
	 } 
	
	   
	/*
	 * Obtain the time difference between the 
	 * user picking up the scooter and returning the scooter
	 * i.e. the time for single-use scooters
	 */
	public long timeDiff(String qmid) throws ParseException{  
	 
	try   
	{   
	  //UserMessage a = new UserMessage();  
		a.QMID = qmid;
	  String pathName = "D:/"+a.QMID+"Time"+".txt"; 
	try (FileReader fr = new FileReader(pathName); 
	BufferedReader bf = new BufferedReader(fr);){ 
		String line = bf.readLine(), lastsecline= "", lastline = "";
		

			while(line!=null) {

				lastsecline = String.valueOf(line.split(",")[0]).trim();
				lastline= String.valueOf(line.split(",")[1]).trim();
				line = bf.readLine();
			//
			}	readPickTime=lastsecline;
				readReturnTime=lastline;
				System.out.println(readPickTime+"00000");
				
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		
	}catch(IOException e) { 
	e.printStackTrace(); 
	} 
	  Date pickDate=null;  
	      SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	      pickDate = formatter.parse(readPickTime); 
	  Date returnDate=null;    
	  returnDate = formatter.parse(readReturnTime);  
	  long diff =  returnDate.getTime()-pickDate.getTime(); 
	   
	  long days = (int) (diff / (1000 * 60 * 60 * 24));   
	  System.out.println("days "+days);//
	  long hours = (int) ((diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60));   
	  long minutes = (int) ((diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60));   
	  long seconds = (int) ((diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000*60))/1000);  
	 
	  System.out.println("Seconds "+seconds);//
	  minutesSum= ((hours*60)*60) + (minutes*60)+seconds; 
	  String stringMinutesSum=Long.toString(minutesSum);
	 
	File file = new File("D:/"+a.QMID+"Time"+".txt");//+Info.getName() 
	FileWriter fw; 
	 
	fw = new FileWriter(file.getAbsoluteFile(),true); 
	BufferedWriter bw = new BufferedWriter(fw); 
	// 
	bw.write(stringMinutesSum+",\r\n");

	bw.close(); 
	 
	}catch (Exception e)   
	{ 
	} 
	return minutesSum; 
	} 

	public static void max() {
		int i;

	        String[] s=numList.toArray(new String[numList.size()]);
	        int p = s.length;
	        int[] A=new int[p];	        
	        for(i=0;i<s.length;i++){A[i]=Integer.parseInt(s[i]);}
	        for(i=0;i<A.length;i++){
	       
	            if(A[i]>max)   // Judging the maximum
	                max = A[i];
	            if(A[i]<min)   // Judging the minimum
	            	min = A[i];            
	           
	        } 
	}

public static void SearchKeyword(File file,String keyword) {  
	
    //Parameter check
    verifyParam(file, keyword);   
    LineNumberReader lineReader = null;  
    try {  
        lineReader = new LineNumberReader(new FileReader(file));  
        String readLine = null;  
        while((readLine =lineReader.readLine()) != null){  
            //Determine the number of occurrences of keywords in each line
            int index = 0;  
            int next = 0;  
            int times = 0;//Number of occurrences
            while((index = readLine.indexOf(keyword,next)) != -1) {  
                next = index + keyword.length();  
                times++;  
            }  
            if(times > 0) {  
            	lines1=lineReader.getLineNumber();
            	String str = Integer.toString(lines1);
                numList.add(str);
            }  
        }  
    } catch (IOException e) {  
        e.printStackTrace();  
    } finally {  
        close(lineReader);  
    }  
}  

private static void verifyParam(File file, String keyword) {  

    if(file == null ){  
        throw new NullPointerException("the file is null");  
    }  
    if(keyword == null || keyword.trim().equals("")){  
        throw new NullPointerException("the keyword is null or \"\" ");  
    }  
      
    if(!file.exists()) {  
        throw new RuntimeException("the file is not exists");  
    }  
    if(file.isDirectory()){  
        throw new RuntimeException("the file is a directory,not a file");  
    }  
    if(!file.canRead()) {  
        throw new RuntimeException("the file can't read");  
    }  
}  
  
private static void close(Closeable able){  
    if(able != null){  
        try {  
            able.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            able = null;  
        }  
    }  
}  

/*
 * Calculate the sum of the times the user has used the time in the time log file
 */
public int addMinutesSum(String qmid) throws IOException {
	a.QMID = qmid;
	Date now=new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String tablename=dateFormat.format(now);
    System.out.println(tablename); 
	SearchKeyword(new File("D:/"+a.QMID+"Time"+".txt"), tablename);  
     max();
	File file =new File("D:/"+a.QMID+ "Time"+".txt");
	try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s = "";
		int i=0;
		while(br.read() !=-1) {
            s=br.readLine();
			if (i<=max-1&&i>=min-1) {
		allMinutesSum += Integer.parseInt(String.valueOf(s.split(",")[2]).trim());
		
		}i++;		
			}
		
			br.close();

	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	System.out.println(allMinutesSum);
	return allMinutesSum;
}
	
	public void fineInterface(String qmid) throws ParseException, IOException {
		timeDiff(qmid);
		addMinutesSum(qmid);
		if (minutesSum >= 1800 || allMinutesSum > 7200) { 
			new FineArea().setArea(qmid);
		     a.Balance="1";
		     a.writeUserInfo(a); 
		} else{
			System.out.println("Thank you for using the scooter. Your time is within the prescribed range"); 
		}
	}
		
	public void actionPerformed (ActionEvent event) { 
	    if(event.getSource()==cancel) { 
	        fineFrame.dispose(); 
	    }else if(event.getSource()==pay) {     
	            fineFrame.dispose(); 
	    } 
	} 
	
 } 