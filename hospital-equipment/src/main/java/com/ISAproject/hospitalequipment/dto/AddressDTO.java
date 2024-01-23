package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
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

    private Double longitude;
    private Double latitude;
   public AddressDTO(){}
  
    public AddressDTO(Long id, String country, String city, String street, String number,Double longitude, Double latitude) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public AddressDTO(Address address) {
        this.id=address.getId() ;
        this.city= address.getCity();
        this.country=address.getCountry();
        this.number=address.getNumber();
        this.street=address.getStreet();
        this.longitude=address.getLongitude();
        this.latitude=address.getLatitude();
    }




}

