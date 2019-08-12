package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountNumber;
    private String accountName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    public Account() {
    }

    public Account(String accountNumber, String accountName, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
