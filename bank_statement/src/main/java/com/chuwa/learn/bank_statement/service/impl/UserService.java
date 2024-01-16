package com.chuwa.learn.bank_statement.service.impl;

import com.chuwa.learn.bank_statement.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();
    UserDto getUserById(long id);


}
