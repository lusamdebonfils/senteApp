package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Long loanNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Installment> installmentList;
    private LocalDate dateOfIssue;
    private LocalDate dueDate;
    private Double loanAmount;
    private Double interestRate;

    public Loan() {
    }

    public Loan(Long loanNumber, List<Installment> installmentList, LocalDate dateOfIssue, LocalDate dueDate, Double loanAmount, Double interestRate) {
        this.loanNumber = loanNumber;
        this.installmentList = installmentList;
        this.dateOfIssue = dateOfIssue;
        this.dueDate = dueDate;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    public void setInstallmentList(List<Installment> installmentList) {
        this.installmentList = installmentList;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanNumber=" + loanNumber +
                ", installmentList=" + installmentList +
                ", dateOfIssue=" + dateOfIssue +
                ", dueDate=" + dueDate +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                '}';
    }
}
