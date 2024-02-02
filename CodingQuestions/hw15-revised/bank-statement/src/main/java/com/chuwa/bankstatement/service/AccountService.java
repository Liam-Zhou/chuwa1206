package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> findByUserIdBetween(Long startUserId, Long endUserId);
}
