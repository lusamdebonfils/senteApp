package edu.mum.cs.cs425.finalproject.senteapp.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfIssue;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double loanAmount;
    private Double interestRate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "firstSeconder")
    private Member firstSeconder;
   // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "firstSeconder")
  //  private Member firstSeconder;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondSeconder")
    private Member secondSeconder;

    public Loan() {
    }

    public Loan(Long loanNumber, List<Installment> installmentList, LocalDate applicationDate, LocalDate dateOfIssue, LocalDate dueDate, @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'") Double loanAmount, Double interestRate, Member firstSeconder, Member secondSeconder) {
        this.loanNumber = loanNumber;
        this.installmentList = installmentList;
        this.applicationDate = applicationDate;
        this.dateOfIssue = dateOfIssue;
        this.dueDate = dueDate;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.firstSeconder = firstSeconder;
        this.secondSeconder = secondSeconder;
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

    public Member getFirstSeconder() {
        return firstSeconder;
    }

    public void setFirstSeconder(Member firstSeconder) {
        this.firstSeconder = firstSeconder;
    }

    public Member getSecondSeconder() {
        return secondSeconder;
    }

    public void setSecondSeconder(Member secondSeconder) {
        this.secondSeconder = secondSeconder;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanNumber=" + loanNumber +
                ", installmentList=" + installmentList +
                ", applicationDate=" + applicationDate +
                ", dateOfIssue=" + dateOfIssue +
                ", dueDate=" + dueDate +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", firstSeconder=" + firstSeconder +
                ", secondSeconder=" + secondSeconder +
                '}';
    }
}
