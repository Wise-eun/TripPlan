import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyPage extends JFrame{
	static Socket socket;
	User user;
	static Plan buffplan = new Plan() ; 
	ImageIcon mypage = new ImageIcon(getClass().getResource("마이페이지.png"));
	public static Image background ;
	 private ImageIcon makeBtBasic = new ImageIcon(Main.class.getResource("만들기basic.png"));
	   private ImageIcon makeBtClick = new ImageIcon(Main.class.getResource("만들기click.png"));
	   
		 private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("상단바.png")));
		   
		 private ImageIcon exitBtBasic = new ImageIcon(Main.class.getResource("exitButtonBasic.png"));
		   private ImageIcon exitBtClick = new ImageIcon(Main.class.getResource("exitButtonClick.png"));
		   private JButton exitButton = new JButton(exitBtBasic);
		   
		   private ImageIcon reloadBtBasic = new ImageIcon(Main.class.getResource("새로고침.png"));
		   private ImageIcon reloadBtClick = new ImageIcon(Main.class.getResource("새로고침click.png"));
		   
		   private ImageIcon first = new ImageIcon(Main.class.getResource("첫번째프로젝트.png"));
		   private ImageIcon second = new ImageIcon(Main.class.getResource("두번째프로젝트.png"));
		   private ImageIcon third = new ImageIcon(Main.class.getResource("세번째프로젝트.png"));
		   private ImageIcon fourth = new ImageIcon(Main.class.getResource("네번째프로젝트.png"));
		   private ImageIcon fifth = new ImageIcon(Main.class.getResource("다섯번째프로젝트.png"));
		   private ImageIcon sixth = new ImageIcon(Main.class.getResource("여섯번째프로젝트.png"));
	   
	
	   private JButton reloadButton;
	   
	   private int mouseX, mouseY;
	   private Image screenImage;
	   private Graphics screenGraphic;
	 
	   
		static ArrayList <JButton> makeButton = new ArrayList <JButton>();
		
		static ArrayList <JButton> PlanButton = new ArrayList <JButton>();
		
	   
	public MyPage(Socket socket,User user) {
		this.socket = socket;
		mypage = imageSetSize(mypage,500,347);
		makeBtClick = imageSetSize(makeBtClick,30,30);
		makeBtBasic = imageSetSize(makeBtBasic,40,40);
		reloadBtBasic = imageSetSize(reloadBtBasic,50,20);
		reloadBtClick = imageSetSize(reloadBtClick,50,20);
		
		first = imageSetSize(first,50,30);
		second = imageSetSize(second,50,30);
		third = imageSetSize(third,50,30);
		fourth = imageSetSize(fourth,50,30);
		fifth = imageSetSize(fifth,50,30);
		sixth = imageSetSize(sixth,50,30);
		
	
		for(int i=0;i<6;i++) {
			makeButton.add(new JButton(makeBtBasic));
		}
		
		PlanButton.add(new JButton(first));
		PlanButton.add(new JButton(second));
		PlanButton.add(new JButton(third));
		PlanButton.add(new JButton(fourth));
		PlanButton.add(new JButton(fifth));
		PlanButton.add(new JButton(sixth));
		
		for(int i=0;i<6;i++) {
			makeButton.get(i).setBorderPainted(false);
			makeButton.get(i).setContentAreaFilled(false);
			makeButton.get(i).setFocusPainted(false);
			makeButton.get(i).setVisible(false);
			
			PlanButton.get(i).setBorderPainted(false);
			PlanButton.get(i).setContentAreaFilled(false);
			PlanButton.get(i).setFocusPainted(false);
			PlanButton.get(i).setVisible(false);
			
			
		}
		
		
		makeButton.get(0).setBounds(61, 100, 50, 50);
		PlanButton.get(0).setBounds(61, 100, 50, 30);
		
		makeButton.get(1).setBounds(230, 100, 50, 50);
		PlanButton.get(1).setBounds(230, 100, 50, 30);
		
		makeButton.get(2).setBounds(400, 100, 50, 50);
		PlanButton.get(2).setBounds(400, 100, 50, 30);
		
		makeButton.get(3).setBounds(61, 250, 50, 50);
		PlanButton.get(3).setBounds(61, 250, 50, 30);
		
		makeButton.get(4).setBounds(230, 250, 50, 50);
		PlanButton.get(4).setBounds(230, 250, 50, 30);
		
		makeButton.get(5).setBounds(400, 250, 50, 50);
		PlanButton.get(5).setBounds(400, 250, 50, 30);
		
		for(int i=0;i<6;i++) {
		add(PlanButton.get(i));
		add(makeButton.get(i));
		}
		background = mypage.getImage();
		
		
		setUndecorated(true);
	      setTitle("TripPlan");
	      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	      setResizable(false);
	      setLocationRelativeTo(null);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	      setBackground(new Color(0, 0, 0, 0));
	      setLayout(null);
	      
	      exitButton.setBounds(470, 0, 30, 20);
	      exitButton.setBorderPainted(false);
	      exitButton.setContentAreaFilled(false);
	      exitButton.setFocusPainted(false);
	      exitButton.addMouseListener(new MouseAdapter() {
	         @Override

	         public void mouseEntered(MouseEvent e) {
	            exitButton.setIcon(exitBtClick);
	            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	         }

	         @Override
	         public void mouseExited(MouseEvent e) {
	            exitButton.setIcon(exitBtBasic);
	            exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	         }

	         @Override
	         public void mousePressed(MouseEvent e) {

	            System.exit(0);
	         }

	      });
	      add(exitButton);
	      menuBar.setBounds(0, 0, 500, 20);
	      menuBar.addMouseListener(new MouseAdapter() { 
	    	  public void mousePressed(MouseEvent e) {
	            mouseX = e.getX();
	            mouseY = e.getY();
	         }
	      });
	      menuBar.addMouseMotionListener(new MouseMotionAdapter() {
	          @Override
	          public void mouseDragged(MouseEvent e) {
	             int x = e.getXOnScreen();
	             int y = e.getYOnScreen();
	             setLocation(x - mouseX, y - mouseY);
	          }

	       });
	      add(menuBar);

	if(user.plans.size()!=0) {
		int i=0;
		for(;i<user.plans.size();i++) {
			if(user.plans.get(i)!= null)
			{
				makeButton.get(i).setVisible(false);
				
				PlanButton.get(i).setVisible(true);
			}
			}
		
			
				for(;i<6;i++) {
				PlanButton.get(i).setVisible(false);
				
				makeButton.get(i).setVisible(true);
				//add(makeButton.get(i));
				}

	}
	else {
		for(int i=0;i<6;i++) {
			PlanButton.get(i).setVisible(false);
			
			makeButton.get(i).setVisible(true);
			add(makeButton.get(i));
		}
	}
	
	
	for(int i=0;i<6;i++) {
	makeButton.get(i).addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent e) {
           
        	   makeButton.get(0).setCursor(new Cursor(Cursor.HAND_CURSOR));
        	   makeButton.get(0).setIcon(makeBtClick);
           }

           public void mouseExited(MouseEvent e) {
              
        	   makeButton.get(0).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	   makeButton.get(0).setIcon(makeBtBasic);
           }

           public void mousePressed(MouseEvent e) {
           	
           new invite(user);
           //dispose();
           
           
           }

        });
	}
		
	reloadButton = new JButton(reloadBtBasic);
	reloadButton.setBounds(400, 50, 50, 20);
	reloadButton.setBorderPainted(false);
	reloadButton.setContentAreaFilled(false);
	reloadButton.setFocusPainted(false);
	reloadButton.setVisible(true);
add(reloadButton);

reloadButton.addMouseListener(new MouseAdapter() {
       public void mouseEntered(MouseEvent e) {
       
    	   reloadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	   reloadButton.setIcon(reloadBtClick);
       }

       public void mouseExited(MouseEvent e) {
          
    	   reloadButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    	   reloadButton.setIcon(reloadBtBasic);
       }

       public void mousePressed(MouseEvent e) {
    	   //ArrayList<Plan_info> plans = Server.plans;
    	   //Main.send(Login.socket,plans);
			try {
				Socket socket =Login.socket;
				//SocketAddress address = new InetSocketAddress("localhost",10002);
				
				
				Main.send(socket,buffplan);
				Main.receive(socket,user);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	   
    	   
      // new invite(user);
       //dispose();
       
       
       }
        

    });
		
PlanButton.get(0).addMouseListener(new MouseAdapter() {
    @Override

    public void mouseEntered(MouseEvent e) {
       exitButton.setIcon(exitBtClick);
       exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
       exitButton.setIcon(exitBtBasic);
       exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e) {

       //System.exit(0);
    }

 });
	}
	
	  public void screenDraw(Graphics2D g) {
		   
	      g.drawImage(background, 0, 0, null);
	      paintComponents(g);
	      g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	      this.repaint();

	   }
	 public void paint(Graphics g) {

		 screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      screenGraphic = screenImage.getGraphics();
      screenDraw((Graphics2D) screenGraphic);
	      g.drawImage(screenImage, 0, 0, null);

	   }
	 
	   ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		      Image ximg = icon.getImage();
		      Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		      ImageIcon syimg = new ImageIcon(yimg);
		      return syimg;

		   }
}
