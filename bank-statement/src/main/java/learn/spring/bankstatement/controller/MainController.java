package learn.spring.bankstatement.controller;

import jakarta.validation.Valid;
import learn.spring.bankstatement.payload.UserDto;
import learn.spring.bankstatement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<UserDto> createPost(@Valid @RequestBody UserDto userDto){ // indicate that a method parameter should be bound to the body of the HTTP request
        UserDto response = this.userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
