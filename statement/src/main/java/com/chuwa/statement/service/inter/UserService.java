package com.chuwa.statement.service.inter;

import com.chuwa.statement.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> findAllUser();
    UserDto findUserById(long id);
}
