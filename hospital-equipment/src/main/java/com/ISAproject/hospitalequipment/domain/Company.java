package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Company")
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

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime workStartTime;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime workEndTime;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CompanyAdministrator> administrators = new HashSet<CompanyAdministrator>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EquipmentStock> equipmentStocks = new HashSet<EquipmentStock>();

    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();

    public Company(String name, String description, Address address, Double grade, LocalTime workStartTime, LocalTime workEndTime) {
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.address = address;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }

    public Company() {
    }
}




