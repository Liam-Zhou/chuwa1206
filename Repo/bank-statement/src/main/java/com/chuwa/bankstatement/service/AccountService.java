package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.payload.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> getAccountByUserId(long userId);

    AccountDto getAccountById(long id);
    List<AccountDto> getAllAccounts();
}
