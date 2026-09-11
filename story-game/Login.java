import javax.swing.*;
import java.awt.*;
public class Login{
    public static void main (String[] args){
        JFrame frame = new JFrame("Login");
        frame.setLayout(new GridLayout(3,2,10,10));
        JLabel usernameLabel=new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel=new JLabel("Password:");
        JTextField passwordField = new JTextField();
        
        JButton loginButton =new JButton("Login");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }

}
