package org.chuwa.bankstatement.service.impl;

import org.chuwa.bankstatement.dao.UserRepository;
import org.chuwa.bankstatement.entities.User;
import org.chuwa.bankstatement.payload.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        logger.info("set up user for each test");
        user = new User(1L, "test username", "test addr", "test phone", "test email");
    }

    @BeforeAll
    static void beforeAll() { logger.info("start UserService test..."); }

    @Test
    void createUserProfile() {
        UserDto userDto = new UserDto(1L, "test username", "test addr", "test phone", "test email");
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        UserDto response = userService.createUserProfile(userDto);

        // assertions
        assertNotNull(response);
        assertEquals(userDto.getUserId(), response.getUserId());
        assertEquals(userDto.getName(), response.getName());
        assertEquals(userDto.getAddr(), response.getAddr());
        assertEquals(userDto.getEmail(), response.getEmail());
        assertEquals(userDto.getPhone(), response.getPhone());
    }
}