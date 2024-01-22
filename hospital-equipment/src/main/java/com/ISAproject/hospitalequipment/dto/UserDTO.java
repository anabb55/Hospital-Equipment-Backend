package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.User;
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

    private AddressDTO address;

    private String phoneNumber;

    public UserDTO() {
    }



    public UserDTO(Long id, String email, String password,String firstname, String lastname,  String username,String phoneNumber, String occupation,  AddressDTO address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;

    }

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.username = user.getUsername();
        this.phoneNumber = user.getLastName();
        this.occupation = user.getOccupation();
        this.address = new AddressDTO(user.getAddress());
    }



}
