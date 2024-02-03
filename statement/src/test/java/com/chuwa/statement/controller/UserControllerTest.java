package com.chuwa.statement.controller;

import com.chuwa.statement.payload.UserDto;
import com.chuwa.statement.service.inter.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userServiceMock;

    @InjectMocks
    private UserController userControllerMock;


    private UserDto userDto;
    private List<UserDto> userDtoList;

    @BeforeEach
    public void setup(){
        userDto=new UserDto(1,"hhh","cc","123","555@5");
        userDtoList= List.of(userDto);
    }

    @Test
    public void testCreateUser() {
        when(userServiceMock.createUser(any(UserDto.class)))
                .thenReturn(userDto);
        ResponseEntity<UserDto> response=userControllerMock.createUser(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userDto, response.getBody());

    }

    @Test
    public void testFindAllUser() {
        when(userServiceMock.findAllUser())
                .thenReturn(userDtoList);
        ResponseEntity<List<UserDto>> response=userControllerMock.findAllUser();
        assertEquals(userDtoList, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testFindUserById() {
        when(userServiceMock.findUserById(ArgumentMatchers.anyLong()))
                .thenReturn(userDto);
        HttpServletRequest servletRequest=mock(HttpServletRequest.class);
        HttpServletResponse servletResponse=mock(HttpServletResponse.class);
        ResponseEntity<UserDto> response=userControllerMock.findUserById(1,servletResponse,servletRequest);
        assertEquals(userDto, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(servletResponse).addCookie(any(Cookie.class));
        verify(servletResponse).addHeader(eq("Set-Cookie"), contains("UserId=" + 1));
    }

    @Test
    public void testLogCookieInfo() {
        userControllerMock.logCookieInfo(new Cookie("null","null"));
    }

}