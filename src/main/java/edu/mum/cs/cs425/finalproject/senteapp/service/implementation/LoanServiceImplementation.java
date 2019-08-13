package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Loan;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.repository.LoanRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.LoanService;
import edu.mum.cs.cs425.finalproject.senteapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImplementation implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private MemberService memberService;
    @Override
    public Loan saveLoanRecord(Loan s) {
        return loanRepository.save(s);
    }

    @Override
    public Double loanValidity(List<Member> members) {
        double totalEligibleLoanAmount = 0;
        for(Member member: members){
            totalEligibleLoanAmount += memberService.calculateMemberAccountBalance(member.getMemberId());
        }
        return totalEligibleLoanAmount;
    }

