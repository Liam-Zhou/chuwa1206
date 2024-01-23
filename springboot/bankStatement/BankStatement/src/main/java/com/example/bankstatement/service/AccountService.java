package com.example.bankstatement.service;

import com.example.bankstatement.payload.AccountDto;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */

public interface AccountService {
    AccountDto createAccount(long userId, AccountDto accountDto);
}
