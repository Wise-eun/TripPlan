import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

class ReceiveDataThread implements Runnable{
Socket socket;
ObjectInputStream is;
ObjectOutputStream os;

BufferedReader bufferReader;
ArrayList <Plan> plans;
User user;
	public ReceiveDataThread(Socket s, ObjectInputStream is,User user) {
		this.user = user;
		socket = s;
		
	
		this.is = is;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
	
		// TODO Auto-generated method stub
		//ObjectInputStream dis = null;
		System.out.println("실행중");
		try {
			while(true) {
				
				os = new ObjectOutputStream(socket.getOutputStream());
				bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
				os.writeObject(plans); // 데이터 직렬화
	            os.flush(); // 직렬화된 데이터 전달
	            
	            
	            is = new ObjectInputStream(socket.getInputStream());
				plans = (ArrayList <Plan>)is.readObject();
				 user.setPlans(load(user,plans));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
   public synchronized static ArrayList <Plan> load(User user,ArrayList <Plan> plans) {
		   
		   Iterator<Plan> it = plans.iterator();
		   ArrayList <Plan> users_plans = new ArrayList<Plan>();
		   
		   int num=0;
		   if(plans.size()>0) {
		   
		   for(int i=0;i<plans.size();i++) {
			   for(int j=0;j<plans.get(i).getusers().size();j++) {
		      if(user.ID.equals( plans.get(i).getusers().get(j))==true) // 사용자가 포함된 계획이 있을경우로드 
		    	  users_plans.add(plans.get(i)); 
		         
			   }
		   } 
		   
		   //user.setPlans(users_plans);
		   }
		   return users_plans;
		}
	
}