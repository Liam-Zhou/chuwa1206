package com.example.redbook.service.impl;

import com.example.redbook.dao.AccountRepository;
import com.example.redbook.dao.UserProfileRepository;
import com.example.redbook.entity.Account;
import com.example.redbook.entity.UserProfile;
import com.example.redbook.payload.UserAccountDto;
import com.example.redbook.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImpl implements UserProfileService {
    UserProfileRepository userProfileRepository;

    AccountRepository accountRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, AccountRepository accountRepository) {
        this.userProfileRepository = userProfileRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public UserAccountDto getAccount(long userId) {
        UserProfile userProfile = userProfileRepository.findById(userId).orElse(null);
        if (userProfile != null) {
            Account userAccount = accountRepository.findById(userProfile.getAccount().getAccountId()).orElse(null);
            if (userAccount != null) {
                return new UserAccountDto(
                        userAccount.getAccountId(),
                        userProfile.getName(),
                        userProfile.getAddr(),
                        userProfile.getPhone(),
                        userProfile.getEmail(),
                        userAccount.getRountingNumber(),
                        userAccount.getAccountNumber(),
                        userAccount.getCreateDateTime(),
                        userAccount.getUpdateDateTime()
                );
            }
        }
        return null;
    }


}
