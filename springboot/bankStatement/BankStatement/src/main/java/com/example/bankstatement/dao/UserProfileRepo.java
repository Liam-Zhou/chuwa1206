package com.example.bankstatement.dao;

import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex D.
 */
@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
}
