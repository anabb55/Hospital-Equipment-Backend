package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO extends UserDTO{
    private int penaltyPoints;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    public RegisterUserDTO(int penaltyPoints, UserCategory userCategory) {
        this.penaltyPoints = penaltyPoints;
        this.userCategory = userCategory;
    }

    public RegisterUserDTO() {
    }
}
