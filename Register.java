import javax.swing.*;
import java.awt.*;

public class Register {
    public static void main(String[] args) {

        // main window
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(800, 550); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // panel to center the registration box
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30)); 

        // registration box 
        JPanel registerPanel = new JPanel(new GridLayout(6, 2, 10, 15));
        registerPanel.setPreferredSize(new Dimension(1000, 1000)); 
        registerPanel.setBorder(BorderFactory.createTitledBorder("Student Registration"));

        // --- UPDATED CODE: Name field with JScrollPane ---
        JLabel nameLabel = new JLabel("Name:");
        JTextArea nameArea = new JTextArea(1, 20); // Changed to JTextArea to support scrolling
        nameArea.setLineWrap(true);
        nameArea.setWrapStyleWord(true);
        JScrollPane nameScrollPane = new JScrollPane(nameArea);
        nameScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // gender
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        // course dropdown
        JLabel courseLabel = new JLabel("Course:");
        String[] courses = {"Computer Science", "Business Administration", "Engineering", "Arts"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);

        // Address field with JScrollPane
        JLabel addressLabel = new JLabel("Address:");
        JTextArea addressArea = new JTextArea(3, 20); 
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true); 
        JScrollPane addressScrollPane = new JScrollPane(addressArea);
        addressScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Terms and Conditions Checkbox
        JLabel termsLabel = new JLabel("Terms:");
        JCheckBox termsCheckBox = new JCheckBox("I agree to the terms and conditions");

        // submit button
        JButton submitButton = new JButton("Register");
        JLabel emptyLabel = new JLabel(""); 

        // Add components to the grid
        registerPanel.add(nameLabel);
        registerPanel.add(nameScrollPane); // Added scroll pane instead of field
        
        registerPanel.add(genderLabel);
        registerPanel.add(genderPanel);
        
        registerPanel.add(courseLabel);
        registerPanel.add(courseComboBox);
        
        registerPanel.add(addressLabel);
        registerPanel.add(addressScrollPane);
        
        registerPanel.add(termsLabel);
        registerPanel.add(termsCheckBox);
        
        registerPanel.add(emptyLabel);
        registerPanel.add(submitButton);

        // Nest the panels together
        centerPanel.add(registerPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Add main panel to the frame and display it
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
