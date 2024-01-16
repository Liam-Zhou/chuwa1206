package com.chuwa.transaction.payload;

import com.chuwa.transaction.entity.Account;

import java.util.List;


public class BankStatementDto {

    private String username;
    private String address;
    private String statePeriod;
    private List<AccountDto> account;
    private List<TransactionDto> txn;

    public BankStatementDto() {
    }

    public BankStatementDto(String username, String address, String statePeriod, List<AccountDto> account, List<TransactionDto> txn) {
        this.username = username;
        this.address = address;
        this.statePeriod = statePeriod;
        this.account = account;
        this.txn = txn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatePeriod() {
        return statePeriod;
    }

    public void setStatePeriod(String statePeriod) {
        this.statePeriod = statePeriod;
    }

    public List<AccountDto> getAccount() {
        return account;
    }

    public void setAccount(List<AccountDto> account) {
        this.account = account;
    }

    public List<TransactionDto> getTxn() {
        return txn;
    }

    public void setTxn(List<TransactionDto> txn) {
        this.txn = txn;
    }
}
