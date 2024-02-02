package com.example.bankstatement.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    private AccountDto accountDto;
    private AccountDtoWithoutUserProfile accountDtoWithoutUserProfile;

    @BeforeEach
    void setUp() {
        // Initialize your test data here
        accountDto = new AccountDto(); // Initialize with test data
        accountDtoWithoutUserProfile = new AccountDtoWithoutUserProfile(); // Initialize with test data
    }

    @Test
    void createAccountTest() throws Exception {
        given(accountService.createAccount(any(Long.class), any(AccountDto.class))).willReturn(accountDto);

        mockMvc.perform(post("/api/v1/users/{userId}/accounts", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(accountDto)));
    }

    @Test
    void getAccountByUserIdTest() throws Exception {
        List<AccountDtoWithoutUserProfile> accounts = Arrays.asList(accountDtoWithoutUserProfile);
        given(accountService.getAccountByUserId(any(Long.class))).willReturn(accounts);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(accounts)));
    }

    @Test
    void getAccountByUserIdByAccountIdTest() throws Exception {
        given(accountService.getAccountByUserIdByAccountId(any(Long.class), any(Long.class))).willReturn(accountDto);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts/{accountId}", 1L, 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(accountDto)));
    }

    @Test
    void updateAccountByUserIdAccountIdTest() throws Exception {
        given(accountService.updateAccountByUserIdAccountId(any(Long.class), any(Long.class), any(AccountDtoWithoutUserProfile.class))).willReturn(accountDtoWithoutUserProfile);

        mockMvc.perform(put("/api/v1/users/{userId}/accounts/{accountId}", 1L, 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountDtoWithoutUserProfile)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(accountDtoWithoutUserProfile)));
    }

    @Test
    void deleteAccountByUserIdAccountIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/users/{userId}/accounts/{accountId}", 1L, 1L))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The account deleted successfully.")));
    }


}

