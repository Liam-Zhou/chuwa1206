package org.example;

public class Account {
    private String user_name;
    private String pw;
    private UserInfo userinfo;
    private AccountStatus accountStatus;

    public Account(String user_name, String pw, UserInfo userinfo, AccountStatus accountStatus) {
        this.user_name = user_name;
        this.pw = pw;
        this.userinfo = userinfo;
        this.accountStatus = accountStatus;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void resetPassword(){
    }

}
