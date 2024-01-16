package com.chuwa.bankstatement.payload;

import java.time.LocalDateTime;

public class TransactionDto {

    private Long id;
    private Long amount;
    private String description;
    private LocalDateTime createDateTime;
    private String accountNumber;

    public TransactionDto() {}

    public TransactionDto(Long id, Long amount, String description, LocalDateTime createDateTime, String accountNumber) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.createDateTime = createDateTime;
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
