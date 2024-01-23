package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.exception.ResourceNotFoundException;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(long userId, AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        UserProfile userProfile = userProfileRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
        account.setUser(userProfile);
        Account savedaccount = accountRepo.save(account);
        return modelMapper.map(savedaccount, AccountDto.class);
    }
}
