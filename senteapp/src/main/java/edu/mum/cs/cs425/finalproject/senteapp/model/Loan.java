package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private Long loanNumber;
    private Integer installmentNumber;
    private LocalDate paymentDate;

    public Loan() {
    }

    public Loan(Long loanNumber, Integer installmentNumber, LocalDate paymentDate) {
        this.loanNumber = loanNumber;
        this.installmentNumber = installmentNumber;
        this.paymentDate = paymentDate;
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

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanNumber=" + loanNumber +
                ", installmentNumber=" + installmentNumber +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
