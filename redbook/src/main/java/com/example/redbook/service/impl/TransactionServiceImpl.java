package com.example.redbook.service.impl;

import com.example.redbook.dao.TransactionRepository;
import com.example.redbook.dao.UserProfileRepository;
import com.example.redbook.payload.TransactionDto;
import com.example.redbook.payload.UserAccountDto;
import com.example.redbook.payload.UserTransactionDto;
import com.example.redbook.service.TransactionService;
import com.example.redbook.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    private UserProfileRepository userProfileRepository;

    private UserProfileService userProfileService;

    @Autowired
    public TransactionServiceImpl(UserProfileRepository userProfileRepository, TransactionRepository transactionRepository, UserProfileService userProfileService)
    {
        this.transactionRepository = transactionRepository;
        this.userProfileRepository = userProfileRepository;
        this.userProfileService = userProfileService;
    }


    @Override
    public UserTransactionDto getUserTransactions(long userId, LocalDateTime from, LocalDateTime to) {
        UserAccountDto userAccount = userProfileService.getAccount(userId);
        UserTransactionDto userTransaciton = new UserTransactionDto(userAccount.getName(), userAccount.getAddr(), from, to, userAccount.getAccountId());
        List<TransactionDto> transactions = transactionRepository.findByAccountAccountIdAndDateBetween(userAccount.getAccountId(), from, to).stream().map( t -> new TransactionDto(t.getDate(), t.getDescription(), t.getAmount())).collect(Collectors.toList());
        userTransaciton.setTransactions(transactions);
        return userTransaciton;
    }

}
