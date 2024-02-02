package com.example.bank.statement.service;

import com.example.bank.statement.payload.TransactionResponse;

public interface StatementService {

    TransactionResponse getStatement(long userId, String startDate, String endDate);
}
