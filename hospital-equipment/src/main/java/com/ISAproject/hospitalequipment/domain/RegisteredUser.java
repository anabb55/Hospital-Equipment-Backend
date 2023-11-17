package com.ISAproject.hospitalequipment.domain;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "registeredUsers")
@Getter
@Setter
public class RegisteredUser extends User {


    private int penaltyPoints;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;



    public RegisteredUser() {
        // Default constructor
    }
}

