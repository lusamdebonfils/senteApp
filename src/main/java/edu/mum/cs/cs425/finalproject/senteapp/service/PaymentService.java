package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Loan;
import edu.mum.cs.cs425.finalproject.senteapp.model.Saving;

public interface PaymentService {

    public abstract Saving saveSaving(Saving saving);
    public abstract Loan saveLoan(Loan loan);
}
