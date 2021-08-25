import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerThread {

	
	Socket child;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	String user_id;
	HashMap<String,ObjectOutputStream> hm;
	
	
	public ServerThread(Socket s , HashMap hm) {
		child = s;
		this.hm= hm;
		try {
			ois = new ObjectInputStream(child.getInputStream());
			oos = new ObjectOutputStream(child.getOutputStream());
			
			//user_id = (String)ois.readObject();
			
			
			synchronized(hm) {
				hm.put(user_id, oos);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public void run() {
		Plan receiveData;
		
		
		while(true) {
			try {
				receiveData = (Plan)ois.readObject();
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		
	}
	
	public void send(Plan plan) {
		
		
	}
	
	
}
