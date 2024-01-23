package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.UserRepository;
import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToEntity(userDto);
        userRepository.save(user);
        return  entityToDto(user);
    }


    @Override
    public UserDto getUserById(long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return  entityToDto(user);
    }

    private UserDto entityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setAddr(user.getAddr());
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setPhone(user.getPhone());
        userDto.setName(user.getName());
        return userDto;
    }

    private User dtoToEntity(UserDto userDto){
        User user = new User();
        user.setAddr(userDto.getAddr());
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setPhone(userDto.getPhone());
        user.setName(userDto.getName());
        return user;
    }
}
