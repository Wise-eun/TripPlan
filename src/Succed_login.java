import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Succed_login extends JFrame{
	Succed_login(){
		
		setTitle("로그인 성공");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		      
		      JLabel NewLabel = new JLabel("안녕하세요 "+ User.Name + "님, 환영합니다.");
		      NewLabel.setBounds(50, 10, 300, 20);
		      NewWindowContainer.add(NewLabel);
	            
	            
	            
	            setSize(300, 100);
	            setResizable(false);
	            setVisible(true);
	}
}
