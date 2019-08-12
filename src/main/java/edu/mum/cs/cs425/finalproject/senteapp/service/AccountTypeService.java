package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.AccountType;
import org.springframework.data.domain.Page;

public interface AccountTypeService {
    public Page<AccountType> getAllAccountTypes(int pageNo);
}