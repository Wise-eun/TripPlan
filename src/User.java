import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class User implements Serializable{

	static String ID;
	static String PW;
	static String Name;
	
	Socket sck=null;
	
	
	public  static ArrayList <Plan> plans = new ArrayList<Plan>();
	
	
	User(String ID, String PW, String Name){
		this.ID = ID;
		this.PW = PW;
		this.Name = Name;
	}
	public void setPlans( ArrayList <Plan> plans) {
		this.plans = plans;
		
	}
	
	public String getID(){

		return this.ID;
	}
	public String getName(){
		return this.Name;
	}
	
	public void printID(){

		System.out.println("ID = "+this.ID);
	}
	public void printName(){
		System.out.println("Name = "+this.Name);
	}
	
	
	
}
