package com.chuwa.learn.statement.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String addr;
    @NotEmpty
    @Size(min = 10,message = "phone number must be 10 digits")
    private String phone;
    @NotEmpty
    @Email(message = "Please provide a valid email address")
    private String email;

    public UserDto() {
    }

    public UserDto(long id, String name, String addr, String phone, String email) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
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
}
