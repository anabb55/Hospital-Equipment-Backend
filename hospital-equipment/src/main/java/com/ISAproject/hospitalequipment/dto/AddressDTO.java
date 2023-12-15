package com.ISAproject.hospitalequipment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;

    public AddressDTO(Long id, String country, String city, String street, String number) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }
}
