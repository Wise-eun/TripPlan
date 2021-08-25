import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;

public class Main  {
	
	
	public static final int SCREEN_WIDTH = 500;
	public static final int SCREEN_HEIGHT = 347;
	
	static Socket sck = null;
	
	
	
	   public static void main(String[] args) {
		

	//sck = new Socket()	
		try {
			Socket socket = new Socket("localhost",10002);
			SocketAddress address = new InetSocketAddress("localhost",10002);
			//socket.connect(address);
			System.out.println("접속 성공");
			new Login(socket); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
	   
	   
	   
	   public static void send(Socket socket, Plan plans) throws IOException {
	        //Person 객체 생성. 인자로 3 넣어줌.
		   Plan send_plans = plans;

	        //생성한 person 객체를 byte array로 변환
	        byte[] data = toByteArray(send_plans);
	        //서버로 내보내기 위한 출력 스트림 뚫음
	        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
	        //출력 스트림에 데이터 씀
	       Plan  p = send_plans;
	       p.printUser();
	        os.writeObject(p);
	        //보냄
	        os.flush();
	        System.out.println("Plan send!");
//	        socket.close();
	    }
//	   public static void send(Socket socket, User user) throws IOException {
//	        //Person 객체 생성. 인자로 3 넣어줌.
//		   User send_user = user;
//
//	        //생성한 person 객체를 byte array로 변환
//	        byte[] data = toByteArray(send_user);
//	        //서버로 내보내기 위한 출력 스트림 뚫음
//	        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
//	        //출력 스트림에 데이터 씀
//	       User  u = send_user;
//	        os.writeObject(u);
//	        //보냄
//	        os.flush();
//	        System.out.println("User info send!");
////	        socket.close();
//	    }
	   
	   public static void receive(Socket socket, User user) throws IOException {
		   System.out.println("receive start!");
		   ArrayList <Plan> receiveplans = null ;
	        //서버로부터 받기 위한 입력 스트림 뚫음
	        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
	        try {
	        	 receiveplans = (ArrayList<Plan>)is.readObject();
				
				//System.out.println("출력된 결과 :"+ user.ID+" "+user.Name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	   user.setPlans(load(user,receiveplans));
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
	   
	   
	   
	   public static byte[] toByteArray (Object obj)
	    {
	        byte[] bytes = null;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        try {
	            ObjectOutputStream oos = new ObjectOutputStream(bos);
	            oos.writeObject(obj);
	            oos.flush();
	            oos.close();
	            bos.close();
	            bytes = bos.toByteArray();
	        }
	        catch (IOException ex) {
	            //TODO: Handle the exception
	        }
	        return bytes;
	    }
	   
	   
	   
	   
	   
	   public static <T> T toObject (byte[] bytes, Class<T> type)
	    {
	        Object obj = null;
	        try {
	            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
	            ObjectInputStream ois = new ObjectInputStream (bis);
	            obj = ois.readObject();
	        }
	        catch (IOException ex) {
	            //TODO: Handle the exception
	        }
	        catch (ClassNotFoundException ex) {
	            //TODO: Handle the exception
	        }
	        return type.cast(obj);
	    }
}




