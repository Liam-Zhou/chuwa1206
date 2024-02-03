package com.example.bankproject.service.impl;

import com.example.bankproject.entity.UserProfile;
import com.example.bankproject.payload.UserProfileDto;
import com.example.bankproject.repository.UserProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    void addUser_ShouldReturnUserProfileDto() {
        // Arrange
        UserProfileDto inputDto = new UserProfileDto();
        inputDto.setName("John Doe");
        inputDto.setAddress("123 Main St");
        inputDto.setPhone("123-456-7890");
        inputDto.setEmail("john.doe@example.com");

        UserProfile inputEntity = modelMapper.map(inputDto, UserProfile.class);
        UserProfile savedEntity = new UserProfile();
        savedEntity.setId(1L);
        savedEntity.setName("John Doe");
        savedEntity.setAddress("123 Main St");
        savedEntity.setPhone("123-456-7890");
        savedEntity.setEmail("john.doe@example.com");

        // Mocking the repository behavior
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(savedEntity);

        // Act
        UserProfileDto resultDto = userProfileService.addUser(inputDto);

        // Assert
        assertNotNull(resultDto);
        assertEquals("John Doe", resultDto.getName());
        assertEquals("123 Main St", resultDto.getAddress());
        assertEquals("123-456-7890", resultDto.getPhone());
        assertEquals("john.doe@example.com", resultDto.getEmail());
    }

    @Test
    void getAll_ShouldReturnListOfUserProfileDto() {
        // Arrange
        UserProfile userProfile1 = new UserProfile();
        userProfile1.setId(1L);
        userProfile1.setName("John Doe");

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setId(2L);
        userProfile2.setName("Jane Doe");

        when(userProfileRepository.findAll()).thenReturn(Arrays.asList(userProfile1, userProfile2));

        // Act
        List<UserProfileDto> result = userProfileService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
    }

    @Test
    void getById_ExistingId_ShouldReturnUserProfileDto() {
        // Arrange
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setName("John Doe");

        when(userProfileRepository.findById(1L)).thenReturn(Optional.of(userProfile));

        // Act
        UserProfileDto result = userProfileService.getById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    void getById_NonExistingId_ShouldThrowException() {
        // Arrange
        when(userProfileRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(Exception.class, () -> userProfileService.getById(1L));
    }

    @Test
    void findByIdBetween_ShouldReturnListOfUserProfile() {
        // Arrange
        UserProfile userProfile1 = new UserProfile();
        userProfile1.setId(1L);
        userProfile1.setName("John Doe");

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setId(2L);
        userProfile2.setName("Jane Doe");

        when(userProfileRepository.findByIdBetween(1L, 3L)).thenReturn(Arrays.asList(userProfile1, userProfile2));

        // Act
        List<UserProfile> result = userProfileService.findByIdBetween(1L, 3L);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
    }
}