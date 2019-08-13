package edu.mum.cs.cs425.finalproject.senteapp.service;
import edu.mum.cs.cs425.finalproject.senteapp.model.Loan;
import edu.mum.cs.cs425.finalproject.senteapp.model.Member;

import java.util.List;

public interface LoanService {
    public Loan saveLoanRecord(Loan s);
    public Double loanValidity(List<Member> members);

}
