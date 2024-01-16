package com.chuwa.transaction.payload;

public class AccountDto {
    private long accountId;
    private long userId;
    private String routingNumber;

    private String accountNumber;

    public AccountDto() {
    }

    public AccountDto(long accountId, long userId, String routingNumber, String accountNumber) {
        this.accountId = accountId;
        this.userId = userId;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
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

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
