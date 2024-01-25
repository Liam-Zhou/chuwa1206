package com.example.bankstatement.controller;

import com.example.bankstatement.entity.Account;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/users/{userId}/accounts")
    public ResponseEntity<AccountDto> createAccount(@PathVariable(value="userId") Long userId,  @RequestBody AccountDto accountDto){
        AccountDto response = accountService.createAccount(userId, accountDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}/accounts")
    public ResponseEntity<List<AccountDtoWithoutUserProfile>> getAccountByUserId(@PathVariable(value = "userId") Long userId){
        return new ResponseEntity<>(accountService.getAccountByUserId(userId),HttpStatus.OK);
    }

    /**
     * try with cookie
     * @param userId    to verify if have Authorization
     * @param accountId
     * @return
     */
    @GetMapping("/users/{userId}/accounts/{accountId}")
    public ResponseEntity<AccountDto> getAccountByUserIdByAccountId(@PathVariable(value = "userId") Long userId,
                                                                    @PathVariable(value = "accountId") Long accountId){
        AccountDto response = accountService.getAccountByUserIdByAccountId(userId, accountId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/accounts/{accountId}")
    public ResponseEntity<AccountDtoWithoutUserProfile> updateAccountByUserIdAccountId(@PathVariable(value = "userId") Long userId,
                                                                                       @PathVariable(value = "accountId") Long accountId,
                                                                                       @RequestBody AccountDtoWithoutUserProfile accountDto){
        return new ResponseEntity<>(accountService.updateAccountByUserIdAccountId(userId, accountId, accountDto),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAccountByUserIdAccountId(@PathVariable(value = "userId") Long userId,
                                                                 @PathVariable(value = "accountId") Long accountId){
        accountService.deleteAccountByUserIdAccountId(userId, accountId);
        return new ResponseEntity<>("The account deleted successfully.",HttpStatus.OK);
    }


}
