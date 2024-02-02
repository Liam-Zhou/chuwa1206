package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.exception.ResourceNotFoundException;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AccountDtoWithoutUserProfile> getAccountByUserId(Long userId) {
        UserProfile userProfile = userProfileRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserProfile","userId",userId));
        List<AccountDtoWithoutUserProfile> accountDtos = userProfile.getAccounts().stream()
                .map(account -> modelMapper.map(account, AccountDtoWithoutUserProfile.class))
                .sorted(Comparator.comparing(AccountDtoWithoutUserProfile::getAccountID))
                .collect(Collectors.toList());
        return accountDtos;
    }

    @Override
    public AccountDto getAccountByUserIdByAccountId(Long userId, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account","accountId",accountId));
        return modelMapper.map(account,AccountDto.class);

    }

    @Override
    public AccountDtoWithoutUserProfile updateAccountByUserIdAccountId(Long userId, Long accountId, AccountDtoWithoutUserProfile accountDto) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","accountId", accountId));
        account.setAccountID(accountDto.getAccountID());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
        Account updatedAccount = accountRepo.save(account);
        return modelMapper.map(updatedAccount, AccountDtoWithoutUserProfile.class);
    }

    @Override
    public void deleteAccountByUserIdAccountId(Long userId, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","accountId",accountId));
        accountRepo.delete(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}
