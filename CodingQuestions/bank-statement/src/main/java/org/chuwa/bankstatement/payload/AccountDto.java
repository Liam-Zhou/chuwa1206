package org.chuwa.bankstatement.payload;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

public class AccountDto {
    private Long accountId;

    private Long userId;

    @NotEmpty
    @Size(min=2, message="routing number should have at least 2 characters")
    private String routingNumber;

    @NotEmpty
    @Size(min=2, message="account number should have at least 2 characters")
    private String accountNumber;

    public AccountDto(Long accountId, Long userId, String routingNumber, String accountNumber) {
        this.accountId = accountId;
        this.userId = userId;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    public AccountDto() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
