package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.payload.UserAccountResponseDto;
import com.chuwa.bankstatement.payload.UserProfileDto;
import com.chuwa.bankstatement.service.AccountService;
import com.chuwa.bankstatement.service.TransactionService;
import com.chuwa.bankstatement.service.UserAccountService;
import com.chuwa.bankstatement.service.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserProfileService userProfileService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @Autowired
    public UserAccountServiceImpl(UserProfileService userProfileService, AccountService accountService, TransactionService transactionService) {
        this.userProfileService = userProfileService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    private final ModelMapper modelMapper = new ModelMapper();

    public UserAccountResponseDto getUserAccountDetails(Long userId) {
        UserProfileDto userProfileDto = userProfileService.getById(userId);
        AccountDto accountDto = accountService.getById(userId);
        List<TransactionDto> transactionDtos = transactionService.getAllByAccountId(accountDto.getUserId());

        String username = userProfileDto.getName();
        String address = userProfileDto.getAddress();

        String statePeriod = "fake function will add it later";

        return new UserAccountResponseDto(
                username,
                address,
                statePeriod,
                accountDto,
                transactionDtos
        );
    }


    public List<UserAccountResponseDto> getUserAccountDetailsInRange(Long startId, Long endId) {
        List<UserProfileDto> userProfiles = userProfileService.findByIdBetween(startId, endId)
                .stream()
                .map(userProfile -> modelMapper.map(userProfile, UserProfileDto.class))
                .toList();
        List<AccountDto> accounts = accountService.findByUserIdBetween(startId, endId)
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .toList();
        List<Long> accountIds = accounts.stream()
                .map(AccountDto::getAccountId)
                .collect(Collectors.toList());
        List<TransactionDto> transactions = transactionService.findByAccountIdIn(accountIds)
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .toList();

        List<UserAccountResponseDto> userAccountDetails = new ArrayList<>();
        for (UserProfileDto userProfile : userProfiles) {
            UserAccountResponseDto userAccountResponse = new UserAccountResponseDto(
                    userProfile.getName(),
                    userProfile.getAddress(),
                    "statePeriod logic here",
                    accounts.stream().filter(a -> a.getUserId().equals(userProfile.getId())).findFirst().orElse(null),
                    transactions.stream().filter(t -> t.getAccountId().equals(userProfile.getId())).collect(Collectors.toList())
            );
            userAccountDetails.add(userAccountResponse);
        }

        return userAccountDetails;
    }

    @Override
    public List<UserAccountResponseDto> getUserAccountDetailsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<TransactionDto> transactionDtos = transactionService.getTransactionsByDateRange(startDate, endDate);

        Set<Long> userIds = transactionDtos.stream()
                .map(TransactionDto::getAccountId)
                .collect(Collectors.toSet());

        List<UserAccountResponseDto> userAccounts = new ArrayList<>();
        for (Long userId : userIds) {
            UserProfileDto userProfileDto = userProfileService.getById(userId);
            AccountDto accountDto = accountService.getById(userId);
            List<TransactionDto> userTransactions = transactionDtos.stream()
                    .filter(t -> t.getAccountId().equals(userId))
                    .collect(Collectors.toList());

            String username = userProfileDto.getName();
            String address = userProfileDto.getAddress();
            String statePeriod = "will add it later";

            userAccounts.add(new UserAccountResponseDto(
                    username, address, statePeriod, accountDto, userTransactions));
        }

        return userAccounts;
    }

}