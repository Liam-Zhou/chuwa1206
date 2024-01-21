package org.chuwa.bankstatement.payload;

public class UserDto {
    private Long userId;
    private String name;
    private String addr;
    private String phone;
    private String email;

    public UserDto(Long userId, String name, String addr, String phone, String email) {
        this.userId = userId;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public UserDto() {
    }
}
