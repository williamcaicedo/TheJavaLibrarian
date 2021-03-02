package co.utb.softeng.services;

import java.util.List;
import java.util.stream.Collectors;

import co.utb.softeng.dataaccess.MemberDao;
import co.utb.softeng.entities.Member;

public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member getMember(Long memberId) {
        Member member = this.memberDao.getMember(memberId);
        return member;
    }

    @Override
    public Member saveMember(Member member) {
        return this.memberDao.saveMember(member);
    }

    @Override
    public List<String> getBookTitlesByMember(Long memberId) {
        Member member = this.getMember(memberId);
        List<String> bookTitles = member.getBooks().stream().map(b -> b.getTitle()).collect(Collectors.toList());
        return bookTitles;
    }

    @Override
    public List<Member> getAllMembers() {
        return this.memberDao.getAllMembers();
    }
    
}
