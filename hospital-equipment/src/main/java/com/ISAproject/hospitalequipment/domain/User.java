package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.ISAproject.hospitalequipment.domain.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Getter @Setter
    private Long id;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Getter @Setter
    private String email;

    @NotNull
    @Size(min=6, max=20)
    @Getter @Setter
    private String password;

    @NotEmpty
    @Getter @Setter
    private String firstName;

    @NotEmpty
    @Getter @Setter
    private String lastName;

    @NotEmpty
    @Getter @Setter
    private String city;

    @NotEmpty
    @Getter @Setter
    private String country;

    @NotNull
    @Getter @Setter
    private String phoneNumber;

    @NotEmpty
    @Getter @Setter
    private String occupation;

    @NotEmpty
    @Getter @Setter
    private String company;

    @Getter @Setter
    private boolean activated;

    @Getter @Setter
    private int penaltyPoints;



    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private UserCategory userCategory;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private UserType userType;


    public User(Long id, String email, String password, String firstName, String lastName, String city, String country, String phoneNumber, String occupation, String company, boolean activated, int penaltyPoints, UserCategory userCategory, UserType userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.company = company;
        this.activated = activated;
        this.penaltyPoints = penaltyPoints;
        this.userCategory = userCategory;
        this.userType = userType;
    }

    public User() {

    }


}

