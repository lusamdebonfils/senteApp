package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Member;

import java.util.List;

public interface MemberService {
        public abstract Member saveMember(Member member);
        public abstract List<Member> getAllMembers();
        public abstract Member getMemberById(Long memberId);

}
