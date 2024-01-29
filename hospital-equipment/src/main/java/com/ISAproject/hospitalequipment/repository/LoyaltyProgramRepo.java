package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyProgramRepo extends JpaRepository<LoyaltyProgram, Long> {

}

