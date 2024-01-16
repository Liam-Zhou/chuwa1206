package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.payload.UserDto;
import com.chuwa.bankstatement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto response = userService.createUser(userDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id){
        UserDto response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/account/{id}")
//    public ResponseEntity<List<Account>> getAccountsByUser(@PathVariable(name = "id") long id){
//        List<Account> response = userService.getAccountsByUser(id);
//        return ResponseEntity.ok(response);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody UserDto userDto,@PathVariable(name = "id") long id){
        UserDto response = userService.updateUser(userDto,id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable(name = "id") long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
