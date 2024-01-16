package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.TransactionRepository;
import com.chuwa.bankstatement.dao.UserProfileRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.entity.UserProfile;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.*;
import com.chuwa.bankstatement.service.BankStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaorui
 */
@Service
public class BankStatementServiceImpl implements BankStatementService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public BankStatementResponseDto getBankStatement(BankStatementRequestDto request) {
        UserProfile userProfile = userProfileRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", request.getUserId()));

        Account account = accountRepository.findByUserProfileId(userProfile.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "userProfileId", userProfile.getId()));

        List<Transaction> transactions = transactionRepository.findByAccountAndTimeBetween(account, request.getStartTime(), request.getEndTime());

        return constructResponse(userProfile, account, transactions);
    }

    private BankStatementResponseDto constructResponse(UserProfile userProfile, Account account, List<Transaction> transactions) {
        BankStatementResponseDto response = new BankStatementResponseDto();
        response.setUsername(userProfile.getName());
        response.setAddress(userProfile.getAddress());
        response.setStatePeriod("Default value");
        response.setAccount(getAccountDto(account));
        response.setTransactions(getTransactionDto(transactions));
        return response;
    }

    private AccountDto getAccountDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setUserProfileId(account.getUserProfile().getId());
        dto.setRoutingNumber(account.getRoutingNumber());
        dto.setAccountNumber(account.getAccountNumber());
        return dto;
    }

    private List<TransactionDto> getTransactionDto(List<Transaction> transactions) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactions) {
            TransactionDto dto = new TransactionDto();
            dto.setId(transaction.getId());
            dto.setAccountId(transaction.getAccount().getId());
            dto.setTime(transaction.getTime());
            dto.setDescription(transaction.getDescription());
            dto.setAmount(transaction.getAmount());
            transactionDtos.add(dto);
        }
        return transactionDtos;
    }
}
