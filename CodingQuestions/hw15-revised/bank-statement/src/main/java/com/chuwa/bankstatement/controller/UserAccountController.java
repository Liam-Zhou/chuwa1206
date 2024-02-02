package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.UserAccountResponseDto;
import com.chuwa.bankstatement.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{userId}/account-details")
    public ResponseEntity<UserAccountResponseDto> getUserAccountDetails(@PathVariable Long userId) {
        UserAccountResponseDto userAccountDetails = userAccountService.getUserAccountDetails(userId);
        return ResponseEntity.ok(userAccountDetails);
    }

    @GetMapping("/range")
    public ResponseEntity<List<UserAccountResponseDto>> getUserAccountsInRange(
            @RequestParam("startId") Long startId,
            @RequestParam("endId") Long endId) {
        List<UserAccountResponseDto> userAccountResponseDtos = userAccountService.getUserAccountDetailsInRange(startId, endId);
        return new ResponseEntity<>(userAccountResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/date_range")
    public ResponseEntity<List<UserAccountResponseDto>> getUserAccountsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<UserAccountResponseDto> response = userAccountService.getUserAccountDetailsByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
