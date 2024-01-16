package com.example.bank.statement.service.impl;

import com.example.bank.statement.dao.AccountRepository;
import com.example.bank.statement.dao.TransactionRepository;
import com.example.bank.statement.entity.Account;
import com.example.bank.statement.entity.Transaction;
import com.example.bank.statement.exception.ResourceNotFoundException;
import com.example.bank.statement.payload.TransactionDto;
import com.example.bank.statement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction toBeSaved = mapToEntity(transactionDto);

        Transaction saved = this.transactionRepository.save(toBeSaved);

        return mapToDto(saved);
    }

    private TransactionDto mapToDto(Transaction saved) {
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId(saved.getId());
        transactionDto.setDate(String.valueOf(saved.getDate()));
        transactionDto.setDescription(saved.getDescription());
        transactionDto.setAmount(saved.getAmount());
        transactionDto.setAccountId(saved.getAccount().getId());

        return transactionDto;
    }

    private Transaction mapToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();

        Account account = this.accountRepository.findById(transactionDto.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Account", "id", transactionDto.getAccountId()));
        transaction.setAccount(account);
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDescription(transactionDto.getDescription());

        return transaction;
    }

    @Override
    public TransactionDto getTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        return mapToDto(transaction);
    }
}
