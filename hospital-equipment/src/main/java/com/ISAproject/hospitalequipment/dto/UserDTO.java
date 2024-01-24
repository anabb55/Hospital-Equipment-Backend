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

    private boolean waslogged;
    public UserDTO() {
    }

    public UserDTO(Long id, String firstname, String lastname,String username,String password, String email, String occupation, Address address, String phoneNumber){

        this.id= id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.occupation = occupation;
        this.address = new AddressDTO(address);
        this.phoneNumber = phoneNumber;
        this.waslogged=false;

    }

    public UserDTO(Long id, String email, String password, String username,String firstname, String lastname, String phoneNumber, String occupation, boolean enabled, AddressDTO address, String companyName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
        this.waslogged=false;
    }





    public UserDTO(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, AddressDTO address,String username) {
        this.email = email;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.occupation = occupation;
        this.address = address;
        this.waslogged=false;
    }


    public UserDTO(String email, String password,String userName, String firstName, String lastName, String phoneNumber, String occupation,  AddressDTO address) {
        this.email = email;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
        this.waslogged=false;
    }
    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.username = user.getUsername();
        this.phoneNumber = user.getPhoneNumber();
        this.occupation = user.getOccupation();
        this.address = new AddressDTO(user.getAddress());
        this.waslogged=false;
    }



}
