package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoyaltyProgramRepo extends JpaRepository<LoyaltyProgram, Long> {

    @Override
    List<LoyaltyProgram> findAll();

    @Override
    LoyaltyProgram save(LoyaltyProgram loyaltyProgram);
}

