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


public class MeterInfo extends JFrame implements ActionListener
{   
    private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel;
    private JLabel introLabel,unameLabel,unoLabel,meternoLabel,meterHolderLabel,meterReadingLabel,MonthLabel;
	private JTextField unameTF,unoTF,meternoTF,meterHolderTF,meterReadingTF;
	private JButton addbttn,Detailsbttn,deletebttn,clearbttn,savebttn,importbttn,GoBackbttn;
	private JComboBox combo;
    private Font font;
	//private ElectricityBill b1;
	private NESCO n1;
	
	private String[] columns={"User Name","User ID","Meter No.","Meter Holder","Meter Reading","Month"};
	private String[]  rows= new String[6];

  MeterInfo(){
	  	super("Electrcity Billing v1.00");
		this.setSize(780,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Italic", Font.BOLD,14);
		
		introLabel=new JLabel("Manage Electric Bills", SwingConstants.CENTER );
		introLabel.setBounds(250,20,250,55);
		introLabel.setForeground(new Color(255,255,255));
		introLabel.setBackground(new Color(0,0,0));
		introLabel.setOpaque(true);
		introLabel.setFont(new Font("Mongolian Baiti", Font.BOLD,24));
		panel.add(introLabel);
		
		unameLabel=new JLabel("User Name  ", SwingConstants.CENTER );
		unameLabel.setBounds(10,80,140,30);
		unameLabel.setForeground(new Color(255,255,255));
		unameLabel.setBackground(new Color(0,0,0));
		unameLabel.setOpaque(true);
		unameLabel.setFont(font);
		panel.add(unameLabel);
		
		unameTF= new JTextField();
		unameTF.setBounds(160,80,200,30);
		unameTF.setFont(font);
		panel.add(unameTF);
		
		addbttn= new JButton("ADD");
		addbttn.setBounds(400,80,100,30);
		addbttn.setFont(font);
		addbttn.addActionListener(this);
		panel.add(addbttn);
		
		unoLabel=new JLabel("User ID  ", SwingConstants.CENTER);
		unoLabel.setBounds(10,130,140,30);
		unoLabel.setForeground(new Color(255,255,255));
		unoLabel.setBackground(new Color(0,0,0));
		unoLabel.setOpaque(true);
		unoLabel.setFont(font);
		panel.add(unoLabel);
		
		unoTF= new JTextField();
		unoTF.setBounds(160,130,200,30);
		unoTF.setFont(font);
		panel.add(unoTF);
		
	    Detailsbttn= new JButton("Details");
		Detailsbttn.setBounds(400,130,100,30);
		Detailsbttn.setFont(font);
		Detailsbttn.addActionListener(this);
		panel.add(Detailsbttn);
		
		meternoLabel=new JLabel("Meter No ", SwingConstants.CENTER);
		meternoLabel.setBounds(10,180,140,30);
		meternoLabel.setForeground(new Color(255,255,255));
		meternoLabel.setBackground(new Color(0,0,0));
		meternoLabel.setOpaque(true);
		meternoLabel.setFont(font);
		panel.add(meternoLabel);
		
		meternoTF= new JTextField();
		meternoTF.setBounds(160,180,200,30);
		meternoTF.setFont(font);
		panel.add(meternoTF);
		
		deletebttn= new JButton("DELETE");
		deletebttn.setBounds(400,180,100,30);
		deletebttn.setFont(font);
		deletebttn.addActionListener(this);
		panel.add(deletebttn);
		
	    meterHolderLabel=new JLabel("Meter Holder", SwingConstants.CENTER);
		meterHolderLabel.setBounds(10,230,140,30);
		meterHolderLabel.setForeground(new Color(255,255,255));
		meterHolderLabel.setBackground(new Color(0,0,0));
		meterHolderLabel.setOpaque(true);
		meterHolderLabel.setFont(font);
		panel.add(meterHolderLabel);
		
		meterHolderTF= new JTextField();
		meterHolderTF.setBounds(160,230,200,30);
		meterHolderTF.setFont(font);
		panel.add(meterHolderTF);
		
		clearbttn= new JButton("CLEAR");
		clearbttn.setBounds(400,230,100,30);
		clearbttn.setFont(font);
		clearbttn.addActionListener(this);
		panel.add(clearbttn);
		
		meterReadingLabel=new JLabel("MeterReading", SwingConstants.CENTER);
		meterReadingLabel.setBounds(10,280,140,30);
		meterReadingLabel.setForeground(new Color(255,255,255));
		meterReadingLabel.setBackground(new Color(0,0,0));
		meterReadingLabel.setOpaque(true);
		meterReadingLabel.setFont(font);
		panel.add(meterReadingLabel);
		
		meterReadingTF= new JTextField();
		meterReadingTF.setBounds(160,280,200,30);
		meterReadingTF.setFont(font);
		panel.add(meterReadingTF);
		
		savebttn = new JButton("Save");
	    savebttn.setBounds(400,280,100,30);
		savebttn.setFont(font);
		savebttn.addActionListener(this);
		panel.add(savebttn);
		
		MonthLabel=new JLabel("Month ", SwingConstants.CENTER );
		MonthLabel.setBounds(10,320,140,30);
		MonthLabel.setForeground(new Color(255,255,255));
		MonthLabel.setBackground(new Color(0,0,0));
		MonthLabel.setOpaque(true);
		MonthLabel.setFont(font);
		panel.add(MonthLabel);
		
		String items[] = {"January", "February", "March", "April", "May","June","July","August","September","November","December",""};
		combo = new JComboBox(items);
		combo.setBounds(160,320,200,30);
		panel.add(combo);
		
		importbttn = new JButton("import");
	    importbttn.setBounds(400,320,100,30);
		importbttn.setFont(font);
		importbttn.addActionListener(this);
		panel.add(importbttn);
		
		GoBackbttn = new JButton("Go Back");
	    GoBackbttn.setBounds(250,650,100,30);
		GoBackbttn.setFont(font);
		GoBackbttn.addActionListener(this);
		panel.add(GoBackbttn);
		

		table= new JTable();
		table.setBounds(10,450,100,100);
		model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setFont(font);
		table.setSelectionBackground(Color.GREEN);
		table.setBackground(Color.WHITE);
		table.setRowHeight(30);
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				int numberOfRow=table.getSelectedRow();
				String uname=model.getValueAt(numberOfRow,0).toString();
				String uid=model.getValueAt(numberOfRow,1).toString();
				String MeterNo=model.getValueAt(numberOfRow,2).toString();
				String Meterholder=model.getValueAt(numberOfRow,3).toString();
				String MeterRead=model.getValueAt(numberOfRow,4).toString();
				String month=model.getValueAt(numberOfRow,5).toString();
				Object monthobj=month;
				
				unameTF.setText(uname);
				unoTF.setText(uid);
				meternoTF.setText(MeterNo);
				meterHolderTF.setText(Meterholder);
				meterReadingTF.setText(MeterRead);
				meterReadingTF.setText(MeterRead);
                combo.getModel().setSelectedItem(monthobj);
			}
		});
		
		scroll = new JScrollPane(table);
		scroll.setBounds(10,360,740,265);
		panel.add(scroll);
		this.add(panel);
    }	
		
		public void actionPerformed(ActionEvent e)
		{
		  if( e.getSource() ==addbttn)
		  {
			String s1=unameTF.getText();  
			String s2=unoTF.getText();  
			String s3=meternoTF.getText();  
			String s4=meterHolderTF.getText();
			String s5=meterReadingTF.getText();
			String s6="";
			String s7=combo.getSelectedItem().toString();
			
			
			if(!s1.equals(s6) & !s2.equals(s6) & !s3.equals(s6) & !s4.equals(s6) & !s5.equals(s6))
			{
			   rows[0]=unameTF.getText();  
			   rows[1]=unoTF.getText();  
			   rows[2]=meternoTF.getText();  
			   rows[3]=meterHolderTF.getText();
			   rows[4]=meterReadingTF.getText();
			   rows[5]=combo.getSelectedItem().toString();
			   
			   try{
				boolean flag=false;
				File file=new File("User.txt");
				Scanner scanner= new Scanner(file);
				while(scanner.hasNext()){
					String name= scanner.next();
					String id=scanner.next();
					if(name.equals(s1) & id.equals(s2))
					{
                        model.addRow(rows);
						flag=true;
						break;
					}
					else{continue;}

				}
				
			   
				scanner.close();
				
				if(flag==false){JOptionPane.showMessageDialog(null,"Invalid user");}
			   }
				catch(Exception io)
				{
					System.out.println(io);
				}
			   
			}   
		    else{JOptionPane.showMessageDialog(null,"Please enter all the values");}
			
			 
		}
		  
		  else if(e.getSource()==clearbttn)
		  {
			unameTF.setText("");
			unoTF.setText("");
			meternoTF.setText("");
			meterHolderTF.setText("");
			meterReadingTF.setText("");
		  }
		  
		  else if(e.getSource()==deletebttn)
		  {
			
			int numberOfRows=table.getSelectedRow();
			if(numberOfRows>=0){
				model.removeRow(numberOfRows);
			}
			else{JOptionPane.showMessageDialog(null,"Please select a row to delete");}
		  }
		  
		  else if(e.getSource()==savebttn)
	    {
			 try{
                //the file path
               File file = new File("Text.txt");
               //if the file not exist create one
               if(!file.exists()){
                   file.createNewFile();
               }
               
               FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
               
               //loop for jtable rows
               for(int i = 0; i < table.getRowCount(); i++){
                   //loop for jtable column
                   for(int j = 0; j < table.getColumnCount(); j++){
                       bw.write(table.getModel().getValueAt(i, j)+" ");
                   }
                   //break line at the begin 
                   //break line at the end 
				   bw.newLine();
                   
               }
               //close BufferedWriter
               bw.close();
               //close FileWriter 
               fw.close();
               JOptionPane.showMessageDialog(null, "Data Exported");
               
               }catch(Exception ex){
                   ex.printStackTrace();
               }
        }
			
			else if(e.getSource()==importbttn)
			{
				 String filePath = "Text.txt";
                 File file = new File(filePath);
        
              try {
                  FileReader fr = new FileReader(file);
                  BufferedReader br = new BufferedReader(fr);
                  //model = (DefaultTableModel)jTableImport.getModel();
                  Object[] lines = br.lines().toArray();
            
                  for(int i = 0; i < lines.length; i++){
                  String[] row = lines[i].toString().split(" ");
                  model.addRow(row);
                  } 
			    }  
            
              catch (FileNotFoundException ex) {
                //Logger.getLogger(JTable_import_and_export_to_text_file.class.getName()).log(Level.SEVERE, null, ex);
                }      
				
			}
			
			else if(e.getSource()==Detailsbttn){
				
			   String u1=unameTF.getText();  
			   String u2=unoTF.getText();  
			   String u3=meternoTF.getText();  
			   String u4=meterHolderTF.getText();
			   String u5=meterReadingTF.getText();
			   String u6=combo.getSelectedItem().toString();
			   
			    try{
				   int userid=Integer.parseInt(u2);
				   int meternumber=Integer.parseInt(u3);
				   double meterReading=Double.parseDouble(u5);
				   

				   User u=new User(userid,u1);
				   ElectricityBill e1=new ElectricityBill(meternumber,u4,meterReading);
				   u.showDetails();
				   e1.BillOperation();
				   e1.showDetails();
				   
				   double bill=e1.BillOperation();
				   
				   
				   showDetails obj=new showDetails(u1,userid,meternumber,u4,meterReading,bill,u6);
				   obj.setVisible(true);
				   this.setVisible(false);
				   
				   
			   }
			   catch (NumberFormatException ex){
				   ex.printStackTrace();
			   }
			}
			
			else if(e.getSource()==GoBackbttn)
			{
				adminPanel ed=new adminPanel();
				ed.setVisible(true);
				this.setVisible(false);
			}
			
		}

    
}

 
  
  



