import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Detail2 extends JFrame implements ActionListener {
    JLabel usernameLabel, phoneLabel, vehicleLabel, titleLabel,titleLabel2,dateofbt,bldt,rollt,progt,valt;
    JTextField usernameField, phoneField, vehicleField,datebirth,bldf,rollf,progf,vlf;
    JButton submitButton, resetButton;
    Studentinfo2 M=new Studentinfo2();
   

    public Detail2() {
        ImageIcon icon = new ImageIcon("aiub.png");
        setIconImage(icon.getImage());
        setTitle("STUDENT VEHICAL INFORMATION");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
       setLayout(null);
        
/*------------------------------------------------------title---------------------------------------------------------------- */
        titleLabel = new JLabel("STUDENT INFORMATION");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(100, 100, 500, 50);


   

/*----------------------------------------------xxx--------------------------------------------------------------------------- */        

/*------------------------------------------------studen er name and box--------------------------------------------------------- */

        //box er ager likha
        usernameLabel = new JLabel("Student name:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(100, 200, 100, 20);
        //boxx
        usernameField = new JTextField();
        usernameField.setBounds(200, 200, 200, 20); 
        //usernameField.setFont(new Font("Sans Serif", Font.BOLD, 100));
       
        usernameField.setText(M.Rname()); 
        usernameField.setBackground(Color.WHITE); 
         usernameField.setFont(new Font("Arial", Font.BOLD, 12));

/*-------------------------------------------------xxxx-------------------------------------------------------------------------------- */

/*----------------------------------------------phone number and box-------------------------------------------------------------------- */
        //box er ager likha
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(100, 250, 160, 20);
        //box
        phoneField = new JTextField();
        phoneField.setBounds(200, 250, 150, 20);
        phoneField.setText(M.phn());    
        phoneField.setBackground(Color.WHITE);
        phoneField.setFont(new Font("Arial", Font.BOLD, 12));

/*---------------------------------------------------xxx----------------------------------------------------------------------------------- */
/*--------------------------------------------date of birth and box-------------------------------------------------------------------------- */
        //box er ager likha
        dateofbt = new JLabel("Date of birth:");
        dateofbt.setForeground(Color.WHITE);
        dateofbt.setBounds(100, 300, 100, 20);
        //boxx
        datebirth = new JTextField();
        datebirth.setBounds(200, 300, 200, 20);
        datebirth.setText(M.Dob());    
        datebirth.setBackground(Color.WHITE);
        datebirth.setFont(new Font("Arial", Font.BOLD, 12));

/*---------------------------------------------xxxxxx---------------------------------------------------------------------------------------- */        

/*-----------------------------blood group----------------------------------------------------------------------------------------- */

            bldt = new JLabel("Blood Group:");    
            bldt.setForeground(Color.WHITE);
            bldt.setBounds(100, 350, 100, 20);
        //boxx
        bldf = new JTextField();
        bldf.setBounds(200, 350, 200, 20);
        bldf.setText(M.Rblod());    
        bldf.setBackground(Color.WHITE);
        bldf.setFont(new Font("Arial", Font.BOLD, 12));

        

/*--------------------------xxxxxxxx----------------------------------------------------------------------------------------------- */

/*-----------------------------------roll and box --------------------------------------------------------------------------- */

        //box er ager line
        rollt = new JLabel("Roll:");    
        rollt.setForeground(Color.WHITE);
        rollt.setBounds(100, 400, 100, 20);
        //boxx
        rollf = new JTextField();
        rollf.setBounds(200, 400, 200, 20);
        rollf.setText(M.roll());    
        rollf.setBackground(Color.WHITE);
        rollf.setFont(new Font("Arial", Font.BOLD, 12));

/*------------------------------------------xxxxx--------------------------------------------------------- */
/*-------------------------------------------------programe name---------------------------------------------------------------------------- */
           //box er ager line
           progt = new JLabel("Program:");    
           progt.setForeground(Color.WHITE);
           progt.setBounds(100, 450, 100, 20);
           //boxx
           progf = new JTextField();
           progf.setBounds(200, 450, 200, 20);
           progf.setText(M.program());    
           progf.setBackground(Color.WHITE);
           progf.setFont(new Font("Arial", Font.BOLD, 12));


/*-------------------------------------------------------xxxxxxxx----------------------------------------------------------------------------- */
/*----------------------------------------------validity---------------------------------------------------------------------------------- */

                   //box er ager line
                   valt = new JLabel("Validity:");    
                   valt.setForeground(Color.WHITE);
                   valt.setBounds(100, 500, 100, 20);
                   //boxx
                   vlf = new JTextField();
                   vlf.setBounds(200, 500, 200, 20);
                   vlf.setText(M.Val());    
                   vlf.setBackground(Color.WHITE);
                   vlf.setFont(new Font("Arial", Font.BOLD, 12));

/*-----------------------------------------------xxxxxxxxx------------------------------------------------------------------------ */
/*--------------------------------------------vehical number---------------------------------------------------------------------- */
       


        titleLabel2 = new JLabel("VEHICAL INFORMATION");
        titleLabel2.setFont(new Font("Sans Serif", Font.BOLD, 36));
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setBounds(800, 100, 500, 50);

        //box er ager likha
        vehicleLabel = new JLabel("Vehicle Number:");
        vehicleLabel.setForeground(Color.WHITE);
        vehicleLabel.setBounds(800, 200, 100, 20); 
        vehicleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        //box
        vehicleField = new JTextField();
        vehicleField.setBounds(900, 200, 150, 20);
        vehicleField.setFont(new Font("Sans Serif", Font.BOLD, 15));
       

/*---------------------------------xxxxxxxxx-------------------------------------------------------------------------------------------- */
/*--------------------------------------------submit button---------------------------------------------------------------------- */

         submitButton = new JButton("Find parking");
         submitButton.setBounds(800, 250, 150, 30);


/*---------------------------------xxxxxxxxx-------------------------------------------------------------------------------------------- */
 /*-------------------------------------resetbutton------------------------------------------------------------------------------------- */
       
 
        resetButton = new JButton("Reset");
        resetButton.setBounds(960, 250, 100, 30);


 /*--------------------------------------------------------xxxxxxx--------------------------------------------------------------------------- */       
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(titleLabel);
        add(titleLabel2);
        add(usernameLabel);
        add(datebirth);
        add(dateofbt);
        add(bldt);
        add(bldf);
        add(rollt);
        add(rollf);
        add(progt);
        add(progf);
        add(valt);
        add(vlf);

        add(usernameField);
        add(phoneLabel);
        add(phoneField);
        add(vehicleLabel);
        add(vehicleField);
        add(submitButton);
        add(resetButton);

        getContentPane().setBackground(new Color(54, 54, 54));

        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String username = usernameField.getText();
            String phone = phoneField.getText();
            String vehicle = vehicleField.getText();

            // Do something with the form data
            int confirmation= JOptionPane.showConfirmDialog(this, "Username: " + username + "\nPhone Number: " + phone + "\nVehicle Number: " + vehicle);
            if(confirmation == JOptionPane.YES_OPTION)
            {   
                Parking p = new Parking();
                dispose();

            }
        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            phoneField.setText("");
            vehicleField.setText("");

            vlf.setText("");
            progf.setText("");
            rollf.setText("");
            bldf.setText("");
            datebirth.setText("");
        }
    }

}
