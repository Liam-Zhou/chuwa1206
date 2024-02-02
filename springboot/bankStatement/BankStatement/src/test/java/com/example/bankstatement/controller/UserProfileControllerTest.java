package com.example.bankstatement.controller;

import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserProfileController.class)
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    @Autowired
    private ObjectMapper objectMapper;

    // Assume UserProfileDto and AccountDtoWithoutUserProfile are properly defined elsewhere
    private UserProfileDto userProfileDto;
    private AccountDtoWithoutUserProfile accountDto;

    @BeforeEach
    void setUp() {
        userProfileDto = new UserProfileDto(); // Initialize with test data
        accountDto = new AccountDtoWithoutUserProfile(); // Initialize with test data
    }

    @Test
    void createUserProfileTest() throws Exception {
        given(userProfileService.createUserProfile(any(UserProfileDto.class))).willReturn(userProfileDto);

        mockMvc.perform(post("/api/v1/user-profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userProfileDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(userProfileDto)));
    }

    @Test
    void getAllUserProfileTest() throws Exception {
        given(userProfileService.getAllUserProfile()).willReturn(Collections.singletonList(userProfileDto));

        mockMvc.perform(get("/api/v1/user-profiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(userProfileDto))));
    }

    @Test
    void getUserProfileByUserIdTest() throws Exception {
        given(userProfileService.getUserProfileByUserId(any(Long.class))).willReturn(userProfileDto);

        mockMvc.perform(get("/api/v1/user-profiles/{userId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userProfileDto)));
    }

    @Test
    void getAllAccountsByUserIdTest() throws Exception {
        given(userProfileService.getAllAccountsByUserId(any(Long.class))).willReturn(Collections.singletonList(accountDto));

        mockMvc.perform(get("/api/v1/user-profiles/{userId}/accounts", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(accountDto))));
    }

    @Test
    void updateUserProfileTest() throws Exception {
        given(userProfileService.updateUserProfile(any(Long.class), any(UserProfileDto.class))).willReturn(userProfileDto);

        mockMvc.perform(put("/api/v1/user-profiles/{userId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userProfileDto)))
                .andExpect(status().is(222)) // Custom status code used in your controller
                .andExpect(content().json(objectMapper.writeValueAsString(userProfileDto)));
    }

    @Test
    void deleteUserProfileTest() throws Exception {
        mockMvc.perform(delete("/api/v1/user-profiles/{userId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The user profile deleted successfully.")));
    }



}