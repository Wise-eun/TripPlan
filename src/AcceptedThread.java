
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AcceptedThread implements Runnable{
ServerSocket serverSocket;
Socket client;
Plan receiveplan;
User receiveuser;

List<Socket> connections = new Vector<Socket>();


static ArrayList <Plan> sendplans = new ArrayList <Plan> ();
public AcceptedThread(ServerSocket serverSocket) {
	this.serverSocket = serverSocket;
	
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket server =serverSocket;
		
		while(true) {
			
			try {
				client = serverSocket.accept();
				System.out.println("connected client" + client);
				connections.add(client);
//				Socket socket = server.accept();
				System.out.println("before is");
				ObjectInputStream is = new ObjectInputStream(client.getInputStream());
				 System.out.println("after is");
				ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
				 
				connections.add(client);
				
				if(is != null) {
				try {
					receiveplan = (Plan)is.readObject();
					//System.out.println("User ID = "+receiveuser.getID() + "User Name = "+receiveuser.getName());
					MainServer.save(receiveplan);
					sendplans = MainServer.plans;
					System.out.println("receive!");
				
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				}
				
				//형변환한게 저장되어있는 유저의ID와같을경우
				
				
				if(os != null){
			
//					senduser = Server.load(receiveuser);
//					//senduser.Name = "change";
					
				for(Socket socket: connections) {	
				 os.writeObject(sendplans);
				 os.flush();
				}
				 System.out.println("server send");}

			
				//client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("receive plans users : ");
			receiveplan.printUser();
			System.out.print("send plans users : ");
			for(int i=0;i<sendplans.size();i++)
			sendplans.get(i).printUser();
			
			
		}
	}
	
}

class Client{
	Socket socket;
	Client(Socket socket){
		this.socket = socket;
		
	}

}

//	
//	public void sendData( Socket socket, Plans plans){
//        try {
//            OutputStream os = socket.getOutputStream();
//            Plans send_plans = plans;
//            byte[] bytes = toByteArray(send_plans);    
//            os.write(bytes);
//            os.flush();
//        } catch(Exception e1){
//            e1.printStackTrace();
//        }
//    }
//	
//	 public static byte[] toByteArray (Object obj)
//	    {
//	        byte[] bytes = null;
//	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	        try {
//	            ObjectOutputStream oos = new ObjectOutputStream(bos);
//	            oos.writeObject(obj);
//	            oos.flush();
//	            oos.close();
//	            bos.close();
//	            bytes = bos.toByteArray();
//	        }
//	        catch (IOException ex) {
//	            //TODO: Handle the exception
//	        }
//	        return bytes;
//	    }
//	   
//	   
//	   
//	   
//	   
//	   public static <T> T toObject (byte[] bytes, Class<T> type)
//	    {
//	        Object obj = null;
//	        try {
//	            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
//	            ObjectInputStream ois = new ObjectInputStream (bis);
//	            obj = ois.readObject();
//	        }
//	        catch (IOException ex) {
//	            //TODO: Handle the exception
//	        }
//	        catch (ClassNotFoundException ex) {
//	            //TODO: Handle the exception
//	        }
//	        return type.cast(obj);
//	    }
//	
//}