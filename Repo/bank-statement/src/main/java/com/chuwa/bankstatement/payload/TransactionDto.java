package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.entity.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {
    private long id;
    private Account account;
    private String description;
    private LocalDate date;
    private BigDecimal amount;

    public TransactionDto() {
    }

    public TransactionDto(long id, Account account, String description, LocalDate date, BigDecimal amount) {
        this.id = id;
        this.account = account;
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
