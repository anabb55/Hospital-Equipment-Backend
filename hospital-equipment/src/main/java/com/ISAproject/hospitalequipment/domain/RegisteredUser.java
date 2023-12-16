package com.ISAproject.hospitalequipment.domain;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<Reservation>();



    public RegisteredUser() {
        // Default constructor
    }
}

