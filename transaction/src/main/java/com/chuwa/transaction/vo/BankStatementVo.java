package com.chuwa.transaction.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class BankStatementVo {
    @NotNull(message = "UserId cannot be empty")
    private long userId;

    @NotEmpty(message = "Month cannot be empty")
    @Pattern(regexp = "^[1-9]$|^1[0-2]$", message = "Value must be a number between 1 and 12")
    private String month;

    public BankStatementVo() {
    }

    public BankStatementVo(long userId, String month) {
        this.userId = userId;
        this.month = month;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
