import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error_login extends JFrame{
	   JLabel NewLabel = new JLabel("���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
	   JButton error_button = new JButton("Ȯ��");
	   
	Error_login(){
		
		setTitle("�α��ο���");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		   
		      NewLabel.setBounds(50, 10, 300, 20);
		      
		      
		      
		      error_button.setBounds(110, 35, 60, 20);
	            error_button.setVisible(true);
	            
	            
	            
		      add(NewLabel);     
	            add(error_button);
	       
	          
	     
	            
	            error_button.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		            
		            	error_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		            }

		            public void mouseExited(MouseEvent e) {
		               
		            	error_button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
