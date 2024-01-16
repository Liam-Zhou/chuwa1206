package com.example.bank.statement.payload;

import com.example.bank.statement.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private Long userProfileId;
    private String routingNumber;
    private String accountNumber;
}
