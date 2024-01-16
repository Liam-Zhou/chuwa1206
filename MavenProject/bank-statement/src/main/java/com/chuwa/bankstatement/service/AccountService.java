package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.payload.AccountDto;

/**
 * @author xiaorui
 */
public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
