package com.ISAproject.hospitalequipment.domain;

public class LoyaltyProgram {
    private int pointsPerEquipment;
    private int penaltyThreshold;
    private int discountPercentage;

    public LoyaltyProgram(int pointsPerEquipment, int penaltyThreshold, int discountPercentage) {
        this.pointsPerEquipment = pointsPerEquipment;
        this.penaltyThreshold = penaltyThreshold;
        this.discountPercentage = discountPercentage;
    }


    public int getPointsPerEquipment() {
        return pointsPerEquipment;
    }

    public void setPointsPerEquipment(int pointsPerEquipment) {
        this.pointsPerEquipment = pointsPerEquipment;
    }

    public int getPenaltyThreshold() {
        return penaltyThreshold;
    }

    public void setPenaltyThreshold(int penaltyThreshold) {
        this.penaltyThreshold = penaltyThreshold;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

}
