
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parking extends JFrame implements ActionListener {
JLabel locationLabel, titleLabel;
JButton backButton;
String[] locations = {"A1", "A2", "A3","A4","A5","A6","A7","A8","A9","A10", "B1", "B2", "B3", "C1", "C2", "C3"};
String assignedLocation;
public Parking() {
    setTitle("Parking");
    setSize(1280, 720);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);

    titleLabel = new JLabel("Parking");
    titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setBounds(550, 100, 150, 50);

    locationLabel = new JLabel("Your assigned parking location is:");
    locationLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
    locationLabel.setForeground(Color.WHITE);
    locationLabel.setBounds(500, 200, 300, 20);

    assignedLocation = locations[(int)(Math.random() * locations.length)];
    JLabel assignedLocationLabel = new JLabel(assignedLocation);
    assignedLocationLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
    assignedLocationLabel.setForeground(Color.WHITE);
    assignedLocationLabel.setBounds(580, 250, 100, 50);

    backButton = new JButton("Back");
    backButton.setBounds(570, 400, 100, 30);
    backButton.addActionListener(this);

    add(titleLabel);
    add(locationLabel);
    add(assignedLocationLabel);
    add(backButton);

    getContentPane().setBackground(new Color(54, 54, 54));

    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == backButton) {
        Detail d = new Detail();
        dispose();
    }
}
}