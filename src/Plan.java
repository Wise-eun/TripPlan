import java.io.Serializable;
import java.util.ArrayList;

public class Plan implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String user;
	private ArrayList<String> users  = new ArrayList<String>();
	
	public Plan() {
		
	}
	
	public 	Plan(String user, int id) {
		this.id =id;
		this.user = "user";
	}

	public Plan(Plan newplan){
		id = newplan.id;
		users = newplan.users;
		
	}
	
public 	Plan(ArrayList<String> users){
	this.users = users;
	
	for(int i=0;i<users.size();i++) {
		
		
		
	//user 클래스에 방 추가하기	
	}
	

}



public int getID(){
	return this.id;
}
public void setID(int id){
	this.id =id;
}


public String getName(){
	return this.user;
}

public ArrayList<String> getusers(){
	return this.users;
}
public void broadcast() {
	
	
}

public void printUser() {
	for(int i=0;i<users.size();i++)
	System.out.println(users.get(i));
}

}
