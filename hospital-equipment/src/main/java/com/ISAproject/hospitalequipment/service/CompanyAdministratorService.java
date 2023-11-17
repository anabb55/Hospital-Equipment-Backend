package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;

import java.util.List;

public interface CompanyAdministratorService {
    public List<CompanyAdministrator> findAll();
    public CompanyAdministrator save(CompanyAdministrator admin);

    public List<CompanyAdministrator> findByCompany(CompanyProfile company);
}
