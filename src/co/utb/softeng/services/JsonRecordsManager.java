package co.utb.softeng.services;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.utb.softeng.entities.Member;

public class JsonRecordsManager implements RecordsManager {

    private String filePath;
    private ObjectMapper mapper;
    private Map<String, Member> records;

    public JsonRecordsManager(String filePath) throws Exception{
        this.filePath = filePath;
        this.init();
    }

    private void init() throws Exception{
        String recordsString = Files.readString(Paths.get(this.filePath), StandardCharsets.UTF_8);
        this.mapper = new ObjectMapper();
        this.records = this.mapper.readValue(recordsString, new TypeReference<Map<String, Member>>(){});
    }

    @Override
    public Member getMember(String memberId) {
        return this.records.get(memberId);
    }
    
}
