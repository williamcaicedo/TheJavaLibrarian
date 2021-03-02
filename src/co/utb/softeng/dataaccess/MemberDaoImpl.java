package co.utb.softeng.dataaccess;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.utb.softeng.entities.Member;

public class MemberDaoImpl implements MemberDao {

    private String filePath;
    private ObjectMapper mapper;
    private Map<Long, Member> members;

    public MemberDaoImpl(String filePath) throws Exception {
        this.filePath = filePath;
        this.init();
    }

    private void init() throws Exception {
        String recordsString = Files.readString(Paths.get(this.filePath), StandardCharsets.UTF_8);
        this.mapper = new ObjectMapper();
        this.members = this.mapper.readValue(recordsString, new TypeReference<Map<Long, Member>>() {
        });
    }

    @Override
    public Member getMember(Long memberId) {
        return this.members.get(memberId);
    }

    @Override
    public Member saveMember(Member member) {
        this.members.put(member.getId(), member);
        try {
            this.mapper.writeValueAsString(this.members);

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<Member>(this.members.values());
    }
    
}
