package com.example.bank.statement.service;

import com.example.bank.statement.payload.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);
}
