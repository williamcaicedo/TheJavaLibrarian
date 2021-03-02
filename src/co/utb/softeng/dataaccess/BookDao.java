package co.utb.softeng.dataaccess;

import java.util.List;

import co.utb.softeng.entities.Book;

public interface BookDao {
    public Book getBook(Long id);
    public List<Book> getAllBooks();
    public Book saveBook(Book book);
    
}
