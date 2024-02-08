package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.UserRepository;
import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.exception.ResourceNotFoundException;
import com.chuwa.learn.statement.payload.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private UserDto userDto;

    @BeforeAll
    static void beforeAll() {
        log.info("START test");
    }

    @BeforeEach
    void setUp(){
        log.info("set up Post for each test");
        this.user = new User(1L,"user1","111 N Ave","3333333333","123@gmail.com", LocalDateTime.now(),LocalDateTime.now());
        //ModelMapper modelMapper = new ModelMapper();
        this.userDto = modelMapper.map(this.user, UserDto.class);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        // Act
        UserDto result = userService.createUser(userDto);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getName(), userDto.getName());
        Assertions.assertEquals(result.getAddr(),userDto.getAddr());
        Assertions.assertEquals(result.getEmail(),userDto.getEmail());
        Assertions.assertEquals(result.getPhone(),userDto.getPhone());
        Assertions.assertEquals(result.getId(),userDto.getId());

    }


    @Test
    public void testGetUserById() {
        // Arrange
        long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));


        // Act
        UserDto result = userService.getUserById(userId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getName(), userDto.getName());
        Assertions.assertEquals(result.getAddr(),userDto.getAddr());
        Assertions.assertEquals(result.getEmail(),userDto.getEmail());
        Assertions.assertEquals(result.getPhone(),userDto.getPhone());
        Assertions.assertEquals(result.getId(),userDto.getId());

    }

    @Test
    public void testGetUserByIdNotFound() {
        // Given
        long nonExistentUserId = 999L;

        // When, Then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(nonExistentUserId));
    }
}
