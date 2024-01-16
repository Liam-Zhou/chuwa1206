package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.TransactionRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author xiaorui
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = convertToEntity(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return convertToDto(savedTransaction);
    }

    private Transaction convertToEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setTime(dto.getTime() != null ? dto.getTime() : LocalDateTime.now());

        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        transaction.setAccount(account);

        return transaction;
    }

    private TransactionDto convertToDto(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setDescription(transaction.getDescription());
        dto.setAmount(transaction.getAmount());
        dto.setTime(transaction.getTime());
        dto.setAccountId(transaction.getAccount().getId());
        return dto;
    }
}
