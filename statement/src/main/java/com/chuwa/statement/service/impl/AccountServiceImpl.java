package com.chuwa.statement.service.impl;

import com.chuwa.statement.dao.AccountRepository;
import com.chuwa.statement.dao.UserRepository;
import com.chuwa.statement.entity.Account;
import com.chuwa.statement.entity.User;
import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.AccountDto;
import com.chuwa.statement.payload.AccountDto;
import com.chuwa.statement.service.inter.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = mapToEntity(accountDto);
        Account savedAccount = accountRepository.save(account);
        return mapToDto(savedAccount);
    }

    @Override
    public List<AccountDto> findAllAccount() {
        List<AccountDto> lst=accountRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
        return lst;
    }

    @Override
    public AccountDto findAccountById(long id) {
        AccountDto accountDto=accountRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Account","id",id));
        return accountDto;
    }

    AccountDto mapToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setUserId(account.getUser().getId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setRoutingNumber(account.getRoutingNumber());
        return accountDto;
    }

    Account mapToEntity(AccountDto accountDto){
        Account account=new Account();
        User user=userRepository.findById(accountDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException("User","id",accountDto.getUserId()));
        account.setUser(user);
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
        return account;
    }
}
