package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.AccountRepoitory;
import com.chuwa.learn.statement.entity.Account;
import com.chuwa.learn.statement.payload.AccountDto;
import com.chuwa.learn.statement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepoitory accountRepoitory;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account tobeSaved =dtoToEntity(accountDto);
        accountRepoitory.save(tobeSaved);
        return entityToDto(tobeSaved);
    }

    @Override
    public AccountDto getAccountById(long id) {
        Account account = accountRepoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "id", id));
        return entityToDto(account);
    }
    private Account dtoToEntity(AccountDto accountDto){
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
        account.setUserId(accountDto.getUserId());
        return  account;
    }
    private AccountDto entityToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(account.getAccountId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setRoutingNumber(account.getRoutingNumber());
        accountDto.setUserId(account.getUserId());
        return  accountDto;
    }
}
