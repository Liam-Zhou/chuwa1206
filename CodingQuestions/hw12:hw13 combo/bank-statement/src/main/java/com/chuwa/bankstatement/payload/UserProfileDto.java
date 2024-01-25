package com.chuwa.bankstatement.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO No address
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserProfileDto {
    private Long id;
    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;
    private String address;
    private String phone;
    private String email;
}
