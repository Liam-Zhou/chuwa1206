package com.chuwa.statement.service.inter;

import com.chuwa.statement.payload.AccountDto;

import java.util.List;

public interface AccountService{
    AccountDto findAccountById(long id);
    List<AccountDto> findAllAccount();
    AccountDto createAccount(AccountDto accountDto);
}
