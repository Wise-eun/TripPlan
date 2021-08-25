import java.io.Serializable;
import java.util.ArrayList;

public class Plans implements Serializable{
	public static ArrayList<Plan_info> list = new ArrayList<Plan_info>();
	
	Plans(){}
	
	Plans(ArrayList<Plan_info> list){
		this.list = list;
		
	}
}
