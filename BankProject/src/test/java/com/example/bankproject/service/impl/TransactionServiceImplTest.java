package com.example.bankproject.service.impl;

import com.example.bankproject.entity.Transaction;
import com.example.bankproject.payload.TransactionDto;
import com.example.bankproject.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void getAllTransactions() {
        // Mock data for the repository
        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, 1L, LocalDate.now(), "Description 1", 100.0),
                new Transaction(2L, 1L, LocalDate.now(), "Description 2", 150.0)
        );

        // Mocking behavior of the repository
        when(transactionRepository.findAll()).thenReturn(mockTransactions);

        // Calling the service method
        List<TransactionDto> result = transactionService.getAllTransactions();

        // Verifying the result
        assertEquals(mockTransactions.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getTransactionById() {
        // Mock data for the repository
        Long transactionId = 1L;
        Transaction mockTransaction = new Transaction(transactionId, 1L, LocalDate.now(), "Description 1", 100.0);

        // Mocking behavior of the repository
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(mockTransaction));

        // Calling the service method
        TransactionDto result = transactionService.getTransactionById(transactionId);

        // Verifying the result
        assertNotNull(result);

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findById(transactionId);
    }

    @Test
    void getTransactionByIdNotFound() {
        // Mock data for the repository
        Long transactionId = 1L;

        // Mocking behavior of the repository for a non-existent transaction
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.empty());

        // Calling the service method and expecting an exception
        assertThrows(RuntimeException.class, () -> {
            transactionService.getTransactionById(transactionId);
        });

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findById(transactionId);
    }

    @Test
    void createTransaction() {
        // Mock data for the service method
        TransactionDto transactionDto = new TransactionDto(1L, LocalDate.now(), "Description", 200.0);
        Transaction mockTransactionEntity = new Transaction(1L, 1L, LocalDate.now(), "Description", 200.0);

        // Ensure consistent stubbing for the save method
        when(transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(mockTransactionEntity);

        // Calling the service method
        TransactionDto result = transactionService.createTransaction(transactionDto);

        // Verifying the result
        assertEquals(mockTransactionEntity.getId(), result.getAccountId());
        assertEquals(transactionDto.getDescription(), result.getDescription());
        assertEquals(transactionDto.getAmount(), result.getAmount());

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).save(Mockito.any(Transaction.class));
    }

    @Test
    void getAllByAccountId() {
        // Mock data for the service method
        Long accountId = 1L;

        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, accountId, LocalDate.now(), "Description 1", 100.0),
                new Transaction(2L, accountId, LocalDate.now(), "Description 2", 150.0)
        );

        // Mocking behavior of the repository
        when(transactionRepository.findByAccountId(accountId)).thenReturn(mockTransactions);

        // Calling the service method
        List<TransactionDto> result = transactionService.getAllByAccountId(accountId);

        // Verifying the result
        assertEquals(mockTransactions.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findByAccountId(accountId);
    }


    @Test
    void findByAccountIdIn() {
        // Mock data for the service method
        List<Long> accountIds = Arrays.asList(1L, 2L);

        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, 1L, LocalDate.now(), "Description 1", 100.0),
                new Transaction(2L, 2L, LocalDate.now(), "Description 2", 150.0),
                new Transaction(3L, 1L, LocalDate.now(), "Description 3", 200.0)
        );

        // Mocking behavior of the repository
        when(transactionRepository.findByAccountIdIn(accountIds)).thenReturn(mockTransactions);

        // Calling the service method
        List<TransactionDto> result = transactionService.findByAccountIdIn(accountIds);

        // Verifying the result
        assertEquals(mockTransactions.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findByAccountIdIn(accountIds);
    }

    @Test
    void getTransactionsByDateRange() {
        // Mock data for the service method
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);

        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, 1L, LocalDate.of(2022, 1, 10), "Description 1", 100.0),
                new Transaction(2L, 2L, LocalDate.of(2022, 1, 15), "Description 2", 150.0),
                new Transaction(3L, 1L, LocalDate.of(2022, 1, 20), "Description 3", 200.0)
        );

        // Mocking behavior of the repository
        when(transactionRepository.findByDateBetween(startDate, endDate)).thenReturn(mockTransactions);

        // Calling the service method
        List<TransactionDto> result = transactionService.getTransactionsByDateRange(startDate, endDate);

        // Verifying the result
        assertEquals(mockTransactions.size(), result.size());

        // Verifying that the repository method was called
        Mockito.verify(transactionRepository, Mockito.times(1)).findByDateBetween(startDate, endDate);
    }

}