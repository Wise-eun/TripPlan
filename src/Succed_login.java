import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Succed_login extends JFrame{
	Succed_login(){
		
		setTitle("�α��� ����");
		   this.setLocation(600, 350);
		     JPanel NewWindowContainer = new JPanel();
		      setContentPane(NewWindowContainer);
		      NewWindowContainer.setLayout(null);
		      
		      JLabel NewLabel = new JLabel("�ȳ��ϼ��� "+ User.Name + "��, ȯ���մϴ�.");
		      NewLabel.setBounds(50, 10, 300, 20);
		      NewWindowContainer.add(NewLabel);
	            
	            
	            
	            setSize(300, 100);
	            setResizable(false);
	            setVisible(true);
	}
}
