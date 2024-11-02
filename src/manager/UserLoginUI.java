package manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginUI extends JFrame {

    private JPanel contentPane;
    private JTextField emailField;
    private JPasswordField passwordField;

    // Database credentials and URL (update these with your database details)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USERNAME = "your_db_username";
    private static final String DB_PASSWORD = "your_db_password";

    public UserLoginUI() {
        login();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserLoginUI frame = new UserLoginUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Left-side login panel
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/bglog.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setPreferredSize(new Dimension(450, 600));
        loginPanel.setLayout(null);
        contentPane.add(loginPanel, BorderLayout.WEST);

        // Login label
        JLabel loginLabel = new JLabel("LOG IN");
        loginLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(149, 100, 115, 40);
        loginPanel.add(loginLabel);

        // Email label and field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(100, 180, 100, 30);
        loginPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBackground(new Color(221, 221, 221));
        emailField.setBounds(100, 210, 200, 30);
        loginPanel.add(emailField);
        emailField.setColumns(10);

        // Password label and field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(100, 260, 100, 30);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(221, 221, 221));
        passwordField.setBounds(100, 290, 200, 30);
        loginPanel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("");
        loginButton.setBounds(154, 355, 95, 30);
        ImageIcon arrowIcon = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/buton.png");
        loginButton.setIcon(arrowIcon);
        loginPanel.add(loginButton);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (checkCredentials(email, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose(); // Close the login window
                    openDashboard(); // Open the dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Right-side image panel
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon rightSideImage = new ImageIcon("C:/Users/JC Mendez/Downloads/AuroraCoveHotel/auroraCoveHotel/ImageIcon/hotel6.png");
                g.drawImage(rightSideImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.add(imagePanel, BorderLayout.CENTER);
    }

    private boolean checkCredentials(String email, String password) {
        // Method to connect to the database and check if the user exists
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if a record is found
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void openDashboard() {
        // Open the DashboardUser screen
        DashboardUser dashboard = new DashboardUser();
        JFrame dashboardFrame = new JFrame("Dashboard");
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setContentPane(dashboard);
        dashboardFrame.setSize(1243, 875);
        dashboardFrame.setVisible(true);
    }
}
