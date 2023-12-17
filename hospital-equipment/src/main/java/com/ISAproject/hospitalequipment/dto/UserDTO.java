package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String password;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String occupation;

    @JsonProperty
    private Address address;

    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName,String username, String lastName, String password, String email, String occupation, Address address, String phoneNumber){
        this.id= id;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.occupation = occupation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;

    }
}
