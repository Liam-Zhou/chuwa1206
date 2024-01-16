package com.example.bank.statement.service.impl;

import com.example.bank.statement.dao.AccountRepository;
import com.example.bank.statement.dao.TransactionRepository;
import com.example.bank.statement.dao.UserProfileRepository;
import com.example.bank.statement.entity.Account;
import com.example.bank.statement.entity.Transaction;
import com.example.bank.statement.entity.UserProfile;
import com.example.bank.statement.exception.ResourceNotFoundException;
import com.example.bank.statement.payload.TransactionDto;
import com.example.bank.statement.payload.TransactionResponse;
import com.example.bank.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementServiceImpl implements StatementService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public TransactionResponse getStatement(long userId, String startDate, String endDate) {
        TransactionResponse transactionResponse = new TransactionResponse();

        //userId -> username, address
        UserProfile userProfile = this.userProfileRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", userId));
        //statePeriod -> startDate + endDate
        String statePeriod = startDate + "," + endDate;
        //account -> use userId to find account
        Account account = this.accountRepository.findByUserProfile(userProfile);
        //List<TransactionDto> txn -> use accountId to find all txn matched
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate + "T00:00:00.000000", formatter);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate + "T23:59:59.999999", formatter);

        List<Transaction> transactionsByAccount = this.transactionRepository.findTransactionsByAccountAndDateBetween(account, startLocalDateTime, endLocalDateTime);

        transactionResponse.setUsername(userProfile.getName());
        transactionResponse.setAddr(userProfile.getAddress());
        transactionResponse.setStatePeriod(statePeriod);
        transactionResponse.setTxn(transactionsByAccount.stream().map(transaction -> mapToDto(transaction)).collect(Collectors.toList()));
        transactionResponse.setAccount(String.valueOf(account.getId()));

        return transactionResponse;
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
}
