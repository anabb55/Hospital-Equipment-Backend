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


}
