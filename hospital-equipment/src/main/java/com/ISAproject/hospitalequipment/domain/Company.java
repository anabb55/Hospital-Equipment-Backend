package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Company")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Company.class)
public class Company {
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




    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private WorkingTimeCalender workingTimeCalender;




    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CompanyAdministrator> administrators = new HashSet<CompanyAdministrator>();

    @JsonIgnore
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EquipmentStock> equipmentStocks;
    public Company(String name, String description, Address address, Double grade) {
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.address = address;
    }

    public Company() {

    }


}
