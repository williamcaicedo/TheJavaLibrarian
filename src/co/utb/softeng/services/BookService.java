package co.utb.softeng.services;

import java.util.List;

import co.utb.softeng.entities.Book;

public interface BookService {

    public Book getBook(Long bookId);
    public List<Book> getAllBooksByAlphabeticalOrder();
    public Book saveBook(Book book);
    
}
