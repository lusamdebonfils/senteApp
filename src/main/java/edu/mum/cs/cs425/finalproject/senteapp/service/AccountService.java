package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import org.springframework.data.domain.Page;

public interface AccountService {

    public Page<Account> getAllAccounts(int pageNo);
    public Account saveAccount(Account account);

}
