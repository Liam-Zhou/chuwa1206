package com.chuwa.bankstatement.dao;

import com.chuwa.bankstatement.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiaorui
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
