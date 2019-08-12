package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "installments")
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long installmentId;
    private Integer installmentNumber;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private Double installmentAmount;

    public Installment() {
    }

    public Installment(Integer installmentNumber, LocalDate dueDate, LocalDate paymentDate, Double installmentAmount) {
        this.installmentNumber = installmentNumber;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.installmentAmount = installmentAmount;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "installmentId=" + installmentId +
                ", installmentNumber=" + installmentNumber +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", installmentAmount=" + installmentAmount +
                '}';
    }
}
