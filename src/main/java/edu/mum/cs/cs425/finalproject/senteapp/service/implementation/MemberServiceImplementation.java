package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.repository.MemberRepository;

import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImplementation implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImplementation(MemberRepository memberRepository){
        this.memberRepository =  memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Page<Member> getAllMembers(int pageNo) {
        return memberRepository.findAll(PageRequest.of(pageNo, 3,Sort.by("firstName")));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }


    @Override
    public Double calculateMemberAccountBalance(Long memberId) {
        return 0.0;

    }

    @Override
    public Page<Member> searchMembers(String search, Integer pageNo) {
        return memberRepository.findAllByLastNameContainsOrFirstNameContainsOrMiddleNameContains(search, search, search, PageRequest.of(pageNo, 2,Sort.by("firstName")));

    }

    @Override
    public List<Member> getMembersByAccount(Account account) {
        return memberRepository.findByAccountEquals(account);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmailEquals(email);
    }
}
