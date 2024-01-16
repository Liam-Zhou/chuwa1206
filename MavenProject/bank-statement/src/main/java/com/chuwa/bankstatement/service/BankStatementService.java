package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.BankStatementRequestDto;
import com.chuwa.bankstatement.payload.BankStatementResponseDto;

/**
 * @author xiaorui
 */
public interface BankStatementService {
    BankStatementResponseDto getBankStatement(BankStatementRequestDto request);
}
