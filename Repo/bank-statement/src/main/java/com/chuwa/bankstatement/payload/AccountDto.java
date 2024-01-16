package com.chuwa.bankstatement.payload;


public class AccountDto {
    private long id;

    private String routingNumber;

    private String accountNumber;
    private long userId;

    public AccountDto() {
    }

    public AccountDto(long id, String routingNumber, String accountNumber, long userId) {
        this.id = id;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
