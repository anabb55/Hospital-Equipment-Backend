package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompanyDTO {
    private Long id;
    private String name;
    private AddressDTO address;
    private String description;
    private Double grade;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime workStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime workEndTime;



    public CompanyDTO() {
    }


    public CompanyDTO(Company company) {

        this(company.getId(),company.getName(),new AddressDTO(company.getAddress()),company.getDescription(),company.getGrade(),company.getWorkStartTime(),company.getWorkEndTime());
    }

    public CompanyDTO(Long id, String name, AddressDTO address, String description, Double grade, LocalTime workStartTime, LocalTime workEndTime) {
        this.id = id;
        this.name = name;
        this.address =address;
        this.description = description;
        this.grade = grade;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }


}