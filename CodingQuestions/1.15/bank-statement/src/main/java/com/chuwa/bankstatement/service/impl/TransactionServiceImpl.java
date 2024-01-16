package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.DAO.AccountRepository;
import com.chuwa.bankstatement.DAO.TransactionRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto createTransaction(Long userId, Long accountId, TransactionDto transactionDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
        Transaction toBeSaved = convertDtoToEntity(transactionDto);
        account.addTransaction(toBeSaved);
        accountRepository.save(account);
        return convertEntityToDto(toBeSaved);
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto transactionDto) {

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        if (transactionDto.getAmount() != null) {
            transaction.setAmount(transactionDto.getAmount());
        }
        if (transactionDto.getDescription() != null) {
            transaction.setDescription(transactionDto.getDescription());
        }
        if (transactionDto.getCreateDateTime() != null) {
            transaction.setCreateDateTime(transactionDto.getCreateDateTime());
        }

        Account originalAccount = transaction.getAccount();
        String accountNumber = originalAccount.getAccountNumber();
        Set<Transaction> transactions = originalAccount.getTransactions();
        if (transactionDto.getAccountNumber() != null && !transactionDto.getAccountNumber().equals(accountNumber)) {
            transactions.remove(transaction);
            Account newAccount = accountRepository.findByAccountNumber(transactionDto.getAccountNumber());
            newAccount.addTransaction(transaction);
            accountRepository.save(newAccount);
        }
        accountRepository.save(originalAccount);
        return convertEntityToDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = transactions.stream()
                .map(TransactionServiceImpl::convertEntityToDto)
                .toList();
        return transactionDtos;
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        return convertEntityToDto(transaction);
    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
        Account account = transaction.getAccount();
        account.getTransactions().remove(transaction);
        accountRepository.save(account);
    }

    public static TransactionDto convertEntityToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setCreateDateTime(transaction.getCreateDateTime());
        transactionDto.setAccountNumber(transaction.getAccount().getAccountNumber());
        return transactionDto;
    }

    public static Transaction convertDtoToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDescription(transactionDto.getDescription());
        return transaction;
    }
}
