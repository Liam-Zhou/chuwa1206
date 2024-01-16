package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.entity.Account;
import java.time.LocalDateTime;
import java.util.Set;

public class UserDto {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private Set<AccountDto> accounts;

    public UserDto() {}

    public UserDto(Long id, String name, String address, String phone, String email, LocalDateTime createDateTime, LocalDateTime updateDateTime, Set<AccountDto> accounts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountDto> accounts) {
        this.accounts = accounts;
    }
}

