import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginpanel {

    public static void main(String[] args) {

        // Main window
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to center the login box
        JPanel centerPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 0, 80)
        );

        // Login box
        JPanel loginPanel = new JPanel(
            new GridLayout(3, 2, 10, 15)
        );
        loginPanel.setPreferredSize(
            new Dimension(400, 240)
        );
        loginPanel.setBorder(
            BorderFactory.createTitledBorder("Login")
        );

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");

        // Add components
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        loginPanel.add(loginButton);
        loginPanel.add(clearButton);

        // Add login panel to center panel
        centerPanel.add(loginPanel);

        // Add center panel to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add main panel to frame
        frame.add(mainPanel);

        // ------------------------------------
        // LOGIN BUTTON EVENT
        // ------------------------------------
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
