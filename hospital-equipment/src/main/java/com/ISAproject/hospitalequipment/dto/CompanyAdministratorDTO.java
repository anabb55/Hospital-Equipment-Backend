package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignoriše Hibernate specifične propertije
public class CompanyAdministratorDTO {

    private Long id;

    private Company company;
    public CompanyAdministratorDTO() {
    }

    public CompanyAdministratorDTO(CompanyAdministrator administrator) {
        this.id = administrator.getId();
        this.company = administrator.getCompany();
    }

    public CompanyAdministratorDTO(Long id, Company company) {
        this.id = id;
        this.company = company;
    }

}
