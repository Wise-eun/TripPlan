import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class invite extends JFrame{
	 String ID;
	 User user;
	boolean same = true;
	static ArrayList<String> users = new ArrayList<String>();
	Plan plan;
invite(User user){
this.user = user;
	setTitle("ģ�� �ʴ�");
	users.add(user.ID);
	   this.setLocation(800, 100);
	     JPanel NewWindowContainer = new JPanel();
	      setContentPane(NewWindowContainer);
	      NewWindowContainer.setLayout(null);
	  this.setLayout(null);
	  
	  JLabel NewLabel = new JLabel("���� ������ ��ȹ�� ģ���� ID�� �߰����ּ���!");
	  NewLabel.setBounds(70,10,300,20);
      NewLabel.setVisible(true);
    add(NewLabel);

      
      JLabel NewLabel1 = new JLabel("ģ�� ID");
	      NewLabel1.setBounds(50,40,50,20);
	      NewLabel1.setVisible(true);
        add(NewLabel1);
        JTextField text1 = new JTextField();
        text1.setVisible(true);
        text1.setBounds(100,40,80,20);
        add(text1);
        JButton check1 = new JButton("�ʴ�");
        check1.setBounds(200,40,70,20);
        check1.setVisible(true);
        add(check1);
        

        check1.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	check1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	check1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	 ID = text1.getText();
	            	 for(int w=0;Login.array[w][0]!=null;w++)
	   		      {	
	            	if(Login.array[w][0].equals(ID)) {
	            		same = true;
	            		break;
	            	}
	            	else {same = false;	}
	            
	   		      }
	            	 
	            	  if(same== true) {
			            	//new Checkcheck(0);
			           check1.setVisible(false);
			           text1.setVisible(false);
			           JLabel text11 = new JLabel(text1.getText());
			           
			           text11.setBounds(100,40,80,20);
			           add(text11);
			           users.add(text1.getText());
			           
	            	  }
			            else {
			            	new Error_invite();
			            }	
	            	 
	            }
	            
	          	             
	   
	         });
        
        
        
        
        
        
        JLabel NewLabel2 = new JLabel("ģ�� ID");
        NewLabel2.setBounds(50,70,50,20);
        add(NewLabel2);
        JTextField text2 = new JTextField();
        text2.setBounds(100,70,80,20);
        text2.setVisible(true);
        add(text2);
        JButton check2 = new JButton("�ʴ�");
        check2.setBounds(200,70,70,20);
        check2.setVisible(true);
        add(check2);
        
        check2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            
            	check2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
               
            	check2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
            	 ID = text2.getText();
            	 for(int w=0;Login.array[w][0]!=null;w++)
   		      {	
            	if(Login.array[w][0].equals(ID)) {
            		same = true;
            		break;
            	}
            	else {same = false;	}
            
   		      }
            	 
            	  if(same== true) {
		            	//new Checkcheck(0);
            		   check2.setVisible(false);
			           text2.setVisible(false);
			           JLabel text22 = new JLabel(text2.getText());
			           
			           text22.setBounds(100,70,80,20);
			           users.add(text2.getText());
			           add(text22);
            	  }
		            else {
		            	new Error_invite();
		            }	
            	 
            }
            
          	             
   
         });
        
        
        
  	  JLabel NewLabel3 = new JLabel("ģ�� ID");
      NewLabel3.setBounds(50,100,50,20);
      add(NewLabel3);
      JTextField text3 = new JTextField();
      text3.setBounds(100,100,80,20);
      text3.setVisible(true);
      add(text3);
      JButton check3 = new JButton("�ʴ�");
      check3.setBounds(200,100,70,20);
      check3.setVisible(true);
      add(check3);
      
      
      check3.addMouseListener(new MouseAdapter() {
          public void mouseEntered(MouseEvent e) {
          
          	check3.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }

          public void mouseExited(MouseEvent e) {
             
          	check3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }

          public void mousePressed(MouseEvent e) {
          	 ID = text3.getText();
          	 for(int w=0;Login.array[w][0]!=null;w++)
 		      {	
          	if(Login.array[w][0].equals(ID)) {
          		same = true;
          		break;
          	}
          	else {same = false;	}
          
 		      }
          	 
          	  if(same== true) {
		            	//new Checkcheck(0);
          		   check3.setVisible(false);
		           text3.setVisible(false);
		           JLabel text33 = new JLabel(text3.getText());
		           
		           text33.setBounds(100,100,80,20);
		           users.add(text3.getText());
		           add(text33);      
          	  
          	  }
		            else {
		            	new Error_invite();
		            }	
          	 
          }
          
        	             
 
       });
      
      
      JButton make = new JButton("��ȹ ����");
      make.setBounds(280,140,100,20);
      make.setVisible(true);
      add(make);
      make.addMouseListener(new MouseAdapter() {
          public void mouseEntered(MouseEvent e) {
          
          	make.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }

          public void mouseExited(MouseEvent e) {
             
          	make.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }

          public void mousePressed(MouseEvent e) {
          plan = new Plan(users);
          //Server.save(users,plan);
          Random random = new Random();
          random.setSeed(System.currentTimeMillis()); 
          plan.setID(random.nextInt());
         user.plans.add(plan);
  		try {
  			
  			//Socket socket = new Socket("localhost",10002);
			//SocketAddress address = new InetSocketAddress("localhost",10002);
			
			Main.send(Login.socket,plan);
			//Main.receive(socket,user);
			
			dispose();
			
			if(user.plans.size()!=0) {
				int i=0;
				for(;i<user.plans.size();i++) {
					if(user.plans.get(i)!= null)
					{
						MyPage.makeButton.get(i).setVisible(false);
						MyPage.PlanButton.get(i).setVisible(true);
						
						//add(MyPage.PlanButton.get(i));
					}
					}
				
					
						for(;i<6;i++) {
							MyPage.PlanButton.get(i).setVisible(false);
						
							MyPage.makeButton.get(i).setVisible(true);
						//add(MyPage.makeButton.get(i));
						}
					
					
				
				
			}
			
			
			
			
			
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
          //dispose();
          	//dispose(); 
          }
          
        	             
 
       });
      
      
      
      setSize(400, 200);
      setResizable(false);
      setVisible(true);
      
}
	

}

class Error_invite extends JFrame {
	Error_invite(){
		
		setTitle("�˸�");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		      
		      JLabel NewLabel = new JLabel("�ش�ID�� ���� ����ڰ� �����ϴ�.");
				 NewLabel.setBounds(60, 10, 300, 20);
			      NewWindowContainer.add(NewLabel);
				
			      JButton button = new JButton("Ȯ��");
			      button.setBounds(110, 35, 60, 20);
			      add(button);
			      
			      
			      button.addMouseListener(new MouseAdapter() {
			            public void mouseEntered(MouseEvent e) {
			            
			            	button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			            }

			            public void mouseExited(MouseEvent e) {
			               
			            	button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			            }

			            public void mousePressed(MouseEvent e) {
			            	
			            
			            dispose();
			            
			            
			            }
			             
			   
			         });
			      setSize(300, 100);
		          setResizable(false);
		          setVisible(true);
		
	}
	
}
