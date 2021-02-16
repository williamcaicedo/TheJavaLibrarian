package co.utb.softeng.betterlibrarian;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import co.utb.softeng.utils.Member;

public class BetterLibrarian {

    public static void main(String[] args) throws Exception{
        RecordsManager recordsManager = new RecordsManager("src/members.data");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hey, I'm the librarian, what's your ID number?");
        String id = reader.readLine();
        Member member = recordsManager.getMember(id);
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
