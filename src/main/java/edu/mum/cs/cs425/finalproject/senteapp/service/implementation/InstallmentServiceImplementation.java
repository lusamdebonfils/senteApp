package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Installment;
import edu.mum.cs.cs425.finalproject.senteapp.repository.InstallmentRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.InstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstallmentServiceImplementation implements InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;
    @Override
    public Installment saveInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }
}
