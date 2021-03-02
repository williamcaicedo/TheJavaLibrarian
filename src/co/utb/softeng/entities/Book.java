package co.utb.softeng.entities;

public class Book {

    private Long id;
    private String title;


    public Book() {}

    public Book(String id, String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    

}
