package com.chuwa.learn.statement.service;

import com.chuwa.learn.statement.payload.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);
}
