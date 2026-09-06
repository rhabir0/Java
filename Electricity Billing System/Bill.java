import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import Classes.*;
import java.util.*;

public class Bill extends JFrame implements ActionListener 
{ 
    private JPanel panel2;
    private JLabel unameLabel,unoLabel,meternoLabel,meterHolderLabel,meterReadingLabel,BillLabel,MonthLabel;
	private JLabel unameTF,unoTF,meternoTF,meterHolderTF,meterReadingTF,Bill,monthName;
	private JButton gobackbttn,SendBillbttn;
    private Font font;
	private String userName,HolderName,Month;
	private int MeterNum,UserId;
	private double MeterReading,bill;
	
	Bill(String userName, int UserId, int MeterNum,String HolderName,double MeterReading, double bill,String Month){
		super("Electrcity Billing v1.00");
		this.setSize(600,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.userName=userName;
		this.UserId=UserId;
		this.MeterNum=MeterNum;
		this.HolderName=HolderName;
		this.MeterReading=MeterReading;
		this.bill=bill;
		this.Month=Month;
		
		String ID=String.valueOf(UserId);
		String meterNo=String.valueOf(MeterNum);
		String meter_read=String.valueOf(MeterReading);
		String Billamount=String.valueOf(bill);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(204,255,204));
		Font font = new Font("Italic", Font.BOLD,14);
		
		unameLabel=new JLabel("User Name  ", SwingConstants.CENTER );
		unameLabel.setBounds(10,80,140,30);
		unameLabel.setForeground(new Color(255,255,255));
		unameLabel.setBackground(new Color(0,0,0));
		unameLabel.setOpaque(true);
		unameLabel.setFont(font);
		panel2.add(unameLabel);
		
		unoLabel=new JLabel("User ID  ", SwingConstants.CENTER);
		unoLabel.setBounds(10,130,140,30);
		unoLabel.setForeground(new Color(255,255,255));
		unoLabel.setBackground(new Color(0,0,0));
		unoLabel.setOpaque(true);
		unoLabel.setFont(font);
		panel2.add(unoLabel);
		
		meternoLabel=new JLabel("Meter No ", SwingConstants.CENTER);
		meternoLabel.setBounds(10,180,140,30);
		meternoLabel.setForeground(new Color(255,255,255));
		meternoLabel.setBackground(new Color(0,0,0));
		meternoLabel.setOpaque(true);
		meternoLabel.setFont(font);
		panel2.add(meternoLabel);
		
		meterHolderLabel=new JLabel("Meter Holder", SwingConstants.CENTER);
		meterHolderLabel.setBounds(10,230,140,30);
		meterHolderLabel.setForeground(new Color(255,255,255));
		meterHolderLabel.setBackground(new Color(0,0,0));
		meterHolderLabel.setOpaque(true);
		meterHolderLabel.setFont(font);
		panel2.add(meterHolderLabel);
		
		meterReadingLabel=new JLabel("MeterReading", SwingConstants.CENTER);
		meterReadingLabel.setBounds(10,280,140,30);
		meterReadingLabel.setForeground(new Color(255,255,255));
		meterReadingLabel.setBackground(new Color(0,0,0));
		meterReadingLabel.setOpaque(true);
		meterReadingLabel.setFont(font);
		panel2.add(meterReadingLabel);
		
		BillLabel=new JLabel("Bill", SwingConstants.CENTER);
		BillLabel.setBounds(10,320,140,30);
		BillLabel.setForeground(new Color(255,255,255));
		BillLabel.setBackground(new Color(0,0,0));
		BillLabel.setOpaque(true);
		BillLabel.setFont(font);
		panel2.add(BillLabel);
		
		MonthLabel=new JLabel("Month", SwingConstants.CENTER);
		MonthLabel.setBounds(10,370,140,30);
		MonthLabel.setForeground(new Color(255,255,255));
		MonthLabel.setBackground(new Color(0,0,0));
		MonthLabel.setOpaque(true);
		MonthLabel.setFont(font);
		panel2.add(MonthLabel);
		
		
		unameTF=new JLabel(userName, SwingConstants.CENTER );
		unameTF.setBounds(160,80,200,30);
		unameTF.setForeground(new Color(0,0,0));
		unameTF.setBackground(new Color(211,211,211));
		unameTF.setOpaque(true);
		unameTF.setFont(font);
		panel2.add(unameTF);
		
		unoTF=new JLabel(ID, SwingConstants.CENTER);
		unoTF.setBounds(160,130,200,30);
		unoTF.setForeground(new Color(0,0,0));
		unoTF.setBackground(new Color(211,211,211));
		unoTF.setOpaque(true);
		unoTF.setFont(font);
		panel2.add(unoTF);
		
		meternoTF=new JLabel(meterNo, SwingConstants.CENTER);
		meternoTF.setBounds(160,180,200,30);
		meternoTF.setForeground(new Color(0,0,0));
		meternoTF.setBackground(new Color(211,211,211));
		meternoTF.setOpaque(true);
		meternoTF.setFont(font);
		panel2.add(meternoTF);
		
		meterHolderTF=new JLabel(HolderName, SwingConstants.CENTER);
		meterHolderTF.setBounds(160,230,200,30);
		meterHolderTF.setForeground(new Color(0,0,0));
		meterHolderTF.setBackground(new Color(211,211,211));
		meterHolderTF.setOpaque(true);
		meterHolderTF.setFont(font);
		panel2.add(meterHolderTF);
		
		meterReadingTF=new JLabel(meter_read+" (Unit)", SwingConstants.CENTER);
		meterReadingTF.setBounds(160,280,200,30);
		meterReadingTF.setForeground(new Color(0,0,0));
		meterReadingTF.setBackground(new Color(211,211,211));
		meterReadingTF.setOpaque(true);
		meterReadingTF.setFont(font);
		panel2.add(meterReadingTF);
		
		Bill=new JLabel(Billamount+" tk", SwingConstants.CENTER);
		Bill.setBounds(160,320,200,30);
		Bill.setForeground(new Color(0,0,0));
		Bill.setBackground(new Color(211,211,211));
		Bill.setOpaque(true);
		Bill.setFont(font);
		panel2.add(Bill);
		
		monthName=new JLabel(Month, SwingConstants.CENTER);
		monthName.setBounds(160,370,200,30);
		monthName.setForeground(new Color(0,0,0));
		monthName.setBackground(new Color(211,211,211));
		monthName.setOpaque(true);
		monthName.setFont(font);
		panel2.add(monthName);
		
		gobackbttn= new JButton("Go Back");
	    gobackbttn.setBounds(200,450,100,30);
		gobackbttn.setFont(font);
        gobackbttn.addActionListener(this);
		panel2.add(gobackbttn);
		
		SendBillbttn= new JButton("Pay");
	    SendBillbttn.setBounds(350,450,100,30);
		SendBillbttn.setFont(font);
        SendBillbttn.addActionListener(this);
		panel2.add(SendBillbttn);
		
		this.add(panel2);
	}
    
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==gobackbttn)
		{    
            try{//checking the users created accounts and userpanel
			
		        File file=new File("LoginInfo.txt");
			    Scanner scanner= new Scanner(file);
			    while(scanner.hasNext()){
				String name= scanner.next();
			    String id=scanner.next();
				String userMail=scanner.next();
				String pass=scanner.next();
				String Sequrityans=scanner.next();
				
				String ID=String.valueOf(UserId);
				
				if(userName.equals(name) & ID.equals(id))
				{
					//JOptionPane.showMessageDialog(null,"Login successfull!");
					userPanel obj= new userPanel(name,id,userMail);
					obj.setVisible(true);
					this.setVisible(false);
					
				}
				else{continue;}
			    }
			}	
			
		  catch(Exception ex)
		    {
			System.out.println(ex);
		    }
		}
		
		 /*if(a.getSource()==SendBillbttn){
			try{
				File file2 = new File("ElectricBill.txt");
			    FileReader fr = new FileReader("ElectricBill.txt");
			    BufferedReader br=new BufferedReader(fr);
				if(br.readLine()==null){
					FileWriter fw= new FileWriter(file2.getName(),true);
					BufferedWriter bw= new BufferedWriter(fw);
					
					String ID=String.valueOf(UserId);
		            String meterNo=String.valueOf(MeterNum);
		            String meter_read=String.valueOf(MeterReading);
		            String Billamount=String.valueOf(bill);
					
					bw.write(userName+" "+ID+" "+meterNo+" "+HolderName+" "+meter_read+" "+Billamount+" "+Month);
			        bw.newLine();
					bw.close();
			        fw.close();
				}
				else{
				FileWriter fw= new FileWriter(file2.getName(),true);
				BufferedWriter bw= new BufferedWriter(fw);
				
				String ID=String.valueOf(UserId);
		        String meterNo=String.valueOf(MeterNum);
		        String meter_read=String.valueOf(MeterReading);
		        String Billamount=String.valueOf(bill);
				
				bw.write(userName+" "+ID+" "+meterNo+" "+HolderName+" "+meter_read+" "+Billamount+" "+Month);
			    bw.newLine();
			    //bw.write("------------------------------------------------------");
			    bw.close();
			    fw.close();
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}*/
		
		else if(a.getSource()==SendBillbttn)
		{
			try{
				String input=JOptionPane.showInputDialog(null,"Enter the amount ","Payment",JOptionPane.QUESTION_MESSAGE);
				double amount=Double.parseDouble(input);
			    if(amount==bill)
				{
					JOptionPane.showMessageDialog(null,"Bill Paid");
					String Billamount=String.valueOf(bill);
					Bill.setText(Billamount+"tk (PAID!!!)");
					
					String u1=unameTF.getText();
					String u2=unoTF.getText();
					String u3=meternoTF.getText();
					String u4=meterHolderTF.getText();
					String u5=meterReadingTF.getText();
					String u6=monthName.getText();
					String u7=Bill.getText();
					
					try{
					   File file2 = new File("GetElectricBill.txt");
			           FileReader fr = new FileReader("GetElectricBill.txt");
			           BufferedReader br=new BufferedReader(fr);
			           if(br.readLine()==null){
                          FileWriter fw= new FileWriter(file2.getName(),true);
			              BufferedWriter bw= new BufferedWriter(fw);
			              bw.write(u1+" "+u2+" "+u3+" "+u4+" "+u5+" "+u6+" "+u7);
			              bw.newLine();
			              bw.close();
			              fw.close();
					    }
						FileWriter fw= new FileWriter(file2.getName(),true);
			            BufferedWriter bw= new BufferedWriter(fw);
			            bw.write(u1+" "+u2+" "+u3+" "+u4+" "+u5+" "+u6+" "+u7);
			            bw.newLine();
			            bw.close();
			            fw.close();
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please pay the amount mentioned");
				}	
			}
			catch(InputMismatchException ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid input");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid input");
			}
		}
	}
	
}