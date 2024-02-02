package com.chuwa.transaction.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private String routingNumber;

    private String accountNumber;




    public Account() {
    }

    public Account(long id, String routingNumber, String accountNumber, long userId) {
        this.id = id;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long accountId) {
        this.id = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
