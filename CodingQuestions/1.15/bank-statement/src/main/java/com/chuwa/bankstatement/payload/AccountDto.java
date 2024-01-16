package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.entity.User;
import java.time.LocalDateTime;
import java.util.Set;

public class AccountDto {
    private Long id;
    private String routingNumber;
    private String accountNumber;
    private LocalDateTime createDateTime;
    private Set<TransactionDto> transactions;

    public AccountDto() {}

    public AccountDto(Long id, String routingNumber, String accountNumber, LocalDateTime createDateTime, Set<TransactionDto> transactions) {
        this.id = id;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.createDateTime = createDateTime;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
