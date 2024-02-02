package com.example.bankproject.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountId;
    private Long userId;
    private String routingNumber;
    private String accountNumber;

}
