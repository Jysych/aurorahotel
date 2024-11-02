package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AdminDashboard extends JFrame {

    private String loggedInUser;

    public AdminDashboard(String userEmail) {
        this.loggedInUser = userEmail;
        initialize();
    }

    private void initialize() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1243, 843);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

     // Left panel (Navigation bar)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(3, 91, 150));
        leftPanel.setBounds(0, 74, 1227, 737);
        leftPanel.setLayout(null);
        contentPane.add(leftPanel);

        // Logo without resizing
        ImageIcon logoIcon = new ImageIcon("C:/Users/JC Mendez/git/DSA-FinalProj/ImageIcon/navbar.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 0, 300, 76);  // Adjusts to the icon's original dimensions
        contentPane.add(logoLabel);  // Add the logoLabel directly to contentPane or the desired panel

        // Logout button
        JButton logoutButton = new JButton("LOG OUT");
        logoutButton.setBackground(new Color(192, 192, 192));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logout action here
            }
        });
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        logoutButton.setBounds(34, 179, 180, 41);
        leftPanel.add(logoutButton);
        
        // Right panel content (main panel)
        JPanel leftPanel_1 = new JPanel();
        leftPanel_1.setLayout(null);
        leftPanel_1.setBackground(new Color(255, 255, 255));
        leftPanel_1.setBounds(244, 11, 956, 704);
        leftPanel.add(leftPanel_1);

        // Button 1 with image
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(new Color(3, 91, 150));
        ImageIcon button1Icon = new ImageIcon("C:/Users/JC Mendez/git/DSA-FinalProj/ImageIcon/Booked.png");
        btnNewButton.setIcon(new ImageIcon(button1Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnNewButton.setBounds(30, 26, 265, 664);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Button 1 action
            }
        });
        leftPanel_1.add(btnNewButton);

        // Button 2 with image
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(new Color(3, 91, 150));
        ImageIcon button2Icon = new ImageIcon("C:/Users/JC Mendez/git/DSA-FinalProj/ImageIcon/Guest.png");
        btnNewButton_1.setIcon(new ImageIcon(button2Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnNewButton_1.setBounds(332, 26, 265, 664);
        leftPanel_1.add(btnNewButton_1);

        // Button 3 with image
        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBackground(new Color(3, 91, 150));
        ImageIcon button3Icon = new ImageIcon("C:/Users/JC Mendez/git/DSA-FinalProj/ImageIcon/hotel.png");
        btnNewButton_1_1.setIcon(new ImageIcon(button3Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnNewButton_1_1.setBounds(643, 26, 265, 320);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Button 3 action
            }
        });
        leftPanel_1.add(btnNewButton_1_1);

        // Button 4 with image
        JButton btnNewButton_1_1_1 = new JButton("");
        btnNewButton_1_1_1.setBackground(new Color(3, 91, 150));
        ImageIcon button4Icon = new ImageIcon("C:/Users/JC Mendez/git/DSA-FinalProj/ImageIcon/settings.png");
        btnNewButton_1_1_1.setIcon(new ImageIcon(button4Icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        btnNewButton_1_1_1.setBounds(643, 370, 265, 320);
        leftPanel_1.add(btnNewButton_1_1_1);

        // User label
        JLabel userLabel = new JLabel("Username: " + loggedInUser);
        userLabel.setBounds(34, 60, 180, 90);
        userLabel.setBackground(new Color(192, 192, 192));
        userLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
        userLabel.setForeground(Color.WHITE);
        leftPanel.add(userLabel);
    }

    public static void main(String[] args) {
        AdminDashboard frame = new AdminDashboard("SuperNila");
        frame.setVisible(true);
    }
}
