package com.example.bankproject.payload;

import jakarta.persistence.Column;
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
    @Column(name = "name", nullable = false)
    private String name;
    private String address;
    private String phone;
    private String email;
}
