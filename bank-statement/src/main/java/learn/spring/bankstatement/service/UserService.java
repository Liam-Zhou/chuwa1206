package learn.spring.bankstatement.service;

import learn.spring.bankstatement.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
