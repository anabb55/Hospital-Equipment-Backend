package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Role;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterUserDTO extends UserDTO{
    private int penaltyPoints;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;


    private LoyaltyProgramDTO loyaltyProgram;


    public RegisterUserDTO(RegisteredUser registeredUser) {
        super(
                registeredUser.getId(),
                registeredUser.getFirstname(),
                registeredUser.getLastname(),
                registeredUser.getUsername(),
                registeredUser.getPassword(),
                registeredUser.getEmail(),
                registeredUser.getOccupation(),
                registeredUser.getAddress(),
                registeredUser.getPhoneNumber()
        );
        this.penaltyPoints = registeredUser.getPenaltyPoints();
        this.userCategory = registeredUser.getUserCategory();
        this.loyaltyProgram=new LoyaltyProgramDTO(registeredUser.getLoyaltyProgram());

    }

    public RegisterUserDTO(){
    }
}
