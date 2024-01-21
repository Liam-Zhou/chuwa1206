package org.chuwa.bankstatement.payload;

import java.util.List;

public class BankStatement {
    private String username;
    private String addr;
    private String accountId;
    private Integer periodStartMonth;
    private Integer periodEndMonth;
    private List<TxnDto> transactions;

    public BankStatement(String username, String addr, String accountId, List<TxnDto> transactions) {
        this.username = username;
        this.addr = addr;
        this.accountId = accountId;
        this.transactions = transactions;
    }

    public Integer getPeriodStartMonth() {
        return periodStartMonth;
    }

    public void setPeriodStartMonth(Integer periodStartMonth) {
        this.periodStartMonth = periodStartMonth;
    }

    public Integer getPeriodEndMonth() {
        return periodEndMonth;
    }

    public void setPeriodEndMonth(Integer periodEndMonth) {
        this.periodEndMonth = periodEndMonth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<TxnDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TxnDto> transactions) {
        this.transactions = transactions;
    }
}
