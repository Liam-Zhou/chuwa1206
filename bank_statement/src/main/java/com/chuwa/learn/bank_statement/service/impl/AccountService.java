package com.chuwa.learn.bank_statement.service.impl;

import com.chuwa.learn.bank_statement.payload.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);
}
