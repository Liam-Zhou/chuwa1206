package org.chuwa.bankstatement.service;

import org.chuwa.bankstatement.payload.UserDto;

public interface UserService {
    UserDto createUserProfile(UserDto userDto);
}
