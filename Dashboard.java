import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Dashboard {
    public static void main(String[] args) {

        
new LoginPage();
    }
}



class Book {

    String title;
    String author;
    String category;

    Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Title: "+title
                +"Author: " +author
                + "Category: "+category;
    }
}



class LoginPage {

    LoginPage() {

        JFrame frame = new JFrame("Login - Library Management System");

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(exitButton);

        frame.add(panel);

        
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password =
                        new String(passwordField.getPassword());

                if (username.equals("admin")
                        && password.equals("1234")) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Login Successful!"
                    );

                    frame.dispose();

                    new LibraryManagementSystem();

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Username or Password!",
                            "Login Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        
        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}




class LibraryManagementSystem {

    
    static ArrayList<Book> books = new ArrayList<>();

    LibraryManagementSystem() {

        JFrame frame =
                new JFrame("Library Management System");

        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(2, 4, 15, 15)
        );


        JButton addBookButton =
                new JButton("Add Book");

        JButton viewBooksButton =
                new JButton("View Books");

        JButton searchBooksButton =
                new JButton("Search Books");

        JButton logoutButton =
                new JButton("Logout");

        JButton exitButton =
                new JButton("Exit");


        panel.add(addBookButton);
        panel.add(viewBooksButton);
        panel.add(searchBooksButton);
        panel.add(logoutButton);
        panel.add(exitButton);


      
        addBookButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        new Addbook();
                    }
                }
        );


     

        viewBooksButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        new ViewBooks();
                    }
                }
        );


   

        searchBooksButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        new SearchBooks();
                    }
                }
        );


      

        logoutButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        int choice =
                                JOptionPane.showConfirmDialog(
                                        frame,
                                        "Are you sure you want to logout?",
                                        "Logout",
                                        JOptionPane.YES_NO_OPTION
                                );

                        if (choice ==
                                JOptionPane.YES_OPTION) {

                            frame.dispose();

                            new LoginPage();
                        }
                    }
                }
        );


      

        exitButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        int choice =
                                JOptionPane.showConfirmDialog(
                                        frame,
                                        "Are you sure you want to exit?",
                                        "Exit",
                                        JOptionPane.YES_NO_OPTION
                                );

                        if (choice ==
                                JOptionPane.YES_OPTION) {

                            System.exit(0);
                        }
                    }
                }
        );


        frame.add(panel);

        frame.setVisible(true);
    }
}





class Addbook {

    Addbook() {

        JFrame frame = new JFrame("Add Book");

        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5, 2, 10, 10)
        );


        JLabel titleLabel =
                new JLabel("Title:");

        JTextField titleField =
                new JTextField(20);


        JLabel authorLabel =
                new JLabel("Author:");

        JTextField authorField =
                new JTextField(20);


        JLabel categoryLabel =
                new JLabel("Category:");


        JComboBox<String> categoryField =
                new JComboBox<>(
                        new String[]{
                                "Novel",
                                "Science Fiction",
                                "Self-help",
                                "Biography",
                                "History",
                                "Children's"
                        }
                );


        JButton addButton =
                new JButton("Add Book");

        JButton clearButton =
                new JButton("Clear");


        // Add components
        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(authorLabel);
        panel.add(authorField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(addButton);
        panel.add(clearButton);


       

        clearButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        titleField.setText("");
                        authorField.setText("");

                        categoryField.setSelectedIndex(0);
                    }
                }
        );


        

        addButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        String title =
                                titleField.getText().trim();

                        String author =
                                authorField.getText().trim();

                        String category =
                                (String)
                                categoryField.getSelectedItem();


                        
                        if (title.isEmpty()
                                || author.isEmpty()) {

                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Please enter Title and Author!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );

                            return;
                        }


                    
                        Book book =
                                new Book(
                                        title,
                                        author,
                                        category
                                );


            
                        LibraryManagementSystem.books.add(book);


                        JOptionPane.showMessageDialog(
                                frame,
                                "Book Added Successfully!\n\n"
                                + "Title: " + title
                                + "\nAuthor: " + author
                                + "\nCategory: " + category
                        );


            
                        titleField.setText("");
                        authorField.setText("");
                        categoryField.setSelectedIndex(0);
                    }
                }
        );


        frame.add(panel);

        frame.setVisible(true);
    }
}



class ViewBooks {

    ViewBooks() {

        JFrame frame =
                new JFrame("View Books");

        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

6

        JTextArea bookArea =
                new JTextArea();

        bookArea.setEditable(false);

        bookArea.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );


        
        JScrollPane scrollPane =
                new JScrollPane(bookArea);
    
        if (LibraryManagementSystem.books.isEmpty()) {

            bookArea.setText(
                    "No books available."
            );

        } else {

            StringBuilder text =
                    new StringBuilder();

            text.append("========== LIBRARY BOOKS ==========\n\n");


            int number = 1;

            for (Book book :
                    LibraryManagementSystem.books) {

                text.append(number)
                        .append(". ")
                        .append(book.toString())
                        .append("\n\n");

                number++;
            }


            bookArea.setText(
                    text.toString()
            );
        }


        frame.add(scrollPane);

        frame.setVisible(true);
    }
}



class SearchBooks {

    SearchBooks() {

        JFrame frame =
                new JFrame("Search Books");

        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);


        JPanel topPanel =
                new JPanel(
                        new FlowLayout()
                );


        JLabel searchLabel =
                new JLabel("Search:");

        JTextField searchField =
                new JTextField(25);

        JButton searchButton =
                new JButton("Search");


        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);


        
        JTextArea resultArea =
                new JTextArea();

        resultArea.setEditable(false);

        resultArea.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );


        JScrollPane scrollPane =
                new JScrollPane(resultArea);


    

        searchButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        String searchText =
                                searchField.getText()
                                        .trim()
                                        .toLowerCase();


                        if (searchText.isEmpty()) {

                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Please enter a search term!"
                            );

                            return;
                        }


                        StringBuilder result =
                                new StringBuilder();

                        int count = 0;


                        for (Book book :
                                LibraryManagementSystem.books) {


                            // Search title, author and category
                            if (book.title
                                    .toLowerCase()
                                    .contains(searchText)

                                    || book.author
                                    .toLowerCase()
                                    .contains(searchText)

                                    || book.category
                                    .toLowerCase()
                                    .contains(searchText)) {
                                    
                                count++;
                                result.append(count)
                                        .append(". ")
                                        .append(book.toString())
                                        .append("\n\n");
                            }
                        }


                        if (count == 0) {

                            resultArea.setText(
                                    "No books found for: "
                                    + searchText
                            );

                        } else {

                            resultArea.setText(
                                    "========== SEARCH RESULTS ==========\n\n"
                                    + result.toString()
                            );
                        }
                    }
                }
        );


        // Enter key also performs search
        searchField.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        searchButton.doClick();
                    }
                }
        );


        frame.setLayout(
                new BorderLayout(10, 10)
        );

        frame.add(
                topPanel,
                BorderLayout.NORTH
        );

        frame.add(
                scrollPane,
                BorderLayout.CENTER
        );


        frame.setVisible(true);
    }
}
