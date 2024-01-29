package com.example.bank.statement.service.impl;

import com.example.bank.statement.dao.AccountRepository;
import com.example.bank.statement.dao.UserProfileRepository;
import com.example.bank.statement.entity.Account;
import com.example.bank.statement.entity.UserProfile;
import com.example.bank.statement.exception.ResourceNotFoundException;
import com.example.bank.statement.payload.AccountDto;
import com.example.bank.statement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    @Transactional
    public AccountDto createAccount(AccountDto accountDto) {
        Account toBeSaved = mapToEntity(accountDto);

        Account saved = this.accountRepository.save(toBeSaved);

        return mapToDto(saved);
    }

    @Override
    public AccountDto getAccountById(long id) {
        Account account = this.accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "id", id));
        return mapToDto(account);
    }

    private AccountDto mapToDto(Account saved) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(saved.getId());
        accountDto.setAccountNumber(saved.getAccountNumber());
        accountDto.setRoutingNumber(saved.getRoutingNumber());
        accountDto.setUserProfileId(saved.getUserProfile().getId());

        return accountDto;
    }

    private Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
        Long id = accountDto.getUserProfileId();
        UserProfile userProfile = this.userProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));
        account.setUserProfile(userProfile);

        return account;
    }
}
