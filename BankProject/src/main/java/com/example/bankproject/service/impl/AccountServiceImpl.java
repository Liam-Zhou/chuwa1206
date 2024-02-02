package com.example.bankproject.service.impl;

import com.example.bankproject.entity.Account;
import com.example.bankproject.payload.AccountDto;
import com.example.bankproject.repository.AccountRepository;
import com.example.bankproject.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper){
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll().stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getById(Long id) {
        return modelMapper.map(accountRepository.findById(id).orElseThrow(), AccountDto.class);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account save = modelMapper.map(accountDto, Account.class);
        return modelMapper.map(accountRepository.save(save), AccountDto.class);
    }

    @Override
    public List<AccountDto> findByUserIdBetween(Long startUserId, Long endUserId) {
        List<Account> accounts = accountRepository.findByUserIdBetween(startUserId, endUserId);
        return accounts.stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }
}
