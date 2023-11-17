package com.ISAproject.hospitalequipment.domain;

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
public class CompanyProfile {
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

    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CompanyAdministrator> administrators = new HashSet<CompanyAdministrator>();

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
