package com.chuwa.transaction.dao;

import com.chuwa.transaction.entity.UserProfile;
import com.chuwa.transaction.payload.UserProfileDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
