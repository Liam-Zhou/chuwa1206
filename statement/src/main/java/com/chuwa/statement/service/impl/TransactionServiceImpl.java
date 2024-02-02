package com.chuwa.statement.service.impl;

import com.chuwa.statement.dao.AccountRepository;
import com.chuwa.statement.dao.TransactionRepository;
import com.chuwa.statement.entity.Account;
import com.chuwa.statement.entity.Transaction;
import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.TransactionDto;
import com.chuwa.statement.service.inter.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction=mapToEntity(transactionDto);
        Transaction ToBeReturned=transactionRepository.save(transaction);
        return mapToDto(ToBeReturned);
    }

    @Override
    public List<TransactionDto> findAllTransaction() {
        List<TransactionDto> lst=transactionRepository.findAll()
                .stream()
                .map(TransactionServiceImpl::mapToDto)
                .toList();
        return lst;
    }

    @Override
    public TransactionDto findTransactionById(long id) {
        TransactionDto transactionDto=transactionRepository.findById(id)
                .map(TransactionServiceImpl::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Txn","id",id));
        return transactionDto;
    }

    static TransactionDto mapToDto(Transaction transaction){
        TransactionDto transactionDto=new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAccountId(transaction.getAccount().getId());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }

    Transaction mapToEntity(TransactionDto transactionDto){
        Transaction transaction=new Transaction();
        Account account=accountRepository.findById(transactionDto.getAccountId())
                .orElseThrow(()->new ResourceNotFoundException("Account","id", transactionDto.getAccountId()));
        transaction.setAccount(account);
        transaction.setDate(transactionDto.getDate());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDescription(transactionDto.getDescription());
        return transaction;
    }
}
