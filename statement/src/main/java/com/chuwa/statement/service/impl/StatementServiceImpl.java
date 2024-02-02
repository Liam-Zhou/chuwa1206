package com.chuwa.statement.service.impl;

import com.chuwa.statement.dao.AccountRepository;
import com.chuwa.statement.dao.TransactionRepository;
import com.chuwa.statement.dao.UserRepository;
import com.chuwa.statement.entity.Account;
import com.chuwa.statement.entity.Transaction;
import com.chuwa.statement.entity.User;
import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.StatementDto;
import com.chuwa.statement.payload.TransactionDto;
import com.chuwa.statement.service.inter.StatementService;
import com.chuwa.statement.service.inter.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatementServiceImpl implements StatementService {
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public StatementServiceImpl(UserRepository userRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<StatementDto> findStatementByUserIdAndDateBetween(long userId, LocalDateTime startDate, LocalDateTime endDate) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        List<Account> accounts=accountRepository.findByUser(user);
        List<StatementDto> statements=accounts.stream()
                .map(account -> {
                    List<TransactionDto> txns=transactionRepository.findByAccountAndDateBetween(account,startDate,endDate)
                            .stream()
                            .map(TransactionServiceImpl::mapToDto)
                            .toList();
                    return new StatementDto(user.getName(), user.getAddress(), startDate, endDate, account.getAccountNumber(), txns);
                })
                .toList();
        return statements;

    }
}
