package com.chuwa.statement.service.impl;

import com.chuwa.statement.dao.UserRepository;
import com.chuwa.statement.entity.User;
import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.UserDto;
import com.chuwa.statement.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserDto> lst=userRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
        return lst;
    }

    @Override
    public UserDto findUserById(long id) {
        UserDto userDto=userRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return userDto;
    }

    private UserDto mapToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    private User mapToEntity(UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getAddress(),
                userDto.getPhone(),
                userDto.getEmail()
        );
    }
}
