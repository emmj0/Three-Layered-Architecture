package BLL;

import DAL.BookDAO;
import DAL.Book;

import java.util.List;

public class BookBO {
    private BookDAO bookDAO;

    public BookBO() {
        bookDAO = new BookDAO(); // it an issue because there is no dependency injection so there is tight coupling
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookDAO.searchBooksByTitle(title);
    }
}
