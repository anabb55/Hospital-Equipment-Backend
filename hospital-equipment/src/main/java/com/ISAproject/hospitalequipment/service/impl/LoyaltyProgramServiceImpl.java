package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.repository.LoyaltyProgramRepo;
import com.ISAproject.hospitalequipment.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    @Autowired
    LoyaltyProgramRepo loyaltyProgramRepo;


    @Override
    public List<LoyaltyProgram> findAll() {
        return loyaltyProgramRepo.findAll();
    }

    @Override
    public LoyaltyProgram update(LoyaltyProgram program) {
        LoyaltyProgram old = loyaltyProgramRepo.findById(program.getId()).get();
        old.setPointsPerEquipment(program.getPointsPerEquipment());
        old.setDiscountPercentage(program.getDiscountPercentage());
        return loyaltyProgramRepo.save(old);
    }

    @Override
    public LoyaltyProgram findById(Long id) {
        return loyaltyProgramRepo.findById(id).get();
    }
}
