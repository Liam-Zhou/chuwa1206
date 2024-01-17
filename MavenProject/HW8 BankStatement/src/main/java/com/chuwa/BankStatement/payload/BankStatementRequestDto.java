package com.chuwa.BankStatement.payload;

public class BankStatementRequestDto {
    private long userId;

    private int month;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

}
