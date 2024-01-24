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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotEmpty
    private String username;


    @NotNull
    @Size(min=6, max=20)
    private String password;

    @NotEmpty
    private String firstname;

    @NotEmpty

    private String lastname;

    @NotNull
    private String phoneNumber;

    @NotEmpty
    private String occupation;

    @Getter
    @Setter
    private boolean enabled;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private  Address address;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


    private boolean waslogged;


    public User(Long id, String email, String password, String userName, String  firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address, String companyName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.enabled = enabled;
        this.address = address;
        this.username = userName;
        this.waslogged=false;

    }


    public User() {

    }


    public User(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address,String username) {
        this.email = email;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.enabled = enabled;
        this.address = address;
        this.waslogged=false;
        this.username = username;
    }


    public User(String email, String password, String firstName, String lastName, String phoneNumber, String occupation,  Address address,String username) {
        this.email = email;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
        this.waslogged=false;
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}




