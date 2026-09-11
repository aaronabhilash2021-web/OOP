import javax.swing.*;
import java.awt.*;

public class RegisterForm {
    public static void main(String[] args) {

        // Main window
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel to center the registration box
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 80));

        // Registration box (4 rows, 2 columns)
        JPanel registerPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        registerPanel.setPreferredSize(new Dimension(450, 220)); 
        registerPanel.setBorder(BorderFactory.createTitledBorder("Student Registration"));

        // Row 1: Name (Updated with Multi-line Text Area and Scroll Pane)
        JLabel nameLabel = new JLabel("Name:");
        
        // Changed to JTextArea to allow multi-line text entry
        JTextArea nameArea = new JTextArea(2, 20); 
        nameArea.setLineWrap(true);       // Wrap words at the boundary
        nameArea.setWrapStyleWord(true);   // Wrap at word boundaries, not mid-word
        
        // Wrap the text area inside a JScrollPane
        JScrollPane nameScrollPane = new JScrollPane(nameArea);
        nameScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show scrollbar
        
        registerPanel.add(nameLabel);
        registerPanel.add(nameScrollPane); // Add the scroll pane container, not the raw text area

        // Row 2: Gender
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

        // Row 3: Course dropdown
        JLabel courseLabel = new JLabel("Course:");
        String[] courses = {"Computer Science", "Business Administration", "Engineering", "Arts"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);
        registerPanel.add(courseLabel);
        registerPanel.add(courseComboBox);

        // Row 4: Submit Button
        JLabel emptyLabel = new JLabel(""); 
        JButton submitButton = new JButton("Register");
        registerPanel.add(emptyLabel);
        registerPanel.add(submitButton);

        // Assemble the UI hierarchy
        centerPanel.add(registerPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Make the window visible
        frame.setVisible(true);
    }
}
