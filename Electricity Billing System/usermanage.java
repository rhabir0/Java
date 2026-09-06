import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.io.*;


public class usermanage extends JFrame implements ActionListener
{   
    private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel;
    private JLabel unameLabel,unoLabel,meternoLabel,meterHolderLabel,meterReadingLabel;
	private JTextField unameTF,unoTF,meternoTF,meterHolderTF,meterReadingTF;
	private JButton addbttn,updatebttn,deletebttn,clearbttn,savebttn;
    private Font font;
	
	private String[] columns={"User Name","User ID","Meter No.","Meter Holder","Meter Reading"};
	private String[]  rows= new String[5];

  usermanage(){
	  	super("Electrcity Billing v1.00");
		this.setSize(780,690);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,255,204));
		Font font = new Font("Italic", Font.BOLD,14);
		
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
		
	    updatebttn= new JButton("UPDATE");
		updatebttn.setBounds(400,130,100,30);
		updatebttn.setFont(font);
		panel.add(updatebttn);
		
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
		
		
		table= new JTable();
		model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setFont(font);
		table.setSelectionBackground(Color.GREEN);
		table.setBackground(Color.WHITE);
		table.setRowHeight(30);
		
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
			if(!s1.equals(s6) & !s2.equals(s6) & !s3.equals(s6) & !s4.equals(s6) & !s5.equals(s6))
			{
			   rows[0]=unameTF.getText();  
			   rows[1]=unoTF.getText();  
			   rows[2]=meternoTF.getText();  
			   rows[3]=meterHolderTF.getText();
			   rows[4]=meterReadingTF.getText();
			   model.addRow(rows);
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
                   bw.write("\n_________\n");
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
    
 
		 }
		public static void main(String args[]){
		usermanage u= new usermanage();
		u.setVisible(true);
	}
} 
  
  


