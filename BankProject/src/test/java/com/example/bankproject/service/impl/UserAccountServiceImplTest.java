package com.example.bankproject.service.impl;

import com.example.bankproject.entity.UserProfile;
import com.example.bankproject.payload.AccountDto;
import com.example.bankproject.payload.TransactionDto;
import com.example.bankproject.payload.UserAccountResponseDto;
import com.example.bankproject.payload.UserProfileDto;
import com.example.bankproject.service.AccountService;
import com.example.bankproject.service.TransactionService;
import com.example.bankproject.service.UserProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplTest {

    @InjectMocks
    private UserAccountServiceImpl userAccountService;

    @Mock
    private UserProfileService userProfileService;

    @Mock
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void getUserAccountDetails() {
        // Mock data for the service method
        Long userId = 1L;
        Long accountId = 1L;
        UserProfileDto userProfileDto = new UserProfileDto(userId, "John Doe", "123 Main St", "525787813", "sueos@gmai.com");
        AccountDto accountDto = new AccountDto(accountId, userId, "123", "123");
        List<TransactionDto> transactionDtos = Arrays.asList(
                new TransactionDto(1L, LocalDate.now(), "Description 1", 100.0),
                new TransactionDto(2L, LocalDate.now(), "Description 2", 150.0)
        );

        // Mocking behavior of the service methods
        when(userProfileService.getById(userId)).thenReturn(userProfileDto);
        when(accountService.getById(userId)).thenReturn(accountDto);
        when(transactionService.getAllByAccountId(userId)).thenReturn(transactionDtos);

        // Calling the service method
        UserAccountResponseDto result = userAccountService.getUserAccountDetails(userId);

        // Verifying the result
        assertNotNull(result);
        assertEquals("John Doe", result.getUsername());
        assertEquals("123 Main St", result.getAddr());
        // Add more assertions based on your actual logic

        // Verifying that the service methods were called
        verify(userProfileService, times(1)).getById(userId);
        verify(accountService, times(1)).getById(userId);
        verify(transactionService, times(1)).getAllByAccountId(userId);
    }

    @Test
    void getUserAccountDetailsInRange() {
        // Mock data
        UserProfile userProfile = new UserProfile();
        userProfile.setName("John Doe");
        userProfile.setAddress("123 Main St");
        userProfile.setPhone("123-456-7890");
        userProfile.setEmail("john@example.com");

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setName("John Doe2");
        userProfile2.setAddress("123 Main St123");
        userProfile2.setPhone("123-456-7asd0");
        userProfile2.setEmail("john@examp23le.com");
        AccountDto accountDto1 = new AccountDto(101L, 1L, "123456", "987654321");
        AccountDto accountDto2 = new AccountDto(102L, 2L, "654321", "123456789");

        TransactionDto transactionDto1 = new TransactionDto(201L, LocalDate.now(), "Transaction 1", 100.0);
        TransactionDto transactionDto2 = new TransactionDto(202L,  LocalDate.now(), "Transaction 2", 150.0);

        // Mocking service calls

        // Mocking service calls
        when(userProfileService.findByIdBetween(1L, 2L))
                .thenReturn(List.of(userProfile, userProfile2));
        when(accountService.findByUserIdBetween(1L, 2L))
                .thenReturn(List.of(accountDto1, accountDto2));
        when(transactionService.findByAccountIdIn(List.of(101L, 102L)))
                .thenReturn(List.of(transactionDto1, transactionDto2));

        // Execute the method to be tested
        List<UserAccountResponseDto> result = userAccountService.getUserAccountDetailsInRange(1L, 2L);

        // Assertions
        assertEquals(2, result.size());

        UserAccountResponseDto userAccountResponseDto1 = result.get(0);
        assertEquals("John Doe", userAccountResponseDto1.getUsername());
        assertEquals("123 Main St", userAccountResponseDto1.getAddr());
        assertEquals("statePeriod logic here", userAccountResponseDto1.getStatePeriod());

        UserAccountResponseDto userAccountResponseDto2 = result.get(1);
        assertEquals("John Doe2", userAccountResponseDto2.getUsername());
        assertEquals("123 Main St123", userAccountResponseDto2.getAddr());
        assertEquals("statePeriod logic here", userAccountResponseDto2.getStatePeriod());
    }

    @Test
    void getUserAccountDetailsByDateRange() {
        // Mock data
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(1L);
        userProfileDto.setName("John Doe");
        userProfileDto.setAddress("123 Main St");

        AccountDto accountDto = new AccountDto();
        accountDto.setUserId(1L);
        accountDto.setAccountId(101L);
        accountDto.setRoutingNumber("123456");
        accountDto.setAccountNumber("987654321");

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(1L);
        transactionDto.setDescription("Test Transaction");
        transactionDto.setAmount(100.0);

        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactionDtos.add(transactionDto);

        // Mocking service calls
        when(transactionService.getTransactionsByDateRange(Mockito.any(LocalDate.class), Mockito.any(LocalDate.class)))
                .thenReturn(transactionDtos);
        when(userProfileService.getById(anyLong())).thenReturn(userProfileDto);
        when(accountService.getById(anyLong())).thenReturn(accountDto);

        // Execute the method to be tested
        List<UserAccountResponseDto> result = userAccountService.getUserAccountDetailsByDateRange(
                LocalDate.now().minusDays(7), LocalDate.now());

        // Assertions
        assertEquals(1, result.size());
        UserAccountResponseDto userAccountResponseDto = result.get(0);
        assertEquals("John Doe", userAccountResponseDto.getUsername());
        assertEquals("123 Main St", userAccountResponseDto.getAddr());
        assertEquals("will add it later", userAccountResponseDto.getStatePeriod());
        assertEquals(accountDto, userAccountResponseDto.getAccount());
        assertEquals(transactionDtos, userAccountResponseDto.getTxn());
    }
}