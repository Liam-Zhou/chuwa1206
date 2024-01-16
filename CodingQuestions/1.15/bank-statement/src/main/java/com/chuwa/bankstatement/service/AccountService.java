package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(Long userId, AccountDto accountDto);
}
