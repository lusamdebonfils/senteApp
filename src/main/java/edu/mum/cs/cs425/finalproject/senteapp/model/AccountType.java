package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;

@Entity
@Table(name = "accounttypes")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTypeId;
    private String accountTypeName;

    public AccountType() {
    }

    public AccountType(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
