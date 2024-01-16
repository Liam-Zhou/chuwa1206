package com.chuwa.bankstatement.payload;

import java.time.Month;
import java.util.List;

public class StatementDto {

    private String name;
    private String address;
    private Month month;
    private String accountNumber;
    private List<TransactionDto> transactions;

    public StatementDto() {}

    public StatementDto(String name, String address, Month month, String accountNumber, List<TransactionDto> transactions) {
        this.name = name;
        this.address = address;
        this.month = month;
        this.accountNumber = accountNumber;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
