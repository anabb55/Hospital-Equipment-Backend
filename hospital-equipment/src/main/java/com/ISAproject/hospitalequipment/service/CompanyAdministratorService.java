package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;

import java.util.List;

public interface CompanyAdministratorService {
    public List<CompanyAdministrator> findAll();
    public CompanyAdministrator save(CompanyAdministrator admin);

    public CompanyAdministrator getById(Long id);

    public CompanyAdministrator update(CompanyAdministrator admin, Long id);
}
