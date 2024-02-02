package com.example.bankproject.service;

import com.example.bankproject.payload.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> findByUserIdBetween(Long startUserId, Long endUserId);
}
