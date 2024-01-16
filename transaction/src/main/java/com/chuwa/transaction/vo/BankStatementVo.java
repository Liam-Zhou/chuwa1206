package com.chuwa.transaction.vo;

import java.util.Date;

public class BankStatementVo {
    private long userId;
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
