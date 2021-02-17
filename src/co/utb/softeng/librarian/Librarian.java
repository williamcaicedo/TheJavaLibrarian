package co.utb.softeng.librarian;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.utb.softeng.utils.Member;



public class Librarian {

    public static void main(String[] args) throws Exception{
        //Cargar contenidos del archivo de miembros
        Map<String, Member> members = new HashMap<String, Member>();
        Scanner fileScanner = new Scanner(new File("src/members.data"));
        while (fileScanner.hasNext()) {
            String[] line = fileScanner.nextLine().split(",");
            String memberId = line[0];
            String memberName = line[1];
            String[] memberBooks = line[2].substring(1, line[2].length() - 1).split(";");
            members.put(memberId, new Member(memberId, memberName, Arrays.asList(memberBooks)));  
        }
        fileScanner.close();
        
        //Imprimir en pantalla y preguntar por el id del miembro a consultar
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hey, I'm the librarian, what's your ID number?");
        String id = reader.readLine();
        //Buscar en el mapa la información del miembro
        Member member = members.get(id);
        //Imprimir en pantalla la información del miembro
        System.out.println("Your ID is:" + member.getId());
        System.out.println("Your name is: " + member.getName());
        System.out.println("Books you currently have: " + member.getBooks().toString());
    }
    
}
