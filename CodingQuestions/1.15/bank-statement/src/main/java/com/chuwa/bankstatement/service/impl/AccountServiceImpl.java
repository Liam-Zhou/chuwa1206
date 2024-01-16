package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.DAO.AccountRepository;
import com.chuwa.bankstatement.DAO.UserRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.User;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public AccountDto createAccount(Long userId, AccountDto accountDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Account toBeSaved = convertDtoToEntity(accountDto);
        user.addAccount(toBeSaved);
        userRepository.save(user);
        return convertEntityToDto(toBeSaved);
    }

    public static AccountDto convertEntityToDto(Account account) {
        Set<TransactionDto> transactionDtos = Optional.ofNullable(account.getTransactions())
                .orElse(Collections.emptySet())
                .stream()
                .map(TransactionServiceImpl::convertEntityToDto)
                .collect(Collectors.toSet());
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setRoutingNumber(account.getRoutingNumber());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setCreateDateTime(account.getCreateDateTime());
        accountDto.setTransactions(transactionDtos);
        return accountDto;
    }

    public static Account convertDtoToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setRoutingNumber(accountDto.getRoutingNumber());
        account.setAccountNumber(accountDto.getAccountNumber());
        return account;
    }
}
