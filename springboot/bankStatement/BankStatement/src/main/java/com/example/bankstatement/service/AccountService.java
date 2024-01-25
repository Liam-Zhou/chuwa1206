package com.example.bankstatement.service;

import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex D.
 */

public interface AccountService {
    AccountDto createAccount(long userId, AccountDto accountDto);

    List<AccountDtoWithoutUserProfile> getAccountByUserId(Long userId);

    AccountDto getAccountByUserIdByAccountId(Long userId, Long accountId);

    AccountDtoWithoutUserProfile updateAccountByUserIdAccountId(Long userId, Long accountId, AccountDtoWithoutUserProfile accountDto);

    void deleteAccountByUserIdAccountId(Long userId, Long accountId);
}
