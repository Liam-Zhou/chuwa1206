package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.AccountRepository;
import com.chuwa.transaction.entity.Account;
import com.chuwa.transaction.payload.AccountDto;
import com.chuwa.transaction.service.AccountService;
import com.chuwa.transaction.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountImpl implements AccountService {
    final AccountRepository accountRepository;
    final UserProfileService userProfileService;

    public AccountImpl(AccountRepository accountRepository, UserProfileService userProfileService) {
        this.accountRepository = accountRepository;
        this.userProfileService = userProfileService;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account toBeSave = convertDtoToEntity(accountDto);
        Account saved = this.accountRepository.save(toBeSave);
        AccountDto res = convertEntityToDto(saved);

        return res;
    }


    @Override
    public List<AccountDto> findAccountsByUserId(long id) {
        List<Account> accounts = this.accountRepository
                .findByUserId(id);


        List<AccountDto> response = accounts.stream().map(account -> convertEntityToDto(account)).collect(Collectors.toList());
        return response;

    }

    private AccountDto convertEntityToDto(Account saved) {
        AccountDto response = new AccountDto();
        response.setAccountId(saved.getId());
        response.setUserId(saved.getUserId());
        response.setAccountNumber(saved.getAccountNumber());
        response.setRoutingNumber(saved.getRoutingNumber());
        return response;
    }

    private Account convertDtoToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setUserId(accountDto.getUserId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
        return account;
    }
}
