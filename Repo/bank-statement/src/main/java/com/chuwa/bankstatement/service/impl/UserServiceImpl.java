package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.dao.UserRepository;
import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.User;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.payload.UserDto;
import com.chuwa.bankstatement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
//    private AccountRepository accountRepository;

//    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
//        this.userRepository = userRepository;
//        this.accountRepository = accountRepository;
//    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User toBeSaved = convertDtoToEntity(userDto);
        User saved = userRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    private static UserDto convertEntityToDto(User saved) {
        UserDto response = new UserDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setAddr(saved.getAddr());
        response.setEmail(saved.getEmail());
        response.setPhone(saved.getPhone());
        return response;
    }

    private static User convertDtoToEntity(UserDto userDto) {
        User toBeSaved = new User();
        toBeSaved.setName(userDto.getName());
        toBeSaved.setAddr(userDto.getAddr());
        toBeSaved.setEmail(userDto.getEmail());
        toBeSaved.setPhone(userDto.getPhone());
        return toBeSaved;
    }

    @Override
    public UserDto getUserById(long id) {
        User response = userRepository.findById(id).orElseThrow(()->new RuntimeException("User does not exist"));
        return convertEntityToDto(response);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> response = userRepository.findAll().stream().map(user -> convertEntityToDto(user)).collect(Collectors.toList());
        return response;
    }

//    @Override
//    public List<Account> getAccountsByUser(long id) {
//        List<Account> accounts= accountRepository.findByUserId(id);
//        return accounts;
//    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User toBeSaved = userRepository.findById(id).orElseThrow(()->new RuntimeException("User does not exist"));
        toBeSaved.setName(userDto.getName());
        toBeSaved.setAddr(userDto.getAddr());
        toBeSaved.setEmail(userDto.getEmail());
        toBeSaved.setPhone(userDto.getPhone());
        User saved = userRepository.save(toBeSaved);
        return convertEntityToDto(saved);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
