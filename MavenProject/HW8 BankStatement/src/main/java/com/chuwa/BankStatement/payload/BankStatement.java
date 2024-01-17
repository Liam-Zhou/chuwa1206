package com.chuwa.BankStatement.payload;

import java.util.Date;
import java.util.List;

public class BankStatement {
    private String username;
    private String addr;
    private String accountId;
    private List<TxnDto> txns;

    public BankStatement(String username, String addr, String accountId, List<TxnDto> txns) {
        this.username = username;
        this.addr = addr;
        this.accountId = accountId;
        this.txns = txns;
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

    public List<TxnDto> getTxns() {
        return txns;
    }

    public void setTxns(List<TxnDto> txns) {
        this.txns = txns;
    }

}

//class TxnList{
//    private Date date;
//    private String description;
//    private double amount;
//}
