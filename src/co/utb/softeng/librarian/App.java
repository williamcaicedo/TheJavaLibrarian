package co.utb.softeng.librarian;

import co.utb.softeng.services.*;
import co.utb.softeng.services.RecordsManager;

public class App {
    public static void main(String[] args) {
        try {
            //RecordsManager recordsManager = new PlainTextRecordsManager("src/members.data");
            RecordsManager recordsManager = new JsonRecordsManager("src/members.json");
            Librarian librarian = new Librarian(recordsManager);
            librarian.run();
        } catch (Exception e) {
            System.err.println("Unable to initialize member records: " + e.toString());
        }
        
        
    }
}
