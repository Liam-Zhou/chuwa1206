package com.example.bankproject.controller;

import com.example.bankproject.payload.TransactionDto;
import com.example.bankproject.service.TransactionService;
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
class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @Test
    void getAllTransactions() {
        // Arrange
        List<TransactionDto> mockTransactions = Arrays.asList(
                new TransactionDto(1L, LocalDate.now(), "Deposit", 100.0),
                new TransactionDto(2L, LocalDate.now(), "Withdrawal", 50.0)
        );
        when(transactionService.getAllTransactions()).thenReturn(mockTransactions);

        // Act
        ResponseEntity<List<TransactionDto>> response = transactionController.getAllTransactions();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTransactions, response.getBody());
        verify(transactionService, times(1)).getAllTransactions();
    }

    @Test
    void getTransactionById() {
        // Arrange
        Long transactionId = 1L;
        TransactionDto mockTransaction = new TransactionDto(1L, LocalDate.now(), "Deposit", 100.0);
        when(transactionService.getTransactionById(transactionId)).thenReturn(mockTransaction);

        // Act
        ResponseEntity<TransactionDto> response = transactionController.getTransactionById(transactionId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTransaction, response.getBody());
        verify(transactionService, times(1)).getTransactionById(transactionId);
    }

    @Test
    void createTransaction() {
        // Arrange
        TransactionDto inputTransactionDto = new TransactionDto(null, LocalDate.now(), "Withdrawal", 50.0);
        TransactionDto createdTransactionDto = new TransactionDto(1L, LocalDate.now(), "Withdrawal", 50.0);
        when(transactionService.createTransaction(inputTransactionDto)).thenReturn(createdTransactionDto);

        // Act
        ResponseEntity<TransactionDto> response = transactionController.createTransaction(inputTransactionDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdTransactionDto, response.getBody());
        verify(transactionService, times(1)).createTransaction(inputTransactionDto);
    }
}