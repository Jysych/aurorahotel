package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginUI extends JFrame {

    private JPanel contentPane;
    private JTextField emailField;
    private JPasswordField passwordField;

    // Predetermined admin credentials
    private final String ADMIN_EMAIL = "SuperNila";
    private final String ADMIN_PASSWORD = "123";

    public loginUI() {
        login();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                loginUI frame = new loginUI();
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
                // Get the user input from the email and password fields
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Validate the login credentials
                if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
                    // If successful, show a success message and open the dashboard
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose(); // Close the login window
                    openDashboard(email); // Pass the logged-in user's email
                } else {
                    // If unsuccessful, show an error message
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

    // Method to open the Admin Dashboard and pass the logged-in email
    private void openDashboard(String email) {
        AdminDashboard dashboard = new AdminDashboard(email); // Pass the logged-in email to the dashboard
        dashboard.setVisible(true);
    }
}
