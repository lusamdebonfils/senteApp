package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {

    public Page<Account> getAllAccounts(int pageNo);
    public Account saveAccount(Account account);
    public List<Account> getAllAccountsList();

}
