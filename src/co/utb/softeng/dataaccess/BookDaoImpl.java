package co.utb.softeng.dataaccess;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.utb.softeng.entities.Book;

public class BookDaoImpl implements BookDao {

    private String filePath;
    private ObjectMapper mapper;
    private Map<Long, Book> books;

    public BookDaoImpl(String filePath) throws Exception {
        this.filePath = filePath;
        this.init();
    }

    private void init() throws Exception {
        String recordsString = Files.readString(Paths.get(this.filePath), StandardCharsets.UTF_8);
        this.mapper = new ObjectMapper();
        this.books = this.mapper.readValue(recordsString, new TypeReference<Map<Long, Book>>() {
        });
    }

    @Override
    public Book getBook(Long bookId) {
        return this.books.get(bookId);
    }

    @Override
    public Book saveBook(Book book) {
        this.books.put(book.getId(), book);
        try {
            this.mapper.writeValueAsString(this.books);

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.books.values());
    }
    
}

    
