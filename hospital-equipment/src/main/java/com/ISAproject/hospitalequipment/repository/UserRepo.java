package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    @Query("UPDATE User u SET u.firstName = :newUsername WHERE u.id = :userId")
    void updateUsername(@Param("userId") Long userId, @Param("newUsername") String newUsername);



}