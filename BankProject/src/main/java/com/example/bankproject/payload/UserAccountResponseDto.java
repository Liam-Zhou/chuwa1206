package com.example.bankproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountResponseDto {
    private String username;
    private String addr;
    private String statePeriod;
    private AccountDto account;
    private List<TransactionDto> txn;
}
