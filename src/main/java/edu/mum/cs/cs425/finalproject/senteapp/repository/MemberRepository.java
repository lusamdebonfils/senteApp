package edu.mum.cs.cs425.finalproject.senteapp.repository;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Page<Member> findAllByLastNameContainsOrFirstNameContainsOrMiddleNameContains(String s1, String s2, String s3, PageRequest pageNo);
    public List<Member> findByAccountEquals(Account account);
    public Member findByEmailEquals(String email);


}
