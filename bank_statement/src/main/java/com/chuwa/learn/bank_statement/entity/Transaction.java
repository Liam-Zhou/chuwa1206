package com.chuwa.learn.bank_statement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "transactions"
)
public class Transaction {
    @Column(name = "account_id", nullable = false)
    private long accountId;

    @Column(name = "user_id", nullable = false)
    private LocalDateTime date;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private double amount;

    public Transaction() {
    }

    public Transaction(long accountId, LocalDateTime date, String description, double amount) {
        this.accountId = accountId;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
