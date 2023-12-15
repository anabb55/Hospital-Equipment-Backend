package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignoriše Hibernate specifične propertije
public class CompanyDTO {
    private Long id;
    private String name;
    private Address address;
    private String description;
    private Double grade;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime workStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime workEndTime;

    private Set<CompanyAdministrator> administrators;

    public CompanyDTO(Company company) {
        this(company.getId(),company.getName(),company.getAddress(),company.getDescription(),company.getGrade(),company.getWorkStartTime(),company.getWorkEndTime(),company.getAdministrators());



    }

    public CompanyDTO(Long id, String name, Address address, String description, Double grade, LocalTime workStartTime, LocalTime workEndTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.grade = grade;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }

    public CompanyDTO(Long id, String name, Address address, String description, Double grade, LocalTime workStartTime, LocalTime workEndTime, Set<CompanyAdministrator> administrators) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.grade = grade;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.administrators=administrators;
    }
}