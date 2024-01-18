package com.example.bankstatement.payload;

import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.entity.UserProfile;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex D.
 */
public class AccountDto {
    private Long id;
    private Long accountID;
    private Long routingNumber;
    private Long accountNumber;
    private UserProfile user;
    private Set<Txn> txns;

    public Set<Txn> getTxns() {
        return txns;
    }

    public void setTxns(Set<Txn> txns) {
        this.txns = txns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public AccountDto() {
    }

    public AccountDto(Long id, Long accountID, Long routingNumber, Long accountNumber, UserProfile user) {
        this.id = id;
        this.accountID = accountID;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.user = user;
    }
}
