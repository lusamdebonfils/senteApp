package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberService {
        public abstract Member saveMember(Member member);
        public abstract Page<Member> getAllMembers(int pageNo);
        public abstract List<Member> getAllMembers();
        public abstract Member getMemberById(Long memberId);
        public abstract Double calculateMemberAccountBalance(Long memberId);
        public abstract Page<Member> searchMembers(String search, Integer pageNo);
        public abstract Page<Member> getAllMembersPerAccount(Account acct, int pageNo);
        public abstract List<Member> getAllByAccountID(Long accounID);




        public abstract List<Member> getMembersByAccount(Account account);
        public Member getMemberByEmail(String email);

}
