package com.chuwa.statement.controller;

import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.AccountDto;
import com.chuwa.statement.payload.ErrorDetails;
import com.chuwa.statement.service.inter.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @Mock
    private AccountService accountServiceMock;

    @InjectMocks
    private AccountController accountControllerMock;

    private AccountDto accountDto;
    private List<AccountDto> accountDtoList;

    @BeforeEach
    public void setup(){
        accountDto = new AccountDto(1L,1,"789","789");

        accountDtoList = new ArrayList<>();
        accountDtoList.add(new AccountDto(2L,2,"123","123"));
        accountDtoList.add(new AccountDto(3L,3,"456","456"));
    }

    @Test
    public void testCreateAccount() {
        when(accountServiceMock.createAccount(ArgumentMatchers.any(AccountDto.class)))
                .thenReturn(accountDto);
        ResponseEntity<AccountDto> response=accountControllerMock.createAccount(accountDto);

        verify(accountServiceMock).createAccount(accountDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(accountDto, response.getBody());
    }

    @Test
    public void testFindAllAccount(){
        when(accountServiceMock.findAllAccount())
                .thenReturn(accountDtoList);
        ResponseEntity<List<AccountDto>> response=accountControllerMock.findAllAccount();

        verify(accountServiceMock).findAllAccount();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(accountDtoList, response.getBody());
    }

    @Test
    public void testFindAccountById(){
        when(accountServiceMock.findAccountById(ArgumentMatchers.anyLong()))
        .thenReturn(accountDto);
        ResponseEntity<AccountDto> response=accountControllerMock.findAccountById(1);

        verify(accountServiceMock).findAccountById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(accountDto, response.getBody());
    }

    @Test
    public void testFindAccountByIdException(){
        when(accountServiceMock.findAccountById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Account","id",1));

        assertThrows(ResourceNotFoundException.class, () -> {
            accountControllerMock.findAccountById(1);
        });
    }

}