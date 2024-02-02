package com.example.bankproject.controller;

import com.example.bankproject.payload.AccountDto;
import com.example.bankproject.payload.UserAccountResponseDto;
import com.example.bankproject.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerTest {

    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private UserAccountController userAccountController;

    @Test
    void getUserAccountDetails() {
        // Arrange
        Long userId = 123L;
        UserAccountResponseDto mockUserAccountDetails = new UserAccountResponseDto(
                "John Doe", "123 Main St", "Active", new AccountDto(1L, userId, "123", "456"), null);
        when(userAccountService.getUserAccountDetails(userId)).thenReturn(mockUserAccountDetails);

        // Act
        ResponseEntity<UserAccountResponseDto> response = userAccountController.getUserAccountDetails(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUserAccountDetails, response.getBody());
        verify(userAccountService, times(1)).getUserAccountDetails(userId);
    }

    @Test
    void getUserAccountsInRange() {
        // Arrange
        Long startId = 1L;
        Long endId = 5L;
        List<UserAccountResponseDto> mockUserAccountResponseDtos = Arrays.asList(
                new UserAccountResponseDto("User1", "Address1", "Active", null, null),
                new UserAccountResponseDto("User2", "Address2", "Active", null, null)
        );
        when(userAccountService.getUserAccountDetailsInRange(startId, endId)).thenReturn(mockUserAccountResponseDtos);

        // Act
        ResponseEntity<List<UserAccountResponseDto>> response = userAccountController.getUserAccountsInRange(startId, endId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUserAccountResponseDtos, response.getBody());
        verify(userAccountService, times(1)).getUserAccountDetailsInRange(startId, endId);
    }

    @Test
    void getUserAccountsByDateRange() {
        // Arrange
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);
        List<UserAccountResponseDto> mockUserAccountResponseDtos = Arrays.asList(
                new UserAccountResponseDto("User1", "Address1", "Active", null, null),
                new UserAccountResponseDto("User2", "Address2", "Active", null, null)
        );
        when(userAccountService.getUserAccountDetailsByDateRange(startDate, endDate)).thenReturn(mockUserAccountResponseDtos);

        // Act
        ResponseEntity<List<UserAccountResponseDto>> response = userAccountController.getUserAccountsByDateRange(startDate, endDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUserAccountResponseDtos, response.getBody());
        verify(userAccountService, times(1)).getUserAccountDetailsByDateRange(startDate, endDate);
    }
}