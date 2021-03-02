package co.utb.softeng.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Member {

    private Long id;
    private String name;
    private List<Book> books;

    public Member(){}

    public Member(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toString() {
        List<String> bookTitles = this.books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
        return this.id + "," + this.name + "," + "[" + String.join(",", bookTitles) + "]";
    }

    
    
}
