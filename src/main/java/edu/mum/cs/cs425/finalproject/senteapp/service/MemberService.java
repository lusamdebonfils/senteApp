package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberService {
        public abstract Member saveMember(Member member);
        public abstract Page<Member> getAllMembers(int pageNo);
        public abstract Member getMemberById(Long memberId);
        public abstract Page<Member> searchMembers(String search, Integer pageNo);

}
