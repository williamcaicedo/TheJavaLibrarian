package co.utb.softeng.librarian;

import co.utb.softeng.dataaccess.BookDaoImpl;
import co.utb.softeng.dataaccess.MemberDaoImpl;
import co.utb.softeng.services.BookService;
import co.utb.softeng.services.BookServiceImpl;
import co.utb.softeng.services.MemberService;
import co.utb.softeng.services.MemberServiceImpl;

public class App {
    public static void main(String[] args) {
        try {
            MemberService memberService = new MemberServiceImpl(new MemberDaoImpl("src/members.json"));
            BookService bookService = new BookServiceImpl(new BookDaoImpl("src/books.json"));
            Librarian librarian = new Librarian(memberService, bookService);
            librarian.run();
        } catch (Exception e) {
            System.err.println("Unable to initialize member records: " + e.toString());
        }
        
        
    }
}
