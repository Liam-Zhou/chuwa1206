package com.example.bankproject.controller;

import com.example.bankproject.payload.UserProfileDto;
import com.example.bankproject.service.UserProfileService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserProfileControllerTest {

    @Mock
    private UserProfileService userProfileService;

    @InjectMocks
    private UserProfileController userProfileController;

    @Test
    void testAddUser() {
        // Arrange
        UserProfileDto mockUserProfileDto = new UserProfileDto(1L, "John Doe", "123 Main St", "1234567890", "john@example.com");
        when(userProfileService.addUser(any())).thenReturn(mockUserProfileDto);

        // Act
        ResponseEntity<UserProfileDto> response = userProfileController.addUser(mockUserProfileDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockUserProfileDto, response.getBody());
        verify(userProfileService, times(1)).addUser(any());
    }

    @Test
    void testGetAll() {
        // Arrange
        List<UserProfileDto> mockUserProfileDtos = Arrays.asList(
                new UserProfileDto(1L, "User1", "Address1", "1234567890", "user1@example.com"),
                new UserProfileDto(2L, "User2", "Address2", "0987654321", "user2@example.com")
        );
        when(userProfileService.getAll()).thenReturn(mockUserProfileDtos);

        // Act
        ResponseEntity<List<UserProfileDto>> response = userProfileController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUserProfileDtos, response.getBody());
        verify(userProfileService, times(1)).getAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Long userId = 1L;
        UserProfileDto mockUserProfileDto = new UserProfileDto(userId, "John Doe", "123 Main St", "1234567890", "john@example.com");
        when(userProfileService.getById(userId)).thenReturn(mockUserProfileDto);

        // Act
        ResponseEntity<UserProfileDto> response = userProfileController.getById(userId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockUserProfileDto, response.getBody());
        verify(userProfileService, times(1)).getById(userId);
    }
}