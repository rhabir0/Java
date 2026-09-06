import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.io.*;
import Classes.*;

public class FUserRegister extends JFrame implements ActionListener
{ 
    private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel;
    private JLabel unameLabel,unoLabel;
	private JTextField unameTF,unoTF;
	private JButton addbttn,deletebttn,clearbttn,savebttn,importbttn,gobackBttn;
    private Font font;
	private String[] columns={"User Name","User ID"};
	private String[]  rows= new String[2];
	
	FUserRegister(){
		super("Electrcity Billing v1.00");
		this.setSize(700,650);
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
		unameTF.setBounds(160,80,320,30);
		unameTF.setFont(font);
		panel.add(unameTF);
		
		unoLabel=new JLabel("User ID  ", SwingConstants.CENTER);
		unoLabel.setBounds(10,130,140,30);
		unoLabel.setForeground(new Color(255,255,255));
		unoLabel.setBackground(new Color(0,0,0));
		unoLabel.setOpaque(true);
		unoLabel.setFont(font);
		panel.add(unoLabel);
		
		unoTF= new JTextField();
		unoTF.setBounds(160,130,320,30);
		unoTF.setFont(font);
		panel.add(unoTF);
		
		addbttn= new JButton("ADD");
		addbttn.setBounds(20,180,100,30);
		addbttn.setFont(font);
		addbttn.addActionListener(this);
		panel.add(addbttn);
		
		deletebttn= new JButton("DELETE");
		deletebttn.setBounds(140,180,100,30);
		deletebttn.setFont(font);
		deletebttn.addActionListener(this);
		panel.add(deletebttn);
		
		savebttn = new JButton("Save");
	    savebttn.setBounds(260,180,100,30);
		savebttn.setFont(font);
		savebttn.addActionListener(this);
		panel.add(savebttn);
		
	    clearbttn= new JButton("CLEAR");
		clearbttn.setBounds(380,180,100,30);
		clearbttn.setFont(font);
		clearbttn.addActionListener(this);
		panel.add(clearbttn);
		
		gobackBttn= new JButton("Go Back");
		gobackBttn.setBounds(500,180,100,30);
		gobackBttn.setFont(font);
		gobackBttn.addActionListener(this);
		panel.add(gobackBttn);
		
	    importbttn = new JButton("import");
	    importbttn.setBounds(10,330,100,30);
		importbttn.setFont(font);
		importbttn.addActionListener(this);
		panel.add(importbttn);
		

		
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
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent e)
		{
		  if( e.getSource() ==addbttn)
		  {
			String s1=unameTF.getText();  
			String s2=unoTF.getText();  
			String s6="";
			if(!s1.equals(s6) & !s2.equals(s6))
			{
			   rows[0]=unameTF.getText();  
			   rows[1]=unoTF.getText();
			   try{ int userid=Integer.parseInt(s2);
			   
			   String username=unameTF.getText();
			   User u= new User(userid,username);
			   
			   NESCO n=new NESCO();
			   n.insertUser(u);
			   n.showAllUser();
			   
			   model.addRow(rows);}
			   catch(Exception ie){JOptionPane.showMessageDialog(null,"Invalid Input");}
			}
		    else{JOptionPane.showMessageDialog(null,"Please enter all the values");}
		  }
		  
		  else if(e.getSource()==clearbttn)
		  {
			unameTF.setText("");
			unoTF.setText("");
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
               File file = new File("User.txt");
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
		 
		 else if(e.getSource()==importbttn){
				 String filePath = "User.txt";
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
			
			else if(e.getSource()==gobackBttn)
			{
			   adminPanel us= new adminPanel();
		       us.setVisible(true);
			   this.setVisible(false);
			}
	    }
		public static void main(String args[]){
		FUserRegister u= new FUserRegister();
		u.setVisible(true);
	}

}