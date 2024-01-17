package com.chuwa.BankStatement.service;

import com.chuwa.BankStatement.dao.AccountRepository;
import com.chuwa.BankStatement.dao.UserRepository;
import com.chuwa.BankStatement.entity.Account;
import com.chuwa.BankStatement.entity.User;
import com.chuwa.BankStatement.payload.UserDto;
import com.chuwa.BankStatement.utils.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public UserDto postUser(UserDto userDto){

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);

        // automatically create account
        Account account = new Account();
        account.setUser(entityManager.getReference(User.class, savedUser.getId())); // try to use entiry manager
        account.setAccountNumber(savedUser.getName() + "_default_acc_num");
        account.setRoutingNumber(String.valueOf(10000000 + new Random().nextInt(90000000))); //generate an 8 digit number
        Account savedAccount = accountRepository.save(account);

        // add this account to savedUser
        long savedUserId = savedUser.getId();
        savedUser = userRepository.findById(savedUserId).orElseThrow(() -> new ResourceNotFoundException("User", "id", savedUserId));
        savedUser.setAccount(account);
        savedUser = userRepository.save(savedUser);


        return modelMapper.map(savedUser, UserDto.class);
    }


}
