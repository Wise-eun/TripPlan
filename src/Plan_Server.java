import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Plan_Server{
	static ServerSocket serverSocket;
	Socket socket;
	static List<Thread> list;
	
	
	
	public Plan_Server() {
		list = new ArrayList<Thread>();
		System.out.println("Waiting connect.");
		

	}
	public void giveAndTake() {
		try {
			ServerSocket serverSocket = new ServerSocket(10002);
			serverSocket.setReuseAddress(true);
			
			
			
			while(true) {
				socket = serverSocket.accept();
				ServerSocketThread thread = new ServerSocketThread(this,socket);
				list.add(thread);
				thread.start();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public synchronized static void broadCasting(ArrayList <Plan> sendplans, ObjectOutputStream os) {
		for(int i=0;i<list.size();i++) {
			ServerSocketThread thread = (ServerSocketThread)list.get(i);
			System.out.print(list.get(i).getId()+" ");
			thread.send(sendplans);
		}
		
	}
}