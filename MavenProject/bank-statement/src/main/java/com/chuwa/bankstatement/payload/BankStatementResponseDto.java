package com.chuwa.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author xiaorui
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankStatementResponseDto {
    private String username;
    private String address;
    private String statePeriod;
    private AccountDto account;
    private List<TransactionDto> transactions;
}
