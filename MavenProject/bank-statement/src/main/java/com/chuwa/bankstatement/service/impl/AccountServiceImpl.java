package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.UserProfileRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.UserProfile;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaorui
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = convertToEntity(accountDto);

        Account savedAccount = accountRepository.save(account);

        return convertToDto(savedAccount);
    }

    private Account convertToEntity(AccountDto dto) {
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setRoutingNumber(dto.getRoutingNumber());

        UserProfile userProfile = userProfileRepository.findById(dto.getUserProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", dto.getUserProfileId()));
        account.setUserProfile(userProfile);
        return account;
    }

    private AccountDto convertToDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setRoutingNumber(account.getRoutingNumber());
        dto.setUserProfileId(account.getUserProfile().getId());
        return dto;
    }
}
