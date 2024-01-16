package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.DAO.TransactionRepository;
import com.chuwa.bankstatement.DAO.UserRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.entity.User;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.payload.StatementDto;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.payload.UserDto;
import com.chuwa.bankstatement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User toBeSaved = convertDtoToEntity(userDto);
        User saved = userRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserServiceImpl::convertEntityToDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return convertEntityToDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getAddress() != null) {
            user.setAddress(userDto.getAddress());
        }
        if (userDto.getPhone() != null) {
            user.setPhone(userDto.getPhone());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        User saved = userRepository.save(user);
        return convertEntityToDto(saved);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<StatementDto> generateStatement(Long userId, Year year, Month month) {
        List<StatementDto> statementDtos = new ArrayList<>();
        boolean isLeapYear = year.isLeap();
        LocalDateTime startDate = LocalDateTime.of(year.getValue(), month.getValue(), 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year.getValue(), month.getValue() + 1, 1, 0, 0);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Set<Account> accounts = user.getAccounts();
        for (Account account : accounts) {
            List<Transaction> transactions = transactionRepository.findByAccountIdAndCreateDateTimeGreaterThanEqualAndCreateDateTimeLessThan(account.getId(), startDate, endDate);
            List<TransactionDto> transactionDtos = Optional.ofNullable(transactions)
                    .orElse(new ArrayList<>())
                    .stream()
                    .map(TransactionServiceImpl::convertEntityToDto)
                    .toList();
            StatementDto statementDto = new StatementDto(
                    user.getName(),
                    user.getAddress(),
                    month,
                    account.getAccountNumber(),
                    transactionDtos
            );
            statementDtos.add(statementDto);
        }
        return statementDtos;
    }

    public static UserDto convertEntityToDto(User user) {
        Set<AccountDto> accountDtos = Optional.ofNullable(user.getAccounts())
                .orElse(Collections.emptySet())
                .stream()
                .map(AccountServiceImpl::convertEntityToDto)
                .collect(Collectors.toSet());
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setCreateDateTime(user.getCreateDateTime());
        userDto.setUpdateDateTime(user.getUpdateDateTime());
        userDto.setAccounts(accountDtos);
        return userDto;
    }

    public static User convertDtoToEntity(UserDto userDto) {
        Set<Account> accounts = Optional.ofNullable(userDto.getAccounts())
                .orElse(Collections.emptySet())
                .stream()
                .map(AccountServiceImpl::convertDtoToEntity)
                .collect(Collectors.toSet());
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setAccounts(accounts);
        return user;
    }
}
