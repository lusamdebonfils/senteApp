package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "savings")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingId;
    private LocalDate paymentDate;
    private Double amountPaid;
    private Boolean verifiedPayment;

    public Saving() {
    }

    public Saving(LocalDate paymentDate, Double amountPaid, Boolean verifiedPayment) {
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.verifiedPayment = false;

    }

    public Long getSavingId() {
        return savingId;
    }

    public void setSavingId(Long savingId) {
        this.savingId = savingId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }


    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Boolean getVerifiedPayment() {
        return verifiedPayment;
    }

    public void setVerifiedPayment(Boolean verifiedPayment) {
        this.verifiedPayment = verifiedPayment;
    }
}
