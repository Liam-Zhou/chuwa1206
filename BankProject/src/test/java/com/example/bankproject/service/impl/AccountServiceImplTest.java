package com.example.bankproject.service.impl;

import com.example.bankproject.entity.Account;
import com.example.bankproject.payload.AccountDto;
import com.example.bankproject.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testGetAll() {
        // Mock data for the repository
        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(new Account(1L, 1L, "John Doe", "john@example.com"));

        // Mocking behavior of the repository
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        // Mocking behavior of the modelMapper
        when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new AccountDto());

        // Calling the service method
        List<AccountDto> result = accountService.getAll();

        // Verifying the result
        assertEquals(mockAccounts.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(accountRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetById() {
        // Mock data for the repository
        Long accountId = 1L;
        Long userId = 1L;
        Account mockAccount = new Account(accountId, userId, "John Doe", "john@example.com");

        // Mocking behavior of the repository
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(mockAccount));

        // Mocking behavior of the modelMapper
        when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new AccountDto());

        // Calling the service method
        AccountDto result = accountService.getById(accountId);

        // Verifying the result
        assertNotNull(result);

        // Verifying that the repository method was called
        Mockito.verify(accountRepository, Mockito.times(1)).findById(accountId);
    }

    @Test
    public void testCreateAccount() {
        // Mock data for the service method
        AccountDto accountDto = new AccountDto(1L, 1L, "John Doe", "john@example.com");
        Account accountEntity = new Account(); // Mocked Account entity

        // Mocking behavior of the modelMapper for the mapping from AccountDto to Account
        when(modelMapper.map(accountDto, Account.class)).thenReturn(accountEntity);

        // Mocking behavior of the repository save method
        when(accountRepository.save(accountEntity)).thenReturn(accountEntity);

        // Calling the service method
        AccountDto result = accountService.createAccount(accountDto);

        // Verify that the repository method was called
        Mockito.verify(accountRepository, Mockito.times(1)).save(accountEntity);

    }

    @Test
    public void testFindByUserIdBetween() {
        // Mock data for the repository
        Long startUserId = 1L;
        Long endUserId = 10L;
        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(new Account(1L, 1L, "John Doe", "john@example.com"));

        // Mocking behavior of the repository
        when(accountRepository.findByUserIdBetween(startUserId, endUserId)).thenReturn(mockAccounts);

        // Mocking behavior of the modelMapper
        when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new AccountDto());

        // Calling the service method
        List<AccountDto> result = accountService.findByUserIdBetween(startUserId, endUserId);

        // Verifying the result
        assertEquals(mockAccounts.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(accountRepository, Mockito.times(1)).findByUserIdBetween(startUserId, endUserId);
    }

}