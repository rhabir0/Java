import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import Classes.*;
import java.util.*;

public class userPanel extends JFrame implements ActionListener
{ 
  private JPanel panel;
  private JLabel unameLabel,unoLabel,EmailLabel,WelcomeLabel,monthName;
  private JLabel unameTF,unoTF,EmailTF;
  private JButton logoutbttn,showBillbttn;
  private JComboBox combo;
  private String userName,ID,Mail;
  
  userPanel(String userName, String ID,String Mail){
        super("Electrcity Billing v1.00");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userName=userName;
		this.ID=ID;
		this.Mail=Mail;
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Arial", Font.BOLD,14);
		
		WelcomeLabel=new JLabel("Welcome to EBilling!! ", SwingConstants.CENTER );
		WelcomeLabel.setBounds(10,10,300,40);
		WelcomeLabel.setForeground(new Color(255,255,255));
		WelcomeLabel.setBackground(new Color(102,187,102));
		WelcomeLabel.setOpaque(true);
		WelcomeLabel.setFont(new Font("Italic",Font.BOLD,24));
		panel.add(WelcomeLabel);
      	
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
		
		monthName=new JLabel("Month", SwingConstants.CENTER);
		monthName.setBounds(10,230,150,30);
		monthName.setForeground(new Color(255,255,255));
		monthName.setBackground(new Color(0,0,0));
		monthName.setOpaque(true);
		monthName.setFont(font);
		panel.add(monthName);
		
		unameTF=new JLabel(userName, SwingConstants.CENTER );
		unameTF.setBounds(160,80,200,30);
		unameTF.setForeground(new Color(0,0,0));
		unameTF.setBackground(new Color(211,211,211));
		unameTF.setOpaque(true);
		unameTF.setFont(font);
		panel.add(unameTF);
		
		unoTF=new JLabel(ID, SwingConstants.CENTER);
		unoTF.setBounds(160,130,200,30);
		unoTF.setForeground(new Color(0,0,0));
		unoTF.setBackground(new Color(211,211,211));
		unoTF.setOpaque(true);
		unoTF.setFont(font);
		panel.add(unoTF);
		
		EmailTF=new JLabel(Mail, SwingConstants.CENTER);
		EmailTF.setBounds(160,180,200,30);
		EmailTF.setForeground(new Color(0,0,0));
		EmailTF.setBackground(new Color(211,211,211));
		EmailTF.setOpaque(true);
		EmailTF.setFont(font);
		panel.add(EmailTF);
		
		logoutbttn= new JButton("Sign Out");
		logoutbttn.setBounds(350,400,130,30);
		logoutbttn.setBackground(new Color(0,0,0));
		logoutbttn.setForeground(new Color(255,255,255));
		logoutbttn.addActionListener(this);
		panel.add(logoutbttn);
		
		showBillbttn= new JButton("Show Bill");
		showBillbttn.setBounds(80,400,130,30);
		showBillbttn.setBackground(new Color(0,0,0));
		showBillbttn.setForeground(new Color(255,255,255));
		showBillbttn.addActionListener(this);
		panel.add(showBillbttn);
		
		String items[] = {"January", "February", "March", "April", "May","June","July","August","September","October","November","December",};
		combo = new JComboBox(items);
		combo.setBounds(160,230,200,30);
		panel.add(combo);
		
		this.add(panel);
    }
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==showBillbttn)
		{
			try{
				boolean flag=false;
				File file=new File("ElectricBill.txt");
				Scanner scanner= new Scanner(file);
				String Month=combo.getSelectedItem().toString();
				while(scanner.hasNext()){
					String UserName=scanner.next();
					String UserID=scanner.next();
					String MeterNo=scanner.next();
					String HolderName=scanner.next();
					String Units=scanner.next();
					String Bill=scanner.next();
					String MonthF=scanner.next();
					if(userName.equals(UserName) & ID.equals(UserID) & Month.equals(MonthF)){
						int userid=Integer.parseInt(UserID);
				        int meternumber=Integer.parseInt(MeterNo);
				        double meterReading=Double.parseDouble(Units);
				        double bill=Double.parseDouble(Bill);
						flag=true;
						
						Bill obj=new Bill(UserName,userid,meternumber,HolderName,meterReading,bill,MonthF);
						obj.setVisible(true);
						this.setVisible(false);
						
					}
				}
				
			  if(flag==false){JOptionPane.showMessageDialog(null,"Bill not placed");}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		
		else if(ae.getSource()==logoutbttn)
		{
			login fi = new login();
		    fi.setVisible(true);
			this.setVisible(false);
		}
	}

}