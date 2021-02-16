package co.utb.softeng.utils;

import java.util.List;

public class Member {

    private String id;
    private String name;
    private List<String> books;

    public Member(String id, String name, List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public String toString() {
        return this.id + "," + this.name + "," + "[" + String.join(",", this.books) + "]";
    }

    
    
}
