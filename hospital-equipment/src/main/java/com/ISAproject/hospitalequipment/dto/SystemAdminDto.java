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

    public SystemAdminDto(SystemAdmin a){
        super(
                a.getId(),
                a.getEmail(),
                a.getPassword(),
                a.getFirstName(),
                a.getLastName(),
                a.getUsername(),
                a.getPhoneNumber(),
                a.getOccupation(),
                new AddressDTO(a.getAddress())
        );
    this.userCategory = a.getUserCategory();
    }


    public SystemAdminDto( UserCategory userCategory) {
        this.userCategory = userCategory;
    }
}
