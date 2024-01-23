package com.chuwa.learn.statement.service;

import com.chuwa.learn.statement.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(long id);


}
