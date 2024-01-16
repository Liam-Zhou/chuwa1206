package com.chuwa.BankStatement.payload;

import com.chuwa.BankStatement.entity.Txn;

import java.util.Date;

public class TxnDto {
    private Date date;
    private String description;
    private double amount;

    public TxnDto(Txn txn) {
        this.date = txn.getDate();
        this.description = txn.getDescription();
        this.amount = txn.getAmount();
    }

    // Getters and Setters
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