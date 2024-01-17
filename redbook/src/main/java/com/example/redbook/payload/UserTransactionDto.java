package com.example.redbook.payload;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserTransactionDto {
    private String userName;
    private String addr;
    private LocalDateTime fromDate;

    public UserTransactionDto(String userName, String addr, LocalDateTime fromDate, LocalDateTime toDate, long accountId) {
        this.userName = userName;
        this.addr = addr;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.accountId = accountId;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    private LocalDateTime toDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    private long accountId;

    private List<TransactionDto> transactions = new ArrayList<>();
}
