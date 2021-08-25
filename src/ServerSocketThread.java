import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketThread extends Thread{
Socket socket;
Plan_Server server;
ObjectInputStream is = null;
ObjectOutputStream os = null;
String threadName;
Plan receiveplan;
ArrayList <Plan> sendplans;
	public ServerSocketThread(Plan_Server plan_Server, Socket socket) {
		// TODO Auto-generated constructor stub
		server = plan_Server;
		this.socket = socket;
		threadName = super.getName();
		System.out.println("Thread Name : " + threadName);
	}

	public void send(ArrayList <Plan> sendplans) {
		try {
			
			os.writeObject(MainServer.plans);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void run() {
	try {
		
		
		
		
		while(true) {
			try {
				
				is = new ObjectInputStream(socket.getInputStream());
				
				receiveplan = (Plan)is.readObject();
				if(receiveplan != null) {
				MainServer.save(receiveplan);
				sendplans = MainServer.plans;
				os = new ObjectOutputStream(socket.getOutputStream());
				Plan_Server.broadCasting(sendplans, os);
				
				}
//				for(int i=0;i<Plan_Server.list.size();i++) {
//					Socket socket = (Socket)Plan_Server.list.get(i).getId();
//				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
}
