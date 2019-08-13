package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.repository.MemberRepository;
import org.springframework.stereotype.Service;

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
}
