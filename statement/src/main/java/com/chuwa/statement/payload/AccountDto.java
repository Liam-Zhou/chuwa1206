package com.chuwa.statement.payload;


import com.chuwa.statement.entity.User;

public class AccountDto {
    private Long id;

    private long userId;
    private String routingNumber;
    private String accountNumber;

    public AccountDto(long userId, String routingNumber, String accountNumber) {
        this.userId = userId;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    public AccountDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
