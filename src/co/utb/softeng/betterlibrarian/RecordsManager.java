package co.utb.softeng.betterlibrarian;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.utb.softeng.utils.Member;

public class RecordsManager {

    private String filePath;
    private Map<String, Member> records;

    public RecordsManager(String filePath){
        this.filePath = filePath;
        try {
            this.init();
        }
        catch (Exception e) {
            System.err.println("Unable to initialize member records: " + e.toString());
        }

    }
    
    private void init() throws Exception{
        records = new HashMap<String, Member>();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNext()) {
            String[] line = fileScanner.nextLine().split(",");
            String memberId = line[0];
            String memberName = line[1];
            String[] memberBooks = line[2].substring(1, line[2].length() - 1).split(";");
            this.records.put(memberId, new Member(memberId, memberName, Arrays.asList(memberBooks)));  
        }
        fileScanner.close();
        
    }

    public Member getMember(String memberId) {
        return this.records.get(memberId);
    }
}
