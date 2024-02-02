package com.chuwa.statement.service.inter;

import com.chuwa.statement.payload.TransactionDto;
import com.chuwa.statement.payload.UserDto;

import java.util.List;

public interface TransactionService{
    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> findAllTransaction();
    TransactionDto findTransactionById(long id);
}
