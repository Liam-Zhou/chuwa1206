package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.StatementDto;
import com.chuwa.bankstatement.payload.UserDto;
import com.chuwa.bankstatement.service.UserService;
import com.chuwa.bankstatement.validationgroup.Create;
import com.chuwa.bankstatement.validationgroup.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Validated(Create.class) @RequestBody UserDto userDto) {
        UserDto response = userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> response = userService.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") Long userId,
                                              @Validated(Update.class) @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted User Successfully", HttpStatus.OK);
    }

    @GetMapping("/statements")
    public ResponseEntity<List<StatementDto>> getStatements(@RequestParam(name = "user-id") Long userId,
                                                            @RequestParam(name = "year") Year year,
                                                            @RequestParam(name = "month") Month month) {
        List<StatementDto> response = userService.generateStatement(userId, year, month);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
