package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.Approval;
import edu.mum.cs.cs425.finalproject.senteapp.repository.ApprovalRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalServirceImplementation implements ApprovalService {
    @Autowired
    private ApprovalRepository approvalRepository;
    @Override
    public Approval saveApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    @Override
    public List<Approval> getAllApprovals(Account account) {
        return  approvalRepository.findByAccountAccountId(account.getAccountId());
    }

    @Override
    public List<Approval> getAllApprovalsById(Long Id) {
        return approvalRepository.findByAccountAccountId(Id);
    }


}
