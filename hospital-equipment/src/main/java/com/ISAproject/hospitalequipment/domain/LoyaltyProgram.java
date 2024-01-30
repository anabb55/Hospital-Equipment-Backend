package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "loyaltyProgram")
@Getter
@Setter
public class LoyaltyProgram {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pointsPerEquipment;
    private int penaltyThreshold;
    private int discountPercentage;

    @OneToMany(mappedBy = "loyaltyProgram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RegisteredUser> registeredUsers = new HashSet<RegisteredUser>();

    public LoyaltyProgram(int pointsPerEquipment, int penaltyThreshold, int discountPercentage) {
        this.pointsPerEquipment = pointsPerEquipment;
        this.penaltyThreshold = penaltyThreshold;
        this.discountPercentage = discountPercentage;
    }

    public LoyaltyProgram(LoyaltyProgram loyaltyProgram){
        this.pointsPerEquipment = loyaltyProgram.getPointsPerEquipment();
        this.discountPercentage = loyaltyProgram.getDiscountPercentage();
        this.id = loyaltyProgram.getId();
        this.penaltyThreshold = loyaltyProgram.getPenaltyThreshold();
    }


    public LoyaltyProgram() {

    }
}
