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

    private String email;

    private String occupation;

    @JsonProperty
    private Address address;

    private String phoneNumber;
}
