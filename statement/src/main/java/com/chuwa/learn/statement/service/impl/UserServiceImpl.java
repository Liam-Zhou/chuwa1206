package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.UserRepository;
import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.exception.ResourceNotFoundException;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(user, UserDto.class);
    }
}
