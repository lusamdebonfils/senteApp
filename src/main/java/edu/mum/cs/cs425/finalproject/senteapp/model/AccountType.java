package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;

@Entity
@Table(name = "accounttypes")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTypeId;
    private Integer accountTypeNumber;
    private String accountTypeName;

    public AccountType() {
    }

    public AccountType(Integer accountTypeNumber, String accountTypeName) {
        this.accountTypeNumber = accountTypeNumber;
        this.accountTypeName = accountTypeName;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Integer getAccountTypeNumber() {
        return accountTypeNumber;
    }

    public void setAccountTypeNumber(Integer accountTypeNumber) {
        this.accountTypeNumber = accountTypeNumber;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return accountTypeNumber + " - " + accountTypeName;
    }
}
