package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.ISAproject.hospitalequipment.domain.enums.UserRole;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotNull
    @Size(min=6, max=20)
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotEmpty
    private String occupation;

    private boolean enabled;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private  Address address;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


   // private String company;
   //private int penaltyPoints;
  // @Enumerated(EnumType.STRING)
  // private UserCategory userCategory;


    public User(Long id, String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.enabled = enabled;
        this.address = address;
    }


    public User() {

    }


}

