package com.example.redbook.service;

import com.example.redbook.payload.UserAccountDto;
import org.springframework.stereotype.Service;

public interface UserProfileService {
    public UserAccountDto getAccount(long userId);
}
