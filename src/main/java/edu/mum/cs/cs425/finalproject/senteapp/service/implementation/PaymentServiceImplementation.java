package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Installment;
import edu.mum.cs.cs425.finalproject.senteapp.model.Loan;
import edu.mum.cs.cs425.finalproject.senteapp.model.Saving;
import edu.mum.cs.cs425.finalproject.senteapp.repository.InstallmentRepository;
import edu.mum.cs.cs425.finalproject.senteapp.repository.LoanRepository;
import edu.mum.cs.cs425.finalproject.senteapp.repository.SavingRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.InstallmentService;
import edu.mum.cs.cs425.finalproject.senteapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private SavingRepository savingRepository;

    @Autowired
    private InstallmentRepository installmentRepository;
    @Override
    public Saving saveSaving(Saving saving) {
        return savingRepository.save(saving);
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Installment saveInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }
}