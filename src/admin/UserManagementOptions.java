package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagementOptions extends JFrame {

    private AdminDashboard dashboard;  // Reference to AdminDashboard for returning later

    public UserManagementOptions(AdminDashboard dashboard) {
        this.dashboard = dashboard;  // Store reference to AdminDashboard for navigation
        setTitle("User Management Options");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("USER MANAGEMENT");
        titleLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
        titleLabel.setBounds(125, 31, 355, 32);
        getContentPane().add(titleLabel);

        // Add User Button
        JButton addUserButton = new JButton("ADD USER");
        addUserButton.setForeground(new Color(255, 255, 255));
        addUserButton.setBackground(new Color(0, 64, 128));
        addUserButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        addUserButton.setBounds(12, 100, 560, 50);
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUser addUserWindow = new AddUser(UserManagementOptions.this);  // Open AddUser window, passing the current frame
                addUserWindow.setVisible(true);  // Show the AddUser window
                setVisible(false);  // Hide this window
            }
        });
        getContentPane().add(addUserButton);

        // Remove User Button
        JButton removeUserButton = new JButton("REMOVE USER");
        removeUserButton.setForeground(new Color(255, 255, 255));
        removeUserButton.setBackground(new Color(0, 64, 128));
        removeUserButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        removeUserButton.setBounds(12, 170, 560, 50);
        removeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveUser removeUserWindow = new RemoveUser(UserManagementOptions.this);  // Open RemoveUser window
                removeUserWindow.setVisible(true);  // Show the RemoveUser window
                setVisible(false);  // Hide this window
            }
        });
        getContentPane().add(removeUserButton);

        // View All Users Button
        JButton viewAllUsersButton = new JButton("VIEW ALL USERS");
        viewAllUsersButton.setForeground(new Color(255, 255, 255));
        viewAllUsersButton.setBackground(new Color(0, 64, 128));
        viewAllUsersButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        viewAllUsersButton.setBounds(12, 240, 560, 50);
        viewAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAllUsers viewAllUsersWindow = new ViewAllUsers(UserManagementOptions.this);  // Open ViewAllUsers window
                viewAllUsersWindow.setVisible(true);  // Show the ViewAllUsers window
                setVisible(false);  // Hide this window
            }
        });
        getContentPane().add(viewAllUsersButton);
        
        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0, 64, 128));
        backButton.setBounds(12, 314, 91, 39);
        getContentPane().add(backButton);

        setVisible(true);  // Show the UserManagementOptions frame
    }
}