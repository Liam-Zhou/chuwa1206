package org.chuwa.bankstatement.service;

import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;

public interface AccountService {
    AccountDto CreateAccount(AccountDto accountDto);

    BankStatement getStatement(Long userId, Integer startMonth, Integer endMonth);
}
