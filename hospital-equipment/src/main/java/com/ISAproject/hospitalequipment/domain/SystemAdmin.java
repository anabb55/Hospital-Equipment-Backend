package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "systemAdmins")
@Getter
@Setter
public class SystemAdmin extends User {

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    SystemAdmin(Long id, String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address,UserCategory userCategory){
        super(email, password, firstName, lastName, phoneNumber, occupation, enabled, address);
        this.userCategory = userCategory;
    }
    SystemAdmin(Long id, String email, String password, String firstName, String lastName, String phoneNumber, String occupation, Address address,UserCategory userCategory){
        super(email, password, firstName, lastName, phoneNumber, occupation,  address);
        this.userCategory = userCategory;
    }
    public SystemAdmin(){}
}
