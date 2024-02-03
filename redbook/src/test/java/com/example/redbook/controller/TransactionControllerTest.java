package com.example.redbook.controller;

import com.example.redbook.payload.TransactionDto;
import com.example.redbook.payload.UserTransactionDto;
import com.example.redbook.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    void testGetTransactionsById() throws Exception {
        when(transactionService.getUserTransactions(anyLong(), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(createMockUserTransactionDto());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/{userId}/transactions", 1L)
                        .param("from", LocalDateTime.now().toString())
                        .param("to", LocalDateTime.now().plusDays(1).toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userName").value("John Doe"))
                .andExpect(jsonPath("$.transactions").isArray())
                .andExpect(jsonPath("$.transactions[0].description").value("Test Transaction"));
    }

    private UserTransactionDto createMockUserTransactionDto() {
        UserTransactionDto userTransactionDto = new UserTransactionDto("John Doe", "Address", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 1L);
        userTransactionDto.setTransactions(Collections.singletonList(createMockTransactionDto()));
        return userTransactionDto;
    }

    private TransactionDto createMockTransactionDto() {
        return new TransactionDto(LocalDateTime.now(), "Test Transaction", 100);
    }
}
