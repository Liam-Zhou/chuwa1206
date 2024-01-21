package com.chuwa.transaction.payload;

import com.chuwa.transaction.entity.Account;

import java.util.HashMap;
import java.util.List;


public class BankStatementDto {

    private String username;
    private String address;
    private String statePeriod;
    private HashMap<String, List<TransactionDto>> data;

    public BankStatementDto() {
    }

    public BankStatementDto(String username, String address, String statePeriod, HashMap<String, List<TransactionDto>> data) {
        this.username = username;
        this.address = address;
        this.statePeriod = statePeriod;
        this.data = data;
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

    public HashMap<String, List<TransactionDto>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<TransactionDto>> data) {
        this.data = data;
    }
}
