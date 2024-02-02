package com.chuwa.transaction.service;

import com.chuwa.transaction.payload.BankStatementDto;

public interface BankstatementService {
    BankStatementDto createBankstatement(long userId, String month);

}
