package com.chuwa.bankstatement.repository;

import com.chuwa.bankstatement.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByIdBetween(Long startId, Long endId);
}