import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainServer  {
static ServerSocket serverSocket;
Socket socket;
 static ArrayList <Plan> plans = new ArrayList<Plan>();

public static  String[][] array = new String[100][3];


List<Thread> list;



public static void main(String[] args) {
  	 Scanner sc = new Scanner(System.in);  
	 try {
			sc = new Scanner(new File("user_info.txt"));
		} catch (FileNotFoundException e1) {e1.printStackTrace();}
	      int i=0,j=0;
	      while (sc.hasNext()) {
	            String word = sc.next();
	            array[i][j++] = word;
	            word = sc.next();
	            array[i][j++] = word;
	            word = sc.next();
	            array[i][j] = word;
	            i++;j=0;
	           
	         }
	      
	   
	      

	
	Plan_Server server = new Plan_Server();
	server.giveAndTake();
	AcceptedThread acceptThread = new AcceptedThread(serverSocket);
	
	
	//new Thread(acceptThread).start();
	
	  }

public synchronized static void save(Plan plan) {
	   
	if(plan.getusers().size()==0)
		return;
	//ArrayList<String> users = plan.getusers();
	Plan modify;
	for(int i=0;i<plans.size();i++)
	{
		if(plans.get(i).getID()==plan.getID()) {
			modify = plans.get(i);
		modify= plan;
		
		return ;
		}
	}
	plans.add(plan);
	for(int i=0;i<plans.size();i++) {
	System.out.println("출력된 결과 :"+ plans.get(i).getID());
	plans.get(i).printUser();
	}
}



}

	
	


