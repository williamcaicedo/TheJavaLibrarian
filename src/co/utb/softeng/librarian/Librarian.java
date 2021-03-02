package co.utb.softeng.librarian;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import co.utb.softeng.entities.Member;
import co.utb.softeng.services.BookService;
import co.utb.softeng.services.MemberService;



public class Librarian {

    private MemberService memberService;
    private BookService bookService;

    public Librarian(MemberService memberService, BookService bookService) {
        this.memberService = memberService;
        this.bookService = bookService;
    }

    public void run() throws Exception{

        //Interacción con el usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hey, I'm the librarian, what's your ID number?");
        String id = reader.readLine();
        //Consultar la información del miembro solicitada
        Member member = this.memberService.getMember(Long.parseLong(id));
        //Mostrar la información
        if (member != null) {
            System.out.println("Your ID is:" + member.getId());
            System.out.println("Your name is: " + member.getName());
            System.out.println("Books you currently have: " + member.getBooks().toString());
        }
        else {
            System.out.println("Member not found :(");
        }

    }
    
}
