package com.ISAproject.hospitalequipment.domain;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
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
    private int accumulatedPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loyalty_id")
    private LoyaltyProgram loyaltyProgram;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<Reservation>();


    public RegisteredUser(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address, int penaltyPoints,String username,int accumulatedPoints) {
        super(email, password, firstName, lastName, phoneNumber, occupation, enabled, address,username);
        this.penaltyPoints = penaltyPoints;
        this.accumulatedPoints = accumulatedPoints;
    }

    public RegisteredUser() {
        // Default constructor
    }
}

