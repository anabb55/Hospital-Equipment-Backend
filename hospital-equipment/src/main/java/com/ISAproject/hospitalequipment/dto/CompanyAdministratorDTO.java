package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CompanyAdministratorDTO {

    private Long id;

    private CompanyDTO company;
    public CompanyAdministratorDTO() {
    }

    public CompanyAdministratorDTO(CompanyAdministrator administrator) {
        this.id = administrator.getId();
        this.company = new CompanyDTO(administrator.getCompany());
    }

    public CompanyAdministratorDTO(Long id, Company company) {
        this.id = id;
        this.company = new CompanyDTO(company);
    }

}
