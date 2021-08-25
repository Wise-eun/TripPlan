import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements Runnable {
	ReceiveDataThread rt;
	public ArrayList<Thread> list;
	//////////////////////통신
	static Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str;
	Plan buffer = new Plan();

	ObjectInputStream buffplan  ; 
	///////////////////////로그인 정보
	Socket sck;
	static User user;
	
	private String ID;
	private String PW;
	private String Name;
	  public static  String[][] array = new String[100][3];
	//////////////////////////
	ImageIcon login = new ImageIcon(getClass().getResource("로그인페이지.png"));
	public static Image background ;
	 private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("상단바.png")));
	   
	 private ImageIcon exitBtBasic = new ImageIcon(Main.class.getResource("exitButtonBasic.png"));
	   private ImageIcon exitBtClick = new ImageIcon(Main.class.getResource("exitButtonClick.png"));
	   private JButton exitButton = new JButton(exitBtBasic);
	   
	   private ImageIcon loginBtBasic = new ImageIcon(Main.class.getResource("로그인버튼basic.png"));
	   private ImageIcon loginBtClick = new ImageIcon(Main.class.getResource("로그인버튼click.png"));
	   
	   private JButton loginButton;
	   
	   private ImageIcon signinBt = new ImageIcon(Main.class.getResource("회원가입버튼.png"));
	   
	   private JButton signinButton;
	   
	   
	   private int mouseX, mouseY;
	   private Image screenImage;
	   private Graphics screenGraphic;
	 
	 public Login(Socket socket) {
		 
		
	//initNet(ip,port);
		 this.socket =socket; 
		   loginBtBasic = imageSetSize(loginBtBasic,166,20);
		      loginBtClick = imageSetSize(loginBtClick,166,20);
		      loginButton = new JButton(loginBtBasic);
		      
		      signinBt = imageSetSize(signinBt,40,20);
		      signinButton = new JButton(signinBt);
		      
		 login = imageSetSize(login,500,347);
	   
	      
		 background =  login.getImage();

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

		    
		      Scanner sc = new Scanner(System.in);  
		      try {
				sc = new Scanner(new File("user_info.txt"));
			} catch (FileNotFoundException e1) {e1.printStackTrace();}
		      int i=0,j=0;
		      while (sc.hasNext()) {
		            String word = sc.next();
		            array[i][j++] = word;
		            word = sc.next();
		            array[i][j++] = word;
		            word = sc.next();
		            array[i][j] = word;
		            i++;j=0;
		           
		         }
		      ///////////////////정보 잘 저장되었는지 확인하는 용도
		      for(int w=0;array[w][0]!=null;w++)
		      {	    	  
		    	  System.out.println(array[w][0] + " "+array[w][1] + " " + array[w][2]);
		      }
		      
		      
		      
		     
		      /////////////////ID와 PW입력
		      JTextField id_text = new JTextField();
		      id_text.setBounds(164, 164,150 , 20);
		      id_text.setBorder(null);
		      id_text.setVisible(true);
		      add(id_text);
		      
		      JTextField pw_text = new JTextField();
		      pw_text.setBounds(164, 217,150 , 20);
		      pw_text.setBorder(null);
		      pw_text.setVisible(true);
		      add(pw_text);
		      
		    
		      
		      
	
		      loginButton.setBounds(154, 255, 166, 20);
		      loginButton.setBorderPainted(false);
		      loginButton.setContentAreaFilled(false);
		      loginButton.setFocusPainted(false);
		      loginButton.addMouseListener(new MouseAdapter() {
		         @Override

		         public void mouseEntered(MouseEvent e) {
		        	 loginButton.setIcon(loginBtClick);
		        	 loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		        
		         
	
		         
		         }

		         @Override
		         public void mouseExited(MouseEvent e) {
		        	 loginButton.setIcon(loginBtBasic);
		        	 loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		         }

		         @Override
		         public void mousePressed(MouseEvent e) {
		        	 Scanner sc = new Scanner(System.in);  
		        	 try {
		 				sc = new Scanner(new File("user_info.txt"));
		 			} catch (FileNotFoundException e1) {e1.printStackTrace();}
		 		      int i=0,j=0;
		 		      while (sc.hasNext()) {
		 		            String word = sc.next();
		 		            array[i][j++] = word;
		 		            word = sc.next();
		 		            array[i][j++] = word;
		 		            word = sc.next();
		 		            array[i][j] = word;
		 		            i++;j=0;
		 		           
		 		         }
		 		      
		 		      
		        	  ID = id_text.getText();
				      PW = pw_text.getText();
				      
				      boolean succed = false;
				      
				      for(int w=0;array[w][0]!=null;w++)
				      {	    	  
				    	  if(array[w][0].equals(ID)&&array[w][1].equals(PW))
				    	  //if(array[w][0]==ID&&array[w][1]==PW)

				    	  {
				    		  
				    		  Name=array[w][2];
				    			  //로그인 성공
				    			  succed = true;
				    			  break;
 
				    	  }
				    	
				      }
				      
				      if(succed == true)
				      {
	//////// //////////////////////////////////////////////////로그인 성공!
				    	  
//				    	  user.ID = ID;
//				    	  user.PW= PW;
//				    	 user.Name = Name;
				  
				    	  
				    	  user = new User(ID,PW,Name);
				    	  new Succed_login();
				    	  signinButton.setVisible(false);
				    	  loginButton.setVisible(false);
				    	  id_text.setVisible(false);
				    	  pw_text.setVisible(false);
				    	  dispose();
				    	  
				    	  try {
							Main.send(Login.socket,buffer);
							//Main.receive(socket,user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    	  try {
							ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
							 rt = new ReceiveDataThread(Login.socket,is,user);
				    	  } catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 

							
							//socket.close();
						  new MyPage(socket,user);
						
				    
				    	  
				      }
				      else {
				    	  	new Error_login();}

		         }

		      });
		      add( loginButton);
		      
		      
		      signinButton.setBounds(270, 285, 40, 20);
		      signinButton.setBorderPainted(false);
		      signinButton.setContentAreaFilled(false);
		      signinButton.setFocusPainted(false);
		      signinButton.addMouseListener(new MouseAdapter() {
		         @Override

		         public void mouseEntered(MouseEvent e) {
		        	 signinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		         }

		         @Override
		         public void mouseExited(MouseEvent e) {

		        	 signinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		         }

		         @Override
		         public void mousePressed(MouseEvent e) {
		        	 new Signin();

		         }

		      });
		      add( signinButton);
		      
		      
		      
		      
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
	/*   
	   private void initNet(String ip, int port) {
		   try {
			socket = new Socket(ip,port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Thread thread = new Thread(this);
		   thread.start();
	   }

	
}*/



	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Server.load(user);
	}	   
	 
}
