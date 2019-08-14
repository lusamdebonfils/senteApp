package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalId;
    @OneToOne(cascade = CascadeType.ALL)
    private Loan loan;
    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

    public Approval() {
    }

    public Approval(Loan loan, Account account) {
        this.loan = loan;
        this.account = account;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "approvalId=" + approvalId +
                ", loan=" + loan +
                ", account=" + account +
                '}';
    }
}
