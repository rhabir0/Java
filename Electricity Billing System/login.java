import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import Classes.*;
import java.util.*;


public class login extends JFrame implements ActionListener{
	JLabel userLabel, passLabel,imgLabel,design;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn,signUpbttn;
	JPanel panel;
	Font myfont;
	ImageIcon icon,img,logo,eyeShowIcon,eyeHideIcon;
	JCheckBox showkey;
	Container c;
	
	public login(){
		super("Electrcity Billing v1.00");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
	    initComponents();	
	    
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font myfont = new Font("Italic", Font.BOLD,14);
		
		JLabel userLabel = new JLabel("User ID: ", SwingConstants.CENTER);
		userLabel.setBounds(50,250,100,30);
		userLabel.setForeground(new Color(255,255,255));
		userLabel.setBackground(new Color(0,0,0));
		userLabel.setOpaque(true);
		userLabel.setFont(myfont);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(160,250,350,30);
		panel.add(userTF);
		
		JLabel passLabel = new JLabel("Password : ", SwingConstants.CENTER);
		passLabel.setBounds(50,290,100,30);
		passLabel.setForeground(new Color(255,255,255));
		passLabel.setBackground(new Color(0,0,0));
		passLabel.setOpaque(true);
		passLabel.setFont(myfont);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(160,290,350,30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		/*exitBtn = new JButton("Exit");
		exitBtn.setBounds(130, 130, 80, 30);
		exitBtn.setBackground(new Color(0,0,0));
		exitBtn.setForeground(new Color(255,255,255));
		exitBtn.addActionListener(this);
		panel.add(exitBtn);*/
		
		loginBtn = new JButton("Sign in");
		loginBtn.setBounds(100,350,130,30);
		loginBtn.setBackground(new Color(0,0,0));
		loginBtn.setForeground(new Color(255,255,255));
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		signUpbttn= new JButton("Sign up");
		signUpbttn.setBounds(340,350,130,30);
		signUpbttn.setBackground(new Color(0,0,0));
		signUpbttn.setForeground(new Color(255,255,255));
		signUpbttn.addActionListener(this);
		panel.add(signUpbttn);
		
		
        eyeHideIcon=new ImageIcon("hide.png");
		eyeShowIcon=new ImageIcon("showPass.png");
		
		showkey= new JCheckBox();
		showkey.setIcon(eyeShowIcon);
		showkey.setSelectedIcon(eyeHideIcon);
		showkey.setBackground(new Color(204,255,204));
		showkey.setBounds(510,290,30,30);
		panel.add(showkey);
        showkey.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a)
			{
				if(showkey.isSelected())
				{
					passPF.setEchoChar((char)0);
					passPF.requestFocus();
				}
				else{
					passPF.setEchoChar('*');
				}
			}
		});
		
		
		/*img = new ImageIcon("background.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,500,400);
		panel.add(imgLabel);*/
		
		logo = new ImageIcon(getClass().getResource("bill.png"));
		design= new JLabel("",logo,design.RIGHT);
		design.setBounds(200,30,200,200);
		panel.add(design);
		
		this.add(panel);
		
		
	}
	
	public void initComponents(){
		
		//setting frameicon
		icon= new ImageIcon(getClass().getResource("icon.png"));
		this.setIconImage(icon.getImage());
		
		/*adding the logo as image
		logo = new ImageIcon(getClass().getResource("bill.png"));
		c=this.getContentPane();
	    c.setLayout(null);
		design= new JLabel("E-BILL",logo,design.RIGHT);
		design.setBounds(300,50,100,100);
		c.add(design);*/
	}
	
	public void actionPerformed(ActionEvent e){
		//storing the data of textfield
		String s1=userTF.getText();
		String s2=passPF.getText();
		String s3="admin";
		String s4="pass";
		
	
	 if( e.getSource() == loginBtn ){
		 boolean flag=false;
		if(s1.equals(s3) || s2.equals(s4))//For admin login and adminpanel
		{
			adminPanel u2= new adminPanel();
			u2.setVisible(true);
			this.setVisible(false);
			flag=true;
		}
		try{//checking the users created accounts and userpanel
			
		    File file=new File("LoginInfo.txt");
			Scanner scanner= new Scanner(file);
			while(scanner.hasNext()){
				String name= scanner.next();
			    String id=scanner.next();
				String userMail=scanner.next();
				String password=scanner.next();
				String SecurityAns=scanner.next();
				
				//System.out.println(name+""+id+""+""+userMail);
				if(id.equals(s1) & password.equals(s2))
				{
					//JOptionPane.showMessageDialog(null,"Login successfull!");
					userPanel obj= new userPanel(name,id,userMail);
					obj.setVisible(true);
					this.setVisible(false);
					flag=true;
				}
				else{continue;}
			}
			scanner.close();
			if(flag==false){JOptionPane.showMessageDialog(null,"Invalid user");}
		}
		
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	 }
	   
      else if(e.getSource() == signUpbttn)
	  {
		  SignUp obj=new SignUp();
		  obj.setVisible(true);
		  this.setVisible(false);
	  }  
	}
	
}
		
	

	
