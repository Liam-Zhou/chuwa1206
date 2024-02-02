package com.example.bankproject.controller;

import com.example.bankproject.payload.AccountDto;
import com.example.bankproject.service.AccountService;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void getAllAccounts() {
        // Arrange
        List<AccountDto> mockAccounts = Arrays.asList(
                new AccountDto(1L, 2L, "123456789", "987654321"),
                new AccountDto(2L, 3L, "987654321", "123456789")
        );
        when(accountService.getAll()).thenReturn(mockAccounts);

        // Act
        ResponseEntity<List<AccountDto>> response = accountController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockAccounts, response.getBody());
        verify(accountService, times(1)).getAll();
    }

    @Test
    void getAccountById() {
        // Arrange
        Long accountId = 1L;
        AccountDto mockAccount = new AccountDto(1L, 2L,"123456789", "987654321");
        when(accountService.getById(accountId)).thenReturn(mockAccount);

        // Act
        ResponseEntity<AccountDto> response = accountController.getById(accountId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockAccount, response.getBody());
        verify(accountService, times(1)).getById(accountId);
    }

    @Test
    void createAccount() {
        // Arrange
        AccountDto inputAccountDto = new AccountDto(null, 2L, "987654321", "123456789");
        AccountDto createdAccountDto = new AccountDto(1L, 2L, "987654321", "123456789");
        when(accountService.createAccount(inputAccountDto)).thenReturn(createdAccountDto);

        // Mock HttpServletResponse
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

        // Act
        ResponseEntity<AccountDto> response = accountController.createAccount(inputAccountDto, mockResponse);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdAccountDto, response.getBody());
        verify(accountService, times(1)).createAccount(inputAccountDto);

        // Verify that a cookie is added to the response
        verify(mockResponse, times(1)).addCookie(any());
    }
}