package edu.mum.cs.cs425.finalproject.senteapp.repository;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Page<Member> findAllByLastNameContainsOrFirstNameContainsOrMiddleNameContains(String s1, String s2, String s3, PageRequest pageNo);
    //public Page<Member> findMembersByAccount_AccountId(int accountID, PageRequest pageNo);
    public Page<Member> findMembersByAccount(Account account,PageRequest pageNo);
    public List<Member> getAllByAccount_AccountId(Long accountID);
}
