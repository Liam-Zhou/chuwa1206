package com.chuwa.BankStatement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Account {
    @Id
    private String accountNumber;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column
    private String routingNumber;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private List<Txn> Txns;
    @OneToMany(mappedBy = "account")
    private List<Txn> Txns;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
