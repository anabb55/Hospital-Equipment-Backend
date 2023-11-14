package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Addresses")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String number;


    public Address(String country, String city, String street, String number){
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address() {

    }
}
