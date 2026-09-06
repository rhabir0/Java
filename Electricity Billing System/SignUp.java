import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import Classes.*;
import java.util.*;

public class SignUp extends JFrame implements ActionListener
{ 
	private JPanel panel;
    private JLabel unameLabel,unoLabel,EmailLabel,passwordLabel,securityQLabel,signupLabel,label1,imgLabel,titleLabel;
	private JTextField unameTF,unoTF,EmailTF,AnswerTF;
	private JButton signUpbttn,goBackbttn;
	private JComboBox combo;
    private Font font;
	private JPasswordField passPF;
	private JCheckBox showkey;
	private ImageIcon Billicon,eyeShowIcon,eyeHideIcon;
	
	SignUp(){    
		super("Electrcity Billing v1.00");
		this.setSize(780,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Italic", Font.BOLD,14);
		Font font2 = new Font("Mongolian Baiti", Font.BOLD,32);
		
		titleLabel=new JLabel("Pay Your Bill!!!");
		
		signupLabel=new JLabel("Sign Up!");
		signupLabel.setBounds(540,285,200,30);
		signupLabel.setForeground(new Color(0,0,0));
		signupLabel.setBackground(new Color(204,255,204));
		signupLabel.setOpaque(true);
		signupLabel.setFont(font2);
		panel.add(signupLabel);
		
		unameLabel=new JLabel("User Name  ", SwingConstants.CENTER );
		unameLabel.setBounds(10,80,150,30);
		unameLabel.setForeground(new Color(255,255,255));
		unameLabel.setBackground(new Color(0,0,0));
		unameLabel.setOpaque(true);
		unameLabel.setFont(font);
		panel.add(unameLabel);
		
		unoLabel=new JLabel("User ID  ", SwingConstants.CENTER);
		unoLabel.setBounds(10,130,150,30);
		unoLabel.setForeground(new Color(255,255,255));
		unoLabel.setBackground(new Color(0,0,0));
		unoLabel.setOpaque(true);
		unoLabel.setFont(font);
		panel.add(unoLabel);
		
		EmailLabel=new JLabel("Email", SwingConstants.CENTER);
		EmailLabel.setBounds(10,180,150,30);
		EmailLabel.setForeground(new Color(255,255,255));
		EmailLabel.setBackground(new Color(0,0,0));
		EmailLabel.setOpaque(true);
		EmailLabel.setFont(font);
		panel.add(EmailLabel);
		
		passwordLabel=new JLabel("Enter Password", SwingConstants.CENTER);
		passwordLabel.setBounds(10,230,150,30);
		passwordLabel.setForeground(new Color(255,255,255));
	    passwordLabel.setBackground(new Color(0,0,0));
		passwordLabel.setOpaque(true);
		passwordLabel.setFont(font);
		panel.add(passwordLabel);
		
	    securityQLabel=new JLabel("Security Questions", SwingConstants.CENTER);
		securityQLabel.setBounds(10,280,150,30);
		securityQLabel.setForeground(new Color(255,255,255));
	    securityQLabel.setBackground(new Color(0,0,0));
		securityQLabel.setOpaque(true);
		securityQLabel.setFont(font);
		panel.add(securityQLabel);
		
		/*label1=new JLabel();
		label1.setBounds(420,10,5,500);
		label1.setForeground(new Color(255,255,255));
		label1.setBackground(new Color(0,0,0));
		label1.setOpaque(true);
		label1.setFont(font);
		panel.add(label1);*/
		
		unameTF= new JTextField();
		unameTF.setBounds(170,80,200,30);
		unameTF.setFont(font);
		panel.add(unameTF);
		
		unoTF= new JTextField();
		unoTF.setBounds(170,130,200,30);
		unoTF.setFont(font);
		panel.add(unoTF);
		
		EmailTF= new JTextField();
		EmailTF.setBounds(170,180,200,30);
		EmailTF.setFont(font);
		panel.add(EmailTF);
		
		passPF= new JPasswordField();
		//passPF.setEchoChar('*');
		passPF.setBounds(170,230,200,30);
		passPF.setFont(font);
		panel.add(passPF);

		
		String items[] = {"What is your nick name?","Favorite pet?","Favorite anime?"};
		combo = new JComboBox(items);
		combo.setBounds(170,280,200,30);
		panel.add(combo);
		
		AnswerTF=new JTextField();
		AnswerTF.setBounds(170,330,200,30);
		AnswerTF.setFont(font);
		panel.add(AnswerTF);
		
		/*Icon showPassicon=new ImageIcon("showPass.png");
		showPassbttn=new JButton(showPassicon);
		showPassbttn.setBounds(370,230,30,30);
		showPassbttn.addActionListener(this);
		panel.add(showPassbttn);*/
		
		signUpbttn = new JButton("Sign Up");
	    signUpbttn.setBounds(200,380,120,50);
		signUpbttn.setBackground(new Color(0,0,0));
		signUpbttn.setForeground(new Color(255,255,255));
		signUpbttn.addActionListener(this);
		panel.add(signUpbttn);
		
	    goBackbttn = new JButton("Go Back");
	    goBackbttn.setBounds(400,380,120,50);
		goBackbttn.setBackground(new Color(0,0,0));
		goBackbttn.setForeground(new Color(255,255,255));
		goBackbttn.addActionListener(this);
		panel.add(goBackbttn);
		
		Billicon = new ImageIcon(getClass().getResource("Billicon.png"));
		imgLabel= new JLabel(Billicon);
		imgLabel.setBounds(500,80,200,200);
		panel.add(imgLabel);
		
		eyeHideIcon=new ImageIcon("hide.png");
		eyeShowIcon=new ImageIcon("showPass.png");
		
		showkey= new JCheckBox();
		showkey.setIcon(eyeShowIcon);
		showkey.setSelectedIcon(eyeHideIcon);
		showkey.setBackground(new Color(204,255,204));
		showkey.setBounds(370,230,30,30);
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
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==signUpbttn)
		{       
	           boolean created=false;
			   String u1=unameTF.getText();  
			   String u2=unoTF.getText();  
			   String u3=EmailTF.getText();  
			   String u4=passPF.getText();
			   String u5=AnswerTF.getText();
			   try{
			       
			       File file=new File("User.txt");
			       Scanner scanner= new Scanner(file);
			       while(scanner.hasNext()){
					  String name= scanner.next();
			          String id=scanner.next();
			              if(name.equals(u1) & id.equals(u2)){
	                         try{
			                      File file2 = new File("loginInfo.txt");
			                      FileReader fr = new FileReader("loginInfo.txt");
			                      BufferedReader br=new BufferedReader(fr);
			                     if(br.readLine()==null){
                                     FileWriter fw= new FileWriter(file2.getName(),true);
			                         BufferedWriter bw= new BufferedWriter(fw);
			                         bw.write(u1+" "+u2+" "+u3+" "+u4+" "+u5+" ");
			                         bw.newLine();
			                         bw.close();
			                         fw.close();
			                        }
			                         FileWriter fw= new FileWriter(file2.getName(),true);
			                         BufferedWriter bw= new BufferedWriter(fw);
			                         bw.write(u1+" "+u2+" "+u3+" "+u4+" "+u5+" ");
			                         bw.newLine();
			                         bw.close();
			                         fw.close();
			                    }
			                   catch(Exception ex){
				                 ex.printStackTrace();
			                    }
			                     JOptionPane.showMessageDialog(null,"Account Created!");
								 created=true;
								 break;
				            }
					        else{continue;}
							   
					}
				  if(created==false){JOptionPane.showMessageDialog(null,"You are not registered as an user!");}
			    }
			    catch(Exception ex){
				System.out.println(ex);
		        }
				
	    }
        
		else if(ae.getSource()==goBackbttn)
		{
		  login fi = new login();
		  fi.setVisible(true);
		  this.setVisible(false);
		}
	   
	}	

    public static void main(String args[]){
		SignUp s=new SignUp();
		s.setVisible(true);
	}	

}
