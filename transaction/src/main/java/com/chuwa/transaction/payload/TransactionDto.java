package com.chuwa.transaction.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private long TransactionId;

    private long accountId;

    private String description;

    private BigDecimal amount;

    private LocalDateTime createDateTime;



    public TransactionDto() {
    }

    public TransactionDto(long transactionId, long accountId, String description, BigDecimal amount, LocalDateTime createDateTime) {
        TransactionId = transactionId;
        this.accountId = accountId;
        this.description = description;
        this.amount = amount;
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(long transactionId) {
        TransactionId = transactionId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
