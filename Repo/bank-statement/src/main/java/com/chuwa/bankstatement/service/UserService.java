package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(long id);
    List<UserDto> getAllUsers();
   // List<Account> getAccountsByUser(long id);
    UserDto updateUser(UserDto userDto, long id);
    void deleteUser(long id);
}
