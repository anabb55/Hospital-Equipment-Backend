package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {



}