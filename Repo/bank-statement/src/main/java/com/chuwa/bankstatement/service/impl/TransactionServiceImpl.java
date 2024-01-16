package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.TransactionRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction toBeSaved = convertDtoToEntity(transactionDto);
        Transaction saved = transactionRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    private static TransactionDto convertEntityToDto(Transaction saved) {
        TransactionDto response = new TransactionDto();
        response.setId(saved.getId());
        response.setAccount(saved.getAccount());
        response.setAmount(saved.getAmount());
        response.setDate(saved.getDate());
        response.setDescription(saved.getDescription());
        return response;
    }

    private static Transaction convertDtoToEntity(TransactionDto transactionDto) {
        Transaction toBeSaved = new Transaction();
        toBeSaved.setAccount(transactionDto.getAccount());
        toBeSaved.setAmount(transactionDto.getAmount());
        toBeSaved.setDate(transactionDto.getDate());
        toBeSaved.setDescription(transactionDto.getDescription());
        return toBeSaved;
    }

    @Override
    public TransactionDto getTransactionById(long id) {
        Transaction response = transactionRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction does not exist"));
        return convertEntityToDto(response);
    }

    @Override
    public List<TransactionDto> getTransactionByAccountAndDateRange(long accountId, LocalDate startDate, LocalDate endDate) {
        List<Transaction> transactions = transactionRepository.findByAccountIdAndDateBetween(accountId, startDate, endDate);
        List<TransactionDto> transactionDtos = transactions.stream().map(TransactionServiceImpl::convertEntityToDto).collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> getTransactionsByUserAndDateRange(long userId, LocalDate startDate, LocalDate endDate) {
        List<Account> accounts= accountRepository.findByUserId(userId);
        List<Long> accountIds = accounts.stream().map(Account::getId).collect(Collectors.toList());
        List<Transaction> transactions = new ArrayList<>();
        for(Long accountId : accountIds) {
            transactions.addAll(transactionRepository.findByAccountIdAndDateBetween(accountId, startDate, endDate));
        }
        List<TransactionDto> transactionDtos = transactions.stream().map(TransactionServiceImpl::convertEntityToDto).collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = transactions.stream().map(TransactionServiceImpl::convertEntityToDto).collect(Collectors.toList());
        return transactionDtos;
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto,long id) {
        Transaction toBeSaved = transactionRepository.findById(id).orElseThrow(()->new RuntimeException("Transaction does not exist"));
        toBeSaved.setAccount(transactionDto.getAccount());
        toBeSaved.setAmount(transactionDto.getAmount());
        toBeSaved.setDate(transactionDto.getDate());
        toBeSaved.setDescription(transactionDto.getDescription());
        Transaction saved = transactionRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    @Override
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
}
