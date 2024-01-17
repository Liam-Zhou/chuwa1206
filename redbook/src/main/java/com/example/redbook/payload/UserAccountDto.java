package com.example.redbook.payload;

import java.time.LocalDateTime;

public class UserAccountDto {
    private Long accountId;
    private String name;
    private String addr;
    private String phone;
    private String email;
    private int rountingNumber;
    private int accountNumber;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRountingNumber() {
        return rountingNumber;
    }

    public void setRountingNumber(int rountingNumber) {
        this.rountingNumber = rountingNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public UserAccountDto(Long accountId, String name, String addr, String phone, String email,
                          int rountingNumber, int accountNumber, LocalDateTime createDateTime,
                          LocalDateTime updateDateTime) {
        this.accountId = accountId;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
        this.rountingNumber = rountingNumber;
        this.accountNumber = accountNumber;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
