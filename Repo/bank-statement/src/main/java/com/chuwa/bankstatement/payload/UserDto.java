package com.chuwa.bankstatement.payload;


public class UserDto {
    private long id;
    private String name;
    private String addr;
    private String email;
    private String phone;

    public UserDto() {
    }

    public UserDto(long id, String name, String addr, String email, String phone) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
