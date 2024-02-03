package com.example.redbook.playload;

import com.example.redbook.payload.TransactionDto;
import com.example.redbook.payload.UserTransactionDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTransactionDtoTest {
    @Test
    public void testUserTransactionDto() {
        // Create a UserTransactionDto object for testing
        UserTransactionDto userTransactionDto = new UserTransactionDto("John Doe", "123 Main St",
                LocalDateTime.of(2022, 1, 1, 12, 0),
                LocalDateTime.of(2022, 1, 15, 12, 0), 1);

        // Create a TransactionDto object for testing
        TransactionDto transactionDto = new TransactionDto(
                LocalDateTime.of(2022, 1, 5, 12, 0),
                "Transaction description",
                100);

        // Add the transaction to the userTransactionDto
        userTransactionDto.getTransactions().add(transactionDto);

        // Test the getters
        assertEquals("John Doe", userTransactionDto.getUserName());
        assertEquals("123 Main St", userTransactionDto.getAddr());
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), userTransactionDto.getFromDate());
        assertEquals(LocalDateTime.of(2022, 1, 15, 12, 0), userTransactionDto.getToDate());
        assertEquals(1, userTransactionDto.getAccountId());
        assertEquals(1, userTransactionDto.getTransactions().size());

        // Test the setters
        userTransactionDto.setUserName("Jane Doe");
        userTransactionDto.setAddr("456 Oak St");
        userTransactionDto.setFromDate(LocalDateTime.of(2022, 2, 1, 12, 0));
        userTransactionDto.setToDate(LocalDateTime.of(2022, 2, 15, 12, 0));
        userTransactionDto.setAccountId(2);

        // Test if changes were successful
        assertEquals("Jane Doe", userTransactionDto.getUserName());
        assertEquals("456 Oak St", userTransactionDto.getAddr());
        assertEquals(LocalDateTime.of(2022, 2, 1, 12, 0), userTransactionDto.getFromDate());
        assertEquals(LocalDateTime.of(2022, 2, 15, 12, 0), userTransactionDto.getToDate());
        assertEquals(2, userTransactionDto.getAccountId());
    }
}
