package com.example.redbook.payload;

import java.time.LocalDateTime;

public class TransactionDto {
    private LocalDateTime date;

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

    public TransactionDto(LocalDateTime date, String description, int amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private String description;
    private int amount;

}
