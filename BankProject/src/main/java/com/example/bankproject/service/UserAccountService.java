package com.example.bankproject.service;


import com.example.bankproject.payload.UserAccountResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface UserAccountService {

    public UserAccountResponseDto getUserAccountDetails(Long userId);

    List<UserAccountResponseDto> getUserAccountDetailsInRange(Long startId, Long endId);

    List<UserAccountResponseDto> getUserAccountDetailsByDateRange(LocalDate startDate, LocalDate endDate);
}
