import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JLabel usernameLabel, passwordLabel, titleLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, resetButton;
    
    public Login() {
        setTitle("AIUB PARKING   LOGIN");
        setSize(1280, 720);
        ImageIcon icon = new ImageIcon("aiub.png");
        setIconImage(icon.getImage());
       
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(true); // Allow resizing
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

 


        
        titleLabel = new JLabel("STUDENT INFORMATION");
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(400, 100, 500, 50);
/*----------------------------------------------------student er name and box--------------------------------------- */
        usernameLabel = new JLabel("STUDENT NAME:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(500, 200, 100, 20);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Sans Serif", Font.BOLD, 20));
        usernameField.setBounds(650, 200, 150, 20);

/*--------------------------------------xxxxx------------------------------------------------- */
/*-----------------------------------------pass name and boxxx------------------------------------------------------ */
        passwordLabel = new JLabel("STUDENT ID:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(500, 250, 100, 20);
      
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Sans Serif", Font.BOLD, 20));
        passwordField.setBounds(650, 250, 150, 20);

/*-----------------------------xxxx-x-xxx----------------------------------------------- */

        loginButton = new JButton("CHECK STUDENT");
        loginButton.setFont(new Font("Sans Serif", Font.BOLD, 12));
        loginButton.setBounds(500, 300, 150, 30);
        
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Sans Serif", Font.BOLD, 12));
        resetButton.setBounds(700, 300, 100, 30);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(titleLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(resetButton);

        getContentPane().setBackground(new Color(54, 54, 54));

        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform authentication here
            if (username.equals("ahasanul") && password.equals("48399")) {
                JOptionPane.showMessageDialog(this, "Find successful");
                Detail myForm = new Detail();
                dispose();
            
            }
           else if (username.equals("AHASANUL") && password.equals("48399")) {
                JOptionPane.showMessageDialog(this, "Find successful");
                Detail myForm = new Detail();
                dispose();
            
            }

            else if (username.equals("jubiar") && password.equals("51330")) {
                JOptionPane.showMessageDialog(this, "Find successful");
                Detail2 myForm = new Detail2();
                dispose();
            }
            else if (username.equals("JUBIAR") && password.equals("51330")) {
                JOptionPane.showMessageDialog(this, "Find successful");
                Detail2 myForm = new Detail2();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }
    }

  
}

    
