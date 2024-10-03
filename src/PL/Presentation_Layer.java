package PL;

import BLL.BookBO;
import DAL.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Presentation_Layer extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;
    private BookBO bookBO;

    public Presentation_Layer() {
        setTitle("Book Search Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search for a book by title: "));
        searchField = new JTextField(20);
        topPanel.add(searchField);
        searchButton = new JButton("Search");
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        bookBO = new BookBO(); // Instantiate the Business Object

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBooks(); // Trigger search when button is clicked
            }
        });
    }

    private void searchBooks() {
        String title = searchField.getText(); // Get title from input field
        List<Book> books = bookBO.searchBooksByTitle(title); // Call the search method

        resultArea.setText(""); // Clear previous results
        if (books.isEmpty()) {
            resultArea.append("No books found.");
        } else {
            for (Book book : books) {
                resultArea.append(book.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Presentation_Layer().setVisible(true);
        });
    }
}
