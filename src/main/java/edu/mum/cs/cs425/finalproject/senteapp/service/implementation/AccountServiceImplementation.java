package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Account;
import edu.mum.cs.cs425.finalproject.senteapp.repository.AccountRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Page<Account> getAllAccounts(int pageNo) {
        return accountRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("accountName")));
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
