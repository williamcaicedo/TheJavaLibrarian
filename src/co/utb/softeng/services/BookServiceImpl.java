package co.utb.softeng.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import co.utb.softeng.dataaccess.BookDao;
import co.utb.softeng.entities.Book;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book getBook(Long bookId) {
        return this.bookDao.getBook(bookId);
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookDao.saveBook(book);
    }

    @Override
    public List<Book> getAllBooksByAlphabeticalOrder() {
        List<Book> allBooks = this.bookDao.getAllBooks();
        return allBooks.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }
    
}
