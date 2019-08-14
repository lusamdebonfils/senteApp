package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Approval;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ApprovalService {
    public Approval saveApproval(Approval approval);
    public List<Approval> getAllApprovals(Account account);
}
