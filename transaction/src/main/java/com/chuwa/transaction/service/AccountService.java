package com.chuwa.transaction.service;

import com.chuwa.transaction.entity.UserProfile;
import com.chuwa.transaction.payload.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount (AccountDto accountDto);
    AccountDto updateAccount (long id, AccountDto accountDto);
    AccountDto deleteAccount (long id);

    List<AccountDto> findAccountsByUserId(long id);
}
