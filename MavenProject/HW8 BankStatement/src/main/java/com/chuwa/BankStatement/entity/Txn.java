package com.chuwa.BankStatement.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Txn {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "accountNumber")
    private Account account;

    @Column
    private Date date;

    @Column
    private String description;

    @Column
    private double amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
