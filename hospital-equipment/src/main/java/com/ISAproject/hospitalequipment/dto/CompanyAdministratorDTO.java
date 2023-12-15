package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;

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
