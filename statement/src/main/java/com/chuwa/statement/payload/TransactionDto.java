package com.chuwa.statement.payload;

import com.chuwa.statement.entity.Account;


import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private LocalDateTime date;
    private String description;
    private int amount;
    private long accountId;

    public TransactionDto(LocalDateTime date, String description, int amount, long accountId) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.accountId = accountId;
    }

    public TransactionDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
