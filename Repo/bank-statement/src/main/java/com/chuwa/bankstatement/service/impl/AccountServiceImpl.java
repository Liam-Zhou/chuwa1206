package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.UserRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.User;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public AccountServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account toBeSaved = convertDtoToEntity(accountDto);
        Account saved = accountRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    private static AccountDto convertEntityToDto(Account saved) {
        AccountDto response = new AccountDto();
        response.setUserId(saved.getUser().getId());
        response.setAccountNumber(saved.getAccountNumber());
        response.setRoutingNumber(saved.getRoutingNumber());
        response.setId(saved.getId());
        return response;
    }

    private Account convertDtoToEntity(AccountDto accountDto) {
        Account toBeSaved = new Account();
        toBeSaved.setAccountNumber(accountDto.getAccountNumber());
        toBeSaved.setRoutingNumber(accountDto.getRoutingNumber());
        User user = userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User does not exist"));
        toBeSaved.setUser(user);
        return toBeSaved;
    }

    @Override
    public List<AccountDto> getAccountByUserId(long userId) {
        return accountRepository.findByUserId(userId).stream().map(account -> convertEntityToDto(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return convertEntityToDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(account -> convertEntityToDto(account)).collect(Collectors.toList());
    }
}
