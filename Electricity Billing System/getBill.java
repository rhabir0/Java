
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import Classes.*;
import java.util.*;

public class getBill extends JFrame implements ActionListener
{ 
  private JPanel panel;
  private JLabel unameLabel,unoLabel,WelcomeLabel,monthName;
  private JTextField unameTF,unoTF;
  private JButton billbttn,goBackbttn;
  private JComboBox combo;
  
  getBill(){
        super("Electrcity Billing v1.00");
		this.setSize(400,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Arial", Font.BOLD,14);
		
		WelcomeLabel=new JLabel("Get Bill Slip!! ", SwingConstants.CENTER );
		WelcomeLabel.setBounds(10,10,350,40);
		WelcomeLabel.setForeground(new Color(255,255,255));
		WelcomeLabel.setBackground(new Color(156,158,254));
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
		
        monthName=new JLabel("Month", SwingConstants.CENTER);
		monthName.setBounds(10,180,150,30);
		monthName.setForeground(new Color(255,255,255));
		monthName.setBackground(new Color(0,0,0));
		monthName.setOpaque(true);
		monthName.setFont(font);
		panel.add(monthName);
		
		unameTF=new JTextField();
		unameTF.setBounds(160,80,200,30);
		unameTF.setFont(font);
		panel.add(unameTF);
		
		unoTF=new JTextField();
		unoTF.setBounds(160,130,200,30);
        unoTF.setFont(font);
		panel.add(unoTF);
		
		String items[] = {"January", "February", "March", "April", "May","June","July","August","September","October","November","December",};
		combo = new JComboBox(items);
		combo.setBounds(160,180,200,30);
		panel.add(combo);
		
		billbttn= new JButton("Get Bill");
	    billbttn.setBounds(20,250,150,30);
		billbttn.setFont(font);
		billbttn.setForeground(new Color(255,255,255));
		billbttn.setBackground(new Color(156, 158, 254));
		billbttn.addActionListener(this);
		panel.add(billbttn);
		
	    goBackbttn= new JButton("Go Back");
	    goBackbttn.setBounds(190,250,150,30);
		goBackbttn.setFont(font);
		goBackbttn.setForeground(new Color(255,255,255));
		goBackbttn.setBackground(new Color(156, 158, 254));
		goBackbttn.addActionListener(this);
		panel.add(goBackbttn);
		
		this.add(panel);
    }
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==billbttn)
		{   
            boolean flag=false;	
			String s1=unameTF.getText();  
			String s2=unoTF.getText();
			String s3=combo.getSelectedItem().toString();
			try{
				File file=new File("GetElectricBill.txt");
			    Scanner scanner= new Scanner(file);
				
				while(scanner.hasNext()){
				   String name= scanner.next();
			       String id=scanner.next();
			       String meterNumber=scanner.next();
			       String holderName=scanner.next();
			       String meterReading=scanner.next();
			       String unit=scanner.next();
			       String month=scanner.next();
			       String bill=scanner.next();
			       String paid=scanner.next();
				   
				   if(name.equals(s1) & id.equals(s2) & month.equals(s3)){
						String meterRead=meterReading+unit;
						String billamount=bill+paid;
						
						paySlip obj=new paySlip(name,id,meterNumber,holderName,meterRead,billamount,month);
						obj.setVisible(true);
						this.setVisible(false);
						flag=true;
					}
				 else{continue;}
				   
				}
			}
			catch(Exception ex){
				System.out.println(ex);
			}
			if(flag==false){JOptionPane.showMessageDialog(null,"Bill not found");}
			
		}
		
		else if(ae.getSource()==goBackbttn)
		{
			adminPanel a1=new adminPanel();
			a1.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String args[]){
		getBill eb=new getBill();
		eb.setVisible(true);
		
	}

}