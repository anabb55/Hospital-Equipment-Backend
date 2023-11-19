package com.ISAproject.hospitalequipment.domain;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "registeredUsers")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RegisteredUser extends User {


    private int penaltyPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loyalty_id")
    private LoyaltyProgram loyaltyProgram;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

   


    public RegisteredUser() {
        // Default constructor
    }
}

