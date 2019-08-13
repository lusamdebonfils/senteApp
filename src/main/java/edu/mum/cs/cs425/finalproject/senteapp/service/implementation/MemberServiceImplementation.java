package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.repository.MemberRepository;

import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
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
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    @Override
    public Double calculateMemberAccountBalance(Long memberId) {
        return null;
    }
}
