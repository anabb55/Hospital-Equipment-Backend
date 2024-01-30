package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;

import java.util.List;

public interface LoyaltyProgramService {
    public List<LoyaltyProgram> findAll();

    public LoyaltyProgram update(LoyaltyProgram loyaltyProgram);
    public LoyaltyProgram findById(Long id);
}
