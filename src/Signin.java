import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Signin extends JFrame{
	 String ID;
	 String PW;
	 static String Name;
	 boolean same = true;
     
	Signin(){
		
		setTitle("회원가입");
		   this.setLocation(800, 100);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		  this.setLayout(null);
		   
	           
	           JLabel NewLabel3 = new JLabel("이름");
	           NewLabel3.setBounds(100,10,50,20);
	           add(NewLabel3);
	            
	           JTextField text3 = new JTextField();
	           text3.setBounds(150,10,80,20);
	           text3.setVisible(true);
               add(text3);
	           
               
               
               
               JLabel NewLabel = new JLabel("ID");
 		      NewLabel.setBounds(100,50,50,20);
 		      NewLabel.setVisible(true);
 	           add(NewLabel);
	           JTextField text = new JTextField();
	           text.setVisible(true);
	           text.setBounds(150,50,80,20);
               add(text);
	            
              
              
	           JButton check = new JButton("중복확인");
	           check.setBounds(240,50,90,20);
	           add(check);
               
	           check.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		            
		            	check.setCursor(new Cursor(Cursor.HAND_CURSOR));
		            }

		            public void mouseExited(MouseEvent e) {
		               
		            	check.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		            }

		            public void mousePressed(MouseEvent e) {
		            	 ID = text.getText();
		            	 for(int w=0;Login.array[w][0]!=null;w++)
		   		      {	
		            	if(Login.array[w][0].equals(ID)) {
		            		same = true;
		            		break;
		            	}
		            	else {same = false;	}
		            
		   		      }
		            	 
		            	  if(same== true) {
				            	new Checkcheck(0);
				            }
				            else {
				            	new Checkcheck(1);
				            }	
		            	 
		            }
		            
		          	             
		   
		         });
               
               
               
	           JLabel NewLabel2 = new JLabel("PW");
	           NewLabel2.setBounds(100,80,50,20);
	           add(NewLabel2);
	           
	           JTextField text2 = new JTextField();
	           text2.setBounds(150,80,80,20);
	           text2.setVisible(true);
               add(text2);
	           
	           
               
               JButton make = new JButton("회원가입하기");
               make.setBounds(130, 130, 120, 20);
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
		            	ID = text.getText();
		            	PW=text2.getText();
		            	Name = text3.getText();
		            	
		            	
		            if(same==true) {
		            	new Checkcheck(2);	
		            }
		            else if(Name==null || PW==null) {
		            	new Checkcheck(3);	
		            }
		            else {
		            	File file = new File("user_info.txt");
		            	
		            	try {
							FileWriter fw = new FileWriter(file,true);
						fw.write("\n");
						fw.write(ID+" "+PW+" "+Name);
		            	fw.close();
		            	} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	
		            	
		            	
		            	
		            	new Succed_join();
		            dispose();
		            }
		            
		            }
		             
		   
		         });
	          
               
               
	            setSize(400, 200);
	            setResizable(false);
	            setVisible(true);
		
	}
	
	
	
}
class Checkcheck extends JFrame {
	Checkcheck(int a){
		setTitle("ID 중복 확인");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		      
		
		
		
		if(a==0) {
			 JLabel NewLabel = new JLabel("중복되는 ID가 있습니다.");
			 JLabel NewLabel2 = new JLabel("다른 ID로 입력해주세요.");
			 NewLabel.setBounds(50, 10, 300, 20);
			 NewLabel2.setBounds(50, 30, 300, 20);
		      NewWindowContainer.add(NewLabel);
		      NewWindowContainer.add(NewLabel2);
		}
		else if(a==1){
			 JLabel NewLabel = new JLabel("사용가능한 ID 입니다.");
			 NewLabel.setBounds(50, 10, 300, 20);
		      NewWindowContainer.add(NewLabel);
			
		}
		
		else if(a==2) {
			 JLabel NewLabel = new JLabel("ID중복검사를 진행해주세요.");
			 NewLabel.setBounds(50, 10, 300, 20);
		      NewWindowContainer.add(NewLabel);
			
			
		}
		else {
			 JLabel NewLabel = new JLabel("내용기입을 다 했는지 확인해주세요.");
			 NewLabel.setBounds(50, 10, 300, 20);
		      NewWindowContainer.add(NewLabel);
			
			
		}
		
		
		  setSize(300, 100);
          setResizable(false);
          setVisible(true);
	}
	
	
}

class Succed_join extends JFrame{
	Succed_join(){
		
		setTitle("회원가입 성공");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		
		
		 JLabel NewLabel = new JLabel("가입을 축하드립니다." + Signin.Name + "님");
		 JLabel NewLabel2 = new JLabel("다시 로그인 바랍니다.");
		 NewLabel.setBounds(50, 10, 300, 20);
		 NewLabel2.setBounds(50, 30, 300, 20);
	      NewWindowContainer.add(NewLabel);
	      NewWindowContainer.add(NewLabel2);
		
	      
	      JButton button = new JButton("확인");
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


