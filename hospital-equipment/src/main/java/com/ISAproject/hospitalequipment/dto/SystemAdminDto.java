package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemAdminDto extends UserDTO{

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;


    public SystemAdminDto(){}


    public SystemAdminDto(SystemAdmin admin){
        super(
                admin.getId(),
                admin.getFirstname(),
                admin.getLastname(),
                admin.getUsername(),
                admin.getPassword(),
                admin.getEmail(),
                admin.getOccupation(),
                admin.getAddress(),
                admin.getPhoneNumber(),
                admin.getRoles()
        );
    this.userCategory = admin.getUserCategory();
    }


    public SystemAdminDto( UserCategory userCategory) {
        this.userCategory = userCategory;
    }
}
