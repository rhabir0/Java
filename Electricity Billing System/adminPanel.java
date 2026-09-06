import java.lang.*;
import javax.swing.*;
import java.awt.*;
//import java.awt.Container;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.io.*;
import Classes.*;
import java.util.*;


public class adminPanel extends JFrame implements ActionListener
{ 
    private JPanel panel;
    private JLabel label1;
	private JButton RegiseterNewUser,InsertMeter,GetBill;
    private Font font;
	
	private String[] columns={"User Name","User ID"};
	private String[]  rows= new String[2];
	
	adminPanel(){
		super("Electrcity Billing v1.00");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Italic", Font.BOLD,14);
		
		label1=new JLabel("WELCOME TO E-Bill Management", SwingConstants.CENTER );
		label1.setBounds(40,20,400,30);
		label1.setForeground(new Color(255,255,255));
		label1.setBackground(new Color(0,0,0));
		label1.setOpaque(true);
		label1.setFont(font);
		panel.add(label1);
		
		RegiseterNewUser = new JButton("Register User");
	    RegiseterNewUser.setBounds(40,250,150,30);
		RegiseterNewUser.setFont(font);
		RegiseterNewUser.setForeground(new Color(255,255,255));
		RegiseterNewUser.setBackground(new Color(156, 158, 254));
		RegiseterNewUser.addActionListener(this);
		panel.add(RegiseterNewUser);
		
	    InsertMeter = new JButton("Insert Meter");
	    InsertMeter.setBounds(250,250,150,30);
		InsertMeter.setFont(font);
		InsertMeter.setForeground(new Color(255,255,255));
		InsertMeter.setBackground(new Color(156, 158, 254));
		InsertMeter.setToolTipText("You have to register an user first");
		InsertMeter.addActionListener(this);
		panel.add(InsertMeter);
		
		GetBill = new JButton("Get Bill");
	    GetBill.setBounds(150,300,150,30);
		GetBill.setFont(font);
		GetBill.setForeground(new Color(255,255,255));
		GetBill.setBackground(new Color(156, 158, 254));
		GetBill.addActionListener(this);
		panel.add(GetBill);
		
		this.add(panel);
	}	
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() ==RegiseterNewUser)
			{
				FUserRegister u1= new FUserRegister();
				u1.setVisible(true);
				this.setVisible(false);
			}
			else if (e.getSource()==InsertMeter)
			{
			 String userid=JOptionPane.showInputDialog(null,"Enter User ID ","User Validation",JOptionPane.QUESTION_MESSAGE);
			 try{
				boolean flag=false;
				File file=new File("User.txt");
				Scanner scanner= new Scanner(file);
				while(scanner.hasNext()){
					String name= scanner.next();
					String id=scanner.next();
					if(id.equals(userid))
					{
						MeterInfo m1= new MeterInfo();
						m1.setVisible(true);
						this.setVisible(false);
						flag=true;
						break;
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
			
			else if(e.getSource()==GetBill){
				getBill obj= new getBill();
				obj.setVisible(true);
				this.setVisible(false);
			}
		}
		
		
	
		
		public static void main(String args[])
		{
			adminPanel us= new adminPanel();
			us.setVisible(true);
		}
	

}