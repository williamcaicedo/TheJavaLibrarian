package co.utb.softeng.services;

import java.util.List;

import co.utb.softeng.entities.Member;

public interface MemberService {

    public Member getMember(Long memberId);
    public List<Member> getAllMembers();
    public Member saveMember(Member member);
    public List<String> getBookTitlesByMember(Long memberId);
    
}
