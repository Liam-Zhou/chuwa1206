package com.chuwa.learn.bank_statement.payload;

import java.time.LocalDateTime;

public class TransactionDto {
    private long transactionId;
    private long accountId;
    private LocalDateTime date;
    private String description;
    private double amount;

    public TransactionDto() {
    }

    public TransactionDto(long accountId, LocalDateTime date, String description, double amount) {
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
