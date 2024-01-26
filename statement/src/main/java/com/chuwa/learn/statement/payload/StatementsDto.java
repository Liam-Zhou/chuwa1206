package com.chuwa.learn.statement.payload;

import java.time.LocalDateTime;
import java.util.List;

public class StatementsDto {
    String userName;
    String addr;
    AccountDto accountDto;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<TransactionDto> transactions;

    public StatementsDto() {
    }

    public StatementsDto(String userName, String addr, AccountDto accountDto, LocalDateTime startDate, LocalDateTime endDate, List<TransactionDto> transactions) {
        this.userName = userName;
        this.addr = addr;
        this.accountDto = accountDto;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactions = transactions;
    }

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

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
