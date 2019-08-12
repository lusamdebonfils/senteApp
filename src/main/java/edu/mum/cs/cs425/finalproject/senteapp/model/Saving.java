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
    private Double amountSaved;

    public Saving() {
    }

    public Saving(LocalDate paymentDate, Double amountSaved) {
        this.paymentDate = paymentDate;
        this.amountSaved = amountSaved;
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

    public Double getAmountSaved() {
        return amountSaved;
    }

    public void setAmountSaved(Double amountSaved) {
        this.amountSaved = amountSaved;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "savingId=" + savingId +
                ", paymentDate=" + paymentDate +
                ", amountSaved=" + amountSaved +
                '}';
    }
}
