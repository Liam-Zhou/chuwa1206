package com.example.bank.statement.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Name should be at least 2 characters")
    private String name;
    @NotEmpty(message = "Address can not be empty")
    private String address;
    @NotEmpty(message = "Phone number can not be null or empty")
    private String phone;
    @NotEmpty(message = "Email can not be null or empty")
    @Email
    private String email;
}
