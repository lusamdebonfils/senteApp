package edu.mum.cs.cs425.finalproject.senteapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountNumber;
    private String accountName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_type_id")
    @NotNull(message = "Account type required")
    private AccountType accountType;

    @OneToOne(cascade = CascadeType.ALL)
    private Member accountManager;

    public Account() {
    }

    public Account(String accountNumber, String accountName, LocalDate dateCreated, @NotNull(message = "Account type required") AccountType accountType, Member accountManager) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.dateCreated = dateCreated;
        this.accountType = accountType;
        this.accountManager = accountManager;
    }

    public Member getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Member accountManager) {
        this.accountManager = accountManager;
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
                ", dateCreated=" + dateCreated +
                ", accountType=" + accountType +
                '}';
    }
}
