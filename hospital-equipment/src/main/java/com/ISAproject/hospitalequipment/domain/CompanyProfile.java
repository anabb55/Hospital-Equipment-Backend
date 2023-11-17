package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="CompanyProfiles")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompanyProfile {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private Address address;

    @NotNull
    private String description;

    @NotNull
    private Double grade;

/*
    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();
*/

    @ManyToMany(mappedBy = "company", fetch=FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<Equipment> equipment = new HashSet<Equipment>();


    public CompanyProfile(Long id,String name, String description,Address address, Double grade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.address = address;
    }

    public CompanyProfile() {

    }


}
