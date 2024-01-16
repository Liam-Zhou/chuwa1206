package com.chuwa.bankstatement.service;

import java.time.Month;
import com.chuwa.bankstatement.payload.StatementDto;
import com.chuwa.bankstatement.payload.UserDto;

import java.time.Year;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);

    List<StatementDto> generateStatement(Long userId, Year year, Month month);

}
