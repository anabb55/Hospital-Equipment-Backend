package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoyaltyProgramDTO {
    private Long id;
    private int pointsPerEquipment;
    private int penaltyThreshold;
    private int discountPercentage;


    public LoyaltyProgramDTO() {
    }

    public LoyaltyProgramDTO(Long id, int pointsPerEquipment, int penaltyThreshold, int discountPercentage) {
        this.id = id;
        this.pointsPerEquipment = pointsPerEquipment;
        this.penaltyThreshold = penaltyThreshold;
        this.discountPercentage = discountPercentage;
    }

    public LoyaltyProgramDTO(LoyaltyProgram loyalty){
        this.id=loyalty.getId();
        this.pointsPerEquipment=loyalty.getPointsPerEquipment();
        this.penaltyThreshold=loyalty.getPenaltyThreshold();
        this.discountPercentage=loyalty.getDiscountPercentage();

    }
}
