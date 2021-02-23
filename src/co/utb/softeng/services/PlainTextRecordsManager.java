package co.utb.softeng.services;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.utb.softeng.entities.Member;

public class PlainTextRecordsManager implements RecordsManager {

    private String filePath;
    private Map<String, Member> records;

    public PlainTextRecordsManager(String filePath) throws Exception {
        this.filePath = filePath;
        this.init();

    }
    
    private void init() throws Exception{
        this.records = new HashMap<String, Member>();
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
