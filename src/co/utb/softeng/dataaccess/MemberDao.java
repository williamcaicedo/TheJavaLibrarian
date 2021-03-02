package co.utb.softeng.dataaccess;

import java.util.List;

import co.utb.softeng.entities.Member;

public interface MemberDao {
    public Member getMember(Long memberId);
    public List<Member> getAllMembers();
    public Member saveMember(Member member);
    
}
