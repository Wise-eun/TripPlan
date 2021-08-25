import java.io.Serializable;
import java.util.ArrayList;

public class Plan_info implements Serializable{
String ID;
ArrayList <Plan> plan = new ArrayList <Plan>();

Plan_info(String id, Plan plan){
	ID = id;
	this.plan.add(plan);
}



}
