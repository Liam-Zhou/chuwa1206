package com.chuwa.statement.payload;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public class StatementDto {
    private String userName;
    private String userAddress;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String accountNumber;
    private List<TransactionDto> txns;

    public StatementDto(String userName, String userAddress, LocalDateTime startDate, LocalDateTime endDate, String accountNumber, List<TransactionDto> txns) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accountNumber = accountNumber;
        this.txns = txns;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<TransactionDto> getTxns() {
        return txns;
    }

    public void setTxns(List<TransactionDto> txns) {
        this.txns = txns;
    }
}
