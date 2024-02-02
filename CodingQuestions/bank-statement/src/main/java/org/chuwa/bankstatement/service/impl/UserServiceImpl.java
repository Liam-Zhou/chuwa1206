package org.chuwa.bankstatement.service.impl;

import org.chuwa.bankstatement.dao.UserRepository;
import org.chuwa.bankstatement.entities.User;
import org.chuwa.bankstatement.payload.UserDto;
import org.chuwa.bankstatement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUserProfile(UserDto userDto) {
        User toBeSaved = convertFromDtoToEntity(userDto);
        User saved = this.userRepository.save(toBeSaved);
        return convertFromEntityToDto(saved);
    }

    private UserDto convertFromEntityToDto(User saved) {
        UserDto userDto = new UserDto();
        userDto.setName(saved.getName());
        userDto.setAddr(saved.getAddr());
        userDto.setEmail(saved.getEmail());
        userDto.setPhone(saved.getPhone());
        userDto.setUserId(saved.getUserId());
        return userDto;
    }

    private User convertFromDtoToEntity(UserDto userDto) {
        User user = new User();
//        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setAddr(userDto.getAddr());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return user;
    }
}
