import javax.swing.*;
import java.awt.*;

public class RegisterForm {
    public static void main(String[] args) {

        // Main window
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(800, 700); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to center the registration box
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));

        // Registration box (8 rows, 2 columns)
        JPanel registerPanel = new JPanel(new GridLayout(8, 2, 10, 15));
        registerPanel.setPreferredSize(new Dimension(500, 500)); 
        registerPanel.setBorder(BorderFactory.createTitledBorder("Student Registration"));

        // Row 1: Name 
        JLabel nameLabel = new JLabel("Name:");
        JTextArea nameArea = new JTextArea(2, 20); 
        nameArea.setLineWrap(true);       
        nameArea.setWrapStyleWord(true);   
        JScrollPane nameScrollPane = new JScrollPane(nameArea);
        nameScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        registerPanel.add(nameLabel);
        registerPanel.add(nameScrollPane); 

        // Row 2: Email 
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        registerPanel.add(emailLabel);
        registerPanel.add(emailField);

        // Row 3: Password 
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20); 
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);

        // Row 4: Gender
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        
        registerPanel.add(genderLabel);
        registerPanel.add(genderPanel);

        // Row 5: Course dropdown
        JLabel courseLabel = new JLabel("Course:");
        String[] courses = {"Computer Science", "Business Administration", "Engineering", "Arts"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);
        registerPanel.add(courseLabel);
        registerPanel.add(courseComboBox);

        // Row 6: Address
        JLabel addressLabel = new JLabel("Address:");
        JTextArea addressArea = new JTextArea(3, 20);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addressScrollPane = new JScrollPane(addressArea);
        addressScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        registerPanel.add(addressLabel);
        registerPanel.add(addressScrollPane);

        // Row 7: Terms and Conditions 
        JLabel termsLabel = new JLabel(""); 
        JCheckBox termsCheckBox = new JCheckBox("I agree to the Terms & Conditions");
        registerPanel.add(termsLabel);
        registerPanel.add(termsCheckBox);

        // Row 8: Submit and Clear Buttons
        JLabel emptyLabel = new JLabel(""); 
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JButton submitButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");
        
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        
        registerPanel.add(emptyLabel);
        registerPanel.add(buttonPanel);

        // --- NEW: Action Listener for the Register Button ---
        submitButton.addActionListener(e -> {
            if (termsCheckBox.isSelected()) {
                // Show success message if terms are checked
                JOptionPane.showMessageDialog(frame, 
                        "Successfully Registered!", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show warning message if terms are NOT checked
                JOptionPane.showMessageDialog(frame, 
                        "Please agree to the Terms & Conditions before registering.", 
                        "Warning", 
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // Action Listener for the Clear Button
        clearButton.addActionListener(e -> {
            nameArea.setText("");                     
            emailField.setText("");                   
            passwordField.setText("");                
            addressArea.setText("");                  
            genderGroup.clearSelection();             
            courseComboBox.setSelectedIndex(0);       
            termsCheckBox.setSelected(false);         
        });

        // Assemble the UI hierarchy
        centerPanel.add(registerPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Make the window visible
        frame.setVisible(true);
    }
}
