package com.chuwa.learn.statement.payload;

import java.time.LocalDateTime;

public class AccountDto {
    private long accountId;
    private long userId;
    private String accountNumber;
    private String routingNumber;

    public AccountDto() {
    }

    public AccountDto(long accountId, long userId, String accountNumber, String routingNumber) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
}
