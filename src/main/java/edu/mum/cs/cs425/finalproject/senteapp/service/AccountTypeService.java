package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.model.AccountType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountTypeService {
    public Page<AccountType> getAllAccountTypes(int pageNo);
    public AccountType addNewAccountType(AccountType accountType);
    public AccountType getAccountTypeById(Long accountTypeId);
    public List<AccountType> getAllAccountTypesList();
}
