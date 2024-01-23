package com.chuwa.learn.statement.payload;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class TransactionDto {
    @NotEmpty
    private long AccountId;
    @NotEmpty
    private String date;
    private String description;
    @NotEmpty
    private double amount;

    public TransactionDto() {
    }

    public TransactionDto(long accountId, String date, String description, double amount) {
        AccountId = accountId;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public long getAccountId() {
        return AccountId;
    }

    public void setAccountId(long accountId) {
        AccountId = accountId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
